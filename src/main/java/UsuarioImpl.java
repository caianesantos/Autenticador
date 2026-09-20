public class UsuarioImpl implements Usuario {
    private boolean autenticado = false;

    @Override
    public boolean estaAutenticado() {
        return autenticado;
    }

    @Override
    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}