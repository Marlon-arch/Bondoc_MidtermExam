package ph.edu.auf.japhetong.exampart2.helpers

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ph.edu.auf.japhetong.exampart2.models.NoteModel

object PrefsHelper {
    private const val PREF_NAME = "notes_prefs"
    private const val KEY_NOTES = "notes_list"

    fun saveNotes(context: Context, notes: List<NoteModel>) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = Gson().toJson(notes)
    }

    fun loadNotes(context: Context): MutableList<NoteModel> {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = ""
        return if (json != null) {
            val type = object : TypeToken<List<NoteModel>>() {}.type
            Gson().fromJson(json, type)
        } else mutableListOf()
    }
}
