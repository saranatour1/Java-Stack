/*
Enter your query here.
*/
-- TRIANGLES
SELECT IF(
    (t.a + t.b <= t.c) OR (t.a + t.c <= t.b) OR (t.c + t.b <= t.a), 
    "Not A Triangle",
        IF(
            (t.a = t.b) AND (t.a = t.c), 
               "Equilateral",
    
          IF(
              (t.a = t.c) OR (t.a = t.b) OR (t.c = t.b),
              "Isosceles", 
              "Scalene"))) as types
FROM TRIANGLES t;
