(ns offcourse.styles.components.menubar
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden.arithmetic :refer [*]]
            [garden.units :as u :refer [percent]]
            [offcourse.styles.vocabulary :as v]))

(defn menubar [{:keys [templates colors units]}]
  [[v/menubar             (merge (:row-component        templates)
                                 {:flex                 1
                                  :justify-content      :space-between
                                  :padding            [[0 (:full units) 0 0]]
                                  :background          (:day colors)})]
   [v/menubar--section           {:display              :flex
                                  :align-items          :stretch}]

   [v/menubar--logo       (merge (:textbar              templates)
                                 {:justify-content      :center
                                  :padding            [[0 (:full units)]]
                                  :cursor               :pointer})
    [v/hovered                   (:paper                templates)]]

   [:.actions-panel              (:row-component        templates)]
   [:.actions-panel--item (merge (:row-component        templates)
                                 {:padding-left        (:full units)
                                  :align-items          :center})]

   [:.actions-panel--link            (merge (:subtitle             templates)
                                            {:cursor               :pointer})
    [v/hovered                       (merge {:border-bottom     [["1px" "solid" (:night colors)]]
                                             :margin-bottom       "-1px"})]]

   [:.action-panel--search-container (merge (:row-component    templates)
                                            {:cursor           :pointer})
    [v/hovered v/activated           (merge {:border-bottom  [["1px" "solid" (:night colors)]]})]]
   [:.actions-panel--search          (merge (:subtitle             templates)
                                            {:margin-right        (:full units)})]
   [:.actions-panel--search-btn      (merge (:subtitle             templates))]])
