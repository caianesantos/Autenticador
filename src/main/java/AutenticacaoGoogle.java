public class AutenticacaoGoogle implements AutenticacaoStrategy {
    @Override
    public void autenticar(Usuario usuario) {
        System.out.println("Conectando ao provedor OAuth do Google...");
        usuario.setAutenticado(true);
        System.out.println("-> Sucesso: Autenticado via Google.");
    }
}
