package ai.trueface.demo

import ai.trueface.sdk.Trueface
import ai.trueface.sdk.models.SpoofDetection
import ai.trueface.sdk.models.SpoofDetectionRequest
import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_spoof_detection.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpoofDetectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spoof_detection)

        from_gallery.setOnClickListener {
            val code = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val intent = Intent(Intent.ACTION_PICK, code)
            startActivityForResult(intent, 3)
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 3 && data != null && resultCode == Activity.RESULT_OK) {

            val inputStream = applicationContext.contentResolver.openInputStream(data.data)
            val bytes = inputStream.readBytes()

            image.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.size))
            val base64 = Base64.encodeToString(bytes, Base64.DEFAULT)

            result.text = getString(R.string.processing)

            val request = SpoofDetectionRequest(img = base64)
            val call = Trueface.endPoints?.spoofDetection(request = request)
            call?.enqueue(object : Callback<SpoofDetection> {
                override fun onFailure(call: Call<SpoofDetection>?, t: Throwable?) {
                    result.text = t?.message
                }

                override fun onResponse(call: Call<SpoofDetection>?, response: Response<SpoofDetection>?) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val json = gson.toJson(response)

                    if (response?.isSuccessful == true) {
                        response.body()?.let { res ->
                            if (res.success) {
                                result.text = getString(R.string.result_success)
                                codeview.setCode(json.trimMargin(), "json")
                            } else {
                                result.text = res.message
                            }
                        }
                    } else {
                        result.text = response?.errorBody().toString()
                    }
                }

            })
        }
    }
}
