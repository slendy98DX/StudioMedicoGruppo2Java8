-- MySQL Script generated by MySQL Workbench
-- Mon Feb 27 17:22:30 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema studio_medico_progetto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema studio_medico_progetto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `studio_medico_progetto` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema studio_medico_progetto
-- -----------------------------------------------------
USE `studio_medico_progetto` ;

-- -----------------------------------------------------
-- Table `studio_medico_progetto`.`doctor_seq`
-- -----------------------------------------------------

CREATE TABLE `doctor_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB

-- -----------------------------------------------------
-- Table `studio_medico_progetto`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studio_medico_progetto`.`doctor` (
  `doctor_id` bigint NOT NULL,
    `doctor_email` varchar(255) DEFAULT NULL,
    `doctor_name` varchar(255) DEFAULT NULL,
    `doctor_specialization` varchar(255) DEFAULT NULL,
    `doctor_surname` varchar(255) DEFAULT NULL,
    `office_contact` varchar(255) DEFAULT NULL,
    `place_of_work` varchar(255) DEFAULT NULL,
    `working_days` int DEFAULT NULL,
    PRIMARY KEY (`doctor_id`),
    UNIQUE KEY `UK_lr3j4y6twpk17qwuydiqi3yuh` (`doctor_email`)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `studio_medico_progetto`.`secretary_seq`
-- -----------------------------------------------------
CREATE TABLE `secretary_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB


-- -----------------------------------------------------
-- Table `studio_medico_progetto`.`secretary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studio_medico_progetto`.`secretary` (
  `secretary_id` bigint NOT NULL,
    `secretary_email` varchar(255) DEFAULT NULL,
    `secretary_name` varchar(255) DEFAULT NULL,
    `secretary_phone_number` varchar(255) DEFAULT NULL,
    `secretary_surname` varchar(255) DEFAULT NULL,
    `working_days` int DEFAULT NULL,
    `doctordto_doctor_id` bigint DEFAULT NULL,
    PRIMARY KEY (`secretary_id`),
    UNIQUE KEY `UK_69d2psqyk1vaiumpg9r14oq5l` (`secretary_email`),
    UNIQUE KEY `UK_g15r0hqrch018pf3717rhoxij` (`secretary_phone_number`),
    KEY `FKi60cdg57v63gh3l9j7iamyfu4` (`doctordto_doctor_id`),
    CONSTRAINT `FKi60cdg57v63gh3l9j7iamyfu4` FOREIGN KEY (`doctordto_doctor_id`) REFERENCES `doctor` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `studio_medico_progetto`.`booking_seq`
-- -----------------------------------------------------
CREATE TABLE `booking_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB

-- -----------------------------------------------------
-- Table `studio_medico_progetto`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studio_medico_progetto`.`booking` (
      `booking_id` bigint NOT NULL,
      `booking_date` date DEFAULT NULL,
      `creation_date` date DEFAULT NULL,
      `doctordto_doctor_id` bigint DEFAULT NULL,
      `patientdto_patient_id` bigint DEFAULT NULL,
      PRIMARY KEY (`booking_id`),
      KEY `FKj0iyrhiy7yylocnmm91o3xrcb` (`doctordto_doctor_id`),
      KEY `FK8l4pqpgwa2s9c6r08ptfrk967` (`patientdto_patient_id`),
      CONSTRAINT `FK8l4pqpgwa2s9c6r08ptfrk967` FOREIGN KEY (`patientdto_patient_id`) REFERENCES `patient` (`patient_id`),
      CONSTRAINT `FKj0iyrhiy7yylocnmm91o3xrcb` FOREIGN KEY (`doctordto_doctor_id`) REFERENCES `doctor` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `studio_medico_progetto`.`patient_seq`
-- -----------------------------------------------------
CREATE TABLE `patient_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB

-- -----------------------------------------------------
-- Table `studio_medico_progetto`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studio_medico_progetto`.`patient` (
    `patient_id` bigint NOT NULL,
      `patient_email` varchar(255) DEFAULT NULL,
      `patient_name` varchar(255) DEFAULT NULL,
      `patient_phone_number` varchar(255) DEFAULT NULL,
      `patient_surname` varchar(255) DEFAULT NULL,
      `tax_id_code` varchar(255) DEFAULT NULL,
      `doctordto_doctor_id` bigint DEFAULT NULL,
      PRIMARY KEY (`patient_id`),
      UNIQUE KEY `UK_3rjgubfrjwmr1johx59i16s2g` (`patient_email`),
      KEY `FKr0uudx4knhddxs32u3sykj3re` (`doctordto_doctor_id`),
      CONSTRAINT `FKr0uudx4knhddxs32u3sykj3re` FOREIGN KEY (`doctordto_doctor_id`) REFERENCES `doctor` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
