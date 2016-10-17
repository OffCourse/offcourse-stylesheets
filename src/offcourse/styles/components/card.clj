(ns offcourse.styles.components.card
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn card [{:keys [templates breakpoints colors units]}]
  [[v/card                      (merge  (:column-component    templates)
                                        (:sheet               templates)
                                        {:justify-content     :space-between
                                         :width              (:column units)
                                         :flex                1})
    [v/hovered                          (:border-highlighted  templates)]]

   [v/card--section             (merge  (:component           templates)
                                        (:border-thin         templates)
                                        {:position            :relative
                                         :padding            (:two-third units)})
    [v/first                            {:padding-top        (:two-third units)
                                         :padding-bottom     (:two-third units)}]]
   [:.card--dropdown            (merge  (:column-component    templates))]

   [v/card--title               (merge  (:title               templates))]
   [v/card--actions             (merge  (:row-component       templates))]

   ; Media-queries
   (let [{:keys [min-width max-width percent]} (first breakpoints)]
     (at-media {:min-width min-width :max-width max-width}
               [[v/card                 {:width               "100%"}
                 [v/hovered
                  [:.card--dropdown     {:max-height         (* 20 (:full units))
                                         :transition          "all 0.5s ease 0.5s"}]]
                 [v/activated
                  [:.card--dropdown     {:max-height         (* 20 (:full units))
                                         :transition          "all 0.5s ease 0.5s"}]]]
                [v/card--title  (merge  {:pointer-events      :none
                                         :cursor              :default})]
                [:.card--dropdown       {:max-height          0
                                         :overflow            :hidden
                                         :transition          "all 0.5s ease"}]]))])
