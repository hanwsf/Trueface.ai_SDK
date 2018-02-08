package ai.trueface.demo

import ai.trueface.sdk.Trueface
import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        Trueface.key = "YOUR-KEY-HERE"
        Trueface.Services()
    }
}