package com.Borman.cbbbluechips.daos.sql;

public class UserSQL {

    public static final String getAllUsers = "SELECT * FROM user;";

    public static final String insertUser = "INSERT INTO user (`First_Name`, `Last_Name`, `Email`, `Password`, `Cash`) " +
            "VALUES (:firstName, :lastName, :email, :password, :cash);";

    public static final String deleteUser = "DELETE FROM user WHERE User_ID = :userId;";

    public static final String deleteAllUsers = "DELETE FROM user WHERE User_ID > 0";

    public static final String addMoneyToUser = "UPDATE user SET Cash = Cash + :newMoney WHERE (User_ID = :userId);";

    public static final String removeMoneyFromUser = "UPDATE user SET Cash = Cash - :newMoney WHERE (User_ID = :userId);";

    public static final String getUserById = "SELECT * FROM user where User_ID = :userId;";

    public static final String getUserWithEmailAndPassword  = "SELECT * FROM user where Email = :email AND Password = :password;";

    public static final String getUserWithEmail  = "SELECT * FROM user where Email = :email";

    public static final String doesUserSubscribeToTextAlerts = "SELECT Send_Alerts FROM user WHERE User_ID = :userId;";

    public static final String subscribeUserToTextAlerts = "UPDATE user SET Send_Alerts = 1 WHERE User_ID = :userId;";

    public static final String unSubscribeUserToTextAlerts = "UPDATE user SET Send_Alerts = 0 WHERE User_ID = :userId;";

    public static final String getUserPhoneNumber = "SELECT Phone_Number FROM user where User_ID = :userId";

    public static final String updateUsersPhoneNumber = "UPDATE user SET Phone_Number = :phoneNumber WHERE User_ID = :userId;";

}
