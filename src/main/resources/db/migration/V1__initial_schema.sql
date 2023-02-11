create table if not exists employees (
    employee_id serial primary key,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(20) not null unique

);
create table if not exists departments (
    department_id serial primary key,
    department_name varchar(20) not null,
    department_description varchar(50)
);
CREATE TABLE if not exists employee_department (
   employee_id serial NOT NULL,
   department_id serial NOT NULL,
   PRIMARY KEY (employee_id, department_id),
   FOREIGN KEY (employee_id)
       REFERENCES employees (employee_id),
   FOREIGN KEY (department_id)
       REFERENCES departments (department_id)
);

-- INSERT INTO employees(first_name, last_name, email)
-- VALUES ('Spencer', 'Craig', 'email');

-- INSERT INTO departments(department_name, department_description)
-- VALUES ('HR', 'Dealing with people');

-- INSERT INTO employee_department(employee_id, department_id)
-- VALUES (1, 1);

INSERT INTO
    employees (first_name, last_name, email)
VALUES
    ('Spencer', 'Craig', 'spenny@gmail.com'),
    ('Jodie', 'Craig', 'jodie@gmail.com'),
    ('Nancy', 'Craig', 'nancy@gmail.com'),
    ('Charlie', 'Craig', 'charles@gmail.com');

INSERT INTO
    departments (department_name, department_description)
VALUES
    ('Human Resources', 'Dealing with people'),
    ('Systems Maintenance', 'Maintaining systems');

INSERT INTO
    employee_department (employee_id, department_id)
VALUES
    (1,2),
    (2,2),
    (3,2),
    (4,1);


