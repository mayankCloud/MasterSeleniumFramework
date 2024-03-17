package org.selenium.pom.objects;

import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class User {
    private String username;
    private String email;
    private String password;

    public User(){}
    public User(String username) throws IOException {
        User[] users= JacksonUtils.deSerializeJSON("user.json",User[].class);
        for(User user: users){
            if(user.getUsername().equals(username)){
                this.username = user.getUsername();
                this.password = user.getPassword();
                break;
            }
        }
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
