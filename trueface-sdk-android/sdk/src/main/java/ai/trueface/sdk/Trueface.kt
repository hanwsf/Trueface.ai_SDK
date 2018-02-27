package ai.trueface.sdk

import ai.trueface.sdk.models.*
import ai.trueface.sdk.models.CollectionRequest
import ai.trueface.sdk.models.Collection
import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

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

            @GET("/v1/idverify")
            fun verifications(): Call<IDVerify>

            // face recognition

            // enroll
            @POST("/v1/enroll")
            fun enroll(@Body request: EnrollRequest): Call<Enroll>

            @PUT("/v1/enroll")
            fun updateEnroll(@Body request: EnrollRequest): Call<Enroll>

            @GET("/v1/enroll")
            fun listEnroll(): Call<EnrollList>

            @DELETE("/v1/enroll")
            fun deleteEnroll(@Body request: EnrollRequest): Call<EnrollDelete>

            // collection
            @POST("/v1/collection")
            fun createCollection(@Body request: CollectionRequest): Call<Collection>

            @PUT("/v1/collection")
            fun updateCollection(@Body request: CollectionRequest): Call<Collection>

            @DELETE("/v1/collection")
            fun deleteCollection(@Body request: CollectionRequest): Call<CollectionDelete>

            @GET("/v1/collection")
            fun listCollection(): Call<CollectionList>

            @POST("/v1/train")
            fun trainCollection(@Body request: TrainRequest): Call<Train>

            @POST("/v1/match")
            fun match(@Body request: MatchRequest): Call<Match>

            @POST("/v1/identify")
            fun identify(@Body request: IdentifyRequest): Call<Identify>
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