package ai.trueface.sdk

import ai.trueface.sdk.models.*
import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

object Trueface {

    var endPoints: Services.EndPoints? = null

    var base: String = "https://api.trueface.ai"
    var key: String? = null

    @Suppress("unused")
    class Services {

        interface EndPoints {
            // spoof detection
            @POST("/v1/spdetect")
            fun spdetect(@Body request: SpoofDetectionRequest): Call<SpoofDetection>

            @POST("/v1/spdetect")
            fun spoofDetection(@Body request: SpoofDetectionRequest): Call<SpoofDetection>

            // face detection
            @POST("/v1/facedetect")
            fun faceDetection(@Body request: FaceDetectionRequest): Call<FaceDetection>

            @POST("/v1/facedetect?rawlandmarks=true")
            fun faceDetectionWithLandmarks(@Body request: FaceDetectionRequest): Call<FaceDetection>

            // id verify
            @POST("/v1/idverify")
            fun idVerify(@Body request: IDVerifyRequest): Call<IDVerify>

            // face recognition
            @POST("/v1/enroll")
            fun enroll(@Body request: EnrollRequest): Call<Enroll>

        }

        init {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val builder = chain.request().newBuilder()
                                .addHeader("x-api-key", "${Trueface.key}")
                                .addHeader("Content-Type", "application/json")
                                .addHeader("Accept-Encoding", "identity")

                        val request = builder.build()
                        chain.proceed(request)
                    }
                    .addInterceptor(interceptor)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(5, TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(Trueface.base)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            Trueface.endPoints = retrofit.create(Services.EndPoints::class.java)
        }

    }
}