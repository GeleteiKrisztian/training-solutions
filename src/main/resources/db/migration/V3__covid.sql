CREATE TABLE `citizens` (
citizen_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
citizen_name VARCHAR(200) NOT NULL,
zip CHAR(4) NOT NULL,
age BIGINT NOT NULL,
email VARCHAR(200) UNIQUE,
taj VARCHAR(10) UNIQUE,
number_of_vaccination BIGINT DEFAULT (0),
last_vaccination DATETIME
);

CREATE TABLE `vaccinations` (
vaccination_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
citizen_id_f BIGINT NOT NULL,
vaccination_date DATETIME NOT NULL,
status VARCHAR(15),
note VARCHAR(200),
vaccination_type varchar(20),
CONSTRAINT `vaccinations_to_citizens` FOREIGN KEY (citizen_id_f) REFERENCES citizens (citizen_id)
ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE cities (
city_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
zip VARCHAR(4) NOT NULL,
city VARCHAR(40) NOT NULL,
city_part VARCHAR(40)
)
