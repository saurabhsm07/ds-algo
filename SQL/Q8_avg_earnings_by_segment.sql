-- Problem Statement: Write a query that returns average earnings per order segmented by weekday and hour. 
-- For calculating the time period use 'Customer placed order datetime' field. 
-- Earnings value is 'Order total' field
-- https://platform.stratascratch.com/coding/2034-avg-earnings-per-weekday-and-hour?code_type=1
-- Tags: query_precedence, select_before_groupby

select
    dayofweek(customer_placed_order_datetime) as order_day,
    hour(customer_placed_order_datetime) as order_hour,
    customer_placed_order_datetime,
    avg(order_total),
    -- count(*),
    -- max(order_total)
from
    doordash_delivery
group by
    order_day,
    order_hour
order by
    order_day,
    order_hour;