package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Github() : Parcelable {

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

    @SerializedName("blog")
    @Expose
    var blog: String? = null

    @SerializedName("company")
    @Expose
    var company: String? = null

    @SerializedName("followers")
    @Expose
    var followers: Int? = null

    @SerializedName("following")
    @Expose
    var following: Int? = null

    @SerializedName("handle")
    @Expose
    var handle: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    constructor(parcel: Parcel) : this() {
        avatar = parcel.readString()
        blog = parcel.readString()
        company = parcel.readString()
        followers = parcel.readValue(Int::class.java.classLoader) as? Int
        following = parcel.readValue(Int::class.java.classLoader) as? Int
        handle = parcel.readString()
        id = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(avatar)
        parcel.writeString(blog)
        parcel.writeString(company)
        parcel.writeValue(followers)
        parcel.writeValue(following)
        parcel.writeString(handle)
        parcel.writeValue(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Github> {
        override fun createFromParcel(parcel: Parcel): Github {
            return Github(parcel)
        }

        override fun newArray(size: Int): Array<Github?> {
            return arrayOfNulls(size)
        }
    }

}
