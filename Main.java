import java.util.*;
import java.io.*;

public class Main {
	//main class that initiates the go method
	public static void main(String args[]) throws IOException {
		new Main().go();
	}

	//go method that creates a list of reports with proper arguments
	public void go() throws IOException {
		ArrayList<HomeRunTextRpt> reports = new ArrayList<HomeRunTextRpt>();
		reports.add(new HomeRunTextRpt("players.txt", "r1.txt"));
		//.txt can be replaced with .html to produce the html version
		reports.add(new HomeRunHTMLRpt("players.txt", "r2.txt"));
		reports.add(new RBITextRpt("players.txt", "r3.txt"));
		reports.add(new RBIHTMLRptA("players.txt", "r4.txt"));
		reports.add(new RBIHTMLRptB("players.txt", "r5.txt"));
		//passes the list of reports for printing
		makeReports(reports);
	}

	private void makeReports(ArrayList<HomeRunTextRpt> reports) throws IOException {
		//for each report load data then report
		for (HomeRunTextRpt rpt : reports) {
			ArrayList<DataPair> data = rpt.loadData();
			rpt.generateReport(data);
		}
	}
}