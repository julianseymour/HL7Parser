package messages;

import java.util.LinkedList;
import java.util.List;

import core.DefinedInterface;
import core.Hl7ElementDefinition;
import segments.Hl7Segment;

public class Hl7Message implements DefinedInterface{

	protected Hl7MessageDefinition definition;
	protected List<Hl7Segment> segments;
	
	public Hl7Message(Hl7MessageDefinition definition){
		this.setDefinition(definition);
	}

	public Hl7MessageDefinition getDefinition(){
		try{
			if(!this.hasDefinition()){
				throw new Exception("Message definition is undefined");
			}
			return this.definition;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	public boolean hasDefinition(){
		return this.definition != null && this.definition instanceof Hl7MessageDefinition;
	}

	public Hl7MessageDefinition setDefinition(Hl7MessageDefinition definition){
		return this.definition = definition;
	}

	public Hl7ElementDefinition setDefinition(Hl7ElementDefinition definition) {
		return this.setDefinition((Hl7MessageDefinition) definition);
	}
	
	public boolean pushSegment(Hl7Segment segment){
		if(this.segments == null){
			this.segments = new LinkedList<Hl7Segment>();
		}
		return this.segments.add(segment);
	}
	
	public int getSegmentCount(){
		return this.segments == null ? 0 : this.segments.size();
	}
	
	public List<Hl7Segment> getSegments(){
		return this.segments;
	}
	
	public String getMessageType(){
		return this.getDefinition().getMessageType();
	}
	
	public boolean hasSegment(int i){
		return this.segments instanceof List && this.segments.size() > i;
	}
	
	public Hl7Segment getSegment(int i){
		try{
			if(!this.hasSegment(i)){
				throw new Exception("Undefined segment "+i);
			}
			return this.segments.get(i);
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public String toString(){
		String ret = "";
		for(int i = 0; i < this.getSegmentCount(); i++){
			ret += this.getSegment(i).toString() + '\r';
		}
		return ret;
	}
}
