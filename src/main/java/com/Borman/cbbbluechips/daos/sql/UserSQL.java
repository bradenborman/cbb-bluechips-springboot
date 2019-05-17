package com.Borman.cbbbluechips.daos.sql;

public class UserSQL {

    public static final String insertUser = "INSERT INTO user (`First_Name`, `Last_Name`, `Email`, `Password`, `Password_Hint`,`Cash`) " +
            "VALUES (:firstName, :lastName, :email, :password, :passwordHint, :cash);";

    public static final String deleteUser = "DELETE FROM user WHERE User_ID = :userId;";

}
