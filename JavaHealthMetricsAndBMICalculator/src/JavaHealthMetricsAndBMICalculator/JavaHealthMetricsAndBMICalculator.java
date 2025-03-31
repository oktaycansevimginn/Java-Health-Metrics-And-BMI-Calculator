package JavaHealthMetricsAndBMICalculator;

import java.util.Scanner;

public class JavaHealthMetricsAndBMICalculator {
    static class HealthMetrics {
        private String nameSurname;
        private int ageInYears;
        private double bodyMass;
        private double heightInches;
        public static final double POUNDS_TO_KGS = 0.45359237;
        public static final double INCHES_TO_METERS = 0.0254;

        public HealthMetrics() {
            nameSurname = "Jane Doe";
            ageInYears = 30;
            bodyMass = 150;
            heightInches = 65;
        }

        public HealthMetrics(String nameSurname, int ageInYears, double bodyMass, double heightInches) {
            this.nameSurname = nameSurname;
            this.ageInYears = ageInYears;
            this.bodyMass = bodyMass;
            this.heightInches = heightInches;
        }

        public String getNameSurname() {
            return nameSurname;
        }

        public int getAgeInYears() {
            return ageInYears;
        }

        public double getBodyMass() {
            return bodyMass;
        }

        public double getHeightInches() {
            return heightInches;
        }

        public double calculateVKI() {
            double weightInKg = bodyMass * POUNDS_TO_KGS;
            double heightInMeters = heightInches * INCHES_TO_METERS;
            return Math.round(weightInKg / (heightInMeters * heightInMeters));
        }

        public String getVKIStatus() {
            double vki = calculateVKI();
            if (vki < 18.5)
                return "Underweight";
            else if (vki < 25.0)
                return "Normal";
            else if (vki < 30.0)
                return "Overweight";
            else
                return "Obese";
        }
    }

    public static void main(String[] args) {
        final int PEOPLE_COUNT = 3;
        HealthMetrics[] individuals = new HealthMetrics[PEOPLE_COUNT];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < PEOPLE_COUNT; i++) {
            System.out.println("---ENTER DETAILS FOR PERSON " + (i + 1) + "---");
            System.out.println("Please enter full name, age, weight, and height: (separated by spaces)");

            String inputData = input.nextLine();
            String[] dataParts = inputData.split(" ", 4);

            String nameSurname = dataParts[0] + " " + dataParts[1];
            int ageInYears = Integer.parseInt(dataParts[2]);
            String weightAndHeight = dataParts[3];
            String[] weightAndHeightParts = weightAndHeight.split(" ");

            double bodyMass = Double.parseDouble(weightAndHeightParts[0]);
            double heightInches = Double.parseDouble(weightAndHeightParts[1]);

            individuals[i] = new HealthMetrics(nameSurname, ageInYears, bodyMass, heightInches);
        }

        for (HealthMetrics person : individuals) {
            System.out.println("** The VKI result for " + person.getNameSurname() + 
                    " ( Age: " + person.getAgeInYears() + " Weight: " + person.getBodyMass() + 
                    " Height: " + person.getHeightInches() + ") is " + person.getVKIStatus());
        }

        input.close();
    }
}
