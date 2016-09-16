(ns offcourse.styles.components.cards
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn cards [{:keys [templates breakpoints borders colors units]}]
  [[v/cards (merge (:row-component templates)
                   (:recycled-paper templates)
                   {:padding          (:full units)
                    :column-gap       (:column-gap units)
                    :align-items       :flex-start
                    :align-content     :flex-start
                    :flex-wrap         :wrap})
    [v/container {:padding [[0 (:full units) (:full units) 0]]}]]

   [v/card (merge (:column-component templates)
                  (:sheet templates)
                  {:width (:column units)
                   :padding [[0 (:full units)]]
                   :flex 1})
    [v/hovered (:highlighted borders)]]

   (let [{:keys [min-width max-width percent]} (first breakpoints)]
     (at-media {:min-width min-width :max-width max-width}
               [v/cards 
                 [v/container {:width "50%"}]
                v/card {:width "100%"}]))

   [v/card--section (merge (:component templates)
                          {:padding [[0 0 (:full units) 0]]})
    [v/first {:padding-top    (:two-third units)}
             :padding-bottom (:two-third units)]
    [v/last {}]]

   [v/card--title (merge (:title templates))]]) 
