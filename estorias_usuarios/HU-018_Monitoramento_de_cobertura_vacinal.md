## **História de Usuário**

### **ID:**  
HU-018

### **Título:**  
Monitoramento de cobertura vacinal

### **Descrição:**  
Como **agente de saúde**, eu quero **monitorar a cobertura vacinal de uma determinada região** para que **eu possa identificar o índice de vacinação e promover campanhas mais eficazes**.

### **Critérios de Aceitação:**

#### Cenário 1: Visualização da cobertura vacinal por região
- **Dado** que o agente de saúde está na página de monitoramento de cobertura vacinal,
- **Quando** o agente seleciona uma região no mapa,
- **Então** o sistema deve exibir o índice de vacinação da região selecionada,
- **E** deve permitir filtrar os dados por tipo de vacina e faixa etária.

#### Cenário 2: Acesso negado por falta de autorização
- **Dado** que um agente de saúde tenta acessar os dados de uma região para a qual ele não tem autorização,
- **Quando** ele seleciona a região no mapa,
- **Então** o sistema deve exibir uma mensagem de erro informando que ele não tem permissão para visualizar os dados daquela região.

#### Cenário 3: Identificação de regiões com baixa cobertura vacinal
- **Dado** que o agente de saúde está visualizando o índice de vacinação de uma região,
- **Quando** a cobertura vacinal de uma região estiver abaixo de um limite predefinido,
- **Então** o sistema deve gerar um alerta automático sugerindo a necessidade de campanha de vacinação.

### **Prioridade:**  
Baixa

### **Estimativa de Esforço:**  
13 Story Points 

### **Dependências:**  
- Integração com a base de dados de vacinação do SUS.
- Desenvolvimento da interface de visualização do mapa das regiões, permitindo selecionar e visualizar os índices de vacinação por área.
- Integração com o sistema de notificações de campanhas de vacinação.

### **Notas/Comentários Adicionais:**
- Assegurar que as métricas usadas no sistema estão alinhadas com as práticas recomendadas.
- Incluir na interface uma legenda ou instruções claras para o agente de saúde sobre como interpretar os gráficos de cobertura vacinal.
- Garantir a escalabilidade do sistema.
