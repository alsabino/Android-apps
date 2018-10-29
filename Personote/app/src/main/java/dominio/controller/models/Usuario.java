package dominio.controller.models;

/**
 * Created by alsabino on 29/03/2018.
 */

public class Usuario {

    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (!email.equals(usuario.email)) return false;
        return senha.equals(usuario.senha);
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + senha.hashCode();
        return result;
    }
}
