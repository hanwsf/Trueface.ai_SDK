package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IDVerify() : Parcelable {

    @SerializedName("data")
    @Expose
    private var data: IDVerifyData? = null

    @SerializedName("message")
    @Expose
    private var message: String? = null

    @SerializedName("success")
    @Expose
    private var success: Boolean? = null

    constructor(parcel: Parcel) : this() {
        data = parcel.readParcelable(IDVerifyData::class.java.classLoader)
        message = parcel.readString()
        success = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(data, flags)
        parcel.writeString(message)
        parcel.writeValue(success)
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
