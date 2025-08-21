create database Test888;
use Test888;

CREATE TABLE Course (
                        code VARCHAR(10) PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        credit INT NOT NULL
);

INSERT INTO Course (code, name, credit) VALUES
                                            ('PRJ101', 'Core JAVA', 3),
                                            ('CSC102', 'Data Structures', 4),
                                            ('MTH103', 'Linear Algebra', 3);
