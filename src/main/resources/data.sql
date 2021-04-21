
-- inserto expertos de prueba en la BD
INSERT INTO expert (autonomo, condiciones_porcentaje, condiciones_precio_hora, contacto_ciudad, contacto_email, contacto_linkedin, contacto_telefono, created_at, credenciales_correo, credenciales_correo_password, credenciales_zoom, credenciales_zoom_password, disponibilidad, estado, estado_motivo,fichero_cv, fichero_foto, modalidad, nif, nombre, observaciones, origen, puntuacion, updated_at) VALUES
	 (NULL,'10.00','15.00','Valencia','email@email.com','e','123456734','2021-04-21 12:16:00','Hola','','e','','mañanas',0,NULL,NULL,NULL,NULL,'12345678A','Mario López Serrano',NULL,NULL,70,'2021-04-21 12:16:00'),
	 (NULL,'10.00','15.00','Madrid','email2@email.com','e','223456734','2021-04-21','Hola','','e','','mañanas',0,NULL,NULL,NULL,NULL,'22345678A','María Martín Giménez',NULL,NULL,80,'2021-04-21'),
	 (NULL,'10.00','15.00','Barcelona','email3@email.com','e','323456734','2021-04-18','Hola','','e','','mañanas',1,NULL,NULL,NULL,NULL,'32345678A','Juan López Giménez',NULL,NULL,60,'2021-04-21'),
	 (NULL,'10.00','15.00','Mallorca','email4@email.com','e','423456734','2021-04-19','Hola','','e','','tardes',1,NULL,NULL,NULL,NULL,'42345678A','Josefina Sanchez Tur',NULL,NULL,50,'2021-04-21'),
	 (NULL,'10.00','15.00','Málaga','email5@email.com','e','523456734','2021-04-20','Hola','','e','','mañanas',1,NULL,NULL,NULL,NULL,'52345678A','Antonio Muñoz Muñoz',NULL,NULL,50,'2021-04-21'),
	 (NULL,'10.00','15.00','Málaga','email6@email.com','e','623456734','2021-04-21','Hola','','e','','mañanas',1,NULL,NULL,NULL,NULL,'62345678A','Fernando Carrasco López',NULL,NULL,70,'2021-04-21'),
	 (NULL,'10.00','15.00','Sevilla','email7@email.com','e','723456734','2021-04-14','Hola','','e','','tardes',1,NULL,NULL,NULL,NULL,'72345678A','Antonio Pérez Muñoz',NULL,NULL,70,'2021-04-21'),
	 (NULL,'10.00','15.00','Granada','email8@email.com','e','823456734','2021-04-21','Hola','','e','','mañanas y tardes',0,NULL,NULL,NULL,NULL,'82345678A','Marta Pérez Muñoz',NULL,NULL,70,'2021-04-21'),
	 (NULL,'10.00','15.00','Málaga','email9@email.com','e','923456734','2021-04-21','Hola','','e','','mañanas y tardes',0,NULL,NULL,NULL,NULL,'92345678A','Jorge Ruiz Campos',NULL,NULL,60,'2021-04-21'),
	 (NULL,'10.00','15.00','Málaga','email10@email.com','e','993456734','2021-04-20','Hola','','e','','mañanas y tardes',0,NULL,NULL,NULL,NULL,'13345678A','Steve Gates',NULL,NULL,70,'2021-04-21'),
	 (NULL,'10.00','15.00','Córdoba','email11@email.com','e','883456734','2021-04-21','Hola','','e','','mañanas y tardes',0,NULL,NULL,NULL,NULL,'72345678A','Sandra Carrasco Martín',NULL,NULL,70,'2021-04-21')
	 ;

-- inserto usuario con password codificada
INSERT INTO user (nombre_real, username, email, password) VALUES ('Jose Antonio Marí', 'admin1', 'admin1@email.com', '$2a$10$lBzSDeiPcfCrOXBljvc1BOyI32oa9BXfhks6xBx8WubO5WdfLnh3a');
