package com.example.tc.navigationtest.ui.main

import android.media.session.MediaSession
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tc.navigationtest.Token
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var liveData = MutableLiveData<String>()

    private var time = 100

    private var count = 1

    init {
//        Thread {
//            kotlin.run {
//                while (count <= time){
//                    Thread.sleep(500)
//                    count++
//                    liveData.postValue("我是LiveData$count")
//                }
//            }
//        }.start()
        GlobalScope.launch() {
            while (count <= time) {
                delay(1000)
                count++
                liveData.postValue("我是LiveData:$count, Coroutines")
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    suspend fun requestToken(): Token {

        return Token(123)
    }


    fun getLiveData(): LiveData<String> {

        return liveData
    }


}
