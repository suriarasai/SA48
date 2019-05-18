DROP TABLE IF EXISTS EMPLOYEE_PROJECT;
DROP TABLE IF EXISTS EMP_PHONE;
DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS PHONE;
DROP TABLE IF EXISTS PARKING_SPACE;
DROP TABLE IF EXISTS DEPARTMENT;
DROP TABLE IF EXISTS PROJECT;


                        
CREATE TABLE PHONE (ID INTEGER  NOT NULL AUTO_INCREMENT, 
                    TYPE VARCHAR(255), NUM VARCHAR(32), PRIMARY KEY (ID));

CREATE TABLE PARKING_SPACE (ID INTEGER  NOT NULL AUTO_INCREMENT,  
							LOT INTEGER, LOCATION VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE DEPARTMENT (ID INTEGER  NOT NULL AUTO_INCREMENT, 
                         NAME VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE PROJECT (ID INTEGER  NOT NULL AUTO_INCREMENT, 
                      NAME VARCHAR(255), PRIMARY KEY (ID));                            
CREATE TABLE EMPLOYEE (ID INTEGER NOT NULL AUTO_INCREMENT, 
                       NAME VARCHAR(255), SALARY BIGINT, 
                       PSPACE_ID INTEGER, 
                       DEPARTMENT_ID INTEGER, PRIMARY KEY (ID),
                       CONSTRAINT PSPACE_FK FOREIGN KEY (PSPACE_ID) REFERENCES PARKING_SPACE(ID),
                       CONSTRAINT DEPT_FK FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT (ID));

CREATE TABLE EMPLOYEE_PROJECT (PROJECTS_ID INTEGER NOT NULL, EMPLOYEES_ID INTEGER NOT NULL,
                               CONSTRAINT PROJECTS_FK FOREIGN KEY (PROJECTS_ID) REFERENCES PROJECT (ID),
                               CONSTRAINT EMPLOYEES_FK FOREIGN KEY (EMPLOYEES_ID) REFERENCES EMPLOYEE (ID),
                               PRIMARY KEY (PROJECTS_ID, EMPLOYEES_ID));
                               
CREATE TABLE EMP_PHONE (PHONE_ID INTEGER NOT NULL, EMP_ID INTEGER NOT NULL,
                        CONSTRAINT PHONE_FK FOREIGN KEY (PHONE_ID) REFERENCES PHONE (ID),
                        CONSTRAINT EMP_FK FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEE (ID), 
                        PRIMARY KEY (PHONE_ID, EMP_ID));


INSERT INTO `sa48`.`department` (`NAME`) VALUES ('Accounts');
INSERT INTO `sa48`.`department` (`NAME`) VALUES ('Administration');
INSERT INTO `sa48`.`department` (`NAME`) VALUES ('Human Resources');
INSERT INTO `sa48`.`department` (`NAME`) VALUES ('Engineering');
INSERT INTO `sa48`.`department` (`NAME`) VALUES ('Security');
INSERT INTO `sa48`.`department` (`NAME`) VALUES ('Sales');
INSERT INTO `sa48`.`department` (`NAME`) VALUES ('Marketing');
INSERT INTO `sa48`.`department` (`NAME`) VALUES ('Quality Control');

INSERT INTO `sa48`.`phone` (`TYPE`, `NUM`) VALUES ('Office', '65161111');
INSERT INTO `sa48`.`phone` (`TYPE`, `NUM`) VALUES ('Home', '63234444');
INSERT INTO `sa48`.`phone` (`TYPE`, `NUM`) VALUES ('Mobile', '7890678');

INSERT INTO `sa48`.`parking_space` (`LOT`, `LOCATION`) VALUES ('1', '29 Heng Mui Keng Terrace');
INSERT INTO `sa48`.`parking_space` (`LOT`, `LOCATION`) VALUES ('2', '29 Heng Mui Keng Terrace');
INSERT INTO `sa48`.`parking_space` (`LOT`, `LOCATION`) VALUES ('3', '29  Heng Mui Keng Terrace');
INSERT INTO `sa48`.`parking_space` (`LOT`, `LOCATION`) VALUES ('1', 'I Cube');
INSERT INTO `sa48`.`parking_space` (`LOT`, `LOCATION`) VALUES ('2', 'I Cube');
INSERT INTO `sa48`.`parking_space` (`LOT`, `LOCATION`) VALUES ('3', 'I Cube');
INSERT INTO `sa48`.`parking_space` (`LOT`, `LOCATION`) VALUES ('4', '29 Heng Mui Keng Terrace');
INSERT INTO `sa48`.`parking_space` (`LOT`, `LOCATION`) VALUES ('5', '29 Heng Mui Keng Terrace');
INSERT INTO `sa48`.`parking_space` (`LOT`, `LOCATION`) VALUES ('6', '29 Heng Mui Keng Terrace');


INSERT INTO `sa48`.`project` (`NAME`) VALUES ('ASP.Net MVC CA');
INSERT INTO `sa48`.`project` (`NAME`) VALUES ('Java Spring CA');
INSERT INTO `sa48`.`project` (`NAME`) VALUES ('Android Mobile CA');
INSERT INTO `sa48`.`project` (`NAME`) VALUES ('Advanced Development Project');

INSERT INTO `sa48`.`employee` (`NAME`, `SALARY`, `PSPACE_ID`, `DEPARTMENT_ID`) VALUES ('Dilbert', '5000', '1', '4');
INSERT INTO `sa48`.`employee` (`NAME`, `SALARY`, `PSPACE_ID`, `DEPARTMENT_ID`) VALUES ('Wally', '5000', '2', '4');
INSERT INTO `sa48`.`employee` (`NAME`, `SALARY`, `PSPACE_ID`, `DEPARTMENT_ID`) VALUES ('Alice', '5000', '3', '4');
INSERT INTO `sa48`.`employee` (`NAME`, `SALARY`, `PSPACE_ID`, `DEPARTMENT_ID`) VALUES ('Dogbert', '50000', '4', '2');
INSERT INTO `sa48`.`employee` (`NAME`, `SALARY`, `PSPACE_ID`, `DEPARTMENT_ID`) VALUES ('Catbert', '5000', '5', '3');
INSERT INTO `sa48`.`employee` (`NAME`, `SALARY`, `PSPACE_ID`, `DEPARTMENT_ID`) VALUES ('Ashok', '3000', '6', '6');
INSERT INTO `sa48`.`employee` (`NAME`, `SALARY`, `PSPACE_ID`, `DEPARTMENT_ID`) VALUES ('Ratbert', '4000', '7', '7');
INSERT INTO `sa48`.`employee` (`NAME`, `SALARY`, `PSPACE_ID`, `DEPARTMENT_ID`) VALUES ('Mordac', '2000', '8', '1');

INSERT INTO `sa48`.`emp_phone` (`PHONE_ID`, `EMP_ID`) VALUES ('1', '1');
INSERT INTO `sa48`.`emp_phone` (`PHONE_ID`, `EMP_ID`) VALUES ('2', '1');
INSERT INTO `sa48`.`emp_phone` (`PHONE_ID`, `EMP_ID`) VALUES ('3', '1');

INSERT INTO `sa48`.`employee_project` (`PROJECTS_ID`, `EMPLOYEES_ID`) VALUES ('1', '1');
INSERT INTO `sa48`.`employee_project` (`PROJECTS_ID`, `EMPLOYEES_ID`) VALUES ('1', '2');
INSERT INTO `sa48`.`employee_project` (`PROJECTS_ID`, `EMPLOYEES_ID`) VALUES ('1', '3');
INSERT INTO `sa48`.`employee_project` (`PROJECTS_ID`, `EMPLOYEES_ID`) VALUES ('1', '4');
INSERT INTO `sa48`.`employee_project` (`PROJECTS_ID`, `EMPLOYEES_ID`) VALUES ('2', '1');
INSERT INTO `sa48`.`employee_project` (`PROJECTS_ID`, `EMPLOYEES_ID`) VALUES ('3', '1');
INSERT INTO `sa48`.`employee_project` (`PROJECTS_ID`, `EMPLOYEES_ID`) VALUES ('4', '1');


