(ns offcourse.styles.components.form
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [selectors :as s]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn form [{:keys [templates breakpoints colors units]}]
  [[:.form--field                (merge (:title               templates)
                                        {:margin-top          "2px"
                                         :padding          [[(:third units)(:two-third units)]]
                                         :background         (:light colors)})
    [(v/attr :data-field-type :half)
     (merge                             {:min-width           "50%"
                                         :max-width           "50%"})
     [(v/nth-child "2n-1")
      (merge                            {:border-right     [["1px" :solid (:day colors)]]})]
     [(v/nth-child "2n")
      (merge                            {:border-left      [["1px" :solid (:day colors)]]})]]
    [(v/attr :data-field-margin)
     (merge                             {:margin-bottom   [[(:two-third units)]]})]]])
