--查询用户信息
--##login start
select name,age,address,gender,telephone,email from 360ms_employee 
	where name='%s' and password='%s'
--##login end

--##update_user_pwd start
update 360ms_employee set password=? where name=?
--##update_user_pwd end

--##add_user start
insert into 360ms_employee() values(
--##add_user end