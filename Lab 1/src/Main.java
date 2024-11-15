public class Main {
    public static void main(String[] args)
    {
        float timeInSecs = 34311.031f;
        int hours = (int)timeInSecs/3600;
        int mins = (int)(timeInSecs/60)%60;
        int secs = (int)timeInSecs%60;
        int millisecs = (int)((timeInSecs%1f)*1000f);
        System.out.printf("%02d:%02d:%02d:%03d",hours,mins,secs,millisecs);
    }
}