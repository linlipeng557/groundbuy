package com.groundbuy.mine_model.bean;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/17
 */
public class MyCommentBean {

    /**
     * baseData : {"totalRow":1,"pageNumber":1,"lastPage":true,"firstPage":true,"totalPage":1,"pageSize":10,"list":[{"commentImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"createTime":"2019-07-01 15:34:38","goodsId":1,"price":500,"discountPrice":250,"commentId":1,"portrait":"http://equipment.leaf-tech.net:8081/image/default_portrait.jpg","goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"userId":1,"goodsName":"KM罗马鞋","content":"test","username":"ape1"}]}
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
         * list : [{"commentImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"createTime":"2019-07-01 15:34:38","goodsId":1,"price":500,"discountPrice":250,"commentId":1,"portrait":"http://equipment.leaf-tech.net:8081/image/default_portrait.jpg","goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"userId":1,"goodsName":"KM罗马鞋","content":"test","username":"ape1"}]
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
             * commentImgs : ["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"]
             * createTime : 2019-07-01 15:34:38
             * goodsId : 1
             * price : 500
             * discountPrice : 250
             * commentId : 1
             * portrait : http://equipment.leaf-tech.net:8081/image/default_portrait.jpg
             * goodsImgs : ["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"]
             * userId : 1
             * goodsName : KM罗马鞋
             * content : test
             * username : ape1
             */

            private String createTime;
            private int goodsId;
            private int price;
            private int discountPrice;
            private int commentId;
            private String portrait;
            private int userId;
            private String goodsName;
            private String content;
            private String username;
            private List<String> commentImgs;
            private List<String> goodsImgs;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

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

            public int getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(int discountPrice) {
                this.discountPrice = discountPrice;
            }

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }

            public String getPortrait() {
                return portrait;
            }

            public void setPortrait(String portrait) {
                this.portrait = portrait;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public List<String> getCommentImgs() {
                return commentImgs;
            }

            public void setCommentImgs(List<String> commentImgs) {
                this.commentImgs = commentImgs;
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
