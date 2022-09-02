package com.uniminuto.miscontactos.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uniminuto.miscontactos.DetalleContacto;
import com.uniminuto.miscontactos.R;
import com.uniminuto.miscontactos.adapter.ContactoAdaptador;
import com.uniminuto.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    //Creacion de un ArrayList que contendra a los contactos
    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Aca se inflara nuestro layout con el fragment

        View v  = inflater.inflate(R.layout.fragment_recyclerview,container,false);
        //return super.onCreateView(inflater, container, savedInstanceState);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        /*GridLayoutManager glm = new GridLayoutManager(this,2);*/
        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();


        return v;
    }

    //Metodo para inicializar el Adaptador
    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,getActivity());
        listaContactos.setAdapter(adaptador);

    }
    //Metodo para llenar el Array de contactos en el recyclerCardView
    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Albus","Pastor Aleman","nicolas.d02@outlook.com",R.drawable.perro1,false));
        contactos.add(new Contacto("Max","Golden Retriever","pipe@gmail.com",R.drawable.perro2,true));
        contactos.add(new Contacto("Penny","Chihuahua","marcela@gmail.com",R.drawable.perro3,true));
        contactos.add(new Contacto("George","Border Colie","jose@gmail.com",R.drawable.perro4,false));
        contactos.add(new Contacto("Esmeralda","Pit Bull","nubia@gmail.com",R.drawable.perro5,true));
        contactos.add(new Contacto("Juan","Labrador","juan@gamil.com",R.drawable.perro6,true));
    }
}
