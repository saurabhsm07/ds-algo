-- QUERY: Top 5 States With 5 Star Businesses
-- Problem Statement: Find the top 5 states with the most 5 star businesses
-- https://platform.stratascratch.com/coding/10046-top-5-states-with-5-star-businesses?code_type=3
-- TAGS: window, group_by, groupby_with_window 

WITH CTE AS (
    SELECT
        state,
        COUNT(business_id) AS 5_star_busi,
        DENSE_RANK() OVER(
            ORDER BY
                COUNT(business_id) DESC
        ) AS state_rank
    FROM
        yelp_business
    WHERE
        stars = 5
    GROUP BY
        state
)

SELECT
    state,
    5_star_busi
FROM
    CTE
WHERE
    state_rank < 5
ORDER BY
    state_rank ASC,
    state ASC