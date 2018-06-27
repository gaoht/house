package com.ziroom.ziroomcustomer.signed.widget;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.Keyboard.Key;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.text.Editable;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import java.util.Iterator;
import java.util.List;

public class a
{
  public boolean a = true;
  public boolean b = false;
  private Context c;
  private Activity d;
  private KeyboardView e;
  private KeyboardView f;
  private Keyboard g;
  private Keyboard h;
  private LinearLayout i;
  private EditText j;
  private KeyboardView.OnKeyboardActionListener k = new KeyboardView.OnKeyboardActionListener()
  {
    public void onKey(int paramAnonymousInt, int[] paramAnonymousArrayOfInt)
    {
      paramAnonymousArrayOfInt = VdsAgent.trackEditTextSilent(a.a(a.this));
      int i = VdsAgent.trackEditTextSilent(a.a(a.this)).length();
      if (paramAnonymousInt == -3) {
        a.this.hideKeyboard();
      }
      do
      {
        do
        {
          do
          {
            return;
            if (paramAnonymousInt != -5) {
              break;
            }
          } while ((paramAnonymousArrayOfInt == null) || (paramAnonymousArrayOfInt.length() <= 0) || (i <= 0));
          paramAnonymousArrayOfInt.delete(i - 1, i);
          return;
          if (paramAnonymousInt == -1)
          {
            a.b(a.this);
            a.d(a.this).setKeyboard(a.c(a.this));
            return;
          }
          if (paramAnonymousInt == -2)
          {
            if (a.this.a)
            {
              a.this.a = false;
              a.d(a.this).setKeyboard(a.c(a.this));
              return;
            }
            a.this.a = true;
            a.d(a.this).setKeyboard(a.e(a.this));
            return;
          }
          if (paramAnonymousInt != 57419) {
            break;
          }
        } while (i <= 0);
        a.a(a.this).setSelection(i - 1);
        return;
        if (paramAnonymousInt != 57421) {
          break;
        }
      } while (i >= a.a(a.this).length());
      a.a(a.this).setSelection(i + 1);
      return;
      paramAnonymousArrayOfInt.insert(i, Character.toString((char)paramAnonymousInt));
    }
    
    public void onPress(int paramAnonymousInt) {}
    
    public void onRelease(int paramAnonymousInt) {}
    
    public void onText(CharSequence paramAnonymousCharSequence) {}
    
    public void swipeDown() {}
    
    public void swipeLeft() {}
    
    public void swipeRight() {}
    
    public void swipeUp() {}
  };
  
  public a(Activity paramActivity, Context paramContext, EditText paramEditText)
  {
    this.d = paramActivity;
    this.c = paramContext;
    this.j = paramEditText;
    this.g = new Keyboard(paramContext, 2131099648);
    this.h = new Keyboard(paramContext, 2131099648);
    this.i = ((LinearLayout)paramActivity.findViewById(2131690122));
    this.e = ((KeyboardView)paramActivity.findViewById(2131690124));
    this.f = ((KeyboardView)paramActivity.findViewById(2131693011));
    this.f.setKeyboard(this.g);
    this.e.setKeyboard(this.g);
    this.e.setEnabled(true);
    this.e.setPreviewEnabled(false);
    this.e.setOnKeyboardActionListener(this.k);
  }
  
  private void a()
  {
    Object localObject = this.h.getKeys();
    Keyboard.Key localKey;
    if (this.b)
    {
      this.b = false;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localKey = (Keyboard.Key)((Iterator)localObject).next();
        if ((localKey.label != null) && (a(localKey.label.toString())))
        {
          localKey.label = localKey.label.toString().toLowerCase();
          localKey.codes[0] += 32;
        }
      }
    }
    this.b = true;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localKey = (Keyboard.Key)((Iterator)localObject).next();
      if ((localKey.label != null) && (a(localKey.label.toString())))
      {
        localKey.label = localKey.label.toString().toUpperCase();
        localKey.codes[0] -= 32;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return "abcdefghijklmnopqrstuvwxyz".indexOf(paramString.toLowerCase()) > -1;
  }
  
  public void hideKeyboard()
  {
    if (this.i.getVisibility() == 0)
    {
      this.i.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
    }
  }
  
  public void showKeyboard()
  {
    int m = this.i.getVisibility();
    if ((m == 8) || (m == 4))
    {
      this.i.setVisibility(0);
      this.e.setVisibility(0);
      this.f.setVisibility(4);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */