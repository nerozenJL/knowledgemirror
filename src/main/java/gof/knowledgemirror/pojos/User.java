package gof.knowledgemirror.pojos;

import javafx.scene.chart.PieChart;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
    private int userID;
    private String userName;
    private String userPassword;
    private Date userBorndate;
    private String userEvalution;
    private String userEducation;
    private String userExperience;
    private String userHonor;
    private String userSkill;

    public String getUserEducation() {
        return userEducation;
    }

    public void setUserEducation(String userEducation) {
        this.userEducation = userEducation;
    }

    public String getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(String userExperience) {
        this.userExperience = userExperience;
    }

    public String getUserHonor() {
        return userHonor;
    }

    public void setUserHonor(String userHonor) {
        this.userHonor = userHonor;
    }

    public String getUserSkill() {
        return userSkill;
    }

    public void setUserSkill(String userSkill) {
        this.userSkill = userSkill;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserBorndate() {
        return userBorndate;
    }

    public void setUserBorndate(Date userBorndate) {
        this.userBorndate = userBorndate;
    }

    public String getUserEvalution() {
        return userEvalution;
    }

    public void setUserEvalution(String userEvalution) {
        this.userEvalution = userEvalution;
    }

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