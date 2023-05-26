INSERT INTO `ssafitlog`.`user` (`userId`, `userComment`, `img`, `password`, `email`, `nickName`, `userName`, `totalExp`, `level`, `tier`, `userStatus`, `reviewCount`)
VALUES
    ('silverTester', '요호호 테스터입니다.', 'default', '1234', 'tester1@example.com', '실버테스터1', '최불암', 48, 2, 'silver', 0, 0),
    ('goldTester', '테스터라니 무리무리~(※무리가 아니었다?!?!)', 'default', '1234', 'tester2@example.com', '골드테스터1', '아이유', 4640, 3, 'gold', 0, 0);
    ('tester1', 'User comment 1', 'img1.jpg', '1234', 'tester11@example.com', 'Nick1', 'User Name 1', 100, 1, 'Bronze', 1, 5),
    ('tester2', 'User comment 2', 'img2.jpg', '1234', 'tester22@example.com', 'Nick2', 'User Name 2', 200, 2, 'Silver', 1, 10);    
INSERT INTO `ssafitlog`.`favorite` (`userId`, `boardNumber`)
VALUES
    ('silverTester', 5);
    
INSERT INTO `ssafitlog`.`board` (`userId`, `regDate`, `link`, `scoreCount`, `boardContent`, `boardTitle`, `favoriteCount`)
VALUES
    ('silverTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/1', 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('silverTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('silverTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('silverTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/4', 5, '게시물 내용 4', '게시물 제목 4', 3),
	('silverTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.coreviewm/board/1', 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('silverTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('silverTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('goldTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/4', 5, '게시물 내용 4', '게시물 제목 4', 3),
	('goldTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/1', 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('goldTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('goldTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('goldTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/4', 5, '게시물 내용 4', '게시물 제목 4', 3),
	('goldTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('goldTester', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12);

INSERT INTO `ssafitlog`.`user` (`userId`, `userComment`, `img`, `password`, `email`, `nickName`, `userName`, `totalExp`, `level`, `tier`, `userStatus`, `reviewCount`)
VALUES
    ('user3', 'User comment 3', 'img3.jpg', '1234', 'user3@example.com', 'Nick3', 'User Name 3', 300, 3, 'Gold', 1, 15),
    ('user4', 'User comment 4', 'img4.jpg', '1234', 'user4@example.com', 'Nick4', 'User Name 4', 400, 4, 'Platinum', 1, 20),
    ('user5', 'User comment 5', 'img5.jpg', '1234', 'user5@example.com', 'Nick5', 'User Name 5', 500, 5, 'Diamond', 1, 25),
    ('user6', 'User comment 6', 'img6.jpg', '1234', 'user6@example.com', 'Nick6', 'User Name 6', 600, 6, 'Master', 1, 30),
    ('user7', 'User comment 7', 'img7.jpg', '1234', 'user7@example.com', 'Nick7', 'User Name 7', 700, 7, 'Grandmaster', 1, 35),
    ('user8', 'User comment 8', 'img8.jpg', '1234', 'user8@example.com', 'Nick8', 'User Name 8', 800, 8, 'Challenger', 1, 40),
    ('user9', 'User comment 9', 'img9.jpg', '1234', 'user9@example.com', 'Nick9', 'User Name 9', 900, 9, 'Bronze', 1, 45),
    ('user10', 'User comment 10', 'img10.jpg', '1234', 'user10@example.com', 'Nick10', 'User Name 10', 1000, 10, 'Silver', 1, 50),
    ('user11', 'User comment 11', 'img11.jpg', '1234', 'user11@example.com', 'Nick11', 'User Name 11', 1100, 11, 'Gold', 1, 55);

INSERT INTO `ssafitlog`.`board` (`userId`, `regDate`, `link`, `scoreCount`, `boardContent`, `boardTitle`, `favoriteCount`)
VALUES
    ('tester1', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/1', 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('tester1', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('tester2', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('tester2', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/4', 5, '게시물 내용 4', '게시물 제목 4', 3),
	('user3', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/1', 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('user3', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('user3', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('user4', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/4', 5, '게시물 내용 4', '게시물 제목 4', 3),
	('user5', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/1', 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('user5', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('user5', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('user5', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/4', 5, '게시물 내용 4', '게시물 제목 4', 3),
	('user5', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('user6', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('user6', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/4', 5, '게시물 내용 4', '게시물 제목 4', 3),
	('user7', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/1', 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('user8', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('user8', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('user8', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/4', 5, '게시물 내용 4', '게시물 제목 4', 3),
	('user9', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('user9', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('user9', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/4', 5, '게시물 내용 4', '게시물 제목 4', 3),
	('user10', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/1', 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('user10', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/2', 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('user11', DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 60) DAY), 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12);

INSERT INTO `ssafitlog`.`follow` (`followFrom`, `followTo`)
VALUES
    ('tester1', 'tester2'),
    ('tester1', 'user3'),
    ('tester1', 'user4'),
    ('tester1', 'user5'),
    ('tester1', 'user6'),
    ('tester2', 'user7'),
    ('tester2', 'tester1'),
    ('tester2', 'user8'),
    ('tester2', 'user9'),
    ('tester2', 'user10'),
    ('tester2', 'user11');

INSERT INTO `ssafitlog`.`favorite` (`userId`, `boardNumber`)
VALUES
    ('tester1', 1),
    ('tester1', 2),
    ('tester1', 3),
    ('tester1', 4),
    ('tester1', 5),
    ('tester2', 1),
    ('tester2', 2),
    ('tester2', 7),
    ('tester2', 8),
    ('tester2', 9),
    ('tester2', 10),
    ('tester2', 11),
    ('tester2', 12);

INSERT INTO `ssafitlog`.`exp`
VALUES
    ('tester1', TIMESTAMP('2023-05-15 00:00:00'), 10, 1),
    ('tester1', TIMESTAMP('2023-05-14 00:00:00'), 10, 2),
	('tester1', TIMESTAMP('2023-05-13 00:00:00'), 10, 3),
    ('tester1', TIMESTAMP('2023-05-12 00:00:00'), 10, 4),
	('tester1', TIMESTAMP('2023-05-11 00:00:00'), 10, 5),
    ('tester1', TIMESTAMP('2023-05-10 00:00:00'), 10, 1),
	('tester1', TIMESTAMP('2023-05-9 00:00:00'), 10, 2),
    ('tester1', TIMESTAMP('2023-05-8 00:00:00'), 10, 3),
	('tester1', TIMESTAMP('2023-05-7 00:00:00'), 10, 4),
    ('tester1', TIMESTAMP('2023-05-6 00:00:00'), 10, 5),
	('tester2', TIMESTAMP('2023-05-15 00:00:00'), 1, 1),
    ('tester2', TIMESTAMP('2023-05-14 00:00:00'), 3, 2),
	('tester2', TIMESTAMP('2023-05-13 00:00:00'), 5, 3),
    ('tester2', TIMESTAMP('2023-05-12 00:00:00'), 7, 4),
	('tester2', TIMESTAMP('2023-05-11 00:00:00'), 9, 5),
    ('tester2', TIMESTAMP('2023-05-10 00:00:00'), 2, 1),
	('tester2', TIMESTAMP('2023-05-9 00:00:00'), 5, 2),
	('tester2', TIMESTAMP('2023-05-8 00:00:00'), 8, 3),
	('tester2', TIMESTAMP('2023-05-7 00:00:00'), 10, 4),
	('tester2', TIMESTAMP('2023-05-6 00:00:00'), 15, 5),
    ('user3', CURRENT_TIMESTAMP, 150, 70),
    ('user4', CURRENT_TIMESTAMP, 120, 60),
    ('user5', CURRENT_TIMESTAMP, 180, 90),
    ('user6', CURRENT_TIMESTAMP, 140, 75),
    ('user7', CURRENT_TIMESTAMP, 110, 55),
    ('user8', CURRENT_TIMESTAMP, 190, 85),
    ('user9', CURRENT_TIMESTAMP, 160, 65),
    ('user10', CURRENT_TIMESTAMP, 130, 68),
    ('user11', CURRENT_TIMESTAMP, 170, 72);

    INSERT INTO `ssafitlog`.`exp`
VALUES
    ('tester1', TIMESTAMP('2023-05-25 00:00:00'), 10, 1),
    ('tester1', TIMESTAMP('2023-05-24 00:00:00'), 6, 2),
    ('tester1', TIMESTAMP('2023-05-23 00:00:00'), 0, 3),
    ('tester1', TIMESTAMP('2023-05-22 00:00:00'), 8, 4),
    ('tester1', TIMESTAMP('2023-05-21 00:00:00'), 2, 5),
    ('tester1', TIMESTAMP('2023-05-20 00:00:00'), 3, 1),
    ('tester1', TIMESTAMP('2023-05-19 00:00:00'), 4, 2),
    ('tester1', TIMESTAMP('2023-05-18 00:00:00'), 5, 3),
    ('tester1', TIMESTAMP('2023-05-17 00:00:00'), 6, 4),
    ('tester1', TIMESTAMP('2023-05-16 00:00:00'), 2, 5),
    ('tester1', TIMESTAMP('2023-05-5 00:00:00'), 8, 1),
    ('tester1', TIMESTAMP('2023-05-4 00:00:00'), 9, 2),
    ('tester1', TIMESTAMP('2023-05-3 00:00:00'), 2, 3),
    ('tester1', TIMESTAMP('2023-05-2 00:00:00'), 0, 4),
    ('tester1', TIMESTAMP('2023-05-1 00:00:00'), 4, 5),
    ('tester1', TIMESTAMP('2023-04-30 00:00:00'), 5, 1),
    ('tester1', TIMESTAMP('2023-04-29 00:00:00'), 6, 2),
    ('tester1', TIMESTAMP('2023-04-28 00:00:00'), 7, 3),
    ('tester1', TIMESTAMP('2023-04-27 00:00:00'), 8, 4),
    ('tester1', TIMESTAMP('2023-04-26 00:00:00'), 10, 5),
    ('tester1', TIMESTAMP('2023-04-25 00:00:00'), 1, 1),
    ('tester1', TIMESTAMP('2023-04-24 00:00:00'), 0, 2),
    ('tester1', TIMESTAMP('2023-04-23 00:00:00'), 0, 3),
    ('tester1', TIMESTAMP('2023-04-22 00:00:00'), 7, 4),
    ('tester1', TIMESTAMP('2023-04-21 00:00:00'), 9, 5),
    ('tester1', TIMESTAMP('2023-04-20 00:00:00'), 2, 1),
    ('tester1', TIMESTAMP('2023-04-19 00:00:00'), 0, 2),
    ('tester1', TIMESTAMP('2023-04-18 00:00:00'), 8, 3),
    ('tester1', TIMESTAMP('2023-04-17 00:00:00'), 10, 4),
    ('tester1', TIMESTAMP('2023-04-16 00:00:00'), 0, 5);
    
INSERT INTO `ssafitlog`.`board` (`userId`, `regDate`, `link`, `scoreCount`, `boardContent`, `boardTitle`, `favoriteCount`)
VALUES
    ('tester1', '2023-05-24 00:00:00', "zruKSHfD7b4", 10, '어깨어떰?', '어깨 조졌습니다', 5),
    ('tester1', '2023-05-24 00:00:00', "gMaB-fG4u4g", 15, '어깨어깨빔', '어깨어깨빔', 8),
    ('tester2', '2023-05-24 00:00:00', "PK3gAfasWpI", 20, '스쿼트 자세좀 봐주세요', '스쿼트 이렇게 하는거 맞나요?', 12),
    ('tester2', '2023-05-24 00:00:00', "dpBYYEhdofI", 5, '구란데 ㅋㅋ', '나 3대 600임', 3),
    ('user3', '2023-05-24 00:00:00', "2paxL9MmxWM", 10, '1일차', '헬스 1일차', 5),
    ('user3', '2023-05-24 00:00:00', "46vQnzaZ6aU", 15, '사실 3일차', '헬스 3832일차', 8),
    ('user3', '2023-05-24 00:00:00', "ZI5ugBoaPH4", 20, '심 경 섭 대 경 섭', '경섭이 삼두 멋져요', 12),
    ('user4', '2023-05-24 00:00:00', "hR1ZgDQqyVI", 5, '5반헬스장 많관부~', '저는 관장 김인범입니다', 3),
    ('user5', '2023-05-24 00:00:00', "RFuAK6FEeYY", 10, '너무 빡세요', '인범짐 수강중', 5),
    ('user5', '2023-05-24 00:00:00', "CcbOzO3-V14", 15, '제곧내', '인범짐 바이럴아님?', 8),
    ('user5', '2023-05-24 00:00:00', 'https://example.com/board/3', 20, '찾아갑니다', '음해세력들', 12),
    ('tester1', '2023-05-23 00:00:00', "zruKSHfD7b4", 10, '어때요', '등운동 좀 봐주세요', 5),
    ('tester1', '2023-05-22 00:00:00', "gMaB-fG4u4g", 15, '어렵네요', '가슴운동은 어떻게 해야하나여..', 2),
    ('tester2', '2023-05-21 00:00:00', "PK3gAfasWpI", 20, 'ㅜㅜㅜㅜ', '제발 봐주세요', 2),
    ('tester2', '2023-05-20 00:00:00', "dpBYYEhdofI", 5, 'ㅁㄴㅇㄹ', '이거 일케하면댐?', 23),
    ('user3', '2023-05-19 00:00:00', "2paxL9MmxWM", 10, '제곧내', '관리자입니다', 35),
    ('user3', '2023-05-18 00:00:00', "46vQnzaZ6aU", 15, '매일 2시간씩 필참', '헬스 스터디 그룹 모집합니다', 37),
    ('user3', '2023-05-17 00:00:00', "ZI5ugBoaPH4", 20, '깔릴뻔함 ㄷㄷ', '무게 조심하세요', 1),
    ('user4', '2023-05-16 00:00:00', "hR1ZgDQqyVI", 5, '444', '4', 3),
    ('user5', '2023-05-15 00:00:00', "RFuAK6FEeYY", 10, '오 오늘 자극 장난아닌데요', '뻠삥먠', 4),
    ('user5', '2023-05-14 00:00:00', "CcbOzO3-V14", 15, '무릎 좀 아픈듯', '쩜프스쿼트', 8),
    ('user5', '2023-05-13 00:00:00', 'https://example.com/board/3', 20, '좀 잘함 저', 'ㄱㄱ', 17);
    
INSERT INTO `ssafitlog`.`board` (`userId`, `regDate`, `link`, `scoreCount`, `boardContent`, `boardTitle`, `favoriteCount`)
VALUES
    ('tester1', '2023-05-24 00:00:00', "zruKSHfD7b4", 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('tester1', '2023-05-24 00:00:00', "gMaB-fG4u4g", 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('tester2', '2023-05-24 00:00:00', "PK3gAfasWpI", 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('tester2', '2023-05-24 00:00:00', "dpBYYEhdofI", 5, '게시물 내용 4', '게시물 제목 4', 3),
    ('user3', '2023-05-24 00:00:00', "2paxL9MmxWM", 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('user3', '2023-05-24 00:00:00', "46vQnzaZ6aU", 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('user3', '2023-05-24 00:00:00', "ZI5ugBoaPH4", 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('user4', '2023-05-24 00:00:00', "hR1ZgDQqyVI", 5, '게시물 내용 4', '게시물 제목 4', 3),
    ('user5', '2023-05-24 00:00:00', "RFuAK6FEeYY", 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('user5', '2023-05-24 00:00:00', "CcbOzO3-V14", 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('user5', '2023-05-24 00:00:00', 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 12),
    ('tester1', '2023-05-23 00:00:00', "zruKSHfD7b4", 10, '게시물 내용 1', '게시물 제목 1', 5),
    ('tester1', '2023-05-22 00:00:00', "gMaB-fG4u4g", 15, '게시물 내용 2', '게시물 제목 2', 2),
    ('tester2', '2023-05-21 00:00:00', "PK3gAfasWpI", 20, '게시물 내용 3', '게시물 제목 3', 2),
    ('tester2', '2023-05-20 00:00:00', "dpBYYEhdofI", 5, '게시물 내용 4', '게시물 제목 4', 23),
    ('user3', '2023-05-19 00:00:00', "2paxL9MmxWM", 10, '게시물 내용 1', '게시물 제목 1', 35),
    ('user3', '2023-05-18 00:00:00', "46vQnzaZ6aU", 15, '게시물 내용 2', '게시물 제목 2', 37),
    ('user3', '2023-05-17 00:00:00', "ZI5ugBoaPH4", 20, '게시물 내용 3', '게시물 제목 3', 1),
    ('user4', '2023-05-16 00:00:00', "hR1ZgDQqyVI", 5, '게시물 내용 4', '게시물 제목 4', 3),
    ('user5', '2023-05-15 00:00:00', "RFuAK6FEeYY", 10, '게시물 내용 1', '게시물 제목 1', 4),
    ('user5', '2023-05-14 00:00:00', "CcbOzO3-V14", 15, '게시물 내용 2', '게시물 제목 2', 8),
    ('user5', '2023-05-13 00:00:00', 'https://example.com/board/3', 20, '게시물 내용 3', '게시물 제목 3', 17);