package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CollectionRequest() : Parcelable {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("unknowns")
    @Expose
    var unknowns: Boolean? = null

    @SerializedName("enrollment_id")
    @Expose
    var enrollment_id: String? = null

    @SerializedName("collection_id")
    @Expose
    var collection_id: String? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        unknowns = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        enrollment_id = parcel.readString()
        collection_id = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(unknowns)
        parcel.writeString(enrollment_id)
        parcel.writeString(collection_id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CollectionRequest> {
        override fun createFromParcel(parcel: Parcel): CollectionRequest {
            return CollectionRequest(parcel)
        }

        override fun newArray(size: Int): Array<CollectionRequest?> {
            return arrayOfNulls(size)
        }
    }

}
