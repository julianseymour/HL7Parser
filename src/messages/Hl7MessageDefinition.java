package messages;

import core.Hl7ElementDefinition;
import segments.Hl7SegmentGenerator;

public abstract class Hl7MessageDefinition extends Hl7ElementDefinition{
	
	protected Hl7SegmentGenerator segmentGenerator;
	
	public abstract String getMessageType();
	
	public Hl7MessageDefinition(Hl7SegmentGenerator gen){
		this.setSegmentGenerator(gen);
		this.generateComponents();
		/*for(int i = 0; i < this.getComponentCount(); i++){
			Hl7ComponentDefinition fd = this.getComponent(i);
			if(!fd.hasMaxCardinality() || fd.getMaxCardinality() > 1){
				System.out.println("Segment/group "+fd.getName()+" of message "+this.getMessageType()+" has a max cardinality of "+fd.getMaxCardinality());
			}
		}*/
	}
	
	public Hl7SegmentGenerator setSegmentGenerator(Hl7SegmentGenerator sg){
		return this.segmentGenerator = sg;
	}
	
	public boolean hasSegmentGenerator(){
		return this.segmentGenerator != null && this.segmentGenerator instanceof Hl7SegmentGenerator;
	}
	
	public Hl7SegmentGenerator getSegmentGenerator(){
		String f = "Hl7MessageDefinition.getSegmentGenerator()";
		try{
			if(!this.hasSegmentGenerator()){
				throw new Exception(f+": HL7 segment generator is undefined");
			}
			return this.segmentGenerator;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public int getComponentCount(){
		return this.components == null ? 0 : this.components.length;
	}
}
