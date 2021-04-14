package ly.project.reminder.ui.screen.addedNote

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ly.project.reminder.R
import ly.project.reminder.databinding.TimeItemViewBinding
import ly.project.reminder.utils.dpToPx

import ly.project.reminder.utils.readRawResource
import ly.project.reminder.utils.toStringList
import org.json.JSONObject

class HoursAdapter constructor(private val context: Context) :
    RecyclerView.Adapter<HoursAdapter.HoursViewHolder>() {
    private var hours: List<String>

    companion object {
        private  const  val  VIEWS_COUNT_TO_DISPLAY: Int = 3
        private const val  CONTAINER_TIMER_SIZE_HEIGHT = 150
    }

    init {
        val jsonObject = JSONObject(readRawResource(context = context, R.raw.fa))
        hours = jsonObject.getJSONArray("Hours").toStringList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
        val binding =
            TimeItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root.layoutParams.height = dpToPx(CONTAINER_TIMER_SIZE_HEIGHT).toInt() / VIEWS_COUNT_TO_DISPLAY

        return HoursViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) =
        holder.bind(hours[position])

    override fun getItemCount(): Int = hours.size

    inner class HoursViewHolder(private val binding: TimeItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hours: String) {
            binding.timeTextVIew.text = hours
        }
    }
}
