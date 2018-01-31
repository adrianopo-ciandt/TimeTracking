package br.com.timetracking.view.ui.home.fragments

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.model.Card
import br.com.timetracking.R
import br.com.timetracking.view.adapter.CardSelectionAdapter
import br.com.timetracking.view.ui.base.BaseFragment
import java.util.*

class MarkTimeFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view : View? = inflater?.inflate(R.layout.fragment_mark_time, container, false)
        recyclerView = view?.findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.setHasFixedSize(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mCard = Card()
        mCard.Hour = getToday()
        val listCard = ArrayList<Card>()
        listCard.add(mCard)
        recyclerView?.adapter = CardSelectionAdapter(false, listCard)
    }
}