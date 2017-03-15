(ns offcourse.styles.components.dashboard
  (:refer-clojure :exclude [+ - * /])
  (:require [offcourse.styles.vocabulary :as v]
            [garden
              [stylesheet :refer [at-media]]
              [arithmetic :refer [* +]]]))

(defn dashboard [{:keys [templates colors units breakpoints]}]
  [[:.dashboard            (merge (:column-component   templates)
                                  {:width             (:sidebar units)})]

   (let [{:keys [min-width max-width percent]} (first breakpoints)]
    (at-media {:min-width min-width :max-width max-width}
     [:.dashboard          (merge {:width      "100%"})]))

   [:.dashboard--main             {:padding    [[(:two units) (:full units) 0]]}]
   [:.dashboard--controls  (merge {:padding    [[0 (+ (:full units) (:two-third units)) (:full units)]]})]])
