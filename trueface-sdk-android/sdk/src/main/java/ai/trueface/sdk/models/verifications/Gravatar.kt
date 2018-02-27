package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Gravatar() : Parcelable {

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

    @SerializedName("avatars")
    @Expose
    var avatars: List<Avatar>? = null

    @SerializedName("handle")
    @Expose
    var handle: String? = null

    @SerializedName("urls")
    @Expose
    var urls: List<Any>? = null

    constructor(parcel: Parcel) : this() {
        avatar = parcel.readString()
        avatars = parcel.createTypedArrayList(Avatar)
        handle = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(avatar)
        parcel.writeTypedList(avatars)
        parcel.writeString(handle)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Gravatar> {
        override fun createFromParcel(parcel: Parcel): Gravatar {
            return Gravatar(parcel)
        }

        override fun newArray(size: Int): Array<Gravatar?> {
            return arrayOfNulls(size)
        }
    }

}
