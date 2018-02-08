package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Resp() : Parcelable {

    @SerializedName("emb1_score")
    @Expose
    var emb1Score: Double = 0.toDouble()
    @SerializedName("emb0_score")
    @Expose
    var emb0Score: Double = 0.toDouble()
    @SerializedName("emb0_match")
    @Expose
    var isEmb0Match: Boolean = false
    @SerializedName("emb1_match")
    @Expose
    var isEmb1Match: Boolean = false

    constructor(parcel: Parcel) : this() {
        emb1Score = parcel.readDouble()
        emb0Score = parcel.readDouble()
        isEmb0Match = parcel.readByte() != 0.toByte()
        isEmb1Match = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(emb1Score)
        parcel.writeDouble(emb0Score)
        parcel.writeByte(if (isEmb0Match) 1 else 0)
        parcel.writeByte(if (isEmb1Match) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Resp> {
        override fun createFromParcel(parcel: Parcel): Resp {
            return Resp(parcel)
        }

        override fun newArray(size: Int): Array<Resp?> {
            return arrayOfNulls(size)
        }
    }

}
