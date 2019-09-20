package com.groundbuy.mine_model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/17
 */
public class OrderListBean implements Serializable {

    /**
     * baseData : {"totalRow":2,"pageNumber":1,"lastPage":true,"firstPage":true,"totalPage":1,"pageSize":10,"list":[{"logisticsPrice":6,"shopPortrait":"https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795","amount":3,"orderNumber":"1145630807466053632","totalPrice":756,"price":500,"discountPrice":250,"shopName":"爱依服","orderStatus":1,"stockSpecs":"{\u201c颜色\u201d:\"红色\",\"尺码\":\"M\"}","goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"goodsName":"KM罗马鞋"},{"logisticsPrice":6,"shopPortrait":"https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795","amount":3,"orderNumber":"1145630227469307904","totalPrice":756,"price":500,"discountPrice":250,"shopName":"爱依服","orderStatus":-3,"stockSpecs":"{\u201c颜色\u201d:\"红色\",\"尺码\":\"M\"}","goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"goodsName":"KM罗马鞋"}]}
     */

    private BaseDataBean baseData;

    public BaseDataBean getBaseData() {
        return baseData;
    }

    public void setBaseData(BaseDataBean baseData) {
        this.baseData = baseData;
    }

    public static class BaseDataBean implements Serializable{
        /**
         * totalRow : 2
         * pageNumber : 1
         * lastPage : true
         * firstPage : true
         * totalPage : 1
         * pageSize : 10
         * list : [{"logisticsPrice":6,"shopPortrait":"https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795","amount":3,"orderNumber":"1145630807466053632","totalPrice":756,"price":500,"discountPrice":250,"shopName":"爱依服","orderStatus":1,"stockSpecs":"{\u201c颜色\u201d:\"红色\",\"尺码\":\"M\"}","goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"goodsName":"KM罗马鞋"},{"logisticsPrice":6,"shopPortrait":"https://apeweb.oss-cn-shenzhen.aliyuncs.com/test/20190122-fbd07e9d4b9f4bd3af4ef3d848eb4795","amount":3,"orderNumber":"1145630227469307904","totalPrice":756,"price":500,"discountPrice":250,"shopName":"爱依服","orderStatus":-3,"stockSpecs":"{\u201c颜色\u201d:\"红色\",\"尺码\":\"M\"}","goodsImgs":["https://www.xiangjialitou.com/upload/20190516093541_07283106340949d48964a341cff2175b.jpg","https://www.xiangjialitou.com/upload/20190527104608_17172c42531d45cb8a6da296131dd596.jpg","https://www.xiangjialitou.com/upload/20190611143529_5423e846e15c42089d0f1ca557701334.jpg"],"goodsName":"KM罗马鞋"}]
         */

        private int totalRow;
        private int pageNumber;
        private boolean lastPage;
        private boolean firstPage;
        private int totalPage;
        private int pageSize;
        private List<OrderContentBean> list;

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

        public List<OrderContentBean> getList() {
            return list;
        }

        public void setList(List<OrderContentBean> list) {
            this.list = list;
        }


    }
}
