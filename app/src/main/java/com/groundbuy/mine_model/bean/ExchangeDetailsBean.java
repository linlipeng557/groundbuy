package com.groundbuy.mine_model.bean;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/16
 */
public class ExchangeDetailsBean {

    /**
     * address : {"area":"番禺区","zipCode":"510000","isChoice":1,"address":"厦滘修改1","city":"广州市","mobile":"15902064445","updateTime":null,"userId":1,"province":"广东省","createTime":"2019-07-02 12:57:20","name":"阿佩","id":3,"status":1}
     * baseData : {"needUB":2,"attributeInfo":null,"imgUrls":["https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795"],"createTime":"2019-06-29 18:14:13","productStatus":1,"updateTime":null,"id":1,"sort":0,"title":"test","desc":"test","status":1}
     * ubGoods : {"needUB":2,"attributeInfo":null,"imgUrls":["https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795"],"createTime":"2019-06-29 18:14:13","productStatus":1,"updateTime":null,"id":1,"sort":0,"title":"test","desc":"test","status":1}
     * exchange : {"amount":1,"orderNumber":"1145919361333202944","orderAddressId":3,"orderStatus":0,"updateTime":"2019-07-02 12:57:52","ubGoodsId":1,"dbPrice":2,"userId":1,"createTime":"2019-07-02 12:57:20","ubStockId":1,"ubStockSpecs":"{\u201c颜色\u201d:\"白色\",\"尺码\":\"M\"}","id":1,"dbTotal":2,"status":1}
     */

    private AddressBean address;
    private BaseDataBean baseData;
    private UbGoodsBean ubGoods;
    private ExchangeBean exchange;

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public BaseDataBean getBaseData() {
        return baseData;
    }

    public void setBaseData(BaseDataBean baseData) {
        this.baseData = baseData;
    }

    public UbGoodsBean getUbGoods() {
        return ubGoods;
    }

    public void setUbGoods(UbGoodsBean ubGoods) {
        this.ubGoods = ubGoods;
    }

    public ExchangeBean getExchange() {
        return exchange;
    }

    public void setExchange(ExchangeBean exchange) {
        this.exchange = exchange;
    }

    public static class AddressBean {
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
         * createTime : 2019-07-02 12:57:20
         * name : 阿佩
         * id : 3
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

    public static class BaseDataBean {
        /**
         * needUB : 2
         * attributeInfo : null
         * imgUrls : ["https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795"]
         * createTime : 2019-06-29 18:14:13
         * productStatus : 1
         * updateTime : null
         * id : 1
         * sort : 0
         * title : test
         * desc : test
         * status : 1
         */

        private int needUB;
        private Object attributeInfo;
        private String createTime;
        private int productStatus;
        private Object updateTime;
        private int id;
        private int sort;
        private String title;
        private String desc;
        private int status;
        private List<String> imgUrls;

        public int getNeedUB() {
            return needUB;
        }

        public void setNeedUB(int needUB) {
            this.needUB = needUB;
        }

        public Object getAttributeInfo() {
            return attributeInfo;
        }

        public void setAttributeInfo(Object attributeInfo) {
            this.attributeInfo = attributeInfo;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getProductStatus() {
            return productStatus;
        }

        public void setProductStatus(int productStatus) {
            this.productStatus = productStatus;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public List<String> getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(List<String> imgUrls) {
            this.imgUrls = imgUrls;
        }
    }

    public static class UbGoodsBean {
        /**
         * needUB : 2
         * attributeInfo : null
         * imgUrls : ["https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795"]
         * createTime : 2019-06-29 18:14:13
         * productStatus : 1
         * updateTime : null
         * id : 1
         * sort : 0
         * title : test
         * desc : test
         * status : 1
         */

        private int needUB;
        private String attributeInfo;
        private String createTime;
        private int productStatus;
        private Object updateTime;
        private int id;
        private int sort;
        private String title;
        private String desc;
        private int status;
        private List<String> imgUrls;

        public int getNeedUB() {
            return needUB;
        }

        public void setNeedUB(int needUB) {
            this.needUB = needUB;
        }

        public String getAttributeInfo() {
            return attributeInfo;
        }

        public void setAttributeInfo(String attributeInfo) {
            this.attributeInfo = attributeInfo;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getProductStatus() {
            return productStatus;
        }

        public void setProductStatus(int productStatus) {
            this.productStatus = productStatus;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public List<String> getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(List<String> imgUrls) {
            this.imgUrls = imgUrls;
        }
    }

    public static class ExchangeBean {
        /**
         * amount : 1
         * orderNumber : 1145919361333202944
         * orderAddressId : 3
         * orderStatus : 0
         * updateTime : 2019-07-02 12:57:52
         * ubGoodsId : 1
         * dbPrice : 2
         * userId : 1
         * createTime : 2019-07-02 12:57:20
         * ubStockId : 1
         * ubStockSpecs : {“颜色”:"白色","尺码":"M"}
         * id : 1
         * dbTotal : 2
         * status : 1
         */

        private int amount;
        private String orderNumber;
        private int orderAddressId;
        private int orderStatus;
        private String updateTime;
        private int ubGoodsId;
        private int dbPrice;
        private int userId;
        private String createTime;
        private int ubStockId;
        private String ubStockSpecs;
        private int id;
        private int dbTotal;
        private int status;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public int getOrderAddressId() {
            return orderAddressId;
        }

        public void setOrderAddressId(int orderAddressId) {
            this.orderAddressId = orderAddressId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getUbGoodsId() {
            return ubGoodsId;
        }

        public void setUbGoodsId(int ubGoodsId) {
            this.ubGoodsId = ubGoodsId;
        }

        public int getDbPrice() {
            return dbPrice;
        }

        public void setDbPrice(int dbPrice) {
            this.dbPrice = dbPrice;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getUbStockId() {
            return ubStockId;
        }

        public void setUbStockId(int ubStockId) {
            this.ubStockId = ubStockId;
        }

        public String getUbStockSpecs() {
            return ubStockSpecs;
        }

        public void setUbStockSpecs(String ubStockSpecs) {
            this.ubStockSpecs = ubStockSpecs;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDbTotal() {
            return dbTotal;
        }

        public void setDbTotal(int dbTotal) {
            this.dbTotal = dbTotal;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
