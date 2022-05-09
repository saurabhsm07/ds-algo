-- Problem Statement: 
-- Output share of US users that are active. Active users are the ones with an "open" status in the table.
-- https://platform.stratascratch.com/coding/2005-share-of-active-users?code_type=1
-- Solution:
with CTE as (
    select
        distinct country,
        sum(1) over(partition by country) as t,
        (
            (sum(1) over(partition by country) * 1.0) / sum(1) over()
        ) as share
    from
        fb_active_users
    where
        status = 'open'
)

select
    share
from
    CTE
where
    country = 'USA'