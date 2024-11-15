public class Main {

    public static void verify(boolean v, String msg) throws Exception {
        if(!v) throw new Exception(msg);
    }

    public static void main(String[] args) throws Exception {

        { // Check fields: only one char[]
            var fields = DynString.class.getDeclaredFields();
            verify(fields.length == 1, "more than one field");
            verify(fields[0].getType().getCanonicalName().equals("char[]"), "field is not char[]");
        }

//* Move this toggle comment down as you implement new features

        { // Default ctor
            var s = new DynString();
            verify(s.empty(), "default ctor: not empty");
        }

        { // String ctor and get/set
            var s = new DynString("xyz");
            verify(s.size() == 3, "copy ctor: wrong size");
            verify(s.get(0) == 'x', "get(0) wrong value");
            verify(s.get(1) == 'y', "get(1) wrong value");
            verify(s.get(2) == 'z', "get(2) wrong value");
            s.set(0, 'a');
            verify(s.get(0) == 'a', "set(0) incorrect mutation");
        }

        { // Fill ctor
            var s = new DynString(3, 'o');
            verify(s.size() == 3, "fill ctor: wrong size");
            for(int i=0; i<s.size(); ++i)
                verify(s.get(i) == 'o', "fill ctor: wrong value");
        }

        { // Resize and clear
            var s = new DynString("abcd");

            s.resize(2);
            verify(s.size() == 2, "resize down: wrong size");
            verify(s.get(0) == 'a', "resize down: wrong value at index 0");
            verify(s.get(1) == 'b', "resize down: wrong value at index 1");

            s.resize(4);
            verify(s.size() == 4, "resize up: wrong size");
            verify(s.get(2) == '\0', "resize up: wrong value at index 2");
            verify(s.get(3) == '\0', "resize up: wrong value at index 3");

            s.clear();
            verify(s.empty(), "clear did not empty");
        }

        { // equals
            var s = new DynString(4, 'o');
            verify( s.equals( "oooo"), "equals: wrong result");
            verify(!s.equals(  "ooo"), "equals: wrong result");
            verify(!s.equals("ooooo"), "equals: wrong result");
        }

        { // substr
            var s = new DynString("steal");

            var t = s.substr(1,4);
            verify(t.equals("tea"), "substr(int,int): wrong result");

            t = s.substr(1);
            verify(t.equals("teal"), "substr(int): wrong result");
        }

        { // concat
            var a = new DynString("Hello");
            var b = new DynString("World");
            var c = a.concat(" ").concat(b).concat("!");
            verify(c.equals("Hello World!"), "concat: wrong result");
        }

        System.out.println("Unit test passed");
//*/
    }

}

