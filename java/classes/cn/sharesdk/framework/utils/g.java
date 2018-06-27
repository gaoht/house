package cn.sharesdk.framework.utils;

import java.io.IOException;

public abstract class g
  implements Escaper
{
  private static final char[] a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0) {
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt1);
    }
    return arrayOfChar;
  }
  
  protected static final int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      int i = paramCharSequence.charAt(paramInt1);
      paramInt1 += 1;
      if ((i < 55296) || (i > 57343)) {
        return i;
      }
      if (i <= 56319)
      {
        if (paramInt1 == paramInt2) {
          return -i;
        }
        char c = paramCharSequence.charAt(paramInt1);
        if (Character.isLowSurrogate(c)) {
          return Character.toCodePoint(i, c);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + c + "' with value " + c + " at index " + paramInt1);
      }
      throw new IllegalArgumentException("Unexpected low surrogate character '" + i + "' with value " + i + " at index " + (paramInt1 - 1));
    }
    throw new IndexOutOfBoundsException("Index exceeds specified range");
  }
  
  protected int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      i = b(paramCharSequence, paramInt1, paramInt2);
      if ((i >= 0) && (a(i) == null)) {}
    }
    else
    {
      return paramInt1;
    }
    if (Character.isSupplementaryCodePoint(i)) {}
    for (int i = 2;; i = 1)
    {
      paramInt1 += i;
      break;
    }
  }
  
  protected final String a(String paramString, int paramInt)
  {
    int n = paramString.length();
    Object localObject1 = (char[])new a(null).get();
    int m = 0;
    int i = 0;
    int k = paramInt;
    paramInt = i;
    if (k < n)
    {
      int i1 = b(paramString, k, n);
      if (i1 < 0) {
        throw new IllegalArgumentException("Trailing high surrogate at end of input");
      }
      char[] arrayOfChar = a(i1);
      i = paramInt;
      Object localObject3 = localObject1;
      if (arrayOfChar != null)
      {
        i = k - m;
        j = paramInt + i + arrayOfChar.length;
        localObject2 = localObject1;
        if (localObject1.length < j) {
          localObject2 = a((char[])localObject1, paramInt, j + (n - k) + 32);
        }
        j = paramInt;
        if (i > 0)
        {
          paramString.getChars(m, k, (char[])localObject2, paramInt);
          j = paramInt + i;
        }
        i = j;
        localObject3 = localObject2;
        if (arrayOfChar.length > 0)
        {
          System.arraycopy(arrayOfChar, 0, localObject2, j, arrayOfChar.length);
          i = j + arrayOfChar.length;
          localObject3 = localObject2;
        }
      }
      if (Character.isSupplementaryCodePoint(i1)) {}
      for (paramInt = 2;; paramInt = 1)
      {
        m = paramInt + k;
        k = a(paramString, m, n);
        paramInt = i;
        localObject1 = localObject3;
        break;
      }
    }
    int j = n - m;
    i = paramInt;
    Object localObject2 = localObject1;
    if (j > 0)
    {
      i = j + paramInt;
      localObject2 = localObject1;
      if (localObject1.length < i) {
        localObject2 = a((char[])localObject1, paramInt, i);
      }
      paramString.getChars(m, n, (char[])localObject2, paramInt);
    }
    return new String((char[])localObject2, 0, i);
  }
  
  protected abstract char[] a(int paramInt);
  
  public Appendable escape(final Appendable paramAppendable)
  {
    c.a(paramAppendable);
    new Appendable()
    {
      int a = -1;
      char[] b = new char[2];
      
      private void a(char[] paramAnonymousArrayOfChar, int paramAnonymousInt)
        throws IOException
      {
        int i = 0;
        while (i < paramAnonymousInt)
        {
          paramAppendable.append(paramAnonymousArrayOfChar[i]);
          i += 1;
        }
      }
      
      public Appendable append(char paramAnonymousChar)
        throws IOException
      {
        if (this.a != -1)
        {
          if (!Character.isLowSurrogate(paramAnonymousChar)) {
            throw new IllegalArgumentException("Expected low surrogate character but got '" + paramAnonymousChar + "' with value " + paramAnonymousChar);
          }
          arrayOfChar = g.this.a(Character.toCodePoint((char)this.a, paramAnonymousChar));
          if (arrayOfChar != null) {
            a(arrayOfChar, arrayOfChar.length);
          }
          for (;;)
          {
            this.a = -1;
            return this;
            paramAppendable.append((char)this.a);
            paramAppendable.append(paramAnonymousChar);
          }
        }
        if (Character.isHighSurrogate(paramAnonymousChar))
        {
          this.a = paramAnonymousChar;
          return this;
        }
        if (Character.isLowSurrogate(paramAnonymousChar)) {
          throw new IllegalArgumentException("Unexpected low surrogate character '" + paramAnonymousChar + "' with value " + paramAnonymousChar);
        }
        char[] arrayOfChar = g.this.a(paramAnonymousChar);
        if (arrayOfChar != null)
        {
          a(arrayOfChar, arrayOfChar.length);
          return this;
        }
        paramAppendable.append(paramAnonymousChar);
        return this;
      }
      
      public Appendable append(CharSequence paramAnonymousCharSequence)
        throws IOException
      {
        return append(paramAnonymousCharSequence, 0, paramAnonymousCharSequence.length());
      }
      
      public Appendable append(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        int i;
        char[] arrayOfChar;
        if (paramAnonymousInt1 < paramAnonymousInt2)
        {
          if (this.a == -1) {
            break label257;
          }
          char c1 = paramAnonymousCharSequence.charAt(paramAnonymousInt1);
          i = paramAnonymousInt1 + 1;
          if (!Character.isLowSurrogate(c1)) {
            throw new IllegalArgumentException("Expected low surrogate character but got " + c1);
          }
          arrayOfChar = g.this.a(Character.toCodePoint((char)this.a, c1));
          if (arrayOfChar == null) {
            break label146;
          }
          a(arrayOfChar, arrayOfChar.length);
          paramAnonymousInt1 += 1;
          this.a = -1;
        }
        for (;;)
        {
          i = g.this.a(paramAnonymousCharSequence, i, paramAnonymousInt2);
          if (i > paramAnonymousInt1) {
            paramAppendable.append(paramAnonymousCharSequence, paramAnonymousInt1, i);
          }
          if (i == paramAnonymousInt2)
          {
            return this;
            label146:
            paramAppendable.append((char)this.a);
            break;
          }
          paramAnonymousInt1 = g.b(paramAnonymousCharSequence, i, paramAnonymousInt2);
          if (paramAnonymousInt1 < 0)
          {
            this.a = (-paramAnonymousInt1);
            return this;
          }
          arrayOfChar = g.this.a(paramAnonymousInt1);
          if (arrayOfChar != null)
          {
            a(arrayOfChar, arrayOfChar.length);
            label208:
            if (!Character.isSupplementaryCodePoint(paramAnonymousInt1)) {
              break label252;
            }
          }
          label252:
          for (paramAnonymousInt1 = 2;; paramAnonymousInt1 = 1)
          {
            paramAnonymousInt1 = i + paramAnonymousInt1;
            i = paramAnonymousInt1;
            break;
            int j = Character.toChars(paramAnonymousInt1, this.b, 0);
            a(this.b, j);
            break label208;
          }
          label257:
          i = paramAnonymousInt1;
        }
      }
    };
  }
  
  public String escape(String paramString)
  {
    int i = paramString.length();
    int j = a(paramString, 0, i);
    if (j == i) {
      return paramString;
    }
    return a(paramString, j);
  }
  
  private static final class a
    extends ThreadLocal<char[]>
  {
    protected char[] a()
    {
      return new char['Ѐ'];
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/utils/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */