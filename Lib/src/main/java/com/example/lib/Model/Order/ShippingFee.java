package com.example.lib.Model.Order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingFee {
    public class Data {

        @SerializedName("total")
        @Expose
        private Integer total;
        @SerializedName("service_fee")
        @Expose
        private Integer serviceFee;
        @SerializedName("insurance_fee")
        @Expose
        private Integer insuranceFee;
        @SerializedName("pick_station_fee")
        @Expose
        private Integer pickStationFee;
        @SerializedName("coupon_value")
        @Expose
        private Integer couponValue;
        @SerializedName("r2s_fee")
        @Expose
        private Integer r2sFee;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getServiceFee() {
            return serviceFee;
        }

        public void setServiceFee(Integer serviceFee) {
            this.serviceFee = serviceFee;
        }

        public Integer getInsuranceFee() {
            return insuranceFee;
        }

        public void setInsuranceFee(Integer insuranceFee) {
            this.insuranceFee = insuranceFee;
        }

        public Integer getPickStationFee() {
            return pickStationFee;
        }

        public void setPickStationFee(Integer pickStationFee) {
            this.pickStationFee = pickStationFee;
        }

        public Integer getCouponValue() {
            return couponValue;
        }

        public void setCouponValue(Integer couponValue) {
            this.couponValue = couponValue;
        }

        public Integer getR2sFee() {
            return r2sFee;
        }

        public void setR2sFee(Integer r2sFee) {
            this.r2sFee = r2sFee;
        }
    }
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
