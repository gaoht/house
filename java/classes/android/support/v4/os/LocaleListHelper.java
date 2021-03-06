package android.support.v4.os;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

final class LocaleListHelper
{
  private static final Locale EN_LATN;
  private static final Locale LOCALE_AR_XB;
  private static final Locale LOCALE_EN_XA;
  private static final int NUM_PSEUDO_LOCALES = 2;
  private static final String STRING_AR_XB = "ar-XB";
  private static final String STRING_EN_XA = "en-XA";
  private static LocaleListHelper sDefaultAdjustedLocaleList = null;
  private static LocaleListHelper sDefaultLocaleList;
  private static final Locale[] sEmptyList = new Locale[0];
  private static final LocaleListHelper sEmptyLocaleList = new LocaleListHelper(new Locale[0]);
  private static Locale sLastDefaultLocale = null;
  private static LocaleListHelper sLastExplicitlySetLocaleList;
  private static final Object sLock;
  private final Locale[] mList;
  private final String mStringRepresentation;
  
  static
  {
    LOCALE_EN_XA = new Locale("en", "XA");
    LOCALE_AR_XB = new Locale("ar", "XB");
    EN_LATN = LocaleHelper.forLanguageTag("en-Latn");
    sLock = new Object();
    sLastExplicitlySetLocaleList = null;
    sDefaultLocaleList = null;
  }
  
  LocaleListHelper(Locale paramLocale, LocaleListHelper paramLocaleListHelper)
  {
    if (paramLocale == null) {
      throw new NullPointerException("topLocale is null");
    }
    int j;
    int i;
    if (paramLocaleListHelper == null)
    {
      j = 0;
      i = 0;
      label30:
      if (i >= j) {
        break label280;
      }
      if (!paramLocale.equals(paramLocaleListHelper.mList[i])) {
        break label130;
      }
    }
    for (;;)
    {
      if (i == -1) {}
      int n;
      Locale[] arrayOfLocale;
      for (int k = 1;; k = 0)
      {
        n = j + k;
        arrayOfLocale = new Locale[n];
        arrayOfLocale[0] = ((Locale)paramLocale.clone());
        if (i != -1) {
          break label143;
        }
        i = 0;
        while (i < j)
        {
          arrayOfLocale[(i + 1)] = ((Locale)paramLocaleListHelper.mList[i].clone());
          i += 1;
        }
        j = paramLocaleListHelper.mList.length;
        break;
        label130:
        i += 1;
        break label30;
      }
      label143:
      k = 0;
      while (k < i)
      {
        arrayOfLocale[(k + 1)] = ((Locale)paramLocaleListHelper.mList[k].clone());
        k += 1;
      }
      i += 1;
      while (i < j)
      {
        arrayOfLocale[i] = ((Locale)paramLocaleListHelper.mList[i].clone());
        i += 1;
      }
      paramLocale = new StringBuilder();
      i = m;
      while (i < n)
      {
        paramLocale.append(LocaleHelper.toLanguageTag(arrayOfLocale[i]));
        if (i < n - 1) {
          paramLocale.append(',');
        }
        i += 1;
      }
      this.mList = arrayOfLocale;
      this.mStringRepresentation = paramLocale.toString();
      return;
      label280:
      i = -1;
    }
  }
  
