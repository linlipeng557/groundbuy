package com.groundbuy.mine_model.bean;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/16
 */
public class HistoryListBean {

    /**
     * baseData : {"totalRow":1,"pageNumber":1,"firstPage":true,"lastPage":true,"totalPage":1,"pageSize":10,"list":[{"goodsId":1,"price":500,"baseDiscountEndTime":"2019-07-08 10:51:34","discountPrice":250,"productStatus":1,"maxDiscountRate":7.5,"leftTime":512408,"goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"goodsName":"KM罗马鞋","returnUB":10,"status":1,"minDiscountRate":1}]}
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
         * firstPage : true
         * lastPage : true
         * totalPage : 1
         * pageSize : 10
         * list : [{"goodsId":1,"price":500,"baseDiscountEndTime":"2019-07-08 10:51:34","discountPrice":250,"productStatus":1,"maxDiscountRate":7.5,"leftTime":512408,"goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"goodsName":"KM罗马鞋","returnUB":10,"status":1,"minDiscountRate":1}]
         */

        private int totalRow;
        private int pageNumber;
        private boolean firstPage;
        private boolean lastPage;
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

        public boolean isFirstPage() {
            return firstPage;
        }

        public void setFirstPage(boolean firstPage) {
            this.firstPage = firstPage;
        }

        public boolean isLastPage() {
            return lastPage;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
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
             * goodsId : 1
             * price : 500
             * baseDiscountEndTime : 2019-07-08 10:51:34
             * discountPrice : 250
             * productStatus : 1
             * maxDiscountRate : 7.5
             * leftTime : 512408
             * goodsImgs : ["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"]
             * goodsName : KM罗马鞋
             * returnUB : 10
             * status : 1
             * minDiscountRate : 1
             */

            private int goodsId;
            private int price;
            private String baseDiscountEndTime;
            private int discountPrice;
            private int productStatus;
            private double maxDiscountRate;
            private int leftTime;
            private String goodsName;
            private int returnUB;
            private int status;
            private int minDiscountRate;
            private List<String> goodsImgs;

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getBaseDiscountEndTime() {
                return baseDiscountEndTime;
            }

            public void setBaseDiscountEndTime(String baseDiscountEndTime) {
                this.baseDiscountEndTime = baseDiscountEndTime;
            }

            public int getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(int discountPrice) {
                this.discountPrice = discountPrice;
            }

            public int getProductStatus() {
                return productStatus;
            }

            public void setProductStatus(int productStatus) {
                this.productStatus = productStatus;
            }

            public double getMaxDiscountRate() {
                return maxDiscountRate;
            }

            public void setMaxDiscountRate(double maxDiscountRate) {
                this.maxDiscountRate = maxDiscountRate;
            }

            public int getLeftTime() {
                return leftTime;
            }

            public void setLeftTime(int leftTime) {
                this.leftTime = leftTime;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public int getReturnUB() {
                return returnUB;
            }

            public void setReturnUB(int returnUB) {
                this.returnUB = returnUB;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getMinDiscountRate() {
                return minDiscountRate;
            }

            public void setMinDiscountRate(int minDiscountRate) {
                this.minDiscountRate = minDiscountRate;
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
