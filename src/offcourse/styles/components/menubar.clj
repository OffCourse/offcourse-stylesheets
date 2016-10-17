(ns offcourse.styles.components.menubar
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden.arithmetic :refer [*]]
            [garden.units :as u :refer [percent]]
            [offcourse.styles.vocabulary :as v]))

(defn menubar [{:keys [templates colors units]}]
  [[v/menubar             (merge (:row-component        templates)
                                 {:border-bottom      [["1px" :solid (:light colors)]]
                                  :justify-content      :space-between
                                  :flex                 1
                                  :background          (:day colors)
                                  :padding            [[0 (:full units) 0 0]]})]
   [v/menubar--section           {:display              :flex
                                  :align-items          :stretch}]

   [v/menubar--logo       (merge (:textbar              templates)
                                 {:justify-content      :center
                                  :padding            [[0 (:full units)]]
                                  :cursor               :pointer})
    [v/hovered                   (:paper                templates)]]
   [:.menubar--link       (merge (:text                 templates)
                                 {:margin             [[0 (:one-and-half units) 0 0]]})
    [v/hovered            (merge (:border-thin          templates)
                                 (:border-highlighted   templates)
                                 {:color               (:primary colors)
                                  :cursor               :pointer})]]

   [:.actions-panel              (:row-component        templates)]
   [:.actions-panel--link (merge (:subtitle             templates)
                                 (:row-component        templates)
                                 {:align-items          :center
                                  :cursor               :pointer})
    [v/hovered                   {:text-decoration      :underline}]]])
