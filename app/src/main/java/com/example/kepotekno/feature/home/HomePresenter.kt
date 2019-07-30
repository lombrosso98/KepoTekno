package com.example.kepotekno.feature.home

import android.util.Log
import com.example.kepotekno.model.*
import com.example.kepotekno.model.repository.RepoImpl
import com.google.firebase.database.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class HomePresenter(private val view: HomeContract.View): HomeContract.Presenter {

    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val listSmartphones: MutableList<Smartphone> = mutableListOf()
    private val listTablet: MutableList<Smartphone> = mutableListOf()
    private val listLaptop: MutableList<Laptop> = mutableListOf()
    private val listKamera: MutableList<Kamera> = mutableListOf()


    override fun getAllASmartphones() {
        var myRef: DatabaseReference = database.reference.child("smartphone")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listSmartphones.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(Smartphone::class.java)
                    listSmartphones.add(data!!)
                }
                view.showSmartphone(listSmartphones)
            }
        })
    }

    override fun getAllTablets() {
        var myRef: DatabaseReference = database.reference.child("tablet")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listTablet.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(Smartphone::class.java)
                    listTablet.add(data!!)
                }
                view.showTablet(listTablet)
            }
        })
    }

    override fun getAllLaptops() {
        var myRef: DatabaseReference = database.reference.child("laptop")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listLaptop.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(Laptop::class.java)
                    listLaptop.add(data!!)
                }
                view.showLaptop(listLaptop)
            }
        })
    }

    override fun getAllKamera() {
        var myRef: DatabaseReference = database.reference.child("kamera")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listKamera.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(Kamera::class.java)
                    listKamera.add(data!!)
                }
                view.showKamera(listKamera)
            }
        })
    }
}