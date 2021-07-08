package com.netlify.joblink.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.gson.annotations.SerializedName
import com.netlify.joblink.R
import com.netlify.joblink.api.RetrofitApi
import com.netlify.joblink.api.calls.PublishCall
import com.netlify.joblink.model.PublishModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var txtTitle: TextView
lateinit var txtDescription: TextView
lateinit var buttonPublish: Button
lateinit var buttonImage: ImageButton

class PublishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish)

        loadData()

        //setPublish()
    }

    private fun loadData() {
        txtTitle = findViewById(R.id.et_title)
        txtDescription = findViewById(R.id.description_publish)
        buttonPublish = findViewById(R.id.btn_publish)
    }

    private fun notifyUser(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun goToHome() {
        val homeActivity = Intent(this, HomeActivity::class.java)
        startActivity(homeActivity)
        finish()
    }

//    private fun setPublish() {
////        val userPublish = PublishModel(
////            title = txtTitle.text.toString(),
////            description = txtDescription.text.toString()
////
////        )
//
//        val retrofit = RetrofitApi.getRetrofit(PublishCall::class.java, this)
//        val call = retrofit.addPost()
//
//        call.enqueue(object : Callback<PublishModel> {
//
//            override fun onResponse(
//                call: Call<PublishModel>,
//                response: Response<PublishModel>
//            ) {
//
//                //val resposeBody = response.body()
//
//                if (response.isSuccessful()) {
//
//                    notifyUser("Publicação feita com sucesso!")
//                    goToHome()
//                } else {
//                    //Capturar o Erro e mostra para o usuario futuro
//                    notifyUser("Erro ao cadastrar")
//                }
//            }
//
//            override fun onFailure(call: Call<PublishModel>, t: Throwable) {
//
//                notifyUser("Ops! Não foi possivel fazer a conexão.")
//                Log.e("ERRO_CONEXAO", t.message.toString())
//            }
//        })
//    }


}