package com.groundbuy.mine_model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/19
 */
public class OrderContentBean  implements Serializable {
    /**
     * logisticsPrice : 6
     * shopPortrait : https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795
     * amount : 3
     * orderNumber : 1145630807466053632
     * totalPrice : 756
     * price : 500
     * discountPrice : 250
     * shopName : 爱依服
     * orderStatus : 1
     * stockSpecs : {“颜色”:"红色","尺码":"M"}
     * goodsImgs : ["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"]
     * goodsName : KM罗马鞋
     */

    private String shopPortrait;
    private int amount;
    private String orderNumber;
    private int totalPrice;
    private String payTime;
    private String waitPayTime;
    private Object shipTime;
    private int discountPrice;
    private int orderAddressId;
    private String shopName;
    private int orderStatus;
    private String stockSpecs;
    private String remark;
    private String commentTime;
    private int logisticsPrice;
    private String createTime;
    private int price;
    private String closeTime;
    private String goodsName;
    private List<String> goodsImgs;
    private int onRefunding;
    private int refundSuccess;
    private int refundStatus;
    private int refundId;

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

    public int getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(int refundStatus) {
        this.refundStatus = refundStatus;
    }

    public int getRefundId() {
        return refundId;
    }

    public void setRefundId(int refundId) {
        this.refundId = refundId;
    }

    public String getShopPortrait() {
        return shopPortrait;
    }

    public void setShopPortrait(String shopPortrait) {
        this.shopPortrait = shopPortrait;
    }

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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getWaitPayTime() {
        return waitPayTime;
    }

    public void setWaitPayTime(String waitPayTime) {
        this.waitPayTime = waitPayTime;
    }

    public Object getShipTime() {
        return shipTime;
    }

    public void setShipTime(Object shipTime) {
        this.shipTime = shipTime;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getOrderAddressId() {
        return orderAddressId;
    }

    public void setOrderAddressId(int orderAddressId) {
        this.orderAddressId = orderAddressId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStockSpecs() {
        return stockSpecs;
    }

    public void setStockSpecs(String stockSpecs) {
        this.stockSpecs = stockSpecs;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public int getLogisticsPrice() {
        return logisticsPrice;
    }

    public void setLogisticsPrice(int logisticsPrice) {
        this.logisticsPrice = logisticsPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public List<String> getGoodsImgs() {
        return goodsImgs;
    }

    public void setGoodsImgs(List<String> goodsImgs) {
        this.goodsImgs = goodsImgs;
    }
}
