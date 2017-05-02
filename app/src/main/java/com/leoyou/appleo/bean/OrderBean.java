package com.leoyou.appleo.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */

public class OrderBean {
    String MSG;
    String RESULT;

    Paginator Paginator;
    List<DATA> DATA;

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public OrderBean.Paginator getPaginator() {
        return Paginator;
    }

    public void setPaginator(OrderBean.Paginator paginator) {
        Paginator = paginator;
    }

    public List<OrderBean.DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<OrderBean.DATA> DATA) {
        this.DATA = DATA;
    }

    class  DATA{
        /**
         * recordCount : 1
         * record : [{"amount":0.11,"commodityImg":"/yun_rui_source/commodity/23/1488535337771.jpg","releaseId":23,"specName":"同","isReturn":"0","orderCommodityId":133,"quantity":1,"modeName":"咯嘛","commodityName":"今年","commodityId":34,"isEvaluate":"0"}]
         * createTime : 2017-03-04 10:38:18
         * orderCode : 293221488595098640
         * shopName : 做梦
         * sellerId : 23
         * totalAmount : 0.11
         * orderStatus : 0
         * orderId : 95
         */

        private int recordCount;
        private String createTime;
        private String orderCode;
        private String shopName;
        private String sellerId;
        private double totalAmount;
        private String orderStatus;
        private int orderId;
        private List<RecordBean> record;


        public int getRecordCount() {
            return recordCount;
        }

        public void setRecordCount(int recordCount) {
            this.recordCount = recordCount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getSellerId() {
            return sellerId;
        }

        public void setSellerId(String sellerId) {
            this.sellerId = sellerId;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public List<RecordBean> getRecord() {
            return record;
        }

        public void setRecord(List<RecordBean> record) {
            this.record = record;
        }


        public  class RecordBean {
            /**
             * amount : 0.11
             * commodityImg : /yun_rui_source/commodity/23/1488535337771.jpg
             * releaseId : 23
             * specName : 同
             * isReturn : 0
             * orderCommodityId : 133
             * quantity : 1
             * modeName : 咯嘛
             * commodityName : 今年
             * commodityId : 34
             * isEvaluate : 0
             */

            private double amount;
            private String commodityImg;
            private int releaseId;
            private String specName;
            private String isReturn;
            private int orderCommodityId;
            private int quantity;
            private String modeName;
            private String commodityName;
            private int commodityId;
            private String isEvaluate;

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public String getCommodityImg() {
                return commodityImg;
            }

            public void setCommodityImg(String commodityImg) {
                this.commodityImg = commodityImg;
            }

            public int getReleaseId() {
                return releaseId;
            }

            public void setReleaseId(int releaseId) {
                this.releaseId = releaseId;
            }

            public String getSpecName() {
                return specName;
            }

            public void setSpecName(String specName) {
                this.specName = specName;
            }

            public String getIsReturn() {
                return isReturn;
            }

            public void setIsReturn(String isReturn) {
                this.isReturn = isReturn;
            }

            public int getOrderCommodityId() {
                return orderCommodityId;
            }

            public void setOrderCommodityId(int orderCommodityId) {
                this.orderCommodityId = orderCommodityId;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public String getModeName() {
                return modeName;
            }

            public void setModeName(String modeName) {
                this.modeName = modeName;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getIsEvaluate() {
                return isEvaluate;
            }

            public void setIsEvaluate(String isEvaluate) {
                this.isEvaluate = isEvaluate;
            }
        }
    }

    class   Paginator{
        /**
         * limit : 10
         * page : 1
         * totalCount : 2
         * hasNextPage : false
         * startRow : 1
         * endRow : 2
         * totalPages : 1
         * slider : [1]
         * firstPage : true
         * lastPage : true
         * prePage : 1
         * nextPage : 1
         * hasPrePage : false
         * offset : 0
         */

        private int limit;
        private int page;
        private int totalCount;
        private boolean hasNextPage;
        private int startRow;
        private int endRow;
        private int totalPages;
        private boolean firstPage;
        private boolean lastPage;
        private int prePage;
        private int nextPage;
        private boolean hasPrePage;
        private int offset;
        private List<Integer> slider;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public boolean isFirstPage() {
            return firstPage;
        }

        public void setFirstPage(boolean firstPage) {
            this.firstPage = firstPage;
        }

        public boolean isLastPage() {
            return lastPage;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isHasPrePage() {
            return hasPrePage;
        }

        public void setHasPrePage(boolean hasPrePage) {
            this.hasPrePage = hasPrePage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public List<Integer> getSlider() {
            return slider;
        }

        public void setSlider(List<Integer> slider) {
            this.slider = slider;
        }
    }

}
