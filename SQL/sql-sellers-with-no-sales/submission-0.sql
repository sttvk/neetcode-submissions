-- Write your query below
select s.seller_name from seller s
left join orders o
on s.seller_id = o.seller_id
AND o.sale_date >= '2020-01-01'
AND o.sale_date < '2021-01-01'
where o.order_id is null
order by seller_name asc;