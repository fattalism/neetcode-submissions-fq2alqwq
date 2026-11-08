-- Write your query below
SELECT customer_id, customer_name
FROM customers
WHERE customers.customer_id IN (
    SELECT customer_id
    FROM orders
    WHERE product_name = 'A'
) AND customers.customer_id IN (
    SELECT customer_id
    FROM orders
    WHERE product_name = 'B'
) AND NOT customers.customer_id IN (
    SELECT customer_id
    FROM orders
    WHERE product_name = 'C'
)
ORDER BY customers.customer_name;