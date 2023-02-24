-- 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

CREATE DATABASE `Друзья человека`;
USE `Друзья человека`;

-- 8. Создать таблицы с иерархией из диаграммы в БД
CREATE TABLE `Животные`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_top VARCHAR(25)
);

INSERT INTO `Животные` (name_of_top)
VALUES 
('Домашние животные'),
('Вьючные животные')
;

CREATE TABLE `Домашние животные`
(
id int PRIMARY KEY AUTO_INCREMENT,
type_animal_Id int not null,
name_of_home_animal VARCHAR(10) not null,
foreign key (type_animal_Id) references `Животные` (id) on delete cascade
);

INSERT INTO `Домашние животные` (type_animal_Id, name_of_home_animal)
VALUES 
(1, 'Собаки'),
(1, 'Кошки'),
(1, 'Хомяки');

CREATE TABLE `Вьючные животные`
(
id int PRIMARY KEY AUTO_INCREMENT,
type_animal_Id int not null,
name_of_baggage_animal VARCHAR(10),
foreign key (type_animal_Id) references `Животные` (id) on delete cascade
);

INSERT INTO `Вьючные животные` (type_animal_Id, name_of_baggage_animal)
VALUES 
(2, 'Лошади'),
(2, 'Верблюды'),
(2, 'Ослы');

CREATE TABLE `Собаки`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(10),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Домашние животные` (id) on delete cascade
);

CREATE TABLE `Кошки`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(10),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Домашние животные` (id) on delete cascade
);

CREATE TABLE `Хомяки`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(10),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Домашние животные` (id) on delete cascade
);

CREATE TABLE `Лошади`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(10),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Вьючные животные` (id) on delete cascade
);

CREATE TABLE `Верблюды`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(10),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Вьючные животные` (id) on delete cascade
);

CREATE TABLE `Ослы`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(25),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Вьючные животные` (id) on delete cascade
);

-- 9. Заполнить низкоуровневые таблицы именами(животных), командами, которые они выполняют и датами рождения

INSERT INTO `Собаки` (name_of_animal, date_of_birth, instruction, object_id)
VALUES 
("Тузик", date '2022-10-15', "Дай лапу", 1),
("Шарик", date '2021-11-15', "Сидеть", 1);

INSERT INTO `Кошки` (name_of_animal, date_of_birth, instruction, object_id)
VALUES 
("Мурзик", date '2021-05-04', "Иди жрать", 2),
("Барон", date '2022-01-15', "Кис-кис", 2);

INSERT INTO `Хомяки` (name_of_animal, date_of_birth, instruction, object_id)
VALUES 
("Смурф", date '2022-09-22', "Бегай", 3),
("Крыс", date '2021-01-17', "Спи", 3);

INSERT INTO `Лошади` (name_of_animal, date_of_birth, instruction, object_id)
VALUES 
("Яблочко", date '2018-04-03', "Галоп", 1),
("Пегас", date '2015-03-04', "Прыжок", 1);

INSERT INTO `Верблюды` (name_of_animal, date_of_birth, instruction, object_id)
VALUES 
("Горбатый", date '2009-11-16', "Неси", 2),
("Двугорбый", date '2016-02-16', "Вези", 2);

INSERT INTO `Ослы` (name_of_animal, date_of_birth, instruction, object_id)
VALUES 
("Иа", date '2020-11-07', "Прыгай", 3),
("Александр Аркадьевич", date '1965-12-30', "Работай", 3);

-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку.
select * from `Верблюды`;
delete from `Верблюды`
where id > 0;
select * from `Верблюды`;

--  Объединить таблицы лошади, и ослы в одну таблицу.

select * from `Собаки`
union
select * from `Кошки`;

-- 11. Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице

CREATE TABLE `Молодые животные`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(25),
date_of_birth date,
instruction VARCHAR(15)
);
INSERT INTO `Молодые животные` (name_of_animal, date_of_birth, instruction)
SELECT name_of_animal, date_of_birth, instruction FROM `Собаки`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21'
union
SELECT name_of_animal, date_of_birth, instruction FROM `Кошки`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21'
union
SELECT name_of_animal, date_of_birth, instruction FROM `Хомяки`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21'
union
SELECT name_of_animal, date_of_birth, instruction FROM `Лошади`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21'
union
SELECT name_of_animal, date_of_birth, instruction FROM `Верблюды`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21'
union
SELECT name_of_animal, date_of_birth, instruction FROM `Ослы`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21';

select name_of_animal, date_of_birth, instruction, CEILING(DATEDIFF('2023-02-21', date_of_birth)/30) AS month from `Молодые животные`;

-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.

select * from `Собаки`
union
select * from `Кошки`
union
select * from `Хомяки`
union
select * from `Лошади`
union
select * from `Верблюды`
union
select * from `Ослы`;
-- id и object_id остались. Это считается?