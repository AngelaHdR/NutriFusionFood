-- use nutrifusionfoodtest;

    INSERT INTO category(id_category, name_es, name_en) VALUES(1,'Salado','Main dish');					
	INSERT INTO category(id_category, name_es, name_en) VALUES(2,'Postre','Dessert');					
	INSERT INTO category(id_category, name_es, name_en) VALUES(3,'Bebida','Drink');					
	INSERT INTO category(id_category, name_es, name_en) VALUES(4,'Snack','Snack');					
    
    
	INSERT INTO type(id_type, name_es, name_en) VALUES(1,'Carne','Meat');
	INSERT INTO type(id_type, name_es, name_en) VALUES(2,'Pescado','Fish');
	INSERT INTO type(id_type, name_es, name_en) VALUES(3,'Lácteo','Dairy');
	INSERT INTO type(id_type, name_es, name_en) VALUES(4,'Verdura','Vegetable');
	INSERT INTO type(id_type, name_es, name_en) VALUES(5,'Fruta','Fruit');
	INSERT INTO type(id_type, name_es, name_en) VALUES(6,'Hidratos','Hydrate');
		
        
	INSERT INTO ingredient(id_ingredient, gluten, lactose, name_es, name_en, start_season, end_season, id_type) VALUES(1,true,false,'Pan','Bread',1,12,6);											
	INSERT INTO ingredient(id_ingredient, gluten, lactose, name_es, name_en, start_season, end_season, id_type) VALUES(2,false,false,'Pollo','Chicken',1,12,1);											
	INSERT INTO ingredient(id_ingredient, gluten, lactose, name_es, name_en, start_season, end_season, id_type) VALUES(3,false,false,'Tomate','Tomato',5,8,5);											
	INSERT INTO ingredient(id_ingredient, gluten, lactose, name_es, name_en, start_season, end_season, id_type) VALUES(4,false,false,'Puerro','Leek',9,1,4);											
	INSERT INTO ingredient(id_ingredient, gluten, lactose, name_es, name_en, start_season, end_season, id_type) VALUES(5,false,true,'Helado','Ice cream',5,8,3);											
	
    
    INSERT INTO users (id_user, name_user, surname1, surname2, birth_date,nutritionist,pwd,email,username) VALUES(1,'Jose','Perez','Garcia','1989-08-18',true,'password1','mail1','jose');
	INSERT INTO users (id_user, name_user, surname1, surname2, birth_date,nutritionist,pwd,email,username) VALUES(2,'Alicia','Fernandez','Lopez','2000-12-04',false,'password2','mail2','alicia');
	INSERT INTO users (id_user, name_user, surname1, surname2, birth_date,nutritionist,pwd,email,username) VALUES(3,'Pepe','Escudero','Ramirez','1985-10-24',true,'password3','mail3','pepe');
	INSERT INTO users (id_user, name_user, surname1, surname2, birth_date,nutritionist,pwd,email,username) VALUES(4,'Mercedes','Gil','Diaz','2000-04-14',false,'password4','mail4','mercedes');
	
    
	INSERT INTO recipe (id_recipe, description_recipe, name_recipe, lang, time_recipe, steps, id_category, id_user) VALUES(1,'Es un tortilla al cual se le agregan patatas previamente cortadas y troceadas.','Tortilla de Patata','es',30,'paso 1',1,3);												
	INSERT INTO recipe (id_recipe, description_recipe, name_recipe, lang, time_recipe, steps, id_category, id_user) VALUES(2,'Gazpacho o puré frío a base de tomate, pan, aceite, ajo, propio de algunas zonas de Andalucía.','Salmorejo','es',60,'paso 2',1,1);												
	INSERT INTO recipe (id_recipe, description_recipe, name_recipe, lang, time_recipe, steps, id_category, id_user) VALUES(3,'Típica sopa Japonesa servida con fideos, carne y huevos.','Ramen','en',240,'paso 3',1,1);												
	INSERT INTO recipe (id_recipe, description_recipe, name_recipe, lang, time_recipe, steps, id_category, id_user) VALUES(4,'Rebanada de pan que es empapada en leche, almíbar o vino y se fríe en una sartén con aceite','Torrijas','es',45,'paso 4',2,3);												
	INSERT INTO recipe (id_recipe, description_recipe, name_recipe, lang, time_recipe, steps, id_category, id_user) VALUES(5,'Batido de frutas mezclado con leche o helado','Smoothie','en',15,'paso 5',3,3);												
	
    
    INSERT INTO tool(id_tool, name_es, name_en) VALUES(1,'Cuchara','Spoon');
	INSERT INTO tool(id_tool, name_es, name_en) VALUES(2,'Bol','Bowl');
	INSERT INTO tool(id_tool, name_es, name_en) VALUES(3,'Sarten','Pan');
	INSERT INTO tool(id_tool, name_es, name_en) VALUES(4,'Olla','Pot');
	INSERT INTO tool(id_tool, name_es, name_en) VALUES(5,'Vaso medidor','Measuring cup');
	INSERT INTO tool(id_tool, name_es, name_en) VALUES(6,'Batidora','Blender');
    
    
    INSERT INTO composed(id_recipe, id_ingredient) VALUES(2,3);			
	INSERT INTO composed(id_recipe, id_ingredient) VALUES(4,1);			
	INSERT INTO composed(id_recipe, id_ingredient) VALUES(5,5);	
    
    
    INSERT INTO required(id_recipe, id_tool) VALUES(1,3);
	INSERT INTO required(id_recipe, id_tool) VALUES(3,4);
	INSERT INTO required(id_recipe, id_tool) VALUES(4,1);
    
   