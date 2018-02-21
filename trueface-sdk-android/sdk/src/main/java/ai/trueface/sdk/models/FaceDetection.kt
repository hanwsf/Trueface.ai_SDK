package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FaceDetection() : Parcelable {

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("success")
    @Expose
    var success: Boolean = false

    @SerializedName("faces")
    @Expose
    var faces: List<Face>? = null

    constructor(parcel: Parcel) : this() {
        message = parcel.readString()
        success = parcel.readValue(Boolean::class.java.classLoader) as Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(message)
        parcel.writeValue(success)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FaceDetection> {
        override fun createFromParcel(parcel: Parcel): FaceDetection {
            return FaceDetection(parcel)
        }

        override fun newArray(size: Int): Array<FaceDetection?> {
            return arrayOfNulls(size)
        }
    }

}
