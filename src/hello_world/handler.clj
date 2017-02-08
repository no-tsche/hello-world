(ns hello-world.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.core :refer :all]))

(defroutes app-routes
  (GET "/" [] (html [:h1 "Привет! Мир!"]))

  (GET "/user/:id{[0-9]+}" [id] (html [:h2 "Привет, пользователь №" id]))

  (route/not-found "404 Не нашли."))


(def app
  (wrap-defaults app-routes site-defaults))
