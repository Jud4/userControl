insert INTO rol (id,name) values (nextval('rol_seq'),'Admin'),
                                (nextval('rol_seq'),'Moderator'),
                                (nextval('rol_seq'),'Lead'),
                                (nextval('rol_seq'),'Developer');

insert into user_table (id, username, password, email, created_at)
VALUES (nextval('user_seq'),'jotas','pass123','juanjo@gmail.com','2023-11-22 15:03:59.414620'),
       (nextval('user_seq'),'vinny123','pass123','vingo@gmail.com','2023-11-22 15:06:19.393981'),
       (nextval('user_seq'),'juana123','pass123','juanas@gmail.com','2023-11-22 15:37:26.055755'),
       (nextval('user_seq'),'vector123','pass123','victorsdn@gmail.com','2023-11-22 18:16:45.094863');

INSERT INTO user_detail (id, first_name, last_name, age, birth_day, user_id)
VALUES (nextval('user_detail_seq'),'Victor','Smith',37,'1984-05-31',4);

INSERT INTO user_rol (id, active, created_at, user_id, rol_id)
VALUES (nextval('user_rol_seq'),false,'2023-11-23 14:57:23.384772',4,1),
       (nextval('user_rol_seq'),true,'2023-11-23 14:57:23.384772',1,3);