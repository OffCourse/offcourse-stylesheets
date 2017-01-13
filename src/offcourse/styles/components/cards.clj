(ns offcourse.styles.components.cards
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn cards [{:keys [templates breakpoints colors units]}]
  [[:.cards                     (merge  (:row-component       templates)
                                        (:recycled-paper      templates)
                                        {:padding          [[0 0 (:full units) (:full units)]]
                                         :column-gap         (:column-gap units)
                                         :align-items         :flex-start
                                         :align-content       :flex-start
                                         :flex-wrap           :wrap})
    [v/container                        {:padding           [[0 (:full units) (:full units) 0]]}]]

   (let [{:keys [min-width max-width percent]} (first breakpoints)]
     (at-media {:min-width min-width :max-width max-width}
               [[:.cards
                 [v/container           {:width               "100%"}]]]))])
