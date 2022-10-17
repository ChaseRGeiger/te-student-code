-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)
SELECT title 
FROM movie AS m 
JOIN person AS p ON m.director_id = p.person_id
JOIN collection AS c ON m.collection_id = c.collection_id
WHERE c.collection_name = 'Star Wars Collection' AND person_name != 'George Lucas'
ORDER BY title;
