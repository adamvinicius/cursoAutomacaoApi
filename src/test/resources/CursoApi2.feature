#language: pt
@curso
Funcionalidade: test api


  Contexto: test api
    Dado que acesso a url "https://jsonplaceholder.typicode.com"
    Quando preencho o campo "nome" com "Adam" do objeto json
    E preencho o campo "idade" com 31 do objeto json
    E preencho o campo "tipo" com "rg" no objeto documento
    E preencho o campo "numero" com "5421542121" no objeto documento
    E preencho o campo "tipo" com "cpf" no objeto documento_dois
    E preencho o campo "numero" com "548755421" no objeto documento_dois
    E adiciono na lista documentos o objeto documento
    E adiciono na lista documentos o objeto documento_dois
    E preencho o campo "documentos" com a lista documentos no objeto json
    

  @tag1
  Esquema do Cenario: <cenario>
    Quando preencho o campo "nome" com "<nome>" do objeto json
    E realizo um post com o endpoint "/posts"
    Entao valido o campo "nome" com o valor "<nome>"
    E valido o campo "documentos[0].tipo" com o valor "rg"
    E valido o campo "documentos[1].tipo" com o valor "cpf"

    Exemplos: 
      | cenario        | nome     |
      | teste Adam     | Adam     |
      | teste Jose     | Jose     |
      | teste Igor     | Igor     |
      | teste Maycon   | Maycon   |
      | teste Severino | Severino |
