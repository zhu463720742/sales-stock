package com.lichao.salesstock.system.model;


import com.lichao.salesstock.comm.model.BaseEntity;

import java.util.Date;

public class Dict extends BaseEntity<Long> {

    private static final long serialVersionUID = -2431140186410912787L;
    private String type;
    private String k;
    private String val;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public static class TokenModel extends BaseEntity<String> {

        private static final long serialVersionUID = 4566334160572911795L;

        /**
         * 过期时间
         */
        private Date expireTime;
        /**
         * LoginUser的json串
         */
        private String val;

        public Date getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(Date expireTime) {
            this.expireTime = expireTime;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

    }
}