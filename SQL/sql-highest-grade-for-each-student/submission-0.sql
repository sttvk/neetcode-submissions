-- Write your query below
SELECT DISTINCT ON (student_id) 
    student_id, 
    exam_id, 
    score
FROM exam_results
-- Crucial: The ORDER BY must start with the column in DISTINCT ON
ORDER BY student_id, score DESC, exam_id ASC;