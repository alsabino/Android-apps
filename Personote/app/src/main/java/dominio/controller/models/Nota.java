package dominio.controller.models;

import java.util.Date;

/**
 * Created by alsabino on 29/03/2018.
 */

public class Nota {
    private Long id;
    private String titulo;
    private String texto;
    private Date data;
    private Clima clima;

    public Nota() {
    }

    public Nota(String titulo, String texto, Date data, String tempo, Long temperatura) {
        this.titulo = titulo;
        this.texto = texto;
        this.data = data;
        this.clima = clima;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Clima getClima() {
        return clima;
    }

    public void setClima(Clima clima) {
        this.clima = clima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
