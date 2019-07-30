package com.example.kepotekno.feature.tablet

import com.example.kepotekno.model.Smartphone
import com.example.kepotekno.model.SmartphoneResponse
import com.example.kepotekno.model.repository.RepoImpl
import com.google.firebase.database.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class TabletPresenter(private val view: TabletContract.View)
    : TabletContract.Presenter {

    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val list: MutableList<Smartphone> = mutableListOf()

    override fun getAllTablet() {
        view.showLoading()
        var myRef: DatabaseReference = database.reference.child("tablet")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                list.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(Smartphone::class.java)
                    list.add(data!!)
                }
                view.showAllTablet(list)
                view.hideLoading()
            }

        })
    }
}