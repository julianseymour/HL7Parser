package fields;

public abstract class Hl7FieldGenerator{
	
	/*public static Class<? extends Hl7FieldDefinition> getClassFromCode(String code){
		try{
			switch(code){
				case "CE": //CE Coded element
					return CodedElementFieldDefinition.class;
				case "CE_TX": //CE_TX Text only CE data type
					return CodedElementTextOnlyFieldDefinition.class;
				case "CQ": //CQ Composite Quantity with Units
					return CompositeQuantityWithUnitsFieldDefinition.class;
				case "CWE": //CWE Coded with Exceptions
					return CodedWithExceptionsFieldDefinition.class;
				case "CX": //CX Extended Composite Id with Check digit
					return ExtendedCompositeIdWithCheckDigitFieldDefinition.class;
				case "DT": //DT Date
					return DateFieldDefinition.class;
				case "DTM": //DTM Date/Time
					return DateTimeFieldDefinition.class;
				case "EI": //EI Entity Identifier
					return EntityIdentifierFieldDefinition.class;
				case "ERL": //ERL Error Location
					return ErrorLocationFieldDefinition.class;
				case "FN": //FN Family Name
					return FamilyNameFieldDefinition.class;
				case "FT": //FT Formatted text
					return FormattedTextFieldDefinition.class;
				case "HD": //HD Hierarchic Designator
					return HierarchicDesignatorFieldDefinition.class;
				case "ID": //ID Coded Values for HL7 Tables
					return CodedValuesForHl7TablesFieldDefinition.class;
				case "IS": //IS Coded value for User-Defined Tables
					return CodedValuesForUserDefinedTablesFieldDefinition.class;
				case "LA2": //LA2 Location with address variation 2
					return LocationWithAddressVariation2FieldDefinition.class;
				case "MSG": //MSG Message Type
					return MessageTypeFieldDefinition.class;
				case "NM": //NM Numeric
					return NumericFieldDefinition.class;
				case "PT": //PT Processing Type
					return ProcessingTypeFieldDefinition.class;
				case "SAD": //SAD Street Address
					return StreetAddressFieldDefinition.class;
				case "SI": //SI Sequence ID
					return SequenceIdFieldDefinition.class;
				case "ST": //ST String
					return StringFieldDefinition.class;
				case "TS": //TS Time Stamp
					return TimestampFieldDefinition.class;
				case "VID": //VID Version Identifier
					return VersionIdFieldDefinition.class;
				case "XAD": //XAD Extended Address
					return ExtendedAddressFieldDefinition.class;
				case "XCN": //XCN Extended Composite ID Number and Name for Persons
					return ExtendedCompositeIdNumberAndNameForPersonsFieldDefinition.class;
				case "XON": //XON Extended Name and Id Number for Organizations
					return ExtendedCompositeIdNumberAndNameForOrganizationsFieldDefinition.class;
				case "XPN": //XPN Extended Person Name
					return ExtendedPersonNameFieldDefinition.class;
				case "XTN": //XTN Extended telephone number
					return ExtendedTelecommunicationNumberFieldDefinition.class;
				case "DT_D": //DT_D Date with precision to day
				//	return DateWithPrecisionToDayFieldDefinition.class;
				case "TS_M": //TS_M Time Stamp with optional precision to the day and no time zone
				//	return TimestampToMonthFieldDefinition.class;
				case "TS_NZ": //TS_NZ Time Stamp with precision to the day and no time zone
				//	return TimestampNoTimeZoneFieldDefinition.class;
				case "TS_Z": //TS_Z Time Stamp requiring time zone
				//	return TimestampWithTimeZoneFieldDefinition.class;
				default:
					throw new Exception("Undefined data type \""+code+"\"");
			}
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return Hl7FieldDefinition.class;
	}*/
	
