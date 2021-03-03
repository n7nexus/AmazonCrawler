insert into parser
values row(1, '2021-02-26'), row(2, '2021-02-27');

insert into monitoring_parameters
values row(1, "Направление мониторинга", "Направление мониторинга"), row(2, "Название Тарифа", "Название Тарифа"), row(3, "URL Тарифа", "URL Тарифа"), row(4, "Количество запросов", "Количество запросов"), row(5, "Название запроса", "Название запроса"), row(6, "Цена", "Цена");

insert into region
values row(1, "Восток США (Сев. Вирджиния)"), row(2, "Восток США (Огайо)");

insert into collected_parameters
values row(1, null, "Облачный контент", 1, 1, 1), 
row(2, 1, "S3 Standard", 1, 2, 1), 
row(3, 2, "https://aws.amazon.com/ru/s3/pricing/", 1, 3, 1), 
row(4, 2, "PUT", 1, 5, 1), 
row(5, 4, "1000", 1, 4, 1), 
row(6, 4, "0,005", 1, 6, 1);

insert into collected_parameters
values row(7, null, "Облачный контент", 1, 1, 2), 
row(8, 7, "S3 Standard", 1, 2, 2), 
row(9, 8, "https://aws.amazon.com/ru/s3/pricing/", 1, 3, 1), 
row(10, 8, "PUT", 1, 5, 2), 
row(11, 10, "1000", 1, 4, 2), 
row(12, 10, "0,005", 1, 6, 2);

insert into collected_parameters
values row(13, null, "Облачный контент", 2, 1, 1), 
row(14, 13, "S3 Standard", 2, 2, 1), 
row(15, 14, "https://aws.amazon.com/ru/s3/pricing/", 2, 3, 1), 
row(16, 14, "PUT", 2, 5, 1), 
row(17, 16, "1000", 2, 4, 1), 
row(18, 16, "0,005", 2, 6, 1);

insert into collected_parameters
values row(19, null, "Облачный контент", 2, 1, 2), 
row(20, 19, "S3 Standard", 2, 2, 2), 
row(21, 20, "https://aws.amazon.com/ru/s3/pricing/", 2, 3, 2), 
row(22, 20, "PUT", 2, 5, 2), 
row(23, 22, "1000", 2, 4, 2), 
row(24, 22, "0,005", 2, 6, 2);

