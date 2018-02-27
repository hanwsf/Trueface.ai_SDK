package ai.trueface.sdk.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TrainData {

    @SerializedName("collection_id")
    @Expose
    var collectionId: String? = null

}
