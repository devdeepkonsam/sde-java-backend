UPDATE students SET address = '987 cedar st'
WHERE name = "Alice";
/*if sql is in safe mode, it will not update any record and throw an error,
if the where clause doesn't have primary key or unique key.*/