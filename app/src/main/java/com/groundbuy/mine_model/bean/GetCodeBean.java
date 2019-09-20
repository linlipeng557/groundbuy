package com.groundbuy.mine_model.bean;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/11
 */
public class GetCodeBean {

    /**
     * baseData : {"mobile":"13794326922","uuid":"5650e0aeced141399a3179784d96898e"}
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
         * mobile : 13794326922
         * uuid : 5650e0aeced141399a3179784d96898e
         */

        private String mobile;
        private String uuid;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }
}
