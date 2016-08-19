(ns styles.components.list
  (:refer-clojure :exclude [first last list])
  (:require [styles.vocabulary :as v]))

(defn list-component [{:keys [templates borders colors fonts units]}]

  [[v/list         (merge (:column-component templates))]
   [v/list--item   (merge (:row-component    templates)
                          (:border-thin      templates)
                          (:text             templates)
                          {:align-items      :center
                           :padding       [[(:third units)(:two-third units)]]})
    [v/hovered            (:selected         templates)]]

   [v/edit-list
    [v/list--item  (merge {:justify-content :space-between
                           :padding 0
                           :background-color (:day colors)})
     [v/icon-button       {:font-size (:two-third units)}]
     [:span
      [v/first     (merge (:recycled-paper templates)
                          {:flex 1
                           :display :flex
                           :padding (:half units)
                           :align-items :center
                           :height (:one-and-half units)
                           :margin-right (:sixth units)})]]]]

   [v/todo-list
    [v/list--item         {:justify-content :flex-start}
     [v/hovered           (:selected templates)]
     [v/selected          (:highlighted templates)
      [v/checkbox-button
       [v/selected        {:background-color (:night colors)}]]]]]])

