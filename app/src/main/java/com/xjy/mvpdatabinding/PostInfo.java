package com.xjy.mvpdatabinding;

import java.util.List;

/**
 * User: Tom
 * Date: 2016-07-23
 * Time: 15:58
 * FIXME
 */
public class PostInfo {

    /**
     * message : ok
     * nu : 888619996972
     * ischeck : 0
     * com : shentong
     * updatetime : 2016-07-23 15:53:59
     * status : 200
     * condition : 00
     * data : [{"time":"2016-07-22 22:01:34","location":"","context":"由 浙江义乌公司 发往 广东广州中转部","ftime":"2016-07-22 22:01:34"},{"time":"2016-07-22 22:01:34","location":"","context":"浙江义乌公司 正在进行 装车 扫描","ftime":"2016-07-22 22:01:34"},{"time":"2016-07-22 17:29:28","location":"","context":"由 浙江安吉公司(0572-5035080) 发往 浙江杭州航空部","ftime":"2016-07-22 17:29:28"},{"time":"2016-07-22 17:29:28","location":"","context":"浙江安吉公司(0572-5035080) 正在进行 装车 扫描","ftime":"2016-07-22 17:29:28"},{"time":"2016-07-22 17:29:03","location":"","context":"浙江安吉公司(0572-5035080) 的收件员 田诚 已收件","ftime":"2016-07-22 17:29:03"}]
     * state : 0
     */

    private String message;
    private String nu;
    private String ischeck;
    private String com;
    private String updatetime;
    private String status;
    private String condition;
    private String state;
    /**
     * time : 2016-07-22 22:01:34
     * location :
     * context : 由 浙江义乌公司 发往 广东广州中转部
     * ftime : 2016-07-22 22:01:34
     */

    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String time;
        private String location;
        private String context;
        private String ftime;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public String getFtime() {
            return ftime;
        }

        public void setFtime(String ftime) {
            this.ftime = ftime;
        }
    }
}