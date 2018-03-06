package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

object DocumentType {
    const val ID = 0
    const val DL = 0
    const val Passports = 1
    const val Medical = 2
}

object DocumentRegion {
    const val USA = 0
    const val Canada = 1
    const val America = 2
    const val Europe = 3
    const val Australia = 4
    const val Asia = 5
    const val General = 6
    const val Africa = 7
}

class IDVerifyRequest() : Parcelable {

    @SerializedName("id_image")
    @Expose
    var idImage: String? = null

    @SerializedName("person_image")
    @Expose
    var personImage: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("first_name")
    @Expose
    var firstName: String? = null

    @SerializedName("last_name")
    @Expose
    var lastName: String? = null

    @SerializedName("web_verify")
    @Expose
    var webVerify: Boolean = false

    @SerializedName("sanctions_search")
    @Expose
    var sanctionsSearch: Boolean = false

    @SerializedName("document_verify")
    @Expose
    var documentVerify: Boolean = false

    @SerializedName("document_type")
    @Expose
    var documentType: Int = -1

    @SerializedName("document_region")
    @Expose
    var documentRegion: Int = -1

    constructor(parcel: Parcel) : this() {
        idImage = parcel.readString()
        personImage = parcel.readString()
        email = parcel.readString()
        firstName = parcel.readString()
        lastName = parcel.readString()
        webVerify = parcel.readByte() != 0.toByte()
        sanctionsSearch = parcel.readByte() != 0.toByte()
        documentVerify = parcel.readByte() != 0.toByte()
        documentType = parcel.readInt()
        documentRegion = parcel.readInt()
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
        parcel.writeInt(documentType)
        parcel.writeInt(documentRegion)
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

