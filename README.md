
# 💱 Conversor de Moedas - Java + ExchangeRate-API

Projeto simples de conversor de moedas feito em **Java**, utilizando a [ExchangeRate-API](https://www.exchangerate-api.com/) para consultar taxas de câmbio em tempo real.

## 🚀 Funcionalidades

- ✅ Consulta de taxa de câmbio entre moedas.
- ✅ Conversão de valores com base nas taxas atualizadas.
- ✅ Interface interativa via terminal (CLI).

## 📋 Pré-requisitos

- [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalado.
- [Gson (Google JSON)](https://github.com/google/gson) — biblioteca para manipulação de JSON.
- Conexão com a internet para consultar a API de câmbio.

## 📦 Estrutura do Projeto

```
src/
├── Main.java              # Interface de usuário via console
├── ServicoCambio.java     # Requisições à API e lógica de conversão
├── TaxasDeCambio.java     # Modelo de dados retornado pela API
```

---

## 🛠️ Como Executar

### 🔧 Compilação Manual

1. Baixe o [gson-2.8.9.jar](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.9/gson-2.8.9.jar) (ou versão mais recente).
2. Compile:

```bash
javac -cp gson-2.8.9.jar src/*.java -d out
```

3. Execute:

```bash
java -cp "out;gson-2.8.9.jar" Main
```

> 💡 Em sistemas Unix/macOS, use `:` no lugar de `;` no classpath:
```bash
java -cp "out:gson-2.8.9.jar" Main
```

---

## 💡 Como Abrir em IDEs

### IntelliJ IDEA

1. Vá em **File > New > Project from Existing Sources...**
2. Selecione o diretório do projeto.
3. Escolha "Import project from external model" > **Java**.
4. Adicione o `gson-2.8.9.jar` como dependência:
   - Clique com o botão direito em `src` > **Open Module Settings**.
   - Vá em **Libraries > + > Java**, selecione o `.jar`.

### Eclipse

1. Vá em **File > New > Java Project**.
2. Copie os arquivos `.java` para a pasta `src` criada.
3. Clique com o botão direito no projeto > **Build Path > Add External Archives...** e selecione `gson-2.8.9.jar`.

---

## 💱 Moedas Suportadas (menu)

| Código | Moeda           |
|--------|------------------|
| USD    | Dólar Americano  |
| BRL    | Real             |
| EUR    | Euro             |
| CAD    | Dólar Canadense  |
| RUB    | Rublo Russo      |
| CNY    | Yuan             |
| ARS    | Peso Argentino   |

---

## 🔑 API Key

Este projeto usa a [ExchangeRate-API](https://www.exchangerate-api.com/) com uma **chave gratuita** de teste. A chave no código pode expirar, por isso:

1. Cadastre-se em: [https://www.exchangerate-api.com](https://www.exchangerate-api.com/)
2. Copie sua nova chave.
3. Substitua na classe `ServicoCambio.java`:
```java
String apiKey = "SUA_NOVA_CHAVE";
```

---

## ⚠️ Observações

- Erros de rede ou moedas inválidas geram exceções com mensagens claras.
- A taxa é obtida **com base na moeda de origem** selecionada.

---

👨‍💻 Feito para fins didáticos. Contribuições são bem-vindas!
