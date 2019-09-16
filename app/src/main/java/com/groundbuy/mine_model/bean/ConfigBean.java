package com.groundbuy.mine_model.bean;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/11
 */
public class ConfigBean {

    /**
     * baseData : {"remark":"注册协议","id":1,"value":0,"key":"info.agreement","content":"注册协议"}
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
         * remark : 注册协议
         * id : 1
         * value : 0
         * key : info.agreement
         * content : 注册协议
         */

        private String remark;
        private int id;
        private int value;
        private String key;
        private String content;

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
