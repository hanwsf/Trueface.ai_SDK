package ai.trueface.demo

import ai.trueface.sdk.Trueface
import android.app.Application
import io.github.kbiakov.codeview.classifier.CodeProcessor

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        Trueface.key = "mKQSrf7vQ29Y1G0lV41aL2espzYqjt3V7kw3JaVv"
        Trueface.Services()

        CodeProcessor.init(this)
    }
}