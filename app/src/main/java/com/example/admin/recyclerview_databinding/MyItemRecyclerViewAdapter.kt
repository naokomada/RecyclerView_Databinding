package com.example.admin.recyclerview_databinding

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.admin.recyclerview_databinding.ItemFragment.OnListFragmentInteractionListener
import com.example.admin.recyclerview_databinding.Model.TextAndImagepath
import com.example.admin.recyclerview_databinding.R.id.parent
import com.example.admin.recyclerview_databinding.dummy.DummyContent.DummyItem
import android.graphics.Bitmap
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.graphics.BitmapFactory
import android.view.ContextMenu
import android.widget.ImageView
import java.io.File


/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(context: Context, val mValues: ObservableArrayList<TextAndImagepath>) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    val mContext = context
    init {
        mValues.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<TextAndImagepath>>() {

            override fun onItemRangeRemoved(sender: ObservableList<TextAndImagepath>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeRemoved(positionStart, itemCount)
            }

            override fun onItemRangeMoved(sender: ObservableList<TextAndImagepath>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
                notifyItemMoved(fromPosition, toPosition)
            }

            override fun onItemRangeChanged(sender: ObservableList<TextAndImagepath>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeChanged(positionStart, itemCount)
            }

            override fun onItemRangeInserted(sender: ObservableList<TextAndImagepath>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeInserted(positionStart, itemCount)
            }

            override fun onChanged(sender: ObservableList<TextAndImagepath>?) {
                notifyDataSetChanged()

            }
        })
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textAndPath = mValues.get(position)

        // データをセット
        holder.mItem = textAndPath
        holder.mTextView.text = textAndPath.text
        val file = File(mContext.getFilesDir(), "testfile.png")
        holder.mImage.setImageBitmap(BitmapFactory.decodeFile(file.getPath()))


        // /data/user/0/com.example.admin.recyclerview_databinding/files/testfile.png
        // 画像ロード処理
//        val bmp = loadImage(user.getIconUrl())
//        holder.getIcon().setImageBitmap(bmp)
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTextView: TextView
        lateinit var mImage: ImageView
        var mItem: TextAndImagepath? = null

        init {
            mTextView = mView.findViewById(R.id.text) as TextView
            mImage = mView.findViewById(R.id.image) as ImageView
        }

        fun getItem(): TextAndImagepath {
            return mItem!!
        }

        override fun toString(): String {
            return super.toString() + " '" + mItem.toString() + "'"
        }
    }
}
