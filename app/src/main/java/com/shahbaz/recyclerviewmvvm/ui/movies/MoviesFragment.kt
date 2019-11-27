package com.shahbaz.recyclerviewmvvm.ui.movies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shahbaz.recyclerviewmvvm.R
import com.shahbaz.recyclerviewmvvm.data.models.Movies
import com.shahbaz.recyclerviewmvvm.data.network.MoviesApi
import com.shahbaz.recyclerviewmvvm.data.repositories.MoviesRepositroy
import kotlinx.android.synthetic.main.movies_fragment.*


class MoviesFragment : Fragment(), RecyclerviewItemClickListener {


    private lateinit var viewModel: MoviesViewModel

    private lateinit var factory: MoviesViewmOdelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = MoviesApi()

        val repositroy =
            MoviesRepositroy(api)

        factory =
            MoviesViewmOdelFactory(
                repositroy
            )

        viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)

        viewModel.getMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            moviesRecyclerview.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    MoviesAdapter(movies,this)
            }
        })

    }

    override fun onRecyclerviewItemClick(view: View, movies: Movies) {
        when (view.id) {
            R.id.button_book -> {
                Toast.makeText(requireContext(), "Book button clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.layout_like -> {
                Toast.makeText(requireContext(), "Like Layout clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
