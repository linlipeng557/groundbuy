package com.groundbuy.mine_model.bean;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/19
 */
public class RevenueListBean {

    /**
     * baseData : {"totalRow":50,"pageNumber":1,"lastPage":false,"firstPage":true,"totalPage":5,"pageSize":10,"list":[{"withdrawalId":null,"orderNumber":"1155839922033266688","money":200,"createTime":"2019-07-29 21:58:21","action":4,"updateTime":null,"id":63,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155839922033266688","money":-408,"createTime":"2019-07-29 21:58:09","action":1,"updateTime":null,"id":62,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155838578895491072","money":200,"createTime":"2019-07-29 21:52:59","action":4,"updateTime":null,"id":59,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155838578895491072","money":-408,"createTime":"2019-07-29 21:52:49","action":1,"updateTime":null,"id":58,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155835135636148224","money":-408,"createTime":"2019-07-29 21:39:09","action":1,"updateTime":null,"id":55,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155833394085629952","money":-408,"createTime":"2019-07-29 21:32:14","action":1,"updateTime":null,"id":53,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155832279411593216","money":50,"createTime":"2019-07-29 21:29:04","action":5,"updateTime":null,"id":52,"type":1,"userId":1}]}
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
         * totalRow : 50
         * pageNumber : 1
         * lastPage : false
         * firstPage : true
         * totalPage : 5
         * pageSize : 10
         * list : [{"withdrawalId":null,"orderNumber":"1155839922033266688","money":200,"createTime":"2019-07-29 21:58:21","action":4,"updateTime":null,"id":63,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155839922033266688","money":-408,"createTime":"2019-07-29 21:58:09","action":1,"updateTime":null,"id":62,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155838578895491072","money":200,"createTime":"2019-07-29 21:52:59","action":4,"updateTime":null,"id":59,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155838578895491072","money":-408,"createTime":"2019-07-29 21:52:49","action":1,"updateTime":null,"id":58,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155835135636148224","money":-408,"createTime":"2019-07-29 21:39:09","action":1,"updateTime":null,"id":55,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155833394085629952","money":-408,"createTime":"2019-07-29 21:32:14","action":1,"updateTime":null,"id":53,"type":1,"userId":1},{"withdrawalId":null,"orderNumber":"1155832279411593216","money":50,"createTime":"2019-07-29 21:29:04","action":5,"updateTime":null,"id":52,"type":1,"userId":1}]
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
             * withdrawalId : null
             * orderNumber : 1155839922033266688
             * money : 200
             * createTime : 2019-07-29 21:58:21
             * action : 4
             * updateTime : null
             * id : 63
             * type : 1
             * userId : 1
             */

            private Object withdrawalId;
            private String orderNumber;
            private int money;
            private String createTime;
            private int action;
            private Object updateTime;
            private int id;
            private int type;
            private int userId;

            public Object getWithdrawalId() {
                return withdrawalId;
            }

            public void setWithdrawalId(Object withdrawalId) {
                this.withdrawalId = withdrawalId;
            }

            public String getOrderNumber() {
                return orderNumber;
            }

            public void setOrderNumber(String orderNumber) {
                this.orderNumber = orderNumber;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getAction() {
                return action;
            }

            public void setAction(int action) {
                this.action = action;
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

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}
