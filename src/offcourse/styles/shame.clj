(ns offcourse.styles.shame
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [percent px rem]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn shame [{:keys [templates borders colors fonts units breakpoints]}]
  [[:.auth                        (merge (:column-component   templates)
                                         (:sheet              templates)
                                         {:width             (* 20 (:full units))})]
   [:.auth--section               (merge (:column-component   templates)
                                         (:border-thin         templates)
                                         {:padding           (:two-third units)})]
   [:.auth--button-container      (merge (:row-component      templates))]
   [:.auth--button                (merge (:button-base        templates))]
   [:.auth--title                 (merge (:title              templates))]
   [:.auth--text                  (merge (:text               templates))]])
