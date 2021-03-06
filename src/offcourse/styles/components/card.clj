(ns offcourse.styles.components.card
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]
             [selectors :as s]]
            [offcourse.styles.vocabulary :as v]))

(defn card [{:keys [templates breakpoints colors units]}]
  [[:.card                      (merge  (:column-component    templates)
                                        (:sheet               templates)
                                        {:justify-content     :space-between
                                         :width              (:column units)})
    [v/hovered                          (:border-highlighted  templates)]
    [(v/attr :data-card-type :medium)
     (merge                             {:width              (* 20 (:full units))})]
    [(v/attr :data-card-type :wide)
     (merge                             {:width              (:max-content-width units)
                                         :max-width           "100%"})
     [:.card--section                   {:padding            (:full units)}]]]
   [:.card--section             (merge  (:component           templates)
                                        (:border-thin         templates)
                                        {:position            :relative
                                         :padding            (:two-third units)})]
   [:.card--wrapper             (merge  (:column-component    templates))]

   ; typography
   [:.card--title               (merge  (:title               templates)
                                        {:word-wrap           :break-word})
    [(v/attr :data-title-disabled :true)
     (merge                             {:color              (:medium colors)})]

    [(v/attr :data-title-indent)
     (merge                             {:padding-left       (:two-third units)})]]
   [:.card--subtitle            (merge  (:subtitle            templates))
    [(v/attr :data-subtitle-indent)
     (merge                             {:padding-left       (:two-third units)})]]
   [:.card--text                (merge  (:text                templates))
    [(v/attr :data-text-indent)
     (merge                             {:padding-left       (:two-third units)})]
    [(v/attr :data-text-padded :small)
     (merge                             {:padding-bottom     (:third units)})]
    [(v/attr :data-text-padded :large)
     (merge                             {:padding-bottom     (:two-third units)})]]
   [:.card--link                (merge  (:text                templates)
                                        {:cursor              :pointer})
    [v/hovered                  (merge  {:border-bottom      [["1px" "solid" (:night colors)]]
                                         :margin-bottom        "-1px"})]
    [(v/attr :data-link-type :strong)
     (merge                             (:subtitle            templates))]
    [(v/attr :data-link-type :em)
     (merge                             {:color              (:primary colors)})
     [v/hovered                 (merge  {:border-color       (:primary colors)})]]]
   [:.card--error               (merge  (:text                templates)
                                        {:padding           [[0 (:two-third units) (:third units)]]
                                         :color              (:red colors)})]

   ; Utils
   [:.card--row                 (merge  (:row-component       templates)
                                        {:position            :relative
                                         :align-items         :center})
    [(v/attr :data-row-padded :small)
     (merge                             {:padding-bottom     (:third units)})]
    [(v/attr :data-row-padded :large)
     (merge                             {:padding-bottom     (:two-third units)})]
    [(v/attr :data-row-spaced)
     (merge                             {:justify-content     :space-between})]
    [(v/attr :data-row-wrap)
     (merge                             {:justify-content     :flex-start
                                         :flex-wrap           :wrap})]]

   (let [{:keys [min-width max-width]} (first breakpoints)]
     (at-media {:min-width min-width :max-width max-width}
       [[:.card                         {:width               "100%"}
         [(v/attr :data-card-type :wide){:width               "100%"}]
         [v/hovered v/activated
          [:.card--wrapper              {:max-height         (* 20 (:full units))
                                         :transition          "all 0.5s ease 0.5s"}]]]
        [:.card--wrapper                {:max-height          0
                                         :overflow            :hidden
                                         :transition          "all 0.5s ease"}]
        [:.card--title          (merge  {:pointer-events      :none
                                         :cursor              :default})]]))])
