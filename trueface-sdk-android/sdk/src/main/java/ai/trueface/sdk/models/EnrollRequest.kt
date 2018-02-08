package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable

class EnrollRequest(
        var name: String,
        var img0: String,
        var img1: String,
        var img2: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(img0)
        parcel.writeString(img1)
        parcel.writeString(img2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EnrollRequest> {
        override fun createFromParcel(parcel: Parcel): EnrollRequest {
            return EnrollRequest(parcel)
        }

        override fun newArray(size: Int): Array<EnrollRequest?> {
            return arrayOfNulls(size)
        }
    }
}
