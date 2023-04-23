# Tutorial on Java Movie Management System
## 1.Github repository : “https://github.com/Tsuzukii/CSC1004-java-MovieManagementSystem”
## 2.Please first load the database information using MYSQL from “com/example/moviemanagement/dbs/MovieManagementSystem.sql” before using the movie management system.
## 3.Detailed comments on how to realize functions has been included before every specific function.

### (2pts)Seperate systems for Users and Admins
## Common User Side:
### 1.Login functions: Both admins and common users can login through the same window. All the data is stored in the MySQL database, which is in the ".sql" file. [(2pts)Shared Login page for Users and Admins、(2pts)User info can be entered: age, gender, address、(2pts)User Login info can be entered: username and password、(8pts)All info have to be stored in Database、(8pts)Validate the combination of Username and Password ]
### 2.Register function: New users can register through register page. All the new users' data will be stored in the database. [ New users can register in this system. The information must be written to the dataset so that new user can login in. (5pts) ]
### 3.GUI for movies and information: In the main page of users' interface, you can see some classic movies with carousel controllers. Also, in another subpages, you can see some basic movies and their information in the system. They're also presented with carousel assemblies.[ (1pts)Users can see movie information ]
### 4.Comment and Rate: In the Comment page, Users can choose their rate on certain movies and comment on movies. Similarly, All the users' comments and rates will be stored in the database.[ (4pts)Users can rate and comment (4pts)Comments and ratings have to be stored in the system ]
### 5.Recommendation: This part just includes a demo interface of recommending. Due to the situation that realtime responses require much JSON knowledge and stable api, which is completely out of my current ability. Here the chatting part will only show the same information with the users' input.
### 6.Animation: I include some fancy animations with some carousels, such as carousels, titles and buttons. Though some of them are from third-party packages, they also take some work to initialize and implement them into my own project.
### 7.Relatively complete interfaces: I include relatively complete interfaces, like loginerror and registererror pages. [ (6pts)Buttons (6pts)Text inputs (4pts)User friendly (4pts) Properly arranged ]
### 8.Upload pictures: Users can upload pictures while commenting. All the pictures’ information will be loaded to the database. [Pictures Uploading (5%). the users can upload pictures when they post their comments to the movie.]
### 9.Exit: Through exit, you can turn back to login to other users, which will reinitialize users.

## Admin User Side:
### 1.Plots: when clicking the button, admins can enter the plots side. There’re bar charts of age distribution for different movies and pie charts for ratings for different movies. All the charts’ information is based on the data in the database, selecting data through certain sql statement and then add them into the plots. [ (3pts)Admins can view statistics (in plots) ]
### 2.Tableview for rating: Similarly, the tableview’ information is based on the data in the database. Admins can see all ratings from users for different movies. [ (2pts)Admins can view all ratings from users.]
### 3.Add/remove movies: The remove part is to get the movie to be deleted from the choice box, and delete all the related from the database and movie lists using the sql statement and arraylist functions. The removing part is to get the added movie names from the text-field and add these name to the movie names arraylist. Then get the last movie name from the arraylist and assign them into the specific names so that users can comment. [ (2pts)Admins can add/remove data ]
### 4.Upload pictures: Admins can upload posters while adding movies. All the posters will be loaded to the database. [Pictures Uploading (5%). The managers can upload movie posters when they add movies to the system.]


