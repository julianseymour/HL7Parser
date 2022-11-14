package fields;

import java.util.LinkedList;
import java.util.Optional;

import core.ConditionalPredicate;
import core.Hl7ComponentDefinition;

public abstract class Hl7FieldDefinition extends Hl7ComponentDefinition{
	
	public abstract String getFieldType();
	public abstract Object parse(String value);
	public abstract LinkedList<Object> parseRepeated(String value);
	
	protected Optional<Integer> depth;
	protected String name;
	
	public Hl7FieldDefinition(){
	}
	
	public Hl7FieldDefinition(String name){
		this();
		if(name != null){
			this.name = name;
		}else{
			this.name = null;
		}
	}
	
	public int setDepth(int depth){
		this.depth = Optional.of(depth);
		return depth;
	}
	
	public boolean hasDepth(){
		return this.depth != null && this.depth instanceof Optional && !this.depth.isEmpty();
	}
	
	public int getDepth(){
		try{
			if(!this.hasDepth()){
				throw new Exception("Depth is undefined");
			}
			return this.depth.get();
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return -1;
	}
	
	public String setName(String name){
		return this.name = name;
	}
	
	public boolean hasName(){
		return this.name != null;
	}
	
	public String getName(){
		try{
			if(!this.hasName()){
				throw new Exception("Name is undefined");
			}
			return this.name;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public Hl7FieldDefinition withName(String name){
		this.setName(name);
		return this;
	}
	
	public Hl7FieldDefinition conditional(ConditionalPredicate closure){
		return (Hl7FieldDefinition) super.conditional(closure);
	}
	
	public Hl7FieldDefinition cardinality(int min, int max){
		return (Hl7FieldDefinition) super.cardinality(min, max);
	}
	
	public Hl7FieldDefinition usage(String symbol){
		return (Hl7FieldDefinition) super.usage(symbol);
	}
	
	public Hl7FieldDefinition optional(){
		return (Hl7FieldDefinition) super.optional();
	}
	
	public Hl7FieldDefinition required(){
		return (Hl7FieldDefinition) super.required();
	}
	
	public Hl7FieldDefinition requiredEmpty(){
		return (Hl7FieldDefinition) super.requiredEmpty();
	}
	
	public Hl7FieldDefinition unsupported(){
		return (Hl7FieldDefinition) super.unsupported();
	}
	
	public Hl7FieldDefinition length(int min, int max){
		return (Hl7FieldDefinition) super.length(min, max);
	}
	
	public Hl7FieldDefinition withMinCardinality(int min){
		return (Hl7FieldDefinition) super.withMinCardinality(min);
	}
	
	protected void generateComponents(){
		//override in derived classes
	}
	
	public boolean isRepeatable(){
		return !this.hasMaxCardinality() || this.getMaxCardinality() > 1;
	}
	
	@SuppressWarnings("unchecked")
	public String convertString(Object value){
		String ret = "";
		if(this.isRepeatable() && value instanceof LinkedList){
			LinkedList<Object> list = (LinkedList<Object>)value;
			for(int i = 0; i < list.size(); i++){
				if(i > 0){
					ret += "~";
				}
				ret += this.convertString(list.get(i));
			}
		}else{
			ret += value.toString();
		}
		return ret;
	}
}
