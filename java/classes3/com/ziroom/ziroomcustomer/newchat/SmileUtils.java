package com.ziroom.ziroomcustomer.newchat;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ImageSpan;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmileUtils
{
  public static final String ee_1 = "[):]";
  public static final String ee_10 = "[:(]";
  public static final String ee_11 = "[:'(]";
  public static final String ee_12 = "[:|]";
  public static final String ee_13 = "[(a)]";
  public static final String ee_14 = "[8o|]";
  public static final String ee_15 = "[8-|]";
  public static final String ee_16 = "[+o(]";
  public static final String ee_17 = "[<o)]";
  public static final String ee_18 = "[|-)]";
  public static final String ee_19 = "[*-)]";
  public static final String ee_2 = "[:D]";
  public static final String ee_20 = "[:-#]";
  public static final String ee_21 = "[:-*]";
  public static final String ee_22 = "[^o)]";
  public static final String ee_23 = "[8-)]";
  public static final String ee_24 = "[(|)]";
  public static final String ee_25 = "[(u)]";
  public static final String ee_26 = "[(S)]";
  public static final String ee_27 = "[(*)]";
  public static final String ee_28 = "[(#)]";
  public static final String ee_29 = "[(R)]";
  public static final String ee_3 = "[;)]";
  public static final String ee_30 = "[({)]";
  public static final String ee_31 = "[(})]";
  public static final String ee_32 = "[(k)]";
  public static final String ee_33 = "[(F)]";
  public static final String ee_34 = "[(W)]";
  public static final String ee_35 = "[(D)]";
  public static final String ee_4 = "[:-o]";
  public static final String ee_5 = "[:p]";
  public static final String ee_6 = "[(H)]";
  public static final String ee_7 = "[:@]";
  public static final String ee_8 = "[:s]";
  public static final String ee_9 = "[:$]";
  private static final Map<Pattern, Integer> emoticons;
  private static final Spannable.Factory spannableFactory = ;
  
  static
  {
    emoticons = new HashMap();
    addPattern(emoticons, "[):]", 2130838400);
    addPattern(emoticons, "[:D]", 2130838411);
    addPattern(emoticons, "[;)]", 2130838422);
    addPattern(emoticons, "[:-o]", 2130838429);
    addPattern(emoticons, "[:p]", 2130838430);
    addPattern(emoticons, "[(H)]", 2130838431);
    addPattern(emoticons, "[:@]", 2130838432);
    addPattern(emoticons, "[:s]", 2130838433);
    addPattern(emoticons, "[:$]", 2130838434);
    addPattern(emoticons, "[:(]", 2130838401);
    addPattern(emoticons, "[:'(]", 2130838402);
    addPattern(emoticons, "[:|]", 2130838403);
    addPattern(emoticons, "[(a)]", 2130838404);
    addPattern(emoticons, "[8o|]", 2130838405);
    addPattern(emoticons, "[8-|]", 2130838406);
    addPattern(emoticons, "[+o(]", 2130838407);
    addPattern(emoticons, "[<o)]", 2130838408);
    addPattern(emoticons, "[|-)]", 2130838409);
    addPattern(emoticons, "[*-)]", 2130838410);
    addPattern(emoticons, "[:-#]", 2130838412);
    addPattern(emoticons, "[:-*]", 2130838413);
    addPattern(emoticons, "[^o)]", 2130838414);
    addPattern(emoticons, "[8-)]", 2130838415);
    addPattern(emoticons, "[(|)]", 2130838416);
    addPattern(emoticons, "[(u)]", 2130838417);
    addPattern(emoticons, "[(S)]", 2130838418);
    addPattern(emoticons, "[(*)]", 2130838419);
    addPattern(emoticons, "[(#)]", 2130838420);
    addPattern(emoticons, "[(R)]", 2130838421);
    addPattern(emoticons, "[({)]", 2130838423);
    addPattern(emoticons, "[(})]", 2130838424);
    addPattern(emoticons, "[(k)]", 2130838425);
    addPattern(emoticons, "[(F)]", 2130838426);
    addPattern(emoticons, "[(W)]", 2130838427);
    addPattern(emoticons, "[(D)]", 2130838428);
  }
  
  private static void addPattern(Map<Pattern, Integer> paramMap, String paramString, int paramInt)
  {
    paramMap.put(Pattern.compile(Pattern.quote(paramString)), Integer.valueOf(paramInt));
  }
  
  public static boolean addSmiles(Context paramContext, Spannable paramSpannable)
  {
    Iterator localIterator = emoticons.entrySet().iterator();
    boolean bool1 = false;
    Map.Entry localEntry;
    Matcher localMatcher;
    boolean bool2;
    if (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localMatcher = ((Pattern)localEntry.getKey()).matcher(paramSpannable);
      bool2 = bool1;
    }
    label213:
    label216:
    for (;;)
    {
      bool1 = bool2;
      if (!localMatcher.find()) {
        break;
      }
      ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramSpannable.getSpans(localMatcher.start(), localMatcher.end(), ImageSpan.class);
      int j = arrayOfImageSpan.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label213;
        }
        ImageSpan localImageSpan = arrayOfImageSpan[i];
        if ((paramSpannable.getSpanStart(localImageSpan) < localMatcher.start()) || (paramSpannable.getSpanEnd(localImageSpan) > localMatcher.end())) {
          break;
        }
        paramSpannable.removeSpan(localImageSpan);
        i += 1;
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label216;
        }
        paramSpannable.setSpan(new ImageSpan(paramContext, ((Integer)localEntry.getValue()).intValue()), localMatcher.start(), localMatcher.end(), 33);
        bool2 = true;
        break;
        return bool1;
      }
    }
  }
  
  public static boolean containsKey(String paramString)
  {
    Iterator localIterator = emoticons.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((Pattern)((Map.Entry)localIterator.next()).getKey()).matcher(paramString).find()) {
        return true;
      }
    }
    return false;
  }
  
  public static Spannable getSmiledText(Context paramContext, CharSequence paramCharSequence)
  {
    paramCharSequence = spannableFactory.newSpannable(paramCharSequence + " ");
    addSmiles(paramContext, paramCharSequence);
    return paramCharSequence;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/SmileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */