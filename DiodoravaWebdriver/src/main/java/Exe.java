public class Exe {
    public static void main(String[] args) {
        String string = "Total available local SSD space 2x375 GB";
        String [] massivString = string.split("space",2);
        for (String m:massivString) {
            System.out.println(m);

        }

        }


}
