-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later, sorted alphabetically.
-- (6 rows)
SELECT DISTINCT(genre_name)
FROM genre AS g
JOIN movie_genre AS q ON g.genre_id = q.genre_id
JOIN movie AS m ON q.movie_id = m.movie_id
JOIN movie_actor AS a ON m.movie_id = a.movie_id
JOIN person AS p ON a.actor_id = p.person_id
WHERE p.person_name = 'Robert De Niro' AND m.release_date > '01/01/2010'
ORDER BY genre_name;
