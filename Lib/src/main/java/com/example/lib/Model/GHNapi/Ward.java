package com.example.lib.Model.GHNapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ward {
    public class Datum {

        @SerializedName("WardCode")
        @Expose
        private String wardCode;
        @SerializedName("DistrictID")
        @Expose
        private Integer districtID;
        @SerializedName("WardName")
        @Expose
        private String wardName;
        @SerializedName("NameExtension")
        @Expose
        private List<String> nameExtension = null;
        @SerializedName("IsEnable")
        @Expose
        private Integer isEnable;
        @SerializedName("CanUpdateCOD")
        @Expose
        private Boolean canUpdateCOD;
        @SerializedName("UpdatedBy")
        @Expose
        private Integer updatedBy;
        @SerializedName("CreatedAt")
        @Expose
        private String createdAt;
        @SerializedName("UpdatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("SupportType")
        @Expose
        private Integer supportType;
        @SerializedName("WhiteListClient")
        @Expose
        private WhiteListClient whiteListClient;
        @SerializedName("WhiteListWard")
        @Expose
        private WhiteListWard whiteListWard;
        @SerializedName("Status")
        @Expose
        private Integer status;

        public String getWardCode() {
            return wardCode;
        }

        public void setWardCode(String wardCode) {
            this.wardCode = wardCode;
        }

        public Integer getDistrictID() {
            return districtID;
        }

        public void setDistrictID(Integer districtID) {
            this.districtID = districtID;
        }

        public String getWardName() {
            return wardName;
        }

        public void setWardName(String wardName) {
            this.wardName = wardName;
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

        public Integer getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(Integer updatedBy) {
            this.updatedBy = updatedBy;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getSupportType() {
            return supportType;
        }

        public void setSupportType(Integer supportType) {
            this.supportType = supportType;
        }

        public WhiteListClient getWhiteListClient() {
            return whiteListClient;
        }

        public void setWhiteListClient(WhiteListClient whiteListClient) {
            this.whiteListClient = whiteListClient;
        }

        public WhiteListWard getWhiteListWard() {
            return whiteListWard;
        }

        public void setWhiteListWard(WhiteListWard whiteListWard) {
            this.whiteListWard = whiteListWard;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
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

    public class WhiteListWard {

        @SerializedName("From")
        @Expose
        private Object from;
        @SerializedName("To")
        @Expose
        private Object to;

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

    }
}
