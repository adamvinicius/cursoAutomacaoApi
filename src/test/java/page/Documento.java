package page;


import java.util.HashMap;
import java.util.Map;

public class Documento {
	Map<String, Object> documento = new HashMap<>();
	
	public Map<String, Object> getDocumento() {
		return documento;
	}

	public void put(String key, String value) {
		documento.put(key, value);
	}

	
	
}
