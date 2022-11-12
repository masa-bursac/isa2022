--password 123
--role REGISTERED 0 CENTERADMIN 1 SYSTEMADMIN 2 UNREGISTERED 3
--gender MALE 0 FEMALE 1 NONBINARY 2 OTHER 3

insert into center_address (id,longitude,latitude,street,city,state,house_number,postcode) values
(1,0,0,'Bulevar Oslobodjenja','Novi Sad','Srbija','5','21000');
insert into center_address (id,longitude,latitude,street,city,state,house_number,postcode) values
(2,0,0,'Bulevar Vojvode Stepe','Novi Sad','Srbija','10','21000');
insert into center_address (id,longitude,latitude,street,city,state,house_number,postcode) values
(3,0,0,'Beogradska','Beograd','Srbija','21','21000');
insert into center_address (id,longitude,latitude,street,city,state,house_number,postcode) values
(4,0,0,'Bulevar Vojvode Putnika','Beograd','Srbija','4','21000');

insert into center (id,name,description,rating, center_address_id) values
(1,'Centar Novi Sad','Centar za transfuziju krvi u Novom Sadu',5, 1);
insert into center (id,name,description,rating) values
(2,'Centar Novo Naselje','Centar za transfuziju krvi na Novom Naselju',3);
insert into center (id,name,description,rating) values
(3,'Centar Beograd','Centar za transfuziju krvi u Beogradu',5);
insert into center (id,name,description,rating) values
(4,'Centar Novi Beograd','Centar za transfuziju krvi na Novom Beogradu',4);

insert into users (id,role,name,surname,email,password,phone_number,jmbg,gender,has_to_change_pass) values
(1,2,'Pera','Perovic','pera@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0645654324','3012457898654', 0, false);
insert into users (id,role,name,surname,email,password,phone_number,jmbg,gender,has_to_change_pass, center_id) values
(2,1,'Mila','Milic','mila@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0696754324','2567854569852', 1, false, 1);
insert into users (id,role,name,surname,email,password,phone_number,jmbg,gender,has_to_change_pass) values
(3,0,'Vladimir','Vladic','vlada@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0626554304','4567894561234', 2, false);
insert into users (id,role,name,surname,email,password,phone_number,jmbg,gender,has_to_change_pass, center_id) values
(4,1,'Veljko','Veljkovic','veljko@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','064432123','1203894564321', 0, false,1);


insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(1,0,0,'Njegoseva','Novi Sad','Srbija','5','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(2,0,0,'Bulevar oslobodjenja','Novi Sad','Srbija','10','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(3,0,0,'Radnicka','Novi Sad','Srbija','21','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(4,0,0,'Danila Kisa','Novi Sad','Srbija','4','21000');

insert into education (id,education,profession) values 
(1,'ftn','assistant');
insert into education (id,education,profession) values 
(2,'pmf','assistant');
insert into education (id,education,profession) values 
(3,'ftn','student');
insert into education (id,education,profession) values 
(4,'ftn','assistant');


UPDATE users SET address_id = 1, education_id = 1 WHERE users.id = 1;
UPDATE users SET address_id = 2, education_id = 2 WHERE users.id = 2;
UPDATE users SET address_id = 3, education_id = 3 WHERE users.id = 3;
UPDATE users SET address_id = 4, education_id = 4 WHERE users.id = 4;


insert into medical_equipment (id,quantity,blood_type) values 
(1,500,0);
insert into medical_equipment (id,quantity,blood_type) values 
(2,1000,1);
insert into medical_equipment (id,quantity,blood_type) values 
(3,400,2);
insert into medical_equipment (id,quantity,blood_type) values 
(4,300,3);


alter sequence user_entity_id_seq restart with 5;
alter sequence user_address_id_seq restart with 5;
alter sequence user_education_id_seq restart with 5;
alter sequence center_id_seq restart with 5;
alter sequence center_address_id_seq restart with 5;