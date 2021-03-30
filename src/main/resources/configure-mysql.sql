# connect to mysql and run as root user
#Create Databases
CREATE DATABASE dev;

#Create database service accounts
CREATE USER 'dev_user'@'localhost' IDENTIFIED BY 'root';
CREATE USER 'dev_user'@'%' IDENTIFIED BY 'root';

#Database grants
GRANT SELECT ON dev.* to 'dev_user'@'localhost';
GRANT INSERT ON dev.* to 'dev_user'@'localhost';
GRANT DELETE ON dev.* to 'dev_user'@'localhost';
GRANT UPDATE ON dev.* to 'dev_user'@'localhost';
