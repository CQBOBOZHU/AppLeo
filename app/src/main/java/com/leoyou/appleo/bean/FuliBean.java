package com.leoyou.appleo.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */

public class FuliBean {


    /**
     * error : false
     * results : [{"_id":"59029242421aa9544ed889ff","createdAt":"2017-04-28T08:52:18.878Z","desc":"4-28","publishedAt":"2017-04-28T11:49:38.12Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-28-18094719_120129648541065_8356500748640452608_n.jpg","used":true,"who":"daimajia"},{"_id":"59013b1a421aa9544b774088","createdAt":"2017-04-27T08:28:10.755Z","desc":"4-27","publishedAt":"2017-04-27T13:16:46.955Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-27-17934080_117414798808566_8957027985114791936_n.jpg?imageslim","used":true,"who":"daimajia"},{"_id":"58ffe1b5421aa9544ed889e6","createdAt":"2017-04-26T07:54:29.874Z","desc":"4-26","publishedAt":"2017-04-26T11:30:43.767Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-25-13651793_897557617014845_571817176_n.jpg","used":true,"who":"daimajia"},{"_id":"58fe8e05421aa9544b77406d","createdAt":"2017-04-25T07:45:09.55Z","desc":"4-25","publishedAt":"2017-04-25T13:11:39.357Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-24-18013547_1532023163498554_215541963087151104_n.jpg","used":true,"who":"dmj"},{"_id":"58fd4b4a421aa9544825f8f7","createdAt":"2017-04-24T08:48:10.92Z","desc":"4-24","publishedAt":"2017-04-24T11:35:03.680Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-24-18094714_158946097967074_5909424912493182976_n.jpg","used":true,"who":"dmj"},{"_id":"58f95b74421aa954511ebedf","createdAt":"2017-04-21T09:08:04.293Z","desc":"4-21","publishedAt":"2017-04-21T11:30:29.323Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-21-18013964_1389732981073150_4044061109068496896_n.jpg","used":true,"who":"daimajia"},{"_id":"58f8043e421aa9544ed88993","createdAt":"2017-04-20T08:43:42.333Z","desc":"4-20","publishedAt":"2017-04-20T14:03:06.490Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-20-17932350_1238028809599424_2089669844847820800_n.jpg","used":true,"who":"daimajia"},{"_id":"58f6baad421aa954511ebec3","createdAt":"2017-04-19T09:17:33.987Z","desc":"4-19","publishedAt":"2017-04-19T11:44:51.925Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-19-17881407_1845958195665029_1132383288824954880_n.jpg","used":true,"who":"daimajia"},{"_id":"58f5649b421aa9544825f89f","createdAt":"2017-04-18T08:58:03.511Z","desc":"4-18","publishedAt":"2017-04-18T11:34:29.203Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-18-17882540_190116561497334_440657494176432128_n.jpg","used":true,"who":"带马甲"},{"_id":"58f3980c421aa9544b773ff1","createdAt":"2017-04-17T00:13:00.136Z","desc":"4-17","publishedAt":"2017-04-17T11:32:14.674Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-16-17934400_1738549946443321_2924146161843437568_n.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 59029242421aa9544ed889ff
         * createdAt : 2017-04-28T08:52:18.878Z
         * desc : 4-28
         * publishedAt : 2017-04-28T11:49:38.12Z
         * source : chrome
         * type : 福利
         * url : http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-28-18094719_120129648541065_8356500748640452608_n.jpg
         * used : true
         * who : daimajia
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
