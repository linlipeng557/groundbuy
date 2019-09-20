package com.groundbuy.mine_model.bean;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/17
 */
public class RefundListBean {

    /**
     * baseData : {"totalRow":1,"pageNumber":1,"lastPage":true,"firstPage":true,"totalPage":1,"pageSize":10,"list":[{"orderNumber":"1148140468752748544","totalPrice":106,"discountPrice":100,"stockSpecs":"{\"颜色\":\"红色\",\"尺码\":\"M\"}","orderAmount":1,"createTime":"2019-07-08 16:09:44","price":1000,"reserveNumber":null,"goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"goodsName":"KM罗马鞋","refundId":1,"status":-2,"refundAmount":1}]}
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
         * totalRow : 1
         * pageNumber : 1
         * lastPage : true
         * firstPage : true
         * totalPage : 1
         * pageSize : 10
         * list : [{"orderNumber":"1148140468752748544","totalPrice":106,"discountPrice":100,"stockSpecs":"{\"颜色\":\"红色\",\"尺码\":\"M\"}","orderAmount":1,"createTime":"2019-07-08 16:09:44","price":1000,"reserveNumber":null,"goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"goodsName":"KM罗马鞋","refundId":1,"status":-2,"refundAmount":1}]
         */

        private int totalRow;
        private int pageNumber;
        private boolean lastPage;
        private boolean firstPage;
        private int totalPage;
        private int pageSize;
        private List<ListBean> list;

        public int getTotalRow() {
            return totalRow;
        }

        public void setTotalRow(int totalRow) {
            this.totalRow = totalRow;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public boolean isLastPage() {
            return lastPage;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
        }

        public boolean isFirstPage() {
            return firstPage;
        }

        public void setFirstPage(boolean firstPage) {
            this.firstPage = firstPage;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * orderNumber : 1148140468752748544
             * totalPrice : 106
             * discountPrice : 100
             * stockSpecs : {"颜色":"红色","尺码":"M"}
             * orderAmount : 1
             * createTime : 2019-07-08 16:09:44
             * price : 1000
             * reserveNumber : null
             * goodsImgs : ["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"]
             * goodsName : KM罗马鞋
             * refundId : 1
             * status : -2
             * refundAmount : 1
             */

            private String orderNumber;
            private int totalPrice;
            private int discountPrice;
            private String stockSpecs;
            private int orderAmount;
            private String createTime;
            private int price;
            private Object reserveNumber;
            private String goodsName;
            private int refundId;
            private int status;
            private int refundAmount;
            private List<String> goodsImgs;

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

            public String getStockSpecs() {
                return stockSpecs;
            }

            public void setStockSpecs(String stockSpecs) {
                this.stockSpecs = stockSpecs;
            }

            public int getOrderAmount() {
                return orderAmount;
            }

            public void setOrderAmount(int orderAmount) {
                this.orderAmount = orderAmount;
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

            public Object getReserveNumber() {
                return reserveNumber;
            }

            public void setReserveNumber(Object reserveNumber) {
                this.reserveNumber = reserveNumber;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public int getRefundId() {
                return refundId;
            }

            public void setRefundId(int refundId) {
                this.refundId = refundId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getRefundAmount() {
                return refundAmount;
            }

            public void setRefundAmount(int refundAmount) {
                this.refundAmount = refundAmount;
            }

            public List<String> getGoodsImgs() {
                return goodsImgs;
            }

            public void setGoodsImgs(List<String> goodsImgs) {
                this.goodsImgs = goodsImgs;
            }
        }
    }
}
