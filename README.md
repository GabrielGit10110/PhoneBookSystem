# 📞 Sistema de Lista Telefônica com Estruturas Encadeadas 

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://java.com)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Ativo-brightgreen.svg)](https://github.com/GabrielGit10110/PhoneBookSystem)
[![Javadoc](https://img.shields.io/badge/Docs-Javadoc-brightgreen)](https://gabrielgit10110.github.io/PhoneBookSystem/)
[![GitHub Pages](https://img.shields.io/badge/Docs-GitHub%20Pages-blue)](https://gabrielgit10110.github.io/PhoneBookSystem/)

Sistema avançado de lista telefônica que utiliza estruturas de dados encadeadas para armazenamento eficiente de contatos organizados alfabeticamente com números de telefone associados.

## 🎯 Funcionalidades

- **📇 Lista telefônica completa** com nomes e números
- **🔄 Atualização segura** de nomes mantendo números
- **📚 Documentação Javadoc** profissional hospedada
- **🔗 Lista duplamente encadeada** de caracteres (A-Z)
- **📋 Listas simples encadeadas** de contatos para cada letra
- **🔍 Inserção automática** em ordem alfabética
- **⚡ Busca eficiente** por letra e nome
- **🗑️ Remoção segura** de contatos
- **👀 Visualização organizada** da lista completa

## 🌐 Documentação

### [📖 Acessar Documentação Javadoc](https://gabrielgit10110.github.io/PhoneBookSystem/)

A documentação completa da API está disponível via GitHub Pages, incluindo:
- ✅ Referência completa de todas as classes e métodos
- ✅ Exemplos de uso detalhados
- ✅ Diagramas de hierarquia de classes
- ✅ Explicações de complexidade algorítmica

## 🏗️ Estrutura do Projeto

```
📦 PhoneBookSystem
├── 📂 src
│   ├── 📂 model
│   │   ├── CharList.java          # Lista duplamente encadeada de caracteres
│   │   ├── NameList.java          # Lista simples encadeada de contatos
│   │   ├── NodeChar.java          # Nó para caracteres
│   │   ├── NodeName.java          # Nó para contatos (nome + telefone)
│   │   └── PhoneBook.java         # Sistema principal da lista telefônica
│   ├── 📂 controller
│   │   └── TestPhoneList.java     # Controlador de testes
│   └── 📂 view
│       └── PhoneBook.java         # Interface de usuário
├── 📂 docs                        # Documentação Javadoc
└── 📂 bin
    └── # Arquivos compilados
```

## 🚀 Como executar

### Pré-requisitos
- JDK 8 ou superior
- Git instalado

### Passo a passo
1. Clone o repositório:
```bash
git clone https://github.com/GabrielGit10110/PhoneBookSystem.git
```

2. Acesse o diretório do projeto:
```bash
cd PhoneBookSystem
```

3. Compile o código:
```bash
javac -d bin src/model/*.java src/controller/*.java src/view/*.java
```

4. Execute a aplicação:
```bash
java -cp bin view.PhoneBook
```

### 🧪 Executar testes
```bash
java -cp bin controller.TestPhoneList
```

## 🆕 Novas Funcionalidades

### 📞 Sistema Telefônico Completo
- **Números de telefone** associados a cada nome
- **Atualização segura** de nomes mantendo o número
- **Busca de números** por nome
- **Estrutura robusta** para dados de contato

### 🔄 Atualização Segura de Nomes
```java
// Corrige um nome mantendo o número de telefone
phoneBook.updateName("WbRsaldo", "Waldo");
// Número 1191234567 é preservado para "Waldo"
```

### 📚 Documentação Profissional
- Javadoc completo para todas as classes
- Hospedagem automática no GitHub Pages
- Exemplos de uso e boas práticas

## 🧩 Componentes do Sistema

### 📋 CharList (Lista de Caracteres)
- **Lista duplamente encadeada** para caracteres A-Z
- **Inserção ordenada** automática
- **Busca eficiente** por letra
- **Controle de tamanho** e estado da lista

### 📋 NameList (Lista de Contatos)
- **Lista simples encadeada** para contatos (nome + telefone)
- **Ordenação alfabética** automática
- **Prevenção de duplicatas**
- **Operações CRUD** completas
- **Busca de números** de telefone

### 📘 PhoneBook (Lista Telefônica)
- **Integração** entre CharList e NameList
- **Normalização** de nomes (minúsculas, trim)
- **Interface unificada** para operações
- **Atualização segura** de contatos

## 🛠️ Tecnologias utilizadas
- Java SE
- Estruturas de dados encadeadas
- Algoritmos de ordenação
- Manipulação de strings
- Javadoc para documentação
- GitHub Pages para hospedagem
- JDK 8+

## 📋 Exemplo de uso

```java
PhoneBook agenda = new PhoneBook();

// Adicionando contatos com números
agenda.addName("Waldo", 1191234567);
agenda.addName("Ziraldo", 1191234568);
agenda.addName("Wesley", 1193216549);
agenda.addName("Alice", 1191111111);
agenda.addName("Bruno", 1192222222);

// Visualizando a lista completa
System.out.println(agenda.toString());

// Atualizando um nome mantendo o número
agenda.updateName("WbRsaldo", "Waldo");

// Buscando um contato
boolean encontrado = agenda.findName("Alice");

// Removendo um contato
agenda.removeName("Wesley");
```

## 📊 Exemplo de saída

```
Lista: A
Alice - 1191111111

Lista: B  
Bruno - 1192222222

Lista: W
Waldo - 1191234567
Wesley - 1193216549

Lista: Z
Ziraldo - 1191234568
```

## ⚙️ Características Técnicas

- **📞 Dados completos**: Nomes + números de telefone
- **🔄 Atualização segura**: Mantém números ao corrigir nomes
- **📚 Documentação profissional**: Javadoc hospedado
- **🔍 Normalização automática**: Nomes convertidos para minúsculas e trimados
- **📊 Ordenação eficiente**: Inserção mantém ordem alfabética
- **💾 Memória otimizada**: Alocação dinâmica conforme necessidade
- **🛡️ Controle de erros**: Exceções para operações inválidas
- **⚡ Performance**: Busca O(log n) usando divisão por letras

## 🔧 Métodos Principais

### PhoneBook
- `addName(String name, int phone)` - Adiciona contato à lista
- `updateName(String oldName, String newName)` - Atualiza nome mantendo número
- `removeName(String name)` - Remove contato da lista
- `findName(String name)` - Verifica se contato existe
- `toString()` - Retorna representação formatada

### CharList
- `insert(char letter)` - Insere letra ordenadamente
- `getOrCreateChar(char letter)` - Obtém ou cria nó de letra
- `remove(char letter)` - Remove letra da lista
- `isOnTheList(char letter)` - Verifica existência da letra

### NameList
- `insertName(String name, int phone)` - Insere contato ordenadamente
- `findPhoneNumber(String name)` - Busca número por nome
- `removeName(String name)` - Remove contato da lista
- `index(String name)` - Retorna índice do contato
- `isOnTheList(String name)` - Verifica existência do contato

## 🎯 Casos de Uso Reais

### 📝 Correção de Dados
```java
// Usuário digitou errado, corrige mantendo o número
phoneBook.updateName("Joaquim", "Joaquim");
```

### 🔄 Atualização de Cadastro
```java
// Pessoa mudou de nome, atualiza cadastro
phoneBook.updateName("Maria Silva", "Maria Santos");
```

### 📊 Relatórios Organizados
```java
// Gera lista telefônica organizada por letra
System.out.println(phoneBook.toString());
```

## 📝 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

## 👨‍💻 Autor

**Gabriel** - [GabrielGit10110](https://github.com/GabrielGit10110)

- GitHub: [@GabrielGit10110](https://github.com/GabrielGit10110)
- Projetos relacionados: [Estruturas de Dados](https://github.com/GabrielGit10110?tab=repositories)

## 🌟 Agradecimentos

- Inspirado nas aulas de estruturas de dados da faculdade
- Comunidade Java por boas práticas de documentação
- GitHub Pages por hospedagem gratuita de documentação

---

**⭐ Se este projeto foi útil, não esqueça de dar uma estrela no repositório!**

---

<div align="center">
  
Feito com ❤️ e ☕ por Gabriel

[⬆ Voltar ao topo](#-sistema-de-lista-telefônica-com-estruturas-encadeadas)

</div>
