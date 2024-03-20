package Z_Practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JBATMapping {
	
	
	public static void main(String[] args) { //"C:/Users/Swapnesh/Downloads/NewDocType3.18.24Final.xlsx"
        String csvFile = "C:/Users/Swapnesh/Downloads/NewDocType3.18.24Final.xlsx";  // Update this with the path to your CSV file
        List<List<String>> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                List<String> row = new ArrayList<>();
                for (String datum : data) {
                    row.add(datum.trim()); // Trim to remove leading/trailing whitespace
                }
                rows.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the rows
        for (List<String> row : rows) {
            System.out.println(row);
        }
    }

//	public static void main(String[] args) {
//	String str = "Molecular Results, Demo-Contact ROI, OH Forever Bare Consent Form, OH SkinTyte Consent Form, OH BBL Forever Clear Consent Form, OH Hydrafacial Consent Form, OH Botox/Xeomin-Treatment Chart, OH Moxi Consent Form, OH Procell Hair Consent, OH BBL Forever Body Treatment Chart, OH BBL Forever Body Post Care Instructions, OH Halo Non Ablative Consent Form, Detox Food Plan, OH HOCATT Consent, OH HPC Commitment Pledge, OH Aesthetics Intake Form, Injection Documentation: Gardasil, OH Visia Scan, OH Weight Loss Fee Acknowledgement, OH Weight Loss Initial Success Session, OH Weight Loss Consent, OH Juvaderm - Consent From, Optimum Aesthetics Intake, OH Vitruvian Man, OH Emsella Consent, OH Emsella Treatment Record, Core Food Plan, Goal Setting Session, OH HPC Membership Contract, OH HOCATT Treatment Record, Cardiometabolic Food Plan, OH Emsella Intake, Injection Documentation: DEPO, OH SkinVive Consent, OH Demographics, OH Halo Treatment Chart, OH HPC Liability Form, Consents - Ontada, OH Laser Client Intake Form, OH BBL Forever Young Consent Form, OH BBL Forever Body Consent Form, OH BBL Medical History, OH Hydrafacial Consult Form, OH Hydrafacial Treatment Log, OH Botox/Xeomin - Consent Form, OH Stem Cell Injection Consent, OH Procell Face/Body Consent, OH Forever Bare Treatment Chart, OH SkinTyte Treatment Chart, OH BBL Forever Bare Post Care Instructions, OH BBL Forever Young Treatment Chart, BBL Forever Young Post Care Instructions, OH BBL Forever Clear Treatment Chart, Clinical Patient Photos, blood transfusion 2, Canopy-Triage, Canopy-Other, Canopy-Consent, NEW PATIENT RECORDS {BULK SCAN}, Advance care planning – Advanced directive (scanned), Pharmacy Note Financial, EOM Patient-Focused Services, Pharmacy Note - Financial, Tx plan, NCCN Distress Screening, Patient Health Questionnaire PHQ2/PHQ9, Follow Up, Referral Outbound, Coding, Surgery Prior Authorizations, Consent – Foundation, CANCER CLAIMS, Ocular Assessment, CT/Sono/US//MR-Guided Biopsy,Portal Consent, Marijuana registry form, Patient assistance form (PAF), Patient Education Acknowledgement, a-Carequality External, CareQuality, Outside imaging reports, Radiation Oncology Progress notes, Dermatology Dictation, **Dermatology Image**, Legacy Referral Documents, Treatment Log"
//;
//	
//	String [] list  = str.split(",");
//	
//	System.out.println("(");
//     for (String ss : list) {
//    	 
//    	 System.out.println("'"+ ss.trim() + "',");
//     }
//     System.out.println(")");
//     
//	}

}
