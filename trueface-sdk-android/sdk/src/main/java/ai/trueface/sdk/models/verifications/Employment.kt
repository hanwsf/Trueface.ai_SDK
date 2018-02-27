package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Employment() : Parcelable {

    @SerializedName("domain")
    @Expose
    var domain: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("role")
    @Expose
    var role: String? = null

    @SerializedName("seniority")
    @Expose
    var seniority: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    constructor(parcel: Parcel) : this() {
        domain = parcel.readString()
        name = parcel.readString()
        role = parcel.readString()
        seniority = parcel.readString()
        title = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(domain)
        parcel.writeString(name)
        parcel.writeString(role)
        parcel.writeString(seniority)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Employment> {
        override fun createFromParcel(parcel: Parcel): Employment {
            return Employment(parcel)
        }

        override fun newArray(size: Int): Array<Employment?> {
            return arrayOfNulls(size)
        }
    }

}
