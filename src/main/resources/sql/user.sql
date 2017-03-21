CREATE DATABASE mathew;

USE mathew;

CREATE TABLE `user` (`userId` bit NOT NULL,`phone` varchar(13) NULL,`emailAddress` varchar(50) NOT NULL,`password` varchar(30) NOT NULL,`reminderQueryQuestion` varchar(200) NOT NULL,`reminderQueryAnswer` varchar(200) NOT NULL,`screenName` varchar(100) NULL,`qqId` varchar(20) NULL,`weChatId` varchar(100) NULL,`language` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0代表中文，1代表英文',`loginDate` datetime NOT NULL,`lastLoginDate` datetime NULL,`lastLoginIP` varchar(50) NULL,`failedLoginAttempts` integer(100) NULL,`lockout` varchar(255) NULL,`lockoutDate` datetime NULL,`agreedToTermsOfUse` tinyint(1) NULL,`emailAddressVerified` tinyint(1) NULL,PRIMARY KEY (`userId`) );