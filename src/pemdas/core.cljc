(ns pemdas.core)

(loop [[f & r] '(5 + 4 / 4 ** 3) s 0]
  (case f
    \( (recur r (inc s))
    \) (recur r (dec s))
    nil (prn "DONE")
    (recur r s)))

(defn infix [[l op & r]]
  (if r
    (list op l (infix r))
    l))

(defn md [[l op & r]]
  (if r
    (list op l (infix r))
    l))

(defn as [[l op & r]]
  (if r
    (list op l (infix r))
    l))

(infix '(5 + 4 / 4 - 3))
(md '(5 + 4 / 4 - 3))
(as '(5 + 4 / 4 - 3))

(let [[l x & r] '(5 + 4 / 4 - 3)]
  r)