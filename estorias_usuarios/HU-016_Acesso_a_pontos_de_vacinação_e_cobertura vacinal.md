## **História de Usuário**

### **ID:**  
HU-016

### **Título:**  
Acesso a pontos de vacinação e cobertura vacinal

### **Descrição:**  
Como **cidadão**, eu quero **acessar um mapa com pontos de vacinação e informações sobre os índices de cobertura vacinal na minha região** para que **eu possa me manter informado sobre a situação e tomar decisões de prevenção**.

### **Critérios de Aceitação:**

#### Cenário 1: Visualização de pontos de vacinação
- **Dado** o cidadão está na página de monitoramento de vacinação,
- **Quando** o cidadão acessa o mapa interativo,
- **Então** o sistema deve exibir os pontos de vacinação disponíveis na região selecionada,
- **E** deve permitir visualizar os horários de funcionamento e a disponibilidade de vacinas.

#### Cenário 2: Visualização de cobertura vacinal
- **Dado** o cidadão selecionou uma região no mapa,
- **Quando** o cidadão acessa as informações de cobertura vacinal,
- **Então** o sistema deve exibir o índice de vacinação da região,
- **E** deve permitir filtrar os dados (por tipo de vacina e faixa etária).

#### Cenário 3: Falta de dados de vacinação disponíveis
- **Dado** o cidadão está tentando acessar os dados de cobertura vacinal de uma região,
- **Quando** não houver dados disponíveis para a região selecionada,
- **Então** o sistema deve exibir uma mensagem informando que os dados de vacinação não estão disponíveis para a região no momento,
- **E** deve sugerir que o cidadão tente novamente mais tarde ou entre em contato com as autoridades de saúde locais para mais informações.

### **Prioridade:**  
Média

### **Estimativa de Esforço:**  
8 Story Points 

### **Dependências:**  
- Integração com a base de dados do SUS.
- Desenvolvimento da interface de visualização do mapa.
- Dados atualizados sobre pontos de vacinação e disponibilidade de vacinas.

### **Notas/Comentários Adicionais:**
- Incluir instruções claras para os cidadãos sobre como acessar as informações de cobertura vacinal.
- Considerrar o sistema de notificação sobre campanhas de vacinação para regiões com baixa cobertura.
- Assegurar que o sistema seja responsivo.
