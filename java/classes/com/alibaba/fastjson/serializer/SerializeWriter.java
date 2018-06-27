package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;

public final class SerializeWriter
  extends Writer
{
  private static final ThreadLocal<char[]> bufLocal = new ThreadLocal();
  private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal();
  static final int nonDirectFeautres = SerializerFeature.UseSingleQuotes.mask | 0x0 | SerializerFeature.BrowserSecure.mask | SerializerFeature.BrowserCompatible.mask | SerializerFeature.PrettyFormat.mask | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.WriteNonStringValueAsString.mask | SerializerFeature.WriteSlashAsSpecial.mask | SerializerFeature.IgnoreErrorGetter.mask | SerializerFeature.WriteClassName.mask | SerializerFeature.NotWriteDefaultValue.mask;
  protected boolean beanToArray;
  protected char[] buf;
  protected int count;
  protected boolean disableCircularReferenceDetect;
  protected int features;
  protected char keySeperator;
  protected boolean notWriteDefaultValue;
  protected boolean quoteFieldNames;
  protected boolean sortField;
  protected boolean useSingleQuotes;
  protected boolean writeDirect;
  protected boolean writeEnumUsingName;
  protected boolean writeEnumUsingToString;
  protected boolean writeNonStringValueAsString;
  private final Writer writer;
  
  public SerializeWriter()
  {
    this((Writer)null);
  }
  
  public SerializeWriter(int paramInt)
  {
    this(null, paramInt);
  }
  
  public SerializeWriter(Writer paramWriter)
  {
    this(paramWriter, a.g, SerializerFeature.EMPTY);
  }
  
  public SerializeWriter(Writer paramWriter, int paramInt)
  {
    this.writer = paramWriter;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Negative initial size: " + paramInt);
    }
    this.buf = new char[paramInt];
  }
  
  public SerializeWriter(Writer paramWriter, int paramInt, SerializerFeature... paramVarArgs)
  {
    this.writer = paramWriter;
    this.buf = ((char[])bufLocal.get());
    if (this.buf != null) {
      bufLocal.set(null);
    }
    int i;
    for (;;)
    {
      int k = paramVarArgs.length;
      int j = 0;
      i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        i |= paramVarArgs[paramInt].getMask();
        paramInt += 1;
      }
      this.buf = new char['ࠀ'];
    }
    this.features = i;
    computeFeatures();
  }
  
  public SerializeWriter(Writer paramWriter, SerializerFeature... paramVarArgs)
  {
    this(paramWriter, 0, paramVarArgs);
  }
  
  public SerializeWriter(SerializerFeature... paramVarArgs)
  {
    this(null, paramVarArgs);
  }
  
  private int encodeToUTF8(OutputStream paramOutputStream)
    throws IOException
  {
    int i = (int)(this.count * 3.0D);
    Object localObject2 = (byte[])bytesBufLocal.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new byte[' '];
      bytesBufLocal.set(localObject1);
    }
    localObject2 = localObject1;
    if (localObject1.length < i) {
      localObject2 = new byte[i];
    }
    i = IOUtils.encodeUTF8(this.buf, 0, this.count, (byte[])localObject2);
    paramOutputStream.write((byte[])localObject2, 0, i);
    return i;
  }
  
  private byte[] encodeToUTF8Bytes()
  {
    int i = (int)(this.count * 3.0D);
    Object localObject2 = (byte[])bytesBufLocal.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new byte[' '];
      bytesBufLocal.set(localObject1);
    }
    localObject2 = localObject1;
    if (localObject1.length < i) {
      localObject2 = new byte[i];
    }
    i = IOUtils.encodeUTF8(this.buf, 0, this.count, (byte[])localObject2);
    localObject1 = new byte[i];
    System.arraycopy(localObject2, 0, localObject1, 0, i);
    return (byte[])localObject1;
  }
  
  static boolean isSpecial(char paramChar, int paramInt)
  {
    boolean bool = true;
    if (paramChar == ' ') {}
    do
    {
      return false;
      if (paramChar == '/')
      {
        if ((SerializerFeature.WriteSlashAsSpecial.mask & paramInt) != 0) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    } while (((paramChar > '#') && (paramChar != '\\')) || ((paramChar > '\037') && (paramChar != '\\') && (paramChar != '"')));
    return true;
  }
  
  private void writeEnumFieldValue(char paramChar, String paramString1, String paramString2)
  {
    if (this.useSingleQuotes)
    {
      writeFieldValue(paramChar, paramString1, paramString2);
      return;
    }
    writeFieldValueStringWithDoubleQuote(paramChar, paramString1, paramString2);
  }
  
  private void writeKeyWithSingleQuoteIfHasSpecial(String paramString)
  {
    byte[] arrayOfByte = IOUtils.specicalFlags_singleQuotes;
    int k = paramString.length();
    int i3 = this.count + k + 1;
    int j;
    if (i3 > this.buf.length) {
      if (this.writer != null)
      {
        if (k == 0)
        {
          write(39);
          write(39);
          write(58);
          return;
        }
        i = 0;
        if (i >= k) {
          break label647;
        }
        j = paramString.charAt(i);
        if ((j >= arrayOfByte.length) || (arrayOfByte[j] == 0)) {}
      }
    }
    label105:
    label545:
    label647:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        write(39);
      }
      j = 0;
      int m;
      if (j < k)
      {
        m = paramString.charAt(j);
        if ((m < arrayOfByte.length) && (arrayOfByte[m] != 0))
        {
          write(92);
          write(IOUtils.replaceChars[m]);
        }
        for (;;)
        {
          j += 1;
          break label105;
          i += 1;
          break;
          write(m);
        }
      }
      if (i != 0) {
        write(39);
      }
      write(58);
      return;
      expandCapacity(i3);
      if (k == 0)
      {
        if (this.count + 3 > this.buf.length) {
          expandCapacity(this.count + 3);
        }
        paramString = this.buf;
        i = this.count;
        this.count = (i + 1);
        paramString[i] = 39;
        paramString = this.buf;
        i = this.count;
        this.count = (i + 1);
        paramString[i] = 39;
        paramString = this.buf;
        i = this.count;
        this.count = (i + 1);
        paramString[i] = 58;
        return;
      }
      int i4 = this.count;
      int n = i4 + k;
      paramString.getChars(0, k, this.buf, i4);
      this.count = i3;
      int i1 = 0;
      k = i4;
      if (k < n)
      {
        int i5 = this.buf[k];
        m = k;
        int i2 = i1;
        i = n;
        j = i3;
        if (i5 < arrayOfByte.length)
        {
          m = k;
          i2 = i1;
          i = n;
          j = i3;
          if (arrayOfByte[i5] != 0)
          {
            if (i1 != 0) {
              break label545;
            }
            j = i3 + 3;
            if (j > this.buf.length) {
              expandCapacity(j);
            }
            this.count = j;
            System.arraycopy(this.buf, k + 1, this.buf, k + 3, n - k - 1);
            System.arraycopy(this.buf, 0, this.buf, 1, k);
            this.buf[i4] = '\'';
            paramString = this.buf;
            i = k + 1;
            paramString[i] = 92;
            paramString = this.buf;
            m = i + 1;
            paramString[m] = IOUtils.replaceChars[i5];
            i = n + 2;
            this.buf[(this.count - 2)] = '\'';
          }
        }
        for (i2 = 1;; i2 = i1)
        {
          k = m + 1;
          i1 = i2;
          n = i;
          i3 = j;
          break;
          j = i3 + 1;
          if (j > this.buf.length) {
            expandCapacity(j);
          }
          this.count = j;
          System.arraycopy(this.buf, k + 1, this.buf, k + 2, n - k);
          this.buf[k] = '\\';
          paramString = this.buf;
          m = k + 1;
          paramString[m] = IOUtils.replaceChars[i5];
          i = n + 1;
        }
      }
      this.buf[(i3 - 1)] = ':';
      return;
    }
  }
  
  public SerializeWriter append(char paramChar)
  {
    write(paramChar);
    return this;
  }
  
  public SerializeWriter append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (paramCharSequence = "null";; paramCharSequence = paramCharSequence.toString())
    {
      write(paramCharSequence, 0, paramCharSequence.length());
      return this;
    }
  }
  
  public SerializeWriter append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "null";
    }
    paramCharSequence = ((CharSequence)localObject).subSequence(paramInt1, paramInt2).toString();
    write(paramCharSequence, 0, paramCharSequence.length());
    return this;
  }
  
  public void close()
  {
    if ((this.writer != null) && (this.count > 0)) {
      flush();
    }
    if (this.buf.length <= 65536) {
      bufLocal.set(this.buf);
    }
    this.buf = null;
  }
  
  protected void computeFeatures()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.features & SerializerFeature.QuoteFieldNames.mask) != 0)
    {
      bool1 = true;
      this.quoteFieldNames = bool1;
      if ((this.features & SerializerFeature.UseSingleQuotes.mask) == 0) {
        break label253;
      }
      bool1 = true;
      label39:
      this.useSingleQuotes = bool1;
      if ((this.features & SerializerFeature.SortField.mask) == 0) {
        break label258;
      }
      bool1 = true;
      label60:
      this.sortField = bool1;
      if ((this.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
        break label263;
      }
      bool1 = true;
      label81:
      this.disableCircularReferenceDetect = bool1;
      if ((this.features & SerializerFeature.BeanToArray.mask) == 0) {
        break label268;
      }
      bool1 = true;
      label102:
      this.beanToArray = bool1;
      if ((this.features & SerializerFeature.WriteNonStringValueAsString.mask) == 0) {
        break label273;
      }
      bool1 = true;
      label123:
      this.writeNonStringValueAsString = bool1;
      if ((this.features & SerializerFeature.NotWriteDefaultValue.mask) == 0) {
        break label278;
      }
      bool1 = true;
      label144:
      this.notWriteDefaultValue = bool1;
      if ((this.features & SerializerFeature.WriteEnumUsingName.mask) == 0) {
        break label283;
      }
      bool1 = true;
      label165:
      this.writeEnumUsingName = bool1;
      if ((this.features & SerializerFeature.WriteEnumUsingToString.mask) == 0) {
        break label288;
      }
      bool1 = true;
      label186:
      this.writeEnumUsingToString = bool1;
      if ((!this.quoteFieldNames) || ((this.features & nonDirectFeautres) != 0)) {
        break label293;
      }
      bool1 = bool2;
      if (!this.beanToArray)
      {
        if (!this.writeEnumUsingName) {
          break label293;
        }
        bool1 = bool2;
      }
      label227:
      this.writeDirect = bool1;
      if (!this.useSingleQuotes) {
        break label298;
      }
    }
    label253:
    label258:
    label263:
    label268:
    label273:
    label278:
    label283:
    label288:
    label293:
    label298:
    for (char c = '\'';; c = '"')
    {
      this.keySeperator = c;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label39;
      bool1 = false;
      break label60;
      bool1 = false;
      break label81;
      bool1 = false;
      break label102;
      bool1 = false;
      break label123;
      bool1 = false;
      break label144;
      bool1 = false;
      break label165;
      bool1 = false;
      break label186;
      bool1 = false;
      break label227;
    }
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.features |= paramSerializerFeature.getMask();
      if (paramSerializerFeature == SerializerFeature.WriteEnumUsingToString) {
        this.features &= (SerializerFeature.WriteEnumUsingName.getMask() ^ 0xFFFFFFFF);
      }
    }
    for (;;)
    {
      computeFeatures();
      return;
      if (paramSerializerFeature == SerializerFeature.WriteEnumUsingName)
      {
        this.features &= (SerializerFeature.WriteEnumUsingToString.getMask() ^ 0xFFFFFFFF);
        continue;
        this.features &= (paramSerializerFeature.getMask() ^ 0xFFFFFFFF);
      }
    }
  }
  
  public void expandCapacity(int paramInt)
  {
    int i = this.buf.length * 3 / 2 + 1;
    if (i < paramInt) {}
    for (;;)
    {
      char[] arrayOfChar = new char[paramInt];
      System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
      this.buf = arrayOfChar;
      return;
      paramInt = i;
    }
  }
  
  public void flush()
  {
    if (this.writer == null) {
      return;
    }
    try
    {
      this.writer.write(this.buf, 0, this.count);
      this.writer.flush();
      this.count = 0;
      return;
    }
    catch (IOException localIOException)
    {
      throw new d(localIOException.getMessage(), localIOException);
    }
  }
  
  public int getBufferLength()
  {
    return this.buf.length;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return (this.features & paramInt) != 0;
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature)
  {
    return (this.features & paramSerializerFeature.mask) != 0;
  }
  
  public boolean isNotWriteDefaultValue()
  {
    return this.notWriteDefaultValue;
  }
  
  public boolean isSortField()
  {
    return this.sortField;
  }
  
  public int size()
  {
    return this.count;
  }
  
  public byte[] toBytes(String paramString)
  {
    if ((paramString == null) || ("UTF-8".equals(paramString))) {}
    for (paramString = IOUtils.UTF8;; paramString = Charset.forName(paramString)) {
      return toBytes(paramString);
    }
  }
  
  public byte[] toBytes(Charset paramCharset)
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    if (paramCharset == IOUtils.UTF8) {
      return encodeToUTF8Bytes();
    }
    return new String(this.buf, 0, this.count).getBytes(paramCharset);
  }
  
  public char[] toCharArray()
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    char[] arrayOfChar = new char[this.count];
    System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
    return arrayOfChar;
  }
  
  public char[] toCharArrayForSpringWebSocket()
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    char[] arrayOfChar = new char[this.count - 2];
    System.arraycopy(this.buf, 1, arrayOfChar, 0, this.count - 2);
    return arrayOfChar;
  }
  
  public String toString()
  {
    return new String(this.buf, 0, this.count);
  }
  
  public void write(int paramInt)
  {
    int j = this.count + 1;
    int i = j;
    if (j > this.buf.length)
    {
      if (this.writer != null) {
        break label49;
      }
      expandCapacity(j);
    }
    for (i = j;; i = 1)
    {
      this.buf[this.count] = ((char)paramInt);
      this.count = i;
      return;
      label49:
      flush();
    }
  }
  
  public void write(String paramString)
  {
    if (paramString == null)
    {
      writeNull();
      return;
    }
    write(paramString, 0, paramString.length());
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    int k = this.count + paramInt2;
    int i;
    int j;
    if (k > this.buf.length)
    {
      i = paramInt1;
      j = paramInt2;
      if (this.writer == null)
      {
        expandCapacity(k);
        i = k;
        j = paramInt1;
      }
    }
    for (;;)
    {
      paramString.getChars(j, paramInt2 + j, this.buf, this.count);
      this.count = i;
      return;
      do
      {
        paramInt2 = this.buf.length - this.count;
        paramString.getChars(i, i + paramInt2, this.buf, this.count);
        this.count = this.buf.length;
        flush();
        paramInt1 = j - paramInt2;
        k = i + paramInt2;
        i = k;
        j = paramInt1;
      } while (paramInt1 > this.buf.length);
      paramInt2 = paramInt1;
      j = k;
      i = paramInt1;
      continue;
      i = k;
      j = paramInt1;
    }
  }
  
  public void write(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      write("[]");
      return;
    }
    int i1 = this.count;
    int i2 = paramList.size();
    int k = 0;
    int m = i1;
    if (k < i2)
    {
      String str = (String)paramList.get(k);
      if (str == null)
      {
        j = 1;
        if (j == 0) {
          break label225;
        }
        this.count = i1;
        write(91);
        i = 0;
        label83:
        if (i >= paramList.size()) {
          break label218;
        }
        str = (String)paramList.get(i);
        if (i != 0) {
          write(44);
        }
        if (str != null) {
          break label208;
        }
        write("null");
      }
      for (;;)
      {
        i += 1;
        break label83;
        int i3 = str.length();
        int n = 0;
        i = 0;
        label145:
        j = i;
        if (n >= i3) {
          break;
        }
        i = str.charAt(n);
        if ((i < 32) || (i > 126) || (i == 34) || (i == 92)) {}
        for (i = 1;; i = 0)
        {
          j = i;
          if (i != 0) {
            break;
          }
          n += 1;
          break label145;
        }
        label208:
        writeStringWithDoubleQuote(str, '\000');
      }
      label218:
      write(93);
      return;
      label225:
      int j = str.length() + m + 3;
      int i = j;
      if (k == paramList.size() - 1) {
        i = j + 1;
      }
      if (i > this.buf.length)
      {
        this.count = m;
        expandCapacity(i);
      }
      char[] arrayOfChar;
      if (k == 0)
      {
        arrayOfChar = this.buf;
        i = m + 1;
        arrayOfChar[m] = '[';
      }
      for (;;)
      {
        arrayOfChar = this.buf;
        j = i + 1;
        arrayOfChar[i] = '"';
        str.getChars(0, str.length(), this.buf, j);
        i = str.length() + j;
        this.buf[i] = '"';
        k += 1;
        m = i + 1;
        break;
        arrayOfChar = this.buf;
        i = m + 1;
        arrayOfChar[m] = ',';
      }
    }
    this.buf[m] = ']';
    this.count = (m + 1);
  }
  
  public void write(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      write("true");
      return;
    }
    write("false");
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfChar.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length) || (paramInt1 + paramInt2 < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      return;
    }
    int k = this.count + paramInt2;
    int i;
    int j;
    if (k > this.buf.length)
    {
      i = paramInt1;
      j = paramInt2;
      if (this.writer == null)
      {
        expandCapacity(k);
        i = k;
        j = paramInt1;
      }
    }
    for (;;)
    {
      System.arraycopy(paramArrayOfChar, j, this.buf, this.count, paramInt2);
      this.count = i;
      return;
      do
      {
        paramInt2 = this.buf.length - this.count;
        System.arraycopy(paramArrayOfChar, i, this.buf, this.count, paramInt2);
        this.count = this.buf.length;
        flush();
        paramInt1 = j - paramInt2;
        k = i + paramInt2;
        i = k;
        j = paramInt1;
      } while (paramInt1 > this.buf.length);
      paramInt2 = paramInt1;
      j = k;
      i = paramInt1;
      continue;
      i = k;
      j = paramInt1;
    }
  }
  
  public void writeByteArray(byte[] paramArrayOfByte)
  {
    int n = 0;
    int m = 0;
    int i1 = paramArrayOfByte.length;
    int i;
    if (this.useSingleQuotes)
    {
      i = 39;
      if (i1 != 0) {
        break label55;
      }
      if (!this.useSingleQuotes) {
        break label48;
      }
    }
    label48:
    for (paramArrayOfByte = "''";; paramArrayOfByte = "\"\"")
    {
      write(paramArrayOfByte);
      return;
      i = 34;
      break;
    }
    label55:
    char[] arrayOfChar1 = IOUtils.CA;
    int i2 = i1 / 3 * 3;
    int k = (i1 - 1) / 3;
    int i4 = this.count;
    int i3 = (k + 1 << 2) + this.count + 2;
    if (i3 > this.buf.length)
    {
      if (this.writer != null)
      {
        write(i);
        k = 0;
        while (k < i2)
        {
          i4 = k + 1;
          n = paramArrayOfByte[k];
          i3 = i4 + 1;
          i4 = paramArrayOfByte[i4];
          k = i3 + 1;
          n = (i4 & 0xFF) << 8 | (n & 0xFF) << 16 | paramArrayOfByte[i3] & 0xFF;
          write(arrayOfChar1[(n >>> 18 & 0x3F)]);
          write(arrayOfChar1[(n >>> 12 & 0x3F)]);
          write(arrayOfChar1[(n >>> 6 & 0x3F)]);
          write(arrayOfChar1[(n & 0x3F)]);
        }
        n = i1 - i2;
        if (n > 0)
        {
          i2 = paramArrayOfByte[i2];
          k = m;
          if (n == 2) {
            k = (paramArrayOfByte[(i1 - 1)] & 0xFF) << 2;
          }
          k |= (i2 & 0xFF) << 10;
          write(arrayOfChar1[(k >> 12)]);
          write(arrayOfChar1[(k >>> 6 & 0x3F)]);
          if (n != 2) {
            break label366;
          }
        }
        label366:
        for (k = arrayOfChar1[(k & 0x3F)];; k = 61)
        {
          write(k);
          write(61);
          write(i);
          return;
        }
      }
      expandCapacity(i3);
    }
    this.count = i3;
    char[] arrayOfChar2 = this.buf;
    k = i4 + 1;
    arrayOfChar2[i4] = i;
    m = 0;
    while (m < i2)
    {
      int i6 = m + 1;
      i4 = paramArrayOfByte[m];
      int i5 = i6 + 1;
      i6 = paramArrayOfByte[i6];
      m = i5 + 1;
      i4 = (i6 & 0xFF) << 8 | (i4 & 0xFF) << 16 | paramArrayOfByte[i5] & 0xFF;
      arrayOfChar2 = this.buf;
      i5 = k + 1;
      arrayOfChar2[k] = arrayOfChar1[(i4 >>> 18 & 0x3F)];
      arrayOfChar2 = this.buf;
      k = i5 + 1;
      arrayOfChar2[i5] = arrayOfChar1[(i4 >>> 12 & 0x3F)];
      arrayOfChar2 = this.buf;
      i5 = k + 1;
      arrayOfChar2[k] = arrayOfChar1[(i4 >>> 6 & 0x3F)];
      arrayOfChar2 = this.buf;
      k = i5 + 1;
      arrayOfChar2[i5] = arrayOfChar1[(i4 & 0x3F)];
    }
    m = i1 - i2;
    if (m > 0)
    {
      i2 = paramArrayOfByte[i2];
      k = n;
      if (m == 2) {
        k = (paramArrayOfByte[(i1 - 1)] & 0xFF) << 2;
      }
      k |= (i2 & 0xFF) << 10;
      this.buf[(i3 - 5)] = arrayOfChar1[(k >> 12)];
      this.buf[(i3 - 4)] = arrayOfChar1[(k >>> 6 & 0x3F)];
      paramArrayOfByte = this.buf;
      if (m != 2) {
        break label727;
      }
    }
    label727:
    for (int j = arrayOfChar1[(k & 0x3F)];; j = 61)
    {
      paramArrayOfByte[(i3 - 3)] = j;
      this.buf[(i3 - 2)] = '=';
      this.buf[(i3 - 1)] = i;
      return;
    }
  }
  
  public void writeDouble(double paramDouble, boolean paramBoolean)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      writeNull();
    }
    do
    {
      return;
      String str2 = Double.toString(paramDouble);
      String str1 = str2;
      if (isEnabled(SerializerFeature.WriteNullNumberAsZero))
      {
        str1 = str2;
        if (str2.endsWith(".0")) {
          str1 = str2.substring(0, str2.length() - 2);
        }
      }
      write(str1);
    } while ((!paramBoolean) || (!isEnabled(SerializerFeature.WriteClassName)));
    write(68);
  }
  
  public void writeEnum(Enum<?> paramEnum)
  {
    if (paramEnum == null)
    {
      writeNull();
      return;
    }
    String str;
    if ((this.writeEnumUsingName) && (!this.writeEnumUsingToString)) {
      str = paramEnum.name();
    }
    for (;;)
    {
      if (str != null)
      {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {}
        for (int i = 39;; i = 34)
        {
          write(i);
          write(str);
          write(i);
          return;
          if (!this.writeEnumUsingToString) {
            break label91;
          }
          str = paramEnum.toString();
          break;
        }
      }
      writeInt(paramEnum.ordinal());
      return;
      label91:
      str = null;
    }
  }
  
  public void writeFieldName(String paramString)
  {
    writeFieldName(paramString, false);
  }
  
  public void writeFieldName(String paramString, boolean paramBoolean)
  {
    int k = 1;
    if (paramString == null)
    {
      write("null:");
      return;
    }
    if (this.useSingleQuotes)
    {
      if (this.quoteFieldNames)
      {
        writeStringWithSingleQuote(paramString);
        write(58);
        return;
      }
      writeKeyWithSingleQuoteIfHasSpecial(paramString);
      return;
    }
    if (this.quoteFieldNames)
    {
      writeStringWithDoubleQuote(paramString, ':');
      return;
    }
    int i;
    int j;
    if (paramString.length() == 0)
    {
      i = 1;
      j = 0;
      label74:
      if (j >= paramString.length()) {
        break label137;
      }
      if (!isSpecial(paramString.charAt(j), 0)) {
        break label116;
      }
      i = k;
    }
    label116:
    label137:
    for (;;)
    {
      if (i != 0)
      {
        writeStringWithDoubleQuote(paramString, ':');
        return;
        i = 0;
        break;
        j += 1;
        break label74;
      }
      write(paramString);
      write(58);
      return;
    }
  }
  
  public void writeFieldNameDirect(String paramString)
  {
    int i = paramString.length();
    int j = this.count + i + 3;
    if (j > this.buf.length) {
      expandCapacity(j);
    }
    int k = this.count;
    this.buf[this.count] = '"';
    paramString.getChars(0, i, this.buf, k + 1);
    this.count = j;
    this.buf[(this.count - 2)] = '"';
    this.buf[(this.count - 1)] = ':';
  }
  
  public void writeFieldValue(char paramChar1, String paramString, char paramChar2)
  {
    write(paramChar1);
    writeFieldName(paramString);
    if (paramChar2 == 0)
    {
      writeString("\000");
      return;
    }
    writeString(Character.toString(paramChar2));
  }
  
  public void writeFieldValue(char paramChar, String paramString, double paramDouble)
  {
    write(paramChar);
    writeFieldName(paramString);
    writeDouble(paramDouble, false);
  }
  
  public void writeFieldValue(char paramChar, String paramString, float paramFloat)
  {
    write(paramChar);
    writeFieldName(paramString);
    writeFloat(paramFloat, false);
  }
  
  public void writeFieldValue(char paramChar, String paramString, int paramInt)
  {
    if ((paramInt == Integer.MIN_VALUE) || (!this.quoteFieldNames))
    {
      write(paramChar);
      writeFieldName(paramString);
      writeInt(paramInt);
      return;
    }
    if (paramInt < 0) {}
    int j;
    for (int i = IOUtils.stringSize(-paramInt) + 1;; i = IOUtils.stringSize(paramInt))
    {
      j = paramString.length();
      k = i + (this.count + j + 4);
      if (k <= this.buf.length) {
        break label111;
      }
      if (this.writer == null) {
        break;
      }
      write(paramChar);
      writeFieldName(paramString);
      writeInt(paramInt);
      return;
    }
    expandCapacity(k);
    label111:
    i = this.count;
    this.count = k;
    this.buf[i] = paramChar;
    int k = i + j + 1;
    this.buf[(i + 1)] = this.keySeperator;
    paramString.getChars(0, j, this.buf, i + 2);
    this.buf[(k + 1)] = this.keySeperator;
    this.buf[(k + 2)] = ':';
    IOUtils.getChars(paramInt, this.count, this.buf);
  }
  
  public void writeFieldValue(char paramChar, String paramString, long paramLong)
  {
    if ((paramLong == Long.MIN_VALUE) || (!this.quoteFieldNames))
    {
      write(paramChar);
      writeFieldName(paramString);
      writeLong(paramLong);
      return;
    }
    if (paramLong < 0L) {}
    int j;
    for (int i = IOUtils.stringSize(-paramLong) + 1;; i = IOUtils.stringSize(paramLong))
    {
      j = paramString.length();
      k = i + (this.count + j + 4);
      if (k <= this.buf.length) {
        break label114;
      }
      if (this.writer == null) {
        break;
      }
      write(paramChar);
      writeFieldName(paramString);
      writeLong(paramLong);
      return;
    }
    expandCapacity(k);
    label114:
    i = this.count;
    this.count = k;
    this.buf[i] = paramChar;
    int k = i + j + 1;
    this.buf[(i + 1)] = this.keySeperator;
    paramString.getChars(0, j, this.buf, i + 2);
    this.buf[(k + 1)] = this.keySeperator;
    this.buf[(k + 2)] = ':';
    IOUtils.getChars(paramLong, this.count, this.buf);
  }
  
  public void writeFieldValue(char paramChar, String paramString, Enum<?> paramEnum)
  {
    if (paramEnum == null)
    {
      write(paramChar);
      writeFieldName(paramString);
      writeNull();
      return;
    }
    if ((this.writeEnumUsingName) && (!this.writeEnumUsingToString))
    {
      writeEnumFieldValue(paramChar, paramString, paramEnum.name());
      return;
    }
    if (this.writeEnumUsingToString)
    {
      writeEnumFieldValue(paramChar, paramString, paramEnum.toString());
      return;
    }
    writeFieldValue(paramChar, paramString, paramEnum.ordinal());
  }
  
  public void writeFieldValue(char paramChar, String paramString1, String paramString2)
  {
    if (this.quoteFieldNames)
    {
      if (this.useSingleQuotes)
      {
        write(paramChar);
        writeFieldName(paramString1);
        if (paramString2 == null)
        {
          writeNull();
          return;
        }
        writeString(paramString2);
        return;
      }
      if (isEnabled(SerializerFeature.BrowserSecure))
      {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, '\000');
        return;
      }
      if (isEnabled(SerializerFeature.BrowserCompatible))
      {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, '\000');
        return;
      }
      writeFieldValueStringWithDoubleQuoteCheck(paramChar, paramString1, paramString2);
      return;
    }
    write(paramChar);
    writeFieldName(paramString1);
    if (paramString2 == null)
    {
      writeNull();
      return;
    }
    writeString(paramString2);
  }
  
  public void writeFieldValue(char paramChar, String paramString, BigDecimal paramBigDecimal)
  {
    write(paramChar);
    writeFieldName(paramString);
    if (paramBigDecimal == null)
    {
      writeNull();
      return;
    }
    write(paramBigDecimal.toString());
  }
  
  public void writeFieldValue(char paramChar, String paramString, boolean paramBoolean)
  {
    if (!this.quoteFieldNames)
    {
      write(paramChar);
      writeFieldName(paramString);
      write(paramBoolean);
      return;
    }
    if (paramBoolean) {}
    int j;
    for (int i = 4;; i = 5)
    {
      j = paramString.length();
      k = i + (this.count + j + 4);
      if (k <= this.buf.length) {
        break label101;
      }
      if (this.writer == null) {
        break;
      }
      write(paramChar);
      writeString(paramString);
      write(58);
      write(paramBoolean);
      return;
    }
    expandCapacity(k);
    label101:
    i = this.count;
    this.count = k;
    this.buf[i] = paramChar;
    int k = i + j + 1;
    this.buf[(i + 1)] = this.keySeperator;
    paramString.getChars(0, j, this.buf, i + 2);
    this.buf[(k + 1)] = this.keySeperator;
    if (paramBoolean)
    {
      System.arraycopy(":true".toCharArray(), 0, this.buf, k + 2, 5);
      return;
    }
    System.arraycopy(":false".toCharArray(), 0, this.buf, k + 2, 6);
  }
  
  public void writeFieldValueStringWithDoubleQuote(char paramChar, String paramString1, String paramString2)
  {
    int j = paramString1.length();
    int k = this.count;
    int i = paramString2.length();
    k += j + i + 6;
    if (k > this.buf.length)
    {
      if (this.writer != null)
      {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, '\000');
        return;
      }
      expandCapacity(k);
    }
    this.buf[this.count] = paramChar;
    int m = this.count + 2;
    int n = m + j;
    this.buf[(this.count + 1)] = '"';
    paramString1.getChars(0, j, this.buf, m);
    this.count = k;
    this.buf[n] = '"';
    j = n + 1;
    paramString1 = this.buf;
    k = j + 1;
    paramString1[j] = 58;
    this.buf[k] = '"';
    paramString2.getChars(0, i, this.buf, k + 1);
    this.buf[(this.count - 1)] = '"';
  }
  
  public void writeFieldValueStringWithDoubleQuoteCheck(char paramChar, String paramString1, String paramString2)
  {
    int k = paramString1.length();
    int i = this.count;
    if (paramString2 == null)
    {
      j = 4;
      i += k + 8;
    }
    while (i > this.buf.length) {
      if (this.writer != null)
      {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, '\000');
        return;
        j = paramString2.length();
        i += k + j + 6;
      }
      else
      {
        expandCapacity(i);
      }
    }
    this.buf[this.count] = paramChar;
    int m = this.count + 2;
    int n = m + k;
    this.buf[(this.count + 1)] = '"';
    paramString1.getChars(0, k, this.buf, m);
    this.count = i;
    this.buf[n] = '"';
    m = n + 1;
    paramString1 = this.buf;
    k = m + 1;
    paramString1[m] = 58;
    if (paramString2 == null)
    {
      paramString1 = this.buf;
      i = k + 1;
      paramString1[k] = 110;
      paramString1 = this.buf;
      j = i + 1;
      paramString1[i] = 117;
      paramString1 = this.buf;
      i = j + 1;
      paramString1[j] = 108;
      this.buf[i] = 'l';
      return;
    }
    paramString1 = this.buf;
    int i3 = k + 1;
    paramString1[k] = 34;
    int i4 = i3 + j;
    paramString2.getChars(0, j, this.buf, i3);
    n = 0;
    int i1 = -1;
    m = 0;
    k = i;
    int j = -1;
    i = i3;
    if (i < i4)
    {
      paramChar = this.buf[i];
      if (paramChar >= ']')
      {
        if ((paramChar < '') || ((paramChar != ' ') && (paramChar >= ' '))) {
          break label1356;
        }
        m = j;
        if (j == -1) {
          m = i;
        }
        i1 = k + 4;
        n += 1;
        k = m;
        j = paramChar;
        m = i;
      }
    }
    for (;;)
    {
      i += 1;
      int i2 = i1;
      i1 = m;
      m = j;
      j = k;
      k = i2;
      break;
      if (isSpecial(paramChar, this.features))
      {
        m = n + 1;
        if ((paramChar < IOUtils.specicalFlags_doubleQuotes.length) && (IOUtils.specicalFlags_doubleQuotes[paramChar] == 4)) {
          k += 4;
        }
        for (;;)
        {
          if (j == -1)
          {
            j = paramChar;
            i1 = k;
            n = i;
            i2 = m;
            k = i;
            m = n;
            n = i2;
            break;
            if (n > 0)
            {
              i = k + n;
              if (i > this.buf.length) {
                expandCapacity(i);
              }
              this.count = i;
              if (n != 1) {
                break label896;
              }
              if (m != 8232) {
                break label664;
              }
              System.arraycopy(this.buf, i1 + 1, this.buf, i1 + 6, i4 - i1 - 1);
              this.buf[i1] = '\\';
              paramString1 = this.buf;
              i = i1 + 1;
              paramString1[i] = 117;
              paramString1 = this.buf;
              i += 1;
              paramString1[i] = 50;
              paramString1 = this.buf;
              i += 1;
              paramString1[i] = 48;
              paramString1 = this.buf;
              i += 1;
              paramString1[i] = 50;
              this.buf[(i + 1)] = '8';
            }
            label664:
            label896:
            while (n <= 1) {
              for (;;)
              {
                this.buf[(this.count - 1)] = '"';
                return;
                if ((m < IOUtils.specicalFlags_doubleQuotes.length) && (IOUtils.specicalFlags_doubleQuotes[m] == 4))
                {
                  System.arraycopy(this.buf, i1 + 1, this.buf, i1 + 6, i4 - i1 - 1);
                  paramString1 = this.buf;
                  i = i1 + 1;
                  paramString1[i1] = 92;
                  paramString1 = this.buf;
                  j = i + 1;
                  paramString1[i] = 117;
                  paramString1 = this.buf;
                  i = j + 1;
                  paramString1[j] = IOUtils.DIGITS[(m >>> 12 & 0xF)];
                  paramString1 = this.buf;
                  j = i + 1;
                  paramString1[i] = IOUtils.DIGITS[(m >>> 8 & 0xF)];
                  paramString1 = this.buf;
                  i = j + 1;
                  paramString1[j] = IOUtils.DIGITS[(m >>> 4 & 0xF)];
                  this.buf[i] = IOUtils.DIGITS[(m & 0xF)];
                }
                else
                {
                  System.arraycopy(this.buf, i1 + 1, this.buf, i1 + 2, i4 - i1 - 1);
                  this.buf[i1] = '\\';
                  this.buf[(i1 + 1)] = IOUtils.replaceChars[m];
                }
              }
            }
            i = i4;
            m = j - i3;
            k = j;
            j = i;
            i = k;
            k = m;
            label929:
            if (k < paramString2.length())
            {
              paramChar = paramString2.charAt(k);
              if (((paramChar >= IOUtils.specicalFlags_doubleQuotes.length) || (IOUtils.specicalFlags_doubleQuotes[paramChar] == 0)) && ((paramChar != '/') || (!isEnabled(SerializerFeature.WriteSlashAsSpecial)))) {
                break label1164;
              }
              paramString1 = this.buf;
              m = i + 1;
              paramString1[i] = 92;
              if (IOUtils.specicalFlags_doubleQuotes[paramChar] != 4) {
                break label1135;
              }
              paramString1 = this.buf;
              i = m + 1;
              paramString1[m] = 117;
              paramString1 = this.buf;
              m = i + 1;
              paramString1[i] = IOUtils.DIGITS[(paramChar >>> '\f' & 0xF)];
              paramString1 = this.buf;
              i = m + 1;
              paramString1[m] = IOUtils.DIGITS[(paramChar >>> '\b' & 0xF)];
              paramString1 = this.buf;
              m = i + 1;
              paramString1[i] = IOUtils.DIGITS[(paramChar >>> '\004' & 0xF)];
              paramString1 = this.buf;
              i = m + 1;
              paramString1[m] = IOUtils.DIGITS[(paramChar & 0xF)];
              j += 5;
            }
            for (;;)
            {
              k += 1;
              break label929;
              break;
              label1135:
              paramString1 = this.buf;
              i = m + 1;
              paramString1[m] = IOUtils.replaceChars[paramChar];
              j += 1;
              continue;
              label1164:
              if (paramChar == ' ')
              {
                paramString1 = this.buf;
                m = i + 1;
                paramString1[i] = 92;
                paramString1 = this.buf;
                i = m + 1;
                paramString1[m] = 117;
                paramString1 = this.buf;
                m = i + 1;
                paramString1[i] = IOUtils.DIGITS[(paramChar >>> '\f' & 0xF)];
                paramString1 = this.buf;
                i = m + 1;
                paramString1[m] = IOUtils.DIGITS[(paramChar >>> '\b' & 0xF)];
                paramString1 = this.buf;
                m = i + 1;
                paramString1[i] = IOUtils.DIGITS[(paramChar >>> '\004' & 0xF)];
                paramString1 = this.buf;
                i = m + 1;
                paramString1[m] = IOUtils.DIGITS[(paramChar & 0xF)];
                j += 5;
              }
              else
              {
                this.buf[i] = paramChar;
                i += 1;
              }
            }
          }
          i1 = k;
          n = m;
          k = j;
          j = paramChar;
          m = i;
          break;
        }
      }
      label1356:
      i2 = k;
      k = j;
      j = m;
      m = i1;
      i1 = i2;
    }
  }
  
  public void writeFloat(float paramFloat, boolean paramBoolean)
  {
    if ((Float.isNaN(paramFloat)) || (Float.isInfinite(paramFloat))) {
      writeNull();
    }
    do
    {
      return;
      String str2 = Float.toString(paramFloat);
      String str1 = str2;
      if (isEnabled(SerializerFeature.WriteNullNumberAsZero))
      {
        str1 = str2;
        if (str2.endsWith(".0")) {
          str1 = str2.substring(0, str2.length() - 2);
        }
      }
      write(str1);
    } while ((!paramBoolean) || (!isEnabled(SerializerFeature.WriteClassName)));
    write(70);
  }
  
  public void writeInt(int paramInt)
  {
    if (paramInt == Integer.MIN_VALUE)
    {
      write("-2147483648");
      return;
    }
    if (paramInt < 0) {}
    for (int i = IOUtils.stringSize(-paramInt) + 1;; i = IOUtils.stringSize(paramInt))
    {
      int j = this.count + i;
      if (j > this.buf.length)
      {
        if (this.writer != null) {
          break;
        }
        expandCapacity(j);
      }
      IOUtils.getChars(paramInt, j, this.buf);
      this.count = j;
      return;
    }
    char[] arrayOfChar = new char[i];
    IOUtils.getChars(paramInt, i, arrayOfChar);
    write(arrayOfChar, 0, arrayOfChar.length);
  }
  
  public void writeLong(long paramLong)
  {
    int i;
    if ((isEnabled(SerializerFeature.BrowserCompatible)) && (!isEnabled(SerializerFeature.WriteClassName)) && ((paramLong > 9007199254740991L) || (paramLong < -9007199254740991L))) {
      i = 1;
    }
    while (paramLong == Long.MIN_VALUE) {
      if (i != 0)
      {
        write("\"-9223372036854775808\"");
        return;
        i = 0;
      }
      else
      {
        write("-9223372036854775808");
        return;
      }
    }
    int j;
    int k;
    if (paramLong < 0L)
    {
      j = IOUtils.stringSize(-paramLong) + 1;
      int m = this.count + j;
      k = m;
      if (i != 0) {
        k = m + 2;
      }
      if (k > this.buf.length)
      {
        if (this.writer != null) {
          break label186;
        }
        expandCapacity(k);
      }
      if (i == 0) {
        break label238;
      }
      this.buf[this.count] = '"';
      IOUtils.getChars(paramLong, k - 1, this.buf);
      this.buf[(k - 1)] = '"';
    }
    for (;;)
    {
      this.count = k;
      return;
      j = IOUtils.stringSize(paramLong);
      break;
      label186:
      char[] arrayOfChar = new char[j];
      IOUtils.getChars(paramLong, j, arrayOfChar);
      if (i != 0)
      {
        write(34);
        write(arrayOfChar, 0, arrayOfChar.length);
        write(34);
        return;
      }
      write(arrayOfChar, 0, arrayOfChar.length);
      return;
      label238:
      IOUtils.getChars(paramLong, k, this.buf);
    }
  }
  
  public void writeNull()
  {
    write("null");
  }
  
  public void writeNull(int paramInt1, int paramInt2)
  {
    if (((paramInt1 & paramInt2) == 0) && ((this.features & paramInt2) == 0))
    {
      writeNull();
      return;
    }
    if (paramInt2 == SerializerFeature.WriteNullListAsEmpty.mask)
    {
      write("[]");
      return;
    }
    if (paramInt2 == SerializerFeature.WriteNullStringAsEmpty.mask)
    {
      writeString("");
      return;
    }
    if (paramInt2 == SerializerFeature.WriteNullBooleanAsFalse.mask)
    {
      write("false");
      return;
    }
    if (paramInt2 == SerializerFeature.WriteNullNumberAsZero.mask)
    {
      write(48);
      return;
    }
    writeNull();
  }
  
  public void writeNull(SerializerFeature paramSerializerFeature)
  {
    writeNull(0, paramSerializerFeature.mask);
  }
  
  public void writeString(String paramString)
  {
    if (this.useSingleQuotes)
    {
      writeStringWithSingleQuote(paramString);
      return;
    }
    writeStringWithDoubleQuote(paramString, '\000');
  }
  
  public void writeString(String paramString, char paramChar)
  {
    if (this.useSingleQuotes)
    {
      writeStringWithSingleQuote(paramString);
      write(paramChar);
      return;
    }
    writeStringWithDoubleQuote(paramString, paramChar);
  }
  
  public void writeStringWithDoubleQuote(String paramString, char paramChar)
  {
    if (paramString == null)
    {
      writeNull();
      if (paramChar != 0) {
        write(paramChar);
      }
    }
    label606:
    do
    {
      return;
      n = paramString.length();
      m = this.count + n + 2;
      k = m;
      if (paramChar != 0) {
        k = m + 1;
      }
      if (k <= this.buf.length) {
        break label637;
      }
      if (this.writer == null) {
        break;
      }
      write(34);
      k = 0;
      if (k < paramString.length())
      {
        m = paramString.charAt(k);
        if (isEnabled(SerializerFeature.BrowserSecure))
        {
          if (((m >= 48) && (m <= 57)) || ((m >= 97) && (m <= 122)) || ((m >= 65) && (m <= 90)) || (m == 44) || (m == 46) || (m == 95)) {
            break label606;
          }
          write(92);
          write(117);
          write(IOUtils.DIGITS[(m >>> 12 & 0xF)]);
          write(IOUtils.DIGITS[(m >>> 8 & 0xF)]);
          write(IOUtils.DIGITS[(m >>> 4 & 0xF)]);
          write(IOUtils.DIGITS[(m & 0xF)]);
        }
        for (;;)
        {
          k += 1;
          break;
          if (isEnabled(SerializerFeature.BrowserCompatible))
          {
            if ((m == 8) || (m == 12) || (m == 10) || (m == 13) || (m == 9) || (m == 34) || (m == 47) || (m == 92))
            {
              write(92);
              write(IOUtils.replaceChars[m]);
              continue;
            }
            if (m < 32)
            {
              write(92);
              write(117);
              write(48);
              write(48);
              write(IOUtils.ASCII_CHARS[(m * 2)]);
              write(IOUtils.ASCII_CHARS[(m * 2 + 1)]);
              continue;
            }
            if (m >= 127)
            {
              write(92);
              write(117);
              write(IOUtils.DIGITS[(m >>> 12 & 0xF)]);
              write(IOUtils.DIGITS[(m >>> 8 & 0xF)]);
              write(IOUtils.DIGITS[(m >>> 4 & 0xF)]);
              write(IOUtils.DIGITS[(m & 0xF)]);
            }
          }
          else if (((m < IOUtils.specicalFlags_doubleQuotes.length) && (IOUtils.specicalFlags_doubleQuotes[m] != 0)) || ((m == 47) && (isEnabled(SerializerFeature.WriteSlashAsSpecial))))
          {
            write(92);
            if (IOUtils.specicalFlags_doubleQuotes[m] == 4)
            {
              write(117);
              write(IOUtils.DIGITS[(m >>> 12 & 0xF)]);
              write(IOUtils.DIGITS[(m >>> 8 & 0xF)]);
              write(IOUtils.DIGITS[(m >>> 4 & 0xF)]);
              write(IOUtils.DIGITS[(m & 0xF)]);
              continue;
            }
            write(IOUtils.replaceChars[m]);
            continue;
          }
          write(m);
        }
      }
      write(34);
    } while (paramChar == 0);
    write(paramChar);
    return;
    expandCapacity(k);
    label637:
    int i4 = this.count + 1;
    int i5 = i4 + n;
    this.buf[this.count] = '"';
    paramString.getChars(0, n, this.buf, i4);
    this.count = k;
    if (isEnabled(SerializerFeature.BrowserSecure))
    {
      n = k;
      m = -1;
      k = i4;
      while (k < i5)
      {
        i3 = this.buf[k];
        if (i3 >= 48)
        {
          i2 = m;
          i1 = n;
          if (i3 <= 57) {}
        }
        else if (i3 >= 97)
        {
          i2 = m;
          i1 = n;
          if (i3 <= 122) {}
        }
        else if (i3 >= 65)
        {
          i2 = m;
          i1 = n;
          if (i3 <= 90) {}
        }
        else
        {
          i2 = m;
          i1 = n;
          if (i3 != 44)
          {
            i2 = m;
            i1 = n;
            if (i3 != 46)
            {
              i2 = m;
              i1 = n;
              if (i3 != 95)
              {
                i1 = n + 5;
                i2 = k;
              }
            }
          }
        }
        k += 1;
        m = i2;
        n = i1;
      }
      if (n > this.buf.length) {
        expandCapacity(n);
      }
      this.count = n;
      k = m;
      for (m = i5; k >= i4; m = n)
      {
        i1 = this.buf[k];
        if (i1 >= 48)
        {
          n = m;
          if (i1 <= 57) {}
        }
        else if (i1 >= 97)
        {
          n = m;
          if (i1 <= 122) {}
        }
        else if (i1 >= 65)
        {
          n = m;
          if (i1 <= 90) {}
        }
        else
        {
          n = m;
          if (i1 != 44)
          {
            n = m;
            if (i1 != 46)
            {
              n = m;
              if (i1 != 95)
              {
                System.arraycopy(this.buf, k + 1, this.buf, k + 6, m - k - 1);
                this.buf[k] = '\\';
                this.buf[(k + 1)] = 'u';
                this.buf[(k + 2)] = IOUtils.DIGITS[(i1 >>> 12 & 0xF)];
                this.buf[(k + 3)] = IOUtils.DIGITS[(i1 >>> 8 & 0xF)];
                this.buf[(k + 4)] = IOUtils.DIGITS[(i1 >>> 4 & 0xF)];
                this.buf[(k + 5)] = IOUtils.DIGITS[(i1 & 0xF)];
                n = m + 5;
              }
            }
          }
        }
        k -= 1;
      }
      if (paramChar != 0)
      {
        this.buf[(this.count - 2)] = '"';
        this.buf[(this.count - 1)] = paramChar;
        return;
      }
      this.buf[(this.count - 1)] = '"';
      return;
    }
    int i;
    if (isEnabled(SerializerFeature.BrowserCompatible))
    {
      i1 = k;
      m = -1;
      k = i4;
      if (k < i5)
      {
        i2 = this.buf[k];
        if ((i2 == 34) || (i2 == 47) || (i2 == 92))
        {
          n = i1 + 1;
          m = k;
        }
        for (;;)
        {
          k += 1;
          i1 = n;
          break;
          if ((i2 == 8) || (i2 == 12) || (i2 == 10) || (i2 == 13) || (i2 == 9))
          {
            n = i1 + 1;
            m = k;
          }
          else if (i2 < 32)
          {
            n = i1 + 5;
            m = k;
          }
          else
          {
            n = i1;
            if (i2 >= 127)
            {
              n = i1 + 5;
              m = k;
            }
          }
        }
      }
      if (i1 > this.buf.length) {
        expandCapacity(i1);
      }
      this.count = i1;
      n = i5;
      if (m >= i4)
      {
        i = this.buf[m];
        if ((i == 8) || (i == 12) || (i == 10) || (i == 13) || (i == 9))
        {
          System.arraycopy(this.buf, m + 1, this.buf, m + 2, n - m - 1);
          this.buf[m] = '\\';
          this.buf[(m + 1)] = IOUtils.replaceChars[i];
          k = n + 1;
        }
        for (;;)
        {
          m -= 1;
          n = k;
          break;
          if ((i == 34) || (i == 47) || (i == 92))
          {
            System.arraycopy(this.buf, m + 1, this.buf, m + 2, n - m - 1);
            this.buf[m] = '\\';
            this.buf[(m + 1)] = i;
            k = n + 1;
          }
          else if (i < 32)
          {
            System.arraycopy(this.buf, m + 1, this.buf, m + 6, n - m - 1);
            this.buf[m] = '\\';
            this.buf[(m + 1)] = 'u';
            this.buf[(m + 2)] = '0';
            this.buf[(m + 3)] = '0';
            this.buf[(m + 4)] = IOUtils.ASCII_CHARS[(i * 2)];
            this.buf[(m + 5)] = IOUtils.ASCII_CHARS[(i * 2 + 1)];
            k = n + 5;
          }
          else
          {
            k = n;
            if (i >= 127)
            {
              System.arraycopy(this.buf, m + 1, this.buf, m + 6, n - m - 1);
              this.buf[m] = '\\';
              this.buf[(m + 1)] = 'u';
              this.buf[(m + 2)] = IOUtils.DIGITS[(i >>> 12 & 0xF)];
              this.buf[(m + 3)] = IOUtils.DIGITS[(i >>> 8 & 0xF)];
              this.buf[(m + 4)] = IOUtils.DIGITS[(i >>> 4 & 0xF)];
              this.buf[(m + 5)] = IOUtils.DIGITS[(i & 0xF)];
              k = n + 5;
            }
          }
        }
      }
      if (paramChar != 0)
      {
        this.buf[(this.count - 2)] = '"';
        this.buf[(this.count - 1)] = paramChar;
        return;
      }
      this.buf[(this.count - 1)] = '"';
      return;
    }
    int i2 = 0;
    int i3 = -1;
    int i1 = 0;
    int m = i4;
    int i6 = -1;
    int n = k;
    int k = m;
    m = i6;
    if (k < i5)
    {
      i = this.buf[k];
      if (i == 8232)
      {
        i3 = i2 + 1;
        n += 4;
        i1 = i3;
        i2 = n;
        if (m != -1) {
          break label3035;
        }
        i6 = i;
        m = n;
        i2 = i3;
        n = k;
        i1 = k;
        i3 = m;
        m = i6;
      }
    }
    for (;;)
    {
      k += 1;
      i6 = i3;
      i3 = i1;
      i1 = m;
      m = n;
      n = i6;
      break;
      if (i >= 93)
      {
        if ((i >= 127) && (i < 160))
        {
          i1 = m;
          if (m == -1) {
            i1 = k;
          }
          i3 = n + 4;
          i6 = i2 + 1;
          i2 = k;
          m = i;
          n = i1;
          i1 = i2;
          i2 = i6;
        }
      }
      else if (isSpecial(i, this.features))
      {
        i3 = i2 + 1;
        if ((i < IOUtils.specicalFlags_doubleQuotes.length) && (IOUtils.specicalFlags_doubleQuotes[i] == 4)) {
          n += 4;
        }
        for (;;)
        {
          i1 = i3;
          i2 = n;
          label2340:
          label2572:
          label2593:
          int j;
          if (m == -1)
          {
            m = i;
            i6 = n;
            i2 = i3;
            n = k;
            i1 = k;
            i3 = i6;
            break;
            if (i2 > 0)
            {
              k = n + i2;
              if (k > this.buf.length) {
                expandCapacity(k);
              }
              this.count = k;
              if (i2 != 1) {
                break label2572;
              }
              if (i1 != 8232) {
                break label2340;
              }
              System.arraycopy(this.buf, i3 + 1, this.buf, i3 + 6, i5 - i3 - 1);
              this.buf[i3] = '\\';
              paramString = this.buf;
              k = i3 + 1;
              paramString[k] = 117;
              paramString = this.buf;
              k += 1;
              paramString[k] = 50;
              paramString = this.buf;
              k += 1;
              paramString[k] = 48;
              paramString = this.buf;
              k += 1;
              paramString[k] = 50;
              this.buf[(k + 1)] = '8';
            }
            while (paramChar != 0)
            {
              this.buf[(this.count - 2)] = '"';
              this.buf[(this.count - 1)] = paramChar;
              return;
              if ((i1 < IOUtils.specicalFlags_doubleQuotes.length) && (IOUtils.specicalFlags_doubleQuotes[i1] == 4))
              {
                System.arraycopy(this.buf, i3 + 1, this.buf, i3 + 6, i5 - i3 - 1);
                paramString = this.buf;
                k = i3 + 1;
                paramString[i3] = 92;
                paramString = this.buf;
                m = k + 1;
                paramString[k] = 117;
                paramString = this.buf;
                k = m + 1;
                paramString[m] = IOUtils.DIGITS[(i1 >>> 12 & 0xF)];
                paramString = this.buf;
                m = k + 1;
                paramString[k] = IOUtils.DIGITS[(i1 >>> 8 & 0xF)];
                paramString = this.buf;
                k = m + 1;
                paramString[m] = IOUtils.DIGITS[(i1 >>> 4 & 0xF)];
                this.buf[k] = IOUtils.DIGITS[(i1 & 0xF)];
              }
              else
              {
                System.arraycopy(this.buf, i3 + 1, this.buf, i3 + 2, i5 - i3 - 1);
                this.buf[i3] = '\\';
                this.buf[(i3 + 1)] = IOUtils.replaceChars[i1];
                continue;
                if (i2 > 1)
                {
                  n = m - i4;
                  k = m;
                  m = i5;
                  char[] arrayOfChar;
                  if (n < paramString.length())
                  {
                    j = paramString.charAt(n);
                    if (((j >= IOUtils.specicalFlags_doubleQuotes.length) || (IOUtils.specicalFlags_doubleQuotes[j] == 0)) && ((j != 47) || (!isEnabled(SerializerFeature.WriteSlashAsSpecial)))) {
                      break label2842;
                    }
                    arrayOfChar = this.buf;
                    i1 = k + 1;
                    arrayOfChar[k] = '\\';
                    if (IOUtils.specicalFlags_doubleQuotes[j] != 4) {
                      break label2811;
                    }
                    arrayOfChar = this.buf;
                    k = i1 + 1;
                    arrayOfChar[i1] = 'u';
                    arrayOfChar = this.buf;
                    i1 = k + 1;
                    arrayOfChar[k] = IOUtils.DIGITS[(j >>> 12 & 0xF)];
                    arrayOfChar = this.buf;
                    k = i1 + 1;
                    arrayOfChar[i1] = IOUtils.DIGITS[(j >>> 8 & 0xF)];
                    arrayOfChar = this.buf;
                    i1 = k + 1;
                    arrayOfChar[k] = IOUtils.DIGITS[(j >>> 4 & 0xF)];
                    arrayOfChar = this.buf;
                    k = i1 + 1;
                    arrayOfChar[i1] = IOUtils.DIGITS[(j & 0xF)];
                    m += 5;
                  }
                  for (;;)
                  {
                    n += 1;
                    break label2593;
                    break;
                    label2811:
                    arrayOfChar = this.buf;
                    k = i1 + 1;
                    arrayOfChar[i1] = IOUtils.replaceChars[j];
                    m += 1;
                    continue;
                    label2842:
                    if (j == 8232)
                    {
                      arrayOfChar = this.buf;
                      i1 = k + 1;
                      arrayOfChar[k] = '\\';
                      arrayOfChar = this.buf;
                      k = i1 + 1;
                      arrayOfChar[i1] = 'u';
                      arrayOfChar = this.buf;
                      i1 = k + 1;
                      arrayOfChar[k] = IOUtils.DIGITS[(j >>> 12 & 0xF)];
                      arrayOfChar = this.buf;
                      k = i1 + 1;
                      arrayOfChar[i1] = IOUtils.DIGITS[(j >>> 8 & 0xF)];
                      arrayOfChar = this.buf;
                      i1 = k + 1;
                      arrayOfChar[k] = IOUtils.DIGITS[(j >>> 4 & 0xF)];
                      arrayOfChar = this.buf;
                      k = i1 + 1;
                      arrayOfChar[i1] = IOUtils.DIGITS[(j & 0xF)];
                      m += 5;
                    }
                    else
                    {
                      this.buf[k] = j;
                      k += 1;
                    }
                  }
                }
              }
            }
            this.buf[(this.count - 1)] = '"';
            return;
          }
          label3035:
          i3 = i2;
          i2 = i1;
          i1 = k;
          i6 = j;
          n = m;
          m = i6;
          break;
        }
      }
      i6 = m;
      m = i1;
      i1 = i3;
      i3 = n;
      n = i6;
    }
  }
  
  protected void writeStringWithSingleQuote(String paramString)
  {
    int m = 0;
    int i = 0;
    if (paramString == null)
    {
      i = this.count + 4;
      if (i > this.buf.length) {
        expandCapacity(i);
      }
      "null".getChars(0, 4, this.buf, this.count);
      this.count = i;
      return;
    }
    int j = paramString.length();
    int i3 = this.count + j + 2;
    if (i3 > this.buf.length)
    {
      if (this.writer != null)
      {
        write(39);
        if (i < paramString.length())
        {
          j = paramString.charAt(i);
          if ((j <= 13) || (j == 92) || (j == 39) || ((j == 47) && (isEnabled(SerializerFeature.WriteSlashAsSpecial))))
          {
            write(92);
            write(IOUtils.replaceChars[j]);
          }
          for (;;)
          {
            i += 1;
            break;
            write(j);
          }
        }
        write(39);
        return;
      }
      expandCapacity(i3);
    }
    int i1 = this.count + 1;
    int i2 = i1 + j;
    this.buf[this.count] = '\'';
    paramString.getChars(0, j, this.buf, i1);
    this.count = i3;
    int k = -1;
    i = i1;
    j = 0;
    int n;
    if (i < i2)
    {
      n = this.buf[i];
      if ((n > 13) && (n != 92) && (n != 39) && ((n != 47) || (!isEnabled(SerializerFeature.WriteSlashAsSpecial)))) {
        break label589;
      }
      k = j + 1;
      m = n;
      j = i;
    }
    for (;;)
    {
      i += 1;
      n = k;
      k = j;
      j = n;
      break;
      i = i3 + j;
      if (i > this.buf.length) {
        expandCapacity(i);
      }
      this.count = i;
      if (j == 1)
      {
        System.arraycopy(this.buf, k + 1, this.buf, k + 2, i2 - k - 1);
        this.buf[k] = '\\';
        this.buf[(k + 1)] = IOUtils.replaceChars[m];
      }
      for (;;)
      {
        this.buf[(this.count - 1)] = '\'';
        return;
        if (j > 1)
        {
          System.arraycopy(this.buf, k + 1, this.buf, k + 2, i2 - k - 1);
          this.buf[k] = '\\';
          paramString = this.buf;
          i = k + 1;
          paramString[i] = IOUtils.replaceChars[m];
          j = i2 + 1;
          i -= 2;
          while (i >= i1)
          {
            m = this.buf[i];
            if ((m > 13) && (m != 92) && (m != 39))
            {
              k = j;
              if (m == 47)
              {
                k = j;
                if (!isEnabled(SerializerFeature.WriteSlashAsSpecial)) {}
              }
            }
            else
            {
              System.arraycopy(this.buf, i + 1, this.buf, i + 2, j - i - 1);
              this.buf[i] = '\\';
              this.buf[(i + 1)] = IOUtils.replaceChars[m];
              k = j + 1;
            }
            i -= 1;
            j = k;
          }
        }
      }
      label589:
      n = j;
      j = k;
      k = n;
    }
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    writeTo(paramOutputStream, Charset.forName(paramString));
  }
  
  public void writeTo(OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    writeToEx(paramOutputStream, paramCharset);
  }
  
  public void writeTo(Writer paramWriter)
    throws IOException
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    paramWriter.write(this.buf, 0, this.count);
  }
  
  public int writeToEx(OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    if (paramCharset == IOUtils.UTF8) {
      return encodeToUTF8(paramOutputStream);
    }
    paramCharset = new String(this.buf, 0, this.count).getBytes(paramCharset);
    paramOutputStream.write(paramCharset);
    return paramCharset.length;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/SerializeWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */