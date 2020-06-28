package com.feelit.ex2_t5bb_camaque_jimenez_miguel_enrique.Bean

import java.text.SimpleDateFormat
import java.util.*

public class PacienteBean {
    var Dni:String = ""
    var Nombre: String = ""
    var Fecha: String = ""


    val pattern = "DD-MM-YYYY"
    val simpleDateFormat = SimpleDateFormat(pattern)
    val date: String = simpleDateFormat.format(Date())

    constructor(Dni: String, Nombre: String, Fecha: String) {
        this.Dni = Dni
        this.Nombre = Nombre
        this.Fecha = Fecha
    }

    constructor(Dni:String, Nombre: String) {
        this.Dni = Dni
        this.Nombre = Nombre
    }
    fun LimpiarPropiedades()
    {
        this.Dni = ""
        this.Nombre = ""
        this.Fecha=""
    }
    fun ConvertirFecha(date: Date):Date
    {
        return date
    }

}
