package com.example.interdownload_gson;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */


public class Friends {
    /**
     * errorcode : 200
     * reason : Success
     * frends : [{"frend_name":"江泽民","frend_icon":"http://172.18.4.3:8080/kaoshi/img/jzm.png"},{"frend_name":"胡锦涛","frend_icon":"http://172.18.4.3:8080/kaoshi/img/hjt.png"},{"frend_name":"习近平","frend_icon":"http://172.18.4.3:8080/kaoshi/img/xjp.png"}]
     */

    public String errorcode;
    public String reason;
    /**
     * frend_name : 江泽民
     * frend_icon : http://172.18.4.3:8080/kaoshi/img/jzm.png
     */

    public List<FrendsBean> frends;

    public static class FrendsBean {
        public String frend_name;
        public String frend_icon;
    }

}
