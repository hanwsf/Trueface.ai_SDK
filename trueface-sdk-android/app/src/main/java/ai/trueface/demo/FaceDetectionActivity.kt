package ai.trueface.demo

import ai.trueface.sdk.Trueface
import ai.trueface.sdk.models.FaceDetection
import ai.trueface.sdk.models.FaceDetectionRequest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_face_detection.*
import android.content.Intent
import android.app.Activity
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FaceDetectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_face_detection)

        from_gallery.setOnClickListener { fromGallery() }
    }

    private fun fromGallery() {
        val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, 3)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 3
                && data != null
                && resultCode == Activity.RESULT_OK) {
            val inputStream = applicationContext.contentResolver.openInputStream(data.data)
            val bytes = inputStream.readBytes()

            image.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.size))
            val base64 = Base64.encodeToString(bytes, Base64.DEFAULT)

            val req = FaceDetectionRequest(img = base64)
            val call = Trueface.endPoints?.faceDetection(request = req)
            call?.enqueue(object : Callback<FaceDetection> {
                override fun onFailure(call: Call<FaceDetection>?, t: Throwable?) {
                    result.text = t?.message
                }

                override fun onResponse(call: Call<FaceDetection>?, response: Response<FaceDetection>?) {
                    if (response?.isSuccessful == true) {
                        response.body()?.let { res ->
                            if (res.success) {
                                result.text = res.faces.toString()
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
