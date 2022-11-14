package messages;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import core.Hl7Generator;
import segments.Hl7Segment;
import segments.Hl7SegmentGenerator;

public class Hl7MessageGenerator extends Hl7Generator{
	
	protected HashMap<String, Hl7MessageDefinition> definitions;
	protected Hl7SegmentGenerator segmentGenerator;
	
	public Hl7MessageDefinition define(String code){
		try{
			Hl7SegmentGenerator gen = this.getSegmentGenerator();
			switch(code){
				case "ACK":
					return new AcknowledgeMessageDefinition(gen);
				case "QBP":
					return new QueryByParametersMessageDefinition(gen);
				case "RSP":
					return new ResponseToRequestForInformationMessageDefinition(gen);
				case "VXU":
					return new SendImmunizationHistoryMessageDefinition(gen);
				default:
					throw new Exception("Undefined message type \""+code+"\"");
			}
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public Hl7MessageDefinition getDefinition(String type){
		return (Hl7MessageDefinition) super.getDefinition(type);
	}
	
	public Hl7SegmentGenerator setSegmentGenerator(Hl7SegmentGenerator sg){
		return this.segmentGenerator = sg;
	}
	
	public boolean hasSegmentGenerator(){
		return this.segmentGenerator != null && this.segmentGenerator instanceof Hl7SegmentGenerator;
	}
	
	public Hl7SegmentGenerator getSegmentGenerator(){
		if(!this.hasSegmentGenerator()){
			return this.setSegmentGenerator(new Hl7SegmentGenerator());
		}
		return this.segmentGenerator;
	}
	
	public Hl7Message parseFile(File file){
		try{
			Scanner scanner = new Scanner(file);
			Hl7SegmentGenerator sg = this.getSegmentGenerator();
			Hl7Segment header = sg.parse(scanner.nextLine());
			//System.out.println("About to get message type...");
			String msg_type = header.getSubcomponentValueString("MessageType", "MessageCode");
			//System.out.println("Message type is \""+msg_type+"\"");
			Hl7MessageDefinition def = this.define(msg_type);
			Hl7Message message = new Hl7Message(def);
			//System.out.println("Instantiated message");
			message.pushSegment(header);
			while(scanner.hasNextLine()){
				Hl7Segment segment = sg.parse(scanner.nextLine());
				message.pushSegment(segment);
			}
			scanner.close();
			//System.out.println("Done iterating over segments");
			return message;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public Hl7Message parseFilename(String filename){
		return this.parseFile(new File(filename));
	}
}
