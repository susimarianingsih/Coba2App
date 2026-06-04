package com.example.coba2app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.coba2app.databinding.ActivityImpliciteBinding

class ImpliciteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImpliciteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImpliciteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SHARE TEXT
        binding.btnShareTo.setOnClickListener {
            val text = binding.edtText.text.toString().trim()

            if (text.isEmpty()) {
                toast("Silakan input text terlebih dahulu")
            } else {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, text)
                startActivity(Intent.createChooser(intent, "Share to"))
            }
        }

        // CALL / DIAL NUMBER
        binding.btnCall.setOnClickListener {
            val phoneNumber = binding.edtPhoneNumber.text.toString().trim()

            if (phoneNumber.isEmpty()) {
                toast("Silakan input nomor telepon")
            } else {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$phoneNumber")
                startActivity(intent)
            }
        }

        // OPEN GOOGLE MAP
        binding.btnOpenGoogleMap.setOnClickListener {
            val location = binding.edtLocation.text.toString().trim()

            if (location.isEmpty()) {
                toast("Silakan input lokasi")
            } else {
                val gmmIntentUri = Uri.parse("geo:0,0?q=${Uri.encode(location)}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")

                if (mapIntent.resolveActivity(packageManager) != null) {
                    startActivity(mapIntent)
                } else {
                    // Jika Google Maps tidak ada, buka dengan aplikasi lain
                    val fallbackIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    startActivity(fallbackIntent)
                }
            }
        }

        // OPEN WEBSITE
        binding.btnOpenWebsite.setOnClickListener {
            var website = binding.edtWebsite.text.toString().trim()

            if (website.isEmpty()) {
                toast("Silakan input website URL")
            } else {
                if (!website.startsWith("http://") && !website.startsWith("https://")) {
                    website = "https://$website"
                }

                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(website)
                startActivity(intent)
            }
        }

        // OPEN CAMERA
        binding.btnOpenCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                toast("Aplikasi kamera tidak tersedia")
            }
        }

        // OPEN GALLERY
        binding.btnOpenGallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivity(intent)
        }

        // OPEN ALARM
        binding.btnOpenAlarm.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_HOUR, 7)
                putExtra(AlarmClock.EXTRA_MINUTES, 0)
                putExtra(AlarmClock.EXTRA_MESSAGE, "Bangun pagi")
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                toast("Aplikasi alarm tidak tersedia")
            }
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
