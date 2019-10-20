package com.example.flowerrecycleview

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private val items : MutableList<ClipData.Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerViewAdapter<Any?>>(R.id.flower_list)
        intiData()


        list.LayoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this,items)

    }

    private fun intiData(){
        val name = resources.getStringArray(R.array.flower_name)
        val image = resources.obtainTypedArray(R.array.flower_image)

        items.clear()

        for (i in name.indices){
            items.add(
                ClipData.Item(
                    name[i],
                    image.getResourceId(i, 0)))
        }

        image.recycle()

    }

}
