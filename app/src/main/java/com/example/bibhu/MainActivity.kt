package com.example.bibhu

import java.util.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var defYear = Calendar.getInstance().get(Calendar.YEAR)
        var defMonth = Calendar.getInstance().get(Calendar.MONTH) + 1
        var defDate = Calendar.getInstance().get(Calendar.DATE)
        defappInput.setText("$defDate $defMonth $defYear")
        appButton.setOnClickListener {
            try{
                var inputuser = appInput.text.toString().split(" ")
                var inputdef = defappInput.text.toString().split(" ")
                var userDate = inputuser[0].toInt();var userMonth = inputuser[1].toInt();var userYear = inputuser[2].toInt()
                var defDate = inputdef[0].toInt();var defMonth = inputdef[1].toInt();var defYear = inputdef[2].toInt()
                var resultYear:Int = defYear - userYear;var resultMonth:Int = defMonth - userMonth;var resultDate:Int = defDate - userDate
                if ((userYear > defYear) || (userYear == defYear && userMonth == defMonth && userDate > defDate)){
                    appOutput.text = "Invalid Input Given.Try Again!!"
                    return@setOnClickListener
                }else if((userMonth > 12) || (userDate > 31) || (defMonth > 12) || defDate > 31){
                    appOutput.text = "Invalid Input Given.Try Again!!"
                    return@setOnClickListener
                }else{
                    if (resultDate < 0){
                        resultMonth--
                        resultDate += 31
                    }
                    if(resultMonth < 0){
                        resultYear--
                        resultMonth += 12
                    }
                    if (resultYear < 0){
                        appOutput.text = "Invalid Input Given.Try Again!!"
                        return@setOnClickListener
                    }else{
                        appOutput.text = "Your age is $resultYear Years $resultMonth Months $resultDate Days."
                    }
                }
            }
            catch(ex:Exception){
                appOutput.text = "Can not display age."
            }
        }
    }
}