(ns offcourse.styles.components.card-meta
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn card-meta [{:keys [templates breakpoints colors units]}]
  [:.card-meta              (merge  (:row-component       templates))
   [:.card-meta--section     (merge  (:column-component    templates))
    [v/second                        {:padding           [[0 0 0 (:third units)]]}]]
   [:.card-meta--image               {:width              (:two units)}]
   [:.card-meta--label       (merge  (:label               templates))]
   [:.card-meta--username    (merge  (:subtitle            templates))]
   [:.card-meta--stats       (merge  (:label               templates)
                                     (:row-component       templates))]])
