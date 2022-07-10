package com.example.colctest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but_0.setOnClickListener{(setTextFile("0"))}
        but_1.setOnClickListener{(setTextFile("1"))}
        but_2.setOnClickListener{(setTextFile("2"))}
        but_3.setOnClickListener{(setTextFile("3"))}
        but_4.setOnClickListener{(setTextFile("4"))}
        but_5.setOnClickListener{(setTextFile("5"))}
        but_6.setOnClickListener{(setTextFile("6"))}
        but_7.setOnClickListener{(setTextFile("7"))}
        but_8.setOnClickListener{(setTextFile("8"))}
        but_9.setOnClickListener{(setTextFile("9"))}
        but_min.setOnClickListener{(setTextFile("-"))}
        but_pl.setOnClickListener{(setTextFile("+"))}
        but_del.setOnClickListener{(setTextFile("/"))}
        but_mu.setOnClickListener{(setTextFile("*"))}
        but_op.setOnClickListener{(setTextFile("("))}
        but_cl.setOnClickListener{(setTextFile(")"))}
        but_sp.setOnClickListener{(setTextFile("."))}
        but_AC.setOnClickListener{
            math_operation.text = ""
            result_text.text = ""
        }
        but_back.setOnClickListener{
            math_operation.text = back(math_operation.text.toString())
            result_text.text = ""
        }
        but_res.setOnClickListener{
            result_text.text = equels(math_operation.text.toString())
        }

    }
    fun setTextFile(str : String){
        if(!result_text.text.equals("")){
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }

    fun back(str : String) : String{
        if (str.length>0){
            return str.substring(0, str.length-1)
        }
        return str
    }

    fun equels(str :String): String{
        var res : String
        try {
            val ex = ExpressionBuilder(str).build()
            res = ex.evaluate().toString()
        }catch (e : Exception){
            res = ("error: ${e.message}")
        }
        return res
    }



}