	public static Hl7FieldDefinition define(String code){
		try{
			//System.out.println("About to instantiate a field defintion with code \""+code+"\"");
			switch(code){
				case "CE": //CE Coded element
					return new CodedElementFieldDefinition(); //.class;
				case "CE_TX": //CE_TX Text only CE data type
				case "TX":
					return new CodedElementTextOnlyFieldDefinition(); //.class;
				case "CQ": //CQ Composite Quantity with Units
					return new CompositeQuantityWithUnitsFieldDefinition(); //.class;
				case "CWE": //CWE Coded with Exceptions
					return new CodedWithExceptionsFieldDefinition(); //.class;
				case "CX": //CX Extended Composite Id with Check digit
					return new ExtendedCompositeIdWithCheckDigitFieldDefinition(); //.class;
				case "DT": //DT Date
					return new DateFieldDefinition(); //.class;
				case "DTM": //DTM Date/Time
					return new DateTimeFieldDefinition(); //.class;
				case "EI": //EI Entity Identifier
					return new EntityIdentifierFieldDefinition(); //.class;
				case "ERL": //ERL Error Location
					return new ErrorLocationFieldDefinition(); //.class;
				case "FN": //FN Family Name
					return new FamilyNameFieldDefinition(); //.class;
				case "FT": //FT Formatted text
					return new FormattedTextFieldDefinition(); //.class;
				case "HD": //HD Hierarchic Designator
					return new HierarchicDesignatorFieldDefinition(); //.class;
				case "ID": //ID Coded Values for HL7 Tables
					return new CodedValuesForHl7TablesFieldDefinition(); //.class;
				case "IS": //IS Coded value for User-Defined Tables
					return new CodedValuesForUserDefinedTablesFieldDefinition(); //.class;
				case "LA2": //LA2 Location with address variation 2
					return new LocationWithAddressVariation2FieldDefinition(); //.class;
				case "MSG": //MSG Message Type
					return new MessageTypeFieldDefinition(); //.class;
				case "NM": //NM Numeric
					return new NumericFieldDefinition(); //.class;
				case "PT": //PT Processing Type
					return new ProcessingTypeFieldDefinition(); //.class;
				case "SAD": //SAD Street Address
					return new StreetAddressFieldDefinition(); //.class;
				case "SI": //SI Sequence ID
					return new SequenceIdFieldDefinition(); //.class;
				case "CM":
				case "CNE":
				case "DLN": //driver's license number
				case "DR":
				case "EIP": //entity identifier parent?
				case "ELD":
				case "FC": //financial class
				case "JCC": //job class code
				case "PL": //patient location
				case "SRT": //sort by field
				case "TQ":
				case "ST": //ST String
					return new StringFieldDefinition(); //.class;
				case "TS": //TS Time Stamp
					return new TimestampFieldDefinition(); //.class;
				case "VID": //VID Version Identifier
					return new VersionIdFieldDefinition(); //.class;
				case "XAD": //XAD Extended Address
					return new ExtendedAddressFieldDefinition(); //.class;
				case "XCN": //XCN Extended Composite ID Number and Name for Persons
					return new ExtendedCompositeIdNumberAndNameForPersonsFieldDefinition(); //.class;
				case "XON": //XON Extended Name and Id Number for Organizations
					return new ExtendedCompositeIdNumberAndNameForOrganizationsFieldDefinition(); //.class;
				case "XPN": //XPN Extended Person Name
					return new ExtendedPersonNameFieldDefinition(); //.class;
				case "XTN": //XTN Extended telephone number
					return new ExtendedTelecommunicationNumberFieldDefinition(); //.class;
				case "DT_D": //DT_D Date with precision to day
				//	return new DateWithPrecisionToDayFieldDefinition(); //.class;
				case "TS_M": //TS_M Time Stamp with optional precision to the day and no time zone
				//	return new TimestampToMonthFieldDefinition(); //.class;
				case "TS_NZ": //TS_NZ Time Stamp with precision to the day and no time zone
				//	return new TimestampNoTimeZoneFieldDefinition(); //.class;
				case "TS_Z": //TS_Z Time Stamp requiring time zone
				//	return new TimestampWithTimeZoneFieldDefinition(); //.class;
				default:
					throw new Exception("Undefined data type \""+code+"\"");
			}
			//Class<? extends Hl7FieldDefinition> classType = Hl7FieldGenerator.getClassFromCode(code);
			//return classType.getDeclaredConstructor().newInstance();
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
}
