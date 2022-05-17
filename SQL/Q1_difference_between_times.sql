-- Problem Statement: You are asked to check if the interval between the two times is different for male and female runners. 
-- First, calculate the average absolute difference between the gun time and net time. 
-- Group the results by available genders (male and female). 
-- Output the absolute difference between those two values.
-- https://platform.stratascratch.com/coding/2064-difference-between-times?code_type=1
-- Tags: union, CTE, groupby

WITH
    marathon_CTE
    AS
    (
            SELECT *, 'male' AS gender
            FROM marathon_male
        UNION
            SELECT *, 'female' AS gender
            FROM marathon_female
    )

SELECT abs(max(actual_time) - min(actual_time))
FROM (SELECT avg(abs(gun_time - net_time)) AS actual_time
    FROM marathon_CTE
    GROUP BY gender) grouped_gender