package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MatchData() : Parcelable {

    @SerializedName("emb2_match")
    @Expose
    var emb2Match: Boolean? = null

    @SerializedName("emb0_score")
    @Expose
    var emb0Score: Double? = null

    @SerializedName("emb2_score")
    @Expose
    var emb2Score: Double? = null

    @SerializedName("emb1_score")
    @Expose
    var emb1Score: Double? = null

    @SerializedName("emb1_match")
    @Expose
    var emb1Match: Boolean? = null

    @SerializedName("emb0_match")
    @Expose
    var emb0Match: Boolean? = null

    constructor(parcel: Parcel) : this() {
        emb2Match = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        emb0Score = parcel.readValue(Double::class.java.classLoader) as? Double
        emb2Score = parcel.readValue(Double::class.java.classLoader) as? Double
        emb1Score = parcel.readValue(Double::class.java.classLoader) as? Double
        emb1Match = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        emb0Match = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(emb2Match)
        parcel.writeValue(emb0Score)
        parcel.writeValue(emb2Score)
        parcel.writeValue(emb1Score)
        parcel.writeValue(emb1Match)
        parcel.writeValue(emb0Match)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MatchData> {
        override fun createFromParcel(parcel: Parcel): MatchData {
            return MatchData(parcel)
        }

        override fun newArray(size: Int): Array<MatchData?> {
            return arrayOfNulls(size)
        }
    }

}