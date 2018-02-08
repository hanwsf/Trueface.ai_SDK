package ai.trueface.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchData {

    @SerializedName("emb2_match")
    @Expose
    private boolean emb2Match;

    @SerializedName("emb0_score")
    @Expose
    private double emb0Score;

    @SerializedName("emb2_score")
    @Expose
    private double emb2Score;

    @SerializedName("emb1_score")
    @Expose
    private double emb1Score;

    @SerializedName("emb1_match")
    @Expose
    private boolean emb1Match;

    @SerializedName("emb0_match")
    @Expose
    private boolean emb0Match;

    public boolean isEmb2Match() {
        return emb2Match;
    }

    public void setEmb2Match(boolean emb2Match) {
        this.emb2Match = emb2Match;
    }

    public double getEmb0Score() {
        return emb0Score;
    }

    public void setEmb0Score(double emb0Score) {
        this.emb0Score = emb0Score;
    }

    public double getEmb2Score() {
        return emb2Score;
    }

    public void setEmb2Score(double emb2Score) {
        this.emb2Score = emb2Score;
    }

    public double getEmb1Score() {
        return emb1Score;
    }

    public void setEmb1Score(double emb1Score) {
        this.emb1Score = emb1Score;
    }

    public boolean isEmb1Match() {
        return emb1Match;
    }

    public void setEmb1Match(boolean emb1Match) {
        this.emb1Match = emb1Match;
    }

    public boolean isEmb0Match() {
        return emb0Match;
    }

    public void setEmb0Match(boolean emb0Match) {
        this.emb0Match = emb0Match;
    }

}
