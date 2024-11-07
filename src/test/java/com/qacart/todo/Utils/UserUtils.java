package com.qacart.todo.Utils;

import com.github.javafaker.Faker;
import com.qacart.todo.Object.UserDetails;

public class UserUtils {
    public UserDetails generateUsers(){
        String firstName=new Faker().name().firstName();
        String lastName=new Faker().name().lastName();
        String email=new Faker().internet().emailAddress();
        String password=new Faker().internet().password();
        UserDetails userDetails=new UserDetails(email,firstName,lastName,password);
        return userDetails;
    }
}
