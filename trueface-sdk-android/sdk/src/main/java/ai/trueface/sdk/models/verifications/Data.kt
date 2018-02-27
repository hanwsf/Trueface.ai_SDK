package ai.trueface.sdk.models.verifications

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data() : Parcelable {

    @SerializedName("created")
    @Expose
    var created: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("first_name")
    @Expose
    var firstName: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("last_name")
    @Expose
    var lastName: String? = null

    @SerializedName("operation_code")
    @Expose
    var operationCode: String? = null

    @SerializedName("owner")
    @Expose
    var owner: String? = null

    @SerializedName("preform_doc_verify")
    @Expose
    var preformDocVerify: Boolean? = null

    @SerializedName("preform_sanctions_search")
    @Expose
    var preformSanctionsSearch: Boolean? = null

    @SerializedName("preform_web_search")
    @Expose
    var preformWebSearch: Boolean? = null

    @SerializedName("preformed")
    @Expose
    var preformed: Boolean? = null

    @SerializedName("result")
    @Expose
    var result: Result? = null

    @SerializedName("sanctions_search")
    @Expose
    var sanctionsSearch: List<Any>? = null

    @SerializedName("updated")
    @Expose
    var updated: String? = null

    @SerializedName("web_results")
    @Expose
    var webResults: WebResults? = null

    constructor(parcel: Parcel) : this() {
        created = parcel.readString()
        email = parcel.readString()
        firstName = parcel.readString()
        id = parcel.readString()
        lastName = parcel.readString()
        operationCode = parcel.readString()
        owner = parcel.readString()
        preformDocVerify = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        preformSanctionsSearch = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        preformWebSearch = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        preformed = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        updated = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(created)
        parcel.writeString(email)
        parcel.writeString(firstName)
        parcel.writeString(id)
        parcel.writeString(lastName)
        parcel.writeString(operationCode)
        parcel.writeString(owner)
        parcel.writeValue(preformDocVerify)
        parcel.writeValue(preformSanctionsSearch)
        parcel.writeValue(preformWebSearch)
        parcel.writeValue(preformed)
        parcel.writeString(updated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }

}
