package com.up.myportfolio.add

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.databinding.DataBindingUtil
import com.up.myportfolio.R
import com.up.myportfolio.databinding.ActivityAddEquityBinding
import java.util.*

class AddEquityActivity : AppCompatActivity(), View.OnClickListener {

    private var equityName: String = ""
    private var equityQty: String = ""
    private var equityInvestmentDate: String = ""
    private var binding: ActivityAddEquityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_equity)
        binding?.lifecycleOwner = this
        initView()
    }

    private fun initView() {
        binding?.buttonSubmit?.setOnClickListener(this)
        binding?.backImage?.setOnClickListener(this)
        binding?.textInvestmentDate?.setOnClickListener(this)
        binding?.inputEquityName?.addTextChangedListener(nameChanger)
        binding?.inputEquityQty?.addTextChangedListener(qtyChanger)
    }

    private val nameChanger = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
            p0?.let {
                equityName = it.toString()
            }
        }
    }

    private val qtyChanger = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
            p0?.let {
                equityQty = it.toString()
            }
        }
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when (it.id) {
                binding?.backImage?.id -> {
                    onBackPressed()
                }
                binding?.buttonSubmit?.id -> {

                }
                binding?.textInvestmentDate?.id -> {
                    val c = Calendar.getInstance()
                    val years = c.get(Calendar.YEAR) - 12
                    c.set(Calendar.YEAR, years)
                    val month = c.get(Calendar.MONTH)
                    val day = c.get(Calendar.DAY_OF_MONTH)
                    val dpd = DatePickerDialog(
                        this,
                        { _, year, monthOfYear, dayOfMonth ->
                            // Display Selected date in TextView
                            val m: Int = monthOfYear + 1
                            var mDate = dayOfMonth.toString()
                            if (mDate.length == 1) {
                                mDate = "0${mDate}"
                            }
                            var months: String = m.toString()
                            if (months.length == 1) {
                                months = "0$months"
                            }
                            binding?.textInvestmentDate?.text =
                                String.format(Locale.US, "%s/%s/%s", mDate, months, year)
                            equityInvestmentDate = String.format(Locale.US, "%s/%s/%s", mDate, months, year)
                        },
                        years,
                        month,
                        day
                    )
                    dpd.datePicker.maxDate = c.timeInMillis - 1000
                    dpd.show()
                }
            }
        }
    }
}