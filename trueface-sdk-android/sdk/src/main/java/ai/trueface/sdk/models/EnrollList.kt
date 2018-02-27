package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EnrollList() : Parcelable {

    @SerializedName("data")
    @Expose
    var data: List<EnrollRecord>? = null

    @SerializedName("message")
    @Expose
    var message: Any? = null

    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    constructor(parcel: Parcel) : this() {
        data = parcel.createTypedArrayList(EnrollRecord)
        success = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(data)
        parcel.writeValue(success)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EnrollList> {
        override fun createFromParcel(parcel: Parcel): EnrollList {
            return EnrollList(parcel)
        }

        override fun newArray(size: Int): Array<EnrollList?> {
            return arrayOfNulls(size)
        }
    }

}
