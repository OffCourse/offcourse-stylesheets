(ns offcourse.styles.components.card-social
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]))

(defn card-social [{:keys [templates breakpoints colors units]}]
  [[:.card-social               (merge  (:row-component       templates)
                                        {:justify-content     :space-between
                                         :align-items         :center})]
   [:.card-social--icons        (merge  (:row-component       templates))]
   [:.card-social--img          (merge  {:height             (:full units)
                                         :margin-right       (:two-third units)})]
   [:.card-social--url          (merge  (:subtitle            templates)
                                        {:text-decoration     :underline})]])
