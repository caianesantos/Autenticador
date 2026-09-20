# Análise de Arquitetura: Refatoração do Serviço de Autenticação

## 1. Princípio SOLID Relacionado
O problema existente no código original está diretamente relacionado à violação do **Princípio do Aberto/Fechado (Open/Closed Principle - OCP)**, que é a letra "O" do acrônimo SOLID.

**O que o princípio diz:**
> "Entidades de software (classes, módulos, funções, etc.) devem estar **abertas para extensão**, mas **fechadas para modificação**."

**Por que foi violado no código original?**
Na implementação inicial, a classe `LoginService` possuía uma estrutura condicional (`if/else if`) que verificava a string do método de autenticação. Para que a equipe pudesse cumprir o novo requisito de adicionar login via Microsoft ou GitHub, seria obrigatório **abrir e modificar** o código da classe `LoginService` inserindo novos blocos `else if`. Isso fere o princípio OCP, pois a classe não estava "fechada para modificação". Alterar classes centrais constantemente aumenta o acoplamento e o risco de introduzir novos bugs em funcionalidades que já estavam operando corretamente.

---

## 2. Padrões de Projeto Utilizados
Para resolver este problema e organizar os diferentes comportamentos de autenticação, foi utilizada a combinação de dois padrões de projeto:

### A. Padrão Strategy (Comportamental)
O padrão principal utilizado para resolver o problema estrutural foi o **Strategy**.
* **Como funciona:** O Strategy permite definir uma família de algoritmos, encapsular cada um deles em uma classe separada e torná-los intercambiáveis.
* **Aplicação no problema:** Criamos a interface `AutenticacaoStrategy` com o método `autenticar(Usuario)`. Cada provedor (Credencial, Google, Facebook, Microsoft, GitHub) tornou-se uma classe concreta que assina este contrato. O `LoginService` agora apenas chama o método `autenticar` da interface genérica, sem precisar conhecer os detalhes de implementação de cada provedor.

### B. Padrão Factory / Simple Factory (Criacional)
Como complemento essencial para manter a assinatura original do método `realizarLogin(String, Usuario)`, utilizamos o padrão **Factory**.
* **Aplicação no problema:** Criamos a classe `AutenticacaoFactory` utilizando um `Map` (Dicionário) que relaciona a `String` (ex: "google") à instância da estratégia correspondente (`AutenticacaoGoogle`). A Factory fica responsável por descobrir e retornar o objeto correto.

---

## 3. Conclusão e Benefícios da Refatoração
Ao aplicar o **Strategy** em conjunto com a **Factory**, o sistema alcançou os seguintes benefícios:
1. **Conformidade com o OCP:** Agora, se um novo provedor de login surgir no futuro (ex: Apple), basta criar uma nova classe `AutenticacaoApple` e registrá-la na Factory. A classe `LoginService` permanecerá **intacta**.
2. **Alta Coesão:** Cada classe de estratégia agora tem apenas um motivo para mudar (Princípio de Responsabilidade Única - SRP). Se a API do Google mudar, apenas a classe `AutenticacaoGoogle` será alterada.
3. **Eliminação de Código "Espaguete":** A cadeia complexa de `if/else` foi completamente eliminada, tornando a manutenção e a leitura do código muito mais simples.