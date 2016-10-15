package com.example.fic.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ListView listagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] dados = new String []{
                "Ir para a padaria",
                "Preparar os filhos para ir para a Igreja",
                "Ir para a Igreja",
                "Comprar pipoca",
                "Voltar para casa",
                "Preparar comida",
                "Receber bronca da esposa",
                "Lavar o carro",
                "Ir para a padaria",
                "Preparar os filhos para ir para a Igreja",
                "Ir para a Igreja",
                "Comprar pipoca",
                "Voltar para casa",
                "Preparar comida",
                "Receber bronca da esposa",
                "Lavar o carro",
                "Ir para a padaria",
                "Preparar os filhos para ir para a Igreja",
                "Ir para a Igreja",
                "Comprar pipoca",
                "Voltar para casa",
                "Preparar comida",
                "Receber bronca da esposa",
                "Lavar o carro",
                "Ir para a padaria",
                "Preparar os filhos para ir para a Igreja",
                "Ir para a Igreja",
                "Comprar pipoca",
                "Voltar para casa",
                "Preparar comida",
                "Receber bronca da esposa",
                "Lavar o carro"
        };

        //Adaptador de dados da ListView
        //Primeiro parâmetro: context
        //Segundo parâmetro: layout das linhas
        //Terceiro parâmetro: valores a serem exibidos
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dados);

        listagem = (ListView) findViewById(R.id.listagem);
        listagem.setAdapter(adaptador);
        listagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "Posição " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void criarTarefaClick(View view){
        Intent cadastro = new Intent(this, NovaActivity.class);
        startActivity(cadastro);
    }
}
