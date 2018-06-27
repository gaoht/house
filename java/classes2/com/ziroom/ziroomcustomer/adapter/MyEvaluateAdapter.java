package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.f;
import com.ziroom.ziroomcustomer.model.EvaluateOption;
import com.ziroom.ziroomcustomer.model.EvaluateSubOption;
import com.ziroom.ziroomcustomer.model.EvaluateWithStar;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar.a;
import com.ziroom.ziroomcustomer.signed.EvaluateLineBreakView;
import java.util.List;

public class MyEvaluateAdapter
  extends BaseAdapter
{
  private Context a;
  private List<EvaluateWithStar> b;
  private int c;
  private int d;
  
  public MyEvaluateAdapter(List<EvaluateWithStar> paramList, Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.b = paramList;
    this.d = paramInt;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.a, 2130903906, null);
    }
    paramView = new viewHolder(paramViewGroup);
    final EvaluateWithStar localEvaluateWithStar = (EvaluateWithStar)this.b.get(paramInt);
    if (localEvaluateWithStar == null) {
      return paramViewGroup;
    }
    if (("ZOXQCP".equals(localEvaluateWithStar.getEvsceneCode())) || ("ZODKCP".equals(localEvaluateWithStar.getEvsceneCode())))
    {
      paramView.siv_room_icon.setController(c.frescoController(localEvaluateWithStar.getPhotoUrl()));
      paramView.siv_room_icon.setVisibility(0);
      paramView.siv_icon.setVisibility(8);
    }
    int i;
    int j;
    for (;;)
    {
      paramView.tv_title.setText(localEvaluateWithStar.getProName());
      paramView.tv_title_top.setText(localEvaluateWithStar.getTitle());
      paramView.tv_content_top.setText(localEvaluateWithStar.getMark());
      paramView.et.setHint(localEvaluateWithStar.getTip());
      if (this.d != 1) {
        break label598;
      }
      if (localEvaluateWithStar.getOptions() == null) {
        break label748;
      }
      i = 0;
      for (j = -1; i < localEvaluateWithStar.getOptions().size(); j = k)
      {
        k = j;
        if (localEvaluateWithStar.getOptions().get(i) != null)
        {
          k = j;
          if (1 == ((EvaluateOption)localEvaluateWithStar.getOptions().get(i)).getSelected()) {
            k = i;
          }
        }
        i += 1;
      }
      paramView.siv_room_icon.setVisibility(8);
      paramView.siv_icon.setVisibility(0);
      paramView.siv_icon.setController(c.frescoController(localEvaluateWithStar.getPhotoUrl()));
    }
    label522:
    label543:
    label574:
    label598:
    label694:
    label706:
    label748:
    for (int k = j;; k = -1)
    {
      if (k >= 0)
      {
        paramView.rs_star.setStarScore(k + 1);
        localEvaluateWithStar.setRate(k);
        if (localEvaluateWithStar.getOptions().get(k) != null)
        {
          i = 0;
          for (j = -1;; j = m)
          {
            m = j;
            if (i >= ((EvaluateOption)localEvaluateWithStar.getOptions().get(k)).getSubOptions().size()) {
              break;
            }
            m = j;
            if (((EvaluateOption)localEvaluateWithStar.getOptions().get(k)).getSubOptions() != null)
            {
              m = j;
              if (1 == ((EvaluateSubOption)((EvaluateOption)localEvaluateWithStar.getOptions().get(k)).getSubOptions().get(i)).getSelected()) {
                m = i;
              }
            }
            i += 1;
          }
        }
        int m = -1;
        if ((localEvaluateWithStar.getOptions() != null) && (k > 0) && (k <= localEvaluateWithStar.getOptions().size()))
        {
          if (localEvaluateWithStar.getOptions().get(k) != null) {
            paramView.pay_terms_tags.setLables(((EvaluateOption)localEvaluateWithStar.getOptions().get(k)).getSubOptions(), false);
          }
          paramView.fl.setVisibility(0);
          if (m < 0) {
            break label694;
          }
          paramView.pay_terms_tags.setVisibility(0);
          if (!f.notNull(localEvaluateWithStar.getAnswers())) {
            break label706;
          }
          paramView.fl.setVisibility(0);
          paramView.et.setText(localEvaluateWithStar.getAnswers());
          paramView.rs_star.setVisibility(0);
        }
      }
      for (;;)
      {
        paramView.rs_star.setImgIsClick(false);
        paramView.et.setEnabled(false);
        paramView.rs_star.setOnStarScoreListener(new RatingStar.a()
        {
          public void starScore(int paramAnonymousInt)
          {
            localEvaluateWithStar.setRate(paramAnonymousInt);
            if ((localEvaluateWithStar.getOptions() != null) && (paramAnonymousInt > 0) && (paramAnonymousInt <= localEvaluateWithStar.getOptions().size())) {
              if (localEvaluateWithStar.getOptions().get(paramAnonymousInt - 1) != null) {
                paramView.pay_terms_tags.setLables(((EvaluateOption)localEvaluateWithStar.getOptions().get(paramAnonymousInt - 1)).getSubOptions(), true);
              }
            }
            for (;;)
            {
              paramView.fl.setVisibility(0);
              paramView.pay_terms_tags.setVisibility(0);
              return;
              paramView.pay_terms_tags.setLables(null, false);
            }
          }
        });
        paramView.et.addTextChangedListener(new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymousEditable)
          {
            localEvaluateWithStar.setSuggestContent(paramAnonymousEditable.toString());
          }
          
          public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
        paramView.et.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            if (paramAnonymousMotionEvent.getAction() == 1) {
              MyEvaluateAdapter.a(MyEvaluateAdapter.this, paramInt);
            }
            return false;
          }
        });
        paramView.et.clearFocus();
        if ((this.c == -1) || (this.c != paramInt)) {
          break;
        }
        paramView.et.requestFocus();
        return paramViewGroup;
        paramView.pay_terms_tags.setLables(null, false);
        break label522;
        paramView.pay_terms_tags.setVisibility(8);
        break label543;
        paramView.fl.setVisibility(8);
        paramView.et.setText("");
        break label574;
        paramView.fl.setVisibility(8);
        paramView.pay_terms_tags.setVisibility(8);
      }
    }
  }
  
  public List<EvaluateWithStar> getmList()
  {
    return this.b;
  }
  
  public void setmList(List<EvaluateWithStar> paramList)
  {
    this.b = paramList;
  }
  
  class viewHolder
  {
    @BindView(2131691275)
    EditText et;
    @BindView(2131690607)
    FrameLayout fl;
    @BindView(2131694030)
    EvaluateLineBreakView pay_terms_tags;
    @BindView(2131690595)
    RatingStar rs_star;
    @BindView(2131691839)
    SimpleDraweeView siv_icon;
    @BindView(2131694027)
    SimpleDraweeView siv_room_icon;
    @BindView(2131694029)
    TextView tv_content_top;
    @BindView(2131689541)
    TextView tv_title;
    @BindView(2131694028)
    TextView tv_title_top;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/MyEvaluateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */