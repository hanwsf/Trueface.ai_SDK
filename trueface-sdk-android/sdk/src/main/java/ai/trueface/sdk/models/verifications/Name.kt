package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Name() : Parcelable {

    @SerializedName("familyName")
    @Expose
    var familyName: String? = null

    @SerializedName("fullName")
    @Expose
    var fullName: String? = null

    @SerializedName("givenName")
    @Expose
    var givenName: String? = null

    constructor(parcel: Parcel) : this() {
        familyName = parcel.readString()
        fullName = parcel.readString()
        givenName = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(familyName)
        parcel.writeString(fullName)
        parcel.writeString(givenName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Name> {
        override fun createFromParcel(parcel: Parcel): Name {
            return Name(parcel)
        }

        override fun newArray(size: Int): Array<Name?> {
            return arrayOfNulls(size)
        }
    }

}
