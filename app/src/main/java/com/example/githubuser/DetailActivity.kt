package com.example.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.githubuser.model.User

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvNamaReceived: TextView = findViewById(R.id.detail_nama)
        val tvUsernameReceived: TextView = findViewById(R.id.detail_username)
        val tvFollowerReceived: TextView = findViewById(R.id.detail_follower)
        val tvFollowingReceived: TextView = findViewById(R.id.detail_following)
        val tvCompanyReceived: TextView = findViewById(R.id.detail_company)
        val tvLocationReceived: TextView = findViewById(R.id.detail_location)
        val tvRepositoryReceived: TextView = findViewById(R.id.detail_repository)
        val tvGambarReceived: ImageView = findViewById(R.id.detail_gambar)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        tvNamaReceived.text = user.name.toString()
        tvUsernameReceived.text = user.dataUsername.toString()
        tvFollowerReceived.text = "Follower     : ${user.dataFollower.toString()}"
        tvFollowingReceived.text = "Following   : ${user.dataFollowing.toString()}"
        tvCompanyReceived.text = "Company    : ${user.dataCompany.toString()}"
        tvLocationReceived.text = "Location     : ${user.dataLocation.toString()}"
        tvRepositoryReceived.text = "Repository : ${user.dataRepository.toString()}"
        tvGambarReceived.setImageResource(user.photo)
    }
}
