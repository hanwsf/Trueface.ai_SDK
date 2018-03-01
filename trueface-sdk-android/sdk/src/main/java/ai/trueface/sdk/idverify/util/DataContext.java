/*
 * 
 */
package ai.trueface.sdk.idverify.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.acuant.mobilesdk.*;
import ai.trueface.sdk.idverify.ScanModel;

/**
 * 
 *
 */
public class DataContext extends android.app.Application
{
    private static final String TAG = DataContext.class.getName();

    private static DataContext instance = null;
    private int cardType;
    private int cardRegion;
    private DriversLicenseCard processedLicenseCard;
    private MedicalCard processedMedicalCard;
    private PassportCard processedPassportCard;
    private FacialData processedFacialData;
    
    private ScanModel scanModel = null;
    
    private LicenseDetails cssnLicenseDetails;

    private String licenseKey = "";

    private Context context;

    private DataContext()
    {
    }
    
    public static DataContext getInstance()
    {
        if (instance == null)
        {
            instance = new DataContext();
        }

        return instance;
    }

    public String getLicenseKey()
    {
        licenseKey = getSharedPreferences().getString("licenseKey", "");
        return licenseKey;
    }
    public void setContext(Context context){
      this.context = context;
    }

    public void setLicenseKey(String licenseKey)
    {
        this.licenseKey = licenseKey;
        Editor editor = getSharedPreferences().edit();
        editor.putString("licenseKey", licenseKey);
        editor.commit();
    }

    public int getCardType()
    {
        return cardType;
    }

    public void setCardType(int cardType)
    {
        this.cardType = cardType;
    }

    public int getCardRegion()
    {
        return cardRegion;
    }

    public void setCardRegion(int cardRegion)
    {
        this.cardRegion = cardRegion;
    }

    public DriversLicenseCard getProcessedLicenseCard()
    {
        return processedLicenseCard;
    }

    public void setProcessedLicenseCard(DriversLicenseCard processedLicenseCard)
    {
        this.processedLicenseCard = processedLicenseCard;
    }

    public MedicalCard getProcessedMedicalCard()
    {
        return processedMedicalCard;
    }

    public void setProcessedMedicalCard(MedicalCard processedMedicalCard)
    {
        this.processedMedicalCard = processedMedicalCard;
    }

    public PassportCard getProcessedPassportCard()
    {
        return processedPassportCard;
    }

    public void setProcessedPassportCard(PassportCard processedPassportCard)
    {
        this.processedPassportCard = processedPassportCard;
    }

    public FacialData getProcessedFacialData() {
        return processedFacialData;
    }

    public void setProcessedFacialData(FacialData processedFacialData) {
        this.processedFacialData = processedFacialData;
    }

    /**
     * @return the scanModel
     */
    public ScanModel getScanModel()
    {
        return scanModel;
    }

    /**
     * @param scanModel the scanModel to set
     */
    public void setScanModel(ScanModel scanModel)
    {
        this.scanModel = scanModel;
    }

    /**
     * @return the cssnLicenseDetails
     */
    public LicenseDetails getCssnLicenseDetails()
    {
        return cssnLicenseDetails;
    }

    /**
     * @param cssnLicenseDetails the cssnLicenseDetails to set
     */
    public void setCssnLicenseDetails(LicenseDetails cssnLicenseDetails)
    {
        this.cssnLicenseDetails = cssnLicenseDetails;
    }

    private SharedPreferences getSharedPreferences()
    {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
