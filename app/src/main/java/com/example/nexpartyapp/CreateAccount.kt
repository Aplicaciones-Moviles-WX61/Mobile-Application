package com.example.nexpartyapp

import Beans.Event
import Beans.User
import Database.AppDatabase
import Interface.EventDao
import Interface.UserDao
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CreateAccount : AppCompatActivity() {

    var txtBirthday: EditText? = null
    var txtPassword: EditText? = null
    var txtEmail: EditText? = null
    var txtName: EditText? = null

    var txtUs: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        txtBirthday = findViewById(R.id.txtBirthday)
        txtPassword = findViewById(R.id.txtPassword)
        txtEmail = findViewById(R.id.txtEmail)
        txtName = findViewById(R.id.txtName)

        txtUs = findViewById(R.id.txtUs)

        var listUsers: List<User>? = null

        val txtLogin = findViewById<TextView>(R.id.txtLogin)
        val btnCreateAccount = findViewById<Button>(R.id.btnCreateAccount)

        val db: AppDatabase? = AppDatabase.getInstance(this.applicationContext)
        val dao: UserDao? = db!!.userDao()

        txtLogin.setOnClickListener {
            val activate = Intent(this, Login::class.java)
            startActivity(activate)
        }

        btnCreateAccount.setOnClickListener {
            val activate = Intent(this, com.example.nexpartyapp.CreateEvent::class.java)
            val account = User(txtName!!.text.toString(), txtEmail!!.text.toString(), txtPassword!!.text.toString(),txtBirthday!!.text.toString() )

            if (dao != null){
                dao.insert(account)
            }

            txtName!!.setText(null)
            txtEmail!!.setText(null)
            txtPassword!!.setText(null)
            txtBirthday!!.setText(null)

            //event list
            listUsers = dao!!.userList() as List<User>?
            val total = listUsers!!.size
            txtUs!!.setText("total users: $total\n")
            for(i in listUsers!!.indices){
                val u = listUsers!![i]
                txtUs!!.append(
                    """
                        User name: ${u!!.name}
                        User email: ${u!!.email}
                        User password: ${u!!.password}
                        User birthday: ${u!!.birthday}
                        
                    """.trimIndent()
                )
            }

            startActivity(activate)
        }








    }
}