-- QUERY: Host Popularity Rental Prices
-- Problem Statement: Find the minimum, average, maximum rental prices for each host’s popularity rating.
-- https://platform.stratascratch.com/coding/9632-host-popularity-rental-prices?code_type=3
-- TAGS: window, cte, group_by, unique_key, partition_by

WITH CTE AS (
    SELECT
        row_number() OVER(
            PARTITION BY -- id,
            room_type,
            host_since,
            zipcode,
            number_of_reviews
        ) AS host_id,
        id,
        price,
        room_type,
        host_since,
        zipcode,
        number_of_reviews,
        CASE
            WHEN number_of_reviews = 0 THEN 'NEW'
            WHEN number_of_reviews > 0
            AND number_of_reviews <= 5 THEN 'RISING'
            WHEN number_of_reviews > 5
            AND number_of_reviews <= 15 THEN 'TRENDING UP'
            WHEN number_of_reviews > 15
            AND number_of_reviews <= 40 THEN 'POPULAR'
            ELSE 'HOT'
        END AS popularity_rating
    FROM
        airbnb_host_searches
    ORDER BY
        popularity_rating
)

SELECT
    popularity_rating,
    -- host_id,
    -- number_of_reviews,
    MIN(price) AS min_price,
    AVG(price) AS avg_price,
    MAX(price) AS max_price
FROM
    CTE
WHERE
    host_id = 1
GROUP BY
    popularity_rating