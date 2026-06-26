package com.example.putriapps.Home.pertemuan10

import android.Manifest
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.putriapps.databinding.FragmentTabBBinding
import com.example.putriapps.utils.PermissionHelper
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter

class TabQrcodeFragment : Fragment() {

    private var _binding: FragmentTabBBinding? = null
    private val binding get() = _binding!!

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                startCamera()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGenerate.setOnClickListener {
            val text = binding.edtQrInput.text.toString().trim()
            if (text.isEmpty()) return@setOnClickListener

            binding.ivQrCode.setImageBitmap(createQR(text))

            if (!PermissionHelper.hasPermission(
                    requireActivity(),
                    Manifest.permission.CAMERA
                )
            ) {
                PermissionHelper.requestPermission(
                    permissionLauncher,
                    Manifest.permission.CAMERA
                )
            } else {
                startCamera()
            }
        }
    }

    private fun createQR(text: String): Bitmap {
        val writer = QRCodeWriter()
        val matrix = writer.encode(
            text,
            BarcodeFormat.QR_CODE,
            500,
            500,
            mapOf(EncodeHintType.CHARACTER_SET to "UTF-8")
        )

        return Bitmap.createBitmap(500, 500, Bitmap.Config.RGB_565).apply {
            for (x in 0 until 500) {
                for (y in 0 until 500) {
                    setPixel(x, y, if (matrix[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }

    private fun startCamera() {
        // Tambahkan kode untuk membuka kamera atau scanner QR di sini
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}