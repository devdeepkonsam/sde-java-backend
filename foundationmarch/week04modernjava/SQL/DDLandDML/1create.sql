CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    class VARCHAR(5) NOT NULL,
    address VARCHAR(255) NOT NULL
);

CREATE TABLE marks (
    student_id INT PRIMARY KEY,
    english INT NOT NULL,
    maths INT NOT NULL,
    physics INT NOT NULL,
    chemistry INT NOT NULL,
    biology INT NOT NULL
);