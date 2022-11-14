package main;

import messages.Hl7Message;
import messages.Hl7MessageGenerator;
import segments.Hl7SegmentGenerator;

public class Main{

	public static void main(String[] args){
		try{
			if(args.length == 0){
				System.out.println("No input arguments");
			}else{
				Hl7MessageGenerator mg = new Hl7MessageGenerator();
				mg.setSegmentGenerator(new Hl7SegmentGenerator());
				/*String[] codes = new String[]{"ACK", "QBP", "RSP", "VXU"};
				for(int i = 0; i < 4; i++){
					mg.define(codes[i]);
				}*/
				for(int i = 0; i < args.length; i++){
					System.out.println("Opening file "+args[i]);
					Hl7Message msg = mg.parseFilename(args[i]);
					MessagePrinter.printMessage(msg);
					System.out.println("About to print the message as a string");
					String s = msg.toString();
					String[] splat = s.split("\r");
					for(int j = 0; j < splat.length; j++){
						System.out.println(splat[j]);
					}
					System.out.println("Converted the contents of "+args[i]+" back into a string");
				}
			}
			System.out.println("Returning normally");
			System.exit(0);
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
	}
}
