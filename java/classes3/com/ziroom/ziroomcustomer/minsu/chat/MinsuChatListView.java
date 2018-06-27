package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.Filter;
import android.widget.ListView;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import java.util.ArrayList;
import java.util.List;

public class MinsuChatListView
  extends ListView
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected float f;
  protected boolean g = true;
  protected final int h = 0;
  protected Context i;
  protected e j;
  protected List<EMConversation> k = new ArrayList();
  Handler l = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
      } while (MinsuChatListView.this.j == null);
      MinsuChatListView.this.j.notifyDataSetChanged();
    }
  };
  private a m;
  
  public MinsuChatListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public MinsuChatListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.i = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MinsuChatListView);
    this.a = paramContext.getColor(0, 2131624576);
    this.b = paramContext.getColor(1, 2131624454);
    this.c = paramContext.getColor(2, 2131624454);
    this.d = paramContext.getDimensionPixelSize(3, 0);
    this.e = paramContext.getDimensionPixelSize(4, 0);
    this.f = paramContext.getDimension(5, 0.0F);
    this.g = paramContext.getBoolean(6, true);
    paramContext.recycle();
  }
  
  public void filter(CharSequence paramCharSequence)
  {
    this.j.getFilter().filter(paramCharSequence);
  }
  
  public EMConversation getItem(int paramInt)
  {
    return this.j.getItem(paramInt);
  }
  
  public void init(List<EMConversation> paramList)
  {
    init(paramList, null);
  }
  
  public void init(List<EMConversation> paramList, a parama)
  {
    this.k = paramList;
    if (parama != null) {
      this.m = parama;
    }
    this.j = new e((Activity)this.i, 0, paramList);
    this.j.setCvsListHelper(this.m);
    this.j.setPrimaryColor(this.a);
    this.j.setPrimarySize(this.d);
    this.j.setSecondaryColor(this.b);
    this.j.setSecondarySize(this.e);
    this.j.setTimeColor(this.c);
    this.j.setTimeSize(this.f);
    setAdapter(this.j);
    setDivider(getResources().getDrawable(2130838383));
    setDividerHeight((int)(ad.dp2px(ApplicationEx.c, 1) / 2.0D + 0.5D));
    setSelector(new ColorDrawable(getResources().getColor(2131624576)));
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
    });
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.g)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void refresh()
  {
    this.l.sendEmptyMessage(0);
  }
  
  public void setConversationListHelper(a parama)
  {
    this.m = parama;
  }
  
  public static abstract interface a
  {
    public abstract String onSetItemSecondaryText(EMMessage paramEMMessage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */