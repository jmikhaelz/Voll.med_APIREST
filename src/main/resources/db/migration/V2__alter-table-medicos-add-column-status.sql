ALTER TABLE medicos ADD estatus TINYINT;

UPDATE medicos SET estatus = 1;