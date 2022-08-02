package com.juice.timetable.ui.tools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.juice.timetable.R
import es.dmoral.toasty.Toasty

class ToolsRecycleViewAdapter : RecyclerView.Adapter<ToolsRecycleViewAdapter.ToolsViewHolder>() {
    var toolList: List<Tool> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView: View = layoutInflater.inflate(R.layout.cell_tool_item, parent, false)
        return ToolsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ToolsViewHolder, position: Int) {
        val tool = toolList[position]
        holder.toolTextView.text = tool.toolName
        holder.toolImageView.setImageResource(tool.toolImageId)
        holder.itemView.setOnClickListener { v ->
            val navController = findNavController(v)
            if (tool.toolName == holder.itemView.resources.getString(R.string.menu_grade)) {
//                navController.navigate(R.id.action_nav_tools_to_nav_grade)
            } else if (tool.toolName == holder.itemView.resources.getString(R.string.menu_exam)) {
//                navController.navigate(R.id.action_nav_tools_to_nav_exam)
            } else if (tool.toolName == holder.itemView.resources.getString(R.string.menu_expect)) {
                Toasty.info(v.context, "(๑•̀ㅂ•́)و✧", Toasty.LENGTH_SHORT, false).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return toolList.size
    }

    class ToolsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var toolImageView: ImageView
        var toolTextView: TextView

        init {
            toolImageView = itemView.findViewById(R.id.toolImageView)
            toolTextView = itemView.findViewById(R.id.toolTextView)
        }
    }
}