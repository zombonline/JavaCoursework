import java.util.Arrays;

public class DynString {
    private char[] data;

    // Construct with no given size
    public DynString()
    {
        resizeData(0);
    }
    // Construct of given size
    public DynString(int len){
        resizeData(len);
    }
    public DynString(int len, char fill)
    {
        resizeData(len);
        Arrays.fill(data, fill);
    }
    // Construct using a string
    public DynString(String s)
    {
        resizeData(s.length());
        for(int i = 0; i < data.length; i++)
        {
            data[i] = s.charAt(i);
        }
    }
    public boolean empty()
    {
        return data.length ==0;
    }
    public char get(int index)
    {
        return data[index];
    }
    public void set(int index, char value)
    {
        data[index] = value;
    }
    public void clear()
    {
        data = new char[0];
    }
    public String substr(int startInclusive)
    {
        StringBuilder substr = new StringBuilder();
        for(int i = startInclusive; i < data.length; i++)
        {
            substr.append(data[i]);
        }
        return substr.toString();
    }
    public DynString concat(String s)
    {
        int originalSize = size();
        resize(originalSize+s.length());
        for(int i = originalSize, j = 0; i < data.length; i++, j++)
        {
            data[i] = s.charAt(j);
        }
        return this;
    }
    public DynString concat(DynString s)
    {
        int originalSize = size();
        resize(originalSize+s.size());
        for(int i = originalSize, j = 0; i < data.length; i++, j++)
        {
            data[i] = s.get(j);
        }
        return this;
    }
    public String substr(int startInclusive, int endExclusive)
    {
        StringBuilder substr = new StringBuilder();
        for(int i = startInclusive; i < endExclusive; i++)
        {
            substr.append(data[i]);
        }
        return substr.toString();
    }

    // Construct copying values from char array
    public DynString(char[] src){
        this(src.length);
        for(int i=0; i<size(); ++i){
            data[i] = src[i];
        }
    }

    // Get current size
    public int size(){
        return data.length;
    }
    //resize data; maintaining values
    public void resize(int len)
    {
        char[] newData = new char[len];
        for(int i = 0; i < newData.length && i < data.length; i++)
        {
            newData[i] = data[i];
        }
        data = newData;
    }

    // Resize internal array; zeroes all values
    private void resizeData(int n){
        data = new char[n];
    }

}