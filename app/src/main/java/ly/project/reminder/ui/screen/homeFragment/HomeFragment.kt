package ly.project.reminder.ui.screen.homeFragment

import GenericSavedStateViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import io.github.persiancalendar.calendar.AbstractDate

import ly.project.reminder.R
import ly.project.reminder.databinding.HomeFragmentBinding
import ly.project.reminder.utils.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    val viewModel: HomeViewModel by viewModels {
        GenericSavedStateViewModelFactory(
            viewModelFactory,
            this
        )
    }

    private var binding: HomeFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false).apply {
            toolbar.apply {
                setLeftIcon(R.drawable.ic_home, null)
                setRightIcon(R.drawable.ic_setting, null)
            }

            calenderPicker.apply {
                onMonthSelected =
                    fun() { selectedMonth.let { monthTextView.text = getMonthName(it) } }
            }

            setDate()
        }
        return binding?.root
    }

    private fun HomeFragmentBinding.setDate() {
        dayTextView.text = getWeekDayName(getTodayOfCalendar(mainCalendar).dayOfMonth)
        (" ${getTodayOfCalendar(mainCalendar).dayOfMonth}  " +
                "${getMonthName(getTodayOfCalendar(mainCalendar))}${
                    "  ${getTodayOfCalendar(mainCalendar).year}"
                }").also { shamsiTextView.text = it }

        (" ${getTodayOfCalendar(CalendarType.GREGORIAN).dayOfMonth}  " +
                "${getMonthName(getTodayOfCalendar(CalendarType.GREGORIAN))}${
                    "  ${getTodayOfCalendar(CalendarType.GREGORIAN).year}"
                }").also { gregorianDateTextView.text = it }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}