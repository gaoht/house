package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.TimeZone;

public final class JSONScanner
  extends JSONLexerBase
{
  private final int len;
  private final String text;
  
  public JSONScanner(String paramString)
  {
    this(paramString, a.f);
  }
  
  public JSONScanner(String paramString, int paramInt)
  {
    super(paramInt);
    this.text = paramString;
    this.len = this.text.length();
    this.bp = -1;
    next();
    if (this.ch == 65279) {
      next();
    }
  }
  
  public JSONScanner(char[] paramArrayOfChar, int paramInt)
  {
    this(paramArrayOfChar, paramInt, a.f);
  }
  
  public JSONScanner(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this(new String(paramArrayOfChar, 0, paramInt1), paramInt2);
  }
  
  static boolean charArrayCompare(String paramString, int paramInt, char[] paramArrayOfChar)
  {
    int j = paramArrayOfChar.length;
    if (j + paramInt > paramString.length()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label45;
      }
      if (paramArrayOfChar[i] != paramString.charAt(paramInt + i)) {
        break;
      }
      i += 1;
    }
    label45:
    return true;
  }
  
  static boolean checkDate(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, int paramInt1, int paramInt2)
  {
    if ((paramChar1 != '1') && (paramChar1 != '2')) {}
    label71:
    do
    {
      do
      {
        do
        {
          return false;
        } while ((paramChar2 < '0') || (paramChar2 > '9') || (paramChar3 < '0') || (paramChar3 > '9') || (paramChar4 < '0') || (paramChar4 > '9'));
        if (paramChar5 != '0') {
          break;
        }
      } while ((paramChar6 < '1') || (paramChar6 > '9'));
      if (paramInt1 != 48) {
        break label124;
      }
    } while ((paramInt2 < 49) || (paramInt2 > 57));
    label124:
    label154:
    do
    {
      do
      {
        return true;
        if (paramChar5 != '1') {
          break;
        }
        if ((paramChar6 == '0') || (paramChar6 == '1') || (paramChar6 == '2')) {
          break label71;
        }
        return false;
        if ((paramInt1 != 49) && (paramInt1 != 50)) {
          break label154;
        }
        if (paramInt2 < 48) {
          break;
        }
      } while (paramInt2 <= 57);
      return false;
      if (paramInt1 != 51) {
        break;
      }
    } while ((paramInt2 == 48) || (paramInt2 == 49));
    return false;
  }
  
  private boolean checkTime(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6)
  {
    if (paramChar1 == '0') {
      if ((paramChar2 >= '0') && (paramChar2 <= '9')) {
        break label38;
      }
    }
    label38:
    label64:
    do
    {
      do
      {
        do
        {
          return false;
          if (paramChar1 != '1') {
            break;
          }
        } while ((paramChar2 < '0') || (paramChar2 > '9'));
        if ((paramChar3 < '0') || (paramChar3 > '5')) {
          break label114;
        }
      } while ((paramChar4 < '0') || (paramChar4 > '9'));
      if ((paramChar5 < '0') || (paramChar5 > '5')) {
        break label129;
      }
    } while ((paramChar6 < '0') || (paramChar6 > '9'));
    label114:
    label129:
    do
    {
      return true;
      if ((paramChar1 != '2') || (paramChar2 < '0')) {
        break;
      }
      if (paramChar2 <= '4') {
        break label38;
      }
      return false;
      if (paramChar3 != '6') {
        break;
      }
      if (paramChar4 == '0') {
        break label64;
      }
      return false;
      if (paramChar5 != '6') {
        break;
      }
    } while (paramChar6 == '0');
    return false;
  }
  
  private void setCalendar(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, char paramChar7, char paramChar8)
  {
    this.calendar = Calendar.getInstance(this.timeZone, this.locale);
    this.calendar.set(1, (paramChar1 - '0') * 1000 + (paramChar2 - '0') * 100 + (paramChar3 - '0') * 10 + (paramChar4 - '0'));
    this.calendar.set(2, (paramChar5 - '0') * 10 + (paramChar6 - '0') - 1);
    this.calendar.set(5, (paramChar7 - '0') * 10 + (paramChar8 - '0'));
  }
  
  public final String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable)
  {
    return paramSymbolTable.addSymbol(this.text, paramInt1, paramInt2, paramInt3);
  }
  
  protected final void arrayCopy(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    this.text.getChars(paramInt1, paramInt1 + paramInt3, paramArrayOfChar, paramInt2);
  }
  
  public byte[] bytesValue()
  {
    return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
  }
  
  public final boolean charArrayCompare(char[] paramArrayOfChar)
  {
    return charArrayCompare(this.text, this.bp, paramArrayOfChar);
  }
  
  public final char charAt(int paramInt)
  {
    if (paramInt >= this.len) {
      return '\032';
    }
    return this.text.charAt(paramInt);
  }
  
  protected final void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    this.text.getChars(paramInt1, paramInt1 + paramInt2, paramArrayOfChar, 0);
  }
  
  public final BigDecimal decimalValue()
  {
    int k = charAt(this.np + this.sp - 1);
    int j = this.sp;
    int i;
    if ((k != 76) && (k != 83) && (k != 66) && (k != 70))
    {
      i = j;
      if (k != 68) {}
    }
    else
    {
      i = j - 1;
    }
    j = this.np;
    if (i < this.sbuf.length)
    {
      this.text.getChars(j, j + i, this.sbuf, 0);
      return new BigDecimal(this.sbuf, 0, i);
    }
    char[] arrayOfChar = new char[i];
    this.text.getChars(j, i + j, arrayOfChar, 0);
    return new BigDecimal(arrayOfChar);
  }
  
  public final int indexOf(char paramChar, int paramInt)
  {
    return this.text.indexOf(paramChar, paramInt);
  }
  
  public String info()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("pos ").append(this.bp).append(", json : ");
    if (this.text.length() < 65536) {}
    for (String str = this.text;; str = this.text.substring(0, 65536)) {
      return str;
    }
  }
  
  public boolean isEOF()
  {
    return (this.bp == this.len) || ((this.ch == '\032') && (this.bp + 1 == this.len));
  }
  
  public final char next()
  {
    int i = this.bp + 1;
    this.bp = i;
    if (i >= this.len) {}
    for (char c = '\032';; c = this.text.charAt(i))
    {
      this.ch = c;
      return c;
    }
  }
  
  public final String numberString()
  {
    int k = charAt(this.np + this.sp - 1);
    int j = this.sp;
    int i;
    if ((k != 76) && (k != 83) && (k != 66) && (k != 70))
    {
      i = j;
      if (k != 68) {}
    }
    else
    {
      i = j - 1;
    }
    return subString(this.np, i);
  }
  
  public boolean scanFieldBoolean(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      return false;
    }
    int j = this.bp + paramArrayOfChar.length;
    int i = j + 1;
    j = charAt(j);
    boolean bool;
    if (j == 116)
    {
      j = i + 1;
      if (charAt(i) != 'r')
      {
        this.matchStat = -1;
        return false;
      }
      i = j + 1;
      if (charAt(j) != 'u')
      {
        this.matchStat = -1;
        return false;
      }
      if (charAt(i) != 'e')
      {
        this.matchStat = -1;
        return false;
      }
      this.bp = (i + 1);
      i = charAt(this.bp);
      bool = true;
    }
    while (i == 44)
    {
      i = this.bp + 1;
      this.bp = i;
      this.ch = charAt(i);
      this.matchStat = 3;
      this.token = 16;
      return bool;
      if (j == 102)
      {
        j = i + 1;
        if (charAt(i) != 'a')
        {
          this.matchStat = -1;
          return false;
        }
        i = j + 1;
        if (charAt(j) != 'l')
        {
          this.matchStat = -1;
          return false;
        }
        j = i + 1;
        if (charAt(i) != 's')
        {
          this.matchStat = -1;
          return false;
        }
        if (charAt(j) != 'e')
        {
          this.matchStat = -1;
          return false;
        }
        this.bp = (j + 1);
        i = charAt(this.bp);
        bool = false;
      }
      else
      {
        this.matchStat = -1;
        return false;
      }
    }
    if (i == 125)
    {
      i = this.bp + 1;
      this.bp = i;
      i = charAt(i);
      if (i == 44)
      {
        this.token = 16;
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
      }
      for (;;)
      {
        this.matchStat = 4;
        break;
        if (i == 93)
        {
          this.token = 15;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        }
        else if (i == 125)
        {
          this.token = 13;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        }
        else
        {
          if (i != 26) {
            break label438;
          }
          this.token = 20;
        }
      }
      label438:
      this.matchStat = -1;
      return false;
    }
    this.matchStat = -1;
    return false;
  }
  
  public int scanFieldInt(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    int n = this.bp;
    char c = this.ch;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      k = 0;
      return k;
    }
    int j = this.bp + paramArrayOfChar.length;
    int i = j + 1;
    int k = charAt(j);
    if (k == 45)
    {
      k = charAt(i);
      j = 1;
      i += 1;
    }
    for (;;)
    {
      if ((k >= 48) && (k <= 57))
      {
        int m = k - 48;
        k = i;
        i = m;
        for (;;)
        {
          m = k + 1;
          k = charAt(k);
          if ((k < 48) || (k > 57)) {
            break;
          }
          i = i * 10 + (k - 48);
          k = m;
        }
        if (k == 46)
        {
          this.matchStat = -1;
          return 0;
        }
        if (i < 0)
        {
          this.matchStat = -1;
          return 0;
        }
        if ((k == 44) || (k == 125)) {
          this.bp = (m - 1);
        }
        if (k != 44) {
          break label266;
        }
        k = this.bp + 1;
        this.bp = k;
        this.ch = charAt(k);
        this.matchStat = 3;
        this.token = 16;
        k = i;
        if (j == 0) {
          break;
        }
        return -i;
      }
      this.matchStat = -1;
      return 0;
      label266:
      if (k == 125)
      {
        k = this.bp + 1;
        this.bp = k;
        k = charAt(k);
        if (k != 44) {
          break label348;
        }
        this.token = 16;
        k = this.bp + 1;
        this.bp = k;
        this.ch = charAt(k);
      }
      for (;;)
      {
        this.matchStat = 4;
        k = i;
        if (j == 0) {
          break;
        }
        return -i;
        label348:
        if (k == 93)
        {
          this.token = 15;
          k = this.bp + 1;
          this.bp = k;
          this.ch = charAt(k);
        }
        else if (k == 125)
        {
          this.token = 13;
          k = this.bp + 1;
          this.bp = k;
          this.ch = charAt(k);
        }
        else
        {
          if (k != 26) {
            break label444;
          }
          this.token = 20;
        }
      }
      label444:
      this.bp = n;
      this.ch = c;
      this.matchStat = -1;
      return 0;
      j = 0;
    }
  }
  
  public long scanFieldLong(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    int n = this.bp;
    char c = this.ch;
    long l2;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      l2 = 0L;
      return l2;
    }
    int i = this.bp + paramArrayOfChar.length;
    int k = i + 1;
    int m = charAt(i);
    int j;
    if (m == 45)
    {
      i = k + 1;
      k = charAt(k);
      j = 1;
    }
    for (;;)
    {
      long l1;
      if ((k >= 48) && (k <= 57))
      {
        l1 = k - 48;
        for (;;)
        {
          k = i + 1;
          i = charAt(i);
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
        if ((i == 44) || (i == 125)) {
          this.bp = (k - 1);
        }
        if (l1 < 0L)
        {
          this.bp = n;
          this.ch = c;
          this.matchStat = -1;
          return 0L;
        }
      }
      else
      {
        this.bp = n;
        this.ch = c;
        this.matchStat = -1;
        return 0L;
      }
      if (i == 44)
      {
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
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
        i = this.bp + 1;
        this.bp = i;
        i = charAt(i);
        if (i == 44)
        {
          this.token = 16;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        }
        for (;;)
        {
          this.matchStat = 4;
          l2 = l1;
          if (j == 0) {
            break;
          }
          return -l1;
          if (i == 93)
          {
            this.token = 15;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          }
          else if (i == 125)
          {
            this.token = 13;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          }
          else
          {
            if (i != 26) {
              break label440;
            }
            this.token = 20;
          }
        }
        label440:
        this.bp = n;
        this.ch = c;
        this.matchStat = -1;
        return 0L;
      }
      this.matchStat = -1;
      return 0L;
      j = 0;
      i = k;
      k = m;
    }
  }
  
  public String scanFieldString(char[] paramArrayOfChar)
  {
    this.matchStat = 0;
    int m = this.bp;
    char c1 = this.ch;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      return stringDefaultValue();
    }
    int i = this.bp + paramArrayOfChar.length;
    int j = i + 1;
    if (charAt(i) != '"')
    {
      this.matchStat = -1;
      return stringDefaultValue();
    }
    i = indexOf('"', j);
    if (i == -1) {
      throw new d("unclosed str");
    }
    String str = subString(j, i - j);
    if (str.indexOf('\\') != -1)
    {
      j = i - 1;
      int k = 0;
      while ((j >= 0) && (charAt(j) == '\\'))
      {
        k += 1;
        j -= 1;
      }
      if (k % 2 == 0) {
        j = i - (this.bp + paramArrayOfChar.length + 1);
      }
    }
    for (paramArrayOfChar = readString(sub_chars(this.bp + paramArrayOfChar.length + 1, j), j);; paramArrayOfChar = str)
    {
      char c2 = charAt(i + 1);
      if ((c2 == ',') || (c2 == '}'))
      {
        this.bp = (i + 1);
        this.ch = c2;
        if (c2 != ',') {
          break label306;
        }
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
        this.matchStat = 3;
        return paramArrayOfChar;
        i = indexOf('"', i + 1);
        break;
      }
      this.matchStat = -1;
      return stringDefaultValue();
      label306:
      i = this.bp + 1;
      this.bp = i;
      i = charAt(i);
      if (i == 44)
      {
        this.token = 16;
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
      }
      for (;;)
      {
        this.matchStat = 4;
        return paramArrayOfChar;
        if (i == 93)
        {
          this.token = 15;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        }
        else if (i == 125)
        {
          this.token = 13;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        }
        else
        {
          if (i != 26) {
            break;
          }
          this.token = 20;
        }
      }
      this.bp = m;
      this.ch = c1;
      this.matchStat = -1;
      return stringDefaultValue();
    }
  }
  
  public Collection<String> scanFieldStringArray(char[] paramArrayOfChar, Class<?> paramClass)
  {
    this.matchStat = 0;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      return null;
    }
    if (paramClass.isAssignableFrom(HashSet.class)) {
      paramClass = new HashSet();
    }
    int j;
    int k;
    for (;;)
    {
      j = this.bp + paramArrayOfChar.length;
      k = j + 1;
      if (charAt(j) != '[') {
        break label510;
      }
      j = charAt(k);
      k += 1;
      if (j != 34) {
        break label328;
      }
      j = indexOf('"', k);
      if (j == -1)
      {
        throw new d("unclosed str");
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
    paramArrayOfChar = subString(k, j - k);
    label185:
    int m;
    if (paramArrayOfChar.indexOf('\\') != -1)
    {
      m = j - 1;
      int n = 0;
      while ((m >= 0) && (charAt(m) == '\\'))
      {
        n += 1;
        m -= 1;
      }
      if (n % 2 == 0)
      {
        m = j - k;
        paramArrayOfChar = readString(sub_chars(k, m), m);
      }
    }
    for (;;)
    {
      k = j + 1;
      j = k + 1;
      k = charAt(k);
      paramClass.add(paramArrayOfChar);
      for (;;)
      {
        if (k == 44)
        {
          k = charAt(j);
          m = j + 1;
          j = k;
          k = m;
          break;
          j = indexOf('"', j + 1);
          break label185;
          label328:
          if ((j == 110) && (this.text.startsWith("ull", k)))
          {
            j = k + 3;
            k = charAt(j);
            paramClass.add(null);
            j += 1;
          }
          else if ((j == 93) && (paramClass.size() == 0))
          {
            j = k + 1;
            m = charAt(k);
            paramArrayOfChar = paramClass;
          }
        }
      }
      int i;
      for (;;)
      {
        this.bp = j;
        if (m != 44) {
          break label556;
        }
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        return paramArrayOfChar;
        this.matchStat = -1;
        return null;
        if (k == 93)
        {
          k = j + 1;
          i = charAt(j);
          for (;;)
          {
            paramArrayOfChar = paramClass;
            m = i;
            j = k;
            if (!isWhitespace(i)) {
              break;
            }
            i = charAt(k);
            k += 1;
          }
        }
        this.matchStat = -1;
        return null;
        label510:
        if (!this.text.startsWith("ull", k)) {
          break;
        }
        k += 3;
        j = k + 1;
        m = charAt(k);
        paramArrayOfChar = null;
      }
      this.matchStat = -1;
      return null;
      label556:
      if (m == 125)
      {
        i = charAt(this.bp);
        do
        {
          if (i == 44)
          {
            this.token = 16;
            j = this.bp + 1;
            this.bp = j;
            this.ch = charAt(j);
          }
          for (;;)
          {
            this.matchStat = 4;
            return paramArrayOfChar;
            if (i == 93)
            {
              this.token = 15;
              j = this.bp + 1;
              this.bp = j;
              this.ch = charAt(j);
            }
            else if (i == 125)
            {
              this.token = 13;
              j = this.bp + 1;
              this.bp = j;
              this.ch = charAt(j);
            }
            else
            {
              if (i != 26) {
                break;
              }
              this.token = 20;
              this.ch = i;
            }
          }
          for (k = 0; isWhitespace(i); k = m)
          {
            k = j + 1;
            i = charAt(j);
            this.bp = k;
            m = 1;
            j = k;
          }
        } while (k != 0);
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
    if (!charArrayCompare(this.text, this.bp, paramArrayOfChar))
    {
      this.matchStat = -2;
      return 0L;
    }
    int j = this.bp + paramArrayOfChar.length;
    int i = j + 1;
    if (charAt(j) != '"')
    {
      this.matchStat = -1;
      return 0L;
    }
    long l = -2128831035L;
    char c;
    for (;;)
    {
      j = i + 1;
      i = charAt(i);
      if (i == 34)
      {
        this.bp = j;
        c = charAt(this.bp);
        this.ch = c;
        if (c != ',') {
          break;
        }
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
        this.matchStat = 3;
        return l;
      }
      if (j > this.len)
      {
        this.matchStat = -1;
        return 0L;
      }
      l = (l ^ i) * 16777619L;
      i = j;
    }
    if (c == '}')
    {
      next();
      skipWhitespace();
      i = getCurrent();
      if (i == 44)
      {
        this.token = 16;
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
      }
      for (;;)
      {
        this.matchStat = 4;
        return l;
        if (i == 93)
        {
          this.token = 15;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        }
        else if (i == 125)
        {
          this.token = 13;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        }
        else
        {
          if (i != 26) {
            break;
          }
          this.token = 20;
        }
      }
      this.matchStat = -1;
      return 0L;
    }
    this.matchStat = -1;
    return 0L;
  }
  
  public boolean scanISO8601DateIfMatch()
  {
    return scanISO8601DateIfMatch(true);
  }
  
  public boolean scanISO8601DateIfMatch(boolean paramBoolean)
  {
    int i11 = this.len - this.bp;
    if ((!paramBoolean) && (i11 > 13))
    {
      i7 = charAt(this.bp);
      i8 = charAt(this.bp + 1);
      i9 = charAt(this.bp + 2);
      i10 = charAt(this.bp + 3);
      int i12 = charAt(this.bp + 4);
      int i13 = charAt(this.bp + 5);
      int i14 = charAt(this.bp + i11 - 1);
      int i15 = charAt(this.bp + i11 - 2);
      if ((i7 == 47) && (i8 == 68) && (i9 == 97) && (i10 == 116) && (i12 == 101) && (i13 == 40) && (i14 == 47) && (i15 == 41))
      {
        i8 = -1;
        i7 = 6;
        if (i7 < i11)
        {
          i10 = charAt(this.bp + i7);
          if (i10 == 43) {
            i9 = i7;
          }
          do
          {
            i7 += 1;
            i8 = i9;
            break;
            if (i10 < 48) {
              break label247;
            }
            i9 = i8;
          } while (i10 <= 57);
        }
        label247:
        if (i8 == -1) {
          return false;
        }
        i7 = this.bp + 6;
        long l = Long.parseLong(subString(i7, i8 - i7));
        this.calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar.setTimeInMillis(l);
        this.token = 5;
        return true;
      }
    }
    if ((i11 == 8) || (i11 == 14) || (i11 == 17))
    {
      if (paramBoolean) {
        return false;
      }
      i = charAt(this.bp);
      j = charAt(this.bp + 1);
      k = charAt(this.bp + 2);
      c2 = charAt(this.bp + 3);
      m = charAt(this.bp + 4);
      n = charAt(this.bp + 5);
      i1 = charAt(this.bp + 6);
      i2 = charAt(this.bp + 7);
      if (!checkDate(i, j, k, c2, m, n, i1, i2)) {
        return false;
      }
      setCalendar(i, j, k, c2, m, n, i1, i2);
      if (i11 != 8)
      {
        i = charAt(this.bp + 8);
        j = charAt(this.bp + 9);
        k = charAt(this.bp + 10);
        c2 = charAt(this.bp + 11);
        m = charAt(this.bp + 12);
        n = charAt(this.bp + 13);
        if (!checkTime(i, j, k, c2, m, n)) {
          return false;
        }
        if (i11 == 17)
        {
          i7 = charAt(this.bp + 14);
          i8 = charAt(this.bp + 15);
          i9 = charAt(this.bp + 16);
          if ((i7 < 48) || (i7 > 57)) {
            return false;
          }
          if ((i8 < 48) || (i8 > 57)) {
            return false;
          }
          if ((i9 < 48) || (i9 > 57)) {
            return false;
          }
          i7 = (i7 - 48) * 100 + (i8 - 48) * 10 + (i9 - 48);
          i9 = c2 - '0' + (k - 48) * 10;
          i8 = (m - 48) * 10 + (n - 48);
          i10 = (i - 48) * 10 + (j - 48);
        }
      }
      for (;;)
      {
        this.calendar.set(11, i10);
        this.calendar.set(12, i9);
        this.calendar.set(13, i8);
        this.calendar.set(14, i7);
        this.token = 5;
        return true;
        i7 = 0;
        break;
        i10 = 0;
        i9 = 0;
        i8 = 0;
        i7 = 0;
      }
    }
    if (i11 < 9) {
      return false;
    }
    int i = charAt(this.bp);
    int j = charAt(this.bp + 1);
    char c2 = charAt(this.bp + 2);
    int k = charAt(this.bp + 3);
    int i6 = charAt(this.bp + 4);
    int i1 = charAt(this.bp + 5);
    int i2 = charAt(this.bp + 6);
    int n = charAt(this.bp + 7);
    int m = charAt(this.bp + 8);
    int i3 = charAt(this.bp + 9);
    int i4;
    if (((i6 == 45) && (n == 45)) || ((i6 == 47) && (n == 47)))
    {
      i4 = i;
      i = m;
      n = i3;
      m = k;
      k = j;
      j = i4;
    }
    while (!checkDate(j, k, c2, m, i1, i2, i, n))
    {
      return false;
      if (((c2 == '.') && (i1 == 46)) || ((c2 == '-') && (i1 == 45)))
      {
        i1 = k;
        i4 = i3;
        i3 = j;
        j = i2;
        i2 = i6;
        c2 = m;
        k = n;
        m = i4;
        n = i3;
      }
      else if ((i6 == 24180) || (i6 == 45380))
      {
        if ((n == 26376) || (n == 50900))
        {
          if ((i3 == 26085) || (i3 == 51068))
          {
            n = m;
            m = k;
            k = j;
            i3 = 48;
            j = i;
            i = i3;
          }
          else if ((charAt(this.bp + 10) == '日') || (charAt(this.bp + 10) == 51068))
          {
            n = k;
            k = j;
            j = i;
            i = m;
            m = n;
            n = i3;
          }
          else
          {
            return false;
          }
        }
        else if ((i2 == 26376) || (i2 == 50900))
        {
          if ((m == 26085) || (m == 51068))
          {
            i2 = i1;
            i1 = 48;
            m = k;
            k = j;
            i3 = 48;
            j = i;
            i = i3;
          }
          else if ((i3 == 26085) || (i3 == 51068))
          {
            i3 = m;
            i2 = i1;
            int i5 = 48;
            i1 = j;
            m = k;
            j = i;
            i = n;
            k = i1;
            i1 = i5;
            n = i3;
          }
          else
          {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    setCalendar(j, k, c2, m, i1, i2, i, n);
    i = charAt(this.bp + 10);
    if ((i == 84) || ((i == 32) && (!paramBoolean)))
    {
      if (i11 < 19) {
        return false;
      }
    }
    else
    {
      if ((i == 34) || (i == 26) || (i == 26085) || (i == 51068))
      {
        this.calendar.set(11, 0);
        this.calendar.set(12, 0);
        this.calendar.set(13, 0);
        this.calendar.set(14, 0);
        i7 = this.bp + 10;
        this.bp = i7;
        this.ch = charAt(i7);
        this.token = 5;
        return true;
      }
      if ((i == 43) || (i == 45))
      {
        if (this.len == 16)
        {
          if ((charAt(this.bp + 13) != ':') || (charAt(this.bp + 14) != '0') || (charAt(this.bp + 15) != '0')) {
            return false;
          }
          setTime('0', '0', '0', '0', '0', '0');
          this.calendar.set(14, 0);
          setTimeZone(i, charAt(this.bp + 11), charAt(this.bp + 12));
          return true;
        }
        return false;
      }
      return false;
    }
    if (charAt(this.bp + 13) != ':') {
      return false;
    }
    if (charAt(this.bp + 16) != ':') {
      return false;
    }
    char c1 = charAt(this.bp + 11);
    j = charAt(this.bp + 12);
    k = charAt(this.bp + 14);
    c2 = charAt(this.bp + 15);
    char c3 = charAt(this.bp + 17);
    char c4 = charAt(this.bp + 18);
    if (!checkTime(c1, j, k, c2, c3, c4)) {
      return false;
    }
    setTime(c1, j, k, c2, c3, c4);
    int i7 = charAt(this.bp + 19);
    Object localObject;
    if (i7 == 46)
    {
      if (i11 < 21) {
        return false;
      }
    }
    else
    {
      this.calendar.set(14, 0);
      i8 = this.bp + 19;
      this.bp = i8;
      this.ch = charAt(i8);
      this.token = 5;
      if ((i7 == 90) && (this.calendar.getTimeZone().getRawOffset() != 0))
      {
        localObject = TimeZone.getAvailableIDs(0);
        if (localObject.length > 0)
        {
          localObject = TimeZone.getTimeZone(localObject[0]);
          this.calendar.setTimeZone((TimeZone)localObject);
        }
      }
      return true;
    }
    i7 = charAt(this.bp + 20);
    if ((i7 < 48) || (i7 > 57)) {
      return false;
    }
    int i9 = i7 - 48;
    int i10 = 1;
    int i8 = i10;
    i7 = i9;
    if (i11 > 21)
    {
      i11 = charAt(this.bp + 21);
      i8 = i10;
      i7 = i9;
      if (i11 >= 48)
      {
        i8 = i10;
        i7 = i9;
        if (i11 <= 57)
        {
          i7 = i11 - 48 + i9 * 10;
          i8 = 2;
        }
      }
    }
    i9 = i8;
    i10 = i7;
    if (i8 == 2)
    {
      i11 = charAt(this.bp + 22);
      i9 = i8;
      i10 = i7;
      if (i11 >= 48)
      {
        i9 = i8;
        i10 = i7;
        if (i11 <= 57)
        {
          i10 = i11 - 48 + i7 * 10;
          i9 = 3;
        }
      }
    }
    this.calendar.set(14, i10);
    i7 = 0;
    c1 = charAt(this.bp + 20 + i9);
    if ((c1 == '+') || (c1 == '-'))
    {
      j = charAt(this.bp + 20 + i9 + 1);
      if ((j < 48) || (j > 49)) {
        return false;
      }
      k = charAt(this.bp + 20 + i9 + 2);
      if ((k < 48) || (k > 57)) {
        return false;
      }
      i7 = charAt(this.bp + 20 + i9 + 3);
      if (i7 == 58)
      {
        if (charAt(this.bp + 20 + i9 + 4) != '0') {
          return false;
        }
        if (charAt(this.bp + 20 + i9 + 5) != '0') {
          return false;
        }
        i7 = 6;
        setTimeZone(c1, j, k);
      }
    }
    for (;;)
    {
      i8 = charAt(this.bp + (i9 + 20 + i7));
      if ((i8 == 26) || (i8 == 34)) {
        break label2393;
      }
      return false;
      if (i7 == 48)
      {
        if (charAt(this.bp + 20 + i9 + 4) != '0') {
          return false;
        }
        i7 = 5;
        break;
      }
      i7 = 3;
      break;
      if (c1 == 'Z')
      {
        i8 = 1;
        i7 = i8;
        if (this.calendar.getTimeZone().getRawOffset() != 0)
        {
          localObject = TimeZone.getAvailableIDs(0);
          i7 = i8;
          if (localObject.length > 0)
          {
            localObject = TimeZone.getTimeZone(localObject[0]);
            this.calendar.setTimeZone((TimeZone)localObject);
            i7 = i8;
          }
        }
      }
    }
    label2393:
    i7 = i9 + 20 + i7 + this.bp;
    this.bp = i7;
    this.ch = charAt(i7);
    this.token = 5;
    return true;
  }
  
  public final int scanInt(char paramChar)
  {
    this.matchStat = 0;
    int i = this.bp;
    char c2 = i + 1;
    char c3 = charAt(i);
    char c4;
    if (c3 == '-')
    {
      i = 1;
      if (i == 0) {
        break label245;
      }
      c3 = c2 + '\001';
      c4 = charAt(c2);
      c2 = c3;
      c3 = c4;
    }
    label245:
    for (;;)
    {
      char c1;
      if ((c3 >= '0') && (c3 <= '9'))
      {
        c4 = c3 - '0';
        c3 = c2;
        c2 = c4;
        for (;;)
        {
          c4 = c3 + '\001';
          c1 = charAt(c3);
          if ((c1 < '0') || (c1 > '9')) {
            break;
          }
          c2 = c2 * '\n' + (c1 - '0');
          c3 = c4;
        }
        i = 0;
        break;
        if (c1 == '.')
        {
          this.matchStat = -1;
          paramChar = '\000';
        }
      }
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
            c1 = charAt(c4);
            c4 += '\001';
          }
          this.bp = c4;
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
  }
  
  public long scanLong(char paramChar)
  {
    this.matchStat = 0;
    int j = this.bp;
    int i = j + 1;
    int k = charAt(j);
    if (k == 45)
    {
      j = 1;
      if (j == 0) {
        break label242;
      }
      k = i + 1;
      int m = charAt(i);
      i = k;
      k = m;
    }
    label242:
    for (;;)
    {
      long l1;
      char c;
      long l2;
      if ((k >= 48) && (k <= 57))
      {
        l1 = k - 48;
        for (;;)
        {
          k = i + 1;
          c = charAt(i);
          if ((c < '0') || (c > '9')) {
            break;
          }
          l1 = l1 * 10L + (c - '0');
          i = k;
        }
        j = 0;
        break;
        if (c == '.')
        {
          this.matchStat = -1;
          l2 = 0L;
        }
      }
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
          c = charAt(k);
          k += 1;
        }
        this.bp = k;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        l2 = l1;
      } while (j == 0);
      return -l1;
      this.matchStat = -1;
      return l1;
    }
  }
  
  protected void setTime(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6)
  {
    this.calendar.set(11, (paramChar1 - '0') * 10 + (paramChar2 - '0'));
    this.calendar.set(12, (paramChar3 - '0') * 10 + (paramChar4 - '0'));
    this.calendar.set(13, (paramChar5 - '0') * 10 + (paramChar6 - '0'));
  }
  
  protected void setTimeZone(char paramChar1, char paramChar2, char paramChar3)
  {
    paramChar3 = ((paramChar2 - '0') * 10 + (paramChar3 - '0')) * 3600 * 1000;
    paramChar2 = paramChar3;
    if (paramChar1 == '-') {
      paramChar2 = -paramChar3;
    }
    if (this.calendar.getTimeZone().getRawOffset() != paramChar2)
    {
      Object localObject = TimeZone.getAvailableIDs(paramChar2);
      if (localObject.length > 0)
      {
        localObject = TimeZone.getTimeZone(localObject[0]);
        this.calendar.setTimeZone((TimeZone)localObject);
      }
    }
  }
  
  public final String stringVal()
  {
    if (!this.hasSpecial) {
      return subString(this.np + 1, this.sp);
    }
    return new String(this.sbuf, 0, this.sp);
  }
  
  public final String subString(int paramInt1, int paramInt2)
  {
    if (ASMUtils.IS_ANDROID)
    {
      if (paramInt2 < this.sbuf.length)
      {
        this.text.getChars(paramInt1, paramInt1 + paramInt2, this.sbuf, 0);
        return new String(this.sbuf, 0, paramInt2);
      }
      char[] arrayOfChar = new char[paramInt2];
      this.text.getChars(paramInt1, paramInt1 + paramInt2, arrayOfChar, 0);
      return new String(arrayOfChar);
    }
    return this.text.substring(paramInt1, paramInt1 + paramInt2);
  }
  
  public final char[] sub_chars(int paramInt1, int paramInt2)
  {
    if ((ASMUtils.IS_ANDROID) && (paramInt2 < this.sbuf.length))
    {
      this.text.getChars(paramInt1, paramInt1 + paramInt2, this.sbuf, 0);
      return this.sbuf;
    }
    char[] arrayOfChar = new char[paramInt2];
    this.text.getChars(paramInt1, paramInt1 + paramInt2, arrayOfChar, 0);
    return arrayOfChar;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/JSONScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */