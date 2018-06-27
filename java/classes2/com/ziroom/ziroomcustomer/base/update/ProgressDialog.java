package com.ziroom.ziroomcustomer.base.update;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.NumberFormat;

public class ProgressDialog
  extends Dialog
{
  public static final int STYLE_HORIZONTAL = 1;
  public static final int STYLE_SPINNER = 0;
  private boolean mHasStarted;
  private int mIncrementBy;
  private int mIncrementSecondaryBy;
  private boolean mIndeterminate;
  private Drawable mIndeterminateDrawable;
  private int mMax;
  private CharSequence mMessage;
  private TextView mMessageView;
  private ProgressBar mProgress;
  private Drawable mProgressDrawable;
  private TextView mProgressNumber;
  private String mProgressNumberFormat;
  private TextView mProgressPercent;
  private NumberFormat mProgressPercentFormat;
  private int mProgressStyle = 0;
  private int mProgressVal;
  private int mSecondaryProgressVal;
  private String mTitle = "";
  private Handler mViewUpdateHandler;
  private TextView tvTitle;
  
  public ProgressDialog(Context paramContext)
  {
    this(paramContext, 2131427695);
  }
  
  public ProgressDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void onProgressChanged()
  {
    if (this.mProgressStyle == 1) {
      this.mViewUpdateHandler.sendEmptyMessage(0);
    }
  }
  
  public static ProgressDialog showHorizontal(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = new ProgressDialog(paramContext);
    paramContext.setTitle(paramCharSequence);
    paramContext.setIndeterminate(paramBoolean1);
    paramContext.setCancelable(paramBoolean2);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.setProgressStyle(1);
    paramContext.show();
    return paramContext;
  }
  
  public int getMax()
  {
    if (this.mProgress != null) {
      return this.mProgress.getMax();
    }
    return this.mMax;
  }
  
  public int getProgress()
  {
    if (this.mProgress != null) {
      return this.mProgress.getProgress();
    }
    return this.mProgressVal;
  }
  
  public int getSecondaryProgress()
  {
    if (this.mProgress != null) {
      return this.mProgress.getSecondaryProgress();
    }
    return this.mSecondaryProgressVal;
  }
  
  public void incrementProgressBy(int paramInt)
  {
    if (this.mProgress != null)
    {
      this.mProgress.incrementProgressBy(paramInt);
      onProgressChanged();
      return;
    }
    this.mIncrementBy += paramInt;
  }
  
  public void incrementSecondaryProgressBy(int paramInt)
  {
    if (this.mProgress != null)
    {
      this.mProgress.incrementSecondaryProgressBy(paramInt);
      onProgressChanged();
      return;
    }
    this.mIncrementSecondaryBy += paramInt;
  }
  
  public boolean isIndeterminate()
  {
    if (this.mProgress != null) {
      return this.mProgress.isIndeterminate();
    }
    return this.mIndeterminate;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903689);
    setCanceledOnTouchOutside(false);
    this.mProgress = ((ProgressBar)findViewById(2131692289));
    this.mProgressNumber = ((TextView)findViewById(2131693285));
    this.mProgressNumberFormat = "%d/%d";
    this.mProgressPercent = ((TextView)findViewById(2131693284));
    this.mProgressPercentFormat = NumberFormat.getPercentInstance();
    this.mProgressPercentFormat.setMaximumFractionDigits(0);
    this.tvTitle = ((TextView)findViewById(2131689541));
    this.tvTitle.setText(this.mTitle);
    this.mViewUpdateHandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        int i = ProgressDialog.this.mProgress.getProgress();
        int j = ProgressDialog.this.mProgress.getMax();
        double d = i / j;
        paramAnonymousMessage = ProgressDialog.this.mProgressNumberFormat;
        ProgressDialog.this.mProgressNumber.setText(String.format(paramAnonymousMessage, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        paramAnonymousMessage = new SpannableString(ProgressDialog.this.mProgressPercentFormat.format(d));
        paramAnonymousMessage.setSpan(new StyleSpan(1), 0, paramAnonymousMessage.length(), 33);
        ProgressDialog.this.mProgressPercent.setText(paramAnonymousMessage);
      }
    };
    if (this.mMax > 0) {
      setMax(this.mMax);
    }
    if (this.mProgressVal > 0) {
      setProgress(this.mProgressVal);
    }
    if (this.mSecondaryProgressVal > 0) {
      setSecondaryProgress(this.mSecondaryProgressVal);
    }
    if (this.mIncrementBy > 0) {
      incrementProgressBy(this.mIncrementBy);
    }
    if (this.mIncrementSecondaryBy > 0) {
      incrementSecondaryProgressBy(this.mIncrementSecondaryBy);
    }
    if (this.mProgressDrawable != null) {
      setProgressDrawable(this.mProgressDrawable);
    }
    if (this.mIndeterminateDrawable != null) {
      setIndeterminateDrawable(this.mIndeterminateDrawable);
    }
    setIndeterminate(this.mIndeterminate);
    onProgressChanged();
    super.onCreate(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.mHasStarted = true;
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mHasStarted = false;
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    if (this.mProgress != null)
    {
      this.mProgress.setIndeterminate(paramBoolean);
      return;
    }
    this.mIndeterminate = paramBoolean;
  }
  
  public void setIndeterminateDrawable(Drawable paramDrawable)
  {
    if (this.mProgress != null)
    {
      this.mProgress.setIndeterminateDrawable(paramDrawable);
      return;
    }
    this.mIndeterminateDrawable = paramDrawable;
  }
  
  public void setMax(int paramInt)
  {
    if (this.mProgress != null)
    {
      this.mProgress.setMax(paramInt);
      onProgressChanged();
      return;
    }
    this.mMax = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    if (this.mHasStarted)
    {
      this.mProgress.setProgress(paramInt);
      onProgressChanged();
      return;
    }
    this.mProgressVal = paramInt;
  }
  
  public void setProgressDrawable(Drawable paramDrawable)
  {
    if (this.mProgress != null)
    {
      this.mProgress.setProgressDrawable(paramDrawable);
      return;
    }
    this.mProgressDrawable = paramDrawable;
  }
  
  public void setProgressNumberFormat(String paramString)
  {
    this.mProgressNumberFormat = paramString;
  }
  
  public void setProgressStyle(int paramInt)
  {
    this.mProgressStyle = paramInt;
  }
  
  public void setSecondaryProgress(int paramInt)
  {
    if (this.mProgress != null)
    {
      this.mProgress.setSecondaryProgress(paramInt);
      onProgressChanged();
      return;
    }
    this.mSecondaryProgressVal = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
    if (this.tvTitle != null) {
      this.tvTitle.setText(this.mTitle);
    }
  }
  
  public void show()
  {
    super.show();
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = localDisplay.getWidth();
      localWindow.setAttributes(localLayoutParams);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/update/ProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */