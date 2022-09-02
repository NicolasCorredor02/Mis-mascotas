package com.uniminuto.miscontactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.uniminuto.miscontactos.adapter.ContactoAdaptadorFav;
import com.uniminuto.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class DetalleContacto extends AppCompatActivity {

    //Creacion de un ArrayList que contendra a los contactos
    ArrayList<Contacto> contactosFav;
    private RecyclerView listaContactosFav;


    /*private TextView txtNombre;
    private TextView txtTelefono;
    private TextView txtEmail;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);


        listaContactosFav = (RecyclerView) findViewById(R.id.rvContactosFav);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        /*GridLayoutManager glm = new GridLayoutManager(this,2);*/
        listaContactosFav.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptadorFav();
        //Para agregar la funcionalidad de un backArrow
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        //Para recibir los parametros es necesario emplear un objeto Bundle
        /*Bundle parametros=getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pEnviarNombre));
        String telefono = parametros.getString(getResources().getString(R.string.pEnviarTelefono));
        String email = parametros.getString(getResources().getString(R.string.pEnviarEmail));


        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        txtNombre.setText(nombre);
        txtTelefono.setText(telefono);
        txtEmail.setText(email);*/
    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mAcerca:
                Intent intent= new Intent(DetalleContacto.this,AcercaMenu.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent i = new Intent(DetalleContacto.this,ContactoMenu.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //BackArrow


    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
    /*
    public void llamar(View v){
        String telefono = txtTelefono.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL);
        //Creacion de un intent implicito ya que estara usando factores externos para su ejecucion
        intent.setData(Uri.parse("tel:" + telefono));
        startActivity(intent);
    }
    public void enviarEmail(View v){
        String email=txtEmail.getText().toString();
        Intent emailIntent= new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email "));
    }
    */


    //Metodo para inicializar el Adaptador de ContactosFav
    public void inicializarAdaptadorFav(){
        ContactoAdaptadorFav adaptadorFav = new ContactoAdaptadorFav(contactosFav,this);
        listaContactosFav.setAdapter(adaptadorFav);

    }
    //Metodo para llenar el Array de contactosFav en el recyclerCardView
    public void inicializarListaContactos(){
        contactosFav = new ArrayList<Contacto>();
        contactosFav.add(new Contacto("Rufus","Pastor Aleman","nicolas.d02@outlook.com",R.drawable.perro1,false));
        contactosFav.add(new Contacto("Max","Golden Retriever","pipe@gmail.com",R.drawable.perro2,true));
        contactosFav.add(new Contacto("Penny","Chihuahua","marcela@gmail.com",R.drawable.perro3,true));
        contactosFav.add(new Contacto("George","Border Colie","jose@gmail.com",R.drawable.perro4,false));
        contactosFav.add(new Contacto("Esmeralda","Pit Bull","nubia@gmail.com",R.drawable.perro5,true));
        contactosFav.add(new Contacto("Juan","Labrador","juan@gamil.com",R.drawable.perro6,true));
    }
    //Metodo para retornar a un activity anque este haya sido finalizado

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent= new Intent(DetalleContacto.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}