package com.example.fic.todolist;

import android.content.Intent;
import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fic.todolist.dao.TarefaDao;
import com.example.fic.todolist.model.Tarefa;

public class NovaActivity extends AppCompatActivity {

    private EditText txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova);

        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
    }

    public void salvarClick(View view){
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(txtTitulo.getText().toString());

        TarefaDao tarefaDao = new TarefaDao(this);
        tarefaDao.inserir(tarefa);

        txtTitulo.setText("");

        Intent telaAnterior = new Intent(this, MainActivity.class);
        startActivity(telaAnterior);
    }
}
