package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Twitter() : Parcelable {

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

    @SerializedName("bio")
    @Expose
    var bio: String? = null

    @SerializedName("favorites")
    @Expose
    var favorites: Int? = null

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

    @SerializedName("location")
    @Expose
    var location: String? = null

    @SerializedName("site")
    @Expose
    var site: String? = null

    @SerializedName("statuses")
    @Expose
    var statuses: Int? = null

    constructor(parcel: Parcel) : this() {
        avatar = parcel.readString()
        bio = parcel.readString()
        favorites = parcel.readValue(Int::class.java.classLoader) as? Int
        followers = parcel.readValue(Int::class.java.classLoader) as? Int
        following = parcel.readValue(Int::class.java.classLoader) as? Int
        handle = parcel.readString()
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        location = parcel.readString()
        site = parcel.readString()
        statuses = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(avatar)
        parcel.writeString(bio)
        parcel.writeValue(favorites)
        parcel.writeValue(followers)
        parcel.writeValue(following)
        parcel.writeString(handle)
        parcel.writeValue(id)
        parcel.writeString(location)
        parcel.writeString(site)
        parcel.writeValue(statuses)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Twitter> {
        override fun createFromParcel(parcel: Parcel): Twitter {
            return Twitter(parcel)
        }

        override fun newArray(size: Int): Array<Twitter?> {
            return arrayOfNulls(size)
        }
    }

}
