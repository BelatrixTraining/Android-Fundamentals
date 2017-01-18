package com.bx.android;

/**
 * Created by eduardomedina on 18/01/17.
 */
public class UserEntity {

    private int id;
    private String name;
    private String lastName;

    public UserEntity(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public UserEntity() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {


        this.id = id;
    }

    public String getName() {


        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }
}
