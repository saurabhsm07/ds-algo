-- Problem Statement: Write a query that'll identify returning active users
-- https://platform.stratascratch.com/coding/10322-finding-user-purchases?code_type=3
-- Tags: CTE, case, window, window_lag, lag, inner_query

WITH transact_CTE as(
    Select
        Case
            when COALESCE(DATEDIFF(created_at, last_transact_date), 100) < 7 then user_id
            else Null
        end as u_id
    from
        (
            select
                user_id,
                created_at,
                lag(created_at) over(
                    partition by user_id
                    order by
                        created_at
                ) as last_transact_date
            from
                amazon_transactions
        ) cte
)

select
    distinct u_id
from
    transact_CTE
where
    u_id is not Null;