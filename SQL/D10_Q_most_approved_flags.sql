-- Problem Statement: Which user flagged the most distinct videos that ended up approved by YouTube
-- https://platform.stratascratch.com/coding/2104-user-with-most-approved-flags
-- Tags: inner_query, window_with_join, group_by

WITH CTE as (
    SELECT
        user_fullname,
        sum(row_no) as total_unique_flags
    FROM
        (
            SELECT
                concat(uf.user_firstname, ' ', uf.user_lastname) as user_fullname,
                uf.video_id,
                fr.reviewed_by_yt,
                row_number() over(
                    partition by concat(uf.user_firstname, ' ', uf.user_lastname),
                    uf.video_id
                ) as row_no
            FROM
                user_flags uf
                JOIN flag_review as fr ON uf.flag_id = fr.flag_id
            WHERE
                fr.reviewed_by_yt = 1
            ORDER BY
                user_fullname,
                video_id
        ) inner_q
    WHERE
        row_no = 1
    GROUP BY
        user_fullname
)
SELECT
    user_fullname
FROM
    CTE
WHERE
    total_unique_flags = (
        SELECT
            max(total_unique_flags)
        FROM
            CTE
    )