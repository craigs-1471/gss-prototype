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