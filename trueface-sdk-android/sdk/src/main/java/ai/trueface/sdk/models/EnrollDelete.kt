package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EnrollDelete() : Parcelable {

    @SerializedName("data")
    @Expose
    var data: String? = null

    @SerializedName("message")
    @Expose
    var message: Any? = null

    @SerializedName("success")
    @Expose
    var success: Boolean = false

    constructor(parcel: Parcel) : this() {
        data = parcel.readString()
        success = parcel.readValue(Boolean::class.java.classLoader) as Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(data)
        parcel.writeValue(success)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EnrollDelete> {
        override fun createFromParcel(parcel: Parcel): EnrollDelete {
            return EnrollDelete(parcel)
        }

        override fun newArray(size: Int): Array<EnrollDelete?> {
            return arrayOfNulls(size)
        }
    }

}
