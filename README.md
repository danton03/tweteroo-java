# Projeto - API Tweteroo com Spring

### Descrição:
Projeto Spring da API do conhecido **Tweteroo**, um clone do Twitter, que foi implementado no módulo de back-end do bootcamp da Driven Education.

A porta utilizada pelo servidor é a 8080 (Porta padrão do Spring). E para persistir os dados (usuários e tweets), utilize variáveis globais em memória.

```http
POST /sign-up
```
- Deve receber (pelo body da request), um parâmetro **username** e um **avatar**, contendo o nome do username do usuário e a sua foto de avatar:
  
  ```json
  {
    "username": "bobesponja",
    "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
  }
  ```   
- Por fim, retorna a mensagem `“OK”`

```http
POST /tweets
```
- Deve receber (pelo body da request), os parâmetros `username` e `tweet`:
    
  ```json
  {
    "username": "bobesponja",
    "tweet": "eu amo o hub"
  }
  ```
    
- Salva esse tweet num array de tweets do servidor
- Por fim, retorna a mensagem `“OK”`

```http
GET /tweets?page=num
```
- Retorna os 5 últimos tweets publicados
- Esse endpoint deverá receber a página identificada via query string (`?page=1`).
- Retorna corretamente os tweets da “página” (`page`) atual, esse endpoint também será chamado ao clicar no botão “**Carregar mais**” (isso já foi feito no front-end). A primeira página corresponde aos últimos 5 tweets, a segunda do 6 ao 10, a terceira do 11 ao 15, etc…
- Retorna os tweets no seguinte formato:
```json
[
   {
      "username": "bobesponja",
      "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
      "tweet": "eu amo o hub"
   }
]
```

```http
GET /tweets/USERNAME
```
- Retorna todos os tweets publicados do usuário recebido por parâmetro de rota(USERNAME).
- Formato de retorno:
```json
[
   {
      "username": "bobesponja",
      "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
      "tweet": "eu amo o hub"
   }
]
```
