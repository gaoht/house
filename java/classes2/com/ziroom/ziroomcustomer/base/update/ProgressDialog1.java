package com.ziroom.ziroomcustomer.base.update;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.NumberFormat;

public class ProgressDialog1
  extends AlertDialog
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
  
  public ProgressDialog1(Context paramContext)
  {
    this(paramContext, 2131427803);
  }
  
  public ProgressDialog1(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public ProgressDialog1(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  private void onProgressChanged()
  {
    if (this.mProgressStyle == 1) {
      this.mViewUpdateHandler.sendEmptyMessage(0);
    }
  }
  
  public static ProgressDialog1 show(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return show(paramContext, paramCharSequence1, paramCharSequence2, false);
  }
  
  public static ProgressDialog1 show(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener, CharSequence paramCharSequence3, CharSequence paramCharSequence4, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new ProgressDialog1(paramContext);
    paramContext.setTitle(paramCharSequence1);
    paramContext.setMessage(paramCharSequence2);
    paramContext.setIndeterminate(false);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.setProgressStyle(paramInt);
    if (paramCharSequence3 != null) {
      paramContext.setButton(-1, paramCharSequence3, paramOnClickListener);
    }
    if (paramCharSequence4 != null) {
      paramContext.setButton(-3, paramCharSequence4, paramOnClickListener);
    }
    paramContext.show();
    return paramContext;
  }
  
  public static ProgressDialog1 show(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    return show(paramContext, paramCharSequence1, paramCharSequence2, paramBoolean, false, null);
  }
  
  public static ProgressDialog1 show(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return show(paramContext, paramCharSequence1, paramCharSequence2, paramBoolean1, paramBoolean2, null);
  }
  
  public static ProgressDialog1 show(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = new ProgressDialog1(paramContext);
    paramContext.setTitle(paramCharSequence1);
    paramContext.setMessage(paramCharSequence2);
    paramContext.setIndeterminate(paramBoolean1);
    paramContext.setCancelable(paramBoolean2);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
    return paramContext;
  }
  
  public static ProgressDialog1 showHorizontal(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = new ProgressDialog1(paramContext);
    paramContext.setMessage(paramCharSequence2);
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
    Object localObject = LayoutInflater.from(getContext());
    if (this.mProgressStyle == 1)
    {
      localObject = ((LayoutInflater)localObject).inflate(2130903689, null);
      this.mProgress = ((ProgressBar)((View)localObject).findViewById(2131692289));
      this.mProgressNumber = ((TextView)((View)localObject).findViewById(2131693285));
      this.mProgressNumberFormat = "%d/%d";
      this.mProgressPercent = ((TextView)((View)localObject).findViewById(2131693284));
      this.mProgressPercentFormat = NumberFormat.getPercentInstance();
      this.mProgressPercentFormat.setMaximumFractionDigits(0);
      this.tvTitle = ((TextView)((View)localObject).findViewById(2131689541));
      this.tvTitle.setText(this.mTitle);
      this.mViewUpdateHandler = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          super.handleMessage(paramAnonymousMessage);
          int i = ProgressDialog1.this.mProgress.getProgress();
          int j = ProgressDialog1.this.mProgress.getMax();
          double d = i / j;
          paramAnonymousMessage = ProgressDialog1.this.mProgressNumberFormat;
          ProgressDialog1.this.mProgressNumber.setText(String.format(paramAnonymousMessage, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          paramAnonymousMessage = new SpannableString(ProgressDialog1.this.mProgressPercentFormat.format(d));
          paramAnonymousMessage.setSpan(new StyleSpan(1), 0, paramAnonymousMessage.length(), 33);
          ProgressDialog1.this.mProgressPercent.setText(paramAnonymousMessage);
        }
      };
      setView((View)localObject);
    }
    for (;;)
    {
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
      if (this.mMessage != null) {
        setMessage(this.mMessage);
      }
      setIndeterminate(this.mIndeterminate);
      onProgressChanged();
      super.onCreate(paramBundle);
      return;
      localObject = ((LayoutInflater)localObject).inflate(2130903691, null);
      this.mProgress = ((ProgressBar)((View)localObject).findViewById(2131692289));
      this.mMessageView = ((TextView)((View)localObject).findViewById(2131693290));
      setView((View)localObject);
    }
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
  
  public void setMessage(CharSequence paramCharSequence)
  {
    if (this.mProgress != null)
    {
      if (this.mProgressStyle == 1)
      {
        super.setMessage(paramCharSequence);
        return;
      }
      this.mMessageView.setText(paramCharSequence);
      return;
    }
    this.mMessage = paramCharSequence;
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/update/ProgressDialog1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */