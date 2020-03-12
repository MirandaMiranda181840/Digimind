package miranda.miranda.digimind_181840.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.pendiente_view.view.*
import miranda.miranda.digimind_181840.Pendiente
import miranda.miranda.digimind_181840.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel


    var pendientes = ArrayList<Pendiente>()
    var adaptador: AdaptadorPendiente? = null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })


        return root
    }

    fun cargarPendiente(){
        pendientes.add(Pendiente("Practice","Everyday","17:00"))
        pendientes.add(Pendiente("Practice","Everyday","17:00"))
        pendientes.add(Pendiente("Practice","Everyday","17:00"))
        pendientes.add(Pendiente("Practice","Everyday","17:00"))
        pendientes.add(Pendiente("Practice","Everyday","17:00"))
        pendientes.add(Pendiente("Practice","Everyday","17:00"))
        pendientes.add(Pendiente("Practice","Everyday","17:00"))
        pendientes.add(Pendiente("Practice","Everyday","17:00"))
        pendientes.add(Pendiente("Practice","Everyday","17:00"))
    }

    class AdaptadorPendiente: BaseAdapter {

        var pendientes = ArrayList<Pendiente>()
        var contexto: Context? = null

        constructor(contexto:Context, pendientes:ArrayList<Pendiente>){
            this.pendientes = pendientes
            this.contexto = contexto
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var pendiente = pendientes[position]
            var inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)  as LayoutInflater
            var vista = inflater.inflate(R.layout.pendiente_view, null)

            vista.pendiente_nombre.setText(pendiente.titulo)
            vista.pendiente_descripcion.setText(pendiente.descripcion)
            vista.pendiente_hora.setText(pendiente.hora)

            return vista

        }

        override fun getItem(position: Int): Any {
            return pendientes[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return pendientes.size
        }

    }


}

