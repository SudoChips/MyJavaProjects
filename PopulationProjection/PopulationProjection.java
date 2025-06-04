public class PopulationProjection {
    public static void main(String[] args) {
        int currentPopulation = 312032486;
        int secondsPerYear = 365 * 24 * 60 * 60;

        double birthsPerYear = secondsPerYear / 7.0;
        double deathsPerYear = secondsPerYear / 13.0;
        double immigrantsPerYear = secondsPerYear / 45.0;

        double netChangePerYear = birthsPerYear + immigrantsPerYear - deathsPerYear;

        for (int year = 1; year <= 5; year++) {
            int projectedPopulation = (int) (currentPopulation + year * netChangePerYear);
            System.out.println("Population after " + year + " year(s): " + projectedPopulation);
        }
    }
}

/*System.out.println("Population after 1 year: ");
System.out.println(312032486 + (365 * 24 * 60 * 60 / 7.0) - (365 * 24 * 60 * 60 / 13.0) + (365 * 24 * 60 * 60 / 45.0));

System.out.println("Population after 2 years: ");
System.out.println(312032486 + (2 * (365 * 24 * 60 * 60 / 7.0) - (365 * 24 * 60 * 60 / 13.0) + (365 * 24 * 60 * 60 / 45.0)));

System.out.println("Population after 3 years: ");
System.out.println(312032486 + (3 * (365 * 24 * 60 * 60 / 7.0) - (365 * 24 * 60 * 60 / 13.0) + (365 * 24 * 60 * 60 / 45.0)));

System.out.println("Population after 4 years: ");
System.out.println(312032486 + (4 * (365 * 24 * 60 * 60 / 7.0) - (365 * 24 * 60 * 60 / 13.0) + (365 * 24 * 60 * 60 / 45.0)));

System.out.println("Population after 5 years: ");
System.out.println(312032486 + (5 * (365 * 24 * 60 * 60 / 7.0) - (365 * 24 * 60 * 60 / 13.0) + (365 * 24 * 60 * 60 / 45.0)));
*/