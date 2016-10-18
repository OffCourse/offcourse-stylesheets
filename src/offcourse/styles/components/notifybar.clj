(ns offcourse.styles.components.notifybar
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden
              [arithmetic :refer [*]]
              [units :as u :refer [percent]]
              [selectors :as s]]
            [offcourse.styles.vocabulary :as v]))

(defn notifybar [{:keys [templates colors units]}]
  [[:.notifybar              (merge (:row-component        templates)
                                    {:flex                 1
                                     :align-items          :center
                                     :justify-content      :space-between
                                     :background          (:dark colors)
                                     :color               (:day colors)})]
   [:.notifybar--section     (merge (:row-component       templates)
                                    {:padding            [[0 (:full units)]]})]

   [:.notifybar--subtitle    (merge (:subtitle            templates))]
   [:.notifybar--text        (merge (:text                templates))]

   [:.notifybar--link        (merge (:text                templates)
                                    {:padding-left       (:third units)
                                     :text-decoration     :underline})]

   [:.notifybar--link-strong (merge (:subtitle            templates)
                                    {:text-decoration     :underline
                                     :color              (:day colors)})]
   [:.notifybar--link-em     (merge (:subtitle            templates)
                                    {:text-decoration     :underline
                                     :color              (:primary colors)})]

   [(s/& :.notifybar (s/attr :data-notify-color := :yellow))
    {:background (:yellow colors)
     :color      (:night colors)}]
   [(s/& :.notifybar (s/attr :data-notify-color := :blue))
    {:background (:blue colors)}]
   [(s/& :.notifybar (s/attr :data-notify-color := :red))
    {:background (:red colors)}]])
