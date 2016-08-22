(ns styles.components.cards
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [styles.vocabulary :as v]))

(defn calculate-breakpoint [{:keys [min-width max-width column-count]} {:keys [column-gap column]}]
  (at-media {:min-width min-width :max-width max-width}
            (let [gap-count    (dec column-count)
                  actual-width (+ (* column-count column) (* gap-count column-gap))]
              [v/cards {:display      (if (= column-count 0) :none :block)
                        :column-count column-count
                        :min-width    actual-width
                        :max-width    actual-width}])))

(defn cards [{:keys [templates breakpoints borders colors units]}]
  [[v/cards (merge (:row-component templates)
                   (:recycled-paper templates)
                   {:background :red
                    :padding          (:full units)
                    :column-gap       (:column-gap units)})
    [v/container {:display :inline-block
                  :width (:column units)
                  :padding-right (:third units)}]]

   (for [breakpoint breakpoints] (calculate-breakpoint breakpoint units))

   [v/card                      (merge (:column-component    templates)
                                       (:paper               templates)
                                       {:position            :relative
                                        :padding           [[0 0]]
                                        :flex                1
                                        :box-shadow       [[(:sixth units) (:sixth units) 0 0 (:medium colors)]]})
    [v/hovered                         (:highlighted         borders)
     [:.card--backside          (merge (:negative            templates)
                                       (:column-component    templates)
                                       {:position            :absolute
                                        :height              "100%"
                                        :width               "100%"
                                        :background         (:medium colors)})]]]
    [:.card--backside                  {:display             :none
                                        :position            :relative}]


   [v/card--section             (merge (:row-component       templates)
                                       (:border-thin         templates)
                                       {:padding          [[(:two-third units)]]})]

   [:.card--frontside                  {:padding           [[0 (:two-third units)(:two-third units) 0]]}
    [v/card--section
     [v/first                   (merge {:padding          [[(:two-third units)]]})]
     [v/second                  (merge (:column-component    templates)
                                       {:padding           [[0 0 (:third units) 0]]})]
     [v/last                           {:border              :none}]]]

   [:.card--info-corner         (merge {:position            :absolute
                                        :right               0
                                        :top                 (:two-third units) 
                                        :width              (:full units)
                                        :height             (:full units)
                                        :display             :flex
                                        :align-items         :center
                                        :justify-content     :center
                                        :background         (:medium colors)
                                        :color              (:day    colors)})]
   [:.card--info-corner-back    (merge {:position            :absolute
                                        :right               0
                                        :top                 (:two-third units) 
                                        :width              (:full units)
                                        :height             (:full units)
                                        :display             :flex
                                        :align-items         :center
                                        :justify-content     :center
                                        :background         (:day colors)
                                        :color              (:medium colors)})]

   [:.card--meta                (merge (:column-component    templates)
                                       {:padding          [[ 0 (:third units)]]})]
   [:.card--img                        {:width              (* (:third units) 6)
                                        :height             (* (:third units) 6)}]
   [:.card--stats               (merge (:row-component       templates)
                                       (:justify-content     :space-between))]
   [:.card--title                      (:subtitle            templates)]
   [:.card--smalltitle                 (:smalltitle          templates)]
   [:.card--smalltext                  (:label               templates)]])
