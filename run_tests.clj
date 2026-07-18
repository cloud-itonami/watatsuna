(require '[clojure.test :as t])
(def suites '[watatsuna.methods.test-analyze watatsuna.methods.test-autorun
              watatsuna.methods.test-ingest watatsuna.methods.test-kotoba-cid
              watatsuna.methods.test-pipeline-cid watatsuna.methods.test-plan
              watatsuna.viz.test-build-viz-data watatsuna.murakumo-test
              watatsuna.repository-contract-test])
(apply require suites)
(let [{:keys [fail error] :as r} (apply t/run-tests suites)]
  (println (select-keys r [:test :pass :fail :error]))
  (when (pos? (+ fail error)) (System/exit 1)))
