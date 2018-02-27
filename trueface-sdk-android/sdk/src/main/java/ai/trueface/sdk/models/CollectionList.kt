package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CollectionList() : Parcelable {

    @SerializedName("data")
    @Expose
    var data: List<CollectionRecord>? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("success")
    @Expose
    var success: Boolean = false

    constructor(parcel: Parcel) : this() {
        data = parcel.createTypedArrayList(CollectionRecord)
        message = parcel.readString()
        success = parcel.readValue(Boolean::class.java.classLoader) as Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(data)
        parcel.writeString(message)
        parcel.writeValue(success)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CollectionList> {
        override fun createFromParcel(parcel: Parcel): CollectionList {
            return CollectionList(parcel)
        }

        override fun newArray(size: Int): Array<CollectionList?> {
            return arrayOfNulls(size)
        }
    }

}

