package steps;

import io.cucumber.java.pt.Quando;
import utils.JsonUtils;

public class JsonSteps {
		
	@Quando("preencho o campo {string} com {string} do objeto json")
	public void preenchoOCampoComDoObjetoJson(String key, String value) {
	    JsonUtils.json.put(key, value);
	}

	@Quando("preencho o campo {string} com {int} do objeto json")
	public void preenchoOCampoComDoObjetoJson(String key, Integer value) {
		JsonUtils.json.put(key, value);
	}
}
