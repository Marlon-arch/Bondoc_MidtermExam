package ph.edu.auf.japhetong.exampart2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import ph.edu.auf.japhetong.exampart2.databinding.ActivityMainBinding
import ph.edu.auf.japhetong.exampart2.dialog.AddNoteDialog
import ph.edu.auf.japhetong.exampart2.helpers.PrefsHelper
import ph.edu.auf.japhetong.exampart2.models.NoteModel
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NotesAdpter
    private var notes = mutableListOf<NoteModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TODO("NOT IMPLEMENTED EXEMPTION")

        binding = ActivityMainBinding.inflate(layoutInflater)

        // Load saved notes
        notes = PrefsHelper.loadNotes(this)
        adapter = NotesAdapter(notes)

        // Search
        binding.etSearch.addTextChangedListener { text ->
            val filtered = notes.filter { it.title.contains(text.toString(), true) }
            adapter.filterList(filtered)
        }

        // Implicit Intent
        binding.btnOpenWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://developer.android.com".toUri())
            startActivity(intent)
        }
    }
}