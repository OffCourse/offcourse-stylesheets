(ns offcourse.styles.components.overlay
  (:refer-clojure :exclude [rem + - * /])
  (:require [offcourse.styles.vocabulary :as v]
            [garden
             [selectors :as s]
             [arithmetic :refer [+ - * /]]
             [units :as u :refer [percent px rem]]]))

(defn overlay [{:keys [templates colors fonts units]}]
 [[:.overlay                     (merge (:column-component   templates)
                                        {:position           :absolute
                                         :left               0
                                         :width             (percent 100)
                                         :height            (percent 100)
                                         :align-items        :center
                                         :padding         [[(:full units)]]
                                         :background         "rgba(0,0,0,0.8)"})]
  [:.course-form                 (merge (:sheet              templates)
                                        {:width             (:modal-content-width units)})]
  [:.course-form--section        (merge (:column-component   templates)
                                        (:border-thin        templates)
                                        {:padding         [[(:full units)]]})]
  [:.course-form--action-title   (merge (:subtitle           templates)
                                        {:padding          [[0 (:half units) (:half units)]]})]
  [:.course-form--course-title   (merge (:title              templates)
                                        {:background        (:light colors)
                                         :flex               1
                                         :padding         [[(:half units)]]})
    [(s/attr :data-error := :true)      {:background        (:red colors)}]]
  [:.course-form--cp-actions     (merge (:row-component      templates)
                                        [:padding         [[(:full units) 0 0]]])]
  [:.course-form--actions        (merge (:row-component      templates))]])
