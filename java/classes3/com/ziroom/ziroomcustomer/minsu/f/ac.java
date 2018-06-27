package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.URLSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.ziroom.ziroomcustomer.minsu.chat.d.f;
import com.ziroom.ziroomcustomer.minsu.chat.span.ChatUrlSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ac
{
  public static void absSize(TextView paramTextView, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    SpannableString localSpannableString = new SpannableString(paramString1 + paramString2);
    localSpannableString.setSpan(new AbsoluteSizeSpan(paramInt1, true), 0, paramString1.length(), 33);
    localSpannableString.setSpan(new AbsoluteSizeSpan(paramInt2, true), paramString1.length(), paramString2.length(), 33);
    paramTextView.setText(localSpannableString);
  }
  
  public static void absSizeColor(TextView paramTextView, String paramString, int paramInt1, int paramInt2)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new AbsoluteSizeSpan(paramInt1, true), 0, paramString.length(), 33);
    localSpannableString.setSpan(new ForegroundColorSpan(paramInt2), 0, paramString.length(), 33);
    paramTextView.setText(localSpannableString);
  }
  
  public static void addInnerLink(TextView paramTextView)
  {
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setAutoLinkMask(1);
    Object localObject = paramTextView.getText();
    if ((localObject instanceof Spannable))
    {
      Spannable localSpannable = (Spannable)localObject;
      URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannable.getSpans(0, ((CharSequence)localObject).length(), URLSpan.class);
      if ((arrayOfURLSpan != null) && (arrayOfURLSpan.length > 0))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        int j = arrayOfURLSpan.length;
        int i = 0;
        while (i < j)
        {
          URLSpan localURLSpan = arrayOfURLSpan[i];
          ((SpannableStringBuilder)localObject).setSpan(new ChatUrlSpan(localURLSpan.getURL()), localSpannable.getSpanStart(localURLSpan), localSpannable.getSpanEnd(localURLSpan), 17);
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#ff0000")), localSpannable.getSpanStart(localURLSpan), localSpannable.getSpanEnd(localURLSpan), 17);
          i += 1;
        }
        paramTextView.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
      }
    }
  }
  
  public static void color(TextView paramTextView, String paramString1, String paramString2, int paramInt)
  {
    int i = paramString1.indexOf(paramString2);
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new ForegroundColorSpan(paramInt), i, paramString2.length() + i, 33);
    paramTextView.setText(paramString1);
  }
  
  public static void colorMulti(TextView paramTextView, String paramString1, String paramString2, int paramInt)
  {
    int i = paramString1.indexOf(paramString2);
    Object localObject = new ArrayList();
    while (i != -1)
    {
      ((List)localObject).add(Integer.valueOf(i));
      i = paramString1.indexOf(paramString2, i + 1);
    }
    paramString1 = new SpannableString(paramString1);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i = ((Integer)((Iterator)localObject).next()).intValue();
      paramString1.setSpan(new ForegroundColorSpan(paramInt), i, paramString2.length() + i, 33);
    }
    paramTextView.setText(paramString1);
  }
  
  public static void image(Context paramContext, TextView paramTextView, String paramString1, String paramString2, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString1);
    int i = ab.dp2px(paramContext, 12.0F);
    paramContext = new ImageSpan(paramContext, f.convertBitmap(BitmapFactory.decodeResource(paramContext.getResources(), paramInt), i, i), 1);
    paramInt = paramString1.indexOf(paramString2);
    localSpannableStringBuilder.setSpan(paramContext, paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setText(localSpannableStringBuilder);
  }
  
  public static void relaSize(TextView paramTextView, String paramString1, String paramString2, float paramFloat)
  {
    int i = paramString1.indexOf(paramString2);
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new RelativeSizeSpan(paramFloat), i, paramString2.length() + i, 33);
    paramTextView.setText(paramString1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */