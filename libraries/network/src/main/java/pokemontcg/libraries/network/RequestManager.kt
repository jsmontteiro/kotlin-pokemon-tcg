package pokemontcg.libraries.network

import android.util.Log
import mobile.libraries.network.exceptions.ServerErrorException
import pokemontcg.libraries.network.exceptions.MyNetworkException
import retrofit2.Response

object RequestManager {
    suspend fun <T> requestFromApi(
        request: (suspend () -> Response<T>)
    ): T? {
        try {
            val response = request()
            if (response.isSuccessful) {
                //aqui pode acontecer de ter algum crash relacionado à conversão de json
                return response.body()
            } else {
                val message = response.message()

                throw when (response.code()) {
                    500 -> ServerErrorException(message)
                    else -> MyNetworkException(message)
                }
            }

        } catch (e: Exception) {
            Log.e("RequestManager", "Request error: ${e.message}", e)
            throw e
        }
    }
}