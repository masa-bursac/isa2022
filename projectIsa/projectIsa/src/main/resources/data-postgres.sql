--password 123
insert into users (role,id,email,name,password,phone_number,surname,jmbg,gender) values
(2,1,'pera@gmail.com','Pera','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0645654324','Perovic','3012457898654', 0);
insert into users (role,id,email,name,password,phone_number,surname,jmbg,gender) values
(1,2,'mila@gmail.com','Mila','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0696754324','Milic','2567854569852', 1);
insert into users (role,id,email,name,password,phone_number,surname,jmbg,gender) values
(0,3,'vlada@gmail.com','Vladimir','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0626554304','Vladic','4567894561234', 2);
insert into users (role,id,email,name,password,phone_number,surname,jmbg,gender) values
(2,4,'veljko@gmail.com','Veljko','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','064432123','Veljkovic','4568521236987', 3);

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

alter sequence user_entity_id_seq restart with 5;
alter sequence user_address_id_seq restart with 5;
alter sequence user_education_id_seq restart with 5;