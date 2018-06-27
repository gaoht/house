package com.ziroom.ziroomcustomer.newchat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

public class PasteEditText
  extends EditText
{
  private Context a;
  
  public PasteEditText(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public PasteEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public PasteEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramCharSequence.toString().startsWith("EASEMOBIMG"))) {
      setText("");
    }
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  @SuppressLint({"NewApi"})
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (paramInt == 16908322)
    {
      Object localObject = (ClipboardManager)getContext().getSystemService("clipboard");
      if ((localObject == null) || (((ClipboardManager)localObject).getText() == null)) {
        return false;
      }
      localObject = ((ClipboardManager)localObject).getText().toString();
      if (((String)localObject).startsWith("EASEMOBIMG"))
      {
        localObject = ((String)localObject).replace("EASEMOBIMG", "");
        Intent localIntent = new Intent(this.a, AlertDialog.class);
        localIntent.putExtra("title", "发送以下图片");
        localIntent.putExtra("forwardImage", (String)localObject);
        localIntent.putExtra("cancel", true);
        ((Activity)this.a).startActivityForResult(localIntent, 11);
      }
    }
    return super.onTextContextMenuItem(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/PasteEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */