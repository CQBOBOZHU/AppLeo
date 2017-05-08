package com.leoyou.appleo.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */

public class BookBean {


    /**
     * count : 1
     * start : 1
     * total : 200
     * books : [{"rating":{"max":10,"numRaters":102990,"average":"9.2","min":0},"subtitle":"","author":["[哥伦比亚] 加西亚·马尔克斯"],"pubdate":"2011-6","tags":[{"count":35085,"name":"百年孤独","title":"百年孤独"},{"count":30545,"name":"加西亚·马尔克斯","title":"加西亚·马尔克斯"},{"count":18445,"name":"经典","title":"经典"},{"count":17177,"name":"拉美文学","title":"拉美文学"},{"count":16670,"name":"小说","title":"小说"},{"count":15812,"name":"外国文学","title":"外国文学"},{"count":9977,"name":"文学","title":"文学"},{"count":7093,"name":"魔幻现实主义","title":"魔幻现实主义"}],"origin_title":"Cien años de soledad","image":"https://img3.doubanio.com/mpic/s6384944.jpg","binding":"精装","translator":["范晔"],"catalog":"","pages":"360","images":{"small":"https://img3.doubanio.com/spic/s6384944.jpg","large":"https://img3.doubanio.com/lpic/s6384944.jpg","medium":"https://img3.doubanio.com/mpic/s6384944.jpg"},"alt":"https://book.douban.com/subject/6082808/","id":"6082808","publisher":"南海出版公司","isbn10":"7544253996","isbn13":"9787544253994","title":"百年孤独","url":"https://api.douban.com/v2/book/6082808","alt_title":"Cien años de soledad","author_intro":"加西亚\u2022马尔克斯（Gabriel García Márquez）1927年出生于哥伦比亚马格达莱纳海滨小镇阿拉卡塔卡。童年与外祖父母一起生活。1936年随父母迁居苏克雷。1947年考入波哥大国立大学。1948年因内战辍学，进入报界。五十年代开始发表文学作品。六十年代初移居墨西哥。1967年出版《百年孤独》。1982年获诺贝尔文学奖。","summary":"《百年孤独》是魔幻现实主义文学的代表作，描写了布恩迪亚家族七代人的传奇故事，以及加勒比海沿岸小镇马孔多的百年兴衰，反映了拉丁美洲一个世纪以来风云变幻的历史。作品融入神话传说、民间故事、宗教典故等神秘因素，巧妙地糅合了现实与虚幻，展现出一个瑰丽的想象世界，成为20世纪最重要的经典文学巨著之一。1982年加西亚\u2022马尔克斯获得诺贝尔文学奖，奠定世界级文学大师的地位，很大程度上乃是凭借《百年孤独》的巨大影响。","series":{"id":"10489","title":"新经典文库:加西亚·马尔克斯作品"},"price":"39.50元"}]
     */

