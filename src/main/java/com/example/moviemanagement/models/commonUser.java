package com.example.moviemanagement.models;

/*save the current user's information in the system so that these information can be used to save in the database
while users commenting.
 */
public class commonUser {
    //initialize current admins or users.
    private static int userid;
    private static String username;
    private static String userType;
    private static int userAge;
    private static String userGender;

    public static void setUserid(int id){
        commonUser.userid = id;
    }

    public static void setUsername(String name){
        commonUser.username = name;
    }

    public static void setUserType(String type){
        commonUser.userType = type;
    }

    public static void setAge(int age){
        commonUser.userAge = age;
    }

    public static void setGender(String gender ){
        commonUser.userGender = gender;
    }

    public static String getType(){
        return userType;
    }

    public static int getAge(){
        return userAge;
    }

    public static String getGender() {
        return userGender;
    }

    public static String getName(){
        return username;
    }

    public static int getId(){
        return userid;
    }




}
