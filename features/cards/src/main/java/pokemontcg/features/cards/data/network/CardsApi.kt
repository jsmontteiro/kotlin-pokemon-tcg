package pokemontcg.features.cards.data.network

import pokemontcg.features.cards.data.network.schemas.ListCardResponseSchema
import retrofit2.Response
import retrofit2.http.GET

internal interface CardsApi {

    @GET("cards")
    suspend fun listCards(): Response<ListCardResponseSchema>
}