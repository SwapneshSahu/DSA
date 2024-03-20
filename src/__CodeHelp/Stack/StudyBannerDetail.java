package __CodeHelp.Stack;

public class StudyBannerDetail {

	    private String header;
	    private String status;
	    private Long patientsCount;
	    private String description;
	    public enum StudyStatusEnum {
	    	CA_COMPLETED("CA Completed"),
	        CA_READY("CA Ready"),
	        CA_ASSIGNED("CA Assigned"),
	        CA_INPROGRESS("CA in Progress"),
	        VENDOR_QC_READY("V-QC Ready"),
	        VENDOR_QC_ASSIGNED("V-QC Assigned"),
	        VENDOR_QC_INPROGRESS("V-QC in Progress"),
	        ONTADA_QC_READY("O-QC Ready"),
	        ONTADA_QC_ASSIGNED("O-QC Assigned"),
	        ONTADA_QC_INPROGRESS("O-QC in Progress"),
	        COMPLETED("Completed");

	        private String label;

	        StudyStatusEnum(String label) {
	            this.label = label;
	        }

	        public String getLabel() {
	            return label;
	        }
	    }
	}
