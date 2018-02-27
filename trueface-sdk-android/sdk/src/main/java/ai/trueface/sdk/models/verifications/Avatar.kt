package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Avatar() : Parcelable {

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    constructor(parcel: Parcel) : this() {
        type = parcel.readString()
        url = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Avatar> {
        override fun createFromParcel(parcel: Parcel): Avatar {
            return Avatar(parcel)
        }

        override fun newArray(size: Int): Array<Avatar?> {
            return arrayOfNulls(size)
        }
    }

}
