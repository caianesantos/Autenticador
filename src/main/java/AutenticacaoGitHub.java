public class AutenticacaoGitHub implements AutenticacaoStrategy {
    @Override
    public void autenticar(Usuario usuario) {
        System.out.println("Conectando ao provedor OAuth do GitHub...");
        usuario.setAutenticado(true);
        System.out.println("-> Sucesso: Autenticado via GitHub.");
    }
}
