-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT *
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. 
-- The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT * 
FROM state
ORDER BY census_region DESC, state_name ASC;


-- The biggest park by area
SELECT park_name, area
FROM park
ORDER BY area DESC;


-- LIMITING RESULTS
SELECT park_name, area
FROM park
ORDER BY area DESC
LIMIT 1;


-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT (CURRENT_DATE - date_established) AS age_in_days, park_name
FROM park
ORDER BY age_in_days DESC, park_name
LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
-- In this format:  city_name (state_abbreviation)
SELECT (city_name || ' (' || state_abbreviation || ')') AS city_state
FROM city
ORDER BY city_name;

-- The all parks by name and date established.
-- Name: park_name Date Established: date_established
SELECT ('Name: ' || park_name || ' Date Established: ' || date_established) AS park_name_and_date, has_camping
FROM park
ORDER BY area DESC;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
-- census_region : state_name
SELECT (census_region || ' : ' || state_name) AS region_and_state
FROM state
WHERE census_region IN ('West', 'Midwest')
ORDER BY census_region, state_name;


-- NUMERIC FUNCTIONS
SELECT round(area / 3, 2) FROM park;

-- AGGREGATE FUNCTIONS

-- Average population across all the states. 
-- Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_state_population
FROM state;

-- rounding the average
SELECT round(AVG(population), 2) AS avg_state_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS west_south_population
FROM state
WHERE census_region IN ('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(*)
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
-- When using a column name, null rows in that column are not included
-- in the count
SELECT COUNT(state_nickname), COUNT(*)
FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest_park, MAX(area) AS largest_park
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT COUNT(city_name) AS cities, state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY cities DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area)
FROM park
GROUP BY has_camping;

SELECT has_camping, round(AVG(area))
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) as total_city_population
FROM city
GROUP BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
-- Once an aggregate is added, can include any other aggregate in the select, 
-- but can only include a column if it is in the GROUP BY
SELECT state_abbreviation, MIN(population) as smallest_city_population, 
	MAX(population) as largest_city_population, COUNT(city_name) AS number_of_cities, 
	AVG(population) AS avg_city_population, SUM(population) AS total_city_population
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city_population;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population
FROM city
ORDER BY city_name
LIMIT 10 OFFSET 10;

SELECT city_name, population
FROM city
ORDER BY city_name
OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY;

-- SUBQUERIES

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT COUNT(city_name) AS cities, (
		SELECT state_name 
		FROM state 
		WHERE state.state_abbreviation = city.state_abbreviation
	)
FROM city
GROUP BY state_abbreviation
ORDER BY cities DESC;


-- Include the names of the smallest and largest parks
SELECT park_name, area
FROM park p,
 (
	SELECT MIN(area) AS smallest_park, MAX(area) AS largest_park
	FROM park
 ) AS subquery
WHERE p.area = subquery.smallest_park OR p.area = subquery.largest_park;

-- List the capital cities for the states in the Northeast census region.
SELECT * 
FROM city 
WHERE city_id IN (
	SELECT capital 
	FROM state 
	WHERE census_region = 'Northeast'
);

