package com.school.model;
// FIX: Unified package structure to make imports smooth

public abstract class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // FIX: Standardized to Java camelCase conventions (getId instead of getID).
    // This stops child classes from crashing due to casing mismatches.
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public abstract void displayDashboard();
}

