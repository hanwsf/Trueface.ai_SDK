package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TrainRequest() : Parcelable {

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

    companion object CREATOR : Parcelable.Creator<TrainRequest> {
        override fun createFromParcel(parcel: Parcel): TrainRequest {
            return TrainRequest(parcel)
        }

        override fun newArray(size: Int): Array<TrainRequest?> {
            return arrayOfNulls(size)
        }
    }

}
