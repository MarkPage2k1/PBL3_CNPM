USE [StudentManagement]
GO
/****** Object:  UserDefinedFunction [dbo].[auto_id_class_teacher]    Script Date: 3/8/2021 7:17:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER FUNCTION [dbo].[auto_id_class_teacher]()
RETURNS VARCHAR(10)
AS
BEGIN
	DECLARE @ID VARCHAR(10)
	IF (SELECT COUNT(id_class_teacher) FROM class_teacher) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(id_class_teacher, 3)) FROM class_teacher
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'ID0000000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'ID000000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END