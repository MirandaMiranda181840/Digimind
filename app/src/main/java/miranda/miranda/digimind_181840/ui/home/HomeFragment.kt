package miranda.miranda.digimind_181840.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.pendiente_view.view.*
import miranda.miranda.digimind_181840.Pendiente
import miranda.miranda.digimind_181840.R

class HomeFragment : Fragment() {

    private var adaptador: AdaptadorPendiente? = null

    companion object{
        var pendientes = ArrayList<Pendiente>()
        var first = true
    }

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        if(first){
            cargarPendiente()
            first = false
        }

        adaptador = AdaptadorPendiente(root.context, pendientes)
        root.gridview.adapter = adaptador
        //root.gridview.adapter = AdaptadorPendiente(root.context, pendientes)


        return root
    }

    fun cargarPendiente(){
        pendientes.add(Pendiente("Practice 1", arrayListOf("Tuesday"),"17:30"))
        pendientes.add(Pendiente("Practice 2",arrayListOf("Monday", "Sunday"),"17:00"))
        pendientes.add(Pendiente("Practice 3",arrayListOf("Wednesday"),"14:00"))
        pendientes.add(Pendiente("Practice 4",arrayListOf("Saturday"),"11:00"))
        pendientes.add(Pendiente("Practice 5",arrayListOf("Friday"),"17:46"))
        pendientes.add(Pendiente("Practice 6",arrayListOf("Thursday"),"12:25"))
        pendientes.add(Pendiente("Practice 7",arrayListOf("Monday"),"16:56"))
    }

    private class AdaptadorPendiente: BaseAdapter {

        var pendientes = ArrayList<Pendiente>()
        var contexto: Context? = null

        constructor(contexto: Context, pendientes:ArrayList<Pendiente>){
            this.pendientes = pendientes
            this.contexto = contexto
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var pendiente = pendientes[position]
            var inflater = LayoutInflater.from(contexto)
            var vista = inflater.inflate(R.layout.pendiente_view, null)

            vista.pendiente_titulo.setText(pendiente.titulo)
            vista.pendiente_descripcion.setText(pendiente.days.toString())
            vista.pendiente_hora.setText(pendiente.time)

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

