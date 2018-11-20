package com.example.tc.navigationtest.ui.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tc.navigationtest.HelloActivity
import com.example.tc.navigationtest.R
import com.example.tc.navigationtest.ToastUtil
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnStep.setOnClickListener {
            ToastUtil.showToast(context, "测试")
            startActivity(Intent(this.context, HelloActivity::class.java))
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val getString = Observer<String> {
            Toast.makeText(this.context, it, Toast.LENGTH_SHORT).show()
        }

//        viewModel.getLiveData().observe(this, getString)
    }

}
