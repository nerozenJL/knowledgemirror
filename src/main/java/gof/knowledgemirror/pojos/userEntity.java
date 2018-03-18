package gof.knowledgemirror.pojos;

import java.io.Serializable;

public class userEntity implements Serializable {
    private int userID;
    private String userName;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}