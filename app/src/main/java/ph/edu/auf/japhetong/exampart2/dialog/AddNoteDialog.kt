package ph.edu.auf.japhetong.exampart2.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle

import ph.edu.auf.japhetong.exampart2.databinding.DialogAddNoteBinding
import ph.edu.auf.japhetong.exampart2.models.NoteModel

class AddNoteDialog(private val onNoteAdded: (NoteModel) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogAddNoteBinding.inflate(layoutInflater)

        return AlertDialog.Builder(requireContext())
            .setTitle("Add Note")
            .setPositiveButton("Add") { _, _ ->

            }
            .setNegativeButton("Cancel", null)
            .create()
    }
}