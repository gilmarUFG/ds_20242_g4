### **ID:**  
HU-005

### **Título:**  
Consulta de Vacinas Pendentes e Reforços

### **Descrição:**  
Como **um profissional de saúde**, eu quero **consultar o histórico de vacinação do cidadão para identificar vacinas pendentes ou reforços necessários** para que **eu possa garantir que o cidadão esteja com todas as vacinas recomendadas em dia.**.

### **Critérios de Aceitação:**

#### Cenário 1: Consulta de Histórico de Vacinação
- **Dado** que o profissional de saúde está autenticado no sistema,
- **Quando** ele busca pelo CPF ou Cartão SUS do cidadão,
- **E** o cidadão tem vacinas pendentes ou reforços próximos,
- **Então** o sistema deve exibir as vacinas pendentes e as datas recomendadas para aplicação.

#### Cenário 2: Nenhum registro de vacina encontrado
- **Dado** que o profissional de saúde está autenticado no sistema,
- **Quando** ele busca pelo CPF ou Cartão SUS de um cidadão com todas as vacinas em dia,
- **Então** o sistema deve exibir uma mensagem indicando que todas as vacinas estão atualizadas.

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
- As vacinas pendentes devem ser destacadas no histórico, com datas de reforço.
