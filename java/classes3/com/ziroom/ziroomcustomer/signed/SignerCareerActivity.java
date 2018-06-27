package com.ziroom.ziroomcustomer.signed;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.my.CreditWebActivity;
import com.ziroom.ziroomcustomer.signed.a.l;
import com.ziroom.ziroomcustomer.signed.a.n;
import java.util.List;
import java.util.Map;

public class SignerCareerActivity
  extends BaseActivity
{
  n a;
  List<l> b;
  a c;
  @BindView(2131690588)
  ImageView ivClose;
  @BindView(2131692451)
  ListView lvInfos;
  @BindView(2131690073)
  TextView tvDesc;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a()
  {
    if (this.a == null) {
      return;
    }
    this.tvDesc.setText(this.a.getDesc());
    this.b = this.a.getList();
    this.c = new a();
    this.lvInfos.setAdapter(this.c);
  }
  
  public void onBackPressed()
  {
    finish();
    overridePendingTransition(2130968652, 2130968667);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903501);
    ButterKnife.bind(this);
    this.a = ((n)getIntent().getSerializableExtra("careerList"));
    a();
  }
  
  @OnClick({2131690588})
  public void onViewClicked()
  {
    finish();
    overridePendingTransition(2130968652, 2130968667);
  }
  
  class a
    extends BaseAdapter
  {
    a() {}
    
    public int getCount()
    {
      if (SignerCareerActivity.this.b == null) {
        return 0;
      }
      return SignerCareerActivity.this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return SignerCareerActivity.this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      final l locall;
      if (paramView == null)
      {
        paramViewGroup = new SignerCareerActivity.b(SignerCareerActivity.this);
        paramView = LayoutInflater.from(SignerCareerActivity.this).inflate(2130904527, null);
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131690097));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131690073));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131689822));
        paramView.setTag(paramViewGroup);
        locall = (l)SignerCareerActivity.this.b.get(paramInt);
        paramViewGroup.a.setController(c.frescoController(locall.getIcon()));
        paramViewGroup.b.setText(locall.getTitle());
        if (locall.getStatus() != 0) {
          break label163;
        }
        paramViewGroup.c.setText("去关联");
      }
      for (;;)
      {
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (locall == null)
            {
              com.freelxl.baselibrary.f.g.textToast(SignerCareerActivity.this, "服务器异常，正在努力抢修中，请稍后再试!");
              return;
            }
            switch (locall.getKey())
            {
            default: 
              return;
            case 1: 
              paramAnonymousView = new Intent(SignerCareerActivity.this, SignerCareerInfoActivity.class);
              paramAnonymousView.putExtra("infoNative", locall.getNative());
              paramAnonymousView.putExtra("maimaiClass", SignerAptitudeActivity.class.getName());
              SignerCareerActivity.this.startActivity(paramAnonymousView);
              return;
            }
            paramAnonymousView = new Intent(SignerCareerActivity.this, CreditWebActivity.class);
            Map localMap = com.ziroom.ziroomcustomer.e.g.buildUid();
            paramAnonymousView.putExtra("title", "领英");
            paramAnonymousView.putExtra("url", String.format(locall.getUrl() + "?uid=%s&sign=%s&timestamp=%s", new Object[] { localMap.get("uid"), localMap.get("sign"), localMap.get("timestamp") }));
            SignerCareerActivity.this.startActivity(paramAnonymousView);
          }
        });
        return paramView;
        paramViewGroup = (SignerCareerActivity.b)paramView.getTag();
        break;
        label163:
        paramViewGroup.c.setText("已关联");
      }
    }
  }
  
  class b
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    
    b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerCareerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */