package core;

import java.util.HashMap;

public abstract class Hl7Generator{

	public abstract Hl7ElementDefinition define(String type);
	
	protected HashMap<String, Hl7ElementDefinition> definitions;
	
	public boolean hasDefinition(String segment_type){
		return this.definitions != null && this.definitions instanceof HashMap && this.definitions.containsKey(segment_type);
	}
	
	public Hl7ElementDefinition getDefinition(String segment_type){
		if(this.hasDefinition(segment_type)){
			return this.definitions.get(segment_type);
		}else if(this.definitions == null){
			this.definitions = new HashMap<String, Hl7ElementDefinition>();
		}
		Hl7ElementDefinition def = this.define(segment_type);
		this.definitions.put(segment_type, def);
		return def;
	}
}
