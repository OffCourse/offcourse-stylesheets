(ns offcourse.styles.vocabulary
  (:refer-clojure :exclude [first second last list])
  (:require [garden.selectors :as s]))

;; LAYOUT
(s/defclass container)
(s/defclass layout)
(s/defclass layout--section)
(s/defclass main)
(s/defclass main--section)

;; ELEMENTS
(s/defclass list)
(def todo-list (list (s/attr :data-list-type := :todo)))
(def edit-list (list (s/attr :data-list-type := :edit)))
(s/defclass list--item)

(s/defclass viewer)
(s/defclass viewer--meta)
(s/defclass viewer--content)
(def viewer-headers      [:h1 :h2 :h3 :h4 :h5 :h6])
(def viewer-header-1      :h1)
(def viewer-header-2      :h2)
(def viewer-header-3      :h3)
(def viewer-header-4      :h4)
(def viewer-header-5      :h5)
(def viewer-header-6      :h6)
(def viewer-text          :p)
(def viewer-anchor        :a)
(def viewer-strong        :strong)
(def viewer-em            :em)
(def viewer-hr            :hr)
(def viewer-ul            :ul)
(def viewer-ol            :ol)
(def viewer-li            :li)
(def viewer-image         :img)
(def viewer-figcaption    :figcaption)
(def viewer-blockquote    :blockquote)
(def viewer-pre           :pre)
(def viewer-code          :code)
(def viewer-fieldset      :fieldset)
(def viewer-legend        :legend)
(def viewer-input         :input)
(def viewer-textarea      :textarea)
(def viewer-select        :select)

(s/defclass logo)

(s/defclass labels)
(s/defclass label)

;; this one must disappear
(s/defclass dashboard)
(s/defclass dashboard--main)
(s/defclass dashboard--edit)

(s/defclass menubar)
(s/defclass menubar--section)
(s/defclass menubar--logo)

(s/defclass button)
(def textbar-button (button (s/attr :data-button-type := :textbar)))
(def icon-button (button (s/attr :data-button-type := :icon)))
(def checkbox-button (button (s/attr :data-button-type := :checkbox)))

(s/defclass title)
(s/defclass subtitle)
(s/defclass content)

;; MODIFIERS
(s/defpseudoclass hover)
(s/defpseudoclass active)
(s/defpseudoclass disabled)
(s/defpseudoclass first-child)
(s/defpseudoclass last-child)

(def selected (s/& (s/attr :data-selected := :true)))
(def disabled (s/& disabled))
(def hovered (s/& hover))
(def activated (s/& active))

(def first (s/& first-child))
(def last (s/& last-child))
(def second (s/& (s/nth-child "2")))
(def third (s/& (s/nth-child "3")))
(defn nth-child [expression] (s/& (s/nth-child expression)))

(defn attr
  ([attribute-name op attribute-value] (s/& (s/attr attribute-name op attribute-value)))
  ([attribute-name attribute-value] (s/& (s/attr= attribute-name attribute-value)))
  ([attribute-name] (s/& (s/attr attribute-name))))
