package tomas.recyclerview_edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal extends AppCompatActivity {

    RecyclerView rvPrueba;
    Button btnCalcular;
    List<String> lista = Arrays.asList("Item 1","Item 2","Item 3");
    PruebaAdapter adapter;
    boolean bandera = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        rvPrueba = (RecyclerView) findViewById(R.id.rvPrueba);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvPrueba.setLayoutManager(llm);

        adapter = new PruebaAdapter(lista);
        rvPrueba.setAdapter(adapter);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String[] escrito = adapter.getEscrito();
                int resultado = 0;

                for(int i = 0;i< escrito.length;i++){
                    if(escrito[i] == null){
                         bandera = false;
                         return;
                    }
                    else{
                        if(escrito[i].equals("")){
                            bandera=false;
                            return;
                        }
                    }
                }

                if(bandera){
                    for(int i = 0;i< escrito.length;i++){
                        resultado+= Integer.parseInt(escrito[i]);
                    }

                    Toast.makeText(getApplicationContext(),"Resultado : " + resultado,Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
