<h1 align='center'>Squad 8 - Back - Hackathon FCamara  </h1> 
<br/>
<div align='center'>
        <a href='#'><img src='https://i.imgur.com/aKiNSth.png' alt='Logo Technical Share.' width='300px'/></a>
</div>
<br>
<p align='center'>
  <a href='#projeto'>Projeto</a> | 
  <a href='#documentacao'>Documentação</a> | 
  <a href='#tech'>Tecnologias</a> | 
  <a href='#instrucoes'>Instruções</a> | 
  <a href='#roteiro'>Roteiro</a> | 
  <a href='#comorodaroprojeto'>Como Rodar o Projeto</a>
</p>

<div id="projeto" style="text-align: justify">
        
A Technical Share é uma aplicação web com o objetivo de catalogar os profissionais do Grupo FCamara para facilitar a troca de experiências e networking, principalmente de quem está em busca de orientações na área de tecnologia. Na plataforma, após a realização do cadastro do usuário, é possível ver os perfis dos profissionais já cadastrados na plataforma que contém, dentre outros, uma descrição do cargo que exercem, biografia pessoal e as habilidades que têm mais domínio. Essas informações já permitem ao usuário um rápido e fácil reconhecimento de pessoas das quais ele possa pedir orientações, tirar dúvidas e mesmo conhecer melhor os colegas que dividem o mesmo espaço de trabalho. <strong><em>Saiba mais do projeto em > https://github.com/squad8-hackatho/squad8-hackatho</em></strong> <br> 
        
