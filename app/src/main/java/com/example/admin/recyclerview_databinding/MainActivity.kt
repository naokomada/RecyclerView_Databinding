package com.example.admin.recyclerview_databinding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.recyclerview_databinding.dummy.DummyContent
import android.graphics.Bitmap
import android.R.attr.bitmap
import android.content.Context
import java.io.BufferedOutputStream
import android.graphics.BitmapFactory
import android.util.Log
import java.io.File


class MainActivity : AppCompatActivity(), ItemFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.sample)
        var bos: BufferedOutputStream? = null
        var tmp: Bitmap? = null
        try {
            bos = BufferedOutputStream(this.openFileOutput("testfile.png", Context.MODE_PRIVATE)) //他アプリアクセス不可
            tmp = bitmap.copy(Bitmap.Config.ARGB_8888, true)
            tmp!!.compress(Bitmap.CompressFormat.PNG, 100, bos)
        } finally {
            if (tmp != null) {
                tmp.recycle()
                tmp = null
            }
            var value: Any = try {
                bos!!.close()
            } catch (e: Exception) {
                //IOException, NullPointerException
            }
            val file = File(this.getFilesDir(), "testfile.png")
            Log.d("mydebug", file.toString())
        }

    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
