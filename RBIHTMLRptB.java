import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RBIHTMLRptB extends RBITextRpt {

	public RBIHTMLRptB(String dataFile, String reportFile) {
		super(dataFile, reportFile);
		// TODO Auto-generated constructor stub
	}

	public void generateReport(ArrayList <DataPair> data){
		try{
			FileWriter output = new FileWriter(m_reportFile);
			BufferedWriter bufferedWriter =
	                new BufferedWriter(output);
			bufferedWriter.write("<html>");
			bufferedWriter.newLine();
			bufferedWriter.write("<body>");
			bufferedWriter.newLine();
			bufferedWriter.write("<table>");
		for (DataPair a : data) {
			bufferedWriter.write("<tr><td>" + a.getName() + "</td><td>" + a.getStat()+ "</td><tr>");
			bufferedWriter.newLine();
			}
			bufferedWriter.close();
		}
		catch(IOException ex){
			System.out.println("Error with file");
		}
	}
	

}
