(ns offcourse.styles.components.cards
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn cards [{:keys [templates breakpoints borders colors units]}]
  ; Collection layout
  [[v/cards                     (merge  (:row-component       templates)
                                        (:recycled-paper      templates)
                                        {:padding          [[(:full units) 0 (:full units) (:full units)]]
                                         :column-gap         (:column-gap units)
                                         :align-items         :flex-start
                                         :align-content       :flex-start
                                         :flex-wrap           :wrap})
    [v/container                        {:padding           [[0 (:full units) (:full units) 0]]}]]

   ; Card Layout
   [v/card                      (merge  (:column-component    templates)
                                        (:sheet               templates)
                                        {:justify-content     :space-between
                                         :width              (:column units)
                                         :flex                1})
    [v/hovered                          (:highlighted         borders)]]

   [v/card--section             (merge  (:component           templates)
                                        (:border-thin         templates)
                                        {:position            :relative
                                         :padding            (:two-third units)})
    [v/first                            {:padding-top        (:two-third units)
                                         :padding-bottom     (:two-third units)}]]
   [:.card--dropdown            (merge  (:column-component    templates))]

   ; Header
   [v/card--title               (merge  (:title               templates))]


   ; Meta-box
   [v/card--profile             (merge  (:row-component       templates))]
   [v/card--profile-section     (merge  (:column-component    templates))
    [v/second                           {:padding           [[0 0 0 (:third units)]]}]]
   [v/card--profile-image               {:width              (:two units)}]
   [v/card--profile-label       (merge  (:label               templates))]
   [v/card--profile-username    (merge  (:subtitle            templates))]
   [v/card--profile-stats       (merge  (:label               templates)
                                        (:row-component       templates))]

   ; Actions
   [v/card--actions             (merge  (:row-component       templates))]

   ; Social
   [v/card--social              (merge  (:row-component       templates)
                                        {:justify-content     :space-between
                                         :align-items         :center})]
   [v/card--social-icons        (merge  (:row-component       templates))]
   [v/card--social-img          (merge  {:height             (:full units)
                                         :margin-right       (:two-third units)})]
   [v/card--social-url          (merge  (:subtitle            templates)
                                        {:text-decoration     :underline})]

   ; In-card edit (new-user view)
   [v/card--edit-field          (merge  (:row-component       templates)
                                        (:recycled-paper      templates)
                                        (:title               templates)
                                        {:margin-bottom      (:sixth units)
                                         :align-items         :center
                                         :padding          [[(:sixth units) (:half units)]]})]

   ; Media-queries
   (let [{:keys [min-width max-width percent]} (first breakpoints)]
     (at-media {:min-width min-width :max-width max-width}
               [[v/cards
                 [v/container           {:width               "100%"}]]
                [v/card                 {:width               "100%"}
                 [v/hovered
                  [:.card--dropdown     {:max-height         (* 20 (:full units))
                                         :transition          "all 0.5s ease 0.5s"}]]
                 [v/activated
                  [:.card--dropdown     {:max-height         (* 20 (:full units))
                                         :transition          "all 0.5s ease 0.5s"}]]]
                [v/card--title  (merge  {:pointer-events      :none
                                         :cursor              :default})]
                [:.card--dropdown       {:max-height          0
                                         :overflow            :hidden
                                         :transition          "all 0.5s ease"}]]))])
