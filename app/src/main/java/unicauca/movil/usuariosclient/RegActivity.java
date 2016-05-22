package unicauca.movil.usuariosclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

import unicauca.movil.usuariosclient.databinding.ActivityRegBinding;
import unicauca.movil.usuariosclient.models.Usuario;
import unicauca.movil.usuariosclient.net.api.UsuariosApi;

public class RegActivity extends AppCompatActivity implements View.OnClickListener, UsuariosApi.OnRegListener {

    ActivityRegBinding binding;
    UsuariosApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setOnClick(this);

        api =  new UsuariosApi(this);
    }

    @Override
    public void onClick(View v) {
        Usuario usr = new Usuario();
        usr.setCorreo(binding.correo.getText().toString());
        usr.setNombre(binding.nombre.getText().toString());
        usr.setUsuario(binding.usr.getText().toString());
        usr.setPassword(binding.pass.getText().toString());
        usr.setFechaNacimiento(new Date());

        api.registrar(usr, this);

    }

    @Override
    public void onReg(boolean success, Usuario usr) {
        if(success){
            Toast.makeText(this,R.string.reg_success,Toast.LENGTH_SHORT ).show();
            finish();
        }else{
            Toast.makeText(this,R.string.reg_error,Toast.LENGTH_SHORT ).show();
        }
    }
}
