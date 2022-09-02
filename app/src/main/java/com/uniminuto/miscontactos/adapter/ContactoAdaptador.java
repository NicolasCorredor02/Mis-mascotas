package com.uniminuto.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uniminuto.miscontactos.pojo.Contacto;
import com.uniminuto.miscontactos.DetalleContacto;
import com.uniminuto.miscontactos.R;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{
    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos=contactos;
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
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {//Aca se pasan los datos de cada elemento de la lista de contactos
        final Contacto contacto= contactos.get(position);//Obtencion de cada elemento en la lista por medio de la iteracion
        contactoViewHolder.imgFotoContacto.setImageResource(contacto.getFoto());
        contactoViewHolder.txtViewNombre.setText(contacto.getNombre());
        contactoViewHolder.txtViewTelefono.setText(contacto.getTelefono());
        //Implementando accion clicqueable a cada cardView
        contactoViewHolder.imgFotoContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                activity.startActivity(intent);

            }
        });
        //Accion para el boton de like
        contactoViewHolder.imgBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,contacto.getNombre()+" ahora es favorito! ",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {//Cantidad de elementos que contiene mi lista
        return contactos.size();
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
