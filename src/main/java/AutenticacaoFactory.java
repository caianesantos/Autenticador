import java.util.HashMap;
import java.util.Map;

public class AutenticacaoFactory {
    private static final Map<String, AutenticacaoStrategy> estrategias = new HashMap<>();

    static {
        estrategias.put("credencial", new AutenticacaoCredencial());
        estrategias.put("google", new AutenticacaoGoogle());
        estrategias.put("facebook", new AutenticacaoFacebook());
        estrategias.put("microsoft", new AutenticacaoMicrosoft());
        estrategias.put("github", new AutenticacaoGitHub());
    }

    public static AutenticacaoStrategy getEstrategia(String metodo) {
        AutenticacaoStrategy estrategia = estrategias.get(metodo.toLowerCase());
        if (estrategia == null) {
            throw new IllegalArgumentException("Método de autenticação não suportado: " + metodo);
        }
        return estrategia;
    }
}