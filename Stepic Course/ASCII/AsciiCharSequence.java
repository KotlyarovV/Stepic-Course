package ASCII;

public class AsciiCharSequence implements  java.lang.CharSequence {
  private  byte[] bytes;
  public AsciiCharSequence (byte[] bytes) {this.bytes = bytes;}

  public AsciiCharSequence subSequence (int a, int b) {
     if (a==b)
       return  new AsciiCharSequence(new byte[]{});
     if (a>b)
       throw new IndexOutOfBoundsException ();
     byte [] newBytes = new byte[b-a];
     for ( int i = 0; i < b-a; i++)
        newBytes[i] = this.bytes[a+i];
     return new AsciiCharSequence(newBytes);
  }

  public char charAt (int a) {return  (char)this.bytes[a];}

  public int length() {return bytes.length;}

  @Override
  public String toString ()
  {
      StringBuilder a = new StringBuilder();
      for (int i =0; i<bytes.length; i++)
          a = a.append(this.charAt(i));
      return a.toString();
  }
}