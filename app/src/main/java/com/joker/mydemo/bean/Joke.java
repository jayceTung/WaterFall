package com.joker.mydemo.bean;

import java.util.List;

/**
 * Created by Joker on 2015/11/27.
 */
public class Joke {

    private List<DetailEntity> detail;
    private String desc;
    private String status;

    public void setDetail(List<DetailEntity> detail) {
        this.detail = detail;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DetailEntity> getDetail() {
        return detail;
    }

    public String getDesc() {
        return desc;
    }

    public String getStatus() {
        return status;
    }

    public class DetailEntity {
        /**
         * content : 刚看到一个反作弄骗子的，我也想起了朋友说过一个，说有个骗子打电话说是小学同学，结果我朋友就说，哎你是那XX小学的YYY吧！我一听声音就知道！哎你怎么知道我现在需要找人借钱啊！以前你挺有钱的呀，富二代，这是你电话吧？我给你发卡号你先借我五万块两个月之后还！然后骗子挂电话了，可能哭去了…哈哈。
         * id : 34023
         * author : 哈哈哈你妹啊
         * picUrl :
         * status : 1
         * xhid : 34023
         */
        private String content;
        private int id;
        private String author;
        private String picUrl;
        private String status;
        private int xhid;

        public void setContent(String content) {
            this.content = content;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setXhid(int xhid) {
            this.xhid = xhid;
        }

        public String getContent() {
            return content;
        }

        public int getId() {
            return id;
        }

        public String getAuthor() {
            return author;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public String getStatus() {
            return status;
        }

        public int getXhid() {
            return xhid;
        }
    }
}
