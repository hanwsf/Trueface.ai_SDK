package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IdentifyData() : Parcelable {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("key")
    @Expose
    var key: String? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        key = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(key)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IdentifyData> {
        override fun createFromParcel(parcel: Parcel): IdentifyData {
            return IdentifyData(parcel)
        }

        override fun newArray(size: Int): Array<IdentifyData?> {
            return arrayOfNulls(size)
        }
    }

}
