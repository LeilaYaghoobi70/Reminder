package ly.project.reminder.ui.screen.addedNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ly.project.reminder.R
import ly.project.reminder.databinding.AddedNoteFragmentBinding
import ly.project.reminder.ui.screen.homeFragment.HomeViewModelFactory
import ly.project.reminder.utils.getMonthName
import ly.project.reminder.utils.getTodayOfCalendar
import ly.project.reminder.utils.getWeekDayName
import ly.project.reminder.utils.mainCalendar
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
            toolbar.apply {

            }
            monthTextView.text = getMonthName(getTodayOfCalendar(mainCalendar))
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding =  null
    }
}