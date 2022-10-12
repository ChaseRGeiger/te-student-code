-- 6. The genres of "The Wizard of Oz" sorted in alphabetical order (A-Z).
-- (3 rows)
SELECT genre_name
FROM genre
JOIN movie_genre ON genre.genre_id = movie_genre.genre_id
JOIN movie ON movie_genre.movie_id = movie.movie_id
WHERE title LIKE 'The Wizard of OZ'
ORDER BY genre_name;


