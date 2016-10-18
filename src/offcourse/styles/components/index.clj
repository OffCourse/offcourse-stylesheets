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
             [notifybar :refer [notifybar]]
             [viewer :refer [viewer]]
             [viewer-content :refer [viewer-content]]
             [overlay :refer [overlay]]]))

(defn navigation-panel [{:keys [templates units fonts colors]}]
  [[:.navigation-panel (merge (:component templates) {})]])

(defn components [config]
  (let [components [list-component meta-widget
                    button dashboard menubar notifybar navigation-panel
                    viewer viewer-content cards card card-meta card-social overlay]]
    (for [component components] (component config))))
