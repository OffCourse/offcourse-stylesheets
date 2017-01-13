(ns offcourse.styles.components.viewer
  (:refer-clojure :exclude [rem + - * /])
  (:require [offcourse.styles.vocabulary :as v]
            [garden
             [selectors :as s]
             [stylesheet :refer [at-media]]
             [arithmetic :refer [+ - * /]]
             [units :as u :refer [percent px rem]]]))

(defn viewer [{:keys [templates colors fonts units breakpoints]}]
  [[v/viewer                 (merge  (:row-component      templates)
                                     {:padding           [[0 0 (:full units) 0]]
                                      :flex               1
                                      :min-height        (:three units)
                                      :max-width         "100vw"})]
   [:.viewer--section                {}]

   [:.viewer--main           (merge  (:paper              templates)
                                     {:display            :block
                                      :padding         [[(* 4 (:third units))]]
                                      :width             (:max-content-width   units)})]

   (let [{:keys [min-width max-width percent]} (first breakpoints)]
    (at-media {:min-width min-width :max-width max-width}
     [[v/viewer               (merge (:column-component    templates)
                                     {:padding          [[(:full units)]]})]
      [:.viewer--main                {:width              "100%"}]]))

   [:.viewer--loading                {:min-height        (:third units)
                                      :width             (percent 100)
                                      :background        (:primary colors)}]
   [:.viewer--loading-img            {:min-height        (:third units)
                                      :width             (percent 100)
                                      :opacity            0.1
                                      :background        "url(/images/loader-anim-2.gif)"}]
   [:.viewer--error                  {:min-height        (:third units)
                                      :width             (percent 100)
                                      :background        (:red colors)}]
   [:.viewer--source-btn             {:padding         [[(:full units) 0]]}]

   [:.viewer--video-container        {:position           :relative
                                      :height             0
                                      :margin             [[(:full units) 0]]
                                      :max-width         (percent 100)
                                      :padding-bottom    (percent 56.25)
                                      :overflow           :hidden}]

   [:.viewer--video                  {:position           :absolute
                                      :width             (percent 100)
                                      :height            (percent 100)
                                      :top                0
                                      :left               0
                                      :background        (:night colors)}]])
