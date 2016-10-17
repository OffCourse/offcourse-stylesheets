(ns offcourse.styles.components.index
  (:require [offcourse.styles.components
             [cards :refer [cards]]
             [card :refer [card]]
             [card-meta :refer [card-meta]]
             [card-social :refer [card-social]]
             [dashboard :refer [dashboard]]
             [button :refer [button]]
             [list :refer [list-component]]
             [meta-widget :refer [meta-widget]]
             [menubar :refer [menubar]]
             [viewer :refer [viewer]]
             [overlay :refer [overlay]]]))

(defn navigation-panel [{:keys [templates units fonts colors]}]
  [[:.navigation-panel (merge (:component templates) {})]])

(defn components [config]
  (let [components [list-component meta-widget
                    button dashboard menubar navigation-panel
                    viewer cards card card-meta card-social overlay]]
    (for [component components] (component config))))
