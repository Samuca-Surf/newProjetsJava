package model;
// Sempre tem os atributos, os getters e setters

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Tarefa {

    private static Long incremento = 0L;
    private Long id; //identificador unico
    private String titulo;
    private String local;
    private Double duracao;
    private LocalDate data;

    public Tarefa() {}

    public Tarefa(String titulo, String local, Double duracao, LocalDate data) {
        this.id = ++incremento;
        this.titulo = titulo;
        this.local = local;
        this.duracao = duracao;
        this.data = data;
    }

    public Tarefa(Long id, String titulo, String local, Double duracao, LocalDate data) {
        this.id = id;
        this.titulo = titulo;
        this.local = local;
        this.duracao = duracao;
        this.data = data;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Tarefa{" + "     id= " + id + "     titulo= " + titulo + "     local= " + local + "     Duração= " + duracao + "     Data= " + data.format(formatoBR) + "   }";
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
