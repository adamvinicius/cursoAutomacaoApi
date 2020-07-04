#language: pt
@tag
Funcionalidade: test api

  @tag1
  Cenario: test api
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
    E realizo um post com o endpoint "/posts"
    Entao valido o campo "nome" com o valor "Adam"
    E valido o campo "documentos[0].tipo" com o valor "rg"
    E valido o campo "documentos[1].tipo" com o valor "cpf"

  @tag1
  Esquema do Cenario: <cenario>
    Dado que acesso a url "https://jsonplaceholder.typicode.com"
    Quando preencho o campo "nome" com "<nome>" do objeto json
    E preencho o campo "idade" com <idade> do objeto json
    E preencho o campo "tipo" com "<tipo>" no objeto documento
    E preencho o campo "numero" com "<numero>" no objeto documento
    E preencho o campo "tipo" com "<tipo_dois>" no objeto documento_dois
    E preencho o campo "numero" com "<numero_dois>" no objeto documento_dois
    E adiciono na lista documentos o objeto documento
    E adiciono na lista documentos o objeto documento_dois
    E preencho o campo "documentos" com a lista documentos no objeto json
    E realizo um post com o endpoint "/posts"
    Entao valido o campo "nome" com o valor "<nome_retorno>"
    E valido o campo "documentos[0].tipo" com o valor "<tipo_retorno>"
    E valido o campo "documentos[1].tipo" com o valor "<tipo_dois_retorno>"

    Exemplos: 
      | cenario        | nome     | idade | tipo | numero     | tipo_dois         | numero_dois | nome_retorno | tipo_retorno | tipo_dois_retorno |
      | teste Adam     | Adam     |    31 | rg   | 5421542121 | cpf               |   548755421 | Adam         | rg           | cpf               |
      | teste Jose     | Jose     |    35 | rg   | 5121412512 | cnh               |   875421214 | Jose         | rg           | cnh               |
      | teste Igor     | Igor     |    34 | rg   | 5874542121 | passaport         |   215412154 | Igor         | rg           | passaport         |
      | teste Maycon   | Maycon   |    25 | rg   | 8984545121 | titulo de eleitor |   875412154 | Maycon       | rg           | titulo de eleitor |
      | teste Severino | Severino |    52 | rg   | 1213154531 | cpf               |   665421313 | Severino     | rg           | cpf               |
