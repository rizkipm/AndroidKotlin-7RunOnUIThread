package superheroku.id.co.androidkotlin7runonuithread

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // start some dummy thread that is different from UI thread
        Thread(Runnable {
            // performing some dummy time taking operation
            var i=0;
            while(i<Int.MAX_VALUE){
                i++
            }

            // try to touch View of UI thread
            this@MainActivity.runOnUiThread(java.lang.Runnable {
                this.textview_msg.text = "Updated from other Thread"
            })
        }).start()
    }
}
