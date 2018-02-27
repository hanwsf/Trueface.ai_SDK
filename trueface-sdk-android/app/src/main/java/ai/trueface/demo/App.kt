package ai.trueface.demo

import ai.trueface.sdk.Trueface
import android.app.Application
import io.github.kbiakov.codeview.classifier.CodeProcessor

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        Trueface.key = ""
        Trueface.Services()

        CodeProcessor.init(this)
    }
}