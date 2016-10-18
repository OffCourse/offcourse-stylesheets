(ns offcourse.styles.layout
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden
              [units :as u :refer [vh]]
              [arithmetic :refer [*]]
              [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn layout [{:keys [templates units colors breakpoints]}]
  [[v/layout                (merge (:column-component   templates)
                                   (:paper              templates)
                                   {:flex                1
                                    :height             (vh 100)
                                    :align-content      :stretch
                                    :overflow           :hidden})]
   [:.layout--header        (merge (:column-component   templates)
                                   {:border-bottom      [["1px" :solid (:light colors)]]})]
   [:.layout--main          (merge (:row-component      templates)
                                   {:flex               1})]

   [:.header                       (:column-component   templates)]
   [:.header--section              (:column-component   templates)
                                   {:flex             [[0 0 (:two units)]]}]

   [v/main                  (merge (:row-component templates)
                                   (:recycled-paper templates)
                                   {:flex 1})]
   [v/main--section
    [v/last                 (merge (:row-component templates)
                                   (:recycled-paper templates)
                                   {:flex 2
                                    :overflow :scroll})]]

   [v/container             (merge (:row-component templates)
                                   {:padding [[0 0 (:two-third units) 0]]})]

   (let [{:keys [min-width max-width percent]} (first breakpoints)]
    (at-media {:min-width min-width :max-width max-width}
     [[v/layout--section
       [v/last                     {:overflow :scroll}]]
      [v/main               (merge (:column-component    templates))]
      [v/main--section
       [v/last                     {:display :block
                                    :overflow :visible}]]]))])
