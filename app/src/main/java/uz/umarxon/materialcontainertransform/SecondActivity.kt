package uz.umarxon.materialcontainertransform

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        config()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    private fun config() {
        val content = findViewById<View>(android.R.id.content)
        content.transitionName = "go"
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())

        with(MaterialContainerTransform().apply {
            addTarget(content)
            duration = 500
        } ){
            window.sharedElementEnterTransition = this
            window.sharedElementReenterTransition = this
        }
    }
}