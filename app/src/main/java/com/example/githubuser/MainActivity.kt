package com.example.githubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.adapter.CardViewUserAdapter
import com.example.githubuser.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var user = arrayListOf<User>()
    private lateinit var rvUser: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)


        prepare()
        addItem()

        showRecyclerCardView()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_info,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_info -> {
                val moveToAbout = Intent(this, AboutActivity::class.java)
                startActivity(moveToAbout)

            }
        }
    }

    private fun showRecyclerCardView() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val cardViewHardwareAdapter = CardViewUserAdapter(user)
        rvUser.adapter = cardViewHardwareAdapter
    }

    private fun addItem(){
        for(position in dataName.indices) {
            val users = User(
                dataName[position],
                dataUsername[position],
                dataFollower[position],
                dataFollowing[position],
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataPhoto.getResourceId(position,-1)
            )
            user.add(users)
        }
    }

    private fun prepare(){
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)

    }

}
