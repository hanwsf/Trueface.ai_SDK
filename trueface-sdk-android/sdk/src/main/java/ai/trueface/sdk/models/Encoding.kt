package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Encoding() : Parcelable {

    @SerializedName("emb0")
    @Expose
    var emb0: String? = null

    @SerializedName("emb1")
    @Expose
    var emb1: String? = null

    constructor(parcel: Parcel) : this() {
        emb0 = parcel.readString()
        emb1 = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(emb0)
        parcel.writeString(emb1)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Encoding> {
        override fun createFromParcel(parcel: Parcel): Encoding {
            return Encoding(parcel)
        }

        override fun newArray(size: Int): Array<Encoding?> {
            return arrayOfNulls(size)
        }
    }

}