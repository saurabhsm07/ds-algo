-- Problem Statement: Find the 3-month rolling average of total revenue from purchases given a table with users, their purchase amount, and date purchased
-- https://platform.stratascratch.com/coding/10314-revenue-over-time?code_type=3
-- Tags: window, avg, group_by, rolling_avg, windo_with_groupby, CTE

-- APPROACH 1: CTE with grouped data (query 1), second query for window function 
WITH revenue_CTE AS (
    SELECT
        CASE

        END AS month_year,
        SUM(
            CASE
                WHEN purchase_amt > 0 THEN purchase_amt
                ELSE 0
            END
        ) AS revenue 
    -- ,sum(purchase_amt) as revenue_with_returns -- edge case test
    FROM
        amazon_purchases
    GROUP BY
        month_year
)

SELECT
    *,
    AVG(revenue) OVER(
        ORDER BY month_year 
        ROWS BETWEEN 3 PRECEDING AND CURRENT ROW
    ) AS rollowing_3_month_avg
FROM
    revenue_CTE 
    
-- APPROACH 2: GROUP BY and WINDOW function in the first query

select
    Case
        when month(created_at) < 10 Then concat(year(created_at), '-0', month(created_at))
        else concat(year(created_at), '-', month(created_at))
    End as month_year,
    sum(
        Case
            When purchase_amt > 0 Then purchase_amt
            else 0
        End
    ) as revenue,
    avg(
        sum(
            Case
                When purchase_amt > 0 Then purchase_amt
                else 0
            End
        )
    ) over(
        order by
            Case
                when month(created_at) < 10 Then concat(year(created_at), '-0', month(created_at))
                else concat(year(created_at), '-', month(created_at))
            END 
        ROWS BETWEEN 3 PRECEDING AND CURRENT ROW
    ) as rolling_average,
    -- sum(purchase_amt) as revenue_with_returns -- edge case test
from
    amazon_purchases
group by
    month_year