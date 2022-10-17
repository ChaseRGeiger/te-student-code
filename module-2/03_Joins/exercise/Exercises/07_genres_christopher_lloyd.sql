-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.
SELECT DISTINCT(genre_name)
FROM genre AS g
JOIN movie_genre AS q ON g.genre_id = q.genre_id
JOIN movie_actor AS a ON q.movie_id = a.movie_id
JOIN person AS p ON a.actor_id = p.person_id
WHERE p.person_name = 'Christopher Lloyd'
ORDER BY genre_name;


