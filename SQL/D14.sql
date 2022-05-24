-- QUERY 1: top_percentile_fraud
-- Problem Statement: Your objective is to identify the top 5 percentile of claims from each state. Your output should be policy number, state, claim cost, and fraud score.
-- https://platform.stratascratch.com/coding/10303-top-percentile-fraud?code_type=1
-- Tags: percent_rank, top_x%, x_percentile, window

SELECT
    policy_num,
    state,
    claim_cost,
    fraud_score,
    percentile_score
FROM
    (
        SELECT
            *,
            percent_rank() over(
                partition BY state
                ORDER BY
                    fraud_score
            ) * 100 AS percentile_score
        FROM
            fraud_score
    ) inner_q
WHERE
    percentile_score > 95;

-- ***************************************************************************************************************************
-- QUERY 2: naïve_forecast
-- Problem Statement: develop a naïve forecast for a new metric called "distance per dollar",
--  defined as the (distance_to_travel/monetary_cost) in our dataset and measure its accuracy
-- https://platform.stratascratch.com/coding/10313-naive-forecasting?code_type=3
-- Tags: window_with_group_by, lag, window_lag, RMS, root_mean_square, window, uber

WITH naive_forecast_CTE AS (
    SELECT
        SUBSTRING_INDEX(request_date, '-', 2) AS month_year,
        SUM(distance_to_travel) / sum(monetary_cost) AS distance_per_dollar,
        LAG(SUM(distance_to_travel) / sum(monetary_cost), 1) OVER(
            ORDER BY
                SUBSTRING_INDEX(request_date, '-', 2)
        ) as naive_forecast
    FROM
        uber_request_logs
    GROUP BY
        month_year
)

select
    ROUND(
        SQRT(
            AVG(
                (distance_per_dollar - naive_forecast) *(distance_per_dollar - naive_forecast) --square function is not working for some reason
            )
        ),
        2
    )
from
    naive_forecast_CTE