package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {

            List<TaxPayer> taxPayers = new ArrayList<>();

            System.out.print("Enter the number of tax payers: ");
            int n = sc.nextInt();
            sc.nextLine();
            System.out.println();

            for (int i = 0; i < n; i++) {
                System.out.printf("Tax payer #%d data:%n", i + 1);
                System.out.print("Individual or company (i/c)? ");
                char option = sc.nextLine().charAt(0);
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Anual income: ");
                double anualIncome = sc.nextDouble();
                sc.nextLine();

                if (option == 'i'){
                    System.out.print("Health expenditures: ");
                    double healthExpenditures = sc.nextDouble();
                    sc.nextLine();

                    taxPayers.add(new Individual(name, anualIncome, healthExpenditures));
                }else {
                    System.out.print("Number of employees: ");
                    int numberEmp = sc.nextInt();
                    sc.nextLine();

                    taxPayers.add(new Company(name, anualIncome, numberEmp));
                }
                System.out.println();
            }

            System.out.println("TAXES PAID:");
            for (TaxPayer taxPayer : taxPayers) {
                double tax = taxPayer.tax();
                System.out.println(taxPayer.getName()
                        + " $ "
                        + String.format("%.2f", tax));
            }

            System.out.println();
            double sum = 0;
            for (TaxPayer taxPayer : taxPayers) {
                sum += taxPayer.tax();
            }

            System.out.printf("Total Taxes: $ %.2f%n", sum);
        }
    }
}
