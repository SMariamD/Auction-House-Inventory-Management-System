import java.util.Comparator;

public class CollectibleComparators {

    // Sort by ID (ascending)
    public static class SortByID implements Comparator<Collectible> {
        @Override
        public int compare(Collectible c1, Collectible c2) {
            return c1.getUniqueIdentifier().compareTo(c2.getUniqueIdentifier());
        }
    }

    // Sort by Price (descending)
    public static class SortByPriceDescending implements Comparator<Collectible> {
        @Override
        public int compare(Collectible c1, Collectible c2) {
            return Double.compare(c2.getStartingPrice(), c1.getStartingPrice());
        }
    }

    // Sort by Year Estimate (ascending)
    public static class SortByYearEstimate implements Comparator<Collectible> {
        @Override
        public int compare(Collectible c1, Collectible c2) {
            return Integer.compare(c1.getYearEstimate().getLowYearEstimate(), c2.getYearEstimate().getLowYearEstimate());
        }
    }
}

