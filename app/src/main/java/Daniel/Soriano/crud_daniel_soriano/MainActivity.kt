package Daniel.Soriano.crud_daniel_soriano

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME
import kotlinx.coroutines.launch
import modelo.claseConexion

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        //1 - Mandar a llamar a todos los elementos
        val nombre = findViewById<EditText>(R.id.txtNombre)
        val peso = findViewById<EditText>(R.id.txtPeso)
        val edad = findViewById<EditText>(R.id.txtEdad)
        val ingresar = findViewById<Button>(R.id.btnIngresar)

        //2 - Programar el boton para agregar
        ingresar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                // Creo un obj de la clase conexion
                val objConexion  = claseConexion().cadenaConexion()
                //2
                val addMascota = objConexion?.prepareStatement("Insert Into tbMascota values(?, ?, ?)")!!
                addMascota.setString(1, nombre.text.toString() )
                addMascota.setInt(2, peso.text.toString().toInt())
                addMascota.setInt(3, edad.text.toString().toInt())
                addMascota.executeUpdate()


            }
        }

    }
}