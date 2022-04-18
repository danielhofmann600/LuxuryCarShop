-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');
INSERT INTO car_shop.customer VALUES (0,'average','passme','richguy69');
INSERT INTO car_shop.customer VALUES (1,'good','1234','Josef Benzos');

INSERT INTO car_shop.car VALUES (0,'Mercedes-Maybach S-Klasse', 'Limusine', 'Schwarz', 286, false, false, 1);
INSERT INTO car_shop.car VALUES (1,'Maserati Levante', 'Limusine', 'Schwarz', 530, false, true, 1, 1);
INSERT INTO car_shop.car VALUES (2,'Lamborghini Urus', 'SUV', 'Schwarz', 650, true, false);
INSERT INTO car_shop.car VALUES (3,'McLaren 765LT Coupe', 'Sportwagen', 'Grün', 765, true, false);
INSERT INTO car_shop.car VALUES (4,'Jaguar E-Type III V-12', 'Cabrio Oldtimer', 'Braun', 276, true, false);





