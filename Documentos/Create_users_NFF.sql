/*Crear usuarios bbdd*/

-- usuario administrador con todos los permisos de busqueda, insercion, actualizacion y borrado
Create user  'adminNFF'@'localhost' IDENTIFIED with mysql_native_password by 'NutriFusionFood%';

grant select on nutrifusionfood.* to  adminNFF@localhost;
grant insert on nutrifusionfood.* to  adminNFF@localhost;
grant update on nutrifusionfood.* to  adminNFF@localhost;
grant delete on nutrifusionfood.* to  adminNFF@localhost;
flush privileges;

-- usuario nutricionista con permisos de busqueda en todas las tablas, insercion en las tablas receta, ingrediente y utensilios
-- actualizacion de sus propias recetas y la información del perfil y borrado de sus propias recetas
Create user  'nutritionist'@'localhost' IDENTIFIED with mysql_native_password by 'Nutritionits';

grant select on nutrifusionfood.* to  adminNFF@localhost;
grant insert on nutrifusionfood.recipe to nutritionist@localhost;
grant insert on nutrifusionfood.ingredient to nutritionist@localhost;
grant insert on nutrifusionfood.tool to nutritionist@localhost;
grant update on nutrifusionfood.recipe to  nutritionist@localhost;
grant update on nutrifusionfood.user to  nutritionist@localhost;
grant delete on nutrifusionfood.recipe to  nutritionist@localhost;
flush privileges;

-- usuario cliente con permisos de busqueda en todas las tablas y acutalizacion de la informacion del perfil
Create user  'cliente'@'localhost' IDENTIFIED with mysql_native_password by 'Cliente';

grant select on nutrifusionfood.* to  adminNFF@localhost;
grant update on nutrifusionfood.user to  nutritionist@localhost;
flush privileges;
