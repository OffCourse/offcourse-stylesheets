(ns offcourse.styles.shame
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [percent px rem vw vh]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn shame [{:keys [templates borders colors fonts units breakpoints]}]
  [[:.loading         (merge (:row-component     templates)
                             {:align-items       :center
                              :justify-content   :center
                              :width             (vw 100)
                              :height            (vh 100)})]
   [:.loading--logo   (merge (:textbar           templates)
                             {:padding          (:two-third units)})]])
