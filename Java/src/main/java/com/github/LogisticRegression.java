package com.github;

import org.apache.commons.csv.*;
import java.io.*;

public class LogisticRegression{
    private static final int DATA_SIZE = 150;

    private double lr;
    private double num_iter;
    private boolean fit_intercept;
    private boolean verbose;

    private double[][] X = new double[DATA_SIZE][2];
    private boolean[] y = new boolean[DATA_SIZE];

    public static void main (String [] args) throws FileNotFoundException, IOException {
        LogisticRegression model = new LogisticRegression(0.01, 300, true, false);
        model.readData();

        
    }

    public void readData () throws FileNotFoundException, IOException{
	    File file = new File(
            this.getClass()
                .getClassLoader()
                .getResource("com/github/data.csv")
                .getFile()
        );
        Reader in = new FileReader(file);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
        int i = 0;
        for (CSVRecord record : records) {
            X[i][0] = Double.parseDouble(record.get(0));
            X[i][1] = Double.parseDouble(record.get(1));
            y[i] = Boolean.parseBoolean(record.get(2));
            i++;
        }
    }

    LogisticRegression(double lr, int num_iter, boolean fit_intercept, boolean verbose){
        this.lr = lr;
        this.num_iter = num_iter;
        this.fit_intercept = fit_intercept;
        this.verbose = verbose;
    }

    public double add_intercept(double[][] X){
        double 
    }

    public double sigmoid (double z){
        return 1 / (1 + Math.exp(-z));
    }
 
    public double loss (double h, double y){
        return (-y * Math.log(h) - (1-y) * Math.log(1-h));
    }

    public void fit (double[][] X, boolean[] y){
        if (fit_intercept)

    }
}