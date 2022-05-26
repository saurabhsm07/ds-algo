-- QUERY: Comments Distribution
-- Problem Statement: Write a query to calculate the distribution of comments by the count of users
-- https://platform.stratascratch.com/coding/10297-comments-distribution?code_type=3
-- TAGS: window, CTE, filter_join, window_groupby

WITH CTE AS (
    SELECT
        users.id,
        users.name,
        users.joined_at,
        comments.body,
        comments.created_at
    FROM
        fb_users users
        LEFT JOIN fb_comments comments ON users.id = comments.user_id
    WHERE
        users.joined_at >= '2018-01-01'
        AND users.joined_at <= '2020-12-31'
        AND MONTH(comments.created_at) = 1
        AND YEAR(comments.created_at) = 2020
        AND comments.created_at >= users.joined_at
)

SELECT
    num_of_comments,
    COUNT(*) AS user_count
FROM
    (
        SELECT
            *,
            count(*) Over(
                PARTITION BY id
                ORDER BY
                    name
            ) AS num_of_comments
        FROM
            CTE
        ORDER BY
            num_of_comments
    ) inner_query
GROUP BY
    num_of_comments

-- ***************************************************************************************************************************