public class Main {
    public static void main(String[] args) {
        double nearestDistance = Double.MAX_VALUE;
        double approx = 0;
        for(double a = 0; a <=100000; a++)
        {
            for(double b = 1; b<=100000; b++)
            {
                double distance = Math.abs((a/b)-Math.PI);
                if(distance < nearestDistance)
                {
                    nearestDistance = distance;
                    approx = a/b;
                }
            }
        }
        int i = 1;
        while(i<100)
        {
            double approxToDp = Math.floor(approx*Math.pow(10,i));
            double piToDp = Math.floor(Math.PI*Math.pow(10,i));
            if(approxToDp != piToDp)
            {
                System.out.println("Accurate to " + (i-1) + " decimal places");
                break;
            }
            i++;
        }
        System.out.println(approx);

    }
}