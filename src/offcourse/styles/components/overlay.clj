(ns offcourse.styles.components.overlay
  (:refer-clojure :exclude [rem + - * /])
  (:require [offcourse.styles.vocabulary :as v]
            [garden
             [selectors :as s]
             [arithmetic :refer [+ - * /]]
             [units :as u :refer [percent px rem]]]))

(defn overlay [{:keys [templates colors fonts units]}]
 [[:.overlay                    (merge (:column-component   templates)
                                       {:position           :absolute
                                        :left               0
                                        :width             (percent 100)
                                        :height            (percent 100)
                                        :align-items        :center
                                        :padding         [[(:full units)]]
                                        :background         "rgba(0,0,0,0.8)"})]
  [:.edit-modal                 (merge (:sheet              templates)
                                       {:width             (:modal-content-width units)})]
  [:.edit-modal--section        (merge (:column-component   templates)
                                       (:border-thin        templates)
                                       {:padding         [[(:full units)]]})]
  [:.edit-modal--action-title   (merge (:subtitle           templates)
                                       {:padding          [[0 (:half units) (:half units)]]})]
  [:.edit-modal--course-title   (merge (:title              templates)
                                       {:flex               1
                                        :padding          [[0 (:half units)]]})]
  [:.edit-modal--actions        (merge (:row-component      templates))]])
