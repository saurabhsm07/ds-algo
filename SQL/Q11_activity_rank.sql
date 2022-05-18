-- Problem Statement: Find the email activity rank for each user
-- https://platform.stratascratch.com/coding/10351-activity-ran
-- Tags: window, group by, widow_with_group_by

select
    from_user,
    count(1) as total_emails,
    rank() over(
        order by
            count(1) desc,
            from_user asc
    )
from
    google_gmail_emails
group by
    from_user;