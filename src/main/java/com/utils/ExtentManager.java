package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports report;

    public static ExtentReports getInstance(){
        if(report == null){
            ExtentSparkReporter spark = new ExtentSparkReporter(".//test-output//SparkReport//Extent.html");
            report = new ExtentReports();

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("fluege.de Test Report");
            spark.config().setEncoding("utf-8");
            spark.config().setReportName("fluege.de Test Report - Frontend");

            report.attachReporter(spark);
        }


        return report;
    }

}
