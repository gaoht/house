package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;

public class LimitEditText
  extends EditText
{
  private int a;
  private String b;
  private boolean c;
  private Context d;
  private boolean e = false;
  private boolean f = false;
  private a g;
  
  public LimitEditText(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext;
    a();
  }
  
  public LimitEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    a();
  }
  
  public LimitEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    a();
  }
  
  public LimitEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.d = paramContext;
    a();
  }
  
  private void a()
  {
    addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (LimitEditText.b(LimitEditText.this) != null) {
          LimitEditText.b(LimitEditText.this).afterTextChanged(paramAnonymousEditable);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (!LimitEditText.a(LimitEditText.this))
        {
          LimitEditText.a(LimitEditText.this, LimitEditText.this.getSelectionEnd());
          LimitEditText.a(LimitEditText.this, paramAnonymousCharSequence.toString());
        }
        if (LimitEditText.b(LimitEditText.this) != null) {
          LimitEditText.b(LimitEditText.this).onTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (!LimitEditText.a(LimitEditText.this)) {
          if (paramAnonymousInt3 == 1) {
            if (LimitEditText.containsEmojiLost(paramAnonymousCharSequence.subSequence(LimitEditText.c(LimitEditText.this) - paramAnonymousInt2, LimitEditText.c(LimitEditText.this) - paramAnonymousInt2 + paramAnonymousInt3).toString()))
            {
              LimitEditText.a(LimitEditText.this, true);
              paramAnonymousCharSequence = Toast.makeText(LimitEditText.d(LimitEditText.this), "暂不支持输入表情符号", 0);
              if ((paramAnonymousCharSequence instanceof Toast)) {
                break label164;
              }
              paramAnonymousCharSequence.show();
              LimitEditText.this.setText(LimitEditText.e(LimitEditText.this));
              paramAnonymousCharSequence = LimitEditText.this.getText();
              if ((paramAnonymousCharSequence instanceof Spannable)) {
                Selection.setSelection((Spannable)paramAnonymousCharSequence, paramAnonymousCharSequence.length());
              }
            }
          }
        }
        for (;;)
        {
          if (LimitEditText.b(LimitEditText.this) != null) {
            LimitEditText.b(LimitEditText.this).onTextChanged(LimitEditText.e(LimitEditText.this), paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
          return;
          label164:
          VdsAgent.showToast((Toast)paramAnonymousCharSequence);
          break;
          if (paramAnonymousInt3 >= 2)
          {
            paramAnonymousCharSequence = paramAnonymousCharSequence.subSequence(LimitEditText.c(LimitEditText.this) - paramAnonymousInt2, LimitEditText.c(LimitEditText.this) - paramAnonymousInt2 + paramAnonymousInt3);
            if (LimitEditText.this.containsEmoji(paramAnonymousCharSequence.toString()))
            {
              LimitEditText.a(LimitEditText.this, true);
              paramAnonymousCharSequence = Toast.makeText(LimitEditText.d(LimitEditText.this), "暂不支持输入表情符号", 0);
              if (!(paramAnonymousCharSequence instanceof Toast)) {
                paramAnonymousCharSequence.show();
              }
              for (;;)
              {
                LimitEditText.this.setText(LimitEditText.e(LimitEditText.this));
                paramAnonymousCharSequence = LimitEditText.this.getText();
                if (!(paramAnonymousCharSequence instanceof Spannable)) {
                  break;
                }
                Selection.setSelection((Spannable)paramAnonymousCharSequence, paramAnonymousCharSequence.length());
                break;
                VdsAgent.showToast((Toast)paramAnonymousCharSequence);
              }
              LimitEditText.a(LimitEditText.this, false);
            }
          }
        }
      }
    });
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
        this.e = bool;
        label36:
        if ((!this.e) || (!this.f)) {
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
      if (this.e)
      {
        if (paramChar == '⃣')
        {
          this.f = true;
          break label36;
        }
        if (paramChar == 65039) {}
        for (bool = true;; bool = false)
        {
          this.f = bool;
          break;
        }
      }
      this.f = false;
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
  
  public void removeListener()
  {
    this.g = null;
  }
  
  public void setTextChangedListener(a parama)
  {
    if (parama != null) {
      this.g = parama;
    }
  }
  
  public static abstract interface a
  {
    public abstract void afterTextChanged(Editable paramEditable);
    
    public abstract void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/LimitEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */