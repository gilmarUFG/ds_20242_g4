## **História de Usuário**


### **ID:** 
HU-002


### **Título:** 
Notificação de Sincronização de Vacinação


### **Descrição:** 
Como **cidadão**, eu quero **receber notificações quando meus dados de vacinação forem sincronizados com sucesso com o SUS** para que **eu possa confirmar que meu histórico está atualizado**.


### **Critérios de Aceitação:**


#### Cenário 1: Notificação de sucesso
- **Dado** que os dados de vacinação do cidadão foram sincronizados com o SUS,
- **Quando** a sincronização é concluída com sucesso,
- **Então** o cidadão deve receber uma notificação confirmando a atualização do histórico de vacinação.


#### Cenário 2: Notificação de nova vacina
- **Dado** que o cidadão tomou uma nova vacina,
- **Quando** a nova vacina tomada constar no sistema,
- **Então** o cidadão deve receber uma notificação informando sobre a adição de uma nova vacina em seu histórico.


#### Cenário 3: Opção de desativar notificações
- **Dado** que o cidadão não deseja receber notificações,
- **Quando** acessa as configurações de notificação,
- **Então** deve ter a opção de desativar as notificações de sincronização de vacinação.


### **Prioridade:** 
Média


### **Estimativa de Esforço:** 
5 Story Points


### **Dependências:** 
- Sistema de notificações.


### **Notas/Comentários Adicionais:**
- As notificações podem ser enviadas via SMS, e-mail ou aplicativo.