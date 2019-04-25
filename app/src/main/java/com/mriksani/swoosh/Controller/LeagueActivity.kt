package com.mriksani.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.mriksani.swoosh.Model.Player
import com.mriksani.swoosh.R
import com.mriksani.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onMensClicked (view : View) {
        womenBtn.isChecked = false
        coedBtn.isChecked = false

        player.league = "Mens"
    }

    fun onWomensClicked (view: View) {
        mensBtn.isChecked = false
        coedBtn.isChecked = false

        player.league = "Womens"
    }

    fun onCoedClicked (view: View) {
        mensBtn.isChecked = false
        womenBtn.isChecked = false

        player.league = "Co-ed"
    }

    fun leagueNextClicked (view : View){
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Choose your league.",Toast.LENGTH_SHORT).show()
        }
    }
}
