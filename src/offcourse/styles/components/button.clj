(ns offcourse.styles.components.button
  (:require [offcourse.styles.vocabulary :as v]
            [garden
             [selectors :as s]]))

(defn button [{:keys [templates colors units fonts]}]

  [[v/textbar-button (merge (:textbar            templates)
                            {:padding         [[(:third units) (:two-third units)]]
                             :align-items        :center
                             :font-size         (:subtitle-font units)
                             :cursor             :pointer})
    [v/hovered       (merge (:paper              templates))]
    [v/disabled             {:background-color  (:medium colors)
                             :color             (:day colors)}]]
   [(s/+ v/textbar-button v/textbar-button) {:margin-left (:sixth units)}]

   [v/icon-button (merge (:buttonless         templates)
                         {:font-size         (:full units)
                          :font-weight       700
                          :display           :flex
                          :justify-content   :center
                          :align-items       :center
                          :height           (:one-and-half units)
                          :width            (:one-and-half units)
                          :margin-right      0
                          :background       (:light colors)
                          :color            (:medium colors)})
    [v/disabled          {:color            (:day colors)}]
    [v/hovered           {:color            (:primary colors)}]]

   [v/checkbox-button (merge (:component        templates)
                             (:buttonless       templates)
                             (:paper            templates)
                             {:display          :flex
                              :margin-right     (:two-third units)
                              :width            (:two-third units)
                              :height           (:two-third units)})
    [v/selected              {:background-color (:primary colors)}]
    [v/disabled              {:background-color (:medium colors)}]]])
