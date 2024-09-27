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
4. RF010 - O sistema deve permitir que o usuário receba uma notificação detalhada quando ocorrer um erro de sincronização de seus dados com o SUS, informando o motivo do erro e dando orientações de como corrigi-lo.
5. RF011 - O sistema deve registrar automaticamente os logs de erro relacionados à sincronização de dados com o SUS, incluindo detalhes como data, hora, código do erro, e descrição do problema, para que a equipe técnica possa verificar e corrigir.
6. RF012 - O sistema deve permitir que o usuário receba uma notificação quando um erro de sincronização de dados com o SUS for resolvido, confirmando que suas informações de vacinação estão atualizadas e corretas.
7. RF016 - O sistema deve permitir que cidadãos acompanhem seu histórico de vacinação, exibindo todas as vacinas já tomadas.
8. RF017 - O sistema deve permitir que cidadãos visualizem as próximas doses de vacina que precisam tomar, com base no calendário oficial de vacinação.
9. RF018 - O sistema deve permitir que agentes de saúde monitorem a cobertura vacinal de uma determinada região.


### Requisitos Não Funcionais


1. RNF001 - Usabilidade: O sistema deve ser intuitivo e fácil de usar, permitindo que cidadãos de todas as idades e níveis de alfabetização tecnológica possam acessar e utilizar suas funcionalidades sem dificuldades. A interface deve ser clara, com instruções visuais e textuais simples.
2. RNF002 - Segurança: <Descrição do Requisito não Funcional>..
3. RNF003 - Desempenho: <Descrição do Requisito não Funcional>..
4. RNF004 - Confiabilidade: <Descrição do Requisito não Funcional>.
5. RNF005 - Manutenibilidade: <Descrição do Requisito não Funcional>.
6. RNF006 - Portabilidade: O sistema deve ser compatível com diversas plataformas (web, iOS e Android), permitindo que os cidadãos acessem seu cartão de vacinação virtual de qualquer dispositivo e sistema operacional.
7. RNF007 - Conectividade: O sistema deve ser capaz de operar de forma eficiente em diferentes condições de conectividade, incluindo conexões de internet de baixa velocidade. Deve garantir a sincronização dos dados de vacinação mesmo em áreas com cobertura de rede limitada, utilizando técnicas de armazenamento em cache e sincronização assíncrona quando necessário.


### Regras de Negócio
1. RN01 - As vacinas devem ser associadas à faixa etária, condição de saúde específica, e outras características como gênero ou região, conforme definido pelas normas de vacinação.
2. RN02 - Os cidadãos devem ter acesso ao seu histórico de vacinação a qualquer momento, podendo visualizar ou imprimir suas informações de vacinação de forma segura e controlada.
3. RN03 - <Descrição da Regra de Negócio>.
4. RN04 - <Descrição da Regra de Negócio>.
5. RN05 - <Descrição da Regra de Negócio>.


### Modelo Arquitetural
<Apresentar uma descrição sucinta do modelo arquitetural do Produto.>


### Modelo de Interfaces Gráficas
<Apresentar uma descrição sucinta do modelo de interfaces gráficas do Produto.>


### Tecnologia de Persistência de Dados
<Apresentar uma descrição sucinta do modelo de persistência do Produto.>


### Local do _Deploy_
O nosso planejamento inicial é hospedar nossa aplicação no Heroku ou no Firebase do Google, sendo crucial para nossa escolha a facilidade de configuração e também os recursos ofertados na versão gratuita.


### Cronograma de Desenvolvimento


