(ns offcourse.styles.components.button
  (:require [offcourse.styles.vocabulary :as v]
            [garden
             [arithmetic :refer [* +]]
             [selectors :as s]]))

(defn button [{:keys [templates colors units fonts]}]
  [[v/textbar-button        (merge (:row-component      templates)
                                   (:subtitle           templates)
                                   {:width             (* 10 (:full units))
                                    :justify-content    :center
                                    :align-items        :center
                                    :padding         [[(:third units) (:two-third units)]]
                                    :background        (:dark colors)
                                    :color             (:day colors)
                                    :border-bottom   [[(:atom units) :solid (:night colors)]]
                                    :cursor             :pointer})
    [v/hovered              (merge {:color             (:night colors)})]]

   [(s/& :.button (s/attr :data-button-color := :blue))
    {:background (:blue colors)}]
   [(s/& :.button (s/attr :data-button-color := :red))
    {:background (:red colors)}]
   [(s/& :.button (s/attr :data-button-color := :twitter))
    {:background (:twitter colors)}]
   [(s/& :.button (s/attr :data-button-color := :linkedin))
    {:background (:linkedin colors)}]
   [(s/& :.button (s/attr :data-button-color := :github))
    {:color      (:dark   colors)
     :background (:github colors)}]

   [(s/+ v/textbar-button
         v/textbar-button)
    {:margin-left     (:sixth units)}]

   [v/checkbox-button       (merge (:component        templates)
                                   (:paper            templates)
                                   {:display          :flex
                                    :margin-right     (:two-third units)
                                    :width            (:two-third units)
                                    :height           (:two-third units)})
    [v/selected                    {:background-color (:primary colors)}]
    [v/disabled                    {:background-color (:medium colors)}]]])
