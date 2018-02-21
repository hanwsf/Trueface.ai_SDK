package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MatchData() : Parcelable {

    @SerializedName("emb2_match")
    @Expose
    var isEmb2Match: Boolean = false

    @SerializedName("emb0_score")
    @Expose
    var emb0Score: Double = 0.toDouble()

    @SerializedName("emb2_score")
    @Expose
    var emb2Score: Double = 0.toDouble()

    @SerializedName("emb1_score")
    @Expose
    var emb1Score: Double = 0.toDouble()

    @SerializedName("emb1_match")
    @Expose
    var isEmb1Match: Boolean = false

    @SerializedName("emb0_match")
    @Expose
    var isEmb0Match: Boolean = false

    constructor(parcel: Parcel) : this() {
        isEmb2Match = parcel.readByte() != 0.toByte()
        emb0Score = parcel.readDouble()
        emb2Score = parcel.readDouble()
        emb1Score = parcel.readDouble()
        isEmb1Match = parcel.readByte() != 0.toByte()
        isEmb0Match = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (isEmb2Match) 1 else 0)
        parcel.writeDouble(emb0Score)
        parcel.writeDouble(emb2Score)
        parcel.writeDouble(emb1Score)
        parcel.writeByte(if (isEmb1Match) 1 else 0)
        parcel.writeByte(if (isEmb0Match) 1 else 0)
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
