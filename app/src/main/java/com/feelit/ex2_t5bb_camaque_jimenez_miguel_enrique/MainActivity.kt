package com.feelit.ex2_t5bb_camaque_jimenez_miguel_enrique

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.feelit.ex2_t5bb_camaque_jimenez_miguel_enrique.Adaptador.AdaptadorPaciente
import com.feelit.ex2_t5bb_camaque_jimenez_miguel_enrique.Bean.PacienteBean
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var oAdaptadorPaciente: AdaptadorPaciente
    lateinit var oListaPacientes:ArrayList<PacienteBean>
    lateinit var oNuevoPaciente: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        oListaPacientes=ArrayList<PacienteBean>()
        oListaPacientes.add(PacienteBean("738928","Manuel"))
        oListaPacientes.add(PacienteBean("735129","Olga"))

        oAdaptadorPaciente = AdaptadorPaciente(oListaPacientes.toList(),this)

        //Atributos del recyledView
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        rvListaPaciente.setLayoutManager(llm)
        rvListaPaciente.setHasFixedSize(true)
        rvListaPaciente.setAdapter(oAdaptadorPaciente)
        //Prueba de texto
    }

    public fun btnNuevoOnClick(v: View)
    {
        oNuevoPaciente= Dialog(this)
        oNuevoPaciente.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoPaciente.setCancelable(false)
        oNuevoPaciente.setContentView(R.layout.activity_nuevo_paciente)
        var obtnGrabarRegistro=oNuevoPaciente.findViewById(R.id.btnGrabar) as Button
        var obtnCancelarRegistro=oNuevoPaciente.findViewById(R.id.btnCerrar) as Button

        obtnGrabarRegistro.setOnClickListener()
        {
            GrabarNuevoRegistro()
            oNuevoPaciente.dismiss()
        }
        obtnCancelarRegistro.setOnClickListener {

            oNuevoPaciente.dismiss()
        }


        oNuevoPaciente.show()
    }


    public fun GrabarNuevoRegistro()
    {
       var oedtNombres: EditText =oNuevoPaciente.findViewById(R.id.txtNombres)
       var oedtDni: EditText =oNuevoPaciente.findViewById(R.id.txtDNI)
        oListaPacientes.add(PacienteBean(oedtDni.toString(),oedtNombres.toString()))

        oAdaptadorPaciente = AdaptadorPaciente(oListaPacientes.toList(),this)
        rvListaPaciente.setAdapter(oAdaptadorPaciente)

    }


    public fun btnBuscar_Onclick(v: View)
    {
        VentanaConfirmacion()
    }

    public fun VentanaConfirmacion()
    {
        var oDialogoConfirma: AlertDialog.Builder= AlertDialog.Builder(this)
        oDialogoConfirma.setTitle("Confirmar eliminación de registro")
        oDialogoConfirma.setMessage("¿Estas seguro de eliminar el registro?")
        oDialogoConfirma.setCancelable(false)
        oDialogoConfirma.setPositiveButton(
            "Si",
            DialogInterface.OnClickListener(
                { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                }
            )
        )

        oDialogoConfirma.setNegativeButton(
            "No",
            DialogInterface.OnClickListener(
                { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                }
            )
        )


        var odialogo: AlertDialog =oDialogoConfirma.create()
        odialogo.show()
    }
}
