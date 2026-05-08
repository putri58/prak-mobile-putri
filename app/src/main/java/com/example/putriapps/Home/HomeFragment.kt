package com.example.putriapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.putriapps.AuthActivity
import com.example.putriapps.Home.pertemuan4.FourthActivity
import com.example.putriapps.Home.pertemuan7.SeventhActivity
import com.example.putriapps.R
import com.example.putriapps.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }



        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        binding.button1.setOnClickListener {

            val intent = Intent(requireContext(), FourthActivity::class.java)

            intent.putExtra("nama", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)

            startActivity(intent)
        }

        binding.button2.setOnClickListener {

            val intent = Intent(requireContext(), SeventhActivity::class.java)

//            intent.putExtra("nama", "Politeknik Caltex Riau")
//            intent.putExtra("asal", "Rumbai")
//            intent.putExtra("usia", 25)

            startActivity(intent)
        }

        // FITUR LOGOUT
        binding.btnLogout.setOnClickListener {

            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->

                    // Hapus SharedPreferences
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    // Kembali ke AuthActivity
                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)

                    requireActivity().finish()
                }

                .setNegativeButton("Tidak") { dialog, _ ->

                    dialog.dismiss()
                }
                .show()
        }
    }
    }
}