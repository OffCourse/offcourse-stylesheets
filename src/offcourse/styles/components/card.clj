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
    [v/hovered                          (:border-highlighted  templates)]
    [(s/& (s/attr= :data-card-type :medium))
     {:width (* 20 (:full units))}]
    [(s/& (s/attr= :data-card-type :wide))
     {:width (:max-content-width units)}]]
   [:.card--section             (merge  (:component           templates)
                                        (:border-thin         templates)
                                        {:position            :relative
                                         :padding            (:two-third units)})]
   [:.card--wrapper             (merge  (:column-component    templates))]

   ; typography
   [:.card--title               (merge  (:title               templates))
    [(s/& (s/attr= :data-title-type :disabled))
     {:color              (:medium colors)}]
    [(s/& (s/attr :data-title-indent))
     {:padding-left       (:two-third units)}]]
   [:.card--subtitle            (merge  (:subtitle            templates))]
   [:.card--text                (merge  (:text                templates))
    [(s/& (s/attr :data-text-indent))
     {:padding-left       (:two-third units)}]]
   [:.card--link                (merge  (:text                templates)
                                        {:text-decoration     :underline})
    [(s/& (s/attr= :data-link-type :strong))
     (:subtitle            templates)]
    [(s/& (s/attr= :data-link-type :em))
     {:color              (:primary colors)}]]
   [:.card--error               (merge  (:text               templates)
                                        {:padding         [[ 0 (:half units) (:third units)]]
                                         :color             (:red colors)})]

   ; Utils
   [:.card--row                 (merge  (:row-component       templates)
                                        {:align-items         :center})
    [(s/& (s/attr :data-top-padded))
     {:padding-top        (:two-third units)}]
    [(s/& (s/attr :data-space-between))
     {:justify-content     :space-between}]
    [(s/& (s/attr :data-wrap))
     {:justify-content     :flex-start
      :flex-wrap           :wrap}]]

   (let [{:keys [min-width max-width percent]} (first breakpoints)]
     (at-media {:min-width min-width :max-width max-width}
       [[:.card                         {:width               "100%"}
         [v/hovered v/activated
          [:.card--wrapper              {:max-height         (* 20 (:full units))
                                         :transition          "all 0.5s ease 0.5s"}]]]
        [:.card--wrapper                {:max-height          0
                                         :overflow            :hidden
                                         :transition          "all 0.5s ease"}]
        [:.card--title          (merge  {:pointer-events      :none
                                         :cursor              :default})]]))])
