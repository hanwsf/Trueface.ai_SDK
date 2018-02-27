package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Linkedin() : Parcelable {

    @SerializedName("handle")
    @Expose
    var handle: String? = null

    constructor(parcel: Parcel) : this() {
        handle = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(handle)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Linkedin> {
        override fun createFromParcel(parcel: Parcel): Linkedin {
            return Linkedin(parcel)
        }

        override fun newArray(size: Int): Array<Linkedin?> {
            return arrayOfNulls(size)
        }
    }

}
