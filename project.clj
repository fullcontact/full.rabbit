(defproject fullcontact/full.rabbit "0.10.1"
  :description "RabbitMQ sugar on top of langohr."
  :url "https://github.com/fullcontact/full.rabbit"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}
  :deploy-repositories [["releases" {:url "https://clojars.org/repo/" :creds :gpg}]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.novemberain/langohr "3.2.0" :exclusions [cheshire]]
                 [fullcontact/full.metrics "0.10.1"]
                 [fullcontact/full.json "0.10.1"]
                 [fullcontact/full.async "0.9.0"]
                 [fullcontact/full.core "0.10.1"]]
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]
  :aot :all
  :plugins [[lein-midje "3.1.3"]]
  :profiles {:dev {:dependencies [[midje "1.7.0"]]}})
