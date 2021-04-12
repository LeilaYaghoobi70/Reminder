package ly.project.reminder.ui.screen.homeFragment

import GenericSavedStateViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import io.github.persiancalendar.calendar.AbstractDate

import ly.project.reminder.R
import ly.project.reminder.databinding.HomeFragmentBinding
import ly.project.reminder.utils.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    val viewModel: HomeViewModel by viewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, this)
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
            dayTextView.text = getWeekDayName(getTodayOfCalendar(mainCalendar).dayOfMonth)

            monthShamsiTextView.text = getMonthName(getTodayOfCalendar(mainCalendar))
            dayShamsiTextView.text = getTodayOfCalendar(mainCalendar).dayOfMonth.toString()
            yearShamsiTextView.text = getTodayOfCalendar(mainCalendar).year.toString()

            monthGeorgianTextView.text = getMonthName(getTodayOfCalendar(CalendarType.GREGORIAN))
            dayGeorgianTextView.text =getTodayOfCalendar(CalendarType.GREGORIAN).dayOfMonth.toString()
            yearGeorgianTextView.text = getTodayOfCalendar(CalendarType.GREGORIAN).year.toString()


            calenderPicker.apply {

                onMonthSelected =
                    fun() {
                        selectedMonth.let { monthTextView.text = getMonthName(it) }
                    }
                onDayClicked = {
                    var date = getDateFromJdnOfCalendar(mainCalendar, it)
                    dayShamsiTextView.text = date.dayOfMonth.toString()
                    monthShamsiTextView.text = getMonthName(date)
                    yearShamsiTextView.text =  date.year.toString()

                     date = getDateFromJdnOfCalendar(CalendarType.GREGORIAN, it)
                    dayGeorgianTextView.text = date.dayOfMonth.toString()
                    monthGeorgianTextView.text =getMonthName(date)
                    yearGeorgianTextView.text = date.year.toString()

                }
                addButton.setOnClickListener {
                    NavHostFragment.findNavController(this@HomeFragment).navigate(R.id.action_homeFragment_to_addedNoteFragment)
                }

            }

        }
        return binding?.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}