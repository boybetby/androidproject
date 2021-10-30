package com.example.lib.Model.GHNapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Province {
    public class Datum {

        @SerializedName("ProvinceID")
        @Expose
        private Integer provinceID;
        @SerializedName("ProvinceName")
        @Expose
        private String provinceName;
        @SerializedName("CountryID")
        @Expose
        private Integer countryID;
        @SerializedName("Code")
        @Expose
        private String code;
        @SerializedName("NameExtension")
        @Expose
        private List<String> nameExtension = null;
        @SerializedName("IsEnable")
        @Expose
        private Integer isEnable;
        @SerializedName("RegionID")
        @Expose
        private Integer regionID;
        @SerializedName("UpdatedBy")
        @Expose
        private Integer updatedBy;
        @SerializedName("CreatedAt")
        @Expose
        private String createdAt;
        @SerializedName("UpdatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("CanUpdateCOD")
        @Expose
        private Boolean canUpdateCOD;
        @SerializedName("Status")
        @Expose
        private Integer status;
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

        public Integer getProvinceID() {
            return provinceID;
        }

        public void setProvinceID(Integer provinceID) {
            this.provinceID = provinceID;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public Integer getCountryID() {
            return countryID;
        }

        public void setCountryID(Integer countryID) {
            this.countryID = countryID;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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

        public Integer getRegionID() {
            return regionID;
        }

        public void setRegionID(Integer regionID) {
            this.regionID = regionID;
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

}
