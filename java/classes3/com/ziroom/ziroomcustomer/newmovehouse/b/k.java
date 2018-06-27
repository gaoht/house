package com.ziroom.ziroomcustomer.newmovehouse.b;

import android.view.View;
import android.widget.BaseAdapter;

public abstract class k
  extends BaseAdapter
{
  protected int a;
  protected int b = -1;
  
  protected void a(int paramInt)
  {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  protected void a(View paramView1, View paramView2, View paramView3, View paramView4, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i;
    if (paramView1 != null)
    {
      if (paramInt3 % 2 == 0)
      {
        i = 0;
        paramView1.setVisibility(i);
        if (paramInt3 % 11 != 0) {
          break label164;
        }
        i = paramInt2;
        label35:
        paramView1.setBackgroundColor(i);
      }
    }
    else
    {
      if (paramView3 != null)
      {
        if (paramInt3 % 5 != 0) {
          break label171;
        }
        i = 0;
        label55:
        paramView3.setVisibility(i);
        if (paramInt3 % 17 != 0) {
          break label178;
        }
        i = paramInt2;
        label73:
        paramView3.setBackgroundColor(i);
      }
      if (paramView2 != null)
      {
        if (paramInt3 % 3 != 0) {
          break label185;
        }
        i = 0;
        label93:
        paramView2.setVisibility(i);
        if (paramInt3 % 13 != 0) {
          break label192;
        }
        i = paramInt2;
        label111:
        paramView2.setBackgroundColor(i);
      }
      if (paramView4 != null)
      {
        if (paramInt3 % 7 != 0) {
          break label199;
        }
        i = j;
        label134:
        paramView4.setVisibility(i);
        if (paramInt3 % 19 != 0) {
          break label206;
        }
      }
    }
    for (;;)
    {
      paramView4.setBackgroundColor(paramInt2);
      return;
      i = 8;
      break;
      label164:
      i = paramInt1;
      break label35;
      label171:
      i = 8;
      break label55;
      label178:
      i = paramInt1;
      break label73;
      label185:
      i = 8;
      break label93;
      label192:
      i = paramInt1;
      break label111;
      label199:
      i = 8;
      break label134;
      label206:
      paramInt2 = paramInt1;
    }
  }
  
  protected int b(int paramInt)
  {
    int i;
    int k;
    int j;
    if (paramInt == 0)
    {
      i = 210;
      k = i;
      if (this.b != -1)
      {
        j = i;
        if (this.b == paramInt) {
          j = i * 19 * 11 * 17 * 13;
        }
        if ((this.b % this.a <= 0) || (this.b - 1 != paramInt)) {
          break label109;
        }
        k = j * 17;
      }
    }
    label109:
    do
    {
      return k;
      if (paramInt < this.a)
      {
        i = 105;
        break;
      }
      if (paramInt % this.a == 0)
      {
        i = 70;
        break;
      }
      i = 35;
      break;
      if (((this.b + 1) % this.a > 0) && (this.b + 1 == paramInt)) {
        return j * 11;
      }
      if (this.b - this.a == paramInt) {
        return j * 19;
      }
      k = j;
    } while (this.b + this.a != paramInt);
    return j * 13;
  }
  
  protected void setSelectPosition(int paramInt)
  {
    this.b = paramInt;
    notifyDataSetChanged();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */