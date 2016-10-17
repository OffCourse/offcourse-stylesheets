(ns offcourse.styles.components.card
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]
             [selectors :as s]]
            [offcourse.styles.vocabulary :as v]))

(defn card [{:keys [templates breakpoints colors units]}]
  [[:.card                      (merge  (:column-component    templates)
                                        (:sheet               templates)
                                        {:justify-content     :space-between
                                         :width              (:column units)})
    [v/hovered                          (:border-highlighted  templates)]]

   [(s/& :.card (s/attr :data-card-type := :wide))
    {:width (:max-content-width units)}]

   [:.card--section             (merge  (:component           templates)
                                        (:border-thin         templates)
                                        {:position            :relative
                                         :padding            (:two-third units)})
     [v/first                           {:padding-top        (:two-third units)
                                         :padding-bottom     (:two-third units)}]]
   [:.card--dropdown            (merge  (:column-component    templates))]

   ; typography
   [:.card--title               (merge  (:title               templates))]
   [:.card--subtitle            (merge  (:subtitle            templates))]
   [:.card--text                (merge  (:text                templates))]
   [:.card--link                (merge  (:subtitle            templates)
                                        {:text-decoration     :underline})]
   [:.card--link-em             (merge  (:text                templates)
                                        {:text-decoration     :underline
                                         :color              (:primary colors)})]
   [:.card--error               (merge  (:text               templates)
                                        {:padding         [[ 0 (:half units) (:third units)]]
                                         :color             (:red colors)})]

   ; form (could be component)
   [:.card--field               (merge  (:title               templates)
                                        {:margin-top         (:third units)
                                         :padding          [[(:third units)(:two-third units)]]
                                         :background         (:light colors)})]
   [:.card--field-small         (merge  (:title               templates)
                                        {:min-width           "50%"
                                         :max-width           "50%"
                                         :margin-top         (:third units)
                                         :padding          [[(:third units)(:two-third units)]]
                                         :background         (:light colors)})]
   [(s/& :.card--field-small (s/nth-child "2n-1")) {:border-right [[(:sixth units) :solid (:day colors)]]}]
   [(s/& :.card--field-small (s/nth-child "2n")) {:border-left  [[(:sixth units) :solid (:day colors)]]}]

   ; Utils
   [:.card--padder              (merge  {:padding-top        (:two-third units)})]
   [:.card--indenter            (merge  {:padding-left       (:two-third units)})]
   [:.card--row                 (merge  (:row-component       templates))]
   [:.card--row-between         (merge  (:row-component       templates)
                                        {:justify-content     :space-between})]
   [:.card--row-wrap            (merge  (:row-component       templates)
                                        {:justify-content     :flex-start
                                         :flex-wrap           :wrap})]
   [:.card--v-center            (merge  (:row-component       templates)
                                        {:align-items         :center})]

   (let [{:keys [min-width max-width percent]} (first breakpoints)]
     (at-media {:min-width min-width :max-width max-width}
       [[:.card                         {:width               "100%"}
         [v/hovered v/activated
          [:.card--dropdown             {:max-height         (* 20 (:full units))
                                         :transition          "all 0.5s ease 0.5s"}]]]
        [:.card--dropdown               {:max-height          0
                                         :overflow            :hidden
                                         :transition          "all 0.5s ease"}]
        [:.card--title          (merge  {:pointer-events      :none
                                         :cursor              :default})]]))])
