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
    import ph.edu.auf.japhetong.exampart2.adapters.NotesAdapter

    class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding
        private lateinit var adapter: NotesAdapter
        private var notes = mutableListOf<NoteModel>()
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
    
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
    
            // Load saved notes
            notes = PrefsHelper.loadNotes(this)
            adapter = NotesAdapter(notes)

            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = adapter
    
            // Search
            binding.etSearch.addTextChangedListener { text ->
                val filtered = notes.filter { it.title.contains(text.toString(), true) }
                adapter.filterList(filtered)
            }

            // Add Note
            binding.fabAdd.setOnClickListener {
                val dialog = AddNoteDialog { note ->
                    notes.add(note)
                    PrefsHelper.saveNotes(this, notes)
                    adapter.addNewItem(note)
                }
                dialog.show(supportFragmentManager, "AddNoteDialog")
            }

            // Explicit Intent
            binding.btnOpenAbout.setOnClickListener {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
    
            // Implicit Intent
            binding.btnOpenWebsite.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, "https://developer.android.com".toUri())
                startActivity(intent)
            }
        }
    }