package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import page.Documento;
import page.Json;

public class JsonUtils {
	public static HashMap<String, Object> json = new HashMap<String, Object>();
	
	protected Documento documento = new Documento();
	protected Documento documentoDois = new Documento();
	protected List<Map<String, Object>> documentos = new ArrayList<Map<String,Object>>();
	protected Json jsonT = new Json();	
	
}
