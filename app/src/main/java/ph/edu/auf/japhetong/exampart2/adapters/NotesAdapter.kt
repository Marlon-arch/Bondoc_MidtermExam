package ph.edu.auf.japhetong.exampart2.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ph.edu.auf.japhetong.exampart2.models.NoteModel

class NotesAdapter(private var notes: MutableList<NoteModel>) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(val binding: DialogAddNoteBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = DialogAddNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

    }

    override fun getItemCount() = 0

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filtered: List<NoteModel>) {

    }

    fun addNewItem(note: NoteModel){
        notifyItemInserted(notes.size -1)
    }
}