package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Enroll() : Parcelable {

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: EnrollData? = null

    @SerializedName("success")
    @Expose
    var success: Boolean = false

    constructor(parcel: Parcel) : this() {
        message = parcel.readString()
        data = parcel.readParcelable(EnrollData::class.java.classLoader)
        success = parcel.readValue(Boolean::class.java.classLoader) as Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(message)
        parcel.writeParcelable(data, flags)
        parcel.writeValue(success)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Enroll> {
        override fun createFromParcel(parcel: Parcel): Enroll {
            return Enroll(parcel)
        }

        override fun newArray(size: Int): Array<Enroll?> {
            return arrayOfNulls(size)
        }
    }
}
