(ns offcourse.styles.components.dashboard
  (:require [offcourse.styles.vocabulary :as v]
            [garden.stylesheet :refer [at-media]]))

(defn dashboard [{:keys [templates colors units breakpoints]}]
  [[v/dashboard        (merge     (:column-component   templates)
                                  {:width             (:sidebar units)})]

   (let [{:keys [min-width max-width percent]} (first breakpoints)]
    (at-media {:min-width min-width :max-width max-width}
     [v/dashboard      (merge     {:width              "100%"})]))

   [v/dashboard--main             {:padding          [[(:full units) (:full units) 0 (:full units)]]}]
   [v/dashboard--edit  (merge     {:padding          [[0 (:full units) (:full units) (:full units)]]})]])
   
