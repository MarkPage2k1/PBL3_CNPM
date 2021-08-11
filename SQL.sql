create database StudentManagement
use StudentManagement
go
create table account
(
	username varchar(50) not null,
	passwordd varchar(20) not null,
	position nvarchar(20),
	constraint pk_username primary key (username)
)
create table course
(
	idcourse varchar(10) not null,
	coursename nvarchar(50),
	describe text, 
	startdate datetime,
	enddate datetime,
	statuss bit,
	constraint pk_idcourse primary key(idcourse)
)
create table class
(
	idclass varchar(10) not null,
	classname nvarchar(50),
	statuss bit,
	remark varchar(10),
	registrationDate datetime,
	course_idcourse varchar(10),
	constraint pk_idclass primary key (idclass),
	constraint fk_course_idcourse foreign key (course_idcourse) references course(idcourse)
)
create table student
(
	idstudent varchar(10) not null,
	studentname nvarchar(50),
	stbirthday datetime,
	stgender bit,
	staddress nvarchar(100),
	ststatuss bit,
	stemail varchar(50),
	stphone varchar(10),
	stavatar binary,
	staccount varchar(50),
	constraint pk_idstudent primary key(idstudent),
	constraint fk_account_st foreign key(staccount) references account(username)
)
create table admin
(
	idadmin varchar(10) not null,
	adminname nvarchar(50),
	adbirthday datetime,
	adgender bit,
	adaddress nvarchar(100),
	adstatus bit,
	ademail varchar(50),
	adphone varchar(10),
	adavatar binary,
	adaccount varchar(50),
	constraint pk_idadmin primary key (idadmin),
	constraint fk_account_ad foreign key(adaccount) references account(username)
)
create table teacher
(
	idteacher varchar(10) not null,
	tchname nvarchar(50),
	tchbirthday datetime,
	tchgender bit,
	tchaddress nvarchar(100),
	tchstatus bit,
	tchemail varchar(50),
	tchphone varchar(10),
	tchavatar binary,
	tchaccount varchar(50),
	constraint pk_idteacher primary key (idteacher),
	constraint fk_account_tch foreign key(tchaccount) references account(username)
)
alter table admin
alter column adavatar binary(5000) 

alter table teacher
alter column tchavatar binary(5000)

alter table student
alter column stavatar binary(5000)
-- đã định nghĩa 2 bảng class_student và class_teacher
alter table class_teacher
add teacher_idteacher varchar(10)
alter table class_teacher
add constraint fk_teacher_idteacher foreign key (teacher_idteacher) references teacher(idteacher)

alter table class_student
add student_idstudent varchar(10)
alter table class_student
add constraint fk_student_idstudent foreign key (student_idstudent) references student(idstudent)
 ----------------------------------------------------------------------------------------------------------------------------------
 insert into account(username,passwordd,position) values ('hv01','1234',N'Học Viên');
 insert into student(idstudent,studentname,stbirthday,stgender,stemail,stphone,staddress,ststatuss,staccount) 
 values ('hv01','Nguyen Van A','2010-03-20', '1','duylengoc1111@gmail.com','0857989478','Thanh Pho Hue',0,'hv01')
 insert into account(username,passwordd,position) values ('hv02','1234',N'Học Viên');
 insert into student(idstudent,studentname,stbirthday,stgender,stemail,stphone,staddress,ststatuss,staccount) 
 values ('hv02','Le Ngoc Duy','2010-03-15', '1','abc@gmail.com','0123454678','Da Nang',1,'hv02')
 insert into account(username,passwordd,position) values ('ad01','1234','Admin');
 insert into admin(idadmin,adminname,adbirthday,adgender,ademail,adphone,adaddress,adstatus,adaccount) 
 values ('ad01','Le Ngoc Duy','2001-03-15', '1','duylengoc1111@gmail.com','0857989478','Thanh Pho Hue',0,'ad01')

 insert into account(username,passwordd,position) values ('gv01','1234',N'Giảng Viên');
 insert into teacher(idteacher,tchname,tchbirthday,tchgender,tchemail,tchphone,tchaddress,tchstatus,tchaccount) 
 values ('gv01','Pham Thi H','1982-05-11', '0','phamthih@gmail.com','0857989478','Da Nang',1,'gv01')

  insert into account(username,passwordd,position) values ('gv02','1234',N'Giảng Viên');
 insert into teacher(idteacher,tchname,tchbirthday,tchgender,tchemail,tchphone,tchaddress,tchstatus,tchaccount) 
 values ('gv02','Nguyen Thi B','1980-01-14', '0','Bnguyenthi@gmail.com','0231123215','Da Nang',1,'gv02')

