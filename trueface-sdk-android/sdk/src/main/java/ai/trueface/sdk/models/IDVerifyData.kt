package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IDVerifyData() : Parcelable {

    @SerializedName("created")
    @Expose
    private var created: String? = null

    @SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("id_chip")
    @Expose
    private var idChip: String? = null

    @SerializedName("id_landmark_chip")
    @Expose
    private var idLandmarkChip: String? = null

    @SerializedName("person_chip")
    @Expose
    private var personChip: String? = null

    @SerializedName("person_landmark_chip")
    @Expose
    private var personLandmarkChip: String? = null

    @SerializedName("result")
    @Expose
    private var result: Boolean? = null

    @SerializedName("score")
    @Expose
    private var score: Double? = null

    @SerializedName("spoof_result")
    @Expose
    private var spoofResult: String? = null

    @SerializedName("spoof_score")
    @Expose
    private var spoofScore: Double? = null

    @SerializedName("updated")
    @Expose
    private var updated: String? = null

    constructor(parcel: Parcel) : this() {
        created = parcel.readString()
        id = parcel.readString()
        idChip = parcel.readString()
        idLandmarkChip = parcel.readString()
        personChip = parcel.readString()
        personLandmarkChip = parcel.readString()
        result = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        score = parcel.readValue(Double::class.java.classLoader) as? Double
        spoofResult = parcel.readString()
        spoofScore = parcel.readValue(Double::class.java.classLoader) as? Double
        updated = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(created)
        parcel.writeString(id)
        parcel.writeString(idChip)
        parcel.writeString(idLandmarkChip)
        parcel.writeString(personChip)
        parcel.writeString(personLandmarkChip)
        parcel.writeValue(result)
        parcel.writeValue(score)
        parcel.writeString(spoofResult)
        parcel.writeValue(spoofScore)
        parcel.writeString(updated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IDVerifyData> {
        override fun createFromParcel(parcel: Parcel): IDVerifyData {
            return IDVerifyData(parcel)
        }

        override fun newArray(size: Int): Array<IDVerifyData?> {
            return arrayOfNulls(size)
        }
    }
}
