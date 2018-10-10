package es.source.code.model;

import java.io.Serializable;

public class User implements Serializable{
    private String userName;
    private String passwd;
    private Boolean oldUser;

    public Boolean getOldUser() {
        return oldUser;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name){
        userName = name;
    }

    public void setPasswd(String passwd1){
        passwd = passwd1;
    }
    public void setOldUser(Boolean oldUser1){
        oldUser = oldUser1;
    }
}
