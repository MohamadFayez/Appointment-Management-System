drop table if exists appointments;
create table appointments
(
  appointment_id      bigint auto_increment,
  appointment_date    date not null,
  status              varchar(20) not null,
  cancellation_reason varchar(100)  not null,
  patient_id          bigint  not null,
primary key(appointment_id)
);

drop table if exists patients;
create table patients
(
  patient_id    bigint auto_increment,
  patient_name  varchar(200) not null,
  mobile_number varchar(100) not null,
primary key(patient_id)
);
