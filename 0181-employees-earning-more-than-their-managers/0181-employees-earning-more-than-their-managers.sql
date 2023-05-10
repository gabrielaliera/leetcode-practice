# Write your MySQL query statement below
SELECT a.name as Employee
FROM Employee AS a JOIN Employee AS b
    ON a.managerId = b.id AND
    a.salary > b.salary