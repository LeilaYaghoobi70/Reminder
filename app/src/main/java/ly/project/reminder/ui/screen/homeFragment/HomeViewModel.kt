package ly.project.reminder.ui.screen.homeFragment

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ly.project.reminder.di.ViewModelAssistedFactory
import javax.inject.Inject

class HomeViewModel constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

}

class  HomeViewModelFactory @Inject constructor(): ViewModelAssistedFactory<HomeViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): HomeViewModel =
       HomeViewModel(savedStateHandle)

}