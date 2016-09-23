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
                    :align-items       :flex-start
                    :align-content     :flex-start
                    :flex-wrap         :wrap})
    [v/container {:padding [[0 (:full units) (:full units) 0]]}]]

   (let [{:keys [min-width max-width percent]} (first breakpoints)]
     (at-media {:min-width min-width :max-width max-width}
               [v/cards 
                 [v/container {:width "50%"}]
                v/card {:width "100%"}]))

   [v/card (merge (:column-component templates)
                  (:sheet templates)
                  {:justify-content :space-between
                   :width (:column units)
                   :flex 1})
    [v/hovered (:highlighted borders)]]

  

   [v/card--section (merge (:component         templates)
                           (:border-thin       templates)
                           {:position          :relative
                            :padding          (:full units)})
    [v/first               {:padding-top    (:two-third units)
                            :padding-bottom (:two-third units)}]]

   [v/card--title (merge (:title templates))]


   [v/card--profile           (merge  (:row-component templates))]
   [v/card--profile-section   (merge  (:column-component templates))
    [v/second                         {:padding [[0 0 0 (:full units)]]}]]
   [v/card--profile-image             {:width (:two units)}]
   [v/card--profile-label     (merge  (:label templates))]
   [v/card--profile-username  (merge  (:subtitle templates))]
   [v/card--profile-stats     (merge  (:label templates)
                                      (:row-component templates))]
   
   [v/card--actions     (merge (:row-component templates))]

   [v/card--social       (merge (:row-component templates)
                                {:justify-content :space-between})]
   [v/card--social-icons (merge (:row-component templates))]
   [v/card--social-img   (merge {:width (:full units)
                                 :height (:full units)
                                 :margin-right (:two-third units)})]
   [v/card--social-url   (merge (:subtitle templates)
                                {:text-decoration :underline})]])
