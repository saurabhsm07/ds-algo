-- Problem Statement: How much net time separates Chris Doe from the 10th best net time (in ascending order)? Avoid gaps in the ranking calculation. 
-- Output absolute net time difference.
-- https://platform.stratascratch.com/coding/2065-time-from-10th-runner?code_type=1
-- tags: CTE, inner_query

WITH CTE as (
    SELECT
        net_time,
        dense_rank() over(
            ORDER BY
                net_time
        ) AS pos
    FROM
        marathon_male
    ORDER BY
        net_time
)

SELECT
    person_name,
    abs(
        net_time - (
            SELECT
                net_time
            FROM
                CTE
            WHERE
                CTE.pos = 10
            LIMIT
                1
        )
    ) AS difference_from_10
FROM
    marathon_male
WHERE
    person_name = 'Chris Doe';