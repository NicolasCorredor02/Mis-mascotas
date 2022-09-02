package com.uniminuto.miscontactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.uniminuto.miscontactos.adapter.ContactoAdaptador;
import com.uniminuto.miscontactos.adapter.PageAdapter;
import com.uniminuto.miscontactos.fragment.PerfilFragment;
import com.uniminuto.miscontactos.fragment.RecyclerViewFragment;
import com.uniminuto.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton btnFav;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(Toolbar)findViewById(R.id.actionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        setUpViewPager();
        btnFav = (ImageButton) findViewById(R.id.imgBtnMoveLike);
        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                startActivity(intent);
            }
        });


        //Declaracion del actionbar
        //Toolbar miActionBar = (Toolbar)findViewById(R.id.actionBar);
        /*setSupportActionBar(miActionBar);*/

        //Validacin para el toolbar
        /*if(toolbar!=null){
            setSupportActionBar(toolbar);
        }*/

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




    private ArrayList<Fragment>agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }
    //Este metodo pone en orbita los fragments para ser visualizados e instanciados
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);
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
                Intent intent= new Intent(MainActivity.this,AcercaMenu.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent i = new Intent(MainActivity.this,ContactoMenu.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}