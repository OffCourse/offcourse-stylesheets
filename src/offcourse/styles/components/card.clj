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
    [v/first                            {:padding-top        (:two-third units)
                                         :padding-bottom     (:two-third units)}]]
   [:.card--dropdown            (merge  (:column-component    templates))]

   [:.card--title               (merge  (:title               templates))]
   [:.card--text                (merge  (:text                templates))]
   [:.card--link                (merge  (:text                templates)
                                        {:text-decoration     :underline})]
   [:.card--link-em             (merge  (:text                templates)
                                        {:text-decoration     :underline
                                         :color              (:primary colors)})]

   [:.card--padder              (merge  {:padding-top        (:two-third units)})]
   [:.card--indenter            (merge  {:padding-left       (:two-third units)})]
   [:.card--field               (merge  (:title               templates)
                                        {:margin-top         (:two-third units)
                                         :padding          [[(:third units)(:two-third units)]]
                                         :background         (:light colors)})]
   [:.card--row                 (merge  (:row-component       templates))]
   [:.card--row-between         (merge  (:row-component       templates)
                                        {:justify-content     :space-between})]
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
