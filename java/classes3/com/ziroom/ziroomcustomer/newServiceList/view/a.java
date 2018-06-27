package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;

public class a
  implements TextWatcher
{
  private Context a;
  private EditText b;
  private int c;
  private String d;
  private boolean e;
  private boolean f = false;
  private boolean g = false;
  
  public a(EditText paramEditText, Context paramContext)
  {
    this.b = paramEditText;
    this.a = paramContext;
  }
  
  private static boolean a(char paramChar)
  {
    return (paramChar != '©') && (paramChar != '®') && (paramChar != '™') && ((paramChar < '↖') || (paramChar > '↙')) && (paramChar != '⏩') && (paramChar != '⏪') && (paramChar != '▶') && (paramChar != '◀') && (paramChar != '◼') && (paramChar != '◻') && (paramChar != '☀') && (paramChar != '☁') && (paramChar != '☎') && (paramChar != '☔') && (paramChar != '☕') && (paramChar != '☝') && (paramChar != '✋') && (paramChar != '☺') && ((paramChar < '♈') || (paramChar > '♓')) && (paramChar != '♠') && (paramChar != '♣') && (paramChar != '♥') && (paramChar != '♦') && (paramChar != '♨') && (paramChar != '♿') && (paramChar != '⚠') && (paramChar != '⚽') && (paramChar != '⚾') && (paramChar != '⛄') && (paramChar != '⛎') && (paramChar != '⛪') && (paramChar != '⛲') && (paramChar != '⛳') && (paramChar != '⛵') && (paramChar != '⛺') && (paramChar != '⛽') && (paramChar != '✂') && (paramChar != '⚡') && (paramChar != '✈') && (paramChar != '✊') && (paramChar != '✌') && (paramChar != '✨') && (paramChar != '✳') && (paramChar != '✴') && (paramChar != '❄') && (paramChar != '❌') && ((paramChar < '❓') || (paramChar > '❕')) && (paramChar != '❗') && (paramChar != '❤') && (paramChar != '➡') && (paramChar != '➿') && ((paramChar < '⬅') || (paramChar > '⬇')) && (paramChar != '⬜') && (paramChar != '⭕') && (paramChar != '〽') && (paramChar != '㊗') && (paramChar != '㊙');
  }
  
  private boolean a(char paramChar, int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      if (((paramChar >= '0') && (paramChar <= '9')) || (paramChar == '#') || (paramChar == '⛪'))
      {
        bool = true;
        this.f = bool;
        label36:
        if ((!this.f) || (!this.g)) {
          break label113;
        }
      }
    }
    label113:
    while ((paramChar != 0) && (paramChar != '\t') && (paramChar != '\n') && (paramChar != '\r') && ((paramChar < ' ') || (paramChar > 55295)) && ((paramChar < 57344) || (paramChar > 65533)) && ((paramChar < 65536) || (paramChar > 1114111)))
    {
      return false;
      bool = false;
      break;
      if (paramInt != 1) {
        break label36;
      }
      if (this.f)
      {
        if (paramChar == '⃣')
        {
          this.g = true;
          break label36;
        }
        if (paramChar == 65039) {}
        for (bool = true;; bool = false)
        {
          this.g = bool;
          break;
        }
      }
      this.g = false;
      break label36;
    }
    return true;
  }
  
  public static boolean containsEmojiLost(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (!a(paramString.charAt(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.e)
    {
      this.c = this.b.getSelectionEnd();
      this.d = paramCharSequence.toString();
    }
  }
  
  public boolean containsEmoji(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (!a(paramString.charAt(i), i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.e)
    {
      if (paramInt3 == 1) {
        if (containsEmojiLost(paramCharSequence.subSequence(paramInt1, paramInt1 + paramInt3).toString()))
        {
          this.e = true;
          paramCharSequence = Toast.makeText(this.a, "暂不支持输入表情符号", 0);
          if ((paramCharSequence instanceof Toast)) {
            break label102;
          }
          paramCharSequence.show();
          this.b.setText(this.d);
          paramCharSequence = VdsAgent.trackEditTextSilent(this.b);
          if ((paramCharSequence instanceof Spannable)) {
            Selection.setSelection((Spannable)paramCharSequence, paramCharSequence.length());
          }
        }
      }
      label102:
      while ((paramInt3 < 2) || (!containsEmoji(paramCharSequence.subSequence(paramInt1, paramInt1 + paramInt3).toString()))) {
        for (;;)
        {
          return;
          VdsAgent.showToast((Toast)paramCharSequence);
        }
      }
      this.e = true;
      paramCharSequence = Toast.makeText(this.a, "暂不支持输入表情符号", 0);
      if (!(paramCharSequence instanceof Toast)) {
        paramCharSequence.show();
      }
      for (;;)
      {
        this.b.setText(this.d);
        paramCharSequence = VdsAgent.trackEditTextSilent(this.b);
        if (!(paramCharSequence instanceof Spannable)) {
          break;
        }
        Selection.setSelection((Spannable)paramCharSequence, paramCharSequence.length());
        return;
        VdsAgent.showToast((Toast)paramCharSequence);
      }
    }
    this.e = false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */