public class LoginService {
    public void realizarLogin(String metodo, Usuario usuario) {
        AutenticacaoStrategy estrategia = AutenticacaoFactory.getEstrategia(metodo);

        estrategia.autenticar(usuario);
    }
}