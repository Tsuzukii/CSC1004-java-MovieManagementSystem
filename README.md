# CSC1004-java-MovieManagementSystem
## Functions implemented:
### Common User Side: 
1. Login functions: Both admins and common users can login through the same window. All the data is stored in the MySQL database, which is in the ".sql" file.
2. Register function: New users can register through register page. All the new users' data will be stored in the database.
3. GUI for movies and information: In the main page of users' interface, you can see some classic movies with carousel controllers. Also, in another subpages, you can see some basic movies and their information I chose to store in the system. They're also presented with carousel assemblies. 
4. Comment and Rate: In the Comment page, Users can choose their rate on certain movies and comment on movies. Similarly, All the users' comments and rates will be stored in the database.
5. Recommendation: This part just includes a demo interface of recommending. Due to the situation that realtime responses require much JSON knowledge and stable api, which is completely out of my current ability. Here the chatting part will only show the same information with the users' input.
6. Animation: I include some fancy animations with some carousels, such as carousels, titles and buttons. Though some of them are from outside packages, they also take some work to initialize and implement them into my own project.
7. Relatively complete interfaces: I include relatively complete interfaces, like loginerror and registererror pages.
8. Exit: Through exit, you can turn back to login to other users, which will reinitialize users.
### Current problems

2. 加电影的计数器如何实现可以不加重复的？
3. TableView的内容被覆盖了
## To be done
1. 研究下upload图片 比如用户头像的上传 可以用组件中的avatar
2. admin用户中的chart plots and bar plots 在数据库中的数据怎么对应 看下课件 大窗口分几个按键切换页面
3. 要一个注册成功返回登录的页面
