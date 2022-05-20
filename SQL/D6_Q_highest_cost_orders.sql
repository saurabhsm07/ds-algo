-- Problem Statement: find the customer with the highest daily total order cost between 2019-02-01 to 2019-05-01
-- https://platform.stratascratch.com/coding/9915-highest-cost-orders?code_type=1
-- Tags: CTE, inner_query, window_functions, rank

with
    CTE
    as
    (
        select c.id,
            c.first_name,
            o.order_date,
            o.total_order_cost
        from customers c inner join orders o on c.id = o.cust_id
        where order_date > '2019-02-01' and order_date <= '2019-05-01'
        order by order_date
    )

select first_name,
    order_date,
    daily_order_cost
from ( select first_name,
        order_date,
        sum(total_order_cost) as daily_order_cost,
        rank() over(order by (sum(total_order_cost)) desc)
    from CTE
    group by first_name, order_date) t
where rank = 1
order by order_date

