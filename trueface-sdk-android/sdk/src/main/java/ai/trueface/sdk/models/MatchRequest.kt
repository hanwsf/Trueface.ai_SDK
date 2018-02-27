package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MatchRequest() : Parcelable {

    @SerializedName("img")
    @Expose
    var img: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("threshold")
    @Expose
    var threshold: Double = 0.5

    constructor(parcel: Parcel) : this() {
        img = parcel.readString()
        id = parcel.readString()
        threshold = parcel.readValue(Double::class.java.classLoader) as Double
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(img)
        parcel.writeString(id)
        parcel.writeValue(threshold)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MatchRequest> {
        override fun createFromParcel(parcel: Parcel): MatchRequest {
            return MatchRequest(parcel)
        }

        override fun newArray(size: Int): Array<MatchRequest?> {
            return arrayOfNulls(size)
        }
    }

}
