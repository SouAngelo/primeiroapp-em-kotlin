package com.example.myapplicationinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplicationinkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // trás os layouts para serem usados "infla-os"
        setContentView(binding.root)
        // configuração da view binding

        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calculate) {
          calculate()
        }
    }

    private fun isValid(): Boolean {
      return (binding.editDistance.text.toString() != ""
              && binding.editPrice.text.toString() != ""
              && binding.editAutonome.text.toString() != ""
              && binding.editAutonome.text.toString().toFloat() != 0f
              )


    }

    private fun calculate() {

        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonome = binding.editAutonome.text.toString().toFloat()

            val totalValue = (distance * price / autonome)

            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        } else {
            Toast.makeText(this, R.string.validation, Toast.LENGTH_LONG).show()
        }



        //Toast.makeText(this, totalValueStr, Toast.LENGTH_LONG).show()

    }
}