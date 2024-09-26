## **História de Usuário**

### **ID:**  
HU-017

### **Título:**  
Visualização de vacinas futuras

### **Descrição:**  
Como **cidadão**, eu quero **visualizar as próximas doses de vacina que eu preciso tomar** para que **eu possa me programar para tomar as vacinas necessárias**.

### **Critérios de Aceitação:**

#### Cenário 1: Visualização de vacinas futuras
- **Dado** que o cidadão está na página de histórico de vacinação,
- **Quando** ele acessa a seção de vacinas futuras,
- **Então** o sistema deve listar as próximas vacinas ou doses que ele precisa tomar,
- **E** exibir as datas previstas para cada aplicação.

#### Cenário 2: Falha ao carregar as vacinas futuras 
- **Dado** que o cidadão está tentando acessar a página de vacinas futuras,
- **Quando** o sistema falha ao recuperar as informações das próximas doses de vacina,
- **Então** uma mensagem de erro deve ser exibida informando que as vacinas futuras não puderam ser carregadas no momento,
- **E** o sistema deve oferecer uma opção para o usuário tentar novamente.

### **Prioridade:**  
Alta

### **Estimativa de Esforço:**  
3 Story Points 

### **Dependências:**  
- ntegração com o calendário de vacinação oficial do SUS para exibir as próximas vacinas com base na faixa etária do cidadão.
- Desenvolvimento da interface de visualização das vacinas futuras.
- Implementação de notificações automáticas para alertar sobre datas de aplicação próximas.

### **Notas/Comentários Adicionais:**
- As vacinas futuras devem ser exibidas em ordem cronológica, com indicação das datas recomendadas para cada dose.
- Garantir que a interface seja intuitiva e exiba os dados de maneira clara e objetiva.
