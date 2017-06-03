package tomas.recyclerview_edittext;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


public class PruebaAdapter extends RecyclerView.Adapter<PruebaAdapter.PruebaViewHolder> {

    List<String> lista;
    String[] escrito;

    public PruebaAdapter(List<String> lista) {
        this.lista = lista;
        escrito = new String[lista.size()];
    }

    @Override
    public PruebaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new PruebaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PruebaViewHolder holder, int position) {
         String producto = lista.get(position);
         holder.bindProducto(producto);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public String[] getEscrito() {
        return escrito;
    }

    public class PruebaViewHolder extends RecyclerView.ViewHolder{

        EditText etCantidad;
        TextView tvProducto;

        public PruebaViewHolder(View itemView) {
            super(itemView);
            etCantidad = (EditText) itemView.findViewById(R.id.etCantidad);
            tvProducto = (TextView) itemView.findViewById(R.id.tvProducto);
            etCantidad.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    escrito[getAdapterPosition()] = s.toString();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }

        public void bindProducto(String nombre){
            tvProducto.setText(nombre);
        }

    }
}
