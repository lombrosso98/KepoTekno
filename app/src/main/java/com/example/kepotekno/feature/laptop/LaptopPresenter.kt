package com.example.kepotekno.feature.laptop

import com.example.kepotekno.model.Laptop
import com.example.kepotekno.model.LaptopResponse
import com.example.kepotekno.model.Smartphone
import com.example.kepotekno.model.repository.RepoImpl
import com.google.firebase.database.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class LaptopPresenter(private val view: LaptopContract.View)
    : LaptopContract.Presenter {

    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val list: MutableList<Laptop> = mutableListOf()

    override fun getAllLaptop() {
        view.showLoading()
        var myRef: DatabaseReference = database.reference.child("laptop")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                list.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(Laptop::class.java)
                    list.add(data!!)
                }
                view.showAllLaptop(list)
                view.hideLoading()
            }

        })
    }

}