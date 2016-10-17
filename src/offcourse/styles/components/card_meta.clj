(ns offcourse.styles.components.card-meta
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn card-meta [{:keys [templates breakpoints colors units]}]
  [[v/card--profile             (merge  (:row-component       templates))]
   [v/card--profile-section     (merge  (:column-component    templates))
    [v/second                           {:padding           [[0 0 0 (:third units)]]}]]
   [v/card--profile-image               {:width              (:two units)}]
   [v/card--profile-label       (merge  (:label               templates))]
   [v/card--profile-username    (merge  (:subtitle            templates))]
   [v/card--profile-stats       (merge  (:label               templates)
                                        (:row-component       templates))]])
