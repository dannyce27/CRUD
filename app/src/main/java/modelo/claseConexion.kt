package modelo

import java.sql.Connection
import java.sql.DriverManager

class claseConexion {
    fun cadenaConexion():Connection?{
        try {
            val ip = "jbdc:oracle:thin@10.10.1.126:1523:xe"
            val usuario = "system"
            val contrasena = "desarrollo"

            val connection = DriverManager.getConnection(ip, usuario, contrasena)
            return connection
        }
        catch (e:Exception){
            println("Este es el error: $e")
            return null
        }
    }
}