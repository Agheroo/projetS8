package org.univamu.polytech.backend.data;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;

    private String name;

    private String password;

    public User() {
    }

    public String getId() {
        return id;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
