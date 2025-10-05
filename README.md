# 📚 Sistema de Lista Telefônica com Estruturas Encadeadas 

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://java.com)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Ativo-brightgreen.svg)](https://github.com/GabrielGit10110/data-structures-java)

# ⚠️ EM DESENVOLVIMENTO

Sistema avançado de lista telefônica que utiliza estruturas de dados encadeadas para armazenamento eficiente de nomes organizados alfabeticamente.

## 🎯 Funcionalidades

- **Lista duplamente encadeada** de caracteres (A-Z)
- **Listas simples encadeadas** de nomes para cada letra
- Inserção automática em ordem alfabética
- Busca eficiente por letra e nome
- Remoção de nomes e letras
- Visualização organizada da lista completa

## 🏗️ Estrutura do Projeto

```
📦 PhoneBookSystem
├── 📂 src
│   ├── 📂 model
│   │   ├── CharList.java          # Lista duplamente encadeada de caracteres
│   │   ├── NameList.java          # Lista simples encadeada de nomes
│   │   ├── NodeChar.java          # Nó para caracteres
│   │   ├── NodeName.java          # Nó para nomes
│   │   └── PhoneBook.java         # Sistema principal da lista telefônica
│   ├── 📂 controller
│   │   └── TestPhoneList.java     # Controlador de testes
│   └── 📂 view
│       └── PhoneBook.java         # Interface de usuário
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

## 🧩 Componentes do Sistema

### 📋 CharList (Lista de Caracteres)
- **Lista duplamente encadeada** para caracteres A-Z
- **Inserção ordenada** automática
- **Busca eficiente** por letra
- **Controle de tamanho** e estado da lista

### 📋 NameList (Lista de Nomes)
- **Lista simples encadeada** para nomes
- **Ordenação alfabética** automática
- **Prevenção de duplicatas**
- **Operações CRUD** completas

### 📘 PhoneBook (Lista Telefônica)
- **Integração** entre CharList e NameList
- **Normalização** de nomes (minúsculas, trim)
- **Interface unificada** para operações

## 🛠️ Tecnologias utilizadas
- Java SE
- Estruturas de dados encadeadas
- Algoritmos de ordenação
- Manipulação de strings
- JDK 8+

## 📋 Exemplo de uso

```java
PhoneBook agenda = new PhoneBook();

// Adicionando nomes
agenda.addName("Waldo");
agenda.addName("Ziraldo");
agenda.addName("Wesley");
agenda.addName("Alice");
agenda.addName("Bruno");

// Visualizando a lista
System.out.println(agenda.toString());

// Removendo um nome
agenda.removeName("Wesley");

// Buscando um nome
boolean encontrado = agenda.findName("Alice");
```

## 📊 Exemplo de saída

```
Lista: a
alice

Lista: b
bruno

Lista: w
waldo
wesley

Lista: z
ziraldo
```

## ⚙️ Características Técnicas

- **Normalização automática**: Nomes convertidos para minúsculas e trimados
- **Ordenação eficiente**: Inserção mantém ordem alfabética
- **Memória otimizada**: Alocação dinâmica conforme necessidade
- **Controle de erros**: Exceções para operações inválidas
- **Performance**: Busca O(log n) usando divisão por letras

## 🔧 Métodos Principais

### PhoneBook
- `addName(String name)` - Adiciona nome à lista
- `removeName(String name)` - Remove nome da lista
- `findName(String name)` - Verifica se nome existe
- `toString()` - Retorna representação formatada

### CharList
- `insert(char letter)` - Insere letra ordenadamente
- `getOrCreateChar(char letter)` - Obtém ou cria nó de letra
- `remove(char letter)` - Remove letra da lista
- `isOnTheList(char letter)` - Verifica existência da letra

### NameList
- `insertName(String name)` - Insere nome ordenadamente
- `removeName(String name)` - Remove nome da lista
- `index(String name)` - Retorna índice do nome
- `isOnTheList(String name)` - Verifica existência do nome

## 📝 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

## 👨‍💻 Autor

**Gabriel** - [GabrielGit10110](https://github.com/GabrielGit10110)

- GitHub: [@GabrielGit10110](https://github.com/GabrielGit10110)

## 🌟 Agradecimentos

- Inspirado nas minhas aulas de estruturas de dados da faculdade
- Comunidade Java por boas práticas

---

**⭐ Não esqueça de dar uma estrela no repositório se achou útil!**

---

<div align="center">
  
Feito com ❤️ e ☕ por Gabriel

[⬆ Voltar ao topo](#-estruturas-de-dados-em-java)

</div>
