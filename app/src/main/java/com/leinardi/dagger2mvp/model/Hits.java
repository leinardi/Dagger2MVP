
package com.leinardi.dagger2mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Hits implements Parcelable {

    @SerializedName("totalHits")
    @Expose
    private int totalHits;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = new ArrayList<Hit>();
    @SerializedName("total")
    @Expose
    private int total;

    /**
     * @return The totalHits
     */
    public int getTotalHits() {
        return totalHits;
    }

    /**
     * @param totalHits The totalHits
     */
    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public Hits withTotalHits(int totalHits) {
        this.totalHits = totalHits;
        return this;
    }

    /**
     * @return The hits
     */
    public List<Hit> getHits() {
        return hits;
    }

    /**
     * @param hits The hits
     */
    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    public Hits withHits(List<Hit> hits) {
        this.hits = hits;
        return this;
    }

    /**
     * @return The total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    public Hits withTotal(int total) {
        this.total = total;
        return this;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.totalHits);
        dest.writeTypedList(this.hits);
        dest.writeInt(this.total);
    }

    public Hits() {
    }

    protected Hits(Parcel in) {
        this.totalHits = in.readInt();
        this.hits = in.createTypedArrayList(Hit.CREATOR);
        this.total = in.readInt();
    }

    public static final Parcelable.Creator<Hits> CREATOR = new Parcelable.Creator<Hits>() {
        @Override
        public Hits createFromParcel(Parcel source) {
            return new Hits(source);
        }

        @Override
        public Hits[] newArray(int size) {
            return new Hits[size];
        }
    };
}
