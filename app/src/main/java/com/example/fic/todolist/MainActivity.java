package com.example.fic.todolist;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fic.todolist.dao.TarefaDao;
import com.example.fic.todolist.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView listagem;


    private TarefaDao tarefaDao;
    private List<Tarefa> tarefas;

    @Override
    protected void onResume() {
        super.onResume();

        tarefas = tarefaDao.listar();


        //String [] dados = new String [];
        //dados[0] = I{
        //       "Ir para a padaria",
        //      "Preparar os filhos para ir para a Igreja",
        //     "Ir para a Igreja",
        //    "Comprar pipoca",
        //    "Voltar para casa",
        //    "Preparar comida",
        //   "Receber bronca da esposa",
        //   "Lavar o carro"
        //};

        //Adaptador de dados da ListView
        //Primeiro parâmetro: context
        //Segundo parâmetro: layout das linhas
        //Terceiro parâmetro: valores a serem exibidos
        ArrayAdapter<Tarefa> adaptador = new ArrayAdapter<Tarefa>(this, android.R.layout.simple_spinner_dropdown_item, tarefas);

        listagem = (ListView) findViewById(R.id.listagem);
        listagem.setAdapter(adaptador);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);



    tarefaDao = new TarefaDao(this);

        tarefas = tarefaDao.listar();


            //String [] dados = new String [];
            //dados[0] = I{
             //       "Ir para a padaria",
              //      "Preparar os filhos para ir para a Igreja",
               //     "Ir para a Igreja",
                //    "Comprar pipoca",
                //    "Voltar para casa",
                //    "Preparar comida",
                 //   "Receber bronca da esposa",
                 //   "Lavar o carro"
            //};

            //Adaptador de dados da ListView
            //Primeiro parâmetro: context
            //Segundo parâmetro: layout das linhas
            //Terceiro parâmetro: valores a serem exibidos
            ArrayAdapter<Tarefa> adaptador = new ArrayAdapter<Tarefa>(this, android.R.layout.simple_spinner_dropdown_item, tarefas);

            listagem = (ListView) findViewById(R.id.listagem);
            listagem.setAdapter(adaptador);
            listagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(MainActivity.this, "Posição " + position, Toast.LENGTH_SHORT).show();
                }
            });

            listagem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(MainActivity.this, "Será que o lagarto mama?", Toast.LENGTH_SHORT).show();

                    final int posicao = position;

                    final AlertDialog.Builder confirma = new AlertDialog.Builder(MainActivity.this);
                    confirma.setTitle("EXCLUSÃO DE TAREFA");
                    confirma.setMessage("Deseja excluir a tarefa?");
                    confirma.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    confirma.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Tarefa tarefa = tarefas.get(posicao);
                            tarefaDao.excluir(tarefa);
                        }
                    });
                    confirma.show();

                    return false;
                }
            });
    }

    public void criarTarefaClick(View view){
        Intent cadastro = new Intent(this, NovaActivity.class);
        startActivity(cadastro);
    }
}
