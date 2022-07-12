-- QUERY: Number of violations
-- Problem Statement: Output the number of violations by year in ascending order
-- https://platform.stratascratch.com/coding/9728-inspections-that-resulted-in-violations?code_type=3
-- TAGS: group_by, order 

SELECT
    YEAR(inspection_date) AS year,
    COUNT(violation_id) AS number_of_violations
FROM
    sf_restaurant_health_violations
WHERE
    business_name = 'Roxanne Cafe'
    AND violation_id IS NOT NULL
GROUP BY
    YEAR(inspection_date)
ORDER BY
    number_of_violations ASC;

-- ***************************************************************************************************************************