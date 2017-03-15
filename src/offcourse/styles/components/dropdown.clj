(ns offcourse.styles.components.dropdown
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [selectors :as s]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn dropdown [{:keys [templates breakpoints colors units]}]
  [[:.dropdown                     {:display          :none
                                    :position         :absolute
                                    :top             (:one-and-half units)
                                    :right            0
                                    :z-index          10
                                    :width           (:column units)
                                    :padding         (:two-third units)
                                    :background      (:green colors)}
    [(v/attr :data-dropdown-shown :true)
     (merge                        (:column-component templates))]]
   [:.dropdown-title        (merge (:title            templates)
                                   {:padding-bottom  (:third units)
                                    :color           (:day colors)})]
   [:.dropdown-text         (merge (:text             templates)
                                   {:color           (:day colors)})]])
