(ns offcourse.styles.components.button
  (:require [offcourse.styles.vocabulary :as v]
            [garden
             [selectors :as s]]))

(defn button [{:keys [templates colors units fonts]}]
  [[v/textbar-button        (merge (:row-component      templates)
                                   (:subtitle           templates)
                                   {:justify-content    :center
                                    :align-items        :center
                                    :padding         [[(:third units) (:two-third units)]]
                                    :background        (:dark colors)
                                    :color             (:day colors)
                                    :border-bottom   [[(:atom units) :solid (:night colors)]]
                                    :cursor             :pointer})
    [v/hovered              (merge (:paper              templates))]]

   [(s/& v/textbar-button (s/attr :data-button-color := :blue))
    {:background (:blue colors)}
    [v/hovered                     {:background        (:day colors)}]]
   [(s/& v/textbar-button (s/attr :data-button-color := :red))
    {:background (:red colors)}
    [v/hovered                     {:background        (:red colors)}]]
   [(s/& v/textbar-button (s/attr :data-button-color := :twitter))
    {:background (:twitter colors)}
    [v/hovered                     {:background        (:twitter colors)}]]
   [(s/& v/textbar-button (s/attr :data-button-color := :facebook))
    {:background (:facebook colors)}
    [v/hovered                     {:background        (:facebook colors)}]]
   [(s/& v/textbar-button (s/attr :data-button-color := :github))
    {:background (:github colors)}
    [v/hovered                     {:background        (:github colors)}]]

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
