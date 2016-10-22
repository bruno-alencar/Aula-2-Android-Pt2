package com.example.fic.todolist.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ListView;

import com.example.fic.todolist.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FIC on 22/10/2016.
 */

public class TarefaDao extends SQLiteOpenHelper{

    private final static int VERSAO = 1;
    private SQLiteDatabase bdTarefa;
    public TarefaDao(Context context) {
        super(context, "tarefa_schema", null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("TAREFA", "Executando o onCreate do banco de dados");
        db.execSQL("create table if not exists tarefa(id integer primary key autoincrement," +
                "titulo text not null, " +
                "concluida integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("TAREFA", "Executando o onUpgrade do banco de dados");
        db.execSQL("drop table if  exists tarefa");
        db.execSQL("create table if not exists tarefa(id integer primary key autoincrement," +
                "titulo text not null, " +
                "concluida integer)");
    }

    public List<Tarefa> listar(){
        List<Tarefa> tarefas = new ArrayList<Tarefa>();

        String [] colunas = new String[]{"id", "titulo", "concluida"};

        bdTarefa = getReadableDatabase();
        Cursor dados = bdTarefa.query("tarefa", colunas , null, null, null, null, "concluida, titulo");

        if(dados.moveToFirst()){
            do{
                Tarefa tarefa = new Tarefa();
                tarefa.setId(dados.getLong(dados.getColumnIndex("id")));
                tarefa.setTitulo(dados.getString(1));
                tarefa.setConcluida(dados.getInt(2) == 0? false: true);

                tarefas.add(tarefa);
            }while (dados.moveToNext());
        }

        bdTarefa.close();
        return tarefas;
    }


    public void inserir(Tarefa tarefa){
        ContentValues dados = new ContentValues();
        dados.put("titulo", tarefa.getTitulo());
        //Operador ternário (if mais facil)
        //dados.put("concluida", tarefa.getConcluida()== true? 1);
        dados.put("concluida", tarefa.getConcluida()? 1 : 0);

        bdTarefa = getWritableDatabase();
        Long id_gerado = bdTarefa.insert("tarefa", null, dados);
        bdTarefa.close();

        tarefa.setId(id_gerado);
    }

    public void excluir(Tarefa tarefa){
        excluir(tarefa.getId());
    }

    public void excluir(Long id){
        bdTarefa = getWritableDatabase();
        bdTarefa.delete("tarefa", "id=" + id, null);
        bdTarefa.close();
    }
}
