package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable

class FaceDetectionRequest(internal val img: String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FaceDetectionRequest> {
        override fun createFromParcel(parcel: Parcel): FaceDetectionRequest {
            return FaceDetectionRequest(parcel)
        }

        override fun newArray(size: Int): Array<FaceDetectionRequest?> {
            return arrayOfNulls(size)
        }
    }
}
