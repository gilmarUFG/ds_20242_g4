
## **História de Usuário**

### **ID:** IMPORTAÇÃO DE DADOS 
HU- 008


### **Título:**  Importação do Histórico de Vacinação do Cidadão  STATUS

### **Descrição:**  
Como **usuário cadastrado**, eu quero **poder viualizar os STATUS da Minha Importação** para que **eu possa entender de onde os dados estão sendo importados**.

### **Critérios de Aceitação:**

#### Cenário 1: Status da Importação de Dados do Usúario 
- **Dado** que o usuário está na página de importação da Dados 
- **Quando** o usúario insere corretamento as informações solicitadas ( ( Nome Completo, Data de Nascimento, Cidade de Nascimento, Hospital de Nascimento, Local de Residência Atual )))
- **E** é direcionado para a página de Validação dos Dados 
- **E** insere o seu aceite as condições estabelecidas 
- **Então** o usuário vizualiza o Status das Importações e o Local onde as informações estão sendo coletadas. 

#### Cenário 2: Falha Status da Importação de Dados do Usúario 
- **Dado** que o usuário está na página de importação da Dados
- **Quando** o usúario insere incorretamente  as informações solicitadas (( Nome Completo, Data de Nascimento, Cidade de Nascimento, Hospital de Nascimento, Local de Residência Atual ))
- **Então** uma mensagem de erro deve ser exibida, informando que a informação está incorreta
- **E** o usuário deve tentar novamente 

### **Prioridade:**  
Alta

### **Estimativa de Esforço:**  
15 Story Points

### **Dependências:**  
- Importação do Histórico de Vacinação do Cidadão (Historia HU-007).

### **Notas/Comentários Adicionais:**
- A importação só deve ser feita de todas as informações estiverem correspondentes aos Cadastros no Estado e Municipio. 
