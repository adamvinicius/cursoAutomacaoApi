package steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.pt.Quando;
import utils.JsonUtils;

public class DocumentosSteps {
	List<HashMap<String, Object>> documentos = new ArrayList<HashMap<String,Object>>();
	HashMap<String, Object> documento = new HashMap<String, Object>();
	HashMap<String, Object> documento_dois = new HashMap<String, Object>();
	
	@Quando("preencho o campo {string} com {string} no objeto documento")
	public void preenchoOCampoComNoObjetoDocumento(String key, String value) {
	    documento.put(key, value);
	}

	@Quando("preencho o campo {string} com {string} no objeto documento_dois")
	public void preenchoOCampoComNoObjetoDocumento_dois(String key, String value) {
	    documento_dois.put(key, value);
	}

	@Quando("adiciono na lista documentos o objeto documento")
	public void adicionoNaListaDocumentosOObjetoDocumento() {
	    documentos.add(documento);
	}

	@Quando("adiciono na lista documentos o objeto documento_dois")
	public void adicionoNaListaDocumentosOObjetoDocumento_dois() {
	    documentos.add(documento_dois);
	}

	@Quando("preencho o campo {string} com a lista documentos no objeto json")
	public void preenchoOCampoComAListaDocumentosNoObjetoJson(String key) {
	    JsonUtils.json.put(key, documentos);
	}
}
