package com.example.postrequests

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
Develop an Android application that gets two parameters as the input from the user, ‘Name’ and ‘Location’

Save these entries to the server with a POST request

Show the data that is saved in the server in a different activity (another screen)

API: https://dojo-recipes.herokuapp.com/test
 */
class MainActivity : AppCompatActivity() {

    lateinit var AddNewUser: Button
    lateinit var RV: RecyclerView
    lateinit var UsersList: ArrayList<UserItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Arrey
        UsersList = arrayListOf()
        GetAllUsers()

        //RecyclerView
        RV = findViewById(R.id.UsersRV)
        RV.layoutManager = LinearLayoutManager(this)

        //Button
        AddNewUser = findViewById<Button>(R.id.AddNewUserbtn)
        AddNewUser.setOnClickListener{
            startActivity(Intent(this, NewUserActivity::class.java))
            finish()
        }
    }//end oncreate

    fun GetAllUsers(){
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        val call: Call<Users?>? = apiInterface!!.GetUsers()
        call?.enqueue(object: Callback<Users?> {

            override fun onResponse(call: Call<Users?>, response: Response<Users?>) {
                UsersList = response.body()!!
                RV.adapter = UsersRecyclerViewAdapter(UsersList)
            }
            override fun onFailure(call: Call<Users?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ooops! Something went wrong",
                    Toast.LENGTH_SHORT).show()
                call.cancel()
            }
        })

    }

}//end class