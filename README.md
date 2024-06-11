![NUTRIFUSION FOOD](src/main/resources/static/images/logo/logo_nombre.png)

Hi, we are the creators of Nutrifusion Food, and today you are going to read what this 
project is about and how we made it.

Firstly, what is Nutrifusion Food, well, glad you asked. Nutrifusion Food is a web 
designed for foodies and people who love to eat and cook. Our goal is to make home made 
food more achievable for everyone, we plan to do this by making an online platform where 
people can look up recipes uploaded by certified nutritionists.

![GUANTE]()

If you visit our page you will be able to see an extensive list of recipes. In each 
recipe you can see who uploaded it, the time it would take you and a small description. 
If you happen to like it, you can sign up to access the rest of the details, by clicking 
on the title you can see what ingredients and tools you will need as well as the steps to
complete it.

Also you can use it as other social media, if you like the recipes that a particular 
nutritionist posts you can directly look at their profile to see all the recipes that 
they have created. Each recipe has also a button to save it in your own profile as your 
favorite recipes.

![CORAZON]()

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

![NF]()

### Color palette
We wanted a style that was clean, attractive and sophisticated and we wanted to avoid the typical 
recipe blog that is overloaded with information, photos and random colors. We started with the idea of 
using three colors as a base for the design, one light color for the background, another more bright for 
the things that we want to stand out and the last one darker for the titles. We ended up with the combination 
that you can see down here:

![COLOR PALETTE]()

### Typography
We selected the following typographies because we wanted to reflect simplicity, elegancy and familiarity
with our designs, also we wanted to stand out some parts thanks to the contrast of colors and styles on
the titles.

We decided to go with Playfair Display for the main text:

![PLAYFAIR]()

And Forum for the titles, menu and other elements:

![FORUM]()


### Mockup
The web is made up of 5 pages that you are allowed to access or not depending on your user status.

If you are **not logged** in you can only access the following pages:
- A landing page where users can log in, access to the categories of the recipes and get 
information with an About us section.
- A page full of recipes, it can be with all the recipes mixed or filtered by category. 
Each recipe has a photo, the name of the creator and a small description.

If you are **logged in** you can also access the following pages:
- A page with the details of the recipe. Which include the ingredients and tools required and the steps 
of the recipe.
- Your profile page, where you will have general information about you and your favorite recipes. If you 
are a nutritionist you have a section with your own recipes, that you can modify and delete.

If you are a **nutritionist** you have also access to one last page:
- A form to add new recipes to your profile.

We wanted our project to be as simple as possible, to make it accessible to all types of users, so the 
web is divided in a way that each page has not many uses and doesn’t overwhelm the users.

## 3. FRONTEND

### Technologies used
For the front end we use some technologies to help with some parts of the web like:

- **Thymeleaf:** we used this plugin as the main link between the frontend and the backend of the web. 
It has helped a lot thanks to the similarity with a programming language. We are able to create conditions, 
loops and forms connected to the database (insert, update and delete the recipes). Also it allowed 
us to create global templates for the fragments that we wanted to use in multiple pages, we created the 
header with the navigation bar and the footer in a different page and then we inserted it in all the other pages.
- **Bootstrap:** we used this toolkit in order to simplify the responsive design of the web. It has also 
helped with the display of all the elements and the global style that we wanted to apply (borders, colors…). 
This toolkit has useful elements such as the dropdown, tabs, forms and buttons.
- **Sass:** we used it to personalize bootstrap variables and create our own functions and variables to simplify css. 
We used the nesting properties to simplify the writing, we created composed variables to apply multiple styles 
at the same time and we used mixins to automatize the assignment of styles to the variables.

![THYMELEAF]() ![BOOTSTRAP]() ![SASS]()

### Programming languages
We use different languages for the frontend, each one with its use:

- **Html5:** is a standardized system for tagging text files to achieve font, color, graphic, and hyperlink effects. 
We used it to create the structure of each page. We used the semantic elements predefined in html (header, 
footer, section), to organize our pages.
- **Css:** to style each page. Our CSS is composed of two parts, first we have all of the bootstrap variables with 
the Sass modifications and then we have our own classes, mainly to adjust the images and other complex elements.
- **JavaScript:** some of the bootstrap elements used JavaScript to make animations, for example the dropdown, 
some menus and the tabs menu. We used mostly the JavaScript code proposed by bootstrap.

![HTML]() ![CSS]()

## 4. BACKEND

