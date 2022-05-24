-- QUERY: popularity_percentage
-- Problem Statement: Find the popularity percentage for each user on Meta/Facebook
-- https://platform.stratAScratch.com/coding/10284-popularity-percentage?code_type=3
-- Tags: UNION, group_by, inner_query, CTE 

WITH CTE AS (
    SELECT
        user1,
        user2
    FROM
        facebook_friends
    UNION
    SELECT
        user2,
        user1
    FROM
        facebook_friends
)

SELECT
    user1 AS user_id,
    count(1) / (
        SELECT
            count(DISTINCT user1)
        FROM
            CTE
    ) * 100 AS popularity_percentage
FROM
    CTE
GROUP BY
    user_id
ORDER BY
    user_id 
    
-- ***************************************************************************************************************************
-- QUERY: Price Of A Handyman
-- Problem Statement:Find the price that a small handyman business is willing to pay per employee
-- https://platform.stratAScratch.com/coding/9815-price-of-a-handyman?code_type=3
-- Tags: group_by, inner_query, mode_calculation

SELECT
    avg_earnings AS cost_per_employee_mode
FROM
    (
        SELECT
            adwords_earnings,
            sum(adwords_earnings) / sum(n_employees) AS avg_earnings
        FROM
            google_adwords_earnings
        WHERE
            business_type = 'handyman'
            AND n_employees <= 10
        GROUP BY
            adwords_earnings
    ) inner_df
GROUP BY
    avg_earnings
ORDER BY
    count(1) DESC
LIMIT
    1