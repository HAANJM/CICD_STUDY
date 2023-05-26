CREATE DEFINER=`root`@`localhost` PROCEDURE `new_procedure2`()
BEGIN
	set @start_date = '2022-05-25';
    set @end_date = '2023-05-25';
    set @current_date = @start_date;
    while @current_date <= @end_date DO
		insert into `ssafitlog`.`exp` (userId, regDate, stricExp, reviewExp)
		values ('silverTester', @current_date, 0, 0);
        set @current_date = date_add(@current_date, interval 1 day);
	end while;
END