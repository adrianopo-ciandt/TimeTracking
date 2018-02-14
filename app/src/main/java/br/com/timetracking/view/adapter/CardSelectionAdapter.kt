package br.com.timetracking.view.adapter

import android.support.annotation.Nullable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.model.Card
import br.com.timetracking.R
import butterknife.BindView
import butterknife.ButterKnife

class CardSelectionAdapter(var mList: Boolean, var mCard: List<Card>) : RecyclerView.Adapter<CardSelectionAdapter.CardSelectionAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardSelectionAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_card, parent, false)

        return CardSelectionAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardSelectionAdapterViewHolder, position: Int) {
        val card = mCard[position]
        holder.tvHour?.text = card.Hour
    }

    override fun getItemCount(): Int {
        return if (mList) mCard.size else 1
    }

    class CardSelectionAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.tvHour) @Nullable @JvmField var tvHour: TextView? = null

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}