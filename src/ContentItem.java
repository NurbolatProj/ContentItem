public abstract class ContentItem {

    protected int id;
    protected static int idGen = 1;

    protected String title;
    protected int year;
    protected int durationMinutes;

    public ContentItem(String title, int year, int durationMinutes) {
        id = idGen++;
        setTitle(title);
        setYear(year);
        setDurationMinutes(durationMinutes);
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Bad title");
        this.title = title;
    }

    public void setYear(int year) {
        int now = java.time.Year.now().getValue();
        if (year < 1990 || year > now)
            throw new IllegalArgumentException("Bad year");
        this.year = year;
    }

    public void setDurationMinutes(int d) {
        if (d <= 0)
            throw new IllegalArgumentException("Bad duration");
        durationMinutes = d;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double getLicenseCost(int currentYear);

    @Override
    public String toString() {
        return id + " | " + title + " | " + year + " | " + durationMinutes + " min";
    }
}
