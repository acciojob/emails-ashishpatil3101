package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals(this.password) && issame(newPassword)){
            this.password=newPassword;
        }
    }
    public boolean issame(String s){
        if(s.length() < 8) return false;

        int upper=0;
        int lower=0;
        int digit=0;
        int special_char=0;
        for(char  ch:s.toCharArray()){

            if(ch >='A' && ch <= 'Z') upper++;
            else if (ch >='a' && ch <= 'z') lower++;
            else if(Character.isDigit(ch)) digit++;
            else special_char++;

        }
        if(lower==0 || upper==0 || special_char==0 || digit==0) return false;

        return true;
    }
}
