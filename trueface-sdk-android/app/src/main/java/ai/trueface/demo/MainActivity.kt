package ai.trueface.demo

import ai.trueface.sdk.idverify.ScanActivity
import ai.trueface.sdk.models.FaceDetectionRequest
import ai.trueface.sdk.models.IDVerifyRequest
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.graphics.BitmapFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        face_detection.setOnClickListener {
            startActivity(Intent(this, FaceDetectionActivity::class.java))
        }

        spoof_detection.setOnClickListener {
            startActivity(Intent(this, SpoofDetectionActivity::class.java))
        }

        spoof_detection_java.setOnClickListener {
            startActivity(Intent(this, SpActivity::class.java))
        }

        enroll.setOnClickListener {
            startActivity(Intent(this, EnrollActivity::class.java))
        }

        scan_document.setOnClickListener {
            startActivityForResult(Intent(this, ScanActivity::class.java), 3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null && requestCode == 3) {
            if (resultCode == Activity.RESULT_OK) {
                val front = data.getByteArrayExtra("front_bitmap")
                frontBitmap.setImageBitmap(BitmapFactory.decodeByteArray(front,0, front.size))

                val back = data.getByteArrayExtra("back_bitmap")
                if (back.isNotEmpty()) {
                    backBitmap.setImageBitmap(BitmapFactory.decodeByteArray(back,0, back.size))
                }
            }
        }
    }
}
