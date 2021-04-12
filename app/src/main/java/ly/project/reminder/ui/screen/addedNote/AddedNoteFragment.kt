package ly.project.reminder.ui.screen.addedNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ly.project.reminder.databinding.AddedNoteFragmentBinding
import ly.project.reminder.ui.screen.homeFragment.HomeViewModelFactory
import javax.inject.Inject

class AddedNoteFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory
    private var binding : AddedNoteFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddedNoteFragmentBinding.inflate(inflater,container, false).apply {

        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding =  null
    }
}