package br.com.montteiro.tcgpokemon.di

import pokemontcg.features.cards.di.CardsModule

object AppModule {
    fun getModules() = listOf(
        *CardsModule.getModules()
    )
}