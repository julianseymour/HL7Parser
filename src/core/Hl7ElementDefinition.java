package core;

import java.util.Map;

public abstract class Hl7ElementDefinition{

	protected Hl7ComponentDefinition[] components;
	protected Map<String, Integer> numbers;
	
	protected abstract void generateComponents();
	
	public Hl7ComponentDefinition getComponent(int i){
		try{
			return this.components[i];
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
}
