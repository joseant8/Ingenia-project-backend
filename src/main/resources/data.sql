
-- inserto expertos de prueba en la BD
INSERT INTO expert (autonomo, condiciones_porcentaje, condiciones_precio_hora, contacto_ciudad, contacto_email, contacto_linkedin, contacto_telefono, created_at, credenciales_correo, credenciales_correo_password, credenciales_zoom, credenciales_zoom_password, disponibilidad, estado, estado_motivo,fichero_cv, fichero_foto, modalidad, nif, nombre, observaciones, origen, puntuacion, updated_at) VALUES
	 (NULL,'10.00','15.00','Valencia','email@email.com','https://es.linkedin.com','123456734','2021-04-21 12:16:00','Hola','','e','','mañanas',0,NULL,NULL,NULL,NULL,'12345678A','Mario López Serrano',NULL,NULL,70,'2021-04-21 12:16:00'),
	 (NULL,'10.00','15.00','Madrid','email2@email.com','https://es.linkedin.com','223456734','2021-04-21','Hola','','e','','mañanas',0,NULL,NULL,NULL,NULL,'22345678A','María Martín Giménez',NULL,NULL,80,'2021-04-21'),
	 (NULL,'10.00','15.00','Barcelona','email3@email.com','https://es.linkedin.com','323456734','2021-04-18','Hola','','e','','mañanas',1,NULL,NULL,NULL,NULL,'32345678A','Juan López Giménez',NULL,NULL,60,'2021-04-21'),
	 (NULL,'10.00','15.00','Mallorca','email4@email.com','https://es.linkedin.com','423456734','2021-04-19','Hola','','e','','tardes',1,NULL,NULL,NULL,NULL,'42345678A','Josefina Sanchez Tur',NULL,NULL,50,'2021-04-21'),
	 (NULL,'10.00','15.00','Málaga','email5@email.com','https://es.linkedin.com','523456734','2021-04-20','Hola','','e','','mañanas',1,NULL,NULL,NULL,NULL,'52345678A','Antonio Muñoz Muñoz',NULL,NULL,50,'2021-04-21'),
	 (NULL,'10.00','15.00','Málaga','email6@email.com','https://es.linkedin.com','623456734','2021-04-21','Hola','','e','','mañanas',1,NULL,NULL,NULL,NULL,'62345678A','Fernando Carrasco López',NULL,NULL,70,'2021-04-21'),
	 (NULL,'10.00','15.00','Sevilla','email7@email.com','https://es.linkedin.com','723456734','2021-04-14','Hola','','e','','tardes',1,NULL,NULL,NULL,NULL,'72345678A','Antonio Pérez Muñoz',NULL,NULL,70,'2021-04-21'),
	 (NULL,'10.00','15.00','Granada','email8@email.com','https://es.linkedin.com','823456734','2021-04-21','Hola','','e','','mañanas y tardes',0,NULL,NULL,NULL,NULL,'82345678A','Marta Pérez Muñoz',NULL,NULL,20,'2021-04-21'),
	 (NULL,'10.00','15.00','Málaga','email9@email.com','https://es.linkedin.com','923456734','2021-04-21','Hola','','e','','mañanas y tardes',0,NULL,NULL,NULL,NULL,'92345678A','Jorge Ruiz Campos',NULL,NULL,30,'2021-04-21'),
	 (NULL,'10.00','15.00','Málaga','email10@email.com','https://es.linkedin.com','993456734','2021-04-20','Hola','','e','','mañanas y tardes',0,NULL,NULL,NULL,NULL,'13345678A','Steve Gates',NULL,NULL,70,'2021-04-21'),
	 (NULL,'10.00','15.00','Córdoba','email11@email.com','https://es.linkedin.com','883456734','2021-04-21','Hola','','e','','mañanas y tardes',0,NULL,NULL,NULL,NULL,'72345678A','Sandra Carrasco Martín',NULL,NULL,70,'2021-04-21')
	 ;


-- inserto etiquetas de prueba en la BD
INSERT INTO tag (nombre, created_at) VALUES ('React', '2021-04-21 12:16:00');
INSERT INTO tag (nombre, created_at) VALUES ('Angular', '2021-04-21 12:16:00');
INSERT INTO tag (nombre, created_at) VALUES ('Spring', '2021-04-21 12:16:00');
INSERT INTO tag (nombre, created_at) VALUES ('Java', '2021-04-21 12:16:00');
INSERT INTO tag (nombre, created_at) VALUES ('JavaScript', '2021-04-21 12:16:00');
INSERT INTO tag (nombre, created_at) VALUES ('TypeScript', '2021-04-21 12:16:00');
INSERT INTO tag (nombre, created_at) VALUES ('C', '2021-04-21 12:16:00');
INSERT INTO tag (nombre, created_at) VALUES ('Docker', '2021-04-21 12:16:00');
INSERT INTO tag (nombre, created_at) VALUES ('Python', '2021-04-21 12:16:00');
INSERT INTO tag (nombre, created_at) VALUES ('Django', '2021-04-21 12:16:00');


-- inserto usuario con password codificada
INSERT INTO user (nombre_completo, username, password) VALUES ('Jose Antonio Marí', 'admin1@email.com', '$2a$10$lBzSDeiPcfCrOXBljvc1BOyI32oa9BXfhks6xBx8WubO5WdfLnh3a');


-- Relaciones
-- inserto relaciones expertos-etiquetas
INSERT INTO expert_tag (expert_id, tag_id) VALUES (1, 1),(1,2),(1,5),(1,6);
INSERT INTO expert_tag (expert_id, tag_id) VALUES (2, 1),(2,2),(2,5),(2,6);
INSERT INTO expert_tag (expert_id, tag_id) VALUES (3, 9),(3,10),(3,3),(3,4);
INSERT INTO expert_tag (expert_id, tag_id) VALUES (4, 9),(4,10),(4,3),(4,4);
INSERT INTO expert_tag (expert_id, tag_id) VALUES (5, 7),(5,2),(5,5),(5,6);
INSERT INTO expert_tag (expert_id, tag_id) VALUES (6, 7),(6,2),(6,5),(6,6);
INSERT INTO expert_tag (expert_id, tag_id) VALUES (7, 4),(7,3),(7,5),(7,6);
INSERT INTO expert_tag (expert_id, tag_id) VALUES (8, 4),(8,3),(8,7);
INSERT INTO expert_tag (expert_id, tag_id) VALUES (9, 4),(9,3),(9,7);
INSERT INTO expert_tag (expert_id, tag_id) VALUES (10, 4),(10,3);
INSERT INTO expert_tag (expert_id, tag_id) VALUES (11, 4),(11,3);


-- relaciones usuario(creador)-etiqueta
UPDATE TAG SET user_id=1 where id=1;
UPDATE TAG SET user_id=1 where id=2;
UPDATE TAG SET user_id=1 where id=3;
UPDATE TAG SET user_id=1 where id=4;
UPDATE TAG SET user_id=1 where id=5;
UPDATE TAG SET user_id=1 where id=6;
UPDATE TAG SET user_id=1 where id=7;
UPDATE TAG SET user_id=1 where id=8;
UPDATE TAG SET user_id=1 where id=9;
UPDATE TAG SET user_id=1 where id=10;