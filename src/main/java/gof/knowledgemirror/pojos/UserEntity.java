package gof.knowledgemirror.pojos;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {
        private Integer id;
        private String user_name;
        private String user_password;
        private String user_email;
        private Date user_borndate;
        private String user_evalution;
        private String user_education;
        private String user_experience;
        private String user_honor;
        private String user_skill;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_password() {
            return user_password;
        }

        public void setUser_password(String user_password) {
            this.user_password = user_password;
        }

        public String getUser_email() {
            return user_email;
        }

        public void setUser_email(String user_email) {
            this.user_email = user_email;
        }

        public Date getUser_borndate() {
            return user_borndate;
        }

        public void setUser_borndate(Date user_borndate) {
            this.user_borndate = user_borndate;
        }

        public String getUser_evalution() {
            return user_evalution;
        }

        public void setUser_evalution(String user_evalution) {
            this.user_evalution = user_evalution;
        }

        public String getUser_education() {
            return user_education;
        }

        public void setUser_education(String user_education) {
            this.user_education = user_education;
        }

        public String getUser_experience() {
            return user_experience;
        }

        public void setUser_experience(String user_experience) {
            this.user_experience = user_experience;
        }

        public String getUser_honor() {
            return user_honor;
        }

        public void setUser_honor(String user_honor) {
            this.user_honor = user_honor;
        }

        public String getUser_skill() {
            return user_skill;
        }

        public void setUser_skill(String user_skill) {
            this.user_skill = user_skill;
        }
    }