  LocaleListHelper(Locale... paramVarArgs)
  {
    if (paramVarArgs.length == 0)
    {
      this.mList = sEmptyList;
      this.mStringRepresentation = "";
      return;
    }
    Locale[] arrayOfLocale = new Locale[paramVarArgs.length];
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Locale localLocale = paramVarArgs[i];
      if (localLocale == null) {
        throw new NullPointerException("list[" + i + "] is null");
      }
      if (localHashSet.contains(localLocale)) {
        throw new IllegalArgumentException("list[" + i + "] is a repetition");
      }
      localLocale = (Locale)localLocale.clone();
      arrayOfLocale[i] = localLocale;
      localStringBuilder.append(LocaleHelper.toLanguageTag(localLocale));
      if (i < paramVarArgs.length - 1) {
        localStringBuilder.append(',');
      }
      localHashSet.add(localLocale);
      i += 1;
    }
    this.mList = arrayOfLocale;
    this.mStringRepresentation = localStringBuilder.toString();
  }
  
  private Locale computeFirstMatch(Collection<String> paramCollection, boolean paramBoolean)
  {
    int i = computeFirstMatchIndex(paramCollection, paramBoolean);
    if (i == -1) {
      return null;
    }
    return this.mList[i];
  }
  
  private int computeFirstMatchIndex(Collection<String> paramCollection, boolean paramBoolean)
  {
    int j;
    if (this.mList.length == 1)
    {
      j = 0;
      return j;
    }
    if (this.mList.length == 0) {
      return -1;
    }
    int i;
    if (paramBoolean)
    {
      i = findFirstMatchIndex(EN_LATN);
      if (i == 0) {
        return 0;
      }
      if (i >= Integer.MAX_VALUE) {}
    }
    for (;;)
    {
      paramCollection = paramCollection.iterator();
      label56:
      if (paramCollection.hasNext())
      {
        j = findFirstMatchIndex(LocaleHelper.forLanguageTag((String)paramCollection.next()));
        if (j == 0) {
          return 0;
        }
        if (j >= i) {
          break label113;
        }
        i = j;
      }
      label113:
      for (;;)
      {
        break label56;
        j = i;
        if (i != Integer.MAX_VALUE) {
          break;
        }
        return 0;
      }
      i = Integer.MAX_VALUE;
    }
  }
  
  private int findFirstMatchIndex(Locale paramLocale)
  {
    int i = 0;
    while (i < this.mList.length)
    {
      if (matchScore(paramLocale, this.mList[i]) > 0) {
        return i;
      }
      i += 1;
    }
    return Integer.MAX_VALUE;
  }
  
  static LocaleListHelper forLanguageTags(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return getEmptyLocaleList();
    }
    paramString = paramString.split(",");
    Locale[] arrayOfLocale = new Locale[paramString.length];
    int i = 0;
    while (i < arrayOfLocale.length)
    {
      arrayOfLocale[i] = LocaleHelper.forLanguageTag(paramString[i]);
      i += 1;
    }
    return new LocaleListHelper(arrayOfLocale);
  }
  
  static LocaleListHelper getAdjustedDefault()
  {
    getDefault();
    synchronized (sLock)
    {
      LocaleListHelper localLocaleListHelper = sDefaultAdjustedLocaleList;
      return localLocaleListHelper;
    }
  }
  
  static LocaleListHelper getDefault()
  {
    Object localObject2 = Locale.getDefault();
    synchronized (sLock)
    {
      if (!((Locale)localObject2).equals(sLastDefaultLocale))
      {
        sLastDefaultLocale = (Locale)localObject2;
        if ((sDefaultLocaleList != null) && (((Locale)localObject2).equals(sDefaultLocaleList.get(0))))
        {
          localObject2 = sDefaultLocaleList;
          return (LocaleListHelper)localObject2;
        }
        sDefaultLocaleList = new LocaleListHelper((Locale)localObject2, sLastExplicitlySetLocaleList);
        sDefaultAdjustedLocaleList = sDefaultLocaleList;
      }
      localObject2 = sDefaultLocaleList;
      return (LocaleListHelper)localObject2;
    }
  }
  
  static LocaleListHelper getEmptyLocaleList()
  {
    return sEmptyLocaleList;
  }
  
  private static String getLikelyScript(Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramLocale = paramLocale.getScript();
      if (!paramLocale.isEmpty()) {
        return paramLocale;
      }
      return "";
    }
    return "";
  }
  
  private static boolean isPseudoLocale(String paramString)
  {
    return ("en-XA".equals(paramString)) || ("ar-XB".equals(paramString));
  }
  
  private static boolean isPseudoLocale(Locale paramLocale)
  {
    return (LOCALE_EN_XA.equals(paramLocale)) || (LOCALE_AR_XB.equals(paramLocale));
  }
  
  static boolean isPseudoLocalesOnly(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return true;
      if (paramArrayOfString.length > 3) {
        return false;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if ((!str.isEmpty()) && (!isPseudoLocale(str))) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  private static int matchScore(Locale paramLocale1, Locale paramLocale2)
  {
    int j = 1;
    int k = 0;
    if (paramLocale1.equals(paramLocale2)) {
      i = 1;
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            i = k;
          } while (!paramLocale1.getLanguage().equals(paramLocale2.getLanguage()));
          i = k;
        } while (isPseudoLocale(paramLocale1));
        i = k;
      } while (isPseudoLocale(paramLocale2));
      str = getLikelyScript(paramLocale1);
      if (!str.isEmpty()) {
        break label96;
      }
      paramLocale1 = paramLocale1.getCountry();
      if (paramLocale1.isEmpty()) {
        break;
      }
      i = k;
    } while (!paramLocale1.equals(paramLocale2.getCountry()));
    return 1;
    label96:
    if (str.equals(getLikelyScript(paramLocale2))) {}
    for (int i = j;; i = 0) {
      return i;
    }
  }
  
  static void setDefault(LocaleListHelper paramLocaleListHelper)
  {
    setDefault(paramLocaleListHelper, 0);
  }
  
  static void setDefault(LocaleListHelper paramLocaleListHelper, int paramInt)
  {
    if (paramLocaleListHelper == null) {
      throw new NullPointerException("locales is null");
    }
    if (paramLocaleListHelper.isEmpty()) {
      throw new IllegalArgumentException("locales is empty");
    }
    synchronized (sLock)
    {
      sLastDefaultLocale = paramLocaleListHelper.get(paramInt);
      Locale.setDefault(sLastDefaultLocale);
      sLastExplicitlySetLocaleList = paramLocaleListHelper;
      sDefaultLocaleList = paramLocaleListHelper;
      if (paramInt == 0)
      {
        sDefaultAdjustedLocaleList = sDefaultLocaleList;
        return;
      }
      sDefaultAdjustedLocaleList = new LocaleListHelper(sLastDefaultLocale, sDefaultLocaleList);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof LocaleListHelper));
      paramObject = ((LocaleListHelper)paramObject).mList;
      bool1 = bool2;
    } while (this.mList.length != paramObject.length);
    int i = 0;
    for (;;)
    {
      if (i >= this.mList.length) {
        break label79;
      }
      bool1 = bool2;
      if (!this.mList[i].equals(paramObject[i])) {
        break;
      }
      i += 1;
    }
    label79:
    return true;
  }
  
  Locale get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mList.length)) {
      return this.mList[paramInt];
    }
    return null;
  }
  
  Locale getFirstMatch(String[] paramArrayOfString)
  {
    return computeFirstMatch(Arrays.asList(paramArrayOfString), false);
  }
  
  int getFirstMatchIndex(String[] paramArrayOfString)
  {
    return computeFirstMatchIndex(Arrays.asList(paramArrayOfString), false);
  }
  
  int getFirstMatchIndexWithEnglishSupported(Collection<String> paramCollection)
  {
    return computeFirstMatchIndex(paramCollection, true);
  }
  
  int getFirstMatchIndexWithEnglishSupported(String[] paramArrayOfString)
  {
    return getFirstMatchIndexWithEnglishSupported(Arrays.asList(paramArrayOfString));
  }
  
  Locale getFirstMatchWithEnglishSupported(String[] paramArrayOfString)
  {
    return computeFirstMatch(Arrays.asList(paramArrayOfString), true);
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.mList.length)
    {
      j = j * 31 + this.mList[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  int indexOf(Locale paramLocale)
  {
    int i = 0;
    while (i < this.mList.length)
    {
      if (this.mList[i].equals(paramLocale)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  boolean isEmpty()
  {
    return this.mList.length == 0;
  }
  
  int size()
  {
    return this.mList.length;
  }
  
  String toLanguageTags()
  {
    return this.mStringRepresentation;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int i = 0;
    while (i < this.mList.length)
    {
      localStringBuilder.append(this.mList[i]);
      if (i < this.mList.length - 1) {
        localStringBuilder.append(',');
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/os/LocaleListHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */