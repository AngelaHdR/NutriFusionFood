/*Crear usuarios bbdd*/

-- rol de administrador con todos los permisos de busqueda, insercion, actualizacion y borrado
Create role 'administrador';

grant select on nutrifusionfood.* to  administrador;
grant insert on nutrifusionfood.* to  administrador;
grant update on nutrifusionfood.* to  administrador;
grant delete on nutrifusionfood.* to  administrador;

grant select on nutrifusionfoodtest.* to  administrador;
grant insert on nutrifusionfoodtest.* to  administrador;
grant update on nutrifusionfoodtest.* to  administrador;
grant delete on nutrifusionfoodtest.* to  administrador;
flush privileges;

-- usuario administrador con rol
Create user 'adminNFF'@'localhost' IDENTIFIED with mysql_native_password by 'NutriFusionFood%';
grant administrador to adminNFF@localhost;
flush privileges;

-- rol de nutricionista con permisos de busqueda en todas las tablas, insercion en las tablas receta, ingrediente y utensilios
-- actualizacion de sus propias recetas y la información del perfil y borrado de sus propias recetas
Create role  'nutritionist';

grant select on nutrifusionfood.* to  nutritionist;
grant insert on nutrifusionfood.recipe to nutritionist;
grant insert on nutrifusionfood.ingredient to nutritionist;
grant insert on nutrifusionfood.tool to nutritionist;
grant update on nutrifusionfood.recipe to  nutritionist;
grant update on nutrifusionfood.user to  nutritionist;
grant delete on nutrifusionfood.recipe to  nutritionist;
flush privileges;

-- nutricionistas con rol
Create user 'angela'@'localhost' IDENTIFIED with mysql_native_password by 'Nutritionits';
grant nutritionist to angela@localhost;
Create user 'sole'@'localhost' IDENTIFIED with mysql_native_password by 'Nutritionits';
grant nutritionist to sole@localhost;
Create user 'andreu'@'localhost' IDENTIFIED with mysql_native_password by 'Nutritionits';
grant nutritionist to andreu@localhost;
Create user 'victor'@'localhost' IDENTIFIED with mysql_native_password by 'Nutritionits';
grant nutritionist to victor@localhost;
flush privileges;

-- role de cliente con permisos de busqueda en todas las tablas y acutalizacion de la informacion del perfil
Create role  'cliente';

grant select on nutrifusionfood.* to  cliente;
grant update on nutrifusionfood.user to  cliente;
flush privileges;

-- clientes con rol
Create user 'alicia'@'localhost' IDENTIFIED with mysql_native_password by 'Cliente';
grant cliente to alicia@localhost;