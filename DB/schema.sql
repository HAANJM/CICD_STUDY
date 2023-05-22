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
  `userComment` VARCHAR(300) NULL DEFAULT NULL,
  `img` VARCHAR(80) NULL DEFAULT NULL,
  `password` VARCHAR(80) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `nickName` VARCHAR(45) NOT NULL,
  `userName` VARCHAR(45) NOT NULL,
  `exp` INT NOT NULL,
  `level` INT NOT NULL,
  `tier` VARCHAR(20) NOT NULL,
  `status` INT NOT NULL,
  `reviewCount` INT NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafitlog`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafitlog`.`board` (
  `boardNumber` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(20) NOT NULL,
  `regDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `link` VARCHAR(80) NOT NULL,
  `scoreCount` INT NOT NULL,
  `boardContent` VARCHAR(900) NOT NULL,
  `boardTitle` VARCHAR(300) NOT NULL,
  `likeCnt` INT NOT NULL,
  PRIMARY KEY (`boardNumber`),
  INDEX `fk_Board_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_Board_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `ssafitlog`.`user` (`userId`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafitlog`.`exp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafitlog`.`exp` (
  `userId` VARCHAR(45) NOT NULL,
  `expcol` VARCHAR(45) NOT NULL,
  `regDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `stricExp` INT NOT NULL,
  `commentExp` INT NOT NULL,
  PRIMARY KEY (`userId`, `expcol`),
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
  `reviewNumber` INT NOT NULL AUTO_INCREMENT,
  `boardNumber` INT NOT NULL,
  `userId` VARCHAR(20) NOT NULL,
  `regDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `reviewContent` VARCHAR(600) NOT NULL,
  `reviewScore` INT NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`reviewNumber`),
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
