package ph.edu.auf.japhetong.exampart2.dialog

import android.app.AlertDialog
import android.app.Dialog
import androidx.fragment.app.DialogFragment
import android.os.Bundle

import ph.edu.auf.japhetong.exampart2.databinding.DialogAddNoteBinding
import ph.edu.auf.japhetong.exampart2.models.NoteModel

class AddNoteDialog(private val onNoteAdded: (NoteModel) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogAddNoteBinding.inflate(layoutInflater)

        return AlertDialog.Builder(requireContext())
            .setTitle("Add Note")
            .setView(binding.root)
            .setPositiveButton("Add") { _, _ ->
                val title = binding.etTitle.text.toString().trim()
                val content = binding.etContent.text.toString().trim()
                if (title.isNotEmpty() && content.isNotEmpty()) {
                    onNoteAdded(NoteModel(title, content))
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
    }
}