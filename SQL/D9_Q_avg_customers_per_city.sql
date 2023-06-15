-- Problem Statement: Write a query that will return all cities with more customers than the average number of  customers of all cities that have at least one customer
-- https://platform.stratascratch.com/coding/2055-average-customers-per-city
-- Tags: CTE, inner_query, multiple_inner_queries, segmented_avg, JOIN, multiple_join, window

WITH C
        linkedin_customers cust_tbl
        JOIN linkedin_city city_tbl ON cust_tbl.city_id = city_tbl.id
        JOIN linkedin_country country_tbl ON country_tbl.id = city_tbl.country_id
)

SELECT
    country_name,
    city_name,
    num_of_customers
FROM
    (
        SELECT
            *,
            count(1) over(partition by city_name) as num_of_customers,
            count(1) over() / (
                SELECT
                    count(distinct city_name)
                FROM
                    CCC_CTE
            ) as avg_customers_across_cities
        FROM
            CCC_CTE
    ) h_bl
WHERE
    num_of_customers >= avg_customers_across_cities