(def project 'offcourse/styles)
(def version "0.5.1")

(set-env!
 :resource-paths #{"src"}
 :dependencies  '[[offcourse/bootlaces  "0.1.16" :scope "test"]])

(require '[offcourse.bootlaces      :refer :all])

(task-options! pom {:project     project
                    :version     version
                    :description "Offcourse stylesheets"})

(deftask package-version []
  (println version))

(deftask build
  "Build and install the project locally."
  []
  (comp (build-jar)
        (target)))

(deftask dev []
  (comp (watch)
        (build)))
