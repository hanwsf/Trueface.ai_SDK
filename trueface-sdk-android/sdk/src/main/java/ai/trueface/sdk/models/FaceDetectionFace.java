package ai.trueface.sdk.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FaceDetectionFace {

    @SerializedName("bounding_box")
    @Expose
    private List<Double> boundingBox = null;
    @SerializedName("points")
    @Expose
    private List<Integer> points = null;
    @SerializedName("landmarks")
    @Expose
    private List<Object> landmarks = null;

    public List<Double> getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(List<Double> boundingBox) {
        this.boundingBox = boundingBox;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public List<Object> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<Object> landmarks) {
        this.landmarks = landmarks;
    }

}
