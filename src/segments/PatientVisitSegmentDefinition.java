package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class PatientVisitSegmentDefinition extends Hl7SegmentDefinition{

	public PatientVisitSegmentDefinition(){
		super();
	}

	protected void generateComponents() {
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("SI").withName("SetIdPid").length(4, 4).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("IS").withName("PatientClass").length(1, 1).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("PL").withName("AssignedPatientLocation").length(80, 80).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("AdmissionType").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("CX").withName("ReadmitNumber").length(20, 20).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("PL").withName("PriorPatientLocation").length(80, 80).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("XCN").withName("AttendingDoctor").length(60, 60).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("XCN").withName("ReferringDoctor").length(60, 60).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("XCN").withName("ConsultingDoctor").length(60, 60).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("HospitalService").length(3, 3).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("PL").withName("TemporaryLocation").length(80, 80).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("ReadmitTestIndicator").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("ReadmissionIndicator").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("AdmitSource").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("AmbulatoryStatus").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("VipIndicator").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("XCN").withName("AdmittingDoctor").length(60, 60).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("PatientType").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("CX").withName("VisitNumber").length(20, 20).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("ST").withName("FinancialClass").length(50,  50).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("ChargePriceIndicator").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("CourtesyCode").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("CreditRating").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("ContractCode").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("DT").withName("ContractEffectiveDate").length(8, 8).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("NM").withName("ContractAmount").length(12, 12).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("NM").withName("ContractPeriod").length(3, 3).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("InterestCode").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("TransferToBadDebtCode").length(1, 1).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("DT").withName("TransferToBadDebtDate").length(8, 8).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("BadDebtAgencyCode").length(10, 10).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("NM").withName("BadDebtTransferAmount").length(12, 12).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("NM").withName("BadDebtRecoveryAmount").length(12, 12).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("DeleteAccountIndicator").length(1, 1).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("DT").withName("DeleteAccountDate").length(8, 8).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("DischargeDisposition").length(3, 3).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("CM").withName("DischargedToLocation").length(25, 25).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("CE").withName("DietType").length(80, 80).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("ServicingFacility").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("BedStatus").length(1, 1).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("AccountStatus").length(2, 2).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("PL").withName("PendingLocation").length(80, 80).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("PL").withName("PendingTemporaryLocation").length(80, 80).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("TS").withName("AdmitDateTime").length(26, 26).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("TS").withName("DischargeDateTime").length(26, 26).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("NM").withName("CurrentPatientBalance").length(12, 12).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("NM").withName("TotalCharges").length(12, 12).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("NM").withName("TotalAdjustments").length(12, 12).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("NM").withName("TotalPayments").length(12, 12).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("CX").withName("AlternateVisitId").length(20, 20).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("IS").withName("VisitIndicator").length(1, 1).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("XCN").withName("OtherHealthcareProvider").length(60, 60).cardinality(0, 0).unsupported()
		};
	}

	public String getSegmentType(){
		return "PV1";
	}

}
