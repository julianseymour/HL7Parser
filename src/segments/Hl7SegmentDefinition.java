package segments;

import java.util.HashMap;
import java.util.Map;

import core.CompositeElementInterface;
import core.ConditionalPredicate;
import core.Hl7ComponentDefinition;
import fields.Hl7FieldDefinition;

public abstract class Hl7SegmentDefinition extends Hl7ComponentDefinition implements CompositeElementInterface{
	
	public abstract String getSegmentType();
	
	public Hl7SegmentDefinition(){
		this.generateComponents();
		Map<String, Integer> numbers = new HashMap<String, Integer>();
		for(int i = 0; i < this.getComponentCount(); i++){
			numbers.put(this.getComponent(i).getName(), i);
			this.getComponent(i).setDepth(2);
		}
		this.numbers = numbers;
		/*for(int i = 0; i < this.getComponentCount(); i++){
			Hl7ComponentDefinition fd = this.getComponent(i);
			if(!fd.hasMaxCardinality() || fd.getMaxCardinality() > 1){
				System.out.println("Field "+fd.getName()+" of segment "+this.getSegmentType()+" has a max cardinality of "+fd.getMaxCardinality());
			}
		}*/
	}
	
	public final String getName(){
		return this.getSegmentType();
	}
	
	public Hl7SegmentDefinition conditional(ConditionalPredicate closure){
		return (Hl7SegmentDefinition) super.conditional(closure);
	}
	
	public Hl7SegmentDefinition cardinality(int min, int max){
		return (Hl7SegmentDefinition) super.cardinality(min, max);
	}
	
	public Hl7SegmentDefinition usage(String symbol){
		return (Hl7SegmentDefinition) super.usage(symbol);
	}
	
	public Hl7SegmentDefinition optional(){
		return (Hl7SegmentDefinition) super.optional();
	}
	
	public Hl7SegmentDefinition required(){
		return (Hl7SegmentDefinition) super.required();
	}
	
	public Hl7SegmentDefinition requiredEmpty(){
		return (Hl7SegmentDefinition) super.requiredEmpty();
	}
	
	public Hl7SegmentDefinition unsupported(){
		return (Hl7SegmentDefinition) super.unsupported();
	}
	
	public Hl7SegmentDefinition length(int min, int max){
		return (Hl7SegmentDefinition) super.length(min, max);
	}
	
	public Hl7SegmentDefinition withMinCardinality(int min){
		return (Hl7SegmentDefinition) super.withMinCardinality(min);
	}
	
	public String getComponentName(int i){
		return ((Hl7FieldDefinition) this.getComponent(i)).getName();
	}
	
	public int getComponentNumber(String name){
		try{
			return this.numbers.get(name);
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return -1;
	}
	
	public int getComponentCount(){
		return this.components == null ? 0 : this.components.length;
	}
	
	public Hl7FieldDefinition getComponent(int i){
		return (Hl7FieldDefinition) super.getComponent(i);
	}
	
	public Hl7FieldDefinition getComponent(String name){
		return this.getComponent(this.getComponentNumber(name));
	}
}
