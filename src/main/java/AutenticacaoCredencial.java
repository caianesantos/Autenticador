public class AutenticacaoCredencial implements AutenticacaoStrategy {
    @Override
    public void autenticar(Usuario usuario) {
        System.out.println("Validando e-mail e senha localmente...");
        usuario.setAutenticado(true);
        System.out.println("-> Sucesso: Autenticado via Credencial.");
    }
}