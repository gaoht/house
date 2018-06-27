package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.util.IOUtils;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

public abstract class JSONLexerBase
  implements JSONLexer, Closeable
{
  protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
  protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
  private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal();
  protected static final int[] digits;
  protected static final char[] typeFieldName = ("\"" + a.c + "\":\"").toCharArray();
  protected int bp;
  protected Calendar calendar = null;
  protected char ch;
  protected int eofPos;
  protected int features;
  protected boolean hasSpecial;
  protected Locale locale = a.b;
  public int matchStat = 0;
  protected int np;
  protected int pos;
  protected char[] sbuf;
  protected int sp;
  protected String stringDefaultValue = null;
  protected TimeZone timeZone = a.a;
  protected int token;
  
  static
  {
    digits = new int[103];
    int i = 48;
    while (i <= 57)
    {
      digits[i] = (i - 48);
      i += 1;
    }
    i = 97;
    while (i <= 102)
    {
      digits[i] = (i - 97 + 10);
      i += 1;
    }
    i = 65;
    while (i <= 70)
    {
      digits[i] = (i - 65 + 10);
      i += 1;
    }
  }
  
  public JSONLexerBase(int paramInt)
  {
    this.features = paramInt;
    if ((Feature.InitStringFieldAsEmpty.mask & paramInt) != 0) {
      this.stringDefaultValue = "";
    }
    this.sbuf = ((char[])SBUF_LOCAL.get());
    if (this.sbuf == null) {
      this.sbuf = new char['Ȁ'];
    }
  }
  
  public static boolean isWhitespace(char paramChar)
  {
    return (paramChar <= ' ') && ((paramChar == ' ') || (paramChar == '\n') || (paramChar == '\r') || (paramChar == '\t') || (paramChar == '\f') || (paramChar == '\b'));
  }
  
  public static String readString(char[] paramArrayOfChar, int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    int n = 0;
    int m = 0;
    if (n < paramInt)
    {
      int i = paramArrayOfChar[n];
      int i1;
      if (i != 92)
      {
        i1 = m + 1;
        arrayOfChar[m] = i;
        m = i1;
      }
      for (;;)
      {
        n += 1;
        break;
        n += 1;
        switch (paramArrayOfChar[n])
        {
        default: 
          throw new d("unclosed.str.lit");
        case '0': 
          i1 = m + 1;
          arrayOfChar[m] = '\000';
          m = i1;
          break;
        case '1': 
          i1 = m + 1;
          arrayOfChar[m] = '\001';
          m = i1;
          break;
        case '2': 
          i1 = m + 1;
          arrayOfChar[m] = '\002';
          m = i1;
          break;
        case '3': 
          i1 = m + 1;
          arrayOfChar[m] = '\003';
          m = i1;
          break;
        case '4': 
          i1 = m + 1;
          arrayOfChar[m] = '\004';
          m = i1;
          break;
        case '5': 
          i1 = m + 1;
          arrayOfChar[m] = '\005';
          m = i1;
          break;
        case '6': 
          i1 = m + 1;
          arrayOfChar[m] = '\006';
          m = i1;
          break;
        case '7': 
          i1 = m + 1;
          arrayOfChar[m] = '\007';
          m = i1;
          break;
        case 'b': 
          i1 = m + 1;
          arrayOfChar[m] = '\b';
          m = i1;
          break;
        case 't': 
          i1 = m + 1;
          arrayOfChar[m] = '\t';
          m = i1;
          break;
        case 'n': 
          i1 = m + 1;
          arrayOfChar[m] = '\n';
          m = i1;
          break;
        case 'v': 
          i1 = m + 1;
          arrayOfChar[m] = '\013';
          m = i1;
          break;
        case 'F': 
        case 'f': 
          i1 = m + 1;
          arrayOfChar[m] = '\f';
          m = i1;
          break;
        case 'r': 
          i1 = m + 1;
          arrayOfChar[m] = '\r';
          m = i1;
          break;
        case '"': 
          i1 = m + 1;
          arrayOfChar[m] = '"';
          m = i1;
          break;
        case '\'': 
          i1 = m + 1;
          arrayOfChar[m] = '\'';
          m = i1;
          break;
        case '/': 
          i1 = m + 1;
          arrayOfChar[m] = '/';
          m = i1;
          break;
        case '\\': 
          i1 = m + 1;
          arrayOfChar[m] = '\\';
          m = i1;
          break;
        case 'x': 
          i1 = m + 1;
          int[] arrayOfInt = digits;
          n += 1;
          int i2 = arrayOfInt[paramArrayOfChar[n]];
          arrayOfInt = digits;
          n += 1;
          arrayOfChar[m] = ((char)(i2 * 16 + arrayOfInt[paramArrayOfChar[n]]));
          m = i1;
          break;
        case 'u': 
          i1 = m + 1;
          n += 1;
          i = paramArrayOfChar[n];
          n += 1;
          int j = paramArrayOfChar[n];
          n += 1;
          int k = paramArrayOfChar[n];
          n += 1;
          arrayOfChar[m] = ((char)Integer.parseInt(new String(new char[] { i, j, k, paramArrayOfChar[n] }), 16));
          m = i1;
        }
      }
    }
    return new String(arrayOfChar, 0, m);
  }
  
  private void scanStringSingleQuote()
  {
    this.np = this.bp;
    this.hasSpecial = false;
    for (;;)
    {
      char c = next();
      if (c == '\'')
      {
        this.token = 4;
        next();
        return;
      }
      if (c == '\032')
      {
        if (!isEOF()) {
          putChar('\032');
        } else {
          throw new d("unclosed single-quote string");
        }
      }
      else
      {
        char[] arrayOfChar;
        if (c == '\\')
        {
          if (!this.hasSpecial)
          {
            this.hasSpecial = true;
            if (this.sp > this.sbuf.length)
            {
              arrayOfChar = new char[this.sp * 2];
              System.arraycopy(this.sbuf, 0, arrayOfChar, 0, this.sbuf.length);
              this.sbuf = arrayOfChar;
            }
            copyTo(this.np + 1, this.sp, this.sbuf);
          }
          c = next();
          switch (c)
          {
          default: 
            this.ch = c;
            throw new d("unclosed single-quote string");
          case '0': 
            putChar('\000');
            break;
          case '1': 
            putChar('\001');
            break;
          case '2': 
            putChar('\002');
            break;
          case '3': 
            putChar('\003');
            break;
          case '4': 
            putChar('\004');
            break;
          case '5': 
            putChar('\005');
            break;
          case '6': 
            putChar('\006');
            break;
          case '7': 
            putChar('\007');
            break;
          case 'b': 
            putChar('\b');
            break;
          case 't': 
            putChar('\t');
            break;
          case 'n': 
            putChar('\n');
            break;
          case 'v': 
            putChar('\013');
            break;
          case 'F': 
          case 'f': 
            putChar('\f');
            break;
          case 'r': 
            putChar('\r');
            break;
          case '"': 
            putChar('"');
            break;
          case '\'': 
            putChar('\'');
            break;
          case '/': 
            putChar('/');
            break;
          case '\\': 
            putChar('\\');
            break;
          case 'x': 
            putChar((char)(digits[next()] * 16 + digits[next()]));
            break;
          case 'u': 
            putChar((char)Integer.parseInt(new String(new char[] { next(), next(), next(), next() }), 16));
            break;
          }
        }
        else if (!this.hasSpecial)
        {
          this.sp += 1;
        }
        else if (this.sp == this.sbuf.length)
        {
          putChar(c);
        }
        else
        {
          arrayOfChar = this.sbuf;
          int i = this.sp;
          this.sp = (i + 1);
          arrayOfChar[i] = c;
        }
      }
    }
  }
  
  public abstract String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable);
  
  protected abstract void arrayCopy(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3);
  
  public abstract byte[] bytesValue();
  
  protected abstract boolean charArrayCompare(char[] paramArrayOfChar);
  
  public abstract char charAt(int paramInt);
  
  public void close()
  {
    if (this.sbuf.length <= 8192) {
      SBUF_LOCAL.set(this.sbuf);
    }
    this.sbuf = null;
  }
  
  public void config(Feature paramFeature, boolean paramBoolean)
  {
    this.features = Feature.config(this.features, paramFeature, paramBoolean);
    if ((this.features & Feature.InitStringFieldAsEmpty.mask) != 0) {
      this.stringDefaultValue = "";
    }
  }
  
  protected abstract void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfChar);
  
  public final Number decimalValue(boolean paramBoolean)
  {
    int i = charAt(this.np + this.sp - 1);
    if (i == 70) {}
    try
    {
      return Float.valueOf(Float.parseFloat(numberString()));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      double d;
      throw new d(localNumberFormatException.getMessage() + ", " + info());
    }
    if (i == 68) {
      return Double.valueOf(Double.parseDouble(numberString()));
    }
    if (paramBoolean) {
      return decimalValue();
    }
    d = doubleValue();
    return Double.valueOf(d);
  }
  
  public abstract BigDecimal decimalValue();
  
  public double doubleValue()
  {
    return Double.parseDouble(numberString());
  }
  
  public float floatValue()
  {
    String str = numberString();
    float f = Float.parseFloat(str);
    if ((f == 0.0F) || (f == Float.POSITIVE_INFINITY))
    {
      int i = str.charAt(0);
      if ((i > 48) && (i <= 57)) {
        throw new d("float overflow : " + str);
      }
    }
    return f;
  }
  
  public Calendar getCalendar()
  {
    return this.calendar;
  }
  
  public final char getCurrent()
  {
    return this.ch;
  }
  
  public Locale getLocale()
  {
    return this.locale;
  }
  
  public TimeZone getTimeZone()
  {
    return this.timeZone;
  }
  
  public abstract int indexOf(char paramChar, int paramInt);
  
  public String info()
  {
    return "";
  }
  
  public final int intValue()
  {
    int j = 0;
    if (this.np == -1) {
      this.np = 0;
    }
    int i = this.np;
    int i1 = this.np + this.sp;
    int k;
    int m;
    int n;
    if (charAt(this.np) == '-')
    {
      k = 1;
      m = Integer.MIN_VALUE;
      i += 1;
      if (i >= i1) {
        break label235;
      }
      j = i + 1;
      n = -(charAt(i) - '0');
      i = j;
      j = n;
    }
    label81:
    label155:
    label235:
    for (;;)
    {
      int i2;
      if (i < i1)
      {
        n = i + 1;
        i2 = charAt(i);
        i = n;
        if (i2 != 76)
        {
          i = n;
          if (i2 != 83)
          {
            if (i2 != 66) {
              break label155;
            }
            i = n;
          }
        }
      }
      for (;;)
      {
        if (k != 0)
        {
          if (i > this.np + 1)
          {
            return j;
            m = -2147483647;
            k = 0;
            break;
            i = i2 - 48;
            if (j < -214748364L) {
              throw new NumberFormatException(numberString());
            }
            j *= 10;
            if (j < m + i) {
              throw new NumberFormatException(numberString());
            }
            j -= i;
            i = n;
            break label81;
          }
          throw new NumberFormatException(numberString());
        }
        return -j;
      }
    }
  }
  
  public final Number integerValue()
    throws NumberFormatException
  {
    long l1 = 0L;
    if (this.np == -1) {
      this.np = 0;
    }
    int k = this.np;
    int i = this.np;
    int j = this.sp + i;
    i = 32;
    int m;
    long l2;
    label101:
    int n;
    switch (charAt(j - 1))
    {
    default: 
      if (charAt(this.np) == '-')
      {
        m = 1;
        l2 = Long.MIN_VALUE;
        k += 1;
        if (k >= j) {
          break label394;
        }
        n = k + 1;
        l1 = -(charAt(k) - '0');
        k = n;
      }
      break;
    }
    label394:
    for (;;)
    {
      if (k < j)
      {
        n = charAt(k) - '0';
        if (l1 < -922337203685477580L)
        {
          return new BigInteger(numberString());
          j -= 1;
          i = 76;
          break;
          j -= 1;
          i = 83;
          break;
          j -= 1;
          i = 66;
          break;
          m = 0;
          l2 = -9223372036854775807L;
          break label101;
        }
        l1 *= 10L;
        if (l1 < n + l2) {
          return new BigInteger(numberString());
        }
        l1 -= n;
        k += 1;
        continue;
      }
      if (m != 0)
      {
        if (k > this.np + 1)
        {
          if ((l1 >= -2147483648L) && (i != 76))
          {
            if (i == 83) {
              return Short.valueOf((short)(int)l1);
            }
            if (i == 66) {
              return Byte.valueOf((byte)(int)l1);
            }
            return Integer.valueOf((int)l1);
          }
          return Long.valueOf(l1);
        }
        throw new NumberFormatException(numberString());
      }
      l1 = -l1;
      if ((l1 <= 2147483647L) && (i != 76))
      {
        if (i == 83) {
          return Short.valueOf((short)(int)l1);
        }
        if (i == 66) {
          return Byte.valueOf((byte)(int)l1);
        }
        return Integer.valueOf((int)l1);
      }
      return Long.valueOf(l1);
    }
  }
  
  public boolean isBlankInput()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      char c = charAt(i);
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
  
  public abstract boolean isEOF();
  
  public final boolean isEnabled(int paramInt)
  {
    return (this.features & paramInt) != 0;
  }
  
  public final boolean isEnabled(int paramInt1, int paramInt2)
  {
    return ((this.features & paramInt2) != 0) || ((paramInt1 & paramInt2) != 0);
  }
  
  public final boolean isEnabled(Feature paramFeature)
  {
    return isEnabled(paramFeature.mask);
  }
  
  public final boolean isRef()
  {
    if (this.sp != 4) {}
    while ((charAt(this.np + 1) != '$') || (charAt(this.np + 2) != 'r') || (charAt(this.np + 3) != 'e') || (charAt(this.np + 4) != 'f')) {
      return false;
    }
    return true;
  }
  
  protected void lexError(String paramString, Object... paramVarArgs)
  {
    this.token = 1;
  }
  
  public final long longValue()
    throws NumberFormatException
  {
    long l1 = 0L;
    if (this.np == -1) {
      this.np = 0;
    }
    int i = this.np;
    int m = this.np + this.sp;
    long l2;
    int j;
    int k;
    if (charAt(this.np) == '-')
    {
      l2 = Long.MIN_VALUE;
      i += 1;
      j = 1;
      if (i >= m) {
        break label240;
      }
      k = i + 1;
      l1 = -(charAt(i) - '0');
      i = k;
    }
    label80:
    label151:
    label240:
    for (;;)
    {
      int n;
      if (i < m)
      {
        k = i + 1;
        n = charAt(i);
        i = k;
        if (n != 76)
        {
          i = k;
          if (n != 83)
          {
            if (n != 66) {
              break label151;
            }
            i = k;
          }
        }
      }
      for (;;)
      {
        if (j != 0)
        {
          if (i > this.np + 1)
          {
            return l1;
            l2 = -9223372036854775807L;
            j = 0;
            break;
            i = n - 48;
            if (l1 < -922337203685477580L) {
              throw new NumberFormatException(numberString());
            }
            l1 *= 10L;
            if (l1 < i + l2) {
              throw new NumberFormatException(numberString());
            }
            l1 -= i;
            i = k;
            break label80;
          }
          throw new NumberFormatException(numberString());
        }
        return -l1;
      }
    }
  }
  
  public final boolean matchField(char[] paramArrayOfChar)
  {
    if (!charArrayCompare(paramArrayOfChar)) {
      return false;
    }
    this.bp += paramArrayOfChar.length;
    this.ch = charAt(this.bp);
    if (this.ch == '{')
    {
      next();
      this.token = 12;
    }
    for (;;)
    {
      return true;
      if (this.ch == '[')
      {
        next();
        this.token = 14;
      }
      else if ((this.ch == 'S') && (charAt(this.bp + 1) == 'e') && (charAt(this.bp + 2) == 't') && (charAt(this.bp + 3) == '['))
      {
        this.bp += 3;
        this.ch = charAt(this.bp);
        this.token = 21;
      }
      else
      {
        nextToken();
      }
    }
  }
  
  public final int matchStat()
  {
    return this.matchStat;
  }
  
  public abstract char next();
  
  public final void nextIdent()
  {
    while (isWhitespace(this.ch)) {
      next();
    }
    if ((this.ch == '_') || (Character.isLetter(this.ch)))
    {
      scanIdent();
      return;
    }
    nextToken();
  }
  
  public final void nextToken()
  {
    this.sp = 0;
    for (;;)
    {
      this.pos = this.bp;
      if (this.ch == '/')
      {
        skipComment();
      }
      else
      {
        if (this.ch == '"')
        {
          scanString();
          return;
        }
        if (this.ch == ',')
        {
          next();
          this.token = 16;
          return;
        }
        if ((this.ch >= '0') && (this.ch <= '9'))
        {
          scanNumber();
          return;
        }
        if (this.ch == '-')
        {
          scanNumber();
          return;
        }
        switch (this.ch)
        {
        default: 
          if (isEOF()) {
            if (this.token == 20) {
              throw new d("EOF error");
            }
          }
        case '\'': 
          if (!isEnabled(Feature.AllowSingleQuotes)) {
            throw new d("Feature.AllowSingleQuotes is false");
          }
          scanStringSingleQuote();
          return;
        case '\b': 
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
          next();
          break;
        case 't': 
          scanTrue();
          return;
        case 'f': 
          scanFalse();
          return;
        case 'n': 
          scanNullOrNew();
          return;
        case 'N': 
        case 'S': 
        case 'T': 
        case 'u': 
          scanIdent();
          return;
        case '(': 
          next();
          this.token = 10;
          return;
        case ')': 
          next();
          this.token = 11;
          return;
        case '[': 
          next();
          this.token = 14;
          return;
        case ']': 
          next();
          this.token = 15;
          return;
        case '{': 
          next();
          this.token = 12;
          return;
        case '}': 
          next();
          this.token = 13;
          return;
        case ':': 
          next();
          this.token = 17;
          return;
          this.token = 20;
          int i = this.eofPos;
          this.bp = i;
          this.pos = i;
          return;
          if ((this.ch > '\037') && (this.ch != '')) {
            break label497;
          }
          next();
        }
      }
    }
    label497:
    lexError("illegal.char", new Object[] { String.valueOf(this.ch) });
    next();
  }
  
  public final void nextToken(int paramInt)
  {
    this.sp = 0;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.ch == ' ') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b'))
      {
        next();
        break;
        if (this.ch == '{')
        {
          this.token = 12;
          next();
          return;
        }
        if (this.ch == '[')
        {
          this.token = 14;
          next();
          return;
          if (this.ch == ',')
          {
            this.token = 16;
            next();
            return;
          }
          if (this.ch == '}')
          {
            this.token = 13;
            next();
            return;
          }
          if (this.ch == ']')
          {
            this.token = 15;
            next();
            return;
          }
          if (this.ch == '\032')
          {
            this.token = 20;
            return;
            if ((this.ch >= '0') && (this.ch <= '9'))
            {
              this.pos = this.bp;
              scanNumber();
              return;
            }
            if (this.ch == '"')
            {
              this.pos = this.bp;
              scanString();
              return;
            }
            if (this.ch == '[')
            {
              this.token = 14;
              next();
              return;
            }
            if (this.ch == '{')
            {
              this.token = 12;
              next();
              return;
              if (this.ch == '"')
              {
                this.pos = this.bp;
                scanString();
                return;
              }
              if ((this.ch >= '0') && (this.ch <= '9'))
              {
                this.pos = this.bp;
                scanNumber();
                return;
              }
              if (this.ch == '[')
              {
                this.token = 14;
                next();
                return;
              }
              if (this.ch == '{')
              {
                this.token = 12;
                next();
                return;
                if (this.ch == '[')
                {
                  this.token = 14;
                  next();
                  return;
                }
                if (this.ch == '{')
                {
                  this.token = 12;
                  next();
                  return;
                  if (this.ch == ']')
                  {
                    this.token = 15;
                    next();
                    return;
                  }
                  if (this.ch == '\032')
                  {
                    this.token = 20;
                    return;
                    nextIdent();
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
    nextToken();
  }
  
  public final void nextTokenWithChar(char paramChar)
  {
    this.sp = 0;
    for (;;)
    {
      if (this.ch == paramChar)
      {
        next();
        nextToken();
        return;
      }
      if ((this.ch != ' ') && (this.ch != '\n') && (this.ch != '\r') && (this.ch != '\t') && (this.ch != '\f') && (this.ch != '\b')) {
        break;
      }
      next();
    }
    throw new d("not match " + paramChar + " - " + this.ch);
  }
  
  public final void nextTokenWithColon()
  {
    nextTokenWithChar(':');
  }
  
  public final void nextTokenWithColon(int paramInt)
  {
    nextTokenWithChar(':');
  }
  
  public abstract String numberString();
  
  public final int pos()
  {
    return this.pos;
  }
  
  protected final void putChar(char paramChar)
  {
    if (this.sp == this.sbuf.length)
    {
      arrayOfChar = new char[this.sbuf.length * 2];
      System.arraycopy(this.sbuf, 0, arrayOfChar, 0, this.sbuf.length);
      this.sbuf = arrayOfChar;
    }
    char[] arrayOfChar = this.sbuf;
    int i = this.sp;
    this.sp = (i + 1);
    arrayOfChar[i] = paramChar;
  }
  
  public final void resetStringPosition()
  {
    this.sp = 0;
  }
  
  public boolean scanBoolean(char paramChar)
  {
    boolean bool = false;
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    int j;
    int i;
    if (c == 't') {
      if ((charAt(this.bp + 1) == 'r') && (charAt(this.bp + 1 + 1) == 'u') && (charAt(this.bp + 1 + 2) == 'e'))
      {
        j = this.bp;
        i = 5;
        c = charAt(j + 4);
        bool = true;
      }
    }
    for (;;)
    {
      if (c == paramChar)
      {
        this.bp += i;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        return bool;
        this.matchStat = -1;
        return false;
        if (c == 'f')
        {
          if ((charAt(this.bp + 1) == 'a') && (charAt(this.bp + 1 + 1) == 'l') && (charAt(this.bp + 1 + 2) == 's') && (charAt(this.bp + 1 + 3) == 'e'))
          {
            j = this.bp;
            i = 6;
            c = charAt(j + 5);
            continue;
          }
          this.matchStat = -1;
          return false;
        }
        if (c == '1')
        {
          c = charAt(this.bp + 1);
          i = 2;
          bool = true;
          continue;
        }
        if (c == '0')
        {
          c = charAt(this.bp + 1);
          i = 2;
        }
      }
      else
      {
        if (isWhitespace(c))
        {
          c = charAt(this.bp + i);
          i += 1;
          continue;
        }
        this.matchStat = -1;
        return bool;
      }
      i = 1;
    }
  }
  
  public final double scanDouble(char paramChar)
  {
    this.matchStat = 0;
    char c1 = this.bp;
    char c2 = '\001';
    c1 = charAt(c1 + '\000');
    double d;
    if ((c1 >= '0') && (c1 <= '9'))
    {
      char c4;
      for (;;)
      {
        c3 = this.bp;
        c1 = c2 + '\001';
        c4 = charAt(c2 + c3);
        if ((c4 < '0') || (c4 > '9')) {
          break;
        }
        c2 = c1;
      }
      c2 = c4;
      char c3 = c1;
      if (c4 == '.')
      {
        c3 = this.bp;
        c2 = c1 + '\001';
        c1 = charAt(c1 + c3);
        if ((c1 >= '0') && (c1 <= '9')) {
          for (;;)
          {
            c3 = this.bp;
            c1 = c2 + '\001';
            c4 = charAt(c2 + c3);
            c2 = c4;
            c3 = c1;
            if (c4 < '0') {
              break;
            }
            c2 = c4;
            c3 = c1;
            if (c4 > '9') {
              break;
            }
            c2 = c1;
          }
        }
        this.matchStat = -1;
        return 0.0D;
      }
      c1 = this.bp;
      d = Double.parseDouble(subString(c1, this.bp + c3 - c1 - 1));
      if (c2 == paramChar)
      {
        this.bp += c3;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        return d;
      }
    }
    else
    {
      this.matchStat = -1;
      return 0.0D;
    }
    this.matchStat = -1;
    return d;
  }
  
  public Enum<?> scanEnum(Class<?> paramClass, SymbolTable paramSymbolTable, char paramChar)
  {
    paramSymbolTable = scanSymbolWithSeperator(paramSymbolTable, paramChar);
    if (paramSymbolTable == null) {
      return null;
    }
    return Enum.valueOf(paramClass, paramSymbolTable);
  }
  
  public final void scanFalse()
  {
    if (this.ch != 'f') {
      throw new d("error parse false");
    }
    next();
    if (this.ch != 'a') {
      throw new d("error parse false");
    }
    next();
    if (this.ch != 'l') {
      throw new d("error parse false");
    }
    next();
    if (this.ch != 's') {
      throw new d("error parse false");
    }
    next();
    if (this.ch != 'e') {
      throw new d("error parse false");
    }
    next();
    if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b') || (this.ch == ':') || (this.ch == '/'))
    {
      this.token = 7;
      return;
    }
    throw new d("scan false error");
  }
  
  public boolean scanFieldBoolean(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      return false;
    }
    int j = paramArrayOfChar.length;
    int k = this.bp;
    int i = j + 1;
    j = charAt(j + k);
    if (j == 116)
    {
      k = this.bp;
      j = i + 1;
      if (charAt(k + i) != 'r')
      {
        this.matchStat = -1;
        return false;
      }
      i = this.bp;
      k = j + 1;
      if (charAt(i + j) != 'u')
      {
        this.matchStat = -1;
        return false;
      }
      j = this.bp;
      i = k + 1;
      if (charAt(j + k) != 'e')
      {
        this.matchStat = -1;
        return false;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      k = this.bp;
      j = i + 1;
      i = charAt(i + k);
      if (i != 44) {
        break label338;
      }
      this.bp += j;
      this.ch = charAt(this.bp);
      this.matchStat = 3;
      this.token = 16;
      return bool;
      if (j != 102) {
        break;
      }
      k = this.bp;
      j = i + 1;
      if (charAt(k + i) != 'a')
      {
        this.matchStat = -1;
        return false;
      }
      k = this.bp;
      i = j + 1;
      if (charAt(k + j) != 'l')
      {
        this.matchStat = -1;
        return false;
      }
      j = this.bp;
      k = i + 1;
      if (charAt(j + i) != 's')
      {
        this.matchStat = -1;
        return false;
      }
      if (charAt(k + this.bp) != 'e')
      {
        this.matchStat = -1;
        return false;
      }
      i = k + 1;
    }
    this.matchStat = -1;
    return false;
    label338:
    if (i == 125)
    {
      k = this.bp;
      i = j + 1;
      j = charAt(k + j);
      if (j == 44)
      {
        this.token = 16;
        this.bp += i;
        this.ch = charAt(this.bp);
      }
      for (;;)
      {
        this.matchStat = 4;
        return bool;
        if (j == 93)
        {
          this.token = 15;
          this.bp += i;
          this.ch = charAt(this.bp);
        }
        else if (j == 125)
        {
          this.token = 13;
          this.bp += i;
          this.ch = charAt(this.bp);
        }
        else
        {
          if (j != 26) {
            break;
          }
          this.token = 20;
          this.bp += i - 1;
          this.ch = '\032';
        }
      }
      this.matchStat = -1;
      return false;
    }
    this.matchStat = -1;
    return false;
  }
  
  public final double scanFieldDouble(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      return 0.0D;
    }
    int j = paramArrayOfChar.length;
    int k = this.bp;
    int i = j + 1;
    j = charAt(j + k);
    int m;
    if ((j >= 48) && (j <= 57))
    {
      for (;;)
      {
        j = this.bp;
        k = i + 1;
        m = charAt(i + j);
        if ((m < 48) || (m > 57)) {
          break;
        }
        i = k;
      }
      j = m;
      i = k;
      if (m == 46)
      {
        j = this.bp;
        i = k + 1;
        j = charAt(k + j);
        if ((j >= 48) && (j <= 57)) {
          for (;;)
          {
            j = this.bp;
            k = i + 1;
            m = charAt(i + j);
            j = m;
            i = k;
            if (m < 48) {
              break;
            }
            j = m;
            i = k;
            if (m > 57) {
              break;
            }
            i = k;
          }
        }
        this.matchStat = -1;
        return 0.0D;
      }
      if (j != 101)
      {
        m = j;
        k = i;
        if (j != 69) {}
      }
      else
      {
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if ((i != 43) && (i != 45)) {
          break label648;
        }
        k = this.bp;
        i = j + 1;
        k = charAt(k + j);
        j = i;
        i = k;
      }
    }
    label648:
    for (;;)
    {
      m = i;
      k = j;
      if (i >= 48)
      {
        m = i;
        k = j;
        if (i <= 57)
        {
          i = charAt(this.bp + j);
          j += 1;
          continue;
        }
      }
      i = this.bp + paramArrayOfChar.length;
      double d = Double.parseDouble(subString(i, this.bp + k - i - 1));
      if (m == 44)
      {
        this.bp += k;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        return d;
        this.matchStat = -1;
        return 0.0D;
      }
      if (m == 125)
      {
        j = this.bp;
        i = k + 1;
        j = charAt(j + k);
        if (j == 44)
        {
          this.token = 16;
          this.bp += i;
          this.ch = charAt(this.bp);
        }
        for (;;)
        {
          this.matchStat = 4;
          return d;
          if (j == 93)
          {
            this.token = 15;
            this.bp += i;
            this.ch = charAt(this.bp);
          }
          else if (j == 125)
          {
            this.token = 13;
            this.bp += i;
            this.ch = charAt(this.bp);
          }
          else
          {
            if (j != 26) {
              break;
            }
            this.token = 20;
            this.bp += i - 1;
            this.ch = '\032';
          }
        }
        this.matchStat = -1;
        return 0.0D;
      }
      this.matchStat = -1;
      return 0.0D;
    }
  }
  
  public final float scanFieldFloat(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      return 0.0F;
    }
    int j = paramArrayOfChar.length;
    int k = this.bp;
    int i = j + 1;
    j = charAt(j + k);
    float f;
    if ((j >= 48) && (j <= 57))
    {
      int m;
      for (;;)
      {
        k = this.bp;
        j = i + 1;
        m = charAt(i + k);
        if ((m < 48) || (m > 57)) {
          break;
        }
        i = j;
      }
      k = m;
      i = j;
      if (m == 46)
      {
        k = this.bp;
        i = j + 1;
        j = charAt(j + k);
        if ((j >= 48) && (j <= 57)) {
          for (;;)
          {
            k = this.bp;
            j = i + 1;
            m = charAt(i + k);
            k = m;
            i = j;
            if (m < 48) {
              break;
            }
            k = m;
            i = j;
            if (m > 57) {
              break;
            }
            i = j;
          }
        }
        this.matchStat = -1;
        return 0.0F;
      }
      j = this.bp + paramArrayOfChar.length;
      f = Float.parseFloat(subString(j, this.bp + i - j - 1));
      if (k == 44)
      {
        this.bp += i;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        return f;
      }
    }
    else
    {
      this.matchStat = -1;
      return 0.0F;
    }
    if (k == 125)
    {
      k = this.bp;
      j = i + 1;
      i = charAt(k + i);
      if (i == 44)
      {
        this.token = 16;
        this.bp += j;
        this.ch = charAt(this.bp);
      }
      for (;;)
      {
        this.matchStat = 4;
        return f;
        if (i == 93)
        {
          this.token = 15;
          this.bp += j;
          this.ch = charAt(this.bp);
        }
        else if (i == 125)
        {
          this.token = 13;
          this.bp += j;
          this.ch = charAt(this.bp);
        }
        else
        {
          if (i != 26) {
            break;
          }
          this.bp += j - 1;
          this.token = 20;
          this.ch = '\032';
        }
      }
      this.matchStat = -1;
      return 0.0F;
    }
    this.matchStat = -1;
    return 0.0F;
  }
  
  public final float[] scanFieldFloatArray(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      return null;
    }
    int i = paramArrayOfChar.length;
    int k = this.bp;
    int j = i + 1;
    if (charAt(i + k) != '[')
    {
      this.matchStat = -2;
      return null;
    }
    k = this.bp;
    i = j + 1;
    j = charAt(k + j);
    paramArrayOfChar = new float[16];
    int n = 0;
    int i5 = this.bp + i - 1;
    if (j == 45) {}
    int m;
    for (int i1 = 1;; i1 = 0)
    {
      k = j;
      j = i;
      if (i1 != 0)
      {
        k = charAt(this.bp + i);
        j = i + 1;
      }
      if ((k < 48) || (k > 57)) {
        break label737;
      }
      i = k - 48;
      for (k = j;; k = j)
      {
        m = this.bp;
        j = k + 1;
        m = charAt(k + m);
        if ((m < 48) || (m > 57)) {
          break;
        }
        i = i * 10 + (m - 48);
      }
    }
    if (m == 46) {
      k = 1;
    }
    int i2;
    int i3;
    while (k != 0)
    {
      k = charAt(this.bp + j);
      if ((k >= 48) && (k <= 57))
      {
        m = j + 1;
        j = 10;
        i = i * 10 + (k - 48);
        for (;;)
        {
          i2 = this.bp;
          k = m + 1;
          m = charAt(m + i2);
          if ((m < 48) || (m > 57)) {
            break;
          }
          i = i * 10 + (m - 48);
          j *= 10;
          m = k;
        }
        k = 0;
      }
      else
      {
        this.matchStat = -1;
        return null;
        i3 = i;
        i2 = j;
        i = k;
        j = m;
      }
    }
    for (;;)
    {
      int i4;
      if ((j == 101) || (j == 69))
      {
        i4 = 1;
        label389:
        m = j;
        k = i;
        if (i4 == 0) {
          break label514;
        }
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if ((i != 43) && (i != 45)) {
          break label941;
        }
        k = this.bp;
        i = j + 1;
        k = charAt(k + j);
        j = i;
        i = k;
      }
      label514:
      label554:
      label737:
      label938:
      label941:
      for (;;)
      {
        m = i;
        k = j;
        if (i >= 48)
        {
          m = i;
          k = j;
          if (i <= 57)
          {
            i = charAt(this.bp + j);
            j += 1;
            continue;
            i4 = 0;
            break label389;
          }
        }
        i = this.bp + k - i5 - 1;
        float f;
        if ((i4 == 0) && (i < 10))
        {
          f = i3 / i2;
          if (i1 == 0) {
            break label938;
          }
          f = -f;
        }
        for (;;)
        {
          float[] arrayOfFloat;
          if (n >= paramArrayOfChar.length)
          {
            arrayOfFloat = new float[paramArrayOfChar.length * 3 / 2];
            System.arraycopy(paramArrayOfChar, 0, arrayOfFloat, 0, n);
            paramArrayOfChar = arrayOfFloat;
          }
          for (;;)
          {
            i1 = n + 1;
            paramArrayOfChar[n] = f;
            if (m == 44)
            {
              j = this.bp;
              i = k + 1;
              j = charAt(j + k);
            }
            for (;;)
            {
              n = i1;
              break;
              f = Float.parseFloat(subString(i5, i));
              break label554;
              if (m == 93)
              {
                j = this.bp;
                i = k + 1;
                j = charAt(j + k);
                if (i1 != paramArrayOfChar.length)
                {
                  arrayOfFloat = new float[i1];
                  System.arraycopy(paramArrayOfChar, 0, arrayOfFloat, 0, i1);
                  paramArrayOfChar = arrayOfFloat;
                }
                for (;;)
                {
                  if (j == 44)
                  {
                    this.bp += i - 1;
                    next();
                    this.matchStat = 3;
                    this.token = 16;
                    return paramArrayOfChar;
                    this.matchStat = -1;
                    return null;
                  }
                  if (j == 125)
                  {
                    k = this.bp;
                    j = i + 1;
                    i = charAt(k + i);
                    if (i == 44)
                    {
                      this.token = 16;
                      this.bp += j - 1;
                      next();
                    }
                    for (;;)
                    {
                      this.matchStat = 4;
                      return paramArrayOfChar;
                      if (i == 93)
                      {
                        this.token = 15;
                        this.bp += j - 1;
                        next();
                      }
                      else if (i == 125)
                      {
                        this.token = 13;
                        this.bp += j - 1;
                        next();
                      }
                      else
                      {
                        if (i != 26) {
                          break;
                        }
                        this.bp += j - 1;
                        this.token = 20;
                        this.ch = '\032';
                      }
                    }
                    this.matchStat = -1;
                    return null;
                  }
                  this.matchStat = -1;
                  return null;
                }
              }
              j = m;
              i = k;
            }
          }
        }
      }
      i2 = 1;
      i3 = i;
      i = m;
      k = j;
      j = i;
      i = k;
    }
  }
  
  public final float[][] scanFieldFloatArray2(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      return (float[][])null;
    }
    int i = paramArrayOfChar.length;
    int k = this.bp;
    int j = i + 1;
    if (charAt(i + k) != '[')
    {
      this.matchStat = -2;
      return (float[][])null;
    }
    k = this.bp;
    i = j + 1;
    j = charAt(k + j);
    Object localObject1 = new float[16][];
    int n = 0;
    int i1;
    label137:
    int i6;
    int i2;
    int m;
    int i3;
    int i4;
    if (j == 91)
    {
      k = this.bp;
      j = i + 1;
      k = charAt(k + i);
      paramArrayOfChar = new float[16];
      i1 = 0;
      i = j;
      j = k;
      i6 = this.bp + i - 1;
      if (j == 45) {}
      for (i2 = 1;; i2 = 0)
      {
        k = j;
        j = i;
        if (i2 != 0)
        {
          k = charAt(this.bp + i);
          j = i + 1;
        }
        if ((k < 48) || (k > 57)) {
          break label830;
        }
        i = k - 48;
        for (k = j;; k = j)
        {
          m = this.bp;
          j = k + 1;
          k = charAt(k + m);
          if ((k < 48) || (k > 57)) {
            break;
          }
          i = i * 10 + (k - 48);
        }
      }
      if (k != 46) {
        break label1146;
      }
      k = charAt(this.bp + j);
      if ((k >= 48) && (k <= 57))
      {
        i = k - 48 + i * 10;
        k = 10;
        m = j + 1;
        j = k;
        for (;;)
        {
          i3 = this.bp;
          k = m + 1;
          m = charAt(m + i3);
          if ((m < 48) || (m > 57)) {
            break;
          }
          i = i * 10 + (m - 48);
          j *= 10;
          m = k;
        }
      }
      this.matchStat = -1;
      return (float[][])null;
      i4 = i;
      i3 = j;
      i = k;
      j = m;
    }
    for (;;)
    {
      int i5;
      if ((j == 101) || (j == 69))
      {
        i5 = 1;
        label433:
        m = j;
        k = i;
        if (i5 == 0) {
          break label558;
        }
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if ((i != 43) && (i != 45)) {
          break label1143;
        }
        k = this.bp;
        i = j + 1;
        k = charAt(k + j);
        j = i;
        i = k;
      }
      label558:
      label598:
      label830:
      label1140:
      label1143:
      for (;;)
      {
        m = i;
        k = j;
        if (i >= 48)
        {
          m = i;
          k = j;
          if (i <= 57)
          {
            i = charAt(this.bp + j);
            j += 1;
            continue;
            i5 = 0;
            break label433;
          }
        }
        i = this.bp + k - i6 - 1;
        float f;
        if ((i5 == 0) && (i < 10))
        {
          f = i4 / i3;
          if (i2 == 0) {
            break label1140;
          }
          f = -f;
        }
        for (;;)
        {
          Object localObject2;
          if (i1 >= paramArrayOfChar.length)
          {
            localObject2 = new float[paramArrayOfChar.length * 3 / 2];
            System.arraycopy(paramArrayOfChar, 0, localObject2, 0, i1);
            paramArrayOfChar = (char[])localObject2;
          }
          for (;;)
          {
            i2 = i1 + 1;
            paramArrayOfChar[i1] = f;
            if (m == 44)
            {
              j = this.bp;
              i = k + 1;
              j = charAt(j + k);
            }
            for (;;)
            {
              i1 = i2;
              break label137;
              f = Float.parseFloat(subString(i6, i));
              break label598;
              if (m == 93)
              {
                j = this.bp;
                i = k + 1;
                j = charAt(j + k);
                localObject2 = paramArrayOfChar;
                if (i2 != paramArrayOfChar.length)
                {
                  localObject2 = new float[i2];
                  System.arraycopy(paramArrayOfChar, 0, localObject2, 0, i2);
                }
                if (n >= localObject1.length)
                {
                  paramArrayOfChar = new float[localObject1.length * 3 / 2][];
                  System.arraycopy(localObject2, 0, paramArrayOfChar, 0, i2);
                }
                for (;;)
                {
                  k = n + 1;
                  paramArrayOfChar[n] = localObject2;
                  if (j == 44)
                  {
                    m = this.bp;
                    j = i + 1;
                    m = charAt(m + i);
                    i = j;
                    j = m;
                  }
                  for (;;)
                  {
                    n = k;
                    localObject1 = paramArrayOfChar;
                    break;
                    break;
                    this.matchStat = -1;
                    return (float[][])null;
                    if (j == 93)
                    {
                      m = this.bp;
                      j = i + 1;
                      i = charAt(m + i);
                      localObject1 = paramArrayOfChar;
                      if (k != paramArrayOfChar.length)
                      {
                        localObject1 = new float[k][];
                        System.arraycopy(paramArrayOfChar, 0, localObject1, 0, k);
                      }
                      if (i == 44)
                      {
                        this.bp += j - 1;
                        next();
                        this.matchStat = 3;
                        this.token = 16;
                        return (float[][])localObject1;
                      }
                      if (i == 125)
                      {
                        k = this.bp;
                        i = j + 1;
                        j = charAt(k + j);
                        if (j == 44)
                        {
                          this.token = 16;
                          this.bp += i - 1;
                          next();
                        }
                        for (;;)
                        {
                          this.matchStat = 4;
                          return (float[][])localObject1;
                          if (j == 93)
                          {
                            this.token = 15;
                            this.bp += i - 1;
                            next();
                          }
                          else if (j == 125)
                          {
                            this.token = 13;
                            this.bp += i - 1;
                            next();
                          }
                          else
                          {
                            if (j != 26) {
                              break;
                            }
                            this.bp += i - 1;
                            this.token = 20;
                            this.ch = '\032';
                          }
                        }
                        this.matchStat = -1;
                        return (float[][])null;
                      }
                      this.matchStat = -1;
                      return (float[][])null;
                    }
                  }
                  paramArrayOfChar = (char[])localObject1;
                }
              }
              j = m;
              i = k;
            }
          }
        }
      }
      label1146:
      i3 = 1;
      i4 = i;
      i = k;
      k = j;
      j = i;
      i = k;
    }
  }
  
  public int scanFieldInt(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      k = 0;
      return k;
    }
    int j = paramArrayOfChar.length;
    int k = this.bp;
    int i = j + 1;
    k = charAt(j + k);
    label57:
    int m;
    if (k == 45)
    {
      j = 1;
      if (j == 0) {
        break label495;
      }
      m = this.bp;
      k = i + 1;
      m = charAt(m + i);
      i = k;
      k = m;
    }
    label236:
    label481:
    label495:
    for (;;)
    {
      int n;
      if ((k >= 48) && (k <= 57))
      {
        m = k - 48;
        k = i;
        i = m;
        for (;;)
        {
          n = this.bp;
          m = k + 1;
          k = charAt(k + n);
          if ((k < 48) || (k > 57)) {
            break;
          }
          i = i * 10 + (k - 48);
          k = m;
        }
        j = 0;
        break label57;
        if (k == 46)
        {
          this.matchStat = -1;
          return 0;
        }
        if (((i >= 0) && (m <= paramArrayOfChar.length + 14)) || ((i == Integer.MIN_VALUE) && (m == 17) && (j != 0))) {
          break label236;
        }
        this.matchStat = -1;
        return 0;
      }
      this.matchStat = -1;
      return 0;
      if (k == 44)
      {
        this.bp += m;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        k = i;
        if (j == 0) {
          break;
        }
        return -i;
      }
      if (k == 125)
      {
        n = this.bp;
        k = m + 1;
        m = charAt(n + m);
        if (m == 44)
        {
          this.token = 16;
          this.bp += k;
          this.ch = charAt(this.bp);
        }
        for (;;)
        {
          this.matchStat = 4;
          k = i;
          if (j == 0) {
            break;
          }
          return -i;
          if (m == 93)
          {
            this.token = 15;
            this.bp += k;
            this.ch = charAt(this.bp);
          }
          else if (m == 125)
          {
            this.token = 13;
            this.bp += k;
            this.ch = charAt(this.bp);
          }
          else
          {
            if (m != 26) {
              break label481;
            }
            this.token = 20;
            this.bp += k - 1;
            this.ch = '\032';
          }
        }
        this.matchStat = -1;
        return 0;
      }
      this.matchStat = -1;
      return 0;
    }
  }
  
  public final int[] scanFieldIntArray(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      return null;
    }
    int i = paramArrayOfChar.length;
    int k = this.bp;
    int j = i + 1;
    if (charAt(i + k) != '[')
    {
      this.matchStat = -2;
      return null;
    }
    k = this.bp;
    i = j + 1;
    j = charAt(k + j);
    paramArrayOfChar = new int[16];
    label126:
    label193:
    int n;
    int i1;
    int i2;
    int m;
    if (j == 93)
    {
      k = charAt(this.bp + i);
      i += 1;
      j = 0;
      if (j != paramArrayOfChar.length)
      {
        int[] arrayOfInt = new int[j];
        System.arraycopy(paramArrayOfChar, 0, arrayOfInt, 0, j);
        paramArrayOfChar = arrayOfInt;
        if (k == 44)
        {
          this.bp += i - 1;
          next();
          this.matchStat = 3;
          this.token = 16;
          return paramArrayOfChar;
          if (k < paramArrayOfChar.length) {
            break label573;
          }
          arrayOfInt = new int[paramArrayOfChar.length * 3 / 2];
          System.arraycopy(paramArrayOfChar, 0, arrayOfInt, 0, k);
          paramArrayOfChar = arrayOfInt;
          n = k + 1;
          i1 = i;
          if (j != 0) {
            i1 = -i;
          }
          paramArrayOfChar[k] = i1;
          if (i2 == 44)
          {
            j = charAt(this.bp + m);
            i = m + 1;
          }
        }
      }
    }
    label240:
    for (k = n;; k = 0)
    {
      if (j == 45)
      {
        m = charAt(this.bp + i);
        j = 1;
        i += 1;
      }
      for (;;)
      {
        if ((m >= 48) && (m <= 57))
        {
          m -= 48;
          n = i;
          i = m;
          for (;;)
          {
            i1 = this.bp;
            m = n + 1;
            i2 = charAt(n + i1);
            if ((i2 < 48) || (i2 > 57)) {
              break;
            }
            i = i * 10 + (i2 - 48);
            n = m;
          }
          if (i2 != 93) {
            break label564;
          }
          k = charAt(this.bp + m);
          j = n;
          i = m + 1;
          break;
        }
        this.matchStat = -1;
        return null;
        if (k == 125)
        {
          k = this.bp;
          j = i + 1;
          i = charAt(k + i);
          if (i == 44)
          {
            this.token = 16;
            this.bp += j - 1;
            next();
          }
          for (;;)
          {
            this.matchStat = 4;
            return paramArrayOfChar;
            if (i == 93)
            {
              this.token = 15;
              this.bp += j - 1;
              next();
            }
            else if (i == 125)
            {
              this.token = 13;
              this.bp += j - 1;
              next();
            }
            else
            {
              if (i != 26) {
                break;
              }
              this.bp += j - 1;
              this.token = 20;
              this.ch = '\032';
            }
          }
          this.matchStat = -1;
          return null;
        }
        this.matchStat = -1;
        return null;
        break label126;
        label564:
        j = i2;
        i = m;
        break label240;
        label573:
        break label193;
        n = 0;
        m = j;
        j = n;
      }
    }
  }
  
  public long scanFieldLong(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    long l2;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      l2 = 0L;
      return l2;
    }
    int j = paramArrayOfChar.length;
    int k = this.bp;
    int i = j + 1;
    k = charAt(j + k);
    int m;
    if (k == 45)
    {
      j = this.bp;
      m = i + 1;
      k = charAt(j + i);
      j = 1;
      i = m;
    }
    for (;;)
    {
      long l1;
      if ((k >= 48) && (k <= 57))
      {
        l1 = k - 48;
        for (;;)
        {
          m = this.bp;
          k = i + 1;
          i = charAt(i + m);
          if ((i < 48) || (i > 57)) {
            break;
          }
          l1 = l1 * 10L + (i - 48);
          i = k;
        }
        if (i == 46)
        {
          this.matchStat = -1;
          return 0L;
        }
        if ((l1 < 0L) || (k > 21))
        {
          this.matchStat = -1;
          return 0L;
        }
      }
      else
      {
        this.matchStat = -1;
        return 0L;
      }
      if (i == 44)
      {
        this.bp += k;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        l2 = l1;
        if (j == 0) {
          break;
        }
        return -l1;
      }
      if (i == 125)
      {
        m = this.bp;
        i = k + 1;
        k = charAt(m + k);
        if (k == 44)
        {
          this.token = 16;
          this.bp += i;
          this.ch = charAt(this.bp);
        }
        for (;;)
        {
          this.matchStat = 4;
          l2 = l1;
          if (j == 0) {
            break;
          }
          return -l1;
          if (k == 93)
          {
            this.token = 15;
            this.bp += i;
            this.ch = charAt(this.bp);
          }
          else if (k == 125)
          {
            this.token = 13;
            this.bp += i;
            this.ch = charAt(this.bp);
          }
          else
          {
            if (k != 26) {
              break label436;
            }
            this.token = 20;
            this.bp += i - 1;
            this.ch = '\032';
          }
        }
        label436:
        this.matchStat = -1;
        return 0L;
      }
      this.matchStat = -1;
      return 0L;
      j = 0;
    }
  }
  
  public String scanFieldString(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      return stringDefaultValue();
    }
    int m = paramArrayOfChar.length;
    if (charAt(m + this.bp) != '"')
    {
      this.matchStat = -1;
      return stringDefaultValue();
    }
    int i = indexOf('"', this.bp + paramArrayOfChar.length + 1);
    if (i == -1) {
      throw new d("unclosed str");
    }
    int j = this.bp + paramArrayOfChar.length + 1;
    String str = subString(j, i - j);
    int k;
    if (str.indexOf('\\') != -1)
    {
      j = i - 1;
      k = 0;
      while ((j >= 0) && (charAt(j) == '\\'))
      {
        k += 1;
        j -= 1;
      }
      if (k % 2 == 0)
      {
        j = i - (this.bp + paramArrayOfChar.length + 1);
        str = readString(sub_chars(this.bp + paramArrayOfChar.length + 1, j), j);
      }
    }
    for (;;)
    {
      j = i - (this.bp + paramArrayOfChar.length + 1) + 1 + (m + 1);
      k = this.bp;
      i = j + 1;
      j = charAt(j + k);
      if (j == 44)
      {
        this.bp += i;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        return str;
        i = indexOf('"', i + 1);
        break;
      }
      if (j == 125)
      {
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if (i == 44)
        {
          this.token = 16;
          this.bp += j;
          this.ch = charAt(this.bp);
        }
        for (;;)
        {
          this.matchStat = 4;
          return str;
          if (i == 93)
          {
            this.token = 15;
            this.bp += j;
            this.ch = charAt(this.bp);
          }
          else if (i == 125)
          {
            this.token = 13;
            this.bp += j;
            this.ch = charAt(this.bp);
          }
          else
          {
            if (i != 26) {
              break;
            }
            this.token = 20;
            this.bp += j - 1;
            this.ch = '\032';
          }
        }
        this.matchStat = -1;
        return stringDefaultValue();
      }
      this.matchStat = -1;
      return stringDefaultValue();
    }
  }
  
  public Collection<String> scanFieldStringArray(char[] paramArrayOfChar, Class<?> paramClass)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      return null;
    }
    if (paramClass.isAssignableFrom(HashSet.class)) {
      paramClass = new HashSet();
    }
    int k;
    int j;
    for (;;)
    {
      i = paramArrayOfChar.length;
      k = this.bp;
      j = i + 1;
      if (charAt(i + k) != '[')
      {
        this.matchStat = -1;
        return null;
        if (paramClass.isAssignableFrom(ArrayList.class))
        {
          paramClass = new ArrayList();
          continue;
        }
        try
        {
          paramClass = (Collection)paramClass.newInstance();
        }
        catch (Exception paramArrayOfChar)
        {
          throw new d(paramArrayOfChar.getMessage(), paramArrayOfChar);
        }
      }
    }
    int i = charAt(this.bp + j);
    j += 1;
    if (i == 34)
    {
      i = indexOf('"', this.bp + j);
      if (i == -1) {
        throw new d("unclosed str");
      }
      k = this.bp + j;
      paramArrayOfChar = subString(k, i - k);
      if (paramArrayOfChar.indexOf('\\') == -1) {
        break label780;
      }
      label203:
      int m = 0;
      k = i - 1;
      while ((k >= 0) && (charAt(k) == '\\'))
      {
        m += 1;
        k -= 1;
      }
      if (m % 2 == 0)
      {
        k = i - (this.bp + j);
        paramArrayOfChar = readString(sub_chars(this.bp + j, k), k);
      }
    }
    label780:
    for (;;)
    {
      j = i - (this.bp + j) + 1 + j;
      k = this.bp;
      i = j + 1;
      j = charAt(j + k);
      paramClass.add(paramArrayOfChar);
      for (;;)
      {
        if (j == 44)
        {
          j = charAt(this.bp + i);
          k = i + 1;
          i = j;
          j = k;
          break;
          i = indexOf('"', i + 1);
          break label203;
          if ((i == 110) && (charAt(this.bp + j) == 'u') && (charAt(this.bp + j + 1) == 'l') && (charAt(this.bp + j + 2) == 'l'))
          {
            i = j + 3;
            j = charAt(i + this.bp);
            paramClass.add(null);
            i += 1;
          }
          else if ((i == 93) && (paramClass.size() == 0))
          {
            k = this.bp;
            i = j + 1;
            j = charAt(k + j);
          }
        }
      }
      while (j == 44)
      {
        this.bp += i;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        return paramClass;
        throw new d("illega str");
        if (j == 93)
        {
          j = this.bp;
          k = i + 1;
          j = charAt(j + i);
          i = k;
        }
        else
        {
          this.matchStat = -1;
          return null;
        }
      }
      if (j == 125)
      {
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if (i == 44)
        {
          this.token = 16;
          this.bp += j;
          this.ch = charAt(this.bp);
        }
        for (;;)
        {
          this.matchStat = 4;
          return paramClass;
          if (i == 93)
          {
            this.token = 15;
            this.bp += j;
            this.ch = charAt(this.bp);
          }
          else if (i == 125)
          {
            this.token = 13;
            this.bp += j;
            this.ch = charAt(this.bp);
          }
          else
          {
            if (i != 26) {
              break;
            }
            this.bp += j - 1;
            this.token = 20;
            this.ch = '\032';
          }
        }
        this.matchStat = -1;
        return null;
      }
      this.matchStat = -1;
      return null;
    }
  }
  
  public long scanFieldSymbol(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfChar))
    {
      this.matchStat = -2;
      return 0L;
    }
    int j = paramArrayOfChar.length;
    int k = this.bp;
    int i = j + 1;
    if (charAt(j + k) != '"')
    {
      this.matchStat = -1;
      return 0L;
    }
    long l = -2128831035L;
    for (;;)
    {
      k = this.bp;
      j = i + 1;
      i = charAt(i + k);
      if (i == 34)
      {
        k = this.bp;
        i = j + 1;
        j = charAt(k + j);
        if (j == 44)
        {
          this.bp += i;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          return l;
        }
      }
      else
      {
        l = (l ^ i) * 16777619L;
        if (i != 92) {
          break label351;
        }
        this.matchStat = -1;
        return 0L;
      }
      if (j == 125)
      {
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if (i == 44)
        {
          this.token = 16;
          this.bp += j;
          this.ch = charAt(this.bp);
        }
        for (;;)
        {
          this.matchStat = 4;
          return l;
          if (i == 93)
          {
            this.token = 15;
            this.bp += j;
            this.ch = charAt(this.bp);
          }
          else if (i == 125)
          {
            this.token = 13;
            this.bp += j;
            this.ch = charAt(this.bp);
          }
          else
          {
            if (i != 26) {
              break;
            }
            this.token = 20;
            this.bp += j - 1;
            this.ch = '\032';
          }
        }
        this.matchStat = -1;
        return 0L;
      }
      this.matchStat = -1;
      return 0L;
      label351:
      i = j;
    }
  }
  
  public final float scanFloat(char paramChar)
  {
    this.matchStat = 0;
    char c1 = this.bp;
    char c2 = '\001';
    c1 = charAt(c1 + '\000');
    float f;
    if ((c1 >= '0') && (c1 <= '9'))
    {
      char c4;
      for (;;)
      {
        c3 = this.bp;
        c1 = c2 + '\001';
        c4 = charAt(c2 + c3);
        if ((c4 < '0') || (c4 > '9')) {
          break;
        }
        c2 = c1;
      }
      c2 = c4;
      char c3 = c1;
      if (c4 == '.')
      {
        c3 = this.bp;
        c2 = c1 + '\001';
        c1 = charAt(c1 + c3);
        if ((c1 >= '0') && (c1 <= '9')) {
          for (;;)
          {
            c3 = this.bp;
            c1 = c2 + '\001';
            c4 = charAt(c2 + c3);
            c2 = c4;
            c3 = c1;
            if (c4 < '0') {
              break;
            }
            c2 = c4;
            c3 = c1;
            if (c4 > '9') {
              break;
            }
            c2 = c1;
          }
        }
        this.matchStat = -1;
        return 0.0F;
      }
      c1 = this.bp;
      f = Float.parseFloat(subString(c1, this.bp + c3 - c1 - 1));
      if (c2 == paramChar)
      {
        this.bp += c3;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        return f;
      }
    }
    else
    {
      this.matchStat = -1;
      return 0.0F;
    }
    this.matchStat = -1;
    return f;
  }
  
  public final void scanIdent()
  {
    this.np = (this.bp - 1);
    this.hasSpecial = false;
    do
    {
      this.sp += 1;
      next();
    } while (Character.isLetterOrDigit(this.ch));
    String str = stringVal();
    if ("null".equalsIgnoreCase(str))
    {
      this.token = 8;
      return;
    }
    if ("new".equals(str))
    {
      this.token = 9;
      return;
    }
    if ("true".equals(str))
    {
      this.token = 6;
      return;
    }
    if ("false".equals(str))
    {
      this.token = 7;
      return;
    }
    if ("undefined".equals(str))
    {
      this.token = 23;
      return;
    }
    if ("Set".equals(str))
    {
      this.token = 21;
      return;
    }
    if ("TreeSet".equals(str))
    {
      this.token = 22;
      return;
    }
    this.token = 18;
  }
  
  public int scanInt(char paramChar)
  {
    char c2 = '\001';
    this.matchStat = 0;
    int j = charAt(this.bp + 0);
    if (j == 45) {}
    char c3;
    char c1;
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        j = this.bp;
        c2 = '\002';
        j = charAt(j + 1);
      }
      if ((j < 48) || (j > 57)) {
        break label162;
      }
      c3 = j - 48;
      j = c2;
      c2 = c3;
      for (;;)
      {
        int k = this.bp;
        c3 = j + 1;
        c1 = charAt(j + k);
        if ((c1 < '0') || (c1 > '9')) {
          break;
        }
        c2 = c2 * '\n' + (c1 - '0');
        j = c3;
      }
    }
    if (c1 == '.')
    {
      this.matchStat = -1;
      paramChar = '\000';
    }
    label162:
    do
    {
      do
      {
        return paramChar;
        if (c2 < 0)
        {
          this.matchStat = -1;
          return 0;
          this.matchStat = -1;
          return 0;
        }
        while (c1 != paramChar)
        {
          if (!isWhitespace(c1)) {
            break;
          }
          c1 = charAt(this.bp + c3);
          c3 += '\001';
        }
        this.bp += c3;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        paramChar = c2;
      } while (i == 0);
      return -c2;
      this.matchStat = -1;
      paramChar = c2;
    } while (i == 0);
    return -c2;
  }
  
  public long scanLong(char paramChar)
  {
    int i = 1;
    this.matchStat = 0;
    int k = charAt(this.bp + 0);
    if (k == 45) {}
    long l1;
    char c;
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        k = this.bp;
        i = 2;
        k = charAt(k + 1);
      }
      if ((k < 48) || (k > 57)) {
        break label163;
      }
      l1 = k - 48;
      for (;;)
      {
        int m = this.bp;
        k = i + 1;
        c = charAt(i + m);
        if ((c < '0') || (c > '9')) {
          break;
        }
        l1 = l1 * 10L + (c - '0');
        i = k;
      }
    }
    long l2;
    if (c == '.')
    {
      this.matchStat = -1;
      l2 = 0L;
    }
    label163:
    do
    {
      return l2;
      if (l1 < 0L)
      {
        this.matchStat = -1;
        return 0L;
        this.matchStat = -1;
        return 0L;
      }
      while (c != paramChar)
      {
        if (!isWhitespace(c)) {
          break;
        }
        c = charAt(this.bp + k);
        k += 1;
      }
      this.bp += k;
      this.ch = charAt(this.bp);
      this.matchStat = 3;
      this.token = 16;
      l2 = l1;
    } while (j == 0);
    return -l1;
    this.matchStat = -1;
    return l1;
  }
  
  public final void scanNullOrNew()
  {
    if (this.ch != 'n') {
      throw new d("error parse null or new");
    }
    next();
    if (this.ch == 'u')
    {
      next();
      if (this.ch != 'l') {
        throw new d("error parse null");
      }
      next();
      if (this.ch != 'l') {
        throw new d("error parse null");
      }
      next();
      if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b'))
      {
        this.token = 8;
        return;
      }
      throw new d("scan null error");
    }
    if (this.ch != 'e') {
      throw new d("error parse new");
    }
    next();
    if (this.ch != 'w') {
      throw new d("error parse new");
    }
    next();
    if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b'))
    {
      this.token = 9;
      return;
    }
    throw new d("scan new error");
  }
  
  public final void scanNumber()
  {
    this.np = this.bp;
    if (this.ch == '-')
    {
      this.sp += 1;
      next();
    }
    while ((this.ch >= '0') && (this.ch <= '9'))
    {
      this.sp += 1;
      next();
    }
    int i = 0;
    if (this.ch == '.')
    {
      this.sp += 1;
      next();
      while ((this.ch >= '0') && (this.ch <= '9'))
      {
        this.sp += 1;
        next();
      }
      i = 1;
    }
    if (this.ch == 'L')
    {
      this.sp += 1;
      next();
    }
    while (i != 0)
    {
      this.token = 3;
      return;
      if (this.ch == 'S')
      {
        this.sp += 1;
        next();
      }
      else if (this.ch == 'B')
      {
        this.sp += 1;
        next();
      }
      else if (this.ch == 'F')
      {
        this.sp += 1;
        next();
        i = 1;
      }
      else if (this.ch == 'D')
      {
        this.sp += 1;
        next();
        i = 1;
      }
      else if ((this.ch == 'e') || (this.ch == 'E'))
      {
        this.sp += 1;
        next();
        if ((this.ch == '+') || (this.ch == '-'))
        {
          this.sp += 1;
          next();
        }
        while ((this.ch >= '0') && (this.ch <= '9'))
        {
          this.sp += 1;
          next();
        }
        if ((this.ch == 'D') || (this.ch == 'F'))
        {
          this.sp += 1;
          next();
        }
        i = 1;
      }
    }
    this.token = 2;
  }
  
  public String scanString(char paramChar)
  {
    this.matchStat = 0;
    int i = charAt(this.bp + 0);
    if (i == 110)
    {
      if ((charAt(this.bp + 1) == 'u') && (charAt(this.bp + 1 + 1) == 'l') && (charAt(this.bp + 1 + 2) == 'l'))
      {
        if (charAt(this.bp + 4) == paramChar)
        {
          this.bp += 5;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          return null;
        }
      }
      else
      {
        this.matchStat = -1;
        return null;
      }
      this.matchStat = -1;
      return null;
    }
    if (i != 34)
    {
      this.matchStat = -1;
      return stringDefaultValue();
    }
    int m = this.bp + 1;
    i = indexOf('"', m);
    if (i == -1) {
      throw new d("unclosed str");
    }
    String str = subString(this.bp + 1, i - m);
    if (str.indexOf('\\') != -1)
    {
      int j = i - 1;
      int k = 0;
      while ((j >= 0) && (charAt(j) == '\\'))
      {
        k += 1;
        j -= 1;
      }
      if (k % 2 == 0)
      {
        j = i - m;
        str = readString(sub_chars(this.bp + 1, j), j);
      }
    }
    for (;;)
    {
      i = i - (this.bp + 1) + 1 + 1;
      if (charAt(i + this.bp) == paramChar)
      {
        this.bp += i + 1;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        return str;
        i = indexOf('"', i + 1);
        break;
      }
      this.matchStat = -1;
      return str;
    }
  }
  
  public final void scanString()
  {
    this.np = this.bp;
    this.hasSpecial = false;
    for (;;)
    {
      char c = next();
      if (c == '"')
      {
        this.token = 4;
        this.ch = next();
        return;
      }
      if (c == '\032')
      {
        if (!isEOF()) {
          putChar('\032');
        } else {
          throw new d("unclosed string : " + c);
        }
      }
      else
      {
        int i;
        char[] arrayOfChar;
        if (c == '\\')
        {
          int j;
          if (!this.hasSpecial)
          {
            this.hasSpecial = true;
            if (this.sp >= this.sbuf.length)
            {
              j = this.sbuf.length * 2;
              i = j;
              if (this.sp > j) {
                i = this.sp;
              }
              arrayOfChar = new char[i];
              System.arraycopy(this.sbuf, 0, arrayOfChar, 0, this.sbuf.length);
              this.sbuf = arrayOfChar;
            }
            copyTo(this.np + 1, this.sp, this.sbuf);
          }
          c = next();
          switch (c)
          {
          default: 
            this.ch = c;
            throw new d("unclosed string : " + c);
          case '0': 
            putChar('\000');
            break;
          case '1': 
            putChar('\001');
            break;
          case '2': 
            putChar('\002');
            break;
          case '3': 
            putChar('\003');
            break;
          case '4': 
            putChar('\004');
            break;
          case '5': 
            putChar('\005');
            break;
          case '6': 
            putChar('\006');
            break;
          case '7': 
            putChar('\007');
            break;
          case 'b': 
            putChar('\b');
            break;
          case 't': 
            putChar('\t');
            break;
          case 'n': 
            putChar('\n');
            break;
          case 'v': 
            putChar('\013');
            break;
          case 'F': 
          case 'f': 
            putChar('\f');
            break;
          case 'r': 
            putChar('\r');
            break;
          case '"': 
            putChar('"');
            break;
          case '\'': 
            putChar('\'');
            break;
          case '/': 
            putChar('/');
            break;
          case '\\': 
            putChar('\\');
            break;
          case 'x': 
            i = next();
            j = next();
            putChar((char)(digits[i] * 16 + digits[j]));
            break;
          case 'u': 
            putChar((char)Integer.parseInt(new String(new char[] { next(), next(), next(), next() }), 16));
            break;
          }
        }
        else if (!this.hasSpecial)
        {
          this.sp += 1;
        }
        else if (this.sp == this.sbuf.length)
        {
          putChar(c);
        }
        else
        {
          arrayOfChar = this.sbuf;
          i = this.sp;
          this.sp = (i + 1);
          arrayOfChar[i] = c;
        }
      }
    }
  }
  
  public void scanStringArray(Collection<String> paramCollection, char paramChar)
  {
    this.matchStat = 0;
    char c1 = charAt(this.bp + 0);
    if ((c1 == 'n') && (charAt(this.bp + 1) == 'u') && (charAt(this.bp + 1 + 1) == 'l') && (charAt(this.bp + 1 + 2) == 'l') && (charAt(this.bp + 1 + 3) == paramChar))
    {
      this.bp += 5;
      this.ch = charAt(this.bp);
      this.matchStat = 5;
      return;
    }
    if (c1 != '[')
    {
      this.matchStat = -1;
      return;
    }
    c1 = charAt(this.bp + 1);
    char c3;
    for (char c2 = '\002'; (c1 == 'n') && (charAt(this.bp + c2) == 'u') && (charAt(this.bp + c2 + 1) == 'l') && (charAt(this.bp + c2 + 2) == 'l'); c2 = c3)
    {
      c1 = c2 + '\003';
      c2 = charAt(c1 + this.bp);
      paramCollection.add(null);
      c1 += '\001';
      if (c2 != ',') {
        break label548;
      }
      c2 = charAt(this.bp + c1);
      c3 = c1 + '\001';
      c1 = c2;
    }
    label305:
    String str;
    if ((c1 == ']') && (paramCollection.size() == 0))
    {
      c3 = this.bp;
      c1 = c2 + '\001';
      c3 = charAt(c3 + c2);
      c2 = c1;
      c1 = c3;
      if (c1 == paramChar)
      {
        this.bp += c2;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
      }
    }
    else
    {
      if (c1 != '"')
      {
        this.matchStat = -1;
        return;
      }
      char c4 = this.bp + c2;
      c1 = indexOf('"', c4);
      if (c1 == '￿') {
        throw new d("unclosed str");
      }
      str = subString(this.bp + c2, c1 - c4);
      if (str.indexOf('\\') == -1) {
        break label590;
      }
      label413:
      c3 = c1 - '\001';
      int i = 0;
      while ((c3 >= 0) && (charAt(c3) == '\\'))
      {
        i += 1;
        c3 -= '\001';
      }
      if (i % 2 == 0)
      {
        c3 = c1 - c4;
        str = readString(sub_chars(this.bp + c2, c3), c3);
      }
    }
    label548:
    label590:
    for (;;)
    {
      c2 = c1 - (this.bp + c2) + 1 + c2;
      c3 = this.bp;
      c1 = c2 + '\001';
      c2 = charAt(c2 + c3);
      paramCollection.add(str);
      break;
      c1 = indexOf('"', c1 + '\001');
      break label413;
      if (c2 == ']')
      {
        c3 = this.bp;
        c2 = c1 + '\001';
        c1 = charAt(c3 + c1);
        break label305;
      }
      this.matchStat = -1;
      return;
      this.matchStat = -1;
      return;
    }
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable)
  {
    skipWhitespace();
    if (this.ch == '"') {
      return scanSymbol(paramSymbolTable, '"');
    }
    if (this.ch == '\'')
    {
      if (!isEnabled(Feature.AllowSingleQuotes)) {
        throw new d("syntax error");
      }
      return scanSymbol(paramSymbolTable, '\'');
    }
    if (this.ch == '}')
    {
      next();
      this.token = 13;
      return null;
    }
    if (this.ch == ',')
    {
      next();
      this.token = 16;
      return null;
    }
    if (this.ch == '\032')
    {
      this.token = 20;
      return null;
    }
    if (!isEnabled(Feature.AllowUnQuotedFieldNames)) {
      throw new d("syntax error");
    }
    return scanSymbolUnQuoted(paramSymbolTable);
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable, char paramChar)
  {
    this.np = this.bp;
    this.sp = 0;
    int j = 0;
    int i = 0;
    char c1 = next();
    if (c1 == paramChar)
    {
      this.token = 4;
      if (j != 0) {
        break label1010;
      }
      if (this.np != -1) {
        break label1000;
      }
      paramChar = '\000';
    }
    label49:
    label1000:
    label1010:
    for (paramSymbolTable = addSymbol(paramChar, this.sp, i, paramSymbolTable);; paramSymbolTable = paramSymbolTable.addSymbol(this.sbuf, 0, this.sp, i))
    {
      this.sp = 0;
      next();
      return paramSymbolTable;
      if (c1 == '\032') {
        throw new d("unclosed.str");
      }
      if (c1 == '\\')
      {
        k = j;
        if (j == 0)
        {
          if (this.sp >= this.sbuf.length)
          {
            k = this.sbuf.length * 2;
            j = k;
            if (this.sp > k) {
              j = this.sp;
            }
            arrayOfChar = new char[j];
            System.arraycopy(this.sbuf, 0, arrayOfChar, 0, this.sbuf.length);
            this.sbuf = arrayOfChar;
          }
          arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
          k = 1;
        }
        c1 = next();
        switch (c1)
        {
        default: 
          this.ch = c1;
          throw new d("unclosed.str.lit");
        case '0': 
          i = i * 31 + c1;
          putChar('\000');
          j = k;
          break;
        case '1': 
          i = i * 31 + c1;
          putChar('\001');
          j = k;
          break;
        case '2': 
          i = i * 31 + c1;
          putChar('\002');
          j = k;
          break;
        case '3': 
          i = i * 31 + c1;
          putChar('\003');
          j = k;
          break;
        case '4': 
          i = i * 31 + c1;
          putChar('\004');
          j = k;
          break;
        case '5': 
          i = i * 31 + c1;
          putChar('\005');
          j = k;
          break;
        case '6': 
          i = i * 31 + c1;
          putChar('\006');
          j = k;
          break;
        case '7': 
          i = i * 31 + c1;
          putChar('\007');
          j = k;
          break;
        case 'b': 
          i = i * 31 + 8;
          putChar('\b');
          j = k;
          break;
        case 't': 
          i = i * 31 + 9;
          putChar('\t');
          j = k;
          break;
        case 'n': 
          i = i * 31 + 10;
          putChar('\n');
          j = k;
          break;
        case 'v': 
          i = i * 31 + 11;
          putChar('\013');
          j = k;
          break;
        case 'F': 
        case 'f': 
          i = i * 31 + 12;
          putChar('\f');
          j = k;
          break;
        case 'r': 
          i = i * 31 + 13;
          putChar('\r');
          j = k;
          break;
        case '"': 
          i = i * 31 + 34;
          putChar('"');
          j = k;
          break;
        case '\'': 
          i = i * 31 + 39;
          putChar('\'');
          j = k;
          break;
        case '/': 
          i = i * 31 + 47;
          putChar('/');
          j = k;
          break;
        case '\\': 
          i = i * 31 + 92;
          putChar('\\');
          j = k;
          break;
        case 'x': 
          c1 = next();
          this.ch = c1;
          char c2 = next();
          this.ch = c2;
          c1 = (char)(digits[c1] * 16 + digits[c2]);
          i = i * 31 + c1;
          putChar(c1);
          j = k;
          break;
        case 'u': 
          j = Integer.parseInt(new String(new char[] { next(), next(), next(), next() }), 16);
          i = i * 31 + j;
          putChar((char)j);
          j = k;
          break;
        }
      }
      i = i * 31 + c1;
      if (j == 0)
      {
        this.sp += 1;
        break;
      }
      if (this.sp == this.sbuf.length)
      {
        putChar(c1);
        break;
      }
      char[] arrayOfChar = this.sbuf;
      int k = this.sp;
      this.sp = (k + 1);
      arrayOfChar[k] = c1;
      break;
      paramChar = this.np + 1;
      break label49;
    }
  }
  
  public final String scanSymbolUnQuoted(SymbolTable paramSymbolTable)
  {
    boolean[] arrayOfBoolean = IOUtils.firstIdentifierFlags;
    int j = this.ch;
    if ((this.ch >= arrayOfBoolean.length) || (arrayOfBoolean[j] != 0)) {}
    for (int i = 1; i == 0; i = 0) {
      throw new d("illegal identifier : " + this.ch + info());
    }
    arrayOfBoolean = IOUtils.identifierFlags;
    this.np = this.bp;
    this.sp = 1;
    i = j;
    for (;;)
    {
      j = next();
      if ((j < arrayOfBoolean.length) && (arrayOfBoolean[j] == 0))
      {
        this.ch = charAt(this.bp);
        this.token = 18;
        if ((this.sp != 4) || (i != 3392903) || (charAt(this.np) != 'n') || (charAt(this.np + 1) != 'u') || (charAt(this.np + 2) != 'l') || (charAt(this.np + 3) != 'l')) {
          break;
        }
        return null;
      }
      i = i * 31 + j;
      this.sp += 1;
    }
    return addSymbol(this.np, this.sp, i, paramSymbolTable);
  }
  
  public String scanSymbolWithSeperator(SymbolTable paramSymbolTable, char paramChar)
  {
    int i = 0;
    this.matchStat = 0;
    int k = this.bp;
    int j = 1;
    k = charAt(k + 0);
    if (k == 110)
    {
      if ((charAt(this.bp + 1) == 'u') && (charAt(this.bp + 1 + 1) == 'l') && (charAt(this.bp + 1 + 2) == 'l'))
      {
        if (charAt(this.bp + 4) == paramChar)
        {
          this.bp += 5;
          this.ch = charAt(this.bp);
          this.matchStat = 3;
          return null;
        }
      }
      else
      {
        this.matchStat = -1;
        return null;
      }
      this.matchStat = -1;
      return null;
    }
    if (k != 34)
    {
      this.matchStat = -1;
      return null;
      j = k;
    }
    int m = this.bp;
    k = j + 1;
    j = charAt(j + m);
    char c;
    if (j == 34)
    {
      j = this.bp + 0 + 1;
      paramSymbolTable = addSymbol(j, this.bp + k - j - 1, i, paramSymbolTable);
      c = charAt(this.bp + k);
      i = k + 1;
    }
    for (;;)
    {
      if (c == paramChar)
      {
        this.bp += i;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        return paramSymbolTable;
        i = i * 31 + j;
        if (j != 92) {
          break;
        }
        this.matchStat = -1;
        return null;
      }
      if (!isWhitespace(c)) {
        break label325;
      }
      c = charAt(this.bp + i);
      i += 1;
    }
    label325:
    this.matchStat = -1;
    return paramSymbolTable;
  }
  
  public final void scanTrue()
  {
    if (this.ch != 't') {
      throw new d("error parse true");
    }
    next();
    if (this.ch != 'r') {
      throw new d("error parse true");
    }
    next();
    if (this.ch != 'u') {
      throw new d("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new d("error parse true");
    }
    next();
    if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b') || (this.ch == ':') || (this.ch == '/'))
    {
      this.token = 6;
      return;
    }
    throw new d("scan true error");
  }
  
  public final int scanType(String paramString)
  {
    int i = 0;
    this.matchStat = 0;
    if (!charArrayCompare(typeFieldName)) {
      return -2;
    }
    int j = this.bp + typeFieldName.length;
    int k = paramString.length();
    while (i < k)
    {
      if (paramString.charAt(i) != charAt(j + i)) {
        return -1;
      }
      i += 1;
    }
    i = j + k;
    if (charAt(i) != '"') {
      return -1;
    }
    j = i + 1;
    this.ch = charAt(j);
    if (this.ch == ',')
    {
      i = j + 1;
      this.ch = charAt(i);
      this.bp = i;
      this.token = 16;
      return 3;
    }
    i = j;
    if (this.ch == '}')
    {
      i = j + 1;
      this.ch = charAt(i);
      if (this.ch != ',') {
        break label198;
      }
      this.token = 16;
      i += 1;
      this.ch = charAt(i);
    }
    for (;;)
    {
      this.matchStat = 4;
      this.bp = i;
      return this.matchStat;
      label198:
      if (this.ch == ']')
      {
        this.token = 15;
        i += 1;
        this.ch = charAt(i);
      }
      else if (this.ch == '}')
      {
        this.token = 13;
        i += 1;
        this.ch = charAt(i);
      }
      else
      {
        if (this.ch != '\032') {
          break;
        }
        this.token = 20;
      }
    }
    return -1;
  }
  
  public void setLocale(Locale paramLocale)
  {
    this.locale = paramLocale;
  }
  
  public void setTimeZone(TimeZone paramTimeZone)
  {
    this.timeZone = paramTimeZone;
  }
  
  public void setToken(int paramInt)
  {
    this.token = paramInt;
  }
  
  protected void skipComment()
  {
    next();
    if (this.ch == '/')
    {
      do
      {
        next();
      } while (this.ch != '\n');
      next();
    }
    for (;;)
    {
      return;
      if (this.ch != '*') {
        break;
      }
      next();
      while (this.ch != '\032') {
        if (this.ch == '*')
        {
          next();
          if (this.ch == '/') {
            next();
          }
        }
        else
        {
          next();
        }
      }
    }
    throw new d("invalid comment");
  }
  
  public final void skipWhitespace()
  {
    while (this.ch <= '/') {
      if ((this.ch == ' ') || (this.ch == '\r') || (this.ch == '\n') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b'))
      {
        next();
      }
      else
      {
        if (this.ch != '/') {
          break;
        }
        skipComment();
      }
    }
  }
  
  public final String stringDefaultValue()
  {
    return this.stringDefaultValue;
  }
  
  public abstract String stringVal();
  
  public abstract String subString(int paramInt1, int paramInt2);
  
  protected abstract char[] sub_chars(int paramInt1, int paramInt2);
  
  public final int token()
  {
    return this.token;
  }
  
  public final String tokenName()
  {
    return JSONToken.name(this.token);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/JSONLexerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */