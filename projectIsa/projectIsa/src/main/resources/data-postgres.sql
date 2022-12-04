--password 123
--role REGISTERED 0 CENTERADMIN 1 SYSTEMADMIN 2 UNREGISTERED 3
--gender MALE 0 FEMALE 1 NONBINARY 2 OTHER 3
--complaint_type CENTER 0 STAFF 1

insert into center_address (id,longitude,latitude,street,city,state,house_number,postcode) values
(1,0,0,'Bulevar Oslobodjenja','Novi Sad','Srbija','5','21000');
insert into center_address (id,longitude,latitude,street,city,state,house_number,postcode) values
(2,0,0,'Bulevar Vojvode Stepe','Novi Sad','Srbija','10','21000');
insert into center_address (id,longitude,latitude,street,city,state,house_number,postcode) values
(3,0,0,'Beogradska','Beograd','Srbija','21','21000');
insert into center_address (id,longitude,latitude,street,city,state,house_number,postcode) values
(4,0,0,'Bulevar Vojvode Putnika','Beograd','Srbija','4','21000');
insert into center_address (id,longitude,latitude,street,city,state,house_number,postcode) values
(5,0,0,'Vojvode Putnika','Beograd','Srbija','4','21000');
insert into center_address (id,longitude,latitude,street,city,state,house_number,postcode) values
(6,0,0,'Putnikova','Beograd','Srbija','4','21000');

insert into center (id,name,description,rating, center_address_id) values
(1,'Centar Novi Sad','Centar za transfuziju krvi u Novom Sadu',5, 1);
insert into center (id,name,description,rating) values
(2,'Centar Novo Naselje','Centar za transfuziju krvi na Novom Naselju',2);
insert into center (id,name,description,rating) values
(3,'Centar Beograd','Centar za transfuziju krvi u Beogradu',3);
insert into center (id,name,description,rating) values
(4,'Centar Novi Beograd','Centar za transfuziju krvi na Novom Beogradu',4);
insert into center (id,name,description,rating) values
(5,'Beograd Centar','Centar za transfuziju krvi na Novom Beogradu',4);
insert into center (id,name,description,rating) values
(6,'Novi Beograd centar','Centar za transfuziju krvi na Novom Beogradu',5);

insert into users (id,role,name,surname,email,password,phone_number,jmbg,gender,has_to_change_pass) values
(1,2,'Pera','Perovic','pera@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0645654324','3012457898654', 0, false);
insert into users (id,role,name,surname,email,password,phone_number,jmbg,gender,has_to_change_pass, center_id) values
(2,1,'Mila','Milic','mila@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0696754324','2567854569852', 1, false, 1);
insert into users (id,role,name,surname,email,password,phone_number,jmbg,gender,has_to_change_pass) values
(3,0,'Vladimir','Vladic','vlada@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0626554304','4567894561234', 2, false);
insert into users (id,role,name,surname,email,password,phone_number,jmbg,gender,has_to_change_pass, center_id) values
(4,1,'Veljko','Veljkovic','veljko@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','064432123','1203894564321', 0, false,1);
insert into users (id,role,name,surname,email,password,phone_number,jmbg,gender,has_to_change_pass) values
(5,0,'Biljana','Brankovic','bilja@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0626254304','4567894561234', 1, false);
insert into users (id,role,name,surname,email,password,phone_number,jmbg,gender,has_to_change_pass) values
(6,0,'Marica','Maric','mara@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0626254304','4567894561234', 1, false);


insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(1,0,0,'Njegoseva','Novi Sad','Srbija','5','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(2,0,0,'Bulevar oslobodjenja','Novi Sad','Srbija','10','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(3,0,0,'Radnicka','Novi Sad','Srbija','21','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(4,0,0,'Danila Kisa','Novi Sad','Srbija','4','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(5,0,0,'Zmaj Jovina','Novi Sad','Srbija','8','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(6,0,0,'Rumenacka','Novi Sad','Srbija','110','21000');

insert into education (id,education,profession) values 
(1,'ftn','assistant');
insert into education (id,education,profession) values 
(2,'pmf','assistant');
insert into education (id,education,profession) values 
(3,'ftn','student');
insert into education (id,education,profession) values 
(4,'ftn','assistant');
insert into education (id,education,profession) values 
(5,'ftn','student');
insert into education (id,education,profession) values 
(6,'Srednja ekonomska skola, Novi Sad','penzioner');


UPDATE users SET address_id = 1, education_id = 1 WHERE users.id = 1;
UPDATE users SET address_id = 2, education_id = 2 WHERE users.id = 2;
UPDATE users SET address_id = 3, education_id = 3 WHERE users.id = 3;
UPDATE users SET address_id = 4, education_id = 4 WHERE users.id = 4;
UPDATE users SET address_id = 5, education_id = 5 WHERE users.id = 5;
UPDATE users SET address_id = 6, education_id = 6 WHERE users.id = 6;


insert into medical_equipment (id,quantity,blood_type) values 
(1,500,0);
insert into medical_equipment (id,quantity,blood_type) values 
(2,1000,1);
insert into medical_equipment (id,quantity,blood_type) values 
(3,400,2);
insert into medical_equipment (id,quantity,blood_type) values 
(4,300,3);


insert into survey (id,question) values
(1,'Да ли сте до сада добровољно давали крв или компоненте крви?');
insert into survey (id,question) values
(2,'Да ли сте икада били одбијени као давалац крви или компоненте крви?');
insert into survey (id,question) values
(3,'Да ли се тренутно осећате здравим, способним и одморним да дате крв или компоненте крви?');
insert into survey (id,question) values
(4,'Да ли сте нешто јели пре доласка на давање крви или компоненте крви?');
insert into survey (id,question) values
(5,'Да ли се бавите опасним занимањем или хобијем?');
insert into survey (id,question) values
(6,'Да ли редовно (свакодневно) узимате било какве лекове?');
insert into survey (id,question) values
(7,'Да ли сте последња 2-3 дана узимали било какве лекове (нпр. Бруфен, Кафетин, Аналгин...)?');
insert into survey (id,question) values
(8,'Да ли стално узимате Аспирин (Cardiopirin)? Да ли сте га узимали у последњих 5 дана?');
insert into survey (id,question) values
(9,'Да ли сте до сада испитивани или лечени у болници или сте тренутно на испитивању или боловању?');
insert into survey (id,question) values
(10,'Да ли сте вадили зуб у протеклих 7 дана?');


insert into complaints(id,complaint_type, complaint,answer,registered_user_id, complaint_date, answer_date, system_adminstrator_id) values
(1,0,'Nemaju potrebnu opremu','Hvala Vam na utisku. Potrudicemo se da to popravimo.', 3, '2021-10-10 18:30:12', '2021-10-12 16:30:18', 1);
insert into complaints(id,complaint_type, complaint,answer,registered_user_id, complaint_date, answer_date, system_adminstrator_id) values
(2,1,'Nestucni','Hvala Vam na utisku. Potrudicemo se da to popravimo.', 3, '2022-11-10 22:11:35', '2021-11-11 10:30:12', 1);
insert into complaints(id,complaint_type, complaint,registered_user_id, complaint_date) values
(3,0,'Manjak opreme', 5, '2022-04-08 10:05:23');
insert into complaints(id,complaint_type, complaint,registered_user_id, complaint_date) values
(4,1,'Neljubazni', 5, '2022-09-04 12:21:09');
insert into complaints(id,complaint_type, complaint,registered_user_id, complaint_date) values
(5,0,'Raspada se zgrada', 6, '2022-11-15 19:43:03');
insert into complaints(id,complaint_type, complaint,registered_user_id, complaint_date) values
(6,1,'Cela ruka mi je u podlivima, ne zna da nadje venu.', 6, '2022-09-10 10:15:35');

UPDATE complaints SET user_id = 2 WHERE complaints.id = 2;
UPDATE complaints SET user_id = 2 WHERE complaints.id = 4;
UPDATE complaints SET user_id = 4 WHERE complaints.id = 6;
UPDATE complaints SET center_id = 1 WHERE complaints.id = 1;
UPDATE complaints SET center_id = 1 WHERE complaints.id = 3;
UPDATE complaints SET center_id = 2 WHERE complaints.id = 5;

insert into appointment(id, date, duration, taken, center_id, registered_user_id) values
(1, '2022-12-07 12:00:00', 30, true, 1, 3);
insert into appointment(id, date, duration, taken, center_id, registered_user_id) values
(2, '2022-12-07 12:30:00', 30, true, 1, 3);

alter sequence user_entity_id_seq restart with 7;
alter sequence user_address_id_seq restart with 7;
alter sequence user_education_id_seq restart with 7;
alter sequence center_id_seq restart with 7;
alter sequence center_address_id_seq restart with 7;
alter sequence complaint_id_seq restart with 7;
alter sequence appointment_id_seq restart with 2;