package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Enroll() : Parcelable {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("encodings")
    @Expose
    var encodings: List<Encoding>? = null

    constructor(parcel: Parcel) : this() {
        status = parcel.readString()
        encodings = parcel.createTypedArrayList(Encoding)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
        parcel.writeTypedList(encodings)
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
