package com.Borman.cbbbluechips.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class User {

    private String ID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordHint;
    private double cash;
    private List<Team> teamsOwned;
    private List<Transaction> allTransactions;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public List<Team> getTeamsOwned() {
        return teamsOwned;
    }

    public void setTeamsOwned(List<Team> teamsOwned) {
        this.teamsOwned = teamsOwned;
    }

    public List<Transaction> getAllTransactions() {
        return allTransactions;
    }

    public void setAllTransactions(List<Transaction> allTransactions) {
        this.allTransactions = allTransactions;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write User as string", e);
        }
    }

}