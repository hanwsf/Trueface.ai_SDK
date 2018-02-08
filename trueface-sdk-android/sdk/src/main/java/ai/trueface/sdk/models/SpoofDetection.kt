package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpoofDetection() : Parcelable {

    @SerializedName("data")
    @Expose
    var data: SpoofDetectionData? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("success")
    @Expose
    var isSuccess: Boolean = false

    constructor(parcel: Parcel) : this() {
        data = parcel.readParcelable(SpoofDetectionData::class.java.classLoader)
        message = parcel.readString()
        isSuccess = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(data, flags)
        parcel.writeString(message)
        parcel.writeByte(if (isSuccess) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SpoofDetection> {
        override fun createFromParcel(parcel: Parcel): SpoofDetection {
            return SpoofDetection(parcel)
        }

        override fun newArray(size: Int): Array<SpoofDetection?> {
            return arrayOfNulls(size)
        }
    }

}
