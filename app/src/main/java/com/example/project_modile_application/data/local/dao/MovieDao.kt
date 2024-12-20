package com.example.project_modile_application.data.local.dao

import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.project_modile_application.data.local.entities.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE isWatched = 1")
    suspend fun getWatchedMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM movies WHERE kinopoiskId = :movieId")
    suspend fun deleteMovie(movieId: Int)

    @Query("SELECT EXISTS(SELECT 1 FROM movies WHERE kinopoiskId = :movieId)")
    suspend fun isMovieExists(movieId: Int): Boolean

    @Query("DELETE FROM movies WHERE isWatched = 1")
    suspend fun deleteAllWatchedMovies()

    @Query("SELECT * FROM movies WHERE kinopoiskId = :movieId")
    suspend fun getMovieById(movieId: Int): MovieEntity?

}
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE movies ADD COLUMN isWatched INTEGER NOT NULL DEFAULT 0")
    }
}