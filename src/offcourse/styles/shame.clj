(ns offcourse.styles.shame
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden.arithmetic :refer [*]]
            [garden.units :as u :refer [percent px rem]]
            [offcourse.styles.vocabulary :as v]))

(defn shame [{:keys [templates borders colors fonts units]}]
  [[:.checkpoint                  (merge (:row-component      templates)
                                         {:padding-top       (:full units)
                                          :width             (percent 100)})]
   [:.meta-widget--container      (merge {:padding           [[(:full units) 0 0 0]]
                                          :max-width         (:max-content-width units)})]
   [:.meta-widget                 (merge (:column-component   templates)
                                         {:justify-content    :flex-start
                                          :padding         [[(:full units)]]})]
   [:.meta-widget--section        (merge (:column-component   templates))]
   [:.meta-widget--list           (merge (:column-component   templates       
                                          {}))]
   [:.meta-widget--list-item      (merge {:padding          [[0 0 (:third units) 0]]})]
   [:.meta-widget--title          (merge (:label              templates))]
   [:.meta-widget--field          (merge (:smalltitle         templates))]
   [:.meta-widget--labels         (merge (:column-component   templates))]])
