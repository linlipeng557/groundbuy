package com.groundbuy.mine_model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/19
 */
public class OrderDetailsBean implements Serializable {

    /**
     * onRefunding : 0
     * refundSuccess : 0
     * address : {"area":"番禺区","zipCode":"510000","isChoice":1,"address":"厦滘修改1","city":"广州市","mobile":"15902064445","updateTime":null,"userId":1,"province":"广东省","createTime":"2019-07-01 17:48:25","name":"阿佩","id":1,"status":1}
     * waitReceiptTime :
     * waitPayTime : -580827
     * order : {"shopPortrait":"https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795","amount":3,"orderNumber":"1145630227469307904","totalPrice":756,"payTime":null,"waitPayTime":"2019-07-01 17:53:25","shipTime":null,"discountPrice":250,"orderAddressId":1,"shopName":"爱依服","orderStatus":-3,"stockSpecs":"{\u201c颜色\u201d:\"红色\",\"尺码\":\"M\"}","remark":"尽快发货","commentTime":null,"logisticsPrice":6,"createTime":"2019-07-01 17:48:25","price":500,"closeTime":"2019-07-01 18:04:02","goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"goodsName":"KM罗马鞋"}
     */

    private int onRefunding;
    private int refundSuccess;
    private AddressBean address;
    private String waitReceiptTime;
    private int waitPayTime;
    private OrderContentBean order;

    public int getOnRefunding() {
        return onRefunding;
    }

    public void setOnRefunding(int onRefunding) {
        this.onRefunding = onRefunding;
    }

    public int getRefundSuccess() {
        return refundSuccess;
    }

    public void setRefundSuccess(int refundSuccess) {
        this.refundSuccess = refundSuccess;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public String getWaitReceiptTime() {
        return waitReceiptTime;
    }

    public void setWaitReceiptTime(String waitReceiptTime) {
        this.waitReceiptTime = waitReceiptTime;
    }

    public int getWaitPayTime() {
        return waitPayTime;
    }

    public void setWaitPayTime(int waitPayTime) {
        this.waitPayTime = waitPayTime;
    }

    public OrderContentBean getOrder() {
        return order;
    }

    public void setOrder(OrderContentBean order) {
        this.order = order;
    }

    public static class AddressBean implements Serializable{
        /**
         * area : 番禺区
         * zipCode : 510000
         * isChoice : 1
         * address : 厦滘修改1
         * city : 广州市
         * mobile : 15902064445
         * updateTime : null
         * userId : 1
         * province : 广东省
         * createTime : 2019-07-01 17:48:25
         * name : 阿佩
         * id : 1
         * status : 1
         */

        private String area;
        private String zipCode;
        private int isChoice;
        private String address;
        private String city;
        private String mobile;
        private Object updateTime;
        private int userId;
        private String province;
        private String createTime;
        private String name;
        private int id;
        private int status;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public int getIsChoice() {
            return isChoice;
        }

        public void setIsChoice(int isChoice) {
            this.isChoice = isChoice;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }


}
