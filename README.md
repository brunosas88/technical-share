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

</div>

<br>

<h2 id='documentacao'>📄Documentação</h2>

A documentação foi implementada com o uso do [Swagger](https://swagger.io/)
<img src="https://user-images.githubusercontent.com/88353298/163569306-131bb742-e6cd-4a48-bff7-5f3ef609c3c1.png" alt="postman_sample" width="800">

<h2 id='tech'>🚀Tecnologias</h2>

O projeto foi desenvolvido empregando o framework do Swagger como interface para acesso direto às rotas do sistema implementado em [Spring Boot 2.6.6](https://spring.io/projects/spring-boot) e [Java 11](https://docs.oracle.com/en/java/javase/11/docs/api/index.html). O banco de dados utilizado foi [PostgresSQL](https://www.postgresql.org/) do próprio [Heroku](https://www.heroku.com/) onde a aplicação está disponibilizada. Não são necessárias instalações de programas terceiros para executar e manipular a [API](https://technicalsharesquad8.herokuapp.com/swagger-ui/index.html). 
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

Mas caso queira acessar localmente ao site:
        
``` bash
git clone https://github.com/squad8-hackatho/squad8-hackathon-back.git
```
- Abra o projeto em um editor de codigo para Spring Boot de sua preferencia (recomendamos o [VSCode](https://code.visualstudio.com)
- Caso escolhar rodar utilizando o VSCode certifique-se de que possue as seguintes extensões instaladas
  - [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
<img src="https://user-images.githubusercontent.com/88353298/163655204-b6ce2524-efcc-40a5-852e-d4d57309eb92.png" width="800"/>

  - [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack)
<img src="https://user-images.githubusercontent.com/88353298/163655232-cb2910b1-b49f-43cb-a4ee-aa5598d31e22.png" width="800"/>

- Agora apenas inicie sua aplicação utilizando a guia "spring-boot-dashboard":
<img src="https://user-images.githubusercontent.com/88353298/163655038-ff7da9cd-80d8-42db-89c6-5ad5e7ef81e8.png"/>

<hr>
*A aplicação (backend) está conectada com o Swagger e será aberta na porta:8080 - acesse http://localhost:8080.*

<hr>

Caso queria ter acesso ao banco de dados que disponivel online localmente:

- Abra uma ferramenta de administração de banco de dados Postegre de sua perferencia (recomentados o [DBeaver](https://dbeaver.io/download/)) 

- Insira os dados para conexão
<img src="https://user-images.githubusercontent.com/88353298/163654347-154918e3-5a21-41d8-b98d-9521ac4651c0.png" />

*A imagem abaixo é um exemplo de como seria a conexão através do DBeaver*
<img src="https://user-images.githubusercontent.com/88353298/163654343-ec7a16a3-5b16-44d4-994c-1242e5afc166.png" />

e pronto ...


        
<br>

<h2 id='roteiro'>📝Roteiro</h2>

As rotas podem ser acessadas em qualquer ordem mas para melhor visualização dos dados de retorno é aconselhável a seguinte sequência:

### 1. /skill (não necessita de autenticação)
- **Objetivo:** Listar todas as habilidades cadastradas no banco de dados disponíveis para especificar as competências das quais o usuário se sente mais à vontade em compartilhar conhecimento.
- **Como fazer:**
  - Acessando a rota ela retorna a lista das habilidades que já estão no sistema.                       
```                                 
https://technicalsharesquad8.herokuapp.com/skill   
``` 

### 2. /skill/* (somente autenticação DEV)
- **Objetivo:** Remoção/Atualização/Cadastro de habilidades no sistema.
        - **Obs.:** Alteração e remoção só podem ser feitas em habilidades que ainda não foram utilizadas no cadastro de perfis. Por isso a equipe de desenvolvedores tem que estabelecer diretrizes e padronização para inserção de habilidades no sistema.  
- **/skill/deletesingle** : Deleta uma habilidade do banco de dados a partir de seu nome. <br>
        - **Como fazer:**
                - Requisição enviada por parâmetro na url.
```         
https://technicalsharesquad8.herokuapp.com/skill/deletesingle?skill=PARAMETRO-NOME-SKILL-EXEMPLO
```         
- **/skill/update** : Atualiza o nome de uma habilidade ou sua area relacionada ou os dois campos a partir de seu nome antigo. <br>
        - **Como fazer:**
                - Requisição enviada por parâmetro na url.
```         
https://technicalsharesquad8.herokuapp.com/skill/update?toChangeSkill=PARAMETRO-NOME-ANTIGO-SKILL-EXEMPLO&newSkillName=PARAMETRO-NOME-NOVO-SKILL-EXEMPLO&newAreaName=PARAMETRO-AREA-EXEMPLO
```         
- **/skill/register** : Registra uma ou mais habilidades a partir de um json enviado. <br>
        - **Como fazer:**
            - Envio de json.
<table>
<tr>
<th> Json </th>
<th> Comentários </th>
</tr>
<tr>
<td>

```json
[
  {
    "skill": "string",
    "area": "string"
  }
]
```

</td>
<td>

```json

  
nome da habilidade
nome da área a qual a habilidade está relacionada
  

```

</td>
</tr>
</table>

### 3. /profiles/register (não necessita de autenticação)
- **Objetivo:** Cadastra um perfil profissional no sistema. (Já possui algumas informações extras para o próximo update). 
- **Como fazer:**  
  - Envio de json.
  - Cadastre dois ou mais usuários para melhor utilização das próximas rotas;
  - Não precisa preencher todos os campos, os únicos requerimentos obrigatórios são **userName**, **email**, **senha** e caso decida colocar alguma habilidade, ela tem que seguir exatamente o padrão da rota **/skill**.
  - Obs.: O campo imagem guarda uma url que direcionaria para uma imagem na nuvem.

<table>
<tr>
<th> Json </th>
<th> Comentários </th>
</tr>
<tr>
<td>

``` json
{
  {
  "userName": "string",
  "email": "string",
  "password": "string",
  "expertiseList": [
    {
      "skill": "string",
      "area": "string"
    }
  ]
}
```

</td>
<td>

```json


nome do usuário
email do usuário
senha do usuário
lista de habilidades
  
habilidade (PRECISA SER EXATAMENTE O QUE ESTÁ NA REGISTRADO NO SISTEMA)
area da habilidade (PRECISA SER EXATAMENTE O QUE ESTÁ NA REGISTRADO NO SISTEMA)
  
 

```

</td>
</tr>
</table>

### 4. /profiles/* (métodos GET - necessita de alguma autenticação)
- **Objetivo:** Encontrar perfil(s) no sistema.
- **/profiles/findprofile** : Encontrar um perfil no sistema através do email. <br>
        - **Como fazer:**
                - Requisição enviada por parâmetro na url.
```         
https://technicalsharesquad8.herokuapp.com/profiles/findprofile?email=PARAMETRO-EMAIL-EXEMPLO
```         
- **/profiles/findbyskill** : Utiliza campo "skill" das habilidades para filtrar os perfis buscados a partir de uma ou duas habilidades, permitindo também um filtro por nível de experiência (campo deve ter valor exatamente igual aos inseridos no campo experienceLevel ao registrar perfil). O único campo obrigatório é o "toExcludeProfileEmail" que serve para retirar da lista retornada o perfil de quem está fazendo essa busca. <br>
        - **Como fazer:**
                - Requisição enviada por parâmetros na url.
```         
https://technicalsharesquad8.herokuapp.com/profiles/findbyskill?firstSkill=PARAMETRO-SKILL-1-EXEMPLO&secondSkill=PARAMETRO-SKILL-2-EXEMPLO&filterXP=PARAMETRO-FILTRO-EXEMPLO&toExcludeProfileEmail=PARAMETRO-EMAIL-EXEMPLO  
```  
- **/profiles/findbyname** : Retorna lista de usuários pelo nome ou parte dele, também utiliza o campo "toExcludeProfileEmail". <br>
        - **Como fazer:**
                - Requisição enviada por parâmetros na url.
```         
https://technicalsharesquad8.herokuapp.com/profiles/findbyname?name=PARAMETRO-NOME-EXEMPLO&toExcludeProfileEmail=PARAMETRO-EMAIL-EXEMPLO  
```   
- **/profiles/findbyall** : Apresenta listagem de todos os usuários do sistema exceto o perfil com email passado no campo "toExcludeProfileEmail". <br>
        - **Como fazer:**
                - Requisição enviada por parâmetros na url.
``` 
https://technicalsharesquad8.herokuapp.com/profiles/findall?toExcludeProfileEmail=PARAMETRO-EMAIL-EXEMPLO
```                
### 5. /requisitions (necessita de alguma autenticação)
  1.GET
        - **Objetivo:** Deleta uma requisição já feita a partir do uuid da requisição e do email da pessoa que está fazendo o pedido de remoção, seja a pessoa que fez ou a que recebeu a requisição do econtro.
        - **Como fazer:**
                - Requisição enviada por parâmetros na url.
```         
https://technicalsharesquad8.herokuapp.com/requisitions?uuidRequisition=EXEMPLO-UUID&emailRemoveRequest=EXEMPLO-EMAIL
```        
  2.POST
        - **Objetivo:** Marcação de um encontro entre quem realizou a requisição e o profissional escolhido. 
        - **Como fazer:**
            - Envio de json.
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
- **Objetivo:** Registrar usuário(login, senha e nível de autenticação) no sistema.
    - **Obs. :** Essa operação não cria um perfil de profisional dentro do sistema.
    - **Como fazer:**
        - Envio de json.
<table>
<tr>
<th> Json </th>
<th> Comentários </th>
</tr>
<tr>
<td>

```json
{
  "userName": "string",
  "password": "string",
  "roles": [
    "string"
  ]
}
```

</td>
<td>

```json

nome do usuário 
senha do usuário
lista de níveis autenticação (pode ter mais de um)
nível de autenticação do usuário


```

</td>
</tr>
</table>   

### 7. /user/login (não necessita de autenticação)
- **Objetivo:** Permitir acesso à aplicação web aos usuários com perfis profissionais cadastrados no sistema.
    - **Como fazer:**
        - Envio de json.
<table>
<tr>
<th> Json </th>
<th> Comentários </th>
</tr>
<tr>
<td>

```json
{
  "userName": "string",
  "password": "string"
}
```

</td>
<td>

```json

nome do usuário 
senha do usuário

```

</td>
</tr>
</table> 

<br>

<hr>

