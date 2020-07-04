package testes;




import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.JsonUtils;
import utils.RestUtils;

public class CursoAPI extends JsonUtils{
	
	@Test
	public void executaTeste() {
		System.out.println("Curso de testes de serviço!");
	}
	@Test
	public void executaTeste2() {
		System.out.println("Curso de testes de serviços 2!");
	}
	
	@Test
	public void testeSoma() {
		int resultado = soma(5, 4);
		Assert.assertEquals(9, resultado);
	}
	
	@Test
	public void testeSomaErro() {
		int resultado = soma(5, 4);
		Assert.assertEquals(10, resultado);
	}
	
	
	public int soma(int valorA, int valorB) {
		int resultado = valorA+valorB;
		return resultado;
	}
	
	@Test
	public void TesteApiGet() {
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.baseUri("http://viacep.com.br/ws/04055041/json/")
				.when()
				.get()
				.then()
				.statusCode(200)
				.extract()
				.response();
		//System.out.println(response.getBody().asString());
		
		String logradouro = response.getBody().jsonPath().get("logradouro");
		String bairro = response.getBody().jsonPath().get("bairro");
		
		Assert.assertEquals("Rua Mauro", logradouro);
		Assert.assertEquals("Saúde", bairro);
	}
	
	@Test
	public void TesteApiCepAdam() {
		RestUtils.executaGET("http://viacep.com.br/ws/","04055041/json/");
		
		String logradouro = RestUtils.getValue("logradouro").toString();
		String bairro = (String) RestUtils.getValue("bairro");
		
		Assert.assertEquals("Rua Mauro", logradouro);
		Assert.assertEquals("Saúde", bairro);
	}
	
	@Test
	public void TesteApiCepSeverino() {
		RestUtils.executaGET("http://viacep.com.br/ws/", "08090660/json");
		String logradouro = RestUtils.getValue("logradouro").toString();
		String bairro = (String)RestUtils.getValue("bairro");
		
		Assert.assertEquals("Rua Inácio Alvarez", logradouro);
		Assert.assertEquals("Jardim Helena", bairro);
	}
	
	@Test
	public void TesteApiPOST() {
		String json = "{\"nome\": \"Adam\",\"idade\": 31,\"documentos\": [{\"tipo\": \"rg\",\"numero\": \"5421542121\"},{\"tipo\": \"cpf\",\"numero\": \"548755421\"}]}";
		RestUtils.executaPOST("https://jsonplaceholder.typicode.com", "/posts", json);
		
		String nome = RestUtils.getValue("nome").toString();
		String tipoDocumento = RestUtils.getValue("documentos[0].tipo").toString();
		String tipoDocumento_dois = RestUtils.getValue("documentos[1].tipo").toString();
		
		Assert.assertEquals("Adam", nome);
		Assert.assertEquals("rg", tipoDocumento);
		Assert.assertEquals("cpf", tipoDocumento_dois);
		
	}
	
	@Test
	public void TesteApiPOST2() {
		String json = "{\"nome\": \"Renan\",\"idade\": 35,\"documentos\": [{\"tipo\": \"rg\",\"numero\": \"5421542121\"},{\"tipo\": \"cnh\",\"numero\": \"548755421\"}]}";
		RestUtils.executaPOST("https://jsonplaceholder.typicode.com", "/posts", json);
		
		String nome = RestUtils.getValue("nome").toString();
		String tipoDocumento = RestUtils.getValue("documentos[0].tipo").toString();
		String tipoDocumento_dois = RestUtils.getValue("documentos[1].tipo").toString();
		
		Assert.assertEquals("Renan", nome);
		Assert.assertEquals("rg", tipoDocumento);
		Assert.assertEquals("cnh", tipoDocumento_dois);
		
		
	}
	
	@Test
	public void TesteApiPostMap() {
		Map<String, Object> json = setDados("rg", "5421542121", "cpf", "548755421", "Adam", 31);
		RestUtils.executaPOST("https://jsonplaceholder.typicode.com", "/posts", json);
		
		String nome = RestUtils.getValue("nome").toString();
		String tipoDocumento = RestUtils.getValue("documentos[0].tipo").toString();
		String tipoDocumento_dois = RestUtils.getValue("documentos[1].tipo").toString();
		
		Assert.assertEquals("Adam", nome);
		Assert.assertEquals("rg", tipoDocumento);
		Assert.assertEquals("cpf", tipoDocumento_dois);
	}
	
	public Map<String, Object> setDados(String tipo, String numeroDocumento, String tipo_dois, String numeroDocumento_dois, String nome, int idade) {
		documento.put("tipo", tipo);
		documento.put("numero", numeroDocumento);
		documentoDois.put("tipo", tipo_dois);
		documentoDois.put("numero", numeroDocumento_dois);
		documentos.add(documento.getDocumento());
		documentos.add(documentoDois.getDocumento());	
		jsonT.put("nome", nome);
		jsonT.put("idade", idade);
		jsonT.put("documentos", documentos);
		
		return jsonT.getJson();
	}
	
	
	
	
}
