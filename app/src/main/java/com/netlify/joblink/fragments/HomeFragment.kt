package com.netlify.joblink.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auth0.android.jwt.JWT
import com.netlify.joblink.R
import com.netlify.joblink.adapter.PublicationAdapter
import com.netlify.joblink.api.RetrofitApi
import com.netlify.joblink.api.SessionManager
import com.netlify.joblink.api.calls.FeedCall
import com.netlify.joblink.model.PublicationModel
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var adapterPublication: PublicationAdapter
    lateinit var rvPublcation: RecyclerView
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadFeed()

    }

    private fun loadFeed() {

        rvPublcation = recycleViewPublcation
        adapterPublication = PublicationAdapter(activity)
        rvPublcation.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvPublcation.adapter = adapterPublication
        sessionManager = SessionManager(activity)

        var feeds: List<PublicationModel> = emptyList()

        val retrofit = activity?.let { RetrofitApi.getRetrofit(FeedCall::class.java, it) }
        val call = retrofit!!.getPublication()

        call.enqueue(object : Callback<List<PublicationModel>> {
            override fun onFailure(call: Call<List<PublicationModel>>, t: Throwable) {
                Log.e("XXXXXXXXXX HOME FRAG ERROR Teste", t.localizedMessage)
                Toast.makeText(activity, "Ops! falha na conexão.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<PublicationModel>>,
                response: Response<List<PublicationModel>>
            ) {
                if (sessionManager.fetchAuthToken() != null) {

                    Log.i("Teste", response.code().toString())
                    Log.i(
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX HomeFragment Teste",
                        response.body().toString()
                    )

                    if (response.code() == 200) {
                        feeds = response.body()!!
                        adapterPublication.updateListPublication(feeds)
                    } else {
                        val jwt = JWT(sessionManager.fetchAuthToken().toString())

                        Log.i("TESTE HOMEFRAG", jwt.isExpired(0).toString())

                    }

                }
            }
        })
    }
}