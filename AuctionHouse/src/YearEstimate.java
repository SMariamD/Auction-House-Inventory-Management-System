public class YearEstimate {
    private int lowYearEstimate;
    private int highYearEstimate;

    public YearEstimate(int lowYearEstimate, Integer highYearEstimate) {
        // Ensure values are within a realistic range, assuming no dates before 0 AD
        if (lowYearEstimate < 0) {
            throw new IllegalArgumentException("Low year estimate cannot be negative.");
        }

        this.lowYearEstimate = lowYearEstimate;
        // If highYearEstimate is null or the same as lowYearEstimate, set both to lowYearEstimate
        if (highYearEstimate == null || highYearEstimate < lowYearEstimate) {
            this.highYearEstimate = lowYearEstimate;
        } else {
            this.highYearEstimate = highYearEstimate;
        }
    }

    public int getLowYearEstimate() {
        return lowYearEstimate;
    }

    public int getHighYearEstimate() {
        return highYearEstimate;
    }

    // Compute middleYearEstimate dynamically to always reflect current values
    public int getMiddleYearEstimate() {
        return Math.round((lowYearEstimate + highYearEstimate) / 2.0f);
    }

    public int getYearDifference() {
        return highYearEstimate - lowYearEstimate;
    }

    public String getYearEstimateString() {
        return lowYearEstimate + " - " + highYearEstimate;
    }

    public String getMiddleYearEstimateString() {
        return String.valueOf(getMiddleYearEstimate());
    }

    public boolean isValid() {
        // Check for any additional conditions beyond low <= high
        return lowYearEstimate <= highYearEstimate && lowYearEstimate >= 0;
    }

    public void setLowYearEstimate(int lowYearEstimate) {
        if (lowYearEstimate < 0) {
            throw new IllegalArgumentException("Low year estimate cannot be negative.");
        }
        this.lowYearEstimate = lowYearEstimate;
    }

    public void setHighYearEstimate(int highYearEstimate) {
        if (highYearEstimate < lowYearEstimate) {
            throw new IllegalArgumentException("High year estimate cannot be less than low year estimate.");
        }
        this.highYearEstimate = highYearEstimate;
    }


    @Override
    public String toString() {
        return String.format("Year Estimate: %d - %d (Middle Estimate: %d)",
                lowYearEstimate, highYearEstimate, getMiddleYearEstimate());
    }
}


