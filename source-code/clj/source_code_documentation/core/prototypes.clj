
(ns source-code-documentation.core.prototypes
    (:require [fruits.vector.api                     :as vector]
              [io.api                                :as io]
              [source-code-documentation.core.config :as core.config]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn options-prototype
  ; @ignore
  ;
  ; @param (map) options
  ;
  ; @return (map)
  ; {:filename-pattern (regex pattern)
  ;  :output-path (string)
  ;  :previews-path (string)
  ;  :source-paths (strings in vector)}
  [options]
  (merge {:filename-pattern core.config/DEFAULT-FILENAME-PATTERN}
         (-> options (update :output-path   io/valid-absolute-path)
                     (update :previews-path io/valid-absolute-path)
                     (update :source-paths  vector/->items io/valid-absolute-path))))
