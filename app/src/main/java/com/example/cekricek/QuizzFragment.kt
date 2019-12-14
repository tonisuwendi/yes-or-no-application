package com.example.cekricek


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cekricek.databinding.FragmentQuizzBinding

/**
 * A simple [Fragment] subclass.
 */
class QuizzFragment : Fragment() {

    val question = arrayOf("Apakah kamu suka rebahan?",
                            "Apakah kamu jomblo?",
                            "Apakah kamu merasa kesepian?")
    var yes_score = 0
    var no_score = 0
    var current_q = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Quiz Iya atau Tidak"
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_quizz, container, false)
        val binding: FragmentQuizzBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_quizz, container, false)

        binding.questionText.text = question[current_q]

        binding.yesBtn.setOnClickListener {
            yes_score++
            nextQuestion(binding)
        }

        binding.noBtn.setOnClickListener {
            no_score++
            nextQuestion(binding)
        }

        return binding.root
    }

    fun nextQuestion(binding: FragmentQuizzBinding) {
        current_q++
        if(current_q < question.size){
            binding.questionText.text = question[current_q]
        }
        else {
            var result = ""
            if(yes_score == 3){
                result = "Waduh, sepertinya hidupmu tidak berguna banget.. aowkwk"
            }else if(yes_score == 2){
                result = "Kebahagiaanmu sepertinya sangat kurang"
            }else if(yes_score == 1){
                result = "Wahh bentar lagi kamu akan bahagia"
            }else{
                result = "Wadawww.. Kamu suka rebahan, kamu ngga jomblo, dan tidak kesepian. Keren banget dah kamu.."
            }
            view!!.findNavController()
                .navigate(QuizzFragmentDirections.actionQuizFragmentToFinishFragment(result))
        }
    }


}
