package com.flight.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(validateEmail(email))
        {
            this.email = email;
        }
    }

    public boolean validateEmail(String email){
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern emailPat = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }
}
