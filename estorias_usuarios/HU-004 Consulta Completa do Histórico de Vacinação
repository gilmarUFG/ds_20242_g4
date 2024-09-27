### **ID:**  
HU-004

### **Título:**  
Consulta Completa do Histórico de Vacinação

### **Descrição:**  
Como **um profissional de saúde**, eu quero **acessar o histórico completo de vacinação do cidadão pelo sistema do SUS** para que **eu possa verificar as vacinas aplicadas e garantir que ele esteja devidamente imunizado**.

### **Critérios de Aceitação:**

#### Cenário 1: Consulta de Histórico de Vacinação
- **Dado** que o profissional de saúde está autenticado no sistema,
- **Quando** ele busca pelo CPF ou Cartão SUS do cidadão,
- **E** o cidadão tem vacinas registradas no sistema,
- **Então** o histórico completo de vacinação deve ser exibido com detalhes das vacinas aplicadas.

#### Cenário 2: Nenhum registro de vacina encontrado
- **Dado** que o profissional de saúde está autenticado no sistema,
- **Quando** ele busca pelo CPF ou Cartão SUS de um cidadão sem vacinas registradas,
- **Então** uma mensagem de erro deve ser exibida, informando que o código está incorreto,
- **E** o sistema deve exibir uma mensagem indicando que nenhum registro de vacina foi encontrado.

#### Cenário 3: Falha no login por expiração do código 2FA
- **Dado** que o profissional de saúde tenta se autenticar no sistema,
- **Quando** o código 2FA expira,
- **Então** o sistema deve informar a falha e solicitar um novo código.

### **Prioridade:**  
Alta

### **Estimativa de Esforço:**  
5 Story Points

### **Dependências:**  
- Integração com o sistema SUS. 
- Autenticação segura.

### **Notas/Comentários Adicionais:**
- A consulta de histórico deve ser rápida e em tempo real, com proteção adequada de dados.
