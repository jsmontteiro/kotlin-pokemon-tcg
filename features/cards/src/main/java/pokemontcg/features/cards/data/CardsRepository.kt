package pokemontcg.features.cards.data

import pokemontcg.features.cards.model.Card

internal interface CardsRepository {
    suspend fun listCars(): List<Card>
}