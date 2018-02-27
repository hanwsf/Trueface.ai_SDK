package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EnrollData() : Parcelable {

    @SerializedName("enrollment_id")
    @Expose
    private var enrollmentId: String? = null

    constructor(parcel: Parcel) : this() {
        enrollmentId = parcel.readString()
    }

    fun getEnrollmentId(): String? {
        return enrollmentId
    }

    fun setEnrollmentId(enrollmentId: String) {
        this.enrollmentId = enrollmentId
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(enrollmentId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EnrollData> {
        override fun createFromParcel(parcel: Parcel): EnrollData {
            return EnrollData(parcel)
        }

        override fun newArray(size: Int): Array<EnrollData?> {
            return arrayOfNulls(size)
        }
    }


}
