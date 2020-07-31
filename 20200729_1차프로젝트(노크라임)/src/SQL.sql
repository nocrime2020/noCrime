drop table member cascade constraints;
drop table alarm cascade constraints;
drop table crime_type cascade constraints;
drop table crime_location cascade constraints;
drop table tip_info cascade constraints;
drop table tipoff cascade constraints;
drop table crime cascade constraints;

drop sequence cr_type_id_seq;
drop sequence cr_loc_id_seq;
drop sequence cr_id_seq;
drop sequence tip_info_id_seq;
drop sequence tip_id_seq;

create table member
(ID varchar2(16),
PW varchar2(20) not null,
NAME varchar2(32) not null,
EMAIL varchar2(40) not null,
constraints member_id_pk primary key(ID),
constraints member_email_uk unique (email)
);

create table alarm
(id varchar2(20),
set_start number(20),
set_end number(20),
cr_cnt number(20),
constraints alarm_id_pk primary key(id),
constraints alarm_id_fk foreign key(id) references member(id)
);

create table crime_type
(cr_type_id varchar2(20),
cr_type varchar2(20) not null,
constraints crimetype_crtypeid_pk primary key(cr_type_id),
constraints crimetype_crtype_CK CHECK (cr_type IN('����', '��������', '��������', '��������', '��ġ', '��������'))
);

create table crime_location
(cr_loc_id varchar2(20),
cr_city varchar2(20) not null,
cr_gu varchar2(20),
cr_address varchar2(70) not null,
constraints crimelocation_crlocid_pk primary key(cr_loc_id)
);

create table tip_info
(tip_info_id varchar2(20),
cr_type_id varchar2(20) not null,
cr_date date default SYSDATE not null,
cr_loc_id varchar2(20) not null,
evidence varchar2(70) not null,
constraints tipinfo_tipinfoid_pk primary key(tip_info_id),
constraints tipinfo_crtypeid_fk foreign key(cr_type_id) references crime_type(cr_type_id),
constraints tipinfo_crlocid_fk foreign key(cr_loc_id) references crime_location(cr_loc_id)
);

create table tipoff
(tip_id varchar2(20),
tip_info_id varchar2(20) not null,
cr_name varchar2(70),
constraints tipoff_tipid_pk primary key(tip_id),
constraints tipoff_tipinfoid_fk foreign key(tip_info_id) references tip_info(tip_info_id)
);

create table crime
(cr_id varchar2(20) not null,
cr_loc_id varchar2(20) not null,
cr_date date not null,
cr_type_id varchar2(20) not null,
tip_id varchar2(20),
cr_name varchar2(70),
constraints crime_crid_uk unique (cr_id),
constraints crime_cridld_pk primary key(cr_id, cr_loc_id, cr_date),
constraints crime_crlocid_fk foreign key(cr_loc_id) references crime_location(cr_loc_id),
constraints crime_crtypeid_fk foreign key(cr_type_id) references crime_type(cr_type_id),
constraints crime_tipid_fk foreign key(tip_id) references tipoff(tip_id)
);

CREATE SEQUENCE cr_type_id_seq
increment by 1
start with 1
nocache;

CREATE SEQUENCE cr_loc_id_seq
increment by 1
start with 1
nocache;

CREATE SEQUENCE cr_id_seq
increment by 1
start with 1
nocache;

CREATE SEQUENCE tip_info_id_seq
increment by 1
start with 1
nocache;

CREATE SEQUENCE tip_id_seq
increment by 1
start with 1
nocache;

INSERT INTO member VALUES('admin','admin','administrator','1@1');
insert into member values('admin','admin','������','dkskdfjk@f.com');
insert into member values('abd12','3098','������','dkskdfjk@gmail.com');
insert into member values('rksk12','4918','���۹�','dksdsfad4545k@gmail.com');
insert into member values('ekfk12','2853','��纻','hgfdhtjk@gmail.com');
insert into member values('akqk12','9114','�̿���','dsfahreahk@gmail.com');
insert into member values('tkwk14','8212','������','fghk@gmail.com');
insert into member values('abd13','2283','�ֽ���','ytutyfkdfjk@gmail.com');

insert into crime values('1001','118','2019-05-18','��������',null,null);
insert into crime values('1018','118','2017-02-01','��������',null,null);
insert into crime values('1030','118','2020-06-01','��������',null,null);
insert into crime values('1047','118','2020-05-28','��������',null,null);
insert into crime values('1019','119','2020-05-29','��������',null,null);
insert into crime values('1048','119','2010-02-01','��������',null,null);
insert into crime values('1077','119','2019-08-05','��������',null,null);
insert into crime values('1106','119','2020-05-20','��������',null,null);
insert into crime values('1135','119','2019-06-13','��������',null,null);
insert into crime values('1164','119','2007-02-24','��������',null,null);
insert into crime values('1193','119','2009-01-31','��������',null,null);
insert into crime values('1222','119','2020-05-08','��������',null,null);
insert into crime values('1251','119','2005-11-29','��������',null,null);
insert into crime values('1280','119','2017-11-18','��������',null,null);
insert into crime values('1309','119','2019-08-14','��������',null,null);
insert into crime values('1338','119','2017-12-26','��������',null,null);

insert into crime_type values('1','��������');
insert into crime_type values('2','����');
insert into crime_type values('3','��������');
insert into crime_type values('4','��������');
insert into crime_type values('5','��������');

insert into crime_location values('118','���ֱ�����','����','�۾Ϸ�58����');
insert into crime_location values('119','���ֱ�����','����','�۾Ϸ�76����');

insert into tip_info values('1000001','��������','2017-09-24','118',null,null);
insert into tip_info values('1000002','��������','2019-08-14','119',null,null);
insert into tip_info values('1000003','��������','2018-05-24','118',null,null);
insert into tip_info values('1000004','����','2018-11-05','119',null,null);
insert into tip_info values('1000005','��������','2018-12-06','118',null,null);
insert into tip_info values('1000006','��������','2020-05-08','119',null,null);
insert into tip_info values('1000007','��������','2019-09-04','118',null,null);
insert into tip_info values('1000008','��������','2020-05-29','118',null,null);
insert into tip_info values('1000009','��������','2020-05-28','118',null,null);

insert into alarm values('abd12','7','13','5');
insert into alarm values('rksk12','7','15','10');
insert into alarm values('ekfk12','2','20','15');
insert into alarm values('akqk12','6','9','13');
insert into alarm values('tkwk14','1','23','4');
insert into alarm values('abd13','12','19','7');


--select * from member;
