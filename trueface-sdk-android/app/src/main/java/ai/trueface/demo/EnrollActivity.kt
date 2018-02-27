package ai.trueface.demo

import ai.trueface.sdk.Trueface
import ai.trueface.sdk.models.Enroll
import ai.trueface.sdk.models.EnrollRequest
import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_enroll.*
import android.util.Base64
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnrollActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enroll)

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

            val request = EnrollRequest(img0 = base64, name = enroll_name.text.toString())
            val call = Trueface.endPoints?.enroll(request = request)
            call?.enqueue(object : Callback<Enroll> {
                override fun onFailure(call: Call<Enroll>?, t: Throwable?) {
                    result.text = t?.message
                }

                override fun onResponse(call: Call<Enroll>?, response: Response<Enroll>?) {
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
