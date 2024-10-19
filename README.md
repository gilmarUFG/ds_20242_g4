### ds_20242_g4
Repositório definido para a manutenção do controle de versão dos artefatos do projeto de do Grupo 4, da Disciplina de Domínios de Software, no semestre 2024-2.


### Nome do Projeto:
Registro de vacina


### Descrição:
O projeto atuará no domínio de Saúde Pública, com foco na prevenção de doenças através da vacinação, uma das missões centrais do Sistema Único de Saúde (SUS) no Brasil. O objetivo principal é criar uma solução digital para gerenciar as informações de vacinação da população, oferecendo um meio mais acessível e eficiente para os cidadãos e integrando-se ao sistema de saúde nacional.


### Problema
Embora a vacinação seja parte da cultura brasileira desde o nascimento, as informações relacionadas a ela acabam se perdendo com o tempo, principalmente porque o controle é feito pelo próprio usuário, ainda utilizando um Cartão de Vacina físico. Esse método em papel é suscetível a perdas e dificulta a manutenção do histórico completo de vacinas, o que pode comprometer a eficácia da prevenção de doenças.


### Objetivos da Solução
O sistema proposto visa virtualizar o Cartão de Vacina do cidadão, criando um meio de armazenamento digital que facilita o controle e acesso às informações de vacinação. Ele integrará os dados com o sistema do SUS, permitindo que o cidadão acompanhe seu calendário de vacinas de forma prática, segura e digital, além de contribuir para uma maior organização das campanhas de vacinação.


### Grupo
Este projeto será desenvolvido pelos componentes do grupo 4:


