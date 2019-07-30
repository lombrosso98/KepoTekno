package com.example.kepotekno.feature.dslr

import com.example.kepotekno.model.Kamera
import com.example.kepotekno.model.KameraResponse
import com.example.kepotekno.model.Laptop
import com.example.kepotekno.model.SmartphoneResponse
import com.example.kepotekno.model.repository.RepoImpl
import com.google.firebase.database.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class DslrPresenter(private val view: DslrContract.View)
    : DslrContract.Presenter {

    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val list: MutableList<Kamera> = mutableListOf()

    override fun getAllKamera() {
        view.showLoading()
        var myRef: DatabaseReference = database.reference.child("kamera")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                list.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(Kamera::class.java)
                    list.add(data!!)
                }
                view.showAllKamera(list)
                view.hideLoading()
            }

        })
    }
}