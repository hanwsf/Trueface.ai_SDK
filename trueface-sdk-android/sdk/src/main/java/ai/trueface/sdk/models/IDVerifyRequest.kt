package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IDVerifyRequest() : Parcelable {

    @SerializedName("id_image")
    @Expose
    private var idImage: String? = null

    @SerializedName("person_image")
    @Expose
    private var personImage: String? = null

    @SerializedName("email")
    @Expose
    private var email: String? = null

    @SerializedName("first_name")
    @Expose
    private var firstName: String? = null

    @SerializedName("last_name")
    @Expose
    private var lastName: String? = null

    @SerializedName("web_verify")
    @Expose
    private var webVerify: Boolean = false

    @SerializedName("sanctions_search")
    @Expose
    private var sanctionsSearch: Boolean = false

    @SerializedName("document_verify")
    @Expose
    private var documentVerify: Boolean = false

    constructor(parcel: Parcel) : this() {
        idImage = parcel.readString()
        personImage = parcel.readString()
        email = parcel.readString()
        firstName = parcel.readString()
        lastName = parcel.readString()
        webVerify = parcel.readByte() != 0.toByte()
        sanctionsSearch = parcel.readByte() != 0.toByte()
        documentVerify = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(idImage)
        parcel.writeString(personImage)
        parcel.writeString(email)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeByte(if (webVerify) 1 else 0)
        parcel.writeByte(if (sanctionsSearch) 1 else 0)
        parcel.writeByte(if (documentVerify) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IDVerifyRequest> {
        override fun createFromParcel(parcel: Parcel): IDVerifyRequest {
            return IDVerifyRequest(parcel)
        }

        override fun newArray(size: Int): Array<IDVerifyRequest?> {
            return arrayOfNulls(size)
        }
    }

}

