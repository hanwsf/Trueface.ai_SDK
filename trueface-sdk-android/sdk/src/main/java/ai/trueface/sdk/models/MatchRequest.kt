package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable

class MatchRequest(
        private var emb0: String,
        private var emb1: String,
        private var img: String
) : Parcelable {
    private var threshold = 0.4f

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
        threshold = parcel.readFloat()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(emb0)
        parcel.writeString(emb1)
        parcel.writeString(img)
        parcel.writeFloat(threshold)
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
