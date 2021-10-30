package com.example.lib.Model.GHNapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class District {
    public class Datum {

        @SerializedName("DistrictID")
        @Expose
        private Integer districtID;
        @SerializedName("ProvinceID")
        @Expose
        private Integer provinceID;
        @SerializedName("DistrictName")
        @Expose
        private String districtName;
        @SerializedName("Code")
        @Expose
        private String code;
        @SerializedName("Type")
        @Expose
        private Integer type;
        @SerializedName("SupportType")
        @Expose
        private Integer supportType;
        @SerializedName("NameExtension")
        @Expose
        private List<String> nameExtension = null;
        @SerializedName("IsEnable")
        @Expose
        private Integer isEnable;
        @SerializedName("CanUpdateCOD")
        @Expose
        private Boolean canUpdateCOD;
        @SerializedName("Status")
        @Expose
        private Integer status;
        @SerializedName("WhiteListClient")
        @Expose
        private WhiteListClient whiteListClient;
        @SerializedName("WhiteListDistrict")
        @Expose
        private WhiteListDistrict whiteListDistrict;
        @SerializedName("CreatedIP")
        @Expose
        private String createdIP;
        @SerializedName("CreatedEmployee")
        @Expose
        private Integer createdEmployee;
        @SerializedName("CreatedSource")
        @Expose
        private String createdSource;
        @SerializedName("CreatedDate")
        @Expose
        private String createdDate;
        @SerializedName("UpdatedIP")
        @Expose
        private String updatedIP;
        @SerializedName("UpdatedEmployee")
        @Expose
        private Integer updatedEmployee;
        @SerializedName("UpdatedSource")
        @Expose
        private String updatedSource;
        @SerializedName("UpdatedDate")
        @Expose
        private String updatedDate;

        public Integer getDistrictID() {
            return districtID;
        }

        public void setDistrictID(Integer districtID) {
            this.districtID = districtID;
        }

        public Integer getProvinceID() {
            return provinceID;
        }

        public void setProvinceID(Integer provinceID) {
            this.provinceID = provinceID;
        }

        public String getDistrictName() {
            return districtName;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getSupportType() {
            return supportType;
        }

        public void setSupportType(Integer supportType) {
            this.supportType = supportType;
        }

        public List<String> getNameExtension() {
            return nameExtension;
        }

        public void setNameExtension(List<String> nameExtension) {
            this.nameExtension = nameExtension;
        }

        public Integer getIsEnable() {
            return isEnable;
        }

        public void setIsEnable(Integer isEnable) {
            this.isEnable = isEnable;
        }

        public Boolean getCanUpdateCOD() {
            return canUpdateCOD;
        }

        public void setCanUpdateCOD(Boolean canUpdateCOD) {
            this.canUpdateCOD = canUpdateCOD;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public WhiteListClient getWhiteListClient() {
            return whiteListClient;
        }

        public void setWhiteListClient(WhiteListClient whiteListClient) {
            this.whiteListClient = whiteListClient;
        }

        public WhiteListDistrict getWhiteListDistrict() {
            return whiteListDistrict;
        }

        public void setWhiteListDistrict(WhiteListDistrict whiteListDistrict) {
            this.whiteListDistrict = whiteListDistrict;
        }

        public String getCreatedIP() {
            return createdIP;
        }

        public void setCreatedIP(String createdIP) {
            this.createdIP = createdIP;
        }

        public Integer getCreatedEmployee() {
            return createdEmployee;
        }

        public void setCreatedEmployee(Integer createdEmployee) {
            this.createdEmployee = createdEmployee;
        }

        public String getCreatedSource() {
            return createdSource;
        }

        public void setCreatedSource(String createdSource) {
            this.createdSource = createdSource;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getUpdatedIP() {
            return updatedIP;
        }

        public void setUpdatedIP(String updatedIP) {
            this.updatedIP = updatedIP;
        }

        public Integer getUpdatedEmployee() {
            return updatedEmployee;
        }

        public void setUpdatedEmployee(Integer updatedEmployee) {
            this.updatedEmployee = updatedEmployee;
        }

        public String getUpdatedSource() {
            return updatedSource;
        }

        public void setUpdatedSource(String updatedSource) {
            this.updatedSource = updatedSource;
        }

        public String getUpdatedDate() {
            return updatedDate;
        }

        public void setUpdatedDate(String updatedDate) {
            this.updatedDate = updatedDate;
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
    private List<Datum> data = null;

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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class WhiteListClient {

        @SerializedName("From")
        @Expose
        private Object from;
        @SerializedName("To")
        @Expose
        private Object to;
        @SerializedName("Return")
        @Expose
        private Object _return;

        public Object getFrom() {
            return from;
        }

        public void setFrom(Object from) {
            this.from = from;
        }

        public Object getTo() {
            return to;
        }

        public void setTo(Object to) {
            this.to = to;
        }

        public Object getReturn() {
            return _return;
        }

        public void setReturn(Object _return) {
            this._return = _return;
        }

    }
    public class WhiteListDistrict {

        @SerializedName("From")
        @Expose
        private List<Integer> from = null;
        @SerializedName("To")
        @Expose
        private List<Integer> to = null;

        public List<Integer> getFrom() {
            return from;
        }

        public void setFrom(List<Integer> from) {
            this.from = from;
        }

        public List<Integer> getTo() {
            return to;
        }

        public void setTo(List<Integer> to) {
            this.to = to;
        }

    }
}
