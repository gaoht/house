package com.ziroom.commonlibrary.widget.gridpasswordview.imebugfixer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;

public class ImeDelBugFixedEditText
  extends EditText
{
  private a a;
  
  public ImeDelBugFixedEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImeDelBugFixedEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ImeDelBugFixedEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return new b(super.onCreateInputConnection(paramEditorInfo), true);
  }
  
  public void setDelKeyEventListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onDeleteClick();
  }
  
  private class b
    extends InputConnectionWrapper
  {
    public b(InputConnection paramInputConnection, boolean paramBoolean)
    {
      super(paramBoolean);
    }
    
    public boolean deleteSurroundingText(int paramInt1, int paramInt2)
    {
      if ((paramInt1 == 1) && (paramInt2 == 0)) {
        return (sendKeyEvent(new KeyEvent(0, 67))) && (sendKeyEvent(new KeyEvent(1, 67)));
      }
      return super.deleteSurroundingText(paramInt1, paramInt2);
    }
    
    public boolean sendKeyEvent(KeyEvent paramKeyEvent)
    {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 67) && (ImeDelBugFixedEditText.a(ImeDelBugFixedEditText.this) != null))
      {
        ImeDelBugFixedEditText.a(ImeDelBugFixedEditText.this).onDeleteClick();
        return true;
      }
      return super.sendKeyEvent(paramKeyEvent);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/gridpasswordview/imebugfixer/ImeDelBugFixedEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */