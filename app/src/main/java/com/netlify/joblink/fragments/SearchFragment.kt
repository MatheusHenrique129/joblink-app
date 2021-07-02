package com.netlify.joblink.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auth0.android.jwt.JWT
import com.netlify.joblink.R
import com.netlify.joblink.adapter.ProfessionAdapter
import com.netlify.joblink.adapter.PublicationAdapter
import com.netlify.joblink.api.RetrofitApi
import com.netlify.joblink.api.SessionManager
import com.netlify.joblink.api.calls.FeedCall
import com.netlify.joblink.api.calls.ProfessionCall
import com.netlify.joblink.model.ProfessionModel
import com.netlify.joblink.model.PublicationModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private lateinit var rvCategory: RecyclerView
    private lateinit var adapterProfission: ProfessionAdapter
    private lateinit var profileFragment: ProfileFragment

    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startRecycleView()

    }

    private fun notifyUser(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    private fun startRecycleView() {
        rvCategory = recycle_view_search
        adapterProfission = ProfessionAdapter(activity)
        rvCategory.layoutManager =
            GridLayoutManager(activity, 2, LinearLayoutManager.VERTICAL, false)
        rvCategory.adapter = adapterProfission
        sessionManager = SessionManager(activity)

        var professions: List<ProfessionModel>

        val retrofit = activity?.let { RetrofitApi.getRetrofit(ProfessionCall::class.java, it) }
        val call = retrofit!!.getProfession()

        call.enqueue(object : Callback<List<ProfessionModel>> {
            override fun onFailure(call: Call<List<ProfessionModel>>, t: Throwable) {
                notifyUser("Ops! falha na conexão")
            }

            override fun onResponse(
                call: Call<List<ProfessionModel>>,
                response: Response<List<ProfessionModel>>
            ) {

                if (sessionManager.fethAuthToken() != null) {

                    Log.i("Teste", response.code().toString())
                    Log.i(
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX HomeFragment Teste",
                        response.body().toString()
                    )

                    if (response.code() == 200) {
                        professions = response.body()!!
                        adapterProfission.updateListPublication(professions)
                    } else {
                        val jwt = JWT(sessionManager.fethAuthToken().toString())

                        Log.i("TESTE HOMEFRAG", jwt.isExpired(0).toString())

                    }

                }

            }

        })
    }
}