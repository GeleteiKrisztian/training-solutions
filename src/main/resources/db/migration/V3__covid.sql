CREATE TABLE `citizens` (
citizen_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
citizen_name VARCHAR(200) NOT NULL,
zip CHAR(4) NOT NULL,
age BIGINT NOT NULL,
email VARCHAR(200),
taj VARCHAR(10),
number_of_vaccination BIGINT,
last_vaccination DATETIME
);

CREATE TABLE `vaccinations` (
vaccination_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
citizen_id_f BIGINT NOT NULL,
vaccination_date DATETIME NOT NULL,
status VARCHAR(10),
note VARCHAR(200),
vaccination_type varchar(20),
CONSTRAINT `vaccinations_to_citizens` FOREIGN KEY (citizen_id_f) REFERENCES citizens (citizen_id)
ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE cities (
city_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
order_id INT NOT NULL,
shipment_date date NOT NULL
);

CREATE TABLE IF NOT EXISTS `zip_and_cities` (
  `zip` int(10) unsigned DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `city_part` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
