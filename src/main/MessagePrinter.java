package main;

import java.util.LinkedList;
import java.util.Optional;

import fields.CompositeField;
import fields.CompositeFieldDefinition;
import fields.Hl7FieldDefinition;
import messages.Hl7Message;
import segments.Hl7Segment;
import segments.Hl7SegmentDefinition;

public class MessagePrinter{

	public static void printMessage(Hl7Message message){
		String type = message.getMessageType();
		int count = message.getSegmentCount();
		System.out.println("Printing a "+type+" message with "+count+" segments");
		for(int i = 0; i < count; i++){
			Hl7Segment seg = message.getSegment(i);
			MessagePrinter.printSegment(seg);
		}
		System.out.println("Finished printing "+type+" message with "+count+" segments");
	}
	
	public static void printSegment(Hl7Segment segment){
		try{
			Hl7SegmentDefinition def = segment.getDefinition();
			String type = def.getSegmentType();
			System.out.println(type+": {");
			int count = segment.getComponentCount();
			for(int i = 0; i < count; i++){
				if(!segment.hasComponentValue(i)){
					continue;
				}
				Hl7FieldDefinition fd = def.getComponent(i);
				Object value = segment.getComponentValue(i);
				if(value instanceof Optional){
					throw new Exception("Component value is an optional");
				}
				MessagePrinter.printField(fd, value);
			}
			System.out.println("}");
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static void tab(int i){
		for(int j = 0; j < i; j++){
			System.out.print('\t');
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void printField(Hl7FieldDefinition definition, Object context){
		String type = definition.getFieldType();
		String name = definition.getName();
		int depth = definition.getDepth();
		tab(depth);
		System.out.print(type+" "+name+": ");
		if(definition instanceof CompositeFieldDefinition){
			System.out.println("{");
			CompositeFieldDefinition cd = (CompositeFieldDefinition) definition;
			CompositeField cf = (CompositeField) context;
			for(int i = 0; i < cd.getComponentCount(); i++){
				if(!cf.hasComponentValue(i)){
					continue;
				}
				MessagePrinter.printField(cd.getComponent(i), cf.getComponent(i));
			}
			tab(depth);
			System.out.println("}");
		}else{
			if(definition.isRepeatable() && context instanceof LinkedList){
				System.out.print("[");
				int size = ((LinkedList<Object>)context).size();
				for(int i = 0; i < size; i++){
					tab(depth+1);
					System.out.print(((LinkedList<Object>)context).get(i).toString());
					if(i < size-1){
						System.out.print(",");
					}
					System.out.println();
				}
				System.out.println("]");
			}else{
				System.out.println(context.toString());
			}
		}
	}
}
