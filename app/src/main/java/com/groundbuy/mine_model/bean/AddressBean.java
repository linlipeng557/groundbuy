package com.groundbuy.mine_model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/18
 */
public class AddressBean implements Serializable {

    /**
     * baseData : {"totalRow":2,"pageNumber":1,"lastPage":true,"firstPage":true,"totalPage":1,"pageSize":10,"list":[{"area":"番禺区","zipCode":"510000","isChoice":1,"address":"厦滘","city":"广州市","mobile":"15902064445","updateTime":null,"userId":1,"province":"广东省","createTime":"2019-06-30 12:16:13","name":"阿佩2","id":2,"status":1},{"area":"番禺区","zipCode":"510000","isChoice":0,"address":"厦滘修改1","city":"广州市","mobile":"15902064445","updateTime":null,"userId":1,"province":"广东省","createTime":"2019-06-30 12:09:29","name":"阿佩","id":1,"status":1}]}
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
         * list : [{"area":"番禺区","zipCode":"510000","isChoice":1,"address":"厦滘","city":"广州市","mobile":"15902064445","updateTime":null,"userId":1,"province":"广东省","createTime":"2019-06-30 12:16:13","name":"阿佩2","id":2,"status":1},{"area":"番禺区","zipCode":"510000","isChoice":0,"address":"厦滘修改1","city":"广州市","mobile":"15902064445","updateTime":null,"userId":1,"province":"广东省","createTime":"2019-06-30 12:09:29","name":"阿佩","id":1,"status":1}]
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

        public static class ListBean implements Serializable{
            /**
             * area : 番禺区
             * zipCode : 510000
             * isChoice : 1
             * address : 厦滘
             * city : 广州市
             * mobile : 15902064445
             * updateTime : null
             * userId : 1
             * province : 广东省
             * createTime : 2019-06-30 12:16:13
             * name : 阿佩2
             * id : 2
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
}
