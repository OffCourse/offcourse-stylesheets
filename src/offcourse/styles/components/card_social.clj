(ns offcourse.styles.components.card-social
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn card-social [{:keys [templates breakpoints colors units]}]
  [[v/card--social              (merge  (:row-component       templates)
                                        {:justify-content     :space-between
                                         :align-items         :center})]
   [v/card--social-icons        (merge  (:row-component       templates))]
   [v/card--social-img          (merge  {:height             (:full units)
                                         :margin-right       (:two-third units)})]
   [v/card--social-url          (merge  (:subtitle            templates)
                                        {:text-decoration     :underline})]])
