package __CodeHelp.String;

public enum PatientStudyStatus {
	TODO("To Do"),
    IN_CA("In CA"),
    IN_VENDOR_QC("In V-QC"),
    IN_ONTADA_QC("In O-QC"),
    CA_COMPLETED("CA Completed"),
    COMPLETED("Complete"),
    CA_ASSIGNED("CA Assigned"),
    CA_READY("CA READY"),
    AWAITING_DOCUMENTS("Awaiting Docu"),
	PARTIALLY_ASSIGNED("Partially Assigned"),
    VENDOR_QC_READY("V-QC Ready"),
    VENDOR_QC_ASSIGNED("V-QC Assigned"),
    VENDOR_QC_COMPLETED("V-QC Completed"),
    ONTADA_QC_READY("O-QC Ready"),
    ONTADA_QC_ASSIGNED("O-QC Assigned"),
    ONTADA_QC_COMPLETED("O-QC Completed"),
    VENDOR_QC_PROGRESS("V-QC in Prog"),
    ONTADA_QC_PROGRESS("O-QC in Prog");
    public final String label;

    PatientStudyStatus(String label) {
        this.label = label;
    }

    
    public String getJsonValue() {
        return this.name();
    }

    @Override
    public String toString() {
        return this.label;
    }
}