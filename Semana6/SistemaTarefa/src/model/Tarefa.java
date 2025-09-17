package model;
// Sempre tem os atributos, os getters e setters

import java.util.Objects;

public class Tarefa {

    private static Long incremento = 0L;
    private Long id; //identificador unico
    private String titulo;

    public Tarefa() {
    }

    public Tarefa(String titulo) {
        this.id = ++incremento;
        this.titulo = titulo;
    }

    public Tarefa(Long id, String titulo) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Tarefa{" + "   id= " + id + "   titulo= " + titulo + " " + "   }";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
