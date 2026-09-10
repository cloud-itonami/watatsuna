(ns watatsuna.repository-contract-test
  (:require [clojure.edn :as edn] [clojure.java.io :as io]
            [clojure.test :refer [deftest is]]))
(deftest repository-boundary
  (let [c (edn/read-string (slurp "repository-contracts.edn"))]
    (is (= :edn (get-in c [:canonical :format])))
    (doseq [p ["manifest.edn" "schema.edn" "wire/manifest.jsonld"
               "wire/data/ingest/telegeography-sample.json"
               "wire/methods/test_ingest_golden.json" "wire/viz/cable-resilience.json"
               "wire/wasm/watatsuna-actor.meta.json"]] (is (.isFile (io/file p)) p))
    (doseq [p (:forbidden-root-paths c)] (is (not (.exists (io/file p))) p))))
