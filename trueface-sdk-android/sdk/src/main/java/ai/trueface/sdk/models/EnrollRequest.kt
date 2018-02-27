package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable

class EnrollRequest(
        var img0: String? = null,
        var img1: String? = null,
        var img2: String? = null,
        var img3: String? = null,
        var img4: String? = null,
        var img5: String? = null,
        var img6: String? = null,
        var img7: String? = null,
        var img8: String? = null,
        var img9: String? = null,
        var collection_id: String? = null,
        var enrollment_id: String? = null,
        var name: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(img0)
        parcel.writeString(img1)
        parcel.writeString(img2)
        parcel.writeString(img3)
        parcel.writeString(img4)
        parcel.writeString(img5)
        parcel.writeString(img6)
        parcel.writeString(img7)
        parcel.writeString(img8)
        parcel.writeString(img9)
        parcel.writeString(collection_id)
        parcel.writeString(enrollment_id)
        parcel.writeString(name)
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
