package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpoofDetectionData() : Parcelable {

    @SerializedName("class")
    @Expose
    private var klass: String? = null

    @SerializedName("key")
    @Expose
    private var key: String? = null

    @SerializedName("score")
    @Expose
    private var score: Double = 0.toDouble()

    @SerializedName("success")
    @Expose
    private var success: Boolean = false

    constructor(parcel: Parcel) : this() {
        klass = parcel.readString()
        key = parcel.readString()
        score = parcel.readDouble()
        success = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(klass)
        parcel.writeString(key)
        parcel.writeDouble(score)
        parcel.writeByte(if (success) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SpoofDetectionData> {
        override fun createFromParcel(parcel: Parcel): SpoofDetectionData {
            return SpoofDetectionData(parcel)
        }

        override fun newArray(size: Int): Array<SpoofDetectionData?> {
            return arrayOfNulls(size)
        }
    }

}
