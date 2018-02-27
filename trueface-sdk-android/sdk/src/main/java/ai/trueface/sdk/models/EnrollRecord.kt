package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EnrollRecord() : Parcelable {

    @SerializedName("collection_id")
    @Expose
    var collectionId: Any? = null

    @SerializedName("created")
    @Expose
    var created: String? = null

    @SerializedName("embeddings")
    @Expose
    var embeddings: List<String>? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("images")
    @Expose
    var images: List<String>? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("owner")
    @Expose
    var owner: String? = null

    @SerializedName("updated")
    @Expose
    var updated: String? = null

    constructor(parcel: Parcel) : this() {
        created = parcel.readString()
        embeddings = parcel.createStringArrayList()
        id = parcel.readString()
        name = parcel.readString()
        owner = parcel.readString()
        updated = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(created)
        parcel.writeStringList(embeddings)
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(owner)
        parcel.writeString(updated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EnrollRecord> {
        override fun createFromParcel(parcel: Parcel): EnrollRecord {
            return EnrollRecord(parcel)
        }

        override fun newArray(size: Int): Array<EnrollRecord?> {
            return arrayOfNulls(size)
        }
    }

}