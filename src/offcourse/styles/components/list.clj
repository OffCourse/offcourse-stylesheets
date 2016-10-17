(ns offcourse.styles.components.list
  (:refer-clojure :exclude [first last list])
  (:require [offcourse.styles.vocabulary :as v]))

(defn list-component [{:keys [templates colors fonts units]}]
  [[v/list                  (merge (:column-component templates))]
   [v/list--item            (merge (:row-component templates)
                                   (:recycled-paper templates)
                                   (:subtitle templates)
                                   {:margin-bottom   (:fifteenth units)
                                    :align-items     :center
                                    :padding         [[ (:sixth units) (:half units)]]})
    [v/hovered                     (:selected templates)]]

   [v/edit-list
     [v/list--item          (merge (:row-component       templates)
                                   (:recycled-paper      templates)
                                   {:justify-content     :space-between
                                    :margin-bottom      (:sixth units)
                                    :padding             0
                                    :background-color   (:light colors)})]
     [v/icon-button                {:font-size          (:two-third units)}]
     [:.list--item-section  (merge (:column-component    templates)
                                   {:flex                1})
      [v/last                      {:flex                0}]]
     [:.list--course        (merge (:title               templates)
                                   {:padding            (:half units)
                                    :background         (:light colors)})]
     [:.list--url           (merge (:subtitle            templates)
                                   {:padding           [[0 (:half units) (:half units) (:half units)]]
                                    :background         (:light colors)})]]

   [v/todo-list
    [v/list--item                  {:justify-content :flex-start}
     [v/hovered                    (:selected templates)]
     [v/selected                   (:highlighted templates)
      [v/checkbox-button
       [v/selected                 {:background-color (:night colors)}]]]]]])
