-- Problem Statement: Given a table of purchases by date, calculate the month-over-month percentage change in revenue
-- https://platform.stratascratch.com/coding/10319-monthly-percentage-difference
-- Tag
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