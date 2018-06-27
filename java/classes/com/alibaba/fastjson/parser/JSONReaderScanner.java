package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;

public final class JSONReaderScanner
  extends JSONLexerBase
{
  private static final ThreadLocal<char[]> BUF_LOCAL = new ThreadLocal();
  private char[] buf;
  private int bufLength;
  private Reader reader;
  
  public JSONReaderScanner(Reader paramReader)
  {
    this(paramReader, a.f);
  }
  
  public JSONReaderScanner(Reader paramReader, int paramInt)
  {
    super(paramInt);
    this.reader = paramReader;
    this.buf = ((char[])BUF_LOCAL.get());
    if (this.buf != null) {
      BUF_LOCAL.set(null);
    }
    if (this.buf == null) {
      this.buf = new char[' '];
    }
    try
    {
      this.bufLength = paramReader.read(this.buf);
      this.bp = -1;
      next();
      if (this.ch == 65279) {
        next();
      }
      return;
    }
    catch (IOException paramReader)
    {
      throw new d(paramReader.getMessage(), paramReader);
    }
  }
  
  public JSONReaderScanner(String paramString)
  {
    this(paramString, a.f);
  }
  
  public JSONReaderScanner(String paramString, int paramInt)
  {
    this(new StringReader(paramString), paramInt);
  }
  
  public JSONReaderScanner(char[] paramArrayOfChar, int paramInt)
  {
    this(paramArrayOfChar, paramInt, a.f);
  }
  
  public JSONReaderScanner(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this(new CharArrayReader(paramArrayOfChar, 0, paramInt1), paramInt2);
  }
  
  public final String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable)
  {
    return paramSymbolTable.addSymbol(this.buf, paramInt1, paramInt2, paramInt3);
  }
  
  protected final void arrayCopy(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.buf, paramInt1, paramArrayOfChar, paramInt2, paramInt3);
  }
  
  public byte[] bytesValue()
  {
    return IOUtils.decodeBase64(this.buf, this.np + 1, this.sp);
  }
  
  public final boolean charArrayCompare(char[] paramArrayOfChar)
  {
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      if (charAt(this.bp + i) != paramArrayOfChar[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final char charAt(int paramInt)
  {
    char c = '\032';
    int i = paramInt;
    char[] arrayOfChar;
    int j;
    if (paramInt >= this.bufLength)
    {
      if (this.bufLength == -1)
      {
        if (paramInt < this.sp) {
          c = this.buf[paramInt];
        }
        return c;
      }
      if (this.bp != 0) {
        break label144;
      }
      arrayOfChar = new char[this.buf.length * 3 / 2];
      System.arraycopy(this.buf, this.bp, arrayOfChar, 0, this.bufLength);
      i = arrayOfChar.length;
      j = this.bufLength;
    }
    for (;;)
    {
      try
      {
        this.bufLength = (this.reader.read(arrayOfChar, this.bufLength, i - j) + this.bufLength);
        this.buf = arrayOfChar;
        i = paramInt;
        return this.buf[i];
      }
      catch (IOException localIOException1)
      {
        throw new d(localIOException1.getMessage(), localIOException1);
      }
      label144:
      i = this.bufLength - this.bp;
      if (i > 0) {
        System.arraycopy(this.buf, this.bp, this.buf, 0, i);
      }
      try
      {
        this.bufLength = this.reader.read(this.buf, i, this.buf.length - i);
        if (this.bufLength == 0) {
          throw new d("illegal state, textLength is zero");
        }
      }
      catch (IOException localIOException2)
      {
        throw new d(localIOException2.getMessage(), localIOException2);
      }
      if (this.bufLength == -1) {
        break;
      }
      this.bufLength += i;
      i = paramInt - this.bp;
      this.np -= this.bp;
      this.bp = 0;
    }
  }
  
  public void close()
  {
    super.close();
    if (this.buf.length <= 32768) {
      BUF_LOCAL.set(this.buf);
    }
    this.buf = null;
    IOUtils.close(this.reader);
  }
  
  protected final void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    System.arraycopy(this.buf, paramInt1, paramArrayOfChar, 0, paramInt2);
  }
  
  public final BigDecimal decimalValue()
  {
    int j = this.np;
    int i = j;
    if (j == -1) {
      i = 0;
    }
    int m = charAt(this.sp + i - 1);
    int k = this.sp;
    if ((m != 76) && (m != 83) && (m != 66) && (m != 70))
    {
      j = k;
      if (m != 68) {}
    }
    else
    {
      j = k - 1;
    }
    return new BigDecimal(this.buf, i, j);
  }
  
  public final int indexOf(char paramChar, int paramInt)
  {
    paramInt -= this.bp;
    for (;;)
    {
      char c = charAt(this.bp + paramInt);
      if (paramChar == c) {
        return paramInt + this.bp;
      }
      if (c == '\032') {
        return -1;
      }
      paramInt += 1;
    }
  }
  
  public final boolean isBlankInput()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      char c = this.buf[i];
      boolean bool1;
      if (c == '\032')
      {
        this.token = 20;
        bool1 = true;
      }
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!isWhitespace(c));
      i += 1;
    }
  }
  
  public boolean isEOF()
  {
    return (this.bufLength == -1) || (this.bp == this.buf.length) || ((this.ch == '\032') && (this.bp + 1 == this.buf.length));
  }
  
  public final char next()
  {
    int j = this.bp + 1;
    this.bp = j;
    int i = j;
    if (j >= this.bufLength)
    {
      if (this.bufLength == -1) {
        return '\032';
      }
      if (this.sp > 0)
      {
        j = this.bufLength - this.sp;
        i = j;
        if (this.ch == '"') {
          i = j - 1;
        }
        System.arraycopy(this.buf, i, this.buf, 0, this.sp);
      }
      this.np = -1;
      j = this.sp;
      this.bp = j;
      try
      {
        int m = this.bp;
        int k = this.buf.length - m;
        i = k;
        if (k == 0)
        {
          char[] arrayOfChar = new char[this.buf.length * 2];
          System.arraycopy(this.buf, 0, arrayOfChar, 0, this.buf.length);
          this.buf = arrayOfChar;
          i = this.buf.length - m;
        }
        this.bufLength = this.reader.read(this.buf, this.bp, i);
        if (this.bufLength == 0) {
          throw new d("illegal stat, textLength is zero");
        }
      }
      catch (IOException localIOException)
      {
        throw new d(localIOException.getMessage(), localIOException);
      }
      if (this.bufLength == -1)
      {
        this.ch = '\032';
        return '\032';
      }
      this.bufLength += this.bp;
      i = j;
    }
    char c = this.buf[i];
    this.ch = c;
    return c;
  }
  
  public final String numberString()
  {
    int j = this.np;
    int i = j;
    if (j == -1) {
      i = 0;
    }
    int m = charAt(this.sp + i - 1);
    int k = this.sp;
    if ((m != 76) && (m != 83) && (m != 66) && (m != 70))
    {
      j = k;
      if (m != 68) {}
    }
    else
    {
      j = k - 1;
    }
    return new String(this.buf, i, j);
  }
  
  public final String stringVal()
  {
    if (!this.hasSpecial)
    {
      int i = this.np + 1;
      if (i < 0) {
        throw new IllegalStateException();
      }
      if (i > this.buf.length - this.sp) {
        throw new IllegalStateException();
      }
      return new String(this.buf, i, this.sp);
    }
    return new String(this.sbuf, 0, this.sp);
  }
  
  public final String subString(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      throw new StringIndexOutOfBoundsException(paramInt2);
    }
    return new String(this.buf, paramInt1, paramInt2);
  }
  
  public final char[] sub_chars(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      throw new StringIndexOutOfBoundsException(paramInt2);
    }
    if (paramInt1 == 0) {
      return this.buf;
    }
    char[] arrayOfChar = new char[paramInt2];
    System.arraycopy(this.buf, paramInt1, arrayOfChar, 0, paramInt2);
    return arrayOfChar;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/JSONReaderScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */