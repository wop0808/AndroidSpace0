package com.example.test_8_1;

import java.util.List;

/**
 * Created by Administrator on 2016/8/1.
 */
public class MyGson {


    /**
     * errorcode : 200
     * reason : Success
     * frends : [{"frend_name":"江泽民","frend_icon":"http://172.18.4.3:8080/kaoshi/img/jzm.png"},{"frend_name":"胡锦涛","frend_icon":"http://172.18.4.3:8080/kaoshi/img/hjt.png"},{"frend_name":"习近平","frend_icon":"http://172.18.4.3:8080/kaoshi/img/xjp.png"}]
     */

    public int errorcode;
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
