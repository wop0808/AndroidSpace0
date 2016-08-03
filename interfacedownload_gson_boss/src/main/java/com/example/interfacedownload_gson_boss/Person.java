package com.example.interfacedownload_gson_boss;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Person {

    /**
     * errorcode : 200
     * reason : Success
     * frends : [{"frend_name":"江泽民","frend_icon":"http://172.18.4.3:8080/kaoshi/img/jzm.png"},{"frend_name":"胡锦涛","frend_icon":"http://172.18.4.3:8080/kaoshi/img/hjt.png"},{"frend_name":"习近平","frend_icon":"http://172.18.4.3:8080/kaoshi/img/xjp.png"}]
     */


    private List<FrendsBean> frends;

    private String errorcode;
    private String reason;
    /**
     * frend_name : 江泽民
     * frend_icon : http://172.18.4.3:8080/kaoshi/img/jzm.png
     */
    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<FrendsBean> getFrends() {
        return frends;
    }

    public void setFrends(List<FrendsBean> frends) {
        this.frends = frends;
    }

    public static class FrendsBean {
        private String frend_name;
        private String frend_icon;

        public String getFrend_name() {
            return frend_name;
        }

        public void setFrend_name(String frend_name) {
            this.frend_name = frend_name;
        }

        public String getFrend_icon() {
            return frend_icon;
        }

        public void setFrend_icon(String frend_icon) {
            this.frend_icon = frend_icon;
        }
    }
}
