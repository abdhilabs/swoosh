package com.mriksani.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.mriksani.swoosh.Model.Player
import com.mriksani.swoosh.R
import com.mriksani.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player
    //Untuk Save Saat Rotate ke 1
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }
    //Untuk Save Saat Rotate ke 2
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onBeginnerClicked(view: View) {
        ballerBtn.isChecked = false

        player.skill = "Beginner"
    }

    fun onBallerClicked(view: View) {
        beginnerBtn.isChecked = false

        player.skill = "Baller"
    }

    fun onFinishClicked(view: View) {
        if (player.skill != "") {
            //Pindah Activity
            val finish = Intent(this, FinishActivity::class.java)
            finish.putExtra(EXTRA_PLAYER, player)
            startActivity(finish)
        } else {
            //Menampilkan Toast
            Toast.makeText(this, "Choose your skill.", Toast.LENGTH_SHORT).show()
        }
    }
}
