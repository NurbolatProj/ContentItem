import java.util.ArrayList;

public class ContentDemo {

    public static void main(String[] args) {

        ArrayList<ContentItem> list = new ArrayList<>();

        list.add(new VideoLecture("Java", 2024, 60, "HD"));
        list.add(new VideoLecture("OOP", 2022, 90, "4K"));

        list.add(new PodcastEpisode("Tech Talk", 2023, 40, "Alex"));
        list.add(new PodcastEpisode("Code Life", 2021, 30, "Maria"));

        int year = java.time.Year.now().getValue();

        for (ContentItem item : list) {
            System.out.println(item + " | cost=" + item.getLicenseCost(year));

            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println("Limit: " + d.getMaxDownloadsPerDay());
            }

            System.out.println();
        }
    }
}
