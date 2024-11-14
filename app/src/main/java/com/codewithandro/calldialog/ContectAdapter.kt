package com.codewithandro.kotlinseries

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.codewithandro.calldialog.R

class ContectAdapter (val Context :Activity,val arrayList: ArrayList<contectData>):
ArrayAdapter<contectData>(Context,R.layout.neweachrow, arrayList)//context,xml row ,arrayList
{
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //create infilter
        val inflater = LayoutInflater.from(Context)//layout inflater pass the mainActivity Context
        //creaet view
        val view=inflater.inflate(R.layout.neweachrow,null)

        //featch the view in xml -> using view

        val conImg = view.findViewById<ImageView>(R.id.conImg)
        val conName =  view.findViewById<TextView>(R.id.conName)
        val conNum =  view.findViewById<TextView>(R.id.conNum)
        val conTimeDate =  view.findViewById<TextView>(R.id.conTimeDate)

        //position change the increass by 1
        //assign the position

        conImg.setImageResource(arrayList[position].conImg)
        conName.text = arrayList[position].conName
        conNum.text = arrayList[position].conNum
        conTimeDate.text = arrayList[position].conTimeDate

        return view
        //ready Adepter
    }
}