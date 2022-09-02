package com.uniminuto.miscontactos.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniminuto.miscontactos.R;
import com.uniminuto.miscontactos.adapter.ContactoAdaptador;
import com.uniminuto.miscontactos.pojo.Contacto;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {
    //Creacion de un ArrayList que contendra a los contactos
    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Aca se inflara nuestro layout con el fragment

        View v  = inflater.inflate(R.layout.fragment_perfil,container,false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvProfilePet);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        listaContactos.setLayoutManager(glm);
        inicializarListaContactosProfilePet();
        inicializarAdaptadorProfilePet();


        return v;
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
    }
    //Metodo para inicializar el Adaptador
    public void inicializarAdaptadorProfilePet(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,getActivity());
        listaContactos.setAdapter(adaptador);

    }
    //Metodo para llenar el Array de contactos en el recyclerCardView
    public void inicializarListaContactosProfilePet(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Albus","Pastor Aleman","nicolas.d02@outlook.com",R.drawable.perro1,false));
        contactos.add(new Contacto("Albus","Pastor Aleman","pipe@gmail.com",R.drawable.perro1,true));
        contactos.add(new Contacto("Albus","Pastor Aleman","marcela@gmail.com",R.drawable.perro1,true));
        contactos.add(new Contacto("Albus","Pastor Aleman","jose@gmail.com",R.drawable.perro1,false));
        contactos.add(new Contacto("Albus","Pastor Aleman","nubia@gmail.com",R.drawable.perro1,true));
        contactos.add(new Contacto("Albus","Pastor Aleman","juan@gamil.com",R.drawable.perro1,true));
    }
}