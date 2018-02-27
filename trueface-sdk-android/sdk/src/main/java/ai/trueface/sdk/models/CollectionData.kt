package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CollectionData() : Parcelable {

    @SerializedName("collection_id")
    @Expose
    var collectionId: String? = null

    constructor(parcel: Parcel) : this() {
        collectionId = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(collectionId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CollectionData> {
        override fun createFromParcel(parcel: Parcel): CollectionData {
            return CollectionData(parcel)
        }

        override fun newArray(size: Int): Array<CollectionData?> {
            return arrayOfNulls(size)
        }
    }

}
