package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GooglePlus() : Parcelable {

    @SerializedName("handle")
    @Expose
    var handle: Any? = null

    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GooglePlus> {
        override fun createFromParcel(parcel: Parcel): GooglePlus {
            return GooglePlus(parcel)
        }

        override fun newArray(size: Int): Array<GooglePlus?> {
            return arrayOfNulls(size)
        }
    }

}
