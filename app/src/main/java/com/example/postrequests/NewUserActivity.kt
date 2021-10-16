package com.example.postrequests

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewUserActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var loc: EditText
    lateinit var Submitbtn: Button
    lateinit var Viewbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)
        name = findViewById<EditText>(R.id.NameET)
        loc = findViewById<EditText>(R.id.LocationET)

        Submitbtn = findViewById<Button>(R.id.Submitbtn)
        Viewbtn = findViewById<Button>(R.id.ViewUsersbtn)

        Submitbtn.setOnClickListener {
            AddUser(UserItem(name.text.toString(), loc.text.toString()))
        }

        Viewbtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }//end oncreate

    fun AddUser(user: UserItem){

        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        apiInterface!!.PostUsers(user)?.enqueue(object: Callback<UserItem?> {

            override fun onResponse(call: Call<UserItem?>, response: Response<UserItem?>) {
                Toast.makeText(this@NewUserActivity, "User added",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<UserItem?>, t: Throwable) {
                Toast.makeText(this@NewUserActivity, "Ooops! Something went wrong",
                    Toast.LENGTH_SHORT).show()
                call.cancel()
            }

        })

    }
}//end class