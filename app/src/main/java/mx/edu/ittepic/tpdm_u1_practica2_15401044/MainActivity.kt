package mx.edu.ittepic.tpdm_u1_practica2_15401044

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lista : ListView?=null
    var RbVector : RadioButton?=null
    var RbMatriz : RadioButton?=null
    var LR : LinearLayout?=null
    var editC: EditText?=null
    var editR :EditText?=null
    var matriz = 0
    var vector = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        RbVector=findViewById(R.id.rbVector)
        RbMatriz=findViewById(R.id.rbMatriz)
        LR=findViewById(R.id.Lrenglones)
        lista=findViewById(R.id.listOpciones)
        editC=findViewById(R.id.editC)



        //----Opciones del listView-------------------------------------------------------------------------

        val Lopciones:Array<String> = resources.getStringArray(R.array.opciones)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Lopciones)
        lista?.adapter = arrayAdapter

        lista?.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val indice = adapterView.getItemIdAtPosition(position).toString().toInt()

            when(indice)
            {
                0->{ validarC()}
                1->{
                    var activity3= Intent(this,Main3Activity::class.java)
                    var cadena = intent.extras?.getString("cadena")
                    activity3.putExtra("cadena",cadena)
                    startActivity(activity3) }
                2->{AlertDialog.Builder(this).setTitle("Acerca de")
                    .setMessage("(C) Diana Laura Ramos Aguilar")
                    .setPositiveButton("Aceptar"){dialog,which->}
                    .show()}
                3->{finish()}
            }
        }

        //-----Opción de vector o matriz
        var textR = TextView(this)
        textR.setText("Renglones : ")
        editR= EditText(this)
        editR?.setHint("                                                          ")
        editR?.inputType=InputType.TYPE_CLASS_NUMBER
        LR?.addView(textR)
        LR?.addView(editR)

        RbVector?.setOnClickListener {
            //Selección de Vector en radioButton
            LR?.removeAllViews() }

        RbMatriz?.setOnClickListener{
            LR?.removeAllViews()
            var textR = TextView(this)
            textR.setText("Renglones : ")
            editR= EditText(this)
            editR?.setHint("                                                          ")
            editR?.inputType=InputType.TYPE_CLASS_NUMBER
            LR?.addView(textR)
            LR?.addView(editR) }


    }//onCreate

    //---------------------Funciones----------------------

    fun validarC() {
        if(RbMatriz?.isChecked==true){
            if(editC?.text.toString().isEmpty() or editR?.text.toString().isEmpty()){
                AlertDialog.Builder(this).setTitle("Error")
                    .setMessage("Llenar los datos para hacer una matriz")
                    .setPositiveButton("Aceptar"){dialog,which->}
                    .show()
            }
            else {
                matriz=1
                var activity2= Intent(this,Main2Activity::class.java)
                activity2.putExtra("matriz",1)
                startActivity(activity2)
            }

        }
        if(RbVector?.isChecked==true) {
            if(editC?.text.toString().isEmpty())
            {
                AlertDialog.Builder(this).setTitle("Error")
                    .setMessage("Llenar los datos para hacer un vector")
                    .setPositiveButton("Aceptar"){dialog,which->}
                    .show()
            }
            else{
                vector=1
                var activity2= Intent(this,Main2Activity::class.java)
                activity2.putExtra("vector",1)
                startActivity(activity2)
            }

        }
    }



}
