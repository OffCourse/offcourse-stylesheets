(ns offcourse.styles.components.button
  (:refer-clojure :exclude [+ - * /])
  (:require [offcourse.styles.vocabulary :as v]
            [garden
             [arithmetic :refer [* +]]
             [selectors :as s]]))

(defn button [{:keys [templates colors units fonts]}]
  [[v/textbar-button         (merge (:row-component      templates)
                                    (:subtitle           templates)
                                    {:width             (* 8 (:full units))
                                     :justify-content    :center
                                     :align-items        :center
                                     :padding         [[(:third units) (:two-third units)]]
                                     :background        (:dark colors)
                                     :color             (:day colors)
                                     :border-bottom   [[(:atom units) :solid (:night colors)]]
                                     :cursor             :pointer})
     [v/hovered              (merge {:color             (:night colors)})]
     [(v/attr :data-button-color :light)
      (merge                        {:background        (:light colors)
                                     :color             (:dark colors)
                                     :border             :none})]
     [(v/attr :data-button-color :blue)
      (merge                        {:background        (:blue colors)})]
     [(v/attr :data-button-color :red)
      (merge                        {:background        (:red colors)})]
     [(v/attr :data-button-color :twitter)
      (merge                        {:background        (:twitter colors)})]
     [(v/attr :data-button-color :linkedin)
      (merge                        {:background        (:linkedin colors)})]
     [(v/attr :data-button-color :github)
      (merge                        {:color             (:dark   colors)
                                     :background        (:github colors)})]
     [(v/attr :data-button-width := :full)
      (merge                        {:width "100%"})]]
   [(s/+ v/textbar-button v/textbar-button)
    (merge                          {:margin-left     (:sixth units)})]

   [v/icon-button            (merge (:row-component     templates)
                                    (:title             templates)
                                    {:padding          (:sixth units)
                                     :justify-content   :center
                                     :align-items       :center
                                     :background       (:medium colors)
                                     :color            (:light colors)})
     [v/hovered                     {:color            (:primary colors)}]
     [:.button--icon                {:width            (:half units)}]]

   [v/checkbox-button        (merge (:component        templates)
                                    (:paper            templates)
                                    {:display          :flex
                                     :margin-right     (:two-third units)
                                     :width            (:two-third units)
                                     :height           (:two-third units)})
    [v/selected                     {:background-color (:primary colors)}]
    [v/disabled                     {:background-color (:medium colors)}]]])
