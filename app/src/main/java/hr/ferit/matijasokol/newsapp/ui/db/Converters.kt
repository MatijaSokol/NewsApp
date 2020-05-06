package hr.ferit.matijasokol.newsapp.ui.db

import androidx.room.TypeConverter
import hr.ferit.matijasokol.newsapp.ui.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}