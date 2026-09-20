public class AutenticacaoMicrosoft implements AutenticacaoStrategy {
    @Override
    public void autenticar(Usuario usuario) {
        System.out.println("Conectando ao provedor OAuth da Microsoft...");
        usuario.setAutenticado(true);
        System.out.println("-> Sucesso: Autenticado via Microsoft.");
    }
}
