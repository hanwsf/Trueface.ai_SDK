package ai.trueface.sdk.idverify;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.acuant.mobilesdk.Region;

import ai.trueface.sdk.R;
import ai.trueface.sdk.idverify.util.DataContext;

public class RegionList extends Activity {
    private ScanModel scanModel = null;

    /**
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // load several member variables
        setContentView(R.layout.activity_regionlist);
        scanModel = DataContext.getInstance().getScanModel();
    }

    public void selectedRegion(View v){
        int region;
        int i = v.getId();
        if (i == R.id.USA) {
            region = Region.REGION_UNITED_STATES;

        } else if (i == R.id.Canada) {
            region = Region.REGION_CANADA;

        } else if (i == R.id.Europe) {
            region = Region.REGION_EUROPE;

        } else if (i == R.id.Africa) {
            region = Region.REGION_AFRICA;

        } else if (i == R.id.Asia) {
            region = Region.REGION_ASIA;

        } else if (i == R.id.America) {
            region = Region.REGION_AMERICA;

        } else if (i == R.id.Australia) {
            region = Region.REGION_AUSTRALIA;

        } else {
            region = Region.REGION_UNITED_STATES;

        }
        DataContext.getInstance().setCardRegion(region);
        finish();
    }
}
