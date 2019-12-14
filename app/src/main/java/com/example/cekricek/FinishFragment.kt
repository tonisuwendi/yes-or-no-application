package com.example.cekricek


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.cekricek.databinding.FragmentFinishBinding

/**
 * A simple [Fragment] subclass.
 */
class FinishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Selesai"
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_finish, container, false)
        val binding: FragmentFinishBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_finish, container, false)

        var args = FinishFragmentArgs.fromBundle(arguments!!)

        binding.explainText.text = args.result

        binding.btnTryAgain.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_finishFragment_to_introFragment))

        return binding.root
    }


}