### Technologies used
As we developed this project, various frameworks and technologies played a crucial role in making our development 
easier, faster, and more effective.
Firstly, we used Spring, a Java framework that simplifies building applications. Spring provided us with features 
like dependency injection, aspect-oriented programming, and data access, which helped streamline our development 
and made our code more maintainable.

![SPRING]()

To ensure our code was reliable, we used Mockito. This testing framework allowed us to create mock objects, 
simulating the behavior of real objects in a controlled manner. This made our testing process much easier and 
helped us catch issues early.

### Architecture
For our project architecture, we organized into four different layers:
1. **Controller Layer:** Manages the access to different pages and handles user input.
2. **Domain Layer:** Contains the service implementation and the core business logic of our application.
3. **Persistence Layer:** Responsible for data access, including mappers and the representation of objects in the relational 
model.
4. **Common Layer:** Manages the Inversion of Control, the language and the user manager, helping to decouple components 
and improve code flexibility.

### Programming languages
In our project, we used Java as the main programming language for the backend because of how it simplifies things for
coding. 
The object based programming language simplifies all the methods and makes the program more comprehensible. We also 
used JavaScript in a simple way to make the forms and menus interactive.

For our database needs, we chose MySQL, an open-source relational database management system. MySQL’s use of SQL
for managing and manipulating databases provided us with a reliable and efficient way to handle our data.

## 5. DATABASE
### ER

![ENTIDAD RELACION]()

### Design
Our database is primarily structured around two main entities: User and Recipe.

User stores all information about the different users. Having an account is essential to access the main services of our 
website. We have three types of users:
1. **ADMIN:** This role is reserved for us, the website administrators. Admins have all privileges, including making changes
to the database.
2. **NUTRITIONIST:** When logging in, users can register as a nutritionist. Nutritionists can add new recipes, including 
their tools and ingredients, and edit or delete their own recipes.
3. **CLIENT:** This is the basic role assigned if users choose not to register as a nutritionist. Clients have basic 
privileges, including updating and deleting their accounts.

Recipe is where all the information about the recipes is stored and it’s linked with almost all the rest entities 
of the database. A RECIPE is made by a USER, it belongs to a CATEGORY, it’s composed of a list of INGREDIENTS, and it
requires a list of TOOLS. Each recipe also has a name, a description, the steps you’d have to follow in order to make 
it and the amount of time you’ll need to do so. We have recipes in both Spanish and English.

Finally, the last entity to highlight is TYPE, each ingredient belongs to a different type (fish, meat, fruit…). Thanks 
to this entity we’re able to create filters for our recipes (like vegetarian, vegan…) and also show in the details of 
the recipe the allergens it has depending on the ingredients.

### Roles and privileges
We have four types of roles that can access our web, each one has different privileges:

|        | ADMIN | NUTRITIONIST               | CLIENT | VISITANT |
|--------|-------|----------------------------|--------|----------|
| SELECT | ALL   | ALL                        | ALL    | ALL      |
| INSERT | ALL   | RECIPE & TOOL & INGREDIENT | NONE   | NONE     |
| UPDATE | ALL   | RECIPE & USER              | USER   | NONE     |
| DELETE | ALL   | RECIPE & USER              | USER   | NONE     |

## 6. DEPLOYMENT
We did the deployment of the web on AWS (Amazon Web Server). To host all the services required we created different 
services.

- First of all we created a VCP, so we could have an IP assigned to our web.
- Then we created a database with RDS, we used MySQL as the local version.
- After that we started with the API, for this we had to download a compressed file with all the information of our web. 
If there were any problems with the tests or any part of our code we had to solve it before downloading it.

The API creates the administration of the web, here is where we generate all the information about the programming, the 
netting, the security group and the database information. We could say that an API is the link between all the 
information and is the one that creates  our page so it can be visible to all on the web, thanks to a generated link.


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
In order to work on multiple tasks at the same time we used *GitHub*, with the *GitFlow* approach. Gitflow is an alternative 
Git branching model that involves the use of feature branches and multiple primary branches. In our case, we decided to 
use directories to classify and organize our feature branches, so finally we ended up with a structure similar to the
programming architecture but with the different tasks related to each part.

![GITHUB]()

![BRANCHES]() ![SUB BRANCHES]()

The branch where we worked mostly is the develop branch, from this branch we created all the different feature branches. 
When we wanted to release our program we had to create a release branch to finish the main changes before the release 
and then merge this branch with the develop branch and the main branch.
Thanks to this approach we were able to modify different aspects of the code at the same time, maintain a logical order 
and merging the changes once each one of the features was ready.
