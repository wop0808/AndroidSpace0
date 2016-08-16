package com.example.test_8_10;

/**
 * Created by Administrator on 2016/8/10.
 */
public class Person {


    /**
     * error_code : 200
     * reason : Success
     * info : {"user_name":"share_android","user_pwd":"123456789","user_head":"http://172.18.4.3:8080/user/head.png"}
     */

    private int error_code;
    private String reason;
    /**
     * user_name : share_android
     * user_pwd : 123456789
     * user_head : http://172.18.4.3:8080/user/head.png
     */

    private InfoBean info;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        private String user_name;
        private String user_pwd;
        private String user_head;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_pwd() {
            return user_pwd;
        }

        public void setUser_pwd(String user_pwd) {
            this.user_pwd = user_pwd;
        }

        public String getUser_head() {
            return user_head;
        }

        public void setUser_head(String user_head) {
            this.user_head = user_head;
        }
    }
}
