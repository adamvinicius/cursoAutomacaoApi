package page;

import java.util.HashMap;
import java.util.Map;

public class Json {
	Map<String, Object> json = new HashMap<>();

	public Map<String, Object> getJson() {
		return json;
	}

	public void put(String key, Object value) {
		this.json.put(key, value);
	}
	
	
}
