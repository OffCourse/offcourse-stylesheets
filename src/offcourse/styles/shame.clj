(ns offcourse.styles.shame
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [percent px rem]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn shame [{:keys [templates borders colors fonts units breakpoints]}]
  [[:.meta-widget--container      (merge {:padding           [[0 0 0 0]]
                                          :max-width         (:max-content-width units)})]
   [:.meta-widget                 (merge (:column-component   templates)
                                         {:justify-content    :flex-start
                                          :padding         [[ 0 (:full units)]]})]
   [:.meta-widget--section        (merge (:column-component   templates))]
   [:.meta-widget--list           (merge (:column-component   templates
                                          {}))]
   [:.meta-widget--list-item      (merge {:padding          [[0 0 (:third units) 0]]})]
   [:.meta-widget--title          (merge (:label              templates))]
   [:.meta-widget--field          (merge (:smalltitle         templates))]
   [:.meta-widget--labels         (merge (:column-component   templates))]

   (let [{:keys [min-width max-width percent]} (first breakpoints)]
     (at-media {:min-width min-width :max-width max-width}
       [[:.meta-widget                   {:padding         [[ (:full units) 0]]}]]))])
