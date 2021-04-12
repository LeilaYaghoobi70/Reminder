package ly.project.reminder.ui.screen.addedNote

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ly.project.reminder.di.ViewModelAssistedFactory
import javax.inject.Inject

class AddedNoteViewModel: ViewModel() {
}

class AddedViewModelFactory @Inject constructor(): ViewModelAssistedFactory<AddedNoteViewModel>{
    override fun create(savedStateHandle: SavedStateHandle): AddedNoteViewModel {
        TODO("Not yet implemented")
    }

}