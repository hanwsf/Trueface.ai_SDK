package ai.trueface.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
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

        enroll.setOnClickListener {
            startActivity(Intent(this, EnrollActivity::class.java))
        }
    }
}
