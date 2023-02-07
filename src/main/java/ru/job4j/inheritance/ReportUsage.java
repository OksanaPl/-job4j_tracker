package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        JSONReport jreport = new JSONReport();
        String newtext = jreport.generate("name", "body");
        System.out.println(newtext);
    }
}
