package com.codewithandro.kotlinseries

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import android.Manifest
import android.widget.TextView
import com.codewithandro.calldialog.R


class CallLogActivity : AppCompatActivity() {

    //initlize arrayList
   lateinit var ConArrayList : ArrayList<contectData>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_call_log)

        //create data
        val conImg = intArrayOf(
            R.drawable.c1,
            R.drawable.c2,
            R.drawable.c3,
            R.drawable.c4,
            R.drawable.c5,
            R.drawable.c6,
            R.drawable.c7,
            R.drawable.c8,
            R.drawable.c9,
            R.drawable.c10,
            R.drawable.c11,
            R.drawable.c12,
            R.drawable.c13,
            R.drawable.c14,
            R.drawable.c15,
            R.drawable.c16,
            R.drawable.c17,
            R.drawable.c18,
            R.drawable.c19,
            R.drawable.c20,
            R.drawable.c21,
            R.drawable.c22,
            R.drawable.c23
        )

        val conName = arrayOf(
            "Shubham Jaybhaye(Brother)",
            "Omkar Sonawane (Robotics Dept)",
            "Rupesh Lokhande (Friend)",
            "Rameshwar Markad (PSI)",
            "Uttereshwar Dongre",
            "Abhay Gite (Civil Engineer)",
            "Kuldeep Jaybhaye (Bro)",
            "Om Kularkar",
            "Vedant Ghuge",
            "Prajwal Ingle",
            "Om Thakre",
            "Vikas",
            "Akhilesh Sharma",
            "Yash Ramteke",
            "Rushi Misal",
            "Auysh Rohilkar",
            "Nakul Rajurkar(AI Devloper)",
            "Yash Karli",
            "Akash Pawar (Full Stack Developer)",
            "Rahul Kumar (Android Developer)",
            "Ankit Vadiya (AI Developer)",
            "Aman Sharma (System Analyst)",
            "Raj Varma (Collage Friend)"
        )

        val conNum = arrayOf(
            "+91 9450688909",
            "+91 7822688900",
            "+91 9065068908",
            "+91 9750688986",
            "+91 9409537712",
            "+91 9009537744",
            "+91 7409537732",
            "+91 9709537785",
            "+91 9409677888",
            "+91 7609677888",
            "+91 91150688909",
            "+91 7722688900",
            "+91 9565068908",
            "+91 9350688986",
            "+91 7709537712",
            "+91 8709537744",
            "+91 7209537732",
            "+91 9809537785",
            "+91 9209677888",
            "+91 9409677845",
            "+91 7109677348",
            "+91 8709677867",
            "+91 9009676755"
        )

        val conTimeDate = arrayOf(
            "Oct 19 Rang 2 times",
            "Oct 14 Rang 7 times",
            "Aug 9 Rang 3 times",
            "Mar 21 Rang 1 times",
            "Sep 18 Rang 6 times",
            "Oct 19 Rang 2 times",
            "Oct 14 Rang 4 times",
            "Aug 9 Rang 9 times",
            "Mar 21 Rang 2 times",
            "Sep 18 Rang 3 times",
            "Oct 19 Rang 1 times",
            "Oct 14 Rang 2 times",
            "Aug 9 Rang 7 times",
            "Mar 21 Rang 2 times",
            "Sep 18 Rang 9 times",
            "Oct 19 Rang 10 times",
            "Oct 14 Rang 1 times",
            "Aug 9 Rang 3 times",
            "Mar 21 Rang 2 times",
            "Sep 18 Rang 4 times",
            "Oct 19 Rang 5 times",
            "Oct 14 Rang 2 times",
            "Aug 9 Rang 3 times"
        )

        //intilaze the  array
        ConArrayList = ArrayList()

        //push data into contectData Class

        for (eachInx in conName.indices) {

            val conData = contectData(
                conImg[eachInx],
                conName[eachInx],
                conNum[eachInx],
                conTimeDate[eachInx]
            )

            //add ConArrayList -> contect Data
            ConArrayList.add(conData)
        }
        //data add ho gaya

        //find list View
        val conListView = findViewById<ListView>(R.id.conListView)
        //isClickable
        conListView.isClickable = true

        //create own adapter------->
        conListView.adapter = ContectAdapter(this, ConArrayList)//context ,dataArray
        //calling
         conListView.setOnItemClickListener { parent, view, position, id ->

            // Access the specific view (root view of the item clicked)
            val clickedView = view

            // Find specific views within the clicked item layout
            val conNum: TextView = clickedView.findViewById(R.id.conNum)

            // Now you can access the content or properties of these view
            val contactNumber = conNum.text.toString()

            val callIntent = Intent(Intent.ACTION_CALL )
            callIntent.data = Uri.parse("tel:$contactNumber")

            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted, start the call
                startActivity(callIntent)
            } else {
                // Permission is not granted, request it
            }
        }
    }
}
