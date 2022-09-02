package com.uniminuto.miscontactos;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptadorFav extends RecyclerView.Adapter<ContactoAdaptadorFav.ContactoViewHolder>{
    ArrayList<Contacto> contactosFav;
    Activity activity;

    public ContactoAdaptadorFav(ArrayList<Contacto> contactosFav, Activity activity){
        this.contactosFav=contactosFav;
        this.activity = activity;
    }

    @NonNull
    //Infla el layout y lo pasara al viewHolder para que el obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//Maneja la parte de inflar o dar vida al cardView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent,false);

        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view

    public void onBindViewHolder(@NonNull ContactoAdaptadorFav.ContactoViewHolder contactoViewHolder, int position) {//Aca se pasan los datos de cada elemento de la lista de contactos
        final Contacto contacto= contactosFav.get(position);//Obtencion de cada elemento en la lista por medio de la iteracion
        if(contacto.getFav()==true){
            contactoViewHolder.imgFotoContacto.setImageResource(contacto.getFoto());
            contactoViewHolder.txtViewNombre.setText(contacto.getNombre());
            contactoViewHolder.txtViewTelefono.setText(contacto.getTelefono());
        }
    }
    public int getItemCount() {//Cantidad de elementos que contiene mi lista
        return contactosFav.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoContacto;
        private TextView txtViewNombre;
        private TextView txtViewTelefono;
        private ImageButton imgBtnLike;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoContacto = (ImageView) itemView.findViewById(R.id.imgFotoContacto);
            txtViewNombre = (TextView) itemView.findViewById(R.id.txtViewNombre);
            txtViewTelefono = (TextView) itemView.findViewById(R.id.txtViewTelefono);
            txtViewTelefono = (TextView) itemView.findViewById(R.id.txtViewTelefono);
            imgBtnLike = (ImageButton) itemView.findViewById(R.id.imgBtnLike);
        }
    }
}
