![NUTRIFUSION FOOD](src/main/resources/static/images/logo/logo_nombre.png)
Hi, we are the creators of Nutrifusion Food, and today you are going to read what this 
project is about and how we made it.

Firstly, what is Nutrifusion Food, well, glad you asked. Nutrifusion Food is a web 
designed for foodies and people who love to eat and cook. Our goal is to make home made 
food more achievable for everyone, we plan to do this by making an online platform where 
people can look up recipes uploaded by certified nutritionists.

If you visit our page you will be able to see an extensive list of recipes. In each 
recipe you can see who uploaded it, the time it would take you and a small description. 
If you happen to like it, you can sign up to access the rest of the details, by clicking 
on the title you can see what ingredients and tools you will need as well as the steps to
complete it.

Also you can use it as other social media, if you like the recipes that a particular 
nutritionist posts you can directly look at their profile to see all the recipes that 
they have created. Each recipe has also a button to save it in your own profile as your 
favorite recipes.

If you sign up as a nutritionist you will have the same features as the other users 
and more. In your profile page you will have options to create new recipes and modify 
and delete the ones you have already created.

## 0. INDEX
1. [CREATORS](#1-creators)
2. [DESIGN](#2-design)
3. [FRONTEND](#3-frontend)
4. [BACKEND](#4-backend)
5. [DATABASE](#5-database)
6. [DEPLOYEMENT](#6-deployement)
7. [ORGANISATION](#7-organisation)


## 1. CREATORS
- [Andreu](https://github.com/AndreuAlfonso) 
- [Soledad](https://github.com/SoleReyes02)
- [Àngela](https://github.com/AngelaHdR)
- [Victor](https://github.com/faloptero)

## 2. DESIGN
So now, let’s talk about the creative process behind the web. Here you can find the 
technologies that we used to decide the design of the web and the logo, the decisions 
that we made to choose the colors and typographies and the main page structures from our web.
### Technologies used
We did a Mockup of the page to help us with the design and organization of the different pages. 
We used two different tools for this task, the first one was *Mock Flow* with this tool we were 
able to create the main structure and display of the web. Once the structure was clear we took our 
design to Wix, here we defined the colors, size and styles of all the main pages in our website.

For the logo, we use *Smashing Logo* to find the basic idea and *Gimp* to modify the logo proposed, 
add our personal touches and adapt it to our design. We ended up with the logo that you can see here:

### Color palette
We wanted a style that was clean, attractive and sophisticated and we wanted to avoid the typical 
recipe blog that is overloaded with information, photos and random colors. We started with the idea of 
using three colors as a base for the design, one light color for the background, another more bright for 
the things that we want to stand out and the last one darker for the titles. We ended up with the combination 
that you can see down here:

### Typography
We selected the following typographies because we wanted to reflect simplicity, elegancy and familiarity
with our designs, also we wanted to stand out some parts thanks to the contrast of colors and styles on
the titles.

We decided to go with Playfair Display for the main text:

And Forum for the titles, menu and other elements:


### Mockup
The web is made up of 5 pages that you are allowed to access or not depending on your user status.

If you are not logged in you can only access the following pages:
- A landing page where users can log in, access to the categories of the recipes and get 
information with an About us section.
- A page full of recipes, it can be with all the recipes mixed or filtered by category. 
Each recipe has a photo, the name of the creator and a small description.

If you are logged in you can also access the following pages:
- A page with the details of the recipe. Which include the ingredients and tools required and the steps 
of the recipe.
- Your profile page, where you will have general information about you and your favorite recipes. If you 
are a nutritionist you have a section with your own recipes, that you can modify and delete.

If you are a nutritionist you have also access to one last page:
- A form to add new recipes to your profile.

We wanted our project to be as simple as possible, to make it accessible to all types of users, so the 
web is divided in a way that each page has not many uses and doesn’t overwhelm the users.

## 3. FRONTEND

### Technologies used
For the front end we use some technologies to help with some parts of the web like:

- Thymeleaf: we used this plugin as the main link between the frontend and the backend of the web. 
It has helped a lot thanks to the similarity with a programming language. We are able to create conditions, 
loops and forms connected to the database (insert, update and delete the recipes). Also it allowed 
us to create global templates for the fragments that we wanted to use in multiple pages, we created the 
header with the navigation bar and the footer in a different page and then we inserted it in all the other pages.
- Bootstrap: we used this toolkit in order to simplify the responsive design of the web. It has also 
helped with the display of all the elements and the global style that we wanted to apply (borders, colors…). 
This toolkit has useful elements such as the dropdown, tabs, forms and buttons.
- Sass: we used it to personalize bootstrap variables and create our own functions and variables to simplify css. 
We used the nesting properties to simplify the writing, we created composed variables to apply multiple styles 
at the same time and we used mixins to automatize the assignment of styles to the variables.

![Logo bootstrap](data:image/jpeg;base64,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)

### Programming languages
We use different languages for the frontend, each one with its use:

- Html5: is a standardized system for tagging text files to achieve font, color, graphic, and hyperlink effects. 
We used it to create the structure of each page. We used the semantic elements predefined in html (header, 
footer, section), to organize our pages.
- Css: to style each page. Our CSS is composed of two parts, first we have all of the bootstrap variables with 
the Sass modifications and then we have our own classes, mainly to adjust the images and other complex elements.
- JavaScript: some of the bootstrap elements used JavaScript to make animations, for example the dropdown, 
some menus and the tabs menu. We used mostly the JavaScript code proposed by bootstrap.

## 4. BACKEND

### Technologies used
As we developed this project, various frameworks and technologies played a crucial role in making our development 
easier, faster, and more effective.
Firstly, we used Spring, a Java framework that simplifies building applications. Spring provided us with features 
like dependency injection, aspect-oriented programming, and data access, which helped streamline our development 
and made our code more maintainable.

To ensure our code was reliable, we used Mockito. This testing framework allowed us to create mock objects, 
simulating the behavior of real objects in a controlled manner. This made our testing process much easier and 
helped us catch issues early.

### Architecture
For our project architecture, we organized into four different layers:
1. Controller Layer: Manages the access to different pages and handles user input.
2. Domain Layer: Contains the service implementation and the core business logic of our application.
3. Persistence Layer: Responsible for data access, including mappers and the representation of objects in the relational 
model.
4. Common Layer: Manages the Inversion of Control, the language and the user manager, helping to decouple components 
and improve code flexibility.

### Programming languages
In our project, we used Java as the main programming language for the backend because of how it simplifies things for
coding. 
The object based programming language simplifies all the methods and makes the program more comprehensible. We also 
used JavaScript in a simple way to make the forms and menus interactive.

For our database needs, we chose MySQL, an open-source relational database management system. MySQL’s use of SQL
for managing and manipulating databases provided us with a reliable and efficient way to handle our data.

## 5. DATABASE

### Design
Our database is primarily structured around two main entities: User and Recipe.

User stores all information about the different users. Having an account is essential to access the main services of our 
website. We have three types of users:
1. ADMIN: This role is reserved for us, the website administrators. Admins have all privileges, including making changes
to the database.
2. NUTRITIONIST: When logging in, users can register as a nutritionist. Nutritionists can add new recipes, including 
their tools and ingredients, and edit or delete their own recipes.
3. CLIENT: This is the basic role assigned if users choose not to register as a nutritionist. Clients have basic 
privileges, including updating and deleting their accounts.

Recipe is where all the information about the recipes is stored and it’s linked with almost all the rest entities 
of the database. A RECIPE is made by a USER, it belongs to a CATEGORY, it’s composed of a list of INGREDIENTS, and it
requires a list of TOOLS. Each recipe also has a name, a description, the steps you’d have to follow in order to make 
it and the amount of time you’ll need to do so. We have recipes in both Spanish and English.

Finally the last entity to highlight is TYPE, each ingredient belongs to a different type (fish, meat, fruit…). Thanks 
to this entity we’re able to create filters for our recipes (like vegetarian, vegan…) and also show in the details of 
the recipe the allergens it has depending on the ingredients.

### Roles and privileges
We have four types of roles that can access our web, each one has different privileges:

| X      | ADMIN | NUTRITIONIST               | CLIENT | VISITANT |
|--------|-------|----------------------------|--------|----------|
| SELECT | ALL   | ALL                        | ALL    | ALL      |
| INSERT | ALL   | RECIPE & TOOL & INGREDIENT | NONE   | NONE     |
| UPDATE | ALL   | RECIPE & USER              | USER   | NONE     |
| DELETE | ALL   | RECIPE & USER              | USER   | NONE     |

## 6. DEPLOYMENT


## 7. ORGANISATION

### Task management
We worked using the Scrum Methodology, an Agile project management philosophy based on the idea of dividing a great 
task into different smaller pieces called sprint. These sprints are made up of various issues and each member has to 
complete their issues for that sprint, at the end of the day it is a cooperative project. In our case, we had six 
sprints of approximately two weeks each one, for dividing the issues and tracking the progress we use the github issues.

For how we organized, we decided to divide the tasks with a cooperative and learning approach. We worked mostly in 
pairs that changed for each task, with one person knowing the subject and the other learning and improving. With these 
organizations we were constantly changing the tasks assigned and we were forced to adapt to new working pairs. A great 
consequence of these organizations is that we have all contributed with all the aspects of our web and we always knew 
the state of the project.

### VCS
In order to work on multiple tasks at the same time we used GitHub, with the GitFlow approach. Gitflow is an alternative 
Git branching model that involves the use of feature branches and multiple primary branches. In our case, we decided to 
use directories to classify and organize our feature branches, so finally we ended up with a structure similar to the
programming architecture but with the different tasks related to each part.