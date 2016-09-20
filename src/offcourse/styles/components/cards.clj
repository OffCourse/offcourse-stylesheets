(ns offcourse.styles.components.cards
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn cards [{:keys [templates breakpoints borders colors units]}]
  [[v/cards (merge (:row-component templates)
                   (:recycled-paper templates)
                   {:padding        [[(:full units) 0 (:full units) (:full units)]]
                    :column-gap       (:column-gap units)
                    :align-items       :stretch
                    :align-content     :flex-start
                    :flex-wrap         :wrap})
    [v/container {:max-height          (* 25 (:full units))
                  :padding [[0 (:full units) (:full units) 0]]}]]

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

   [v/card--section (merge (:component         templates)
                           {:position          :relative
                            :padding         [[0 0 (:full units) 0]]})
    [v/first               {:padding-top    (:two-third units)
                            :padding-bottom (:two-third units)}]]

   [v/card--title (merge (:title templates))]

   [v/card--actions (merge (:row-component templates)
                           {:flex-wrap :wrap})]

   [v/card--edit-sign   {:position :absolute
                         :top (:full units)
                         :right 0
                         :width (:half units)}]
   [v/card--edit-field  (merge (:row-component templates)
                               (:recycled-paper templates)
                               (:title templates)
                               {:margin-bottom   (:sixth units)
                                :align-items     :center
                                :padding         [[ (:sixth units) (:half units)]]})]
   [v/card--profile           (merge  (:row-component templates))]
   [v/card--profile-section   (merge  (:column-component templates))
    [v/second                         {:padding [[0 0 0 (:full units)]]}]]
   [v/card--profile-image             {:width (:three units)}]
   [v/card--profile-subtitle  (merge  (:text templates))]
   [v/card--profile-username  (merge  (:subtitle templates))]
   [v/card--profile-stats     (merge  (:label templates)
                                      (:row-component templates))]])
