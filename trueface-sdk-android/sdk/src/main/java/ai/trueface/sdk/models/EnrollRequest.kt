package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EnrollRequest() : Parcelable {

    @SerializedName("img0")
    @Expose
    var img0: String? = null

    @SerializedName("img1")
    @Expose
    var img1: String? = null

    @SerializedName("img2")
    @Expose
    var img2: String? = null

    @SerializedName("img3")
    @Expose
    var img3: String? = null

    @SerializedName("img4")
    @Expose
    var img4: String? = null

    @SerializedName("img5")
    @Expose
    var img5: String? = null

    @SerializedName("img6")
    @Expose
    var img6: String? = null

    @SerializedName("img7")
    @Expose
    var img7: String? = null

    @SerializedName("img8")
    @Expose
    var img8: String? = null

    @SerializedName("img9")
    @Expose
    var img9: String? = null

    @SerializedName("collection_id")
    @Expose
    var collectionId: String? = null

    @SerializedName("enrollment_id")
    @Expose
    var enrollmentId: String? = null

    constructor(parcel: Parcel) : this() {
        img0 = parcel.readString()
        img1 = parcel.readString()
        img2 = parcel.readString()
        img3 = parcel.readString()
        img4 = parcel.readString()
        img5 = parcel.readString()
        img6 = parcel.readString()
        img7 = parcel.readString()
        img8 = parcel.readString()
        img9 = parcel.readString()
        collectionId = parcel.readString()
        enrollmentId = parcel.readString()
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
        parcel.writeString(collectionId)
        parcel.writeString(enrollmentId)
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