package pokemontcg.libraries.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientBuilder {

    private val baseClient = OkHttpClient()
    private val gsonDefault = GsonBuilder()
        .setDateFormat("yyyy-MM-dd 'T' HH:mm:ss")
        .create()

    fun <T> createServiceApi(
        serviceClass: Class<T>,
        baseUrl: String,
        gson: Gson = gsonDefault,
        vararg interceptor: Interceptor
    ): T {
        val clientBuilder = baseClient.newBuilder()

        clientBuilder.addInterceptor(BasicLoggerInterceptor())

        interceptor.forEach {
            clientBuilder.addInterceptor(it)
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(serviceClass)
    }
}