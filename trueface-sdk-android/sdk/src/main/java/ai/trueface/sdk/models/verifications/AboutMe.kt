package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AboutMe() : Parcelable {

    @SerializedName("avatar")
    @Expose
    var avatar: Any? = null

    @SerializedName("bio")
    @Expose
    var bio: Any? = null

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

    companion object CREATOR : Parcelable.Creator<AboutMe> {
        override fun createFromParcel(parcel: Parcel): AboutMe {
            return AboutMe(parcel)
        }

        override fun newArray(size: Int): Array<AboutMe?> {
            return arrayOfNulls(size)
        }
    }

}
