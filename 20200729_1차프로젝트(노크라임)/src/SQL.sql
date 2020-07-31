INSERT INTO member VALUES('admin','admin','administrator','1@1');

--create table member
--(ID varchar2(16),
--PW varchar2(20) not null,
--NAME varchar2(32) not null,
--EMAIL varchar2(40) not null,
--constraints member_id_pk primary key(ID),
--constraints member_email_uk unique (email)
--);
select * from member

insert into member values('abd12','3098','마현아','dkskdfjk@gmail.com');
insert into member values('rksk12','4918','오송민','dksdsfad4545k@gmail.com');
insert into member values('ekfk12','2853','김루본','hgfdhtjk@gmail.com');
insert into member values('akqk12','9114','이용훈','dsfahreahk@gmail.com');
insert into member values('tkwk14','8212','정혜원','fghk@gmail.com');
insert into member values('abd13','2283','최슬아','ytutyfkdfjk@gmail.com');

insert into crime values('1001','118','2019-05-18','절도강도',null,null);
insert into crime values('1018','118','2017-02-01','약취유인',null,null);
insert into crime values('1030','118','2020-06-01','상해폭행',null,null);
insert into crime values('1047','118','2020-05-28','약취유인',null,null);
insert into crime values('1019','119','2020-05-29','절도강도',null,null);
insert into crime values('1048','119','2010-02-01','절도강도',null,null);
insert into crime values('1077','119','2019-08-05','절도강도',null,null);
insert into crime values('1106','119','2020-05-20','절도강도',null,null);
insert into crime values('1135','119','2019-06-13','상해폭행',null,null);
insert into crime values('1164','119','2007-02-24','상해폭행',null,null);
insert into crime values('1193','119','2009-01-31','상해폭행',null,null);
insert into crime values('1222','119','2020-05-08','상해폭행',null,null);
insert into crime values('1251','119','2005-11-29','강간추행',null,null);
insert into crime values('1280','119','2017-11-18','강간추행',null,null);
insert into crime values('1309','119','2019-08-14','강간추행',null,null);
insert into crime values('1338','119','2017-12-26','강간추행',null,null);

insert into crime_type values('1','절도강도');
insert into crime_type values('2','살인');
insert into crime_type values('3','강간추행');
insert into crime_type values('4','약취유인');
insert into crime_type values('5','상해폭행');

insert into crime_location values('118','광주광역시','남구','송암로58번길');
insert into crime_location values('119','광주광역시','남구','송암로76번길');

insert into tip_info values('1000001','강간추행','2017-09-24','118',null);
insert into tip_info values('1000002','강간추행','2019-08-14','119',null);
insert into tip_info values('1000003','약취유인','2018-05-24','118',null);
insert into tip_info values('1000004','살인','2018-11-05','119',null);
insert into tip_info values('1000005','상해폭행','2018-12-06','118',null);
insert into tip_info values('1000006','상해폭행','2020-05-08','119',null);
insert into tip_info values('1000007','약취유인','2019-09-04','118',null);
insert into tip_info values('1000008','절도강도','2020-05-29','118',null);
insert into tip_info values('1000009','약취유인','2020-05-28','118',null);

insert into tipoff values('1000006','상해폭행','2020-05-08','119',null);
insert into tipoff values('1000008','절도강도','2020-05-29','118',null);
insert into tipoff values('1000009','약취유인','2020-05-28','118',null);

insert into alarm values('abd12','7','13','5');
insert into alarm values('rksk12','7','15','10');
insert into alarm values('ekfk12','2','20','15');
insert into alarm values('akqk12','6','9','13');
insert into alarm values('tkwk14','1','23','4');
insert into alarm values('abd13','12','19','7');

insert into member values('ff','2283','최슬아','ytutyfkdfjk@gmail.com');
insert into member values('fff','22','최슬아','ffff');
insert into member values('ffff','2283','최슬아','ggg');

