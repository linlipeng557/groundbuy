package com.groundbuy.mine_model.bean;

import java.io.Serializable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class UserBean implements Serializable {

    /**
     * baseData : {"country":"\u201c11\u201d","city":"\u201c11\u201d","openid":"\u201c11\u201d","sex":1,"weixinId":"\u201c11\u201d","weixinName":"\u201c11\u201d","mobile":"15902064445","alipayName":"\u201c11\u201d","updateTime":"2019-06-29 14:13:06","portrait":"http://equipment.leaf-tech.net:8081/image/default_portrait.jpg","ub":100,"version":0,"deviceId":"1","platform":"app","password":"6klnrxsjs9735b4fna7wf63r","money":0,"province":"\u201c11\u201d","createTime":"2019-06-28 00:15:44","name":"ape","id":1,"payPassword":"\u201c11\u201d","alipayId":"\u201c11\u201d","status":1}
     */

    private BaseDataBean baseData;
    /**
     * token : ac28b82927e34daf8abf46642e0bc962
     */

    private String token;


    public BaseDataBean getBaseData() {
        return baseData;
    }



    public void setBaseData(BaseDataBean baseData) {
        this.baseData = baseData;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class BaseDataBean implements Serializable {
        /**
         * country : “11”
         * city : “11”
         * openid : “11”
         * sex : 1
         * weixinId : “11”
         * weixinName : “11”
         * mobile : 15902064445
         * alipayName : “11”
         * updateTime : 2019-06-29 14:13:06
         * portrait : http://equipment.leaf-tech.net:8081/image/default_portrait.jpg
         * ub : 100
         * version : 0
         * deviceId : 1
         * platform : app
         * password : 6klnrxsjs9735b4fna7wf63r
         * money : 0
         * province : “11”
         * createTime : 2019-06-28 00:15:44
         * name : ape
         * id : 1
         * payPassword : “11”
         * alipayId : “11”
         * status : 1
         */

        private String country;
        private String city;
        private String openid;
        private int sex;
        private int weixinId;
        private String weixinName;
        private String mobile;
        private String alipayName;
        private String updateTime;
        private String portrait;
        private int ub;
        private int version;
        private int deviceId;
        private String platform;
        private String password;
        private int money;
        private String province;
        private String createTime;
        private String name;
        private int id;
        private String payPassword;
        private int alipayId;
        private int status;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getWeixinId() {
            return weixinId;
        }

        public void setWeixinId(int weixinId) {
            this.weixinId = weixinId;
        }

        public String getWeixinName() {
            return weixinName;
        }

        public void setWeixinName(String weixinName) {
            this.weixinName = weixinName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getAlipayName() {
            return alipayName;
        }

        public void setAlipayName(String alipayName) {
            this.alipayName = alipayName;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public int getUb() {
            return ub;
        }

        public void setUb(int ub) {
            this.ub = ub;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public int getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(int deviceId) {
            this.deviceId = deviceId;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPayPassword() {
            return payPassword;
        }

        public void setPayPassword(String payPassword) {
            this.payPassword = payPassword;
        }

        public int getAlipayId() {
            return alipayId;
        }

        public void setAlipayId(int alipayId) {
            this.alipayId = alipayId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
