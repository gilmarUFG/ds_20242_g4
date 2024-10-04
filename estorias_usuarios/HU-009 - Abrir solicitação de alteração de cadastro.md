

## **História de Usuário**

### **ID:** 
HU-009


### **Título:**  Abrir solicitação de alteração de cadastro 

### **Descrição:**  
Como **usuário cadastrado**, eu quero **poder informar que um dado meu está incorreto em alguma das Bases e solicitar correção**.

### **Critérios de Aceitação:**

#### Cenário 1: Sucesso da abertura de Solicitação de Cadastro 
- **Dado** que o usuário está na página que contém seus dados importados 
- **Quando** o usuário  pode solicitar alteração de algum dado que estiver incorreto 
- **E** é direcionado para a página de que contem campos de preenchimento de alteração
- **Então** é gerado um Protoloco de acompanhamento da alteração.


#### Cenário 2: Falha na abertura de Solicitação de Cadastro 
- **Dado** que o usuário está na página que contém seus dados importados 
- **Quando**  usuário  pode solicitar alteração de algum dado que estiver incorreto 
- **Então** é direcionado para a página de que contem campos de preenchimento de alteração 
- **E** e esecreve seu CPF incorretamente 
- **Então** é gerado um Pop-up informando que está incorreto.



### **Prioridade:**  
Alta

### **Estimativa de Esforço:**  
25 Story Points

### **Dependências:**  
- Importação do Histórico de Vacinação do Cidadão  STATUS ( Historia - HU-008)

### **Notas/Comentários Adicionais:**
- Deve ser gerado protocolo de acompanhamento 
