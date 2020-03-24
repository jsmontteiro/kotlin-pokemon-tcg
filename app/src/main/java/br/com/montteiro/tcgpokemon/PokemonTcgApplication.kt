package br.com.montteiro.tcgpokemon

import android.app.Application
import br.com.montteiro.tcgpokemon.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonTcgApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            this.androidContext(this@PokemonTcgApplication)
            modules(
                AppModule.getModules()
            )
        }
    }
}