package unicauca.movil.usuariosclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.usuariosclient.adapters.UsuarioAdapter;
import unicauca.movil.usuariosclient.databinding.ActivityMainBinding;
import unicauca.movil.usuariosclient.models.Usuario;
import unicauca.movil.usuariosclient.net.api.UsuariosApi;

public class MainActivity extends AppCompatActivity implements UsuariosApi.OnUsuariosListener {

    List<Usuario> data;
    UsuariosApi api;
    UsuarioAdapter adapter;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        data = new ArrayList<>();
        adapter = new UsuarioAdapter(getLayoutInflater(), data);
        api = new UsuariosApi(this);

        binding.setAdapter(adapter);

        api.getUsuarios(this);

    }

    @Override
    public void onUsuarios(List<Usuario> usuarios) {
        for(Usuario u: usuarios){
            data.add(u);
        }
        adapter.notifyDataSetChanged();
    }
}
