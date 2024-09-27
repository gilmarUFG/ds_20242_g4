### **ID:**  
HU-006

### **Título:**  
Consulta de Vacinação em Situações de Emergência

### **Descrição:**  
Como **um profissional de saúde**, eu quero **acessar rapidamente o histórico de vacinação do cidadão em situações de emergência** para que **eu possa verificar se o cidadão está imunizado contra doenças específicas e agir conforme necessário**.

### **Critérios de Aceitação:**

#### Cenário 1: Consulta de Histórico de Vacinação
- **Dado** que o profissional de saúde está autenticado no sistema,
- **Quando** ele busca pelo CPF ou Cartão SUS do cidadão,
- **E** o cidadão tem vacinas relevantes para a emergência em questão,
- **Então** o sistema deve exibir essas vacinas em destaque.

#### Cenário 2: Nenhum registro de vacina encontrado
- **Dado** que o profissional de saúde está autenticado no sistema,
- **Quando** ele busca pelo CPF ou Cartão SUS de um cidadão,
- **E** o cidadão não tem vacinas relevantes para a emergência
- **Então** o sistema deve exibir uma mensagem indicando que não há imunizações específicas para a situação.

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
- A consulta em situações de emergência deve ser rápida e precisa, com destaque para vacinas relacionadas ao surto ou doença em questão.