insert into account(username,passwordd,position) values ('gv04','1234',N'Giảng Viên')
select * from account
delete from account where username = 'gv03'
 ------------------------------------------------------------------------------------------------------------------------------------

 alter table class_teacher
 add id_class_teacher varchar(10),
 constraint pk_idclass_teacher primary key (id_class_teacher)

 alter table class_student
 add id_class_student varchar(10)

 alter table class_student
 add constraint fk_idclass_student foreign key (id_class_student) references class_teacher(id_class_teacher)
 ON DELETE CASCADE
 ON UPDATE CASCADE
 
 alter table class_teacher
 add constraint default_id
default dbo.auto_id_class_teacher() for id_class_teacher

alter table class_teacher
drop constraint default_id

select * from class_teacher
select * from class_student

CREATE FUNCTION auto_id_class_teacher()
RETURNS VARCHAR(10)
AS
BEGIN
	DECLARE @ID VARCHAR(10)
	IF (SELECT COUNT(id_class_teacher) FROM class_teacher) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(id_class_teacher, 3)) FROM class_teacher
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'ID000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'ID00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
------------------------------------------------------------------------------------------------------------------
create table class_admin
(
	id_class_teacher varchar(10),
	idclass varchar(10),
	id_course varchar(10),
	id_teacher varchar(10),
	soluonghv int
	constraint pk_id_class_teacher primary key (id_class_teacher),
	constraint fk_id_class_teacher_ foreign key (id_class_teacher) references class_teacher(id_class_teacher),
	constraint fk_idclass_ foreign key (idclass) references class(idclass),
	constraint fk_id_course_ foreign key (id_course) references course(idcourse),
	constraint fk_id_teacher foreign key (id_teacher) references teacher(idteacher)
)

Select class_teacher.id_class_teacher ,class_teacher.class_idclass,class_teacher.classname,class_teacher.coursename,
tchname,class.statuss,startdate,enddate from class_teacher inner join class on class_teacher.class_idclass = class.idclass 
inner join teacher on teacher.idteacher = class_teacher.teacher_idteacher 
inner join course on course.idcourse = class_teacher.class_course_idcourse

select * from class_teacher
select * from class_student

Select class_student.class_idclass, class.classname, class_student.student_idstudent,student.studentname,student.stphone, 
course.coursename from class_student inner join class on class_student.class_idclass = class.idclass inner join student on 
class_student.id_class_student = student.idstudent inner join course on class_student.class_course_idcourse = course.idcourse 
where class_student.class_idclass = 'CL001' and class_student.class_course_idcourse = 'KH001' and class_student.student_idstudent = 'gv01'

Select class_student.class_idclass, class.classname, class_student.student_idstudent,student.studentname,student.stphone, 
course.coursename from class_student inner join class_teacher on class_student.id_class_student = class_teacher.id_class_teacher inner join class
on class_student.class_idclass = class.idclass inner join student on class_student.student_idstudent = student.idstudent inner join course
on class_student.class_course_idcourse = course.idcourse where class_teacher.id_class_teacher = 'ID00000003'

Update class_teacher set register_date = '',status = '', class_idclass = '', class_course_idcourse = '', teacher_idteacher = '' where id_class_teacher = ''