package com.example.admin.recyclerview_databinding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.recyclerview_databinding.dummy.DummyContent

class MainActivity : AppCompatActivity(), ItemFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
