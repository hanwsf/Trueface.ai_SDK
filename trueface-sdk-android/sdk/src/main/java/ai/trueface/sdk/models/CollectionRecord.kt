package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CollectionRecord() : Parcelable {

    @SerializedName("classifier_url")
    @Expose
    var classifierUrl: String? = null

    @SerializedName("created")
    @Expose
    var created: String? = null

    @SerializedName("enrollments")
    @Expose
    var enrollments: List<String>? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("label_encoder")
    @Expose
    var labelEncoder: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("owner")
    @Expose
    var owner: String? = null

    @SerializedName("unknown")
    @Expose
    var unknown: Boolean? = null

    @SerializedName("updated")
    @Expose
    var updated: String? = null

    constructor(parcel: Parcel) : this() {
        classifierUrl = parcel.readString()
        created = parcel.readString()
        enrollments = parcel.createStringArrayList()
        id = parcel.readString()
        labelEncoder = parcel.readString()
        name = parcel.readString()
        owner = parcel.readString()
        unknown = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        updated = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(classifierUrl)
        parcel.writeString(created)
        parcel.writeStringList(enrollments)
        parcel.writeString(id)
        parcel.writeString(labelEncoder)
        parcel.writeString(name)
        parcel.writeString(owner)
        parcel.writeValue(unknown)
        parcel.writeString(updated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CollectionRecord> {
        override fun createFromParcel(parcel: Parcel): CollectionRecord {
            return CollectionRecord(parcel)
        }

        override fun newArray(size: Int): Array<CollectionRecord?> {
            return arrayOfNulls(size)
        }
    }

}
