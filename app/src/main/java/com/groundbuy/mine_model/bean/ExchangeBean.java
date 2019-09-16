package com.groundbuy.mine_model.bean;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/11
 */
public class ExchangeBean {

    /**
     * baseData : {"totalRow":1,"pageNumber":1,"firstPage":true,"lastPage":true,"totalPage":1,"pageSize":10,"list":[{"exchangeId":1,"needUB":2,"amount":1,"createTime":"2019-07-02 12:57:20","imgUrls":["https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795"],"stock":0,"ubGoodsId":1,"goodsName":"test","status":1}]}
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
         * list : [{"exchangeId":1,"needUB":2,"amount":1,"createTime":"2019-07-02 12:57:20","imgUrls":["https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795"],"stock":0,"ubGoodsId":1,"goodsName":"test","status":1}]
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
             * exchangeId : 1
             * needUB : 2
             * amount : 1
             * createTime : 2019-07-02 12:57:20
             * imgUrls : ["https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795"]
             * stock : 0
             * ubGoodsId : 1
             * goodsName : test
             * status : 1
             */

            private int exchangeId;
            private int needUB;
            private int amount;
            private String createTime;
            private int stock;
            private int ubGoodsId;
            private String goodsName;
            private int status;
            private List<String> imgUrls;

            public int getExchangeId() {
                return exchangeId;
            }

            public void setExchangeId(int exchangeId) {
                this.exchangeId = exchangeId;
            }

            public int getNeedUB() {
                return needUB;
            }

            public void setNeedUB(int needUB) {
                this.needUB = needUB;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }

            public int getUbGoodsId() {
                return ubGoodsId;
            }

            public void setUbGoodsId(int ubGoodsId) {
                this.ubGoodsId = ubGoodsId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
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
    }
}
