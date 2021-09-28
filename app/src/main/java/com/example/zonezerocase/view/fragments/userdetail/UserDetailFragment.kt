package com.example.zonezerocase.view.fragments.userdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.zonezerocase.R
import com.example.zonezerocase.data.models.Doctor
import com.example.zonezerocase.databinding.FragmentUserDetailBinding
import com.example.zonezerocase.downloadFromUrl


class UserDetailFragment : Fragment() {
    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!

    private val args: UserDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user_detail, container, false)

        binding.args = args

        navigateNextPage()

        return binding.root
    }

    private fun navigateNextPage() {
        binding.imageViewNavigateNext.setOnClickListener {
            if (args.doctor.userStatus == "premium") {
                val action =
                    UserDetailFragmentDirections.actionUserDetailFragmentToAppointmentFragment()
                Navigation.findNavController(it).navigate(action)
            } else {
                val action =
                    UserDetailFragmentDirections.actionUserDetailFragmentToPaymentFragment()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}