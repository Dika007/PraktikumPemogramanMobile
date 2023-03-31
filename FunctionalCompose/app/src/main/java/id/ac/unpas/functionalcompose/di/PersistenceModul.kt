package id.ac.unpas.functionalcompose.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.ac.unpas.functionalcompose.persistences.AppDatabase
import id.ac.unpas.functionalcompose.persistences.SetoranSampahDao
import javax.inject.Singleton

/* Dika Sulaeman Akbar 203040163*/
@Module
@InstallIn(SingletonComponent::class)
object PersistenceModul {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "pengelolaan-sampah"
            )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideSetoranSampahDao(appDatabase: AppDatabase): SetoranSampahDao {
        return appDatabase.SetoranSampahDao()
    }
}