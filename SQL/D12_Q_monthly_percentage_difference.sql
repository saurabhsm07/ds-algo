-- Problem Statement: Given a table of purchases by date, calculate the month-over-month percentage change in revenue
-- https://platform.stratascratch.com/coding/10319-monthly-percentage-difference
-- Tags: window, window_lag, window_inline_groupby, segmented_percent

With CTE as (
    select
        CASE
            WHEN Month(created_at) < 10 THEN CONCAT(Year(created_at), '-0', Month(created_at))
            ELSE CONCAT(Year(created_at), '-', Month(created_at))
        END as month,
        sum(value) as total_revenue -- (round(sum(value) / (lag(sum(value),1) over(order by CONCAT(Year(created_at),'-0',Month(created_at)))) * 100, 2) - 100) as monthly_percent_diff_inline
    from
        sf_transactions
    group by
        month
)

select
    *,
    (
        round(
            total_revenue / (
                lag(total_revenue, 1) over(
                    order by
                        month
                )
            ) * 100,
            2
        ) - 100
    ) as monthly_percent_diff
from
    CTE