## **História de Usuário**


### **ID:** 
HU-003


### **Título:** 
Consulta de Histórico de Vacinação Sincronizado


### **Descrição:** 
Como **cidadão**, eu quero **poder consultar meu histórico de vacinação sincronizado com o SUS** para **verificar todas as vacinas que já tomei**.


### **Critérios de Aceitação:**


#### Cenário 1: Consulta bem-sucedida
- **Dado** que o cidadão acessa o sistema do SUS,
- **Quando** clica para consultar o histórico de vacinação,
- **Então** deve ver uma lista completa e atualizada de todas as vacinas administradas.


#### Cenário 2: Histórico incompleto
- **Dado** que o cidadão acessa o sistema do SUS,
- **Quando** há falhas na sincronização de algumas vacinas,
- **Então** deve ser exibida uma mensagem que ocorreu um erro de sincronização e deve tentar novamente mais tarde.


#### Cenário 3: Filtro de vacinas
- **Dado** que o cidadão acessa o histórico de vacinação,
- **Quando** deseja filtrar as vacinas por tipo ou data,
- **Então** deve ter a opção de aplicar filtros para visualizar as informações desejadas.


### **Prioridade:** 
Alta


### **Estimativa de Esforço:** 
8 Story Points


### **Dependências:** 
- Integração com o banco de dados do SUS.


### **Notas/Comentários Adicionais:**
- Garantir que a interface de consulta seja intuitiva e fácil de usar.