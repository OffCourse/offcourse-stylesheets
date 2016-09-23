(ns offcourse.styles.components.dashboard
  (:require [offcourse.styles.vocabulary :as v]))

(defn dashboard [{:keys [templates colors units]}]
  [[v/dashboard        (merge     (:column-component   templates)
                                  {:width             (:sidebar units)})]
   [v/dashboard--main             {:padding          [[(:full units) (:full units) 0 (:full units)]]}]
   [v/dashboard--edit  (merge     {:padding          [[0 (:full units) (:full units) (:full units)]]})]])
