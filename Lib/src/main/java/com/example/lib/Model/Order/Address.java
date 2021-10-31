package com.example.lib.Model.Order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Address {
    public class Datum {
        @SerializedName("latitude")
        @Expose
        private Double latitude;
        @SerializedName("longitude")
        @Expose
        private Double longitude;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("distance")
        @Expose
        private Double distance;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("number")
        @Expose
        private Object number;
        @SerializedName("postal_code")
        @Expose
        private Object postalCode;
        @SerializedName("street")
        @Expose
        private Object street;
        @SerializedName("confidence")
        @Expose
        private Double confidence;
        @SerializedName("region")
        @Expose
        private String region;
        @SerializedName("region_code")
        @Expose
        private String regionCode;
        @SerializedName("county")
        @Expose
        private String county;
        @SerializedName("locality")
        @Expose
        private Object locality;
        @SerializedName("administrative_area")
        @Expose
        private Object administrativeArea;
        @SerializedName("neighbourhood")
        @Expose
        private Object neighbourhood;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("country_code")
        @Expose
        private String countryCode;
        @SerializedName("continent")
        @Expose
        private String continent;
        @SerializedName("label")
        @Expose
        private String label;

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Double getDistance() {
            return distance;
        }

        public void setDistance(Double distance) {
            this.distance = distance;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public Object getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(Object postalCode) {
            this.postalCode = postalCode;
        }

        public Object getStreet() {
            return street;
        }

        public void setStreet(Object street) {
            this.street = street;
        }

        public Double getConfidence() {
            return confidence;
        }

        public void setConfidence(Double confidence) {
            this.confidence = confidence;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getRegionCode() {
            return regionCode;
        }

        public void setRegionCode(String regionCode) {
            this.regionCode = regionCode;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public Object getLocality() {
            return locality;
        }

        public void setLocality(Object locality) {
            this.locality = locality;
        }

        public Object getAdministrativeArea() {
            return administrativeArea;
        }

        public void setAdministrativeArea(Object administrativeArea) {
            this.administrativeArea = administrativeArea;
        }

        public Object getNeighbourhood() {
            return neighbourhood;
        }

        public void setNeighbourhood(Object neighbourhood) {
            this.neighbourhood = neighbourhood;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getContinent() {
            return continent;
        }

        public void setContinent(String continent) {
            this.continent = continent;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

    }

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }


}
