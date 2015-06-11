; Basic printing and using operators such as + and *
(println "Hello Clojure!")
(println (+ 1 5) )
(println (+ (+ 1 2) (+ 5 5) ) )
(println "Calculating pythagorean:" (+ (* 4 4) (* 8 8 ) ) )

; let provides lexival scope by evaluating all expressions
; from its body and becomming the result of the final result
; (let [symbol value ...] body-expressions)
(println "Calculating pythagorean (with let):"
  (
    let [a 4 b 8]
    (+ (* a a) (* b b) )
  )
)

; def creates a var
(println "\ndef creates a var")
(def a 4)
(println a)

; using vars in a later compuations
(println "\nusing vars in a later compuations")
(def a 4)
(def b 8)
(println (+ (* a a) (* b b) ) )

; inc will increment a
(println "inc will increment a")
(println (inc a) )
