package mx.edu.ittepic.tpdm_u1_practica2_15401044

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Main3Activity : AppCompatActivity() {
    var abrir:Button?=null
    var exportar:Button?=null
    var a1: RadioButton?=null
    var a2: RadioButton?=null
    var a3: RadioButton?=null
    var exp=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        abrir=findViewById(R.id.btnAbrir)
        exportar=findViewById(R.id.btnExp)
        a1=findViewById(R.id.abrirA1)
        a2=findViewById(R.id.abrirA2)
        a3=findViewById(R.id.abrirA3)

        abrir?.setOnClickListener {
            exp=0
            if(a1?.isChecked==true){
                abrirA1()
            }
            if(a2?.isChecked==true){
                abrirA2()
            }
            if(a3?.isChecke
                abrirA3()
            }
        }

        exportar?.setOnClickListener {
             exp=1
            if(a1?.isChecked==true){
                abrirA1()
            }
            if(a2?.isChecked==true){
                abrirA2()
            }
            if(a3?.isChecked==true){
                abrirA3()
            }
        }

    }
    //Funciones
    fun abrirA1() {
        var cadena = intent.extras?.getString("cadena")
        if (exp==1){
            val guardarArchivo= OutputStreamWriter(openFileOutput("archivo1.csv", Activity.MODE_PRIVATE))
            guardarArchivo.write(cadena)
            guardarArchivo.flush()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE EXPORTO ARCHIVO 1")
                .setPositiveButton("ACEPTAR"){dialog,which->}
                .show()
        }
        else{
            val abrirArchivo = BufferedReader(InputStreamReader(openFileInput("archivo1.txt")))
            var cad= abrirArchivo.readLine()
                 AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE ABRIO ARCHIVO 1")
                .setPositiveButton("ACEPTAR"){dialog,which->}
                .show()}
    }
    fun abrirA2() {
        var cadena = intent.extras?.getString("cadena")
        if (exp==1){
            val guardarArchivo= OutputStreamWriter(openFileOutput("archivo2.csv", Activity.MODE_PRIVATE))
            guardarArchivo.write(cadena)
            guardarArchivo.flush()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE EXPORTO ARCHIVO 2")
                .setPositiveButton("ACEPTAR"){dialog,which->}
                .show()
        }
        else {
            val abrirArchivo = BufferedReader(InputStreamReader(openFileInput("archivo3.txt")))
            var cad= abrirArchivo.readLine()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE ABRIO ARCHIVO 3")
                .setPositiveButton("ACEPTAR") { dialog, which -> }
                .show()
        }
    }
    fun abrirA3() {
        var cadena = intent.extras?.getString("cadena")
        if (exp == 1) {
            val guardarArchivo= OutputStreamWriter(openFileOutput("archivo3.csv", Activity.MODE_PRIVATE))
            guardarArchivo.write(cadena)
            guardarArchivo.flush()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE EXPORTO ARCHIVO 3")
                .setPositiveButton("ACEPTAR") { dialog, which -> }
                .show()
        } else {
            val abrirArchivo = BufferedReader(InputStreamReader(openFileInput("archivo3.txt")))
            var cad= abrirArchivo.readLine()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE ABRIO ARCHIVO 3")
                .setPositiveButton("ACEPTAR") { dialog, which -> }
                .show()
        }
    }
}
