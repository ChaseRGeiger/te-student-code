-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)
SELECT DISTINCT(person_name)
FROM person AS p
JOIN movie_actor AS a ON p.person_id = a.actor_id
JOIN movie AS m ON a.movie_id = m.movie_id
JOIN collection AS c ON m.collection_id = c.collection_id
WHERE c.collection_name = 'Back to the Future Collection'
ORDER BY person_name;