|Iteração|Descrição|Data Início|Data Fim|Responsável|Situação|
|---|---|---|---|---|---|
|1|Concepção|30/08/2024|13/09/2024|Grupo|Concluída|
|2|Preparação|14/09/2024|27/09/2024|Grupo|Programada|
|3|Item(ns) do backlog <x,y,z>|28/09/2024|11/10/2024|Grupo|Programada|
|4|Item(ns) do backlog <x,y,z>|12/10/2024|25/10/2024|Grupo|Programada|
|5|Item(ns) do backlog <x,y,z>|26/10/2024|08/11/2024|Grupo|Programada|
|6|Item(ns) do backlog <x,y,z>|09/11/2024|22/11/2024|Grupo|Programada|
|7|Item(ns) do backlog <x,y,z>|23/11/2024|06/12/2024|Grupo|Programada|
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
|3|Especificação de estórias de usuários dos Item(ns) do backlog <x,y,z>|28/09/2024|11/10/2024||Programada|
|3|Diagrama de classes dos Item(ns) do backlog <x,y,z>|28/09/2024|11/10/2024||Programada|
|3|Diagrama de interação/sequencia dos itens do backlog <x,y,z>|28/09/2024|11/10/2024||Programada|
|3|Projeto de Interfaces gráficas dos itens do backlog <x,y,z>|28/09/2024|11/10/2024||Programada|
|3|Projeto de persistência dos itens do backlog <x,y,z>|28/09/2024|11/10/2024||Programada|
|3|Implementação dos itens do backlog <x,y,z>*|28/09/2024|11/10/2024||Programada|
|4|Especificação de estórias de usuários dos Item(ns) do backlog <x,y,z>|12/10/2024|25/10/2024||Programada|
|4|Diagrama de classes dos Item(ns) do backlog <x,y,z>|12/10/2024|25/10/2024||Programada|
|4|Diagrama de interação/sequencia dos itens do backlog <x,y,z>|12/10/2024|25/10/2024||Programada|
|4|Projeto de Interfaces gráficas dos itens do backlog <x,y,z>|12/10/2024|25/10/2024||Programada|
|4|Projeto de persistência dos itens do backlog <x,y,z>|12/10/2024|25/10/2024||Programada|
|4|Implementação dos itens do backlog <x,y,z>*|12/10/2024|25/10/2024||Programada|
|5|Especificação de estórias de usuários dos Item(ns) do backlog <x,y,z>|26/10/2024|08/11/2024||Programada|
|5|Diagrama de classes dos Item(ns) do backlog <x,y,z>|26/10/2024|08/11/2024||Programada|
|5|Diagrama de interação/sequencia dos itens do backlog <x,y,z>|26/10/2024|08/11/2024||Programada|
|5|Projeto de Interfaces gráficas dos itens do backlog <x,y,z>|26/10/2024|08/11/2024||Programada|
|5|Projeto de persistência dos itens do backlog <x,y,z>|26/10/2024|08/11/2024||Programada|
|5|Implementação dos itens do backlog <x,y,z>*|26/10/2024|08/11/2024||Programada|
|6|Especificação de estórias de usuários dos Item(ns) do backlog <x,y,z>|09/11/2024|22/11/2024||Programada|
|6|Diagrama de classes dos Item(ns) do backlog <x,y,z>|09/11/2024|22/11/2024||Programada|
|6|Diagrama de interação/sequencia dos itens do backlog <x,y,z>|09/11/2024|22/11/2024||Programada|
|6|Projeto de Interfaces gráficas dos itens do backlog <x,y,z>|09/11/2024|22/11/2024||Programada|
|6|Projeto de persistência dos itens do backlog <x,y,z>|09/11/2024|22/11/2024||Programada|
|6|Implementação dos itens do backlog <x,y,z>*|09/11/2024|22/11/2024||Programada|
|7|Especificação de estórias de usuários dos Item(ns) do backlog <x,y,z>|23/11/2024|06/12/2024||Programada|
|7|Diagrama de classes dos Item(ns) do backlog <x,y,z>|23/11/2024|06/12/2024||Programada|
|7|Diagrama de interação/sequencia dos itens do backlog <x,y,z>|23/11/2024|06/12/2024||Programada|
|7|Projeto de Interfaces gráficas dos itens do backlog <x,y,z>|23/11/2024|06/12/2024||Programada|
|7|Projeto de persistência dos itens do backlog <x,y,z>|23/11/2024|06/12/2024||Programada|
|7|Implementação dos itens do backlog <x,y,z>*|23/11/2024|06/12/2024||Programada|
|8|Apresentação do Projeto|07/12/2024|20/12/2024|Grupo|Programada|


* Implementação se aplicará, se os itens da iteração em andamento, forem eleitos para validação do projeto do trabalho.
