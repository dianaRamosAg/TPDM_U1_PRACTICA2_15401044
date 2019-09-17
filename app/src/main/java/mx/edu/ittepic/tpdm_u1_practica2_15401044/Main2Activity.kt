package mx.edu.ittepic.tpdm_u1_practica2_15401044

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.OutputStreamWriter

class Main2Activity : AppCompatActivity() {
    var btnRegresar:Button?=null
    var listP:LinearLayout?=null
    var editPR :EditText?=null
    var btnCapturar: Button?=null
    var btnArchivar: Button?=null
    var valor:EditText?=null
    var grid:GridLayout?=null
    var a1:RadioButton?=null
    var a2:RadioButton?=null
    var a3:RadioButton?=null
    var m=0
    var v=0
    var cadena=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        listP=findViewById(R.id.LPR)
        btnRegresar=findViewById(R.id.btnRegresar)
        btnCapturar=findViewById(R.id.btnCapturar)
        btnArchivar=findViewById(R.id.btnArchivar)
        valor=findViewById(R.id.editV)
        grid=findViewById(R.id.grid2)
        a1=findViewById(R.id.rbA1)
        a2=findViewById(R.id.rbA2)
        a3=findViewById(R.id.rbA3)
        var vmatriz = intent.extras?.getInt("matriz")
        var vvector = intent.extras?.getInt("vector")

        //regresar
        btnRegresar?.setOnClickListener {
            var activity1= Intent(this,MainActivity::class.java)
            activity1.putExtra("cadena",cadena)
            startActivity(activity1)
        }



        if(vmatriz.toString().toInt()==1) {

            var textPR = TextView(this)
            textPR.setText("Posición R : ")
            editPR= EditText(this)
            editPR?.setHint("                                                          ")
            editPR?.inputType= InputType.TYPE_CLASS_NUMBER
            listP?.addView(textPR)
            listP?.addView(editPR)
            m=1
        }
        if(vvector.toString().toInt()==1){
            v=1
        listP?.removeAllViews()}

        //-----------Capturar---------------

        btnCapturar?.setOnClickListener {
           var v=TextView(this)
            v.setText(valor?.text.toString())
            grid?.addView(v)
        }

        //--------Archivar
        btnArchivar?.setOnClickListener {
            if(a1?.isChecked==true){
                guardarA1()
            }
            if(a2?.isChecked==true){
                guardarA2()
            }
            if(a3?.isChecked==true){
                guardarA3()
            }
        }
    }//oncreate

    //-----------funciones------------
    fun guardarA1(){
        cadena="V"+editPC.text.toString()+" /nValor: "+valor?.text.toString()
        if(m==1){cadena= "Titulo: "+"M"+editPC.text.toString()+editPR?.text.toString()+" /nValor: "+valor?.text.toString()}
        val guardarArchivo=OutputStreamWriter(openFileOutput("archivo1.txt",Activity.MODE_PRIVATE))
        guardarArchivo.write(cadena)
        guardarArchivo.flush()
        AlertDialog.Builder(this).setTitle("ATENCION")
            .setMessage("SE GUARDO EN ARCHIVO 1")
            .setPositiveButton("ACEPTAR"){dialog,which->}
            .show()
    }

    fun guardarA2(){
        cadena="V"+editPC.text.toString()+" /nValor: "+valor?.text.toString()
        if(m==1){cadena= "Titulo: "+"M"+editPC.text.toString()+editPR?.text.toString()+" /nValor: "+valor?.text.toString()}
        val guardarArchivo=OutputStreamWriter(openFileOutput("archivo2.txt",Activity.MODE_PRIVATE))
        guardarArchivo.write("Titulo: "+cadena+" /nValor: "+valor?.text.toString())
        guardarArchivo.flush()
        AlertDialog.Builder(this).setTitle("ATENCION")
            .setMessage("SE GUARDO EN ARCHIVO 2")
            .setPositiveButton("ACEPTAR"){dialog,which->}
            .show()

    }
    fun guardarA3(){
        cadena="V"+editPC.text.toString()+" /nValor: "+valor?.text.toString()
        if(m==1){cadena= "Titulo: "+"M"+editPC.text.toString()+editPR?.text.toString()+" /nValor: "+valor?.text.toString()}

        val guardarArchivo=OutputStreamWriter(openFileOutput("archivo3.txt",Activity.MODE_PRIVATE))
        guardarArchivo.write(cadena)

        guardarArchivo.flush()
        AlertDialog.Builder(this).setTitle("ATENCION")
            .setMessage("SE GUARDO EN ARCHIVO 3")
            .setPositiveButton("ACEPTAR"){dialog,which->}
            .show()

    }
}
