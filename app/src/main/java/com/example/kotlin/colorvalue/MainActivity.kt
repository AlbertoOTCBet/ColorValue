package com.example.kotlin.colorvalue

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.colorvalue.Adapters.ColorApater
import com.example.kotlin.colorvalue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter : ColorApater = ColorApater()
    private lateinit var viewModel: ColorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeBinding()

        val colorDao = ColorDatabase.invoke(application).colorDao()
        val newColor = Color(0,hex = "#00722e", name = "verde")
        Log.i("New_Color", newColor.hex + " -> "+newColor.name )
        //colorDao.insert(newColor)

        /*var dataT = colorDao.getAll()

        //Llamar al método para la creación del recyclerView enviandole los datos del Room
        setUpRecyclerView(dataT)
        Log.i("Quantity_Colors", dataT.size.toString() )*/
        setUpRecyclerView(  )
        Log.i("Onstart", "oncreate")

        binding.btnPlus.setOnClickListener {
            var coloEaxa = binding.numeroExa.text
            var coloName = binding.nombreC.text
            Log.i("Empty_FR", coloEaxa.toString())
            Log.i("Empty_FR",coloName.toString())
            if( !coloEaxa.isEmpty() && !coloName.isEmpty() ){
                if(  !coloEaxa.contains("#")){
                    Toast.makeText(this, "No es un número Exadecimal", Toast.LENGTH_LONG).show()
                }else {
                    val newColor = Color(0, hex = coloEaxa.toString(), name = coloName.toString())
                    viewModel.save(newColor)
                    Toast.makeText(this, "Color agregado", Toast.LENGTH_LONG).show()
                    Log.i("Onstart", "agregar color")
                    Log.i("Onstart", newColor.hex + " -> " + newColor.name)
                    binding.numeroExa.setText("")
                    binding.nombreC.setText("")
                    setUpRecyclerView()
                }
            }else{
                    Toast.makeText(this, "No deje los campos Vacios", Toast.LENGTH_LONG).show()
                }

        }

    }

    private  fun initializeBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView( binding.root )

    }

    override fun onStart() {
        super.onStart()
        setUpRecyclerView(  )
        Log.i("Onstart", "Onresumen")
    }

    private fun setUpRecyclerView (){

        binding.recyclerColor.setHasFixedSize(true)
        var linearLayoutManager = LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerColor.layoutManager = linearLayoutManager
        //adapter.ColorApater(arrayList, this)
        binding.recyclerColor.adapter = adapter
        val colorDao = ColorDatabase.invoke(application).colorDao()
        viewModel = ColorViewModel(colorDao , application)
        //viewModel = ViewModelProvider( this).get(viewModel::class.java)
        viewModel.readAllColors.observe(this, {colors -> adapter.ColorApater( colors,this)})
    }

}

