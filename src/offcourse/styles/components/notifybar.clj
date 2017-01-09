(ns offcourse.styles.components.notifybar
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden
              [arithmetic :refer [*]]
              [units :as u :refer [percent]]
              [selectors :as s]]
            [offcourse.styles.vocabulary :as v]))

(defn notifybar [{:keys [templates colors units]}]
  [[:.notifybar              (merge (:row-component        templates)
                                    {:flex                 1
                                     :align-items          :center
                                     :justify-content      :space-between
                                     :background          (:dark colors)
                                     :color               (:day colors)})
     [(v/attr :data-notify-color :yellow)
      (merge                        {:background          (:yellow colors)
                                     :color               (:night colors)})]
     [(v/attr :data-notify-color :blue)
      (merge                        {:background          (:blue colors)})]
     [(v/attr :data-notify-color :red)
      (merge                        {:background          (:red colors)})]]
   [:.notifybar--section     (merge (:row-component        templates)
                                    {:padding            [[0 (:full units)]]})]

   [:.notifybar--subtitle    (merge (:subtitle             templates))]
   [:.notifybar--text        (merge (:text                 templates))]
   [:.notifybar--link        (merge (:text                 templates)
                                    {:margin-left         (:third units)
                                     :cursor               :pointer})
    [v/hovered               (merge {:border-bottom      [["1px" "solid" (:night colors)]]
                                     :margin-bottom        "-1px"})]
    [(v/attr :data-link-type :strong)
     (merge                         (:subtitle             templates)
                                    {:color               (:day colors)})
     [v/hovered              (merge {:border-bottom      [["1px" "solid" (:day colors)]]
                                     :margin-bottom        "-1px"})]]]])
