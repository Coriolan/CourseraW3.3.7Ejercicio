package com.example.w337project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.main_actionbar);
        setSupportActionBar(miActionBar);

        this.listaMascotas = (RecyclerView) findViewById(R.id.rv_main_mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        this.listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.i_favoritos) {
            Intent intent = new Intent(this, Favoritos.class);
            startActivity(intent);
        }
        return true;
    }

    private void inicializarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(this.mascotas, this);
        listaMascotas.setAdapter(adapter);
    }

    private void inicializarListaMascotas() {
        this.mascotas = new ArrayList<Mascota>();

        Random rand = new Random();

        this.mascotas.add(new Mascota("Cathy", rand.nextInt(11), R.drawable.pet1));
        this.mascotas.add(new Mascota("Ronny", rand.nextInt(11), R.drawable.pet2));
        this.mascotas.add(new Mascota("Firulais", rand.nextInt(11), R.drawable.pet3));
        this.mascotas.add(new Mascota("Fido", rand.nextInt(11), R.drawable.pet4));
        this.mascotas.add(new Mascota("Pluto", rand.nextInt(11), R.drawable.pet5));
        this.mascotas.add(new Mascota("Ayudante de Santa", rand.nextInt(11), R.drawable.pet6));
        this.mascotas.add(new Mascota("Snoopy", rand.nextInt(11), R.drawable.pet7));
        this.mascotas.add(new Mascota("Odie", rand.nextInt(11), R.drawable.pet8));
        this.mascotas.add(new Mascota("Garfield", rand.nextInt(11), R.drawable.pet9));
        this.mascotas.add(new Mascota("Simba", rand.nextInt(11), R.drawable.pet10));
    }
}