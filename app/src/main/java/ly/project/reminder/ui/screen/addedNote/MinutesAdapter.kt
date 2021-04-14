package ly.project.reminder.ui.screen.addedNote

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ly.project.reminder.R
import ly.project.reminder.databinding.TimeItemViewBinding
import ly.project.reminder.utils.dpToPx
import ly.project.reminder.utils.readRawResource
import ly.project.reminder.utils.toStringList
import ly.project.reminder.view.CenterZoomLayoutManager
import org.json.JSONObject

class MinutesAdapter(
    private val context: Context,

    ): RecyclerView.Adapter<MinutesAdapter.MinutesViewHolder>() {
    private val minutes: List<String>

    companion object {
        private  const  val  VIEWS_COUNT_TO_DISPLAY: Int = 3
        private const val  CONTAINER_TIMER_SIZE_HEIGHT = 150
    }

    init {
        val jsonObject = JSONObject(readRawResource(context = context , res =  R.raw.fa))
        minutes = jsonObject.getJSONArray("Minutes").toStringList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MinutesViewHolder {
        val binding =
            TimeItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root.layoutParams.height = dpToPx(CONTAINER_TIMER_SIZE_HEIGHT).toInt() / VIEWS_COUNT_TO_DISPLAY

        return MinutesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MinutesViewHolder, position: Int) = holder.bind(minutes[position])

    override fun getItemCount(): Int = minutes.size

    inner class  MinutesViewHolder(private val binding: TimeItemViewBinding): RecyclerView.ViewHolder(
        binding.root
    ){
        fun bind(minutes: String){
            binding.apply {
                timeTextVIew.text = minutes
            }

        }
    }
}