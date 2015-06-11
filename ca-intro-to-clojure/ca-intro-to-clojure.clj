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
(println "\ninc will increment a, but the value of a won't change. immutability!")
(println (str "inc a => " (inc a) ) )
; but the actual value of a won't change: concept of immutability
(println (str "a => " a) )

; functions
(println "\ndefining a function using defn")
(defn hypothenuse [a b]
  (
    let [a (* a a)
         b (* b b)
         c (+ a b)]
    (Math/sqrt c)
  )
)
(defn hypothenuse [a b] (Math/sqrt (+ (* a a) (* b b) ) ) )
(println "using defined function hypothenuse 9 12:" (hypothenuse 9 12) )
(println "using defined function hypothenuse 4  8: " (hypothenuse 4  8) )

; define an anonymous function
(def hypoth (fn [a b] (Math/sqrt (+ (* a a) (* b b) ) ) ) )
(println (str "hypoth function uses fn " (hypoth 4 8) ) )

; defining a greetings function
(println "\ndefining a greetings function")
(defn greetings [name] (println "Hallo " name) )
(greetings "Guido")
; define a higher order function (HOF) which will generate a greeting function
(println "\ndefine a higher order function (HOF) which will generate a greeting function")
(defn make-greeting [greeting]
  (
    fn [name] (println (str greeting " " name "!") )
  )
)
(def greetings-de (make-greeting "Guten Tag") )
(def greetings-fr (make-greeting "Bonjour") )
(def greetings-es (make-greeting "Hola") )
(greetings-de "Guido")
(greetings-fr "Guido")
(greetings-es "Guido")

; Using guards to test arguments
(defn make-greeting
  [greeting]
  {:pre  [(string? greeting)(< (count greeting) 10)]} ; pre-validation guard
  {:post [(string? greeting)]} ; result validation
  (fn [name] (str greeting " " name "!") )
)
(def greetings-de (make-greeting "Guten Tag") )
(greetings-de "Guido")
(greetings-de "Mississippi")

; using metadata
(defn make-greeting
  "Takes a single arg (a greeting)  and returns a function which also
   takes a single argument (a name). When the returned function is called, it
   prints out a greeting message via println and returns nil"
  [greeting]
  (fn [name] (println (str greeting " " name "!") ) )
)
(def greetings-fr (make-greeting "Bonsoir"))
(greetings-fr "M. Rigot")
