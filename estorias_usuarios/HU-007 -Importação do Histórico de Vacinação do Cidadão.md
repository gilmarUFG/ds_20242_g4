## **História de Usuário**

### **ID:** IMPORTAÇÃO DE DADOS 
HU-007


### **Título:** Importação do Histórico de Vacinação do Cidadão 

### **Descrição:**  
Como **usuário cadastrado**, eu quero **que meu histórico de vacinação seja importado automaticamente das Bases do Municipio e Estado  ao me cadastrar no aplicativo do SUS** para que **eu possa  visualizar todas as vacinas que tomei sem precisar inserir manualmente.**.


### **Critérios de Aceitação:**

#### Cenário 1:  Importação de Dados no Cadastro 
- **Dado** que o usuário está na página de login 
deve ser solicitado Dados de Cadastro (( Nome Completo, Data de Nascimento, Cidade de Nascimento, Hospital de Nascimento, Local de Residência Atual )),
- **Quando** o usuário insere corretamente seus Dados,
- **E** é direcionado para a página contendo todo seu historico de Vacinação,
- **Então** o usuário deve ser selicionar que está de acordo com as informações e a importação será concluída.

#### Cenário 2: Falha no login por código 2FA inválido
- **Dado** que o usuário está na página de verificação de código de autenticação,
- **Quando** insere um código de autenticação incorreto,
- **Então** uma mensagem de erro deve ser exibida, informando que o código está incorreto,
- **E** o usuário deve poder tentar inserir o código novamente.


### **Prioridade:**  
Alta

### **Estimativa de Esforço:**  
20 Story Points//

### **Dependências:**  
- Importação do Histórico de Vacinação do Cidadão 
- Migração de Dados para o SUS

### **Notas/Comentários Adicionais:**
- A importação de dados das bases Municipio e Estado deve ser feita de formas isoladas
