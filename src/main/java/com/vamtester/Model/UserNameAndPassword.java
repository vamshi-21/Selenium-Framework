package com.vamtester.Model;

import lombok.Data;

@Data
public class UserNameAndPassword {

    private String username;

    private String password;

    public UserNameAndPassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
