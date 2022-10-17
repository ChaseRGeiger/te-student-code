-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)
SELECT DISTINCT(person_name), birthday
FROM person AS p
JOIN movie_actor AS a ON p.person_id = a.actor_id
JOIN movie AS m ON a.movie_id = m.movie_id
WHERE p.birthday BETWEEN '01/01/1950' AND '12/31/1959' AND 
m.release_date BETWEEN '01/01/1985' AND '12/31/1985'
ORDER BY birthday;