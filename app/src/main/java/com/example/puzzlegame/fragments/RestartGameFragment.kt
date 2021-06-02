package com.example.puzzlegame.fragments

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.puzzlegame.R
import com.example.puzzlegame.databinding.FragmentRestartGameBinding


class RestartGameFragment : Fragment() {
    private var _binding : FragmentRestartGameBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestartGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.restartButton.setOnClickListener(View.OnClickListener {
            binding.restartButton.playAnimation()
            binding.restartButton.addAnimatorListener(object :AnimatorListener{
                override fun onAnimationStart(animation: Animator?) {}

                override fun onAnimationEnd(animation: Animator?) {
                    val gameFragment = GameFragment()
                    activity?.supportFragmentManager
                        ?.beginTransaction()
                        ?.replace(R.id.fragmentContainer,gameFragment,"Fragment Replaced")
                        ?.addToBackStack(null)
                        ?.commit()

                }

                override fun onAnimationCancel(animation: Animator?) {}
                override fun onAnimationRepeat(animation: Animator?) {}

            })
        })
    }



}