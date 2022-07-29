package uz.umarxon.materialcontainertransform

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.UserHandle
import android.util.Pair
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import uz.umarxon.materialcontainertransform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        config()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            img.also { i->
                btn.setOnClickListener { i2 ->
                    Intent(this@MainActivity, SecondActivity::class.java).also { intent ->
                        sceneTransition(i2,i).apply {
                            startActivity(intent, this.toBundle())
                        }
                    }
                }
            }
        }
    }

    private fun config() {
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
    }
    private fun sceneTransition(i: View,i2:View):ActivityOptions{
        return ActivityOptions.makeSceneTransitionAnimation(this, Pair.create( i, "go"), Pair.create(i2, "t1"))
    }
}