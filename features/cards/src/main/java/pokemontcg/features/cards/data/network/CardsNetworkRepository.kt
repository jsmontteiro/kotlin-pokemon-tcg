package pokemontcg.features.cards.data.network

import pokemontcg.features.cards.data.CardsRepository
import pokemontcg.features.cards.model.Card
import pokemontcg.libraries.network.ApiClientBuilder
import pokemontcg.libraries.network.RequestManager

internal class CardsNetworkRepository(private val api: CardsApi) : CardsRepository {
    override suspend fun listCars(): List<Card> {

        val api = ApiClientBuilder.createServiceApi(CardsApi::class.java)
        val apiResponse = RequestManager.requestFromApi { api.listCards() }

        val cards = apiResponse?.cards?.map {
            Card(
                id = it.id,
                name = it.name,
                imageUrl = it.imageUrl
            )
        }

        return cards ?: emptyList()
    }

}