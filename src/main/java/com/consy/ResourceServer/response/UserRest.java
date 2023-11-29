package com.consy.ResourceServer.response;

import lombok.Data;

@Data
public class UserRest {
    private String userFirstName;
    private String userLastName;
    private String userId;

    public UserRest(String firstName, String lastName, String userId){
        this.userFirstName=firstName;
        this.userLastName=lastName;
        this.userId=userId;
    }
}
