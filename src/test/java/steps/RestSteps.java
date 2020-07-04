package steps;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import utils.JsonUtils;
import utils.RestUtils;

public class RestSteps {
	String url = "";
	@Dado("que acesso a url {string}")
	public void queAcessoAUrl(String _url) {
	    url = _url;
	}
	
	@Quando("realizo um post com o endpoint {string}")
	public void realizoUmPostComOEndpoint(String endpoint) {
	    RestUtils.executaPOST(url, endpoint, JsonUtils.json);
	}

	@Entao("valido o campo {string} com o valor {string}")
	public void validoOCampoComOValor(String key, String value) {
	    String atual = RestUtils.getValue(key).toString();
	    Assert.assertEquals(value, atual);
	}
	
}
