(ns offcourse.styles.components.form
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [selectors :as s]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn form [{:keys [templates breakpoints colors units]}]
  [[:.form--field               (merge (:title               templates)
                                       {:margin-top         (:third units)
                                        :padding          [[(:third units)(:two-third units)]]
                                        :background         (:light colors)})
    [(v/attr :data-field-type :half)
     (merge                            {:min-width           "50%"
                                        :max-width           "50%"})
     [(v/nth-child "2n-1")
      (merge                           {:border-right [[(:sixth units) :solid (:day colors)]]})]
     [(v/nth-child "2n")
      (merge                           {:border-left  [[(:sixth units) :solid (:day colors)]]})]]]])
