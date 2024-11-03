INSERT INTO project.doctors (id, first_name, last_name, specialization_id)
VALUES (1, 'Андрей', 'Иванов', 1),
       (2, 'Ольга', 'Петрова', 2),
       (3, 'Дмитрий', 'Смирнов', 3),
       (4, 'Елена', 'Кузнецова', 1),
       (5, 'Максим', 'Попов', 4),
       (6, 'Анна', 'Васильева', 2),
       (7, 'Игорь', 'Соколов', 5);
INSERT INTO project.patients(id, first_name, last_name)
VALUES (1, 'Николай', 'Сидоров'),
       (2, 'Михаил', 'Козлов'),
       (3, 'Антон', 'Сидоров'),
       (4, 'Петр', 'Петров'),
       (5, 'Сергей', 'Антонов'),
       (6, 'Анна', 'Максимова'),
       (7, 'Мария', 'Соловьева'),
       (8, 'Юрий', 'Сюткин'),
       (9, 'Виктор', 'Пупков'),
       (10, 'Александр', 'Алексеев'),
       (11, 'Дмитрий', 'Власов'),
       (12, 'Сергей', 'Зверев');
INSERT INTO project.specializations(id, name)
VALUES (1, 'Стоматолог'),
       (2, 'Кардиолог'),
       (3, 'Пульмоногол'),
       (4, 'Уролог'),
       (5, 'Хирург'),
       (6, 'Терапевт'),
       (7, 'Эндокринолог');
INSERT INTO project.doctor_patient (doctor_id, patient_id)
VALUES (1, 1),
       (1, 2),
       (3, 3),
       (6, 5),
       (6, 3),
       (7, 2),
       (4, 10)
INSERT INTO project.user (id,username, password, role)
VALUES (1,'andrey@mail.ru', '{noop}123', 'ADMIN');