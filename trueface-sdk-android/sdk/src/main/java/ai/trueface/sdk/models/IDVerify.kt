package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IDVerify() : Parcelable {

    @SerializedName("data")
    @Expose
    var data: IdentifyData? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("success")
    @Expose
    var success: Boolean = false

    constructor(parcel: Parcel) : this() {
        data = parcel.readParcelable(IdentifyData::class.java.classLoader)
        message = parcel.readString()
        success = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(data, flags)
        parcel.writeString(message)
        parcel.writeByte(if (success) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IDVerify> {
        override fun createFromParcel(parcel: Parcel): IDVerify {
            return IDVerify(parcel)
        }

        override fun newArray(size: Int): Array<IDVerify?> {
            return arrayOfNulls(size)
        }
    }

}