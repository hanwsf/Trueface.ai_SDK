package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result() : Parcelable {

    @SerializedName("created")
    @Expose
    var created: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("first_name")
    @Expose
    var firstName: Any? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("id_chip")
    @Expose
    var idChip: String? = null

    @SerializedName("id_landmark_chip")
    @Expose
    var idLandmarkChip: String? = null

    @SerializedName("last_name")
    @Expose
    var lastName: Any? = null

    @SerializedName("normalizd_person_chip")
    @Expose
    var normalizdPersonChip: Any? = null

    @SerializedName("normalized_id_chip")
    @Expose
    var normalizedIdChip: Any? = null

    @SerializedName("operation_code")
    @Expose
    var operationCode: Any? = null

    @SerializedName("owner")
    @Expose
    var owner: String? = null

    @SerializedName("person_chip")
    @Expose
    var personChip: String? = null

    @SerializedName("person_landmark_chip")
    @Expose
    var personLandmarkChip: String? = null

    @SerializedName("result")
    @Expose
    var result: Boolean? = null

    @SerializedName("sanctions_search")
    @Expose
    var sanctionsSearch: List<Any>? = null

    @SerializedName("score")
    @Expose
    var score: Double? = null

    @SerializedName("spoof_result")
    @Expose
    var spoofResult: String? = null

    @SerializedName("spoof_score")
    @Expose
    var spoofScore: Double? = null

    @SerializedName("updated")
    @Expose
    var updated: String? = null

    @SerializedName("web_match")
    @Expose
    var webMatch: WebMatch? = null

    constructor(parcel: Parcel) : this() {
        created = parcel.readString()
        email = parcel.readString()
        id = parcel.readString()
        idChip = parcel.readString()
        idLandmarkChip = parcel.readString()
        owner = parcel.readString()
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
        parcel.writeString(email)
        parcel.writeString(id)
        parcel.writeString(idChip)
        parcel.writeString(idLandmarkChip)
        parcel.writeString(owner)
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

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }

}
