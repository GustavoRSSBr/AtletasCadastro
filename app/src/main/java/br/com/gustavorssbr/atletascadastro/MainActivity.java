package br.com.gustavorssbr.atletascadastro;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle extras = getIntent().getExtras();

        if (extras != null && extras.containsKey("tipoAtleta")) {
            carregarFragment(extras);
        }
    }

    private void carregarFragment(Bundle extras) {
        String tipoAtleta = extras.getString("tipoAtleta");

        if ("JV".equals(tipoAtleta)) {
            fragment = new JuvenilFragment();
        } else if ("SR".equals(tipoAtleta)) {
            fragment = new SeniorFragment();
        } else {
            fragment = new OutroFragment();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, MainActivity.class);

        if (id == R.id.atleta_juvenil) {
            bundle.putString("tipoAtleta", "JV");
        } else if (id == R.id.atleta_senior) {
            bundle.putString("tipoAtleta", "SR");
        } else if (id == R.id.outros_atletas) {
            bundle.putString("tipoAtleta", "OT");
        } else {
            return super.onOptionsItemSelected(item);
        }

        intent.putExtras(bundle);
        startActivity(intent);
        finish();

        return true;
    }
}
