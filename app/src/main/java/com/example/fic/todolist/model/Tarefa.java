package com.example.fic.todolist.model;

/**
 * Created by FIC on 22/10/2016.
 */

public class Tarefa {
    private Long id;
    private String titulo;
    private Boolean concluida;

    public Tarefa() {
        this.titulo = "";
        this.concluida = false;
    }

    public Tarefa(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluido) {
        this.concluida = concluido;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}

