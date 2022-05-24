-- QUERY: popularity_percentage
-- Problem Statement: Find the popularity percentage for each user on Meta/Facebook
-- https://platform.stratascratch.com/coding/10284-popularity-percentage?code_type=3
-- Tags: union, group_by, inner_query, CTE 

with CTE as (
    select
        user1,
        user2
    from
        facebook_friends
    union
    select
        user2,
        user1
    from
        facebook_friends
)

select
    user1 as user_id,
    count(1) / (
        select
            count(distinct user1)
        from
            CTE
    ) * 100 as popularity_percentage
from
    CTE
group by
    user_id
order by
    user_id

-- ***************************************************************************************************************************