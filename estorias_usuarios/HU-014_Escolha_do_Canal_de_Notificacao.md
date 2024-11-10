### História de Usuário 14: Escolha do Canal de Notificação

**ID:** HU-014

**Título:** Escolha do Canal de Notificação

**Descrição:**  
Como usuário do sistema de saúde,  
Eu quero escolher o canal pelo qual desejo receber as notificações de vacinação,  
Para que eu possa receber os lembretes de forma prática e eficiente.

**Critérios de Aceitação:**
- O usuário deve poder selecionar o canal de notificação preferido (e-mail, SMS, ou app).
- O sistema deve respeitar a escolha do usuário e enviar as notificações pelo canal escolhido.
- Caso o envio falhe em um canal, o sistema deve tentar reenviar pelo canal secundário disponível.

**Cenário 1: Seleção do Canal Preferido**  
Dado que o usuário está configurando suas preferências de notificação,  
Então ele deve poder escolher entre e-mail, SMS ou app,  
E o sistema deve respeitar a escolha do usuário.

**Cenário 2: Reenvio em Caso de Falha**  
Dado que o canal de notificação principal falha,  
Então o sistema deve reenviar pelo canal secundário,  
E registrar o reenvio no histórico do usuário.

**Cenário 3: Alteração das Preferências**  
Dado que o usuário deseja alterar o canal de notificação,  
Então ele deve poder modificar suas preferências a qualquer momento,  
E o sistema deve aplicar a mudança imediatamente.

**Prioridade:** Média

**Estimativa de Esforço:** 5 Story Points

**Dependências:** Sistema de notificação configurável.

**Notas/Comentários Adicionais:**  
A interface de seleção deve ser intuitiva e permitir fácil configuração pelo usuário.
