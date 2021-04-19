package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel1Binding
import ph.edu.benilde.matchingkitties.viewModels.GameViewModel

class Level1Activity: AppCompatActivity(){
    private lateinit var binding: ActivityLevel1Binding
    private val imgButtons by lazy { listOf(
            binding.imgButton0,
            binding.imgButton1,
            binding.imgButton2,
            binding.imgButton3,
            binding.imgButton4,
            binding.imgButton5
        )
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        val gameModel by viewModels<GameViewModel>()
        gameModel.startGame()
    }

    fun refreshGrid() {
        val gameModel by viewModels<GameViewModel>()
        val gameRoundImages = gameModel.gameRoundImages.value!!
        val gameRoundImageStatus = gameModel.gameRoundImageStatus.value!!

        for ( i in imgButtons.indices) {
            if(gameRoundImageStatus[i])
                imgButtons[i].setBackgroundResource(gameRoundImages[i])
            else
                imgButtons[i].setBackgroundResource(R.drawable.kitty_00)
        }
    }
}