    private int count;
    private int start;
    private int total;
    private List<BooksBean> books;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public static class BooksBean {
        /**
         * rating : {"max":10,"numRaters":102990,"average":"9.2","min":0}
         * subtitle :
         * author : ["[哥伦比亚] 加西亚·马尔克斯"]
         * pubdate : 2011-6
         * tags : [{"count":35085,"name":"百年孤独","title":"百年孤独"},{"count":30545,"name":"加西亚·马尔克斯","title":"加西亚·马尔克斯"},{"count":18445,"name":"经典","title":"经典"},{"count":17177,"name":"拉美文学","title":"拉美文学"},{"count":16670,"name":"小说","title":"小说"},{"count":15812,"name":"外国文学","title":"外国文学"},{"count":9977,"name":"文学","title":"文学"},{"count":7093,"name":"魔幻现实主义","title":"魔幻现实主义"}]
         * origin_title : Cien años de soledad
         * image : https://img3.doubanio.com/mpic/s6384944.jpg
         * binding : 精装
         * translator : ["范晔"]
         * catalog :
         * pages : 360
         * images : {"small":"https://img3.doubanio.com/spic/s6384944.jpg","large":"https://img3.doubanio.com/lpic/s6384944.jpg","medium":"https://img3.doubanio.com/mpic/s6384944.jpg"}
         * alt : https://book.douban.com/subject/6082808/
         * id : 6082808
         * publisher : 南海出版公司
         * isbn10 : 7544253996
         * isbn13 : 9787544253994
         * title : 百年孤独
         * url : https://api.douban.com/v2/book/6082808
         * alt_title : Cien años de soledad
         * author_intro : 加西亚•马尔克斯（Gabriel García Márquez）1927年出生于哥伦比亚马格达莱纳海滨小镇阿拉卡塔卡。童年与外祖父母一起生活。1936年随父母迁居苏克雷。1947年考入波哥大国立大学。1948年因内战辍学，进入报界。五十年代开始发表文学作品。六十年代初移居墨西哥。1967年出版《百年孤独》。1982年获诺贝尔文学奖。
         * summary : 《百年孤独》是魔幻现实主义文学的代表作，描写了布恩迪亚家族七代人的传奇故事，以及加勒比海沿岸小镇马孔多的百年兴衰，反映了拉丁美洲一个世纪以来风云变幻的历史。作品融入神话传说、民间故事、宗教典故等神秘因素，巧妙地糅合了现实与虚幻，展现出一个瑰丽的想象世界，成为20世纪最重要的经典文学巨著之一。1982年加西亚•马尔克斯获得诺贝尔文学奖，奠定世界级文学大师的地位，很大程度上乃是凭借《百年孤独》的巨大影响。
         * series : {"id":"10489","title":"新经典文库:加西亚·马尔克斯作品"}
         * price : 39.50元
         */

        private RatingBean rating;
        private String subtitle;
        private String pubdate;
        private String origin_title;
        private String image;
        private String binding;
        private String catalog;
        private String pages;
        private ImagesBean images;
        private String alt;
        private String id;
        private String publisher;
        private String isbn10;
        private String isbn13;
        private String title;
        private String url;
        private String alt_title;
        private String author_intro;
        private String summary;
        private SeriesBean series;
        private String price;
        private List<String> author;
        private List<TagsBean> tags;
        private List<String> translator;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getOrigin_title() {
            return origin_title;
        }

        public void setOrigin_title(String origin_title) {
            this.origin_title = origin_title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBinding() {
            return binding;
        }

        public void setBinding(String binding) {
            this.binding = binding;
        }

        public String getCatalog() {
            return catalog;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getIsbn10() {
            return isbn10;
        }

        public void setIsbn10(String isbn10) {
            this.isbn10 = isbn10;
        }

        public String getIsbn13() {
            return isbn13;
        }

        public void setIsbn13(String isbn13) {
            this.isbn13 = isbn13;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAlt_title() {
            return alt_title;
        }

        public void setAlt_title(String alt_title) {
            this.alt_title = alt_title;
        }

        public String getAuthor_intro() {
            return author_intro;
        }

        public void setAuthor_intro(String author_intro) {
            this.author_intro = author_intro;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public SeriesBean getSeries() {
            return series;
        }

        public void setSeries(SeriesBean series) {
            this.series = series;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<String> getTranslator() {
            return translator;
        }

        public void setTranslator(List<String> translator) {
            this.translator = translator;
        }

        public static class RatingBean {
            /**
             * max : 10
             * numRaters : 102990
             * average : 9.2
             * min : 0
             */

            private int max;
            private int numRaters;
            private String average;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getNumRaters() {
                return numRaters;
            }

            public void setNumRaters(int numRaters) {
                this.numRaters = numRaters;
            }

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
                this.average = average;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/spic/s6384944.jpg
             * large : https://img3.doubanio.com/lpic/s6384944.jpg
             * medium : https://img3.doubanio.com/mpic/s6384944.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class SeriesBean {
            /**
             * id : 10489
             * title : 新经典文库:加西亚·马尔克斯作品
             */

            private String id;
            private String title;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class TagsBean {
            /**
             * count : 35085
             * name : 百年孤独
             * title : 百年孤独
             */

            private int count;
            private String name;
            private String title;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
