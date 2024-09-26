## **História de Usuário**

### **ID:**  
HU-016

### **Título:**  
Acompanhamento do histórico de vacinas

### **Descrição:**  
Como **cidadão**, eu quero **acompanhar meu histórico de vacinação** para que **possa garantir que minhas vacinas estão em dia e acompanhar minha saúde preventiva**.

### **Critérios de Aceitação:**

#### Cenário 1: Visualização do histórico de vacinação
- **Dado** que o cidadão está logado no sistema Meu SUS Digital,
- **Quando** ele acessa a página de histórico de vacinação,
- **Então** o sistema deve exibir uma lista das vacinas já tomadas, com as respectivas datas de aplicação.

#### Cenário 2: Informação sobre vacinas vencidas
- **Dado** que o cidadão visualiza seu histórico de vacinação,
- **Quando** uma vacina no histórico está vencida ou faltando doses,
- **Então** o sistema deve destacar essa informação em vermelho,
- **E** sugerir que o cidadão tome medidas para regularizar a situação.

#### Cenário 3: Histórico incompleto
- **Dado** que o cidadão acessa seu histórico de vacinação,
- **Quando** o sistema não consegue encontrar informações completas sobre uma ou mais vacinas,
- **Então** o sistema deve exibir uma mensagem informando sobre dados faltantes,
- **E** fornecer instruções sobre como o cidadão pode regularizar essa situação (ex.: visitar um posto de saúde).

#### Cenário 4: Solicitação de correção de dados
- **Dado** que o cidadão nota um erro no seu histórico de vacinação (ex.: uma vacina registrada incorretamente),
- **Quando** ele clica no botão "Solicitar Correção",
- **Então** o sistema deve permitir que o cidadão envie uma solicitação para revisão dos dados,
- **E** o sistema deve notificar o cidadão do acompanhamento da solicitação.

### **Prioridade:**  
Alta

### **Estimativa de Esforço:**  
5 Story Points 

### **Dependências:**  
- Integração com a base de dados do SUS para obter o histórico de vacinação completo do cidadão.
- Desenvolvimento da interface de visualização do histórico de vacinas.

### **Notas/Comentários Adicionais:**
- O histórico de vacinas deve exibir as doses de forma cronológica, a data e o local de aplicação.
- Assegurar que o acesso aos dados pessoais de vacinação esteja protegido e que apenas o cidadão autorizado possa visualizar seu histórico.
- Incluir uma opção de exportar o histórico de vacinação em formato PDF.
