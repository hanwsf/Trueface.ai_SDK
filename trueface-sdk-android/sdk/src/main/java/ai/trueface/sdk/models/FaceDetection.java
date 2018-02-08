package ai.trueface.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FaceDetection {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("faces")
    @Expose
    private List<FaceDetectionFace> faces = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<FaceDetectionFace> getFaces() {
        return faces;
    }

    public void setFaces(List<FaceDetectionFace> faces) {
        this.faces = faces;
    }

}
