-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dbtest
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbtest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbtest` DEFAULT CHARACTER SET utf8 ;
USE `dbtest` ;

-- -----------------------------------------------------
-- Table `dbtest`.`courts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtest`.`courts` (
  `court_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `court_name` VARCHAR(255) NOT NULL,
  `court_address` VARCHAR(255) NULL,
  PRIMARY KEY (`court_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbtest`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtest`.`users` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `firstname` VARCHAR(255) NULL,
  `lastname` VARCHAR(255) NULL,
  `active` BIT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbtest`.`causes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtest`.`causes` (
  `cause_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `next_date` DATETIME NULL DEFAULT NULL,
  `number` VARCHAR(255) NOT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `user_id` BIGINT(20) NULL DEFAULT NULL,
  `court_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`cause_id`),
  INDEX `fk_courts_court_id_idx` (`court_id` ASC),
  INDEX `fk_users_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_causes_court_id`
  FOREIGN KEY (`court_id`)
  REFERENCES `dbtest`.`courts` (`court_id`),
  CONSTRAINT `fk_causes_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `dbtest`.`users` (`user_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbtest`.`descriptions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtest`.`descriptions` (
  `description_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `description_date` DATETIME NOT NULL,
  `description_text` TEXT NOT NULL,
  `cause_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`description_id`),
  INDEX `fk_case_id_idx` (`cause_id` ASC),
  CONSTRAINT `fk_descriptions_cause_id`
  FOREIGN KEY (`cause_id`)
  REFERENCES `dbtest`.`causes` (`cause_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbtest`.`decisions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtest`.`decisions` (
  `decision_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `decision_brief` VARCHAR(255) NOT NULL,
  `decision_date` DATETIME NOT NULL,
  `decision_text` TEXT NOT NULL,
  `cause_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`decision_id`),
  INDEX `fk_case_id_idx` (`cause_id` ASC),
  CONSTRAINT `fk_decicions_cause_id`
  FOREIGN KEY (`cause_id`)
  REFERENCES `dbtest`.`causes` (`cause_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbtest`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtest`.`roles` (
  `role_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbtest`.`participants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtest`.`participants` (
  `participant_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `participant_name` VARCHAR(255) NOT NULL,
  `participant_address` VARCHAR(255) NULL,
  PRIMARY KEY (`participant_id`),
  UNIQUE INDEX `participant_name_UNIQUE` (`participant_name` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbtest`.`causes_participants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtest`.`causes_participants` (
  `cause_id` BIGINT(20) NOT NULL,
  `participant_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`cause_id`, `participant_id`),
  INDEX `fk_causes_participant_cause_id_idx` (`participant_id` ASC),
  CONSTRAINT `fk_causes_participant_cause_id`
  FOREIGN KEY (`cause_id`)
  REFERENCES `dbtest`.`causes` (`cause_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_causes_participant_participant_id`
  FOREIGN KEY (`participant_id`)
  REFERENCES `dbtest`.`participants` (`participant_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbtest`.`users_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtest`.`users_roles` (
  `user_id` BIGINT(20) NOT NULL,
  `role_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `fk_users_roles_roles1_idx` (`role_id` ASC),
  INDEX `fk_users_roles_users1_idx` (`user_id` ASC),
  CONSTRAINT `fk_users_roles_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `dbtest`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_users_roles_role_id`
  FOREIGN KEY (`role_id`)
  REFERENCES `dbtest`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
