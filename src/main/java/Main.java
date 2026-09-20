public class Main {
    public static void main(String[] args) {
        Usuario usuario = new UsuarioImpl();
        LoginService loginService = new LoginService();

        System.out.println("--- Testando Provedores Originais ---");
        loginService.realizarLogin("credencial", usuario);
        loginService.realizarLogin("google", usuario);
        loginService.realizarLogin("facebook", usuario);

        System.out.println("\n--- Testando Novos Provedores ---");
        loginService.realizarLogin("microsoft", usuario);
        loginService.realizarLogin("github", usuario);

        System.out.println("\n--- Testando Comportamento de Erro (Provedor Inexistente) ---");
        try {
            loginService.realizarLogin("apple", usuario);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro Capturado com sucesso: " + e.getMessage());
        }
    }
}