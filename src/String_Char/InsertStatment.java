package String_Char;

public class InsertStatment {

	public static void main(String[] args) {
		String typesStr ="Biopsy, Bone Marrow Biopsy, Bone Marrow Biopsy Pathology, FISH, Imaging Guided Biopsy, Inpatient Surgery, Liquid Biopsy, Operative Notes, Pathology Report, Surgery, Surgery and Pathology, Surgical Report";
		
		String[] typeList = typesStr.split(", ");
		int count =208;
		for(String type : typeList) {
			System.out.println( "(" +count++ + ",'Surgery and Pathology'," + "'" +type +"'),"  );
		}
		System.out.println(count);
	}
}

