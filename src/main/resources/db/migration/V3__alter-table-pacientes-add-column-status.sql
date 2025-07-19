ALTER TABLE medicos MODIFY estatus TINYINT NOT NULL;

ALTER TABLE pacientes ADD estatus TINYINT;

UPDATE pacientes SET estatus = 1;

ALTER TABLE pacientes MODIFY estatus TINYINT NOT NULL;