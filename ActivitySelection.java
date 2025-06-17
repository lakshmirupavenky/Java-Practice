import java.util.Arrays;
import java.util.Comparator;
class Activity {
    int start, end;
    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class ActivitySelection {
    public static void selectActivities(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));
        System.out.println("Selected activities:");
        int lastEnd = activities[0].end;
        System.out.println("(" + activities[0].start + ", " + activities[0].end + ")");
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastEnd) {
                System.out.println("(" + activities[i].start + ", " + activities[i].end + ")");
                lastEnd = activities[i].end;
            }
        }
	}
    public static void main(String[] args) {
        Activity[] activities = {
            new Activity(1, 3),
            new Activity(2, 4),
            new Activity(3, 5),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(8, 9),
            new Activity(5, 9)
        };
        selectActivities(activities);
    }
}
