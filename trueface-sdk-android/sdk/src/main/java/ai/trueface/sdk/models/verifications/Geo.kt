package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Geo() : Parcelable {

    @SerializedName("city")
    @Expose
    var city: String? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("countryCode")
    @Expose
    var countryCode: String? = null

    @SerializedName("lat")
    @Expose
    var lat: Double? = null

    @SerializedName("lng")
    @Expose
    var lng: Double? = null

    @SerializedName("state")
    @Expose
    var state: String? = null

    @SerializedName("stateCode")
    @Expose
    var stateCode: String? = null

    constructor(parcel: Parcel) : this() {
        city = parcel.readString()
        country = parcel.readString()
        countryCode = parcel.readString()
        lat = parcel.readValue(Double::class.java.classLoader) as? Double
        lng = parcel.readValue(Double::class.java.classLoader) as? Double
        state = parcel.readString()
        stateCode = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(city)
        parcel.writeString(country)
        parcel.writeString(countryCode)
        parcel.writeValue(lat)
        parcel.writeValue(lng)
        parcel.writeString(state)
        parcel.writeString(stateCode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Geo> {
        override fun createFromParcel(parcel: Parcel): Geo {
            return Geo(parcel)
        }

        override fun newArray(size: Int): Array<Geo?> {
            return arrayOfNulls(size)
        }
    }

}
