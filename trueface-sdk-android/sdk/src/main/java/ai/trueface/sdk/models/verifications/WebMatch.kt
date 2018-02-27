package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WebMatch() : Parcelable {

    @SerializedName("aboutme")
    @Expose
    var aboutMe: AboutMe? = null

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

    @SerializedName("bio")
    @Expose
    var bio: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("emailProvider")
    @Expose
    var emailProvider: Boolean? = null

    @SerializedName("employment")
    @Expose
    var employment: Employment? = null

    @SerializedName("facebook")
    @Expose
    var facebook: Facebook? = null

    @SerializedName("fuzzy")
    @Expose
    var fuzzy: Boolean? = null

    @SerializedName("gender")
    @Expose
    var gender: String? = null

    @SerializedName("geo")
    @Expose
    var geo: Geo? = null

    @SerializedName("github")
    @Expose
    var github: Github? = null

    @SerializedName("googleplus")
    @Expose
    var googlePlus: GooglePlus? = null

    @SerializedName("gravatar")
    @Expose
    var gravatar: Gravatar? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("indexedAt")
    @Expose
    var indexedAt: String? = null

    @SerializedName("linkedin")
    @Expose
    var linkedin: Linkedin? = null

    @SerializedName("location")
    @Expose
    var location: String? = null

    @SerializedName("name")
    @Expose
    var name: Name? = null

    @SerializedName("site")
    @Expose
    var site: String? = null

    @SerializedName("timeZone")
    @Expose
    var timeZone: String? = null

    @SerializedName("twitter")
    @Expose
    var twitter: Twitter? = null

    @SerializedName("utcOffset")
    @Expose
    var utcOffset: Int? = null

    constructor(parcel: Parcel) : this() {
        aboutMe = parcel.readParcelable(AboutMe::class.java.classLoader)
        avatar = parcel.readString()
        bio = parcel.readString()
        email = parcel.readString()
        emailProvider = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        employment = parcel.readParcelable(Employment::class.java.classLoader)
        facebook = parcel.readParcelable(Facebook::class.java.classLoader)
        fuzzy = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        gender = parcel.readString()
        geo = parcel.readParcelable(Geo::class.java.classLoader)
        github = parcel.readParcelable(Github::class.java.classLoader)
        googlePlus = parcel.readParcelable(GooglePlus::class.java.classLoader)
        gravatar = parcel.readParcelable(Gravatar::class.java.classLoader)
        id = parcel.readString()
        indexedAt = parcel.readString()
        linkedin = parcel.readParcelable(Linkedin::class.java.classLoader)
        location = parcel.readString()
        name = parcel.readParcelable(Name::class.java.classLoader)
        site = parcel.readString()
        timeZone = parcel.readString()
        twitter = parcel.readParcelable(Twitter::class.java.classLoader)
        utcOffset = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(aboutMe, flags)
        parcel.writeString(avatar)
        parcel.writeString(bio)
        parcel.writeString(email)
        parcel.writeValue(emailProvider)
        parcel.writeParcelable(employment, flags)
        parcel.writeParcelable(facebook, flags)
        parcel.writeValue(fuzzy)
        parcel.writeString(gender)
        parcel.writeParcelable(geo, flags)
        parcel.writeParcelable(github, flags)
        parcel.writeParcelable(googlePlus, flags)
        parcel.writeParcelable(gravatar, flags)
        parcel.writeString(id)
        parcel.writeString(indexedAt)
        parcel.writeParcelable(linkedin, flags)
        parcel.writeString(location)
        parcel.writeParcelable(name, flags)
        parcel.writeString(site)
        parcel.writeString(timeZone)
        parcel.writeParcelable(twitter, flags)
        parcel.writeValue(utcOffset)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WebMatch> {
        override fun createFromParcel(parcel: Parcel): WebMatch {
            return WebMatch(parcel)
        }

        override fun newArray(size: Int): Array<WebMatch?> {
            return arrayOfNulls(size)
        }
    }

}
