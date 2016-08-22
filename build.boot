(def project 'offcourse/styles)
(def version "0.1.4-SNAPSHOT")

(set-env!
 :source-paths #{"src/"})

(set-env! :repositories [["clojars" {:url "https://clojars.org/repo/"
                                     :username (System/getenv "CLOJARS_USER")
                                     :password (System/getenv "CLOJARS_PASS")}]])

(task-options!
   push {:repo           "clojars"
         :ensure-branch  "master"
         :ensure-clean   true
         :ensure-version version}
   pom {:project     'offcourse/styles
        :version     version
        :description "Offcourse stylesheets"
        :url         "https://github.com/offcouse/offcourse-stylesheets/readme.md"
        :scm         {:url "https://github.com/offcouse/offcourse-stylesheets"}
        :license     {"Eclipse Public License"
                      "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom)
        (jar)
        (install)))

(deftask dev []
  (comp (watch)
        (build)))

(deftask deploy []
  (comp (build)
        (push :repo "clojars")))