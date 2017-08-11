package com.leoyou.appleo.bean;

import java.util.List;

/**
 * Created by BoBoZhu on 2017/7/21.
 */

public class QueryBean {


    /**
     * count : 10
     * error : false
     * results : [{"desc":"好甜的《whistle》","ganhuo_id":"56cc6d1d421aa95caa707544","publishedAt":"2015-10-21T02:57:40.914000","readability":"","type":"休息视频","url":"http://video.weibo.com/show?fid=1034:1012bb59b28c2d58e2e9f71968de8c01","who":"lxxself"},{"desc":"街头极限健身Greg Plitt 格雷格普利特励志演讲, Greg Plitt是一传奇人物 ","ganhuo_id":"56cc6d1d421aa95caa707541","publishedAt":"2015-10-22T02:06:07.744000","readability":"","type":"休息视频","url":"http://v.youku.com/v_show/id_XMTM2NDM2MTcxNg","who":"andyiac"},{"desc":"机器人大战！！！","ganhuo_id":"56cc6d1d421aa95caa707640","publishedAt":"2015-07-01T03:59:28.329000","readability":"","type":"休息视频","url":"http://www.bilibili.com/video/av2509456/","who":"代码家"},{"desc":"带你了解冥王星。","ganhuo_id":"56cc6d1d421aa95caa707704","publishedAt":"2015-07-16T03:58:00.509000","readability":"","type":"休息视频","url":"http://www.bilibili.com/video/av2579786/","who":"代码家"},{"desc":"依然震撼：iPhone，一点点改变世界","ganhuo_id":"56cc6d1d421aa95caa7078ae","publishedAt":"2015-09-16T03:34:05.102000","readability":"","type":"休息视频","url":"http://video.sina.com.cn/view/249801254.html","who":"lxxself"},{"desc":"【趣味科普】ZW对你的身体真的好吗？","ganhuo_id":"56cc6d1d421aa95caa7078aa","publishedAt":"2015-09-15T05:06:02.961000","readability":"","type":"休息视频","url":"http://www.acfun.tv/v/ac2199945","who":"lxxself"},{"desc":"谷歌月球XPrize大赛宣传片《重返月球》","ganhuo_id":"56cc6d22421aa95caa707920","publishedAt":"2015-10-13T03:48:04.413000","readability":"","type":"休息视频","url":"http://v.youku.com/v_show/id_XMTM1Njg2NjczMg==.html","who":"lxxself"},{"desc":"看看杜蕾斯是怎么被制造的。","ganhuo_id":"56cc6d23421aa95caa707a2d","publishedAt":"2015-07-15T04:05:29.275000","readability":"","type":"休息视频","url":"http://www.bilibili.com/video/av2566236/","who":"优衣库"},{"desc":"小萝莉跳 Shake it.","ganhuo_id":"56cc6d23421aa95caa707a55","publishedAt":"2015-07-29T03:32:59.580000","readability":"","type":"休息视频","url":"http://www.miaopai.com/show/pK2a83pcIwemm4IuSKEHuA__.htm","who":"代码家"},{"desc":"尼玛，不到最后完全猜不到结局啊！！看完感觉脑子都不够用了～[doge][笑cry]","ganhuo_id":"56cc6d23421aa95caa707aa4","publishedAt":"2016-03-11T12:37:20.004000","readability":"","type":"休息视频","url":"http://video.weibo.com/show?fid=1034:f6f0bc2a1d4f181bde4e8f273546a5b0","who":"LHF"}]
     */

    private int count;
    private boolean error;
    private List<ResultsBean> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

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
         * desc : 好甜的《whistle》
         * ganhuo_id : 56cc6d1d421aa95caa707544
         * publishedAt : 2015-10-21T02:57:40.914000
         * readability :
         * type : 休息视频
         * url : http://video.weibo.com/show?fid=1034:1012bb59b28c2d58e2e9f71968de8c01
         * who : lxxself
         */

        private String desc;
        private String ganhuo_id;
        private String publishedAt;
        private String readability;
        private String type;
        private String url;
        private String who;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getGanhuo_id() {
            return ganhuo_id;
        }

        public void setGanhuo_id(String ganhuo_id) {
            this.ganhuo_id = ganhuo_id;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getReadability() {
            return readability;
        }

        public void setReadability(String readability) {
            this.readability = readability;
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

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
