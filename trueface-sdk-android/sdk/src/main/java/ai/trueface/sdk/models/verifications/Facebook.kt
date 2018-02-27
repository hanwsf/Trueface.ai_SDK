package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Facebook() : Parcelable {

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

    companion object CREATOR : Parcelable.Creator<Facebook> {
        override fun createFromParcel(parcel: Parcel): Facebook {
            return Facebook(parcel)
        }

        override fun newArray(size: Int): Array<Facebook?> {
            return arrayOfNulls(size)
        }
    }

}
