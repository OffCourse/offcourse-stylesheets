(ns offcourse.styles.components.form
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn form [{:keys [templates breakpoints colors units]}]
  [[:.card--field               (merge  (:title               templates)
                                       {:margin-top         (:third units)
                                        :padding          [[(:third units)(:two-third units)]]
                                        :background         (:light colors)})]
   [:.card--field-small         (merge  (:title               templates)
                                       {:min-width           "50%"
                                        :max-width           "50%"
                                        :margin-top         (:third units)
                                        :padding          [[(:third units)(:two-third units)]]
                                        :background         (:light colors)})
    [(s/& (s/nth-child "2n-1"))
     {:border-right [[(:sixth units) :solid (:day colors)]]}]
    [(s/& (s/nth-child "2n"))
     {:border-left  [[(:sixth units) :solid (:day colors)]]}]]])
