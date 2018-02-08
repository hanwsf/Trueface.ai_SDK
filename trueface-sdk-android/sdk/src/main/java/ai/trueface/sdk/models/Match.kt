package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Match() : Parcelable {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("resp")
    @Expose
    var resp: List<Resp>? = null

    constructor(parcel: Parcel) : this() {
        status = parcel.readString()
        resp = parcel.createTypedArrayList(Resp)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
        parcel.writeTypedList(resp)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Match> {
        override fun createFromParcel(parcel: Parcel): Match {
            return Match(parcel)
        }

        override fun newArray(size: Int): Array<Match?> {
            return arrayOfNulls(size)
        }
    }

}
