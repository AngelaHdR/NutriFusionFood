use nutrifusionfood;

	INSERT INTO category(id_category, name_es, name_en) VALUES(1,'Salado','Main dish');
	INSERT INTO category(id_category, name_es, name_en) VALUES(2,'Postre','Dessert');
	INSERT INTO category(id_category, name_es, name_en) VALUES(3,'Bebida','Drink');
	INSERT INTO category(id_category, name_es, name_en) VALUES(4,'Snack','Snack');
    
    INSERT INTO type VALUES (1,'Carne','Meat');
	INSERT INTO type VALUES (2,'Pescado','Fish');
	INSERT INTO type VALUES (3,'Lácteo','Dairy');
	INSERT INTO type VALUES (4,'Verdura','Vegetable');
	INSERT INTO type VALUES (5,'Fruta','Fruit');
	INSERT INTO type VALUES (6,'Hidratos','Hydrate');
    INSERT INTO type VALUES (7,'Otros','Other');
    
    INSERT INTO ingredient VALUES (1,true,false,'Pan','Bread',1,12,6);
	INSERT INTO ingredient VALUES (2,false,false,'Pollo','Chicken',1,12,1);
	INSERT INTO ingredient VALUES (3,false,false,'Tomate','Tomato',1,12,5);
	INSERT INTO ingredient VALUES (4,false,false,'Puerro','Leek',1,12,4);
	INSERT INTO ingredient VALUES (5,false,true,'Helado','Ice cream',1,12,3);
	INSERT INTO ingredient VALUES (6,false,false,'Fresa','Strawberry',1,12,5);
	INSERT INTO ingredient VALUES (7,false,false,'Cerdo','Pig',1,12,1);
	INSERT INTO ingredient VALUES (8,false,false,'Patata','Potato',1,12,7);
	INSERT INTO ingredient VALUES (9,false,true,'Leche','Milk',1,12,3);
	INSERT INTO ingredient VALUES (10,false,false,'Merluza','Hake',1,12,2);
	INSERT INTO ingredient VALUES (11,false,false,'Huevo','Egg',1,12,7);
	INSERT INTO ingredient VALUES (12,false,false,'Cebolla','Onion',1,12,4);
	INSERT INTO ingredient VALUES (13,true,false,'Harina','Flour',1,12,6);
	INSERT INTO ingredient VALUES (14,false,false,'Aceite','Oil',1,12,7);
	INSERT INTO ingredient VALUES (15,false,false,'Bacon','Bacon',1,12,1);
	INSERT INTO ingredient VALUES (16,false,false,'Carne picada','Mince meat',1,12,1);
	INSERT INTO ingredient VALUES (17,false,false,'Pimiento','Red pepper',1,12,4);
	INSERT INTO ingredient VALUES (18,false,false,'Pulpo','Octopus',1,12,2);
	INSERT INTO ingredient VALUES (19,false,false,'Gamba','Prawn',1,12,2);
	INSERT INTO ingredient VALUES (20,false,false,'Judia','Green bean',1,12,4);
	INSERT INTO ingredient VALUES (21,false,false,'Azucar','Sugar',1,12,7);
	INSERT INTO ingredient VALUES (22,false,true,'Nata','Cream',1,12,3);
	INSERT INTO ingredient VALUES (23,false,false,'Zanahoria','Carrot',1,12,4);
	INSERT INTO ingredient VALUES (24,false,false,'Arandanos','Blueberries',1,12,5);
	INSERT INTO ingredient VALUES (25,true,false,'Cafe','Coffee',1,12,7);
	INSERT INTO ingredient VALUES (26,false,false,'Naranja','Orange',1,12,5);
	INSERT INTO ingredient VALUES (27,false,false,'Chocolate','Chocolate',1,12,7);
	INSERT INTO ingredient VALUES (28,false,false,'Jamon serrano','Ham',1,12,1);
	INSERT INTO ingredient VALUES (29,false,false,'Mejillones','Mussels',1,12,2);
	INSERT INTO ingredient VALUES (30,true,false,'Espaguetis','Spaghetti',1,12,6);
	INSERT INTO ingredient VALUES (31,true,false,'Macarrones','Macaroni',1,12,6);
	INSERT INTO ingredient VALUES (32,false,false,'Arroz','Rice',1,12,6);
    
	INSERT INTO users VALUES (1,'Jose','Perez','Garcia','jose','josepegar@gmail.com','1935-12-08',true,'abcgr43k');
	INSERT INTO users VALUES (2,'Alicia','Fernandez','Lopez','alicia','alifernanlop@gmail.com','1995-06-21',false,'cdpo31df');
	INSERT INTO users VALUES (3,'Pepe','Escudero','Ramirez','pepe','pepescura@gmail.com','1985-10-24',true,'plqw98j3');
	INSERT INTO users VALUES (4,'Mercedes','Gil','Diaz','mercedes','mercedergil@gmail.com','2000-04-14',false,'afdgr43k');
	INSERT INTO users VALUES (5,'Soledad','Berenguer','Reyes','Sole','salesher@gmail.com','2002-03-28',true,'fepo31df');
	INSERT INTO users VALUES (6,'Angela','Hermosilla','del Rio','Angela','angela321@gmail.com','2002-06-10',true,'plqw9lo1');
	INSERT INTO users VALUES (7,'Cain','Medina','Roca','Kayn','medroca@gmail.com','1982-03-23',false,'lpcgr43k');
	INSERT INTO users VALUES (8,'Andreu','Alfonso','Megina','Andreu','andre14@gmail.com','2002-10-08',true,'clpo31dr');
	INSERT INTO users VALUES (9,'Victor','Garcia','Espert','Victor','vgaresp213@gmail.com','2001-03-02',true,'vlqx48j5');
	INSERT INTO users VALUES (10,'Carla','Rubio','Delgado','Carla','delcar@gmail.com','1973-08-19',false,'pbdg123f');
	INSERT INTO users VALUES (11,'Patricio','Real','Pastor','Patri','realp@gmail.com','2001-10-06',true,'n3go31df');
	INSERT INTO users VALUES (12,'Sofia','Moreno','Navarro','Sofi','sofea73@gmail.com','1979-09-15',false,'pl1q98j6');

    INSERT INTO recipe VALUES (1,'Es un tortilla al cual se le agregan patatas previamente cortadas y troceadas.','Tortilla de Patata','paso 1. Pelamos las patatas, las lavamos para quitar restos de suciedad, las cortamos en láminas semifinas,
las colocamos en un bol grande y añadimos sal y removemos.
paso 2. Ponemos una sartén al fuego con aceite de oliva 
paso 3. Introducimos las patatas y las dejamos cocinando duran 30 mins a fuego bajo
paso 4. Batimos los huevos en el bol y cortamos la cebolla muy fina mientras esperamos
paso 5. Pochamos la cebolla en otra sartén y escurrimos las patatas con una espumadera y mezclamos
todo con el huevo en el bol
paso 6. Añadimos esta mezcla a una sarten y cocinamos 4 mins por cada lado (poco hecha)','es',45,3,1);
	INSERT INTO recipe VALUES (2,'Gazpacho o puré frío a base de tomate, pan, aceite, ajo, propio de algunas zonas de Andalucía.','Salmorejo','paso 1. Limpiamos los tomates y los cortamos en cuatro y los trituramos en un bol hasta que sea líquido
paso 2. Pasamos esta salsa por un colador
paso 3. Cortamos el pan, lo añadimos a la salsa y lo dejamos 10 mins en reposo 
paso 4. Hechamos el ajo, sal y aceite de oliva y lo batimos
paso 5. Por último lo metemos en la nevera y dejámos que se enfrie','es',20,8,1);
	INSERT INTO recipe VALUES (3,'Japanese soup with noodles, eggs and meat','Ramen',"step 1. Let's start with broth, if it's store-bought, heat it and season it with soy sauce, salt and sake if not 
simmer chicken, pork bones, or vegetables in water for a few hours.
step 2. Cook the protein you want to add in a separate pan and set it aside.
step 3. Cook the ramen noodles according to the package instructions and rinse them with cold water
step 4. Chop and prepare the vegetables, add them to the broth or cook them separately 
step 5. First, add the noodles folowed of the broth, finally add the proteins and the vegetables ",'en',240,6,1);
	INSERT INTO recipe VALUES (4,'Rebanada de pan que es empapada en leche, almíbar o vino y se fríe en una sartén con aceite','Torrijas','paso 1. Calienta la leche, un poco de azúcar y cáscara de limón o naranja en una cacerola grande a fuego 
medio
paso 2. Corta el pan en rebanadas de aproximadamente 1 dede de ancho, remoja las rebanadas en la leche
caliente durante unos minutos, pero sin que llegue a desmoronarse.
paso 3. Bate los huevos
paso 4. Calienta el aceite en una sartén grande a fuego medio-alto. Saca las rebanadas de pan empapadas 
de la leche y pásalas por el huevo batido. Fríe las torrijas en el aceite caliente hasta que estén doradas y 
crujientes por ambos lados. Retira las torrijas y colócalas sobre papel de cocina.
paso 5. Mezcla azúcar y canela en polvo en un plato poco profundo. Pasa las torrijas fritas por la mezcla para
rebozarlas uniformemente.','es',30,5,2);
	INSERT INTO recipe VALUES (5,'Fruit shake with milk, water o icecream ','Smoothie',"step 1. Select your liquid base, water for ligthness; milk or yogurt for creaminess or fruit juice for flavor.
step 2. Add a handful of fruits to the blender.
step 3. Secure the lid on your blender and blend until smooth. If the smoothie is too thick, you can add more liquid. 
If it's too thin, you can add more fruit or ice cubes.
step 4. Taste your smoothie and adjust the flavor as needed",'en',10,9,3);
	INSERT INTO recipe VALUES (6,'Pollo desmenuzado juntado con bechamel, rebozado y frito','Croquetas de pollo','paso 1. Cocina las pechugas de pollo en agua con sal hasta y luego desmenúzalas.
paso 2. En una sartén grande, derrite la mantequilla a fuego medio. Agrega la harina y cocina, revolviendo 
constantemente, durante unos minutos. Luego, poco a poco, agrega la leche, mientras continúas revolviendo.
Cocina la mezcla hasta que espese y se convierta en una salsa suave y cremosa.
paso 3.  Una vez lista, agrega el pollo desmenuzado a la mezcla y revuelve hasta que esté bien incorporado.
paso 4. Transfiere la mezcla a un recipiente y déjala enfriar en la nevera hasta que esté lo suficientemente
 firme como para formar croquetas.
paso 5.  Una vez que la mezcla esté fría, forma pequeñas croquetas con las manos. Pasa cada croqueta 
primero por el pan rallado, luego por los huevos batidos y finalmente por el pan rallado nuevamente.
paso 6. Calienta aceite en una sartén profunda . Cuando el aceite esté caliente, fríe las croquetas unos 3-4 
minutos. Retíralas con una espumadera y colócalas sobre papel de cocina.','es',60,5,1);
	INSERT INTO recipe VALUES (7,'Fried potatoes with bacon on top','Bacon Chips',"step 1. Preheat your oven to 220°C.
step 2. Wash and peel the potatoes. Cut them into thick fry shapes.
step 3. Place the cut potatoes in a pot of boiling water and cook them for about 5 minutes.
step 4. Cook the bacon in a pan over medium heat until it's crispy. Once cooked, place the bacon on a paper 
towel-lined plate. Once cooled, chop the bacon into small pieces.
step 5. Drain the potatoes and pat them dry with paper towels. Place them on a baking sheet lined with 
parchment paper. Arrange the bacon pieces on top of the fries.
step 6. Sprinkle the fries and bacon with salt and pepper to taste.
step 7. Place the baking sheet in the preheated oven and bake for about 25-30 minutes.",'en',45,3,4);
	INSERT INTO recipe VALUES (8,'Empanadillas japonesas rellenas de carne picada','Gyozas','step 1. In a large mixing bowl, combine the meat filling ingridients. Mix everything together.
step 2. Place a gyoza wrapper on a dry surface. Spoon about 1 tablespoon of the meat filling onto the 
center of the wrapper. Dip your finger into water and moisten the edges of the wrapper. Fold the wrapper in half 
over the filling to form a half-moon shape. Pinch and pleat the edges together to seal the gyoza.
step 3. Heat a large non-stick pan over medium heat and add a small amount of oil. Once the oil is hot, 
place the gyoza in the pan in a single layer, flat side down. Cook until the bottoms are golden brown.
step 4.  Carefully add about 1/4 cup of water to the pan, then immediately cover with a lid. Steam the gyoza
for about 5 minutes.
step 5. Remove the lid and let any remaining water evaporate. Use a spatula to transfer the gyoza to a plate','en',60,6,1);
	INSERT INTO recipe VALUES (9,'Plata italiano con ragu y bechamel, separado por láminas de pasta','Lasaña','paso 1. En una sartén grande, saltea la cebolla y el ajo hasta que estén dorados. Agrega la carne picada y 
cocina hasta que esté bien dorada. Añade el tomate triturado, la pasta de tomate, el azúcar, el orégano, la sal
y la pimienta. Cocina a fuego lento revolviendo ocasionalmente, hasta que la salsa espese.
paso 2. En un tazón pequeño, mezcla el queso con el huevo batido y una pizca de sal y pimienta.
paso 3. Precalienta el horno a 180°C. En una fuente para hornear rectangular, extiende una capa delgada de 
salsa de carne en el fondo. Coloca una capa de láminas de lasaña sobre la salsa. Luego, extiende una capa 
de la mezcla de queso sobre las láminas. Repite este proceso, alternando capas, terminando con una capa
de salsa de carne en la parte superior.
paso 4.  Espolvorea el queso mozzarella y el queso parmesano sobre la parte superior de la lasaña.
paso 5. Cubre la fuente para hornear con papel de aluminio y hornea en el horno  durante unos 30 minutos. 
Luego, retira el papel de aluminio y hornea hasta que el queso esté dorado y burbujeante.','es',90,3,1);
	INSERT INTO recipe VALUES (10,'Plato típico de valencia, hecho a partir de carne, arroz y verduras','Paella','paso 1. Vierte el aceite sobre la paella y enciende el fuego. Una vez el aceite esté caliente, añade el conejo 
y el pollo y sofríelos hasta que adquieran un color dorado.
paso 2. A continuación, echa las verduras y rehógalas.
paso 3. Ahora vierte el tomate rallado y sofríelo del mismo modo, removiendo constantemente.
paso 4. Añade pimentón y remuévelo apenas un instante, enseguida tienes que verter el agua hasta los
remaches de la paella. Añade el azafrán, el romero y la sal.
paso 5. Una vez que el agua hierva, déjala unos 5 minutos en ebullición con fuego alto. A continuación, baja 
a fuego medio y déjala cocer entre 20 y 30 minutos. Aviva el fuego y añade el arroz.
paso 6. Mantén el fuego fuerte durante unos 10 minutos y reduce el fuego a la mitad hasta que el arroz quede
en su punto de cocción.','es',60,5,1);
	INSERT INTO recipe VALUES (11,'Masa rellena en forma de media luna que se fríe en aceite.','Empanadilla','paso 1. En un tazón grande, mezcla la harina y la sal. Agrega el agua tibia y el aceite de oliva, y mezcla 
hasta que se forme una masa suave y homogénea. Amasa la masa en una superficie enharinada hasta que 
esté suave y elástica. Cubre la masa con un paño húmedo y déjala reposar durante al menos 30 minutos
paso 2. En una sartén grande, calienta un poco de aceite y saltea la cebolla y el ajo hasta que estén dorados.
Agrega la carne picada y cocina hasta que esté dorada. Luego, agrega el pimiento y el tomate picados, 
y cocina hasta que estén tiernos. Sazona al gusto. Deja enfriar el relleno antes de usarlo.
paso 3.  Divida la masa en pequeñas porciones del tamaño de una nuez y forma bolas. Estira la masa en 
un círculo delgado con un rodillo sobre una superficie enharinada. Coloca una cucharada del relleno en el 
centro de cada masa.
paso 4. Doble la masa sobre el relleno para formar una media luna y presiona los bordes con los dedos para 
sellarlas. 
paso 5. Calienta aceite en una sartén grande a fuego medio-alto. Cuando el aceite esté caliente, coloca las 
empanadillas en la sartén y fríelas unos 2-3 minutos por lado. Retira las empanadillas y colócalas sobre papel
 de cocina.','es',50,8,4);
	INSERT INTO recipe VALUES (12,'Roasted marinated chicken chunks in a spiced sauce','Chicken Tikka Masala','step 1.  In a large bowl, combine the yogurt, lemon juice and the spices. Add the chicken pieces to the bowl 
and toss to coat. Cover and refrigerate for at least 1 hour, the longer the better.
step 2. Preheat your grill to medium-high heat. Thread the marinated chicken onto skewers and grill  for 5-7 
minutes on each side. Remove the chicken from the skewers and set aside.
step 3. In a large pan, heat the vegetable oil over medium heat. Add the onion and cook until softened. Add 
the garlic and ginger, and cook for another 1-2 minutes.
step 4. Add the spices. Cook, stirring constantly, until the spices are toasted and aromatic.
step 5. Add the crushed tomatoes, stirring to combine. Bring the mixture to a simmer and cook for 10-15 
minutes, stirring occasionally.
step 6. Stir in the heavy cream or coconut milk, and season to taste. Add the cooked chicken pieces to the 
sauce and simmer for an additional 5-10 minutes.','en',120,9,1);
	INSERT INTO recipe VALUES (13,'Japanese dessert stuffed with anko','Dorayaki','step 1. In a mixing bowl, whisk together the eggs, granulated sugar, honey, and vanilla extract until slightly 
frothy. Sift in the all-purpose flour and baking powder, and gently fold them into the egg mixture until you have 
a smooth batter.
step 2. Heat a non-stick pan over medium heat and lightly grease it with vegetable oil. Spoon about 1/4 cup of
batter onto the pan, spreading it out into a circle. Cook the pancake for 1-2 minutes. Flip the pancake over and 
cook for an additional 1-2 minutes on the other side. Repeat, stacking the cooked pancakes on a plate and
covering them with a kitchen towel to keep them warm.
step 3.  Once all the pancakes are cooked, spread a spoonful of sweet red bean paste onto the center of one 
pancake. Place another pancake on top to sandwich the filling, pressing down gently to adhere.','en',30,1,2);
	INSERT INTO recipe VALUES (14,'Postre frances elaborado con una natilla','Flan de huevo','paso 1. En un cazo pequeño, combina el azúcar granulada y el agua. Calienta a fuego medio-alto, sin remover,
hasta que la mezcla adquiera un color dorado oscuro. Una vez esté listo, viértelo rápidamente en el fondo de 
un molde para flan y distribúyelo uniformemente cubriendo todo el fondo.
paso 2. En un tazón grande, bate los huevos. Agrega la leche condensada, la leche evaporada y el extracto 
de vainilla, y mezcla hasta que la mezcla esté suave.
paso 3. Vierte la mezcla de flan sobre el caramelo en el molde preparado. Golpea suavemente el molde sobre 
la encimera para eliminar cualquier burbuja de aire atrapada en la mezcla.
paso 4. Precalienta el horno a 180°C. Coloca el molde para flan dentro de una fuente para horno más grande y
llénala con agua caliente hasta que alcance aproximadamente la mitad de la altura del molde para flan. 
paso 5. Transfiere la fuente para horno al horno precalentado y hornea el flan durante aproximadamente 50-60 
minutos.
paso 6. Una vez que el flan esté listo, retíralo del horno y déjalo enfriar a temperatura ambiente. Luego 
refrigéralo durante al menos 4 horas.','es',60,1,2);
	INSERT INTO recipe VALUES (15,'Postre muy popular hecho de queso','Tarta de queso','paso 1. Tritura las galletas hasta obtener migajas finas. Mezcla las migajas de galleta con la mantequilla 
derretida.Presiona la mezcla de galleta en el fondo de un molde para tarta desmontable, cubriendo el fondo.
Refrigera la base mientras preparas el relleno
paso 2. Precalienta el horno a 170°C. En un bol grande, bate el queso crema con el azúcar hasta que esté 
suave y cremoso. Agrega los huevos uno a uno, batiendo bien. Incorpora la nata para montar, el extracto de 
vainilla y la ralladura de limón. Mezcla hasta que todos los ingredientes estén bien combinados.
paso 3. Vierte la mezcla sobre la base de galleta en el molde preparado. Extiende la mezcla de manera 
uniforme con una espátula.
paso 4. Coloca el molde en una bandeja para hornos. Hornea la tarta de queso en el horno precalentado 
durante aproximadamente 45-55 minutos. Retira del horno y deja que se enfríe a temperatura ambiente.
paso 5. Refrigera la tarta de queso durante al menos 4 horas.Desmolda con cuidado la tarta de queso y 
transfiérela a un plato de servir.','es',70,5,2);
	INSERT INTO recipe VALUES (16,'Evolution of the carrot pudding from 1591','Carrot cake','step 1. Preheat your oven to 180°C. Line two round cake pan with parchment paper for easy removal.
step 2. In a large mixing bowl, sift together the flour, baking powder, baking soda, salt, cinnamon, nutmeg, and 
ginger.
step 3. In another mixing bowl, whisk together the granulated sugar and oil until smooth. Add the eggs, one at a 
time, beating well after each addition.
step 4. Gradually add the wet ingredients to the dry ingredients, mixing until just combined. Stir in the grated 
carrots, chopped nuts, shredded coconut, and raisins, until evenly distributed.
step 5. Divide the batter between the prepared cake pans. Smooth the tops with a spatula. Bake in the oven for 
25-30 minutes. Remove the cakes from the oven and allow them to cool in the pans for about 10 minutes. 
Then, transfer them to a wire rack to cool completely.
step 6. In a mixing bowl, beat the softened cream cheese and butter until smooth. Gradually add the powdered 
sugar, beating until fluffy. Mix in the vanilla extract.
step 7. Place one cake layer on a serving plate or cake stand. Spread a layer of cream cheese frosting over 
the top. Place the second cake layer on top and frost the top and sides of the cake with the remaining frosting.','en',50,8,2);
	INSERT INTO recipe VALUES (17,'A cold drink made of milk, a sweet flavouringand typically ice cream.','Strawberry Milkshake','step 1. Rinse the strawberries thoroughly under cold water, remove the stems, and cut them into halves.
step 2. In a blender, combine the strawberries, vanilla ice cream, milk, and sugar. Blend on high speed until the 
mixture is smooth.
step 3. Taste the milkshake and adjust the sweetness by adding more sugar or if desired. Blend again to
combine.','en',10,5,3);
	INSERT INTO recipe VALUES (18,'Cafe valenicano hecho con ron, azucar y canela','Cremaet','paso 1. Lo primero que vamos a hacer es cortar un trozo de piel de limón, que previamente habremos 
enjuagado y limpiado bien bajo el agua del grifo.
paso 2. En un vaso de café, añadimos la piel de limón, 2 cucharadas de azúcar, un trozo de canela en rama, 
unos granos de café y los 40 ml de ron.
paso 3. Ahora metemos el vaso en el microondas y calentamos la mezcla durante 30 segundos. Una vez 
caliente, acercando la llama de un mechero flambeamos el licor. Con una cuchara iremos moviendo la mezcla
hasta que veamos que ya no hay llama.
paso 4. Solo nos queda añadir el café, para preparar un cremaet. Para que las capas queden bien 
diferenciadas, hay que poner una cuchara para que caiga el café sobre ella, y así no romper la armonía del 
cremaet.','es',15,6,3);
	INSERT INTO recipe VALUES (19,'Cóctel valenciano hecho con naranja, ginebra y cava','Agua de valencia','paso 1. En una jarra grande, combina el zumo de naranja, el licor de naranja y el vodka o la ginebra. Remueve 
bien.
paso 2.  Con cuidado, vierte la botella de cava en la jarra con la mezcla de zumo y licores.
paso 3.  Prueba la mezcla y añade azúcar si lo deseas.
paso 4. Una vez que todos los ingredientes estén combinados, refrigera la jarra durante al menos 30 minutos 
antes de servir.','es',5,9,3);
	INSERT INTO recipe VALUES (20,'Coffee or crème base, blended with ice andflavored syrups and  topped with whipped cream.','Frappuccino','step 1. Brew a cup of strong coffee and let cool down.
step 2. Add the cooled coffee, milk, granulated sugar or sweetener, and ice cubes to a blender.
step 3. Blend the ingredients on high speed until smooth and creamy.
step 4. Once the Frappuccino is blended, pour it into glasses. Leave some space at the top.
step 5. Top each glass of Frappuccino with a dollop of whipped cream.','en',10,1,3);
    
    INSERT INTO tool VALUES (1,'Cuchara','Spoon');
	INSERT INTO tool VALUES (2,'Bol','Bowl');
	INSERT INTO tool VALUES (3,'Sarten','Pan');
	INSERT INTO tool VALUES (4,'Olla','Pot');
	INSERT INTO tool VALUES (5,'Vaso medidor','Measuring cup');
	INSERT INTO tool VALUES (6,'Batidora','Blender');
	INSERT INTO tool VALUES (7,'Bandeja','Tray');
	INSERT INTO tool VALUES (8,'Colador','Strainer');
	INSERT INTO tool VALUES (9,'Tarro','Jar');
	INSERT INTO tool VALUES (10,'Cazuela de barro','Clay pot');
    INSERT INTO tool VALUES (11,'Cuchillo','Knife');
	INSERT INTO tool VALUES (12,'Plato','Dish');
	INSERT INTO tool VALUES (13,'Molde de tarta','Cake mold');
	INSERT INTO tool VALUES (14,'Paella','Paella');
	INSERT INTO tool VALUES (15,'Freidora','Fryer');
	INSERT INTO tool VALUES (16,'Horno','Oven');
    
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (1,11);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (1,8);
    INSERT INTO composed(id_recipe,id_ingredient) VALUES (1,12);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (2,1);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (2,3);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (3,2);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (3,4);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (3,7);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (4,11);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (4,9);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (4,1);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (5,6);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (5,9);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (5,5);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (6,1);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (6,11);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (6,2);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (7,7);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (7,8);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (8,7);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (8,4);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (9,11);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (9,12);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (9,7);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (10,3);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (10,2);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (11,12);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (11,3);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (12,3);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (12,12);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (12,2);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (13,11);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (13,9);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (14,9);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (14,11);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (15,11);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (15,9);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (16,11);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (16,9);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (17,5);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (17,6);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (18,5);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (19,6);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (20,9);
	INSERT INTO composed(id_recipe,id_ingredient) VALUES (20,5);
		
	INSERT INTO required(id_recipe,id_tool) VALUES (1,3);
	INSERT INTO required(id_recipe,id_tool) VALUES (1,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (2,6);
	INSERT INTO required(id_recipe,id_tool) VALUES (2,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (3,4);
	INSERT INTO required(id_recipe,id_tool) VALUES (3,8);
	INSERT INTO required(id_recipe,id_tool) VALUES (4,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (4,3);
	INSERT INTO required(id_recipe,id_tool) VALUES (4,4);
	INSERT INTO required(id_recipe,id_tool) VALUES (4,1);
	INSERT INTO required(id_recipe,id_tool) VALUES (5,6);
	INSERT INTO required(id_recipe,id_tool) VALUES (5,5);
	INSERT INTO required(id_recipe,id_tool) VALUES (6,3);
	INSERT INTO required(id_recipe,id_tool) VALUES (6,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (7,4);
	INSERT INTO required(id_recipe,id_tool) VALUES (7,3);
	INSERT INTO required(id_recipe,id_tool) VALUES (7,8);
	INSERT INTO required(id_recipe,id_tool) VALUES (8,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (8,1);
	INSERT INTO required(id_recipe,id_tool) VALUES (8,3);
	INSERT INTO required(id_recipe,id_tool) VALUES (9,3);
	INSERT INTO required(id_recipe,id_tool) VALUES (9,10);
	INSERT INTO required(id_recipe,id_tool) VALUES (9,7);
	INSERT INTO required(id_recipe,id_tool) VALUES (10,3);
	INSERT INTO required(id_recipe,id_tool) VALUES (10,1);
	INSERT INTO required(id_recipe,id_tool) VALUES (11,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (11,3);
	INSERT INTO required(id_recipe,id_tool) VALUES (11,1);
	INSERT INTO required(id_recipe,id_tool) VALUES (12,3);
	INSERT INTO required(id_recipe,id_tool) VALUES (12,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (13,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (13,1);
	INSERT INTO required(id_recipe,id_tool) VALUES (13,3);
	INSERT INTO required(id_recipe,id_tool) VALUES (14,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (14,10);
	INSERT INTO required(id_recipe,id_tool) VALUES (15,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (15,6);
	INSERT INTO required(id_recipe,id_tool) VALUES (16,2);
	INSERT INTO required(id_recipe,id_tool) VALUES (16,7);
	INSERT INTO required(id_recipe,id_tool) VALUES (17,6);
	INSERT INTO required(id_recipe,id_tool) VALUES (17,5);
	INSERT INTO required(id_recipe,id_tool) VALUES (18,4);
	INSERT INTO required(id_recipe,id_tool) VALUES (18,5);
	INSERT INTO required(id_recipe,id_tool) VALUES (19,5);
	INSERT INTO required(id_recipe,id_tool) VALUES (20,6);
	INSERT INTO required(id_recipe,id_tool) VALUES (20,9);