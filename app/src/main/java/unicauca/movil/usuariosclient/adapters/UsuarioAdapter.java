package unicauca.movil.usuariosclient.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import unicauca.movil.usuariosclient.databinding.TemplateUsuarioBinding;
import unicauca.movil.usuariosclient.models.Usuario;

/**
 * Created by Dario Chamorro on 22/05/2016.
 */
public class UsuarioAdapter extends BaseAdapter {

    LayoutInflater inflater;
    List<Usuario> data;

    public UsuarioAdapter(LayoutInflater inflater, List<Usuario> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TemplateUsuarioBinding binding =  TemplateUsuarioBinding.inflate(inflater);
        binding.setUsuario(data.get(position));
        return binding.getRoot();
    }
}
