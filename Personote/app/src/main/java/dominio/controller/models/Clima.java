package dominio.controller.models;

/**
 * Created by alsabino on 29/03/2018.
 */

public class Clima {
    private Long Id;
    private Long temperatura;
    private String clima;

    public Clima() {
    }

    public Clima(Long temperatura, String clima) {
        this.temperatura = temperatura;
        this.clima = clima;
    }

    public Long getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Long temperatura) {
        this.temperatura = temperatura;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
