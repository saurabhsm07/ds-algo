-- Problem Statement: Write a query that returns the rate_type, loan_id and balance of each loan type, 
--    and a column that shows with what percentage the loan's balance contributes to the total balance among the loans of the same rate type.
-- https://platform.stratascratch.com/coding/2001-share-of-loan-balance?code_type=1

select
    rate_type,
    loan_id,
    balance,
    balance / sum(balance) over(partition by rate_type) * 100 as percent_share
from
    submissions
order by
    rate_type;