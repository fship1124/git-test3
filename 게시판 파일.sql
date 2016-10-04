delete
	      from t86_board_comment
	     where no = 2

select * from t86_board_comment;
select * from t86_board_member;

insert into t86_board_comment(
			comment_no, no, comment_content, id
		) values (
			s86_board_comment_no.nextVal, 246, '111', 'a'
		)

insert into t86_board_member(
			id, password, name, email
		) values (
			'a', 1, 'hodong', 'fship1124@naver.com'
		)
		
create table t86_board_comment (
	comment_no number primary key,
	no number(6) not null,
	comment_content varchar2(300) not null,
	id varchar2(50) not null,
	reg_date date default sysdate
);


create table t86_board_member (
	id varchar2(30) primary key,
	password varchar2(30) not null,
	name varchar2(30) not null,
	email varchar2(100) not null
);


CREATE SEQUENCE s86_board_member_no;

CREATE SEQUENCE s86_board_comment_no; 

create table t86_board_file (
	file_no number primary key,
	no number(6) not null,
	ori_file_name varchar2(200) not null,
	real_file_name varchar2(200) not null,
	file_path varchar2(100) not null,
	file_size number not null
	
);










select * from t86_board_member;


create table t86_board_ripple (
	ripple_no number primary key,
	no number(6) not null,
	ripple_content varchar2(200) not null,
	reg_date date default sysdate
);



     
select * from t86_board_ripple order by ripple_no desc;
drop table t86_board_ripple



CREATE SEQUENCE s86_board_ripple_no; 
CREATE SEQUENCE s86_board_file_no; 

select * from user_sequences

select * from t86_board_file;


insert into t86_board_file (
	file_no, no, ori_file_name, real_file_name, file_path, file_size
	) values (
		s86_board_file_no.nextval, s86_board_no.currval, 
		'web.xml', 'web.xml', 'C:\java86\tomcat-work7\wtpwebapps\LecBoard\upload\2016\08\11', 
		'168087'
	);



