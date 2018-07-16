
package com.potato.wahidsadique.androiddumbstructure.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Sources {

    @SerializedName("sources")
    private List<Source> mSources;
    @SerializedName("status")
    private String mStatus;

    public List<Source> getSources() {
        return mSources;
    }

    public void setSources(List<Source> sources) {
        mSources = sources;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
