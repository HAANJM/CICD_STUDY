-- MySQL Script generated by MySQL Workbench
-- Fri May 19 11:28:21 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ssafitlog
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafitlog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafitlog` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ssafitlog` ;

-- -----------------------------------------------------
-- Table `ssafitlog`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafitlog`.`user` (
  `userId` VARCHAR(20) NOT NULL,
  `password` VARCHAR(80) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `nickName` VARCHAR(45) NULL DEFAULT NULL,
  `userName` VARCHAR(45) NULL DEFAULT NULL,
  `img` VARCHAR(80) NULL DEFAULT NULL,
  `exp` INT NULL DEFAULT NULL,
  `level` INT NULL DEFAULT NULL,
  `tier` VARCHAR(20) NULL DEFAULT NULL,
  `userComment` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafitlog`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafitlog`.`board` (
  `boardNumber` INT NOT NULL,
  `link` VARCHAR(80) NULL DEFAULT NULL,
  `scoreCount` INT NULL DEFAULT NULL,
  `regDate` VARCHAR(45) NULL DEFAULT NULL,
  `boardContent` VARCHAR(900) NULL DEFAULT NULL,
  `userId` VARCHAR(20) NOT NULL,
  `likeCnt` INT NULL,
  PRIMARY KEY (`boardNumber`, `userId`),
  INDEX `fk_Board_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_Board_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `ssafitlog`.`user` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafitlog`.`exp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafitlog`.`exp` (
  `stricExp` INT NULL DEFAULT NULL,
  `commentExp` INT NULL DEFAULT NULL,
  `regDate` VARCHAR(45) NULL DEFAULT NULL,
  `userId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userId`),
  INDEX `fk_Exp_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_Exp_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `ssafitlog`.`user` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafitlog`.`follow`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafitlog`.`follow` (
  `followFrom` VARCHAR(20) NOT NULL,
  `followTo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`followFrom`, `followTo`),
  INDEX `fk_Follow_User1_idx` (`followFrom` ASC) VISIBLE,
  INDEX `fk_Follow_User2_idx` (`followTo` ASC) VISIBLE,
  CONSTRAINT `fk_Follow_User1`
    FOREIGN KEY (`followFrom`)
    REFERENCES `ssafitlog`.`user` (`userId`),
  CONSTRAINT `fk_Follow_User2`
    FOREIGN KEY (`followTo`)
    REFERENCES `ssafitlog`.`user` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafitlog`.`like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafitlog`.`like` (
  `userId` VARCHAR(20) NOT NULL,
  `boardNumber` INT NOT NULL,
  PRIMARY KEY (`userId`, `boardNumber`),
  INDEX `fk_Like_User1_idx` (`userId` ASC) VISIBLE,
  INDEX `fk_Like_Board1_idx` (`boardNumber` ASC) VISIBLE,
  CONSTRAINT `fk_Like_Board1`
    FOREIGN KEY (`boardNumber`)
    REFERENCES `ssafitlog`.`board` (`boardNumber`),
  CONSTRAINT `fk_Like_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `ssafitlog`.`user` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafitlog`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafitlog`.`review` (
  `reviewNumber` INT NOT NULL,
  `reviewContent` VARCHAR(600) NULL DEFAULT NULL,
  `regDate` VARCHAR(45) NULL DEFAULT NULL,
  `reviewScore` INT NULL DEFAULT NULL,
  `status` INT NULL DEFAULT NULL,
  `boardNumber` INT NOT NULL,
  `userId` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`reviewNumber`, `boardNumber`, `userId`),
  INDEX `fk_Review_Board2_idx` (`boardNumber` ASC) VISIBLE,
  INDEX `fk_Review_User2_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_Review_Board2`
    FOREIGN KEY (`boardNumber`)
    REFERENCES `ssafitlog`.`board` (`boardNumber`),
  CONSTRAINT `fk_Review_User2`
    FOREIGN KEY (`userId`)
    REFERENCES `ssafitlog`.`user` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;