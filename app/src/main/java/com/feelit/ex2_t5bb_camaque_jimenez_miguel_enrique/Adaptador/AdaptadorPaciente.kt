package com.feelit.ex2_t5bb_camaque_jimenez_miguel_enrique.Adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.feelit.ex2_t5bb_camaque_jimenez_miguel_enrique.Bean.PacienteBean
import com.feelit.ex2_t5bb_camaque_jimenez_miguel_enrique.R
import kotlinx.android.synthetic.main.registro_paciente.view.*
import java.util.*


public class AdaptadorPaciente (val ListaInterna:List<PacienteBean>, Contexto:Context) :
    RecyclerView.Adapter<AdaptadorPaciente.PacienteBeanHolder>() {
    public class PacienteBeanHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(oPaciente: PacienteBean) {
            val oTvFecha = itemView.findViewById(R.id.TVITEM_FECHA) as TextView
            val oTvNombre = itemView.findViewById(R.id.TVITEM_NOMBRE) as TextView
            val oTvDNI = itemView.findViewById(R.id.TVITEM_DNI_PACIENTE) as TextView

            oTvNombre.text = oPaciente.Nombre.toString()
            oTvDNI.text = oPaciente.Dni.toString()
            oTvFecha.text = oPaciente.ConvertirFecha(Date()).toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteBeanHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.registro_paciente, parent, false)
        return PacienteBeanHolder(v)
    }

    override fun getItemCount(): Int {
        return ListaInterna.size
    }

    override fun onBindViewHolder(holder: PacienteBeanHolder, position: Int) {
        holder?.itemView?.TVITEM_DNI_PACIENTE?.text = ListaInterna.get(position).Dni.toString()
        holder?.itemView?.TVITEM_NOMBRE?.text = ListaInterna.get(position).Nombre
        holder?.itemView?.TVITEM_FECHA?.text = ListaInterna.get(position).Fecha
    }
}