A API aqui apresentada foi implementada pelo time de desenvolvedores do Squad 8 pela etapa de Hackathon do [Programa de Formação Season 3](https://digital.fcamara.com.br/programadeformacao) do [Grupo FCamara](https://www.fcamara.com.br/), e mostra todas as rotas criadas no back-end para dar suporte as solicitações do front-end. 

</div>

<br>

<h2 id='documentacao'>📄Documentação</h2>

A documentação foi implementada com o uso do [Swagger](https://swagger.io/)
<img src="https://user-images.githubusercontent.com/88353298/163569306-131bb742-e6cd-4a48-bff7-5f3ef609c3c1.png" alt="postman_sample" width="800">

<h2 id='tech'>🚀Tecnologias</h2>

O projeto foi desenvolvido empregando o framework do Swagger como interface para acesso direto às rotas do sistema implementado em [Spring Boot 2.6.6](https://spring.io/projects/spring-boot) e [Java 11](https://docs.oracle.com/en/java/javase/11/docs/api/index.html). O banco de dados utilizado foi PostgresSQL do próprio Heroku onde a aplicação está disponibilizada. Não são necessárias instalações de programas terceiros para executar e manipular a [API](https://technicalsharesquad8.herokuapp.com/swagger-ui/index.html). 
<p>
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg"  width='80px'/>
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg"  width='80px'/>
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" width='80px'/>
</p>


<br>

<h2 id='instrucoes'>🛠Instruções</h2>

Foi utilizada a configuração básica de segurança do Spring Security, por isso algumas rotas são de acesso restrito, controlado pelo tipo de autorização que cada usuário possui: 
- ADMIN para administradores do sistema podem acessar todas as rotas com exceção da /skill/* , essa role possui a função exclusiva de cadastro de outros usuários e definições de suas autorizações através da rota user/register.
- DEV se refere aos desenvolvedores que fazem manutenção/atualização no sistema. Eles são os únicos com acesso as rotas /skill/* para o controle de inserção, atualização e remoção de habilidades no sistema.
- CLIENT é a autorização criada por padrão ao se cadastrar no sistema. Essa autorização permite o acesso às funcionalidades do sistema como buscar perfis, marcar encontros e verificar agendamentos.
- Obs.: existem rotas permitidas a todos os usuários que são as rotas de login(/user/login), cadastro(/profiles/register) e visualização das habilidades já inseridas no sistema (/skill).
- Obs. 2: existem usuários pré-cadastrados para facilitar a utilização das rotas:
  - usuário: admin / senha: admin (Autorização: ADMIN);
  - usuário dev / senha: dev (Autorização: DEV).

<br>

<h2 id="comorodaroprojeto">:gear:Como rodar o projeto?</h2>

O Back está disponivel na Web atraves da url https://technicalsharesquad8.herokuapp.com. Para utilização de qualquer rota basta completar a url com algum dos complementos mostrados na próxima sessão. Pode-se utilizar também o [Swagger-UI](https://technicalsharesquad8.herokuapp.com/swagger-ui/index.html) da aplicação.

Mas caso queira acessar localmente:
        
``` bash
git clone https://github.com/squad8-hackatho/squad8-hackathon-back.git ```

.
.
.
.
```
        

        
<br>

<h2 id='roteiro'>📝Roteiro</h2>

As rotas podem ser acessadas em qualquer ordem mas para melhor visualização dos dados de retorno é aconselhável a seguinte sequência:

### 1. /skill (não necessita de autenticação)
- Objetivo: Listar todas as habilidades cadastradas no banco de dados disponíveis para especificar as competências das quais o usuário se sente mais à vontade em compartilhar conhecimento.
- O que fazer:
  - Basta acessar a rota que ela retorna a lista das habilidades no sistema.
  - Utilizar

### 2. /profiles/register (não necessita de autenticação)
- Objetivo: É enviado um json com as principais características a serem cadastradas no sistema e as informações são retornadas para confirmação. (Já possui algumas informações extras para o próximo update). 
- O que fazer:  
  - Cadastre dois ou mais usuários para melhor utilização das próximas rotas;
  - Não precisa preencher todos os campos, os únicos requerimentos obrigatórios são userName, email e caso decida colocar alguma habilidade, ela tem que seguir exatamente o padrão da rota /skill.

### 3. /profiles/* (métodos GET - necessita de alguma autenticação)
- Objetivo: Encontrar perfil(s) no sistema.
 1. /profiles/findprofile : Encontrar um perfil no sistema através do email.
 2. /proiles/findbyskill : Utiliza campo "skill" das habilidades para filtrar os perfis buscados a partir de uma ou duas habilidades, permitindo também um filtro por nível de experiência (Sênior, Pleno, Júnior, Trainee, Estagiário). O único campo obrigatório é o "toExcludeProfileEmail" que serve para retirar da lista retornada o perfil de quem está fazendo essa busca.
 3. /proiles/findbyname : Retorna lista de usuários pelo nome ou parte dele, também utiliza o campo "toExcludeProfileEmail".
 4. /profiles/findbyall : Apresenta listagem de todos os usuários do sistema exceto o perfil com email passado no campo "toExcludeProfileEmail".

### 4. /requisitions (necessita de alguma autenticação)
  1.POST
        - Objetivo: É enviado um json com os dados necessários para a marcação de um encontro entre quem realizou a requisição e o profissional escolhido. 

<table>
<tr>
<th> Json </th>
<th> Comentários </th>
</tr>
<tr>
<td>

``` json
{
  "uuidRequisition": "3fa85f64-5717-4562-b3fc-2c963f66afa6",   
  "userName": "string",         
  "userEmail": "string",       
  "requiredUserName": "string",        
  "requiredUserEmail": "string",       
  "subject": "string",         
  "keyWords": "string",         
  "urgency": true,      
  "message": "string",         
  "contactList": [      
    {
      "contact": "string",      
      "type": "string"          
    }
  ]
}
```

</td>
<td>

```json

  campo desnecessário, ele é gerado internamente pelo back
  nome do usuário que está fazendo a requisição
  email do usuário que está fazendo a requisição
  nome do usuário que irá receber a requisição
  email do usuário que irá receber a requisição
  assunto que será tratado durante o encontro
  palavras chaves que fazem parte do assunto a ser tratado
  indicador com valores verdadeiro/falso para mostrar a urgência da requisição
  texto com explicação mais detalhada sobre a intenção da marcação do encontro
  lista de contatos para que o requisitado possa se comunicar com o solicitante 
    
  email, telefone ou outro contato em si
  campo informando qual tipo de comunicação foi utilizado 
    
  

```

</td>
</tr>
</table>


  2.GET
        - Objetivo: Deleta uma requisição já feita a partir do uuid da requisição e do email da pessoa que está fazendo o pedido de remoção, seja a pessia que ou a que recebeu a requisição do econtro.

### 5. /skill/* (somente autenticação DEV)

<table>
<tr>
<th> Json </th>
<th> Comentários </th>
</tr>
<tr>
<td>

``` json
{
  "uuidRequisition": "3fa85f64-5717-4562-b3fc-2c963f66afa6",   
  "userName": "string",         
  "userEmail": "string",       
  "requiredUserName": "string",        
  "requiredUserEmail": "string",       
  "subject": "string",         
  "keyWords": "string",         
  "urgency": true,      
  "message": "string",         
  "contactList": [      
    {
      "contact": "string",      
      "type": "string"          
    }
  ]
}
```

</td>
<td>

```json

  campo desnecessário, ele é gerado internamente pelo back
  nome do usuário que está fazendo a requisição
  email do usuário que está fazendo a requisição
  nome do usuário que irá receber a requisição
  email do usuário que irá receber a requisição
  assunto que será tratado durante o encontro
  palavras chaves que fazem parte do assunto a ser tratado
  indicador com valores verdadeiro/falso para mostrar a urgência da requisição
  texto com explicação mais detalhada sobre a intenção da marcação do encontro
  lista de contatos para que o requisitado possa se comunicar com o solicitante 
    
  email, telefone ou outro contato em si
  campo informando qual tipo de comunicação foi utilizado 
    
  

```

</td>
</tr>
</table>


### 6. /user/register (somente autenticação ADMIN)

### 7. /user/login (não necessita de autenticação)


<br>


<hr>
<p> Feito com muito 🧡 pelo Squad-8<br> #FuturosSangueLaranja 🚀 <p>
