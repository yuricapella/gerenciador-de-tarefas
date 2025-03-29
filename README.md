# Gerenciador de Tarefas Inteligente 📋✨

Este projeto é a base de um **Gerenciador de Tarefas Inteligente** desenvolvido para auxiliar profissionais a organizar suas atividades diárias. Ele foi criado e aprimorado durante o curso de Técnicas de Programação do programa Desenvolva+ da Ada e Mercado Livre, onde nosso professor apresentou uma base sólida e nós fomos implementando melhorias e adaptações, aplicando conceitos de SOLID e programação funcional. 



## 📖 Documentação e Enunciado

Para mais informações sobre o contexto, os requisitos e as diretrizes do projeto, consulte o [Enunciado do Projeto](ENUNCIADO.md).

Além disso, para entender melhor a estrutura de pastas do projeto, consulte o [ESTRUTURA.md](ESTRUTURA.md).



## 🚀 Funcionalidades

- **Cadastro de Tarefas**: Permite registrar novas tarefas com título, descrição, data limite e status (Pendente, Em andamento, Concluído, Bloqueado).
- **Listagem e Filtragem**: Exibe todas as tarefas cadastradas, possibilitando filtragem por status e ordenação por data, título, status ou ID.
- **Atualização de Tarefas**: Permite a atualização dos dados das tarefas. Se algum campo for deixado em branco, o valor existente é mantido.
- **Ordenação Dinâmica**: Utiliza comparadores customizados para ordenar as tarefas conforme critérios definidos, eliminando código repetido.
- **Reutilização de Código**: Implementação de classes utilitárias como o `StatusDisplayHelper` e o `SortingSelectionTaskHandler` para evitar duplicação e facilitar manutenções futuras.




## 🔍 Mudanças e Melhorias Realizadas

Foram realizadas diversas melhorias no projeto, incluindo:

- Formatação da data para o padrão brasileiro.
- Inclusão de um novo status **Bloqueado** no enum `Task.Status`.
- Refatoração de comandos para reduzir duplicação e melhorar a reutilização de código.
- Adição de loops para repetição de ações no menu.
- Tratamento de campos nulos na atualização de tarefas.

Para detalhes completos, consulte o [arquivo de mudanças](MUDANÇAS.md).




## 🚀 Implementações Futuras

As seguintes funcionalidades serão adicionadas em versões futuras do projeto:

- 🔹 **Notificações Inteligentes com CompletableFuture**: O sistema alertará automaticamente o usuário quando uma tarefa estiver próxima do prazo de conclusão, utilizando notificações assíncronas para melhorar a performance da aplicação.



## 💻 Tecnologias Utilizadas

- **Java**
- **Programação Funcional e Orientada a Objetos (SOLID)**
- **API java.time** para manipulação de datas
- **Streams e Optionals** para processamento e validação de dados
- **Collections (Comparator, List, HashMap, Map)** para manipulação de dados e ordenação
- **Scanner** para leitura de entradas do usuário no console

---
