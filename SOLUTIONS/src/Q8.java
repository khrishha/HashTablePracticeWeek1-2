public class Q8 {
    private String[] spots = new String[500];

    private int hash(String license) {
        return Math.abs(license.hashCode() % 500);
    }

    public void park(String license) {
        int index = hash(license);
        while (spots[index] != null) {
            index = (index + 1) % 500;
        }
        spots[index] = license;
        System.out.println("Parked " + license + " at " + index);
    }

    public static void main(String[] args) {
        Q8 lot = new Q8();
        lot.park("XYZ-123");
    }
}