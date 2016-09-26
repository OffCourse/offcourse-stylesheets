(ns offcourse.styles.components.overlay
  (:refer-clojure :exclude [rem + - * /])
  (:require [offcourse.styles.vocabulary :as v]
            [garden
             [selectors :as s]
             [arithmetic :refer [+ - * /]]
             [units :as u :refer [percent px rem]]]))

(defn overlay [{:keys [templates colors fonts units]}]
 [[:.overlay            (merge (:column-component    templates)
                               {:position           :absolute
                                :left               0
                                :width             (percent 100)
                                :height            (percent 100)
                                :align-items        :center
                                :padding           (:full units)
                                :background         "rgba(0,0,0,0.8)"})]
  [:.edit-modal         (merge (:sheet              templates)
                               {:padding           (:full units)})]])