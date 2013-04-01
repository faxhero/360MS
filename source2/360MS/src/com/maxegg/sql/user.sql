--查询用户信息
--##login start
select number,name,password from 360ms_employee 
	where number='%s' and password='%s'
--##login end

--##update_user_pwd start
update 360ms_employee set password=? where name=?
--##update_user_pwd end

--##list_user start
insert into 360ms_employee() values(
--##list_user end