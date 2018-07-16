
package com.potato.wahidsadique.androiddumbstructure.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Source {

    @SerializedName("category")
    private String mCategory;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("id")
    private String mId;
    @SerializedName("language")
    private String mLanguage;
    @SerializedName("name")
    private String mName;
    @SerializedName("sortBysAvailable")
    private List<String> mSortBysAvailable;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("urlsToLogos")
    private UrlsToLogos mUrlsToLogos;

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<String> getSortBysAvailable() {
        return mSortBysAvailable;
    }

    public void setSortBysAvailable(List<String> sortBysAvailable) {
        mSortBysAvailable = sortBysAvailable;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public UrlsToLogos getUrlsToLogos() {
        return mUrlsToLogos;
    }

    public void setUrlsToLogos(UrlsToLogos urlsToLogos) {
        mUrlsToLogos = urlsToLogos;
    }

}
