(def project 'offcourse/styles)
(def version "0.1.4-SNAPSHOT")

(set-env!
 :source-paths #{"src/"}
 :dependencies '[[adzerk/bootlaces "0.1.4" :scope "test"]])

(require '[adzerk.bootlaces :refer :all])

(bootlaces! version)

(task-options!
   push {:repo           "clojars"
         :ensure-branch  "master"
         :ensure-clean   false
         :ensure-version version}
   pom {:project     'offcourse/styles
        :version     version
        :description "Offcourse shared stylesheets"
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