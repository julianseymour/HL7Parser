package segments;

import java.util.HashMap;

import core.Hl7Generator;
import segments.groups.ImmunizationHistoryGroupDefinition;
import segments.groups.ObservationGroupDefinition;
import segments.groups.OrderGroupDefinition;
import segments.groups.PatientIdentifierGroupDefinition;
import segments.groups.ResponseGroupDefinition;
import segments.groups.SegmentGroupDefinition;

public class Hl7SegmentGenerator extends Hl7Generator{

	protected HashMap<String, Hl7SegmentDefinition> definitions;
	protected HashMap<String, SegmentGroupDefinition> groups;
	
	public Hl7SegmentDefinition define(String code){
		try{
			switch(code){
				case "BHS":
					return new BatchHeaderSegmentDefinition(); //.class;
				case "BTS":
					return new BatchTrailerSegmentDefinition(); //.class;
				case "ERR":
					return new ErrorSegmentDefinition(); //.class;
				case "FHS":
					return new FileHeaderSegmentDefinition(); //.class;
				case "FTS":
					return new FileTrailerSegmentDefinition(); //.class;
				case "MSA":
					return new MessageAcknowledgementSegmentDefinition(); //.class;
				case "MSH":
					return new MessageHeaderSegmentDefinition(); //.class;
				case "NK1":
					return new NextOfKinSegmentDefinition(); //.class;
				case "NTE":
					return new NoteSegmentDefinition(); //.class;
				case "OBX":
					return new ObservationResultSegmentDefinition(); //.class;
				case "ORC":
					return new OrderRequestSegmentDefinition(); //.class;
				case "PD1":
					return new PatientDemographicSegmentDefinition(); //.class;
				case "PID":
					return new PatientIdentifierSegmentDefinition(); //.class;
				case "PV1":
					return new PatientVisitSegmentDefinition(); //.class;
				case "QAK":
					return new QueryAcknowledgementSegmentDefinition(); //.class;
				case "QPD":
					return new QueryParameterSegmentDefinition(); //.class;
				case "RCP":
					return new ResponseControlParameterSegmentDefinition(); //.class;
				case "RXA":
					return new PharmacyTreatmentAdministrationSegmentDefinition(); //.class;
				case "RXR":
					return new PharmacyTreatmentRouteSegmentDefinition(); //.class;
				case "ZSA":
					return new CustomErrorSegmentDefinition();
				case "DSC":
				case "GT1":
				case "IN1":
				case "IN2":
				case "IN3":
				case "PV2":
				case "SFT":
				case "TQ1":
				case "TQ2":
					return new EmptySegmentDefinition();
				default:
					throw new Exception("Undefined segment type \""+code+"\"");
			}
			//Class<? extends Hl7SegmentDefinition> classType = Hl7SegmentGenerator.getClassFromCode(code);
			//return classType.getDeclaredConstructor().newInstance();
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public MessageHeaderSegmentDefinition header(){
		return (MessageHeaderSegmentDefinition) this.getDefinition("MSH");
	}
	
	public Hl7SegmentDefinition getDefinition(String type){
		return (Hl7SegmentDefinition) super.getDefinition(type);
	}
	
	public Hl7Segment parse(String s){
		try{
			//System.out.println("Received the string \""+s+"\"");
			String[] splat = s.split("\\|");
			/*for(int i = 0; i < splat.length; i++){
				System.out.println(splat[i]);
			}*/
			if(splat.length < 1){
				throw new Exception("Unable to split string by vertical bar");
			}
			String segtype = splat[0];
			//System.out.println("Segment type is "+segtype);
			Hl7SegmentDefinition def = this.getDefinition(segtype);
			if(def == null){
				throw new Exception("Invalid segment type \""+segtype+"\"");
			}
			Hl7Segment segment = new Hl7Segment(def);
			for(int i = 0; i < splat.length; i++){
				if(splat[i].equals("") || splat[i] == null){
					//String name = def.getComponentName(i);
					//System.out.println("No value assigned for field "+i+" ("+name+")");
					continue;
				}
				//System.out.println("Assigning value \""+splat[i]+"\" to component "+name);
			}
			segment.parse(s);
			//System.out.println("Done parsing "+segtype+" segment");
			return segment;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public boolean hasGroupDefinition(String name){
		return this.groups != null && this.groups instanceof HashMap && this.groups.containsKey(name);
	}
	
	public SegmentGroupDefinition group(String name){
		try{
			if(this.hasGroupDefinition(name)){
				//System.out.println("Returning existing segment group definition \""+name+"\"");
				return this.groups.get(name);
			}
			SegmentGroupDefinition definition = null;
			switch(name){
				case "ImmunizationHistory":
					definition = new ImmunizationHistoryGroupDefinition(this);
					break;
				case "Observation":
					definition = new ObservationGroupDefinition(this);
					break;
				case "Order":
					definition = new OrderGroupDefinition(this);
					break;
				case "PatientIdentifier":
					definition = new PatientIdentifierGroupDefinition(this);
					break;
				case "Response":
					definition = new ResponseGroupDefinition(this);
					break;
				default:
					throw new Exception("Undefiined group name "+name);
			}
			if(this.groups == null){
				this.groups = new HashMap<String, SegmentGroupDefinition>();
			}
			this.groups.put(name, definition);
			//System.out.println("Returning newly instantiated group definition \""+name+"\"");
			return definition;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public OrderGroupDefinition orderGroup(){
		return (OrderGroupDefinition) this.group("Order");
	}
	
	public ImmunizationHistoryGroupDefinition immunizationHistoryGroup(){
		return (ImmunizationHistoryGroupDefinition) this.group("ImmunizationHistory");
	}
	
	public ObservationGroupDefinition observationGroup(){
		return (ObservationGroupDefinition) this.group("Observation");
	}
	
	public PatientIdentifierGroupDefinition patientIdentifierGroup(){
		return (PatientIdentifierGroupDefinition) this.group("PatientIdentifier");
	}
	
	public ResponseGroupDefinition responseGroup(){
		return (ResponseGroupDefinition) this.group("Response");
	}
}
