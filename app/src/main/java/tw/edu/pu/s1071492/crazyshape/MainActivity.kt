package tw.edu.pu.s1071492.crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*

@GlideModule
public final class MyAppGlideModule : AppGlideModule()


class MainActivity : AppCompatActivity() ,GestureDetector.OnGestureListener, View.OnTouchListener{
    lateinit var gDetector: GestureDetector


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img: ImageView = findViewById(R.id.imgTitle)
        GlideApp.with(this)
            .load(R.drawable.cover)
            .circleCrop()
            .override(800, 600)
            .into(img)


        gDetector = GestureDetector(this, this)
        imgNext.setOnTouchListener(this)
        Toast.makeText(this, "作者:陳昱丰", Toast.LENGTH_SHORT).show();

    }
    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
        gDetector.onTouchEvent(event)
        return true

    }


    override fun onDown(p0: MotionEvent?): Boolean {

        return true

    }

    override fun onShowPress(p0: MotionEvent?) {

    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        var X:Int = (1..4).random()
        if(X == 1){val img: ImageView = findViewById(R.id.imgNext)
            img.setImageResource(R.drawable.circle)
        }
        else if(X==2){
            val img: ImageView = findViewById(R.id.imgNext)
            img.setImageResource(R.drawable.square)
        }
        else if(X==3){
            val img: ImageView = findViewById(R.id.imgNext)
            img.setImageResource(R.drawable.star)
        }
        else if(X==4){
            val img: ImageView = findViewById(R.id.imgNext)
            img.setImageResource(R.drawable.triangle)
        }
        return true}

    override fun onScroll(e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onLongPress(p0: MotionEvent?) {
        val img: ImageView = findViewById(R.id.imgNext)
        if(img.equals("circle"))
        intent = Intent(this@MainActivity, GameActivity::class.java)
        startActivity(intent)
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        TODO("Not yet implemented")
    }




}