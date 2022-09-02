package com.uniminuto.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Creacion de un ArrayList que contendra a los contactos
    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    ImageButton btnFav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaracion del actionbar
        Toolbar miActionBar = (Toolbar)findViewById(R.id.actionBar);
        /*setSupportActionBar(miActionBar);*/

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        /*GridLayoutManager glm = new GridLayoutManager(this,2);*/
        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        btnFav = (ImageButton) findViewById(R.id.imgBtnMoveLike);
        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
                startActivity(intent);
            }
        });


        //Ya que el arreglo contactos posee objetos, es necesario implementar un ciclo for each para la 
        // muestra de uno de los atributos de esos objetos, en este caso sera solo la muestra de nombres
        /*ArrayList<String> nombresContacto =  new ArrayList<>();
        for (Contacto contacto:contactos){
            nombresContacto.add(contacto.getNombre());
        }*/
        /*
        ListView listViewContactos =(ListView) findViewById(R.id.listViewContactos);
        listViewContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,nombresContacto));
        //Este evento de click funciona para conocer la posicion del elemento en el ArrayList que se esta cliqueando
        listViewContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
                //Envio de los datos del elemento seleccionado
                //Este es un intent Explicito
                intent.putExtra(getResources().getString(R.string.pEnviarNombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.pEnviarTelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pEnviarEmail),contactos.get(position).getEmail());
                //Sin embargo tambien se puede crear un  Array antes de enviar la data y asi enviarla a traves de un intent.putExtra para el envio de arrays
                startActivity(intent);
                finish();
            }
        });
        */

    }

    //Metodo para inicializar el Adaptador
    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,this);
        listaContactos.setAdapter(adaptador);

    }
    //Metodo para llenar el Array de contactos en el recyclerCardView
    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Rufus","Pastor Aleman","nicolas.d02@outlook.com",R.drawable.perro1,false));
        contactos.add(new Contacto("Max","Golden Retriever","pipe@gmail.com",R.drawable.perro2,true));
        contactos.add(new Contacto("Penny","Chihuahua","marcela@gmail.com",R.drawable.perro3,true));
        contactos.add(new Contacto("George","Border Colie","jose@gmail.com",R.drawable.perro4,false));
        contactos.add(new Contacto("Esmeralda","Pit Bull","nubia@gmail.com",R.drawable.perro5,true));
        contactos.add(new Contacto("Juan","Labrador","juan@gamil.com",R.drawable.perro6,true));
    }
}