public class AutenticacaoFacebook implements AutenticacaoStrategy {
    @Override
    public void autenticar(Usuario usuario) {
        System.out.println("Conectando ao provedor OAuth do Facebook...");
        usuario.setAutenticado(true);
        System.out.println("-> Sucesso: Autenticado via Facebook.");
    }
}
