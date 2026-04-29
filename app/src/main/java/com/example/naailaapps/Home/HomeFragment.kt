package com.example.naailaapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.naailaapps.AuthActivity
import com.example.naailaapps.Home.pertemuan_2.SecondActivity
import com.example.naailaapps.Home.pertemuan_3.ThirdActivity
import com.example.naailaapps.Home.pertemuan_4.FourthActivity
import com.example.naailaapps.Home.pertemuan_5.FifthActivity
import com.example.naailaapps.Home.pertemuan_7.SeventhActivity
import com.example.naailaapps.R
import com.example.naailaapps.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPref = requireContext().getSharedPreferences("session_user", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(requireContext(), FourthActivity::class.java)

            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
        }

        binding.btnToSecond.setOnClickListener{
            val intent = Intent(requireContext(), SecondActivity::class.java)

            startActivity(intent)
        }

        binding.btnToThird.setOnClickListener{
            val intent = Intent(requireContext(), ThirdActivity::class.java)

            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener{
            val intent = Intent(requireContext(), FifthActivity::class.java)

            startActivity(intent)
        }

        binding.btnToSeven.setOnClickListener{
            val intent = Intent(requireContext(), SeventhActivity::class.java)

            startActivity(intent)
        }
        binding.btnLogout.setOnClickListener {

            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()

                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()

                }
                .show()
        }

    }
}