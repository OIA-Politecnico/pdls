(ns electric-starter-app.main
  (:require [hyperfiddle.electric :as e]
            [hyperfiddle.electric-dom2 :as dom]
            [hyperfiddle.electric-ui4 :as ui]))

;; Saving this file will automatically recompile and update in your browser

#?(:clj (defonce !x (atom true)))
(e/def x (e/server (e/watch !x)))

(e/defn Main [ring-request]
  (e/client
    (binding [dom/node js/document.body]
      (dom/h1 (dom/text "Problema de la semana"))
      (dom/p (dom/text "Make sure you check the ")
        (dom/a
          (dom/props {:href "https://oia-politecnico.github.io/wiki" :target "_blank"})
          (dom/text "Wiki de la oia")))
      (ui/button
        (e/fn [] (e/server (swap! !x not)))
        (dom/text "TOGGLE"))
      (dom/text (if x "hola" "chau")))))
