package com.groundbuy.mine_model.bean;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/19
 */
public class OrderCommontBean {

    /**
     * baseData : {"shopPortrait":"https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795","amount":1,"orderNumber":"1148160007548833792","totalPrice":106,"discountPrice":100,"shopName":"爱依服","stockSpecs":"{\"颜色\":\"红色\",\"尺码\":\"M\"}","commentTime":"2019-07-08 17:51:48","content":"tsetedf","logisticsPrice":6,"score":2,"commentImgs":null,"price":1000,"commentId":5,"goodsImgs":"https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg,https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg,https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg","goodsName":"KM罗马鞋"}
     */

    private BaseDataBean baseData;

    public BaseDataBean getBaseData() {
        return baseData;
    }

    public void setBaseData(BaseDataBean baseData) {
        this.baseData = baseData;
    }

    public static class BaseDataBean {
        /**
         * shopPortrait : https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795
         * amount : 1
         * orderNumber : 1148160007548833792
         * totalPrice : 106
         * discountPrice : 100
         * shopName : 爱依服
         * stockSpecs : {"颜色":"红色","尺码":"M"}
         * commentTime : 2019-07-08 17:51:48
         * content : tsetedf
         * logisticsPrice : 6
         * score : 2
         * commentImgs : null
         * price : 1000
         * commentId : 5
         * goodsImgs : https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg,https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg,https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg
         * goodsName : KM罗马鞋
         */

        private String shopPortrait;
        private int amount;
        private String orderNumber;
        private int totalPrice;
        private int discountPrice;
        private String shopName;
        private String stockSpecs;
        private String commentTime;
        private String content;
        private int logisticsPrice;
        private int score;
        private String commentImgs;
        private int price;
        private int commentId;
        private String goodsImgs;
        private String goodsName;

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

        public int getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(int discountPrice) {
            this.discountPrice = discountPrice;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getStockSpecs() {
            return stockSpecs;
        }

        public void setStockSpecs(String stockSpecs) {
            this.stockSpecs = stockSpecs;
        }

        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getLogisticsPrice() {
            return logisticsPrice;
        }

        public void setLogisticsPrice(int logisticsPrice) {
            this.logisticsPrice = logisticsPrice;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getCommentImgs() {
            return commentImgs;
        }

        public void setCommentImgs(String commentImgs) {
            this.commentImgs = commentImgs;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public String getGoodsImgs() {
            return goodsImgs;
        }

        public void setGoodsImgs(String goodsImgs) {
            this.goodsImgs = goodsImgs;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }
    }
}