|Matrícula|Nome|Usuário Git|
|---|---|---|
|202201681|ALINE LIMA MARTINS COELHO|[aaaaline](https://github.com/aaaaline)|
|202206141|ALINE NUNES DOS SANTOS|[alinenunes21](https://github.com/alinenunes21)|
|202200031|RAQUEL DIAS DA SILVA|[RaquelDiasES](https://github.com/RaquelDiasES)|
|202201714|STEPHANY DE OLIVEIRA SOUSA MILHOMEM|[StephanyMil](https://github.com/StephanyMil)|
|202201715|TANIELE ROCHA MADUREIRA|[TanyRM](https://github.com/TanyRM)|
|202009586|THAYLINY ALVES DE MOURA|[thayliny](https://github.com/thayliny)|


### Backlog do Produto


1. RF001 - O sistema deve ser capaz de sincronizar automaticamente os dados de vacinação do cidadão com o SUS sempre que uma nova vacina for registrada no sistema local. A sincronização deve ocorrer em tempo real ou em intervalos regulares, garantindo que o histórico de vacinação do cidadão esteja sempre atualizado no sistema do SUS.
2. RF002 - O sistema deve enviar notificações ao cidadão sempre que seus dados de vacinação forem sincronizados com sucesso. As notificações devem ser enviadas via SMS, e-mail ou aplicativo, conforme a preferência do usuário. O sistema também deve permitir que o cidadão desative essas notificações através das configurações de notificação.
3. RF003 - O sistema deve permitir que o cidadão consulte seu histórico de vacinação sincronizado com o SUS. A consulta deve exibir uma lista completa e atualizada de todas as vacinas administradas. O sistema deve oferecer opções de filtro por tipo de vacina e data, e deve informar o cidadão sobre qualquer ausência de dados devido a falhas na sincronização.
4. RF004 - O sistema deve permitir que profissionais de saúde autenticados consultem o histórico completo de vacinação de um cidadão, utilizando o CPF ou Cartão SUS como identificador. O histórico exibido deve incluir todas as vacinas aplicadas, com detalhes como a data de aplicação, lote da vacina e a validade de cada imunização.
5. RF005 - O sistema deve permitir que profissionais de saúde consultem as vacinas pendentes ou que necessitem de reforço para um cidadão. Essas informações devem ser destacadas no histórico de vacinação, com datas recomendadas para a aplicação das doses pendentes ou reforços, baseadas na faixa etária e no calendário nacional de vacinação.
6. RF006 - O sistema deve comunicar com bases de dados do Múnicio e Estado para importação de informação do usúario para o SUS.
7. RF007 -O sistema deve permitir ao usúario visualizar de onde suas informações estão sendo importadas e o status de cada importação ( Andamento, Concluída, Falha).
8. RF008 - O Sistema deve permitir ao usúario  a abertura de solicitação de alteração de dados diretamente para o local de Importação.
9. RF009 - O sistema deve permitir a consulta rápida do histórico de vacinação de um cidadão em situações de emergência. O profissional de saúde deve ser capaz de acessar vacinas específicas relacionadas à doença em questão (como surtos ou doenças prevalentes) de forma destacada, utilizando o CPF ou Cartão SUS para a busca.
10. RF010 - O sistema deve permitir que o usuário receba uma notificação detalhada quando ocorrer um erro de sincronização de seus dados com o SUS, informando o motivo do erro e dando orientações de como corrigi-lo.
11. RF011 - O sistema deve registrar automaticamente os logs de erro relacionados à sincronização de dados com o SUS, incluindo detalhes como data, hora, código do erro, e descrição do problema, para que a equipe técnica possa verificar e corrigir.
12. RF012 - O sistema deve permitir que o usuário receba uma notificação quando um erro de sincronização de dados com o SUS for resolvido, confirmando que suas informações de vacinação estão atualizadas e corretas.
13. RF013 - O sistema deve permitir que o cidadão visualize, em um mapa interativo, os pontos de vacinação disponíveis e o índice de cobertura vacinal de uma região específica, fornecendo informações detalhadas para que o usuário possa se manter informado e tomar decisões de prevenção.
14. RF014 - O sistema deve permitir que cidadãos visualizem as próximas doses de vacina que precisam tomar, com base no calendário oficial de vacinação.
15. RF015 - O sistema deve permitir que agentes de saúde monitorem a cobertura vacinal de uma determinada região.
16. RF016 - O sistema deve enviar automaticamente lembretes de vacinação para os usuários com vacinas pendentes, utilizando as informações do SUS, para garantir que as vacinas estejam atualizadas conforme o calendário vacinal.
17. RF017 - O sistema deve permitir que os usuários escolham o canal de notificação de sua preferência (e-mail, SMS ou app) para receber lembretes de vacinação, garantindo que as comunicações sejam personalizadas e eficazes.
18. RF018 -O sistema deve permitir que os usuários confirmem o recebimento dos lembretes de vacinação através de um botão ou link na notificação, registrando a confirmação para acompanhamento e envio de lembretes adicionais se necessário.



### Requisitos Não Funcionais


1. RNF001 - Usabilidade: O sistema deve ser intuitivo e fácil de usar, permitindo que cidadãos de todas as idades e níveis de alfabetização tecnológica possam acessar e utilizar suas funcionalidades sem dificuldades. A interface deve ser clara, com instruções visuais e textuais simples.
2. RNF002 - Segurança: O sistema deve garantir a segurança dos dados pessoais e de saúde tanto de cidadãos quanto de profissionais de saúde. O acesso ao sistema deve ser restrito a usuários autenticados, exigindo login com senha e um segundo fator de autenticação para ambos os grupos de usuários. 
3. RNF003 - Desempenho: O sistema deve suportar até 100.000 usuários simultâneos sem degradação perceptível de desempenho. 
4. RNF004 - Confiabilidade: As informações apresentadas devem ser do CPF do cadastro, o histórico apresentado deve ser fidedigno as bases do Município e do  Estado, sem inconsistências. 
5. RNF005 - Manutenibilidade: O sistema deve ser fácil de manter, permitindo modificações, correções e atualizações com baixo custo e impacto, por meio de código modular, bem documentado, e com testes automatizados que garantam a estabilidade das funcionalidades.
6. RNF006 - Portabilidade: O sistema deve ser compatível com diversas plataformas (web, iOS e Android), permitindo que os cidadãos acessem seu cartão de vacinação virtual de qualquer dispositivo e sistema operacional.
7. RNF007 - Conectividade: O sistema deve ser capaz de operar de forma eficiente em diferentes condições de conectividade, incluindo conexões de internet de baixa velocidade. Deve garantir a sincronização dos dados de vacinação mesmo em áreas com cobertura de rede limitada, utilizando técnicas de armazenamento em cache e sincronização assíncrona quando necessário.


### Regras de Negócio
1. RN01 - As vacinas devem ser associadas à faixa etária, condição de saúde específica, e outras características como gênero ou região, conforme definido pelas normas de vacinação.
2. RN02 - Os cidadãos devem ter acesso ao seu histórico de vacinação a qualquer momento, podendo visualizar ou imprimir suas informações de vacinação de forma segura e controlada.
3. RN03 - O calendário de vacinação deve ser atualizado automaticamente no sistema, seguindo as diretrizes do Ministério da Saúde e permitindo ao cidadão verificar quando e quais vacinas deve tomar.
4. RN04 - O sistema deve permitir que os usuários selecionem o canal de notificação (e-mail, SMS ou app) para receber os lembretes de vacinação. Caso o envio falhe pelo canal principal, o sistema deve tentar reenviar a notificação pelo canal secundário configurado.
5. RN05 - Os usuários profissionais de saúde devem poder consultar os dados de cidadãos sob sua responsabilidade, respeitando a privacidade e a segurança.
6. RN06 - Ao logar no Sistema pela primeira vez o usúario deve confirmar uma série de Dados ( Nome Completo, Data de Nascimento, Cidade de Nascimento, Hospital de Nascimento, Local de Residência Atual).
   

### Modelo Arquitetural
O **"Registro de Vacina"** adota um modelo de **Arquitetura Orientada a Serviços (SOA)** para garantir flexibilidade, interoperabilidade e integração com sistemas externos, como o SUS. A arquitetura SOA permite que as funcionalidades do sistema sejam implementadas como serviços independentes e reutilizáveis, promovendo escalabilidade e facilitando a manutenção.

#### 1. Camadas do Modelo SOA
- **Camada de Apresentação (Frontend)**: Fornece interfaces gráficas para usuários (cidadãos e profissionais de saúde). Desenvolvida em React para web e React Native para mobile (iOS e Android), garante uma experiência de usuário consistente e responsiva.

- **Camada de Serviços (Backend)**: Composta por serviços independentes que executam funções específicas, como sincronização de dados, consulta de histórico de vacinação, notificações e autenticação. Cada serviço se comunica com os outros por meio de APIs RESTful.

- **Camada de Integração**: Contém serviços que se comunicam com sistemas externos (e.g., APIs do SUS) para sincronizar dados de vacinação. Inclui um **API Gateway** para gerenciamento centralizado de requisições e autenticação de usuários.

- **Camada de Persistência**: Utiliza um banco de dados relacional para armazenar informações do usuário e histórico de vacinação. Implementa caching para otimizar a performance e garantir a sincronização eficiente, mesmo em condições de baixa conectividade.

#### 2. Principais Serviços
- **Serviço de Sincronização**: Sincroniza automaticamente os dados de vacinação com o SUS, garantindo que o histórico do cidadão esteja sempre atualizado.
- **Serviço de Notificações**: Gerencia o envio de lembretes e atualizações para os usuários através dos canais preferidos (SMS, e-mail ou aplicativo).
- **Serviço de Autenticação**: Realiza autenticação e autorização de usuários, garantindo segurança e controle de acesso.

#### 3. Benefícios da Arquitetura SOA
A adoção de SOA promove a modularidade do sistema, facilita a integração com serviços de terceiros e possibilita a escalabilidade horizontal dos serviços. Além disso, o modelo permite que cada serviço evolua independentemente, reduzindo o impacto de mudanças e simplificando o desenvolvimento contínuo.


### Modelo de Interfaces Gráficas
O modelo de interface gráfica do Registro de Vacinas foi feito utilizando o [Figma](https://www.figma.com/proto/JqkmSr9b5dnG0GsE35XNld/Sistema-de-Registro-de-Vacina?node-id=38-2&node-type=frame&t=tr4pTJ8GM7ZK2pxG-0&scaling=scale-down&content-scaling=fixed&page-id=0%3A1)


### Tecnologia de Persistência de Dados
Para esse projeto foi utilizado o Banco de Dados Relacional MySQL pois entendemos que a abordagem atende as configurações e proriedades do projeto. 


### Local do _Deploy_
O nosso planejamento inicial é hospedar nossa aplicação no Heroku ou no Firebase do Google, sendo crucial para nossa escolha a facilidade de configuração e também os recursos ofertados na versão gratuita.


### Cronograma de Desenvolvimento


|Iteração|Descrição|Data Início|Data Fim|Responsável|Situação|
|---|---|---|---|---|---|
|1|Concepção|30/08/2024|13/09/2024|Grupo|Concluída|
|2|Preparação|14/09/2024|27/09/2024|Grupo|Programada|
|3|Item(ns) do backlog RF014|28/09/2024|11/10/2024|Grupo|Programada|
|4|Item(ns) do backlog RF003|12/10/2024|25/10/2024|Grupo|Programada|
|5|Item(ns) do backlog RF004|26/10/2024|08/11/2024|Grupo|Programada|
|6|Item(ns) do backlog RF016, RF017|09/11/2024|22/11/2024|Grupo|Programada|
|7|Item(ns) do backlog RF018|23/11/2024|06/12/2024|Grupo|Programada|
|8|Apresentação do Projeto|07/12/2024|20/12/2024|Grupo|Programada|


### Iterações x Atividades
|Iteração|Tarefa|Data Início|Data Fim|Responsável|Situação|
|---|---|---|---|---|---|
|1|Definição do grupo de trabalho|30/08/2024|30/08/2024|Grupo|Concluída|
|1|Definição do Tema do Trabalho|30/08/2024|13/09/2024|Grupo|Concluída|
|2|Definição do Backlog do produto|13/09/2024|27/09/2024|Grupo|Programada|
|2|Descrição dos itens do backlog do produto|14/09/2024|27/09/2024|Grupo|Programada|
|2|Distribuição dos itens do backlog entre as iterações|14/09/2024|27/09/2024|Grupo|Programada|
|2|Definição do modelo arquitetural|14/09/2024|27/09/2024|Grupo|Programada|
|3|Especificação de estórias de usuários dos Item(ns) do backlog RF014|28/09/2024|11/10/2024| Aline Nunes|Programada|
|3|Diagrama de classes dos Item(ns) do backlog RF014|28/09/2024|11/10/2024|Aline Nunes e Taniele|Programada|
|3|Diagrama de interação/sequencia dos itens do backlog RF014|28/09/2024|11/10/2024| Stephany|Programada|
|3|Projeto de Interfaces gráficas dos itens do backlog RF014|28/09/2024|11/10/2024|Aline Lima, Raquel e Stephany|Programada|
|3|Projeto de persistência dos itens do backlog RF014|28/09/2024|11/10/2024|Thayliny|Programada|
|3|Implementação dos itens do backlog RF014*|28/09/2024|11/10/2024|Stephany e Thayliny|Programada|
|4|Especificação de estórias de usuários dos Item(ns) do backlog RF003|12/10/2024|25/10/2024|Stephany|Programada|
|4|Diagrama de classes dos Item(ns) do backlog RF003|12/10/2024|25/10/2024|Aline Nunes e Taniele|Programada|
|4|Diagrama de interação/sequencia dos itens do backlog RF003|12/10/2024|25/10/2024|Stephany|Programada|
|4|Projeto de Interfaces gráficas dos itens do backlog RF003|12/10/2024|25/10/2024|Aline Lima e Raquel|Programada|
|4|Projeto de persistência dos itens do backlog RF003|12/10/2024|25/10/2024|Raquel e Thayliny|Programada|
|4|Implementação dos itens do backlog RF003*|12/10/2024|25/10/2024|Raquel, Stephany e Thayliny|Programada|
|5|Especificação de estórias de usuários dos Item(ns) do backlog RF004|26/10/2024|08/11/2024|Raquel|Programada|
|5|Diagrama de classes dos Item(ns) do backlog RF004|26/10/2024|08/11/2024|Aline Nunes e Taniele|Programada|
|5|Diagrama de interação/sequencia dos itens do backlog RF004|26/10/2024|08/11/2024|Thayliny|Programada|
|5|Projeto de Interfaces gráficas dos itens do backlog RF004|26/10/2024|08/11/2024|Aline Lima e Raquel|Programada|
|5|Projeto de persistência dos itens do backlog RF004|26/10/2024|08/11/2024|Thayliny|Programada|
|5|Implementação dos itens do backlog RF004*|26/10/2024|08/11/2024|Aline Lima e Stephany|Programada|
|6|Especificação de estórias de usuários dos Item(ns) do backlog RF016, RF017|09/11/2024|22/11/2024|Aline Nunes|Programada|
|6|Diagrama de classes dos Item(ns) do backlog RF016, RF017|09/11/2024|22/11/2024|Aline Nunes e Taniele|Programada|
|6|Diagrama de interação/sequencia dos itens do backlog RF016, RF017|09/11/2024|22/11/2024|Thayliny|Programada|
|6|Projeto de Interfaces gráficas dos itens do backlog RF016, RF017|09/11/2024|22/11/2024|Raquel e Thayliny|Programada|
|6|Projeto de persistência dos itens do backlog RF016, RF017|09/11/2024|22/11/2024|Thayliny|Programada|
|6|Implementação dos itens do backlog RF016, RF017*|09/11/2024|22/11/2024|Taniele e Stephany|Programada|
|7|Especificação de estórias de usuários dos Item(ns) do backlog RF018|23/11/2024|06/12/2024|Aline Nunes|Programada|
|7|Diagrama de classes dos Item(ns) do backlog RF018|23/11/2024|06/12/2024|Aline Nunes e Taniele|Programada|
|7|Diagrama de interação/sequencia dos itens do backlog RF018|23/11/2024|06/12/2024|Raquel|Programada|
|7|Projeto de Interfaces gráficas dos itens do backlog RF018|23/11/2024|06/12/2024|Aline Lima|Programada|
|7|Projeto de persistência dos itens do backlog RF018|23/11/2024|06/12/2024|Thayliny|Programada|
|7|Implementação dos itens do backlog RF018*|23/11/2024|06/12/2024|Aline Nunes e Stephany|Programada|
|8|Apresentação do Projeto|07/12/2024|20/12/2024|Grupo|Programada|


* Implementação se aplicará, se os itens da iteração em andamento, forem eleitos para validação do projeto do trabalho.
