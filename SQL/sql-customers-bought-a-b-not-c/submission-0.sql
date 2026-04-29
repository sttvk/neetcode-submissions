-- Write your query below
SELECT *
FROM customers AS c
WHERE customer_id IN (SELECT customer_id FROM orders WHERE product_name = 'A')
  AND customer_id IN (SELECT customer_id FROM orders WHERE product_name = 'B')
  AND customer_id NOT IN (SELECT customer_id FROM orders WHERE product_name = 'C' AND customer_id IS NOT NULL)
ORDER BY c.customer_name;