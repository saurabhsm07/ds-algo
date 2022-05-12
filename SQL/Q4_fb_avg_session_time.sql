-- Problem Statement: A session is defined as the time difference between a page_load and page_exit
-- https://platform.stratascratch.com/coding/10352-users-by-avg-session-time?code_type=1

WITH session_CTE as (
    select
        user_id,
        date(timestamp) as date,
        action,
        max(timestamp) as max_timestamp,
        min(timestamp) as min_timestamp
    from
        facebook_web_log
    where
        action = 'page_load'
        or action = 'page_exit'
    group by
        user_id,
        date,
        action
    order by
        user_id
)

select
    pl.user_id,
    avg(pe.min_timestamp - pl.max_timestamp) as avg_session_time
from
    (
        select
            *
        from
            session_CTE
        where
            action = 'page_load'
    ) pl
    inner join (
        select
            *
        from
            session_CTE
        where
            action = 'page_exit'
    ) pe on pe.user_id = pl.user_id
    and pe.date = pl.date
group by
    pl.user_id