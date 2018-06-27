package com.ziroom.ziroomcustomer.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.sortlistview.SideBar;
import com.ziroom.ziroomcustomer.account.sortlistview.SideBar.a;
import com.ziroom.ziroomcustomer.account.sortlistview.a;
import com.ziroom.ziroomcustomer.account.sortlistview.b;
import com.ziroom.ziroomcustomer.account.sortlistview.c;
import com.ziroom.ziroomcustomer.account.sortlistview.d;
import java.util.Collections;
import java.util.List;

public class CityListActivity
  extends Activity
{
  private ListView a;
  private SideBar b;
  private TextView c;
  private c d;
  private a e;
  private List<d> f;
  private b g;
  
  private void a()
  {
    this.e = a.getInstance();
    this.g = new b();
    this.b = ((SideBar)findViewById(2131689785));
    this.c = ((TextView)findViewById(2131689784));
    this.b.setTextView(this.c);
    findViewById(2131689781).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CityListActivity.this.finish();
      }
    });
    this.b.setOnTouchingLetterChangedListener(new SideBar.a()
    {
      public void onTouchingLetterChanged(String paramAnonymousString)
      {
        int i = CityListActivity.a(CityListActivity.this).getPositionForSection(paramAnonymousString.charAt(0));
        if (i != -1) {
          CityListActivity.b(CityListActivity.this).setSelection(i);
        }
      }
    });
    this.a = ((ListView)findViewById(2131689783));
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = CityListActivity.this.getIntent();
        paramAnonymousAdapterView.putExtra("cityname", ((d)CityListActivity.a(CityListActivity.this).getItem(paramAnonymousInt)).getName());
        CityListActivity.this.setResult(-1, paramAnonymousAdapterView);
        CityListActivity.this.finish();
      }
    });
    this.f = b();
    Collections.sort(this.f, this.g);
    this.d = new c(this, this.f);
    this.a.setAdapter(this.d);
  }
  
  /* Error */
  private List<d> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 118	com/ziroom/ziroomcustomer/account/CityListActivity:getResources	()Landroid/content/res/Resources;
    //   4: invokevirtual 124	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   7: ldc 126
    //   9: invokevirtual 132	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_2
    //   13: invokestatic 138	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   16: astore 5
    //   18: aload 5
    //   20: aload_2
    //   21: ldc -116
    //   23: invokeinterface 146 3 0
    //   28: aload 5
    //   30: invokeinterface 150 1 0
    //   35: istore_1
    //   36: aconst_null
    //   37: astore_3
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_2
    //   41: astore 4
    //   43: iload_1
    //   44: iconst_1
    //   45: if_icmpeq +69 -> 114
    //   48: iload_1
    //   49: tableswitch	default:+31->80, 0:+42->91, 1:+31->80, 2:+68->117, 3:+124->173
    //   80: aload 5
    //   82: invokeinterface 153 1 0
    //   87: istore_1
    //   88: goto -48 -> 40
    //   91: new 155	java/util/ArrayList
    //   94: dup
    //   95: invokespecial 156	java/util/ArrayList:<init>	()V
    //   98: astore 4
    //   100: aload 4
    //   102: astore_2
    //   103: goto -23 -> 80
    //   106: astore_3
    //   107: aload_3
    //   108: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   111: aload_2
    //   112: astore 4
    //   114: aload 4
    //   116: areturn
    //   117: ldc -95
    //   119: aload 5
    //   121: invokeinterface 165 1 0
    //   126: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifeq -49 -> 80
    //   132: new 173	com/ziroom/ziroomcustomer/account/sortlistview/d
    //   135: dup
    //   136: invokespecial 174	com/ziroom/ziroomcustomer/account/sortlistview/d:<init>	()V
    //   139: astore_3
    //   140: aload_3
    //   141: aload 5
    //   143: ldc -80
    //   145: ldc -78
    //   147: invokeinterface 182 3 0
    //   152: invokevirtual 186	com/ziroom/ziroomcustomer/account/sortlistview/d:setSortLetters	(Ljava/lang/String;)V
    //   155: aload_3
    //   156: aload 5
    //   158: ldc -80
    //   160: ldc -68
    //   162: invokeinterface 182 3 0
    //   167: invokevirtual 191	com/ziroom/ziroomcustomer/account/sortlistview/d:setName	(Ljava/lang/String;)V
    //   170: goto -90 -> 80
    //   173: ldc -95
    //   175: aload 5
    //   177: invokeinterface 165 1 0
    //   182: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   185: ifeq -105 -> 80
    //   188: aload_2
    //   189: aload_3
    //   190: invokeinterface 196 2 0
    //   195: pop
    //   196: aconst_null
    //   197: astore_3
    //   198: goto -118 -> 80
    //   201: astore_3
    //   202: aconst_null
    //   203: astore_2
    //   204: aload_3
    //   205: invokevirtual 197	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   208: aload_2
    //   209: areturn
    //   210: astore_3
    //   211: goto -7 -> 204
    //   214: astore_3
    //   215: goto -11 -> 204
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_2
    //   221: goto -114 -> 107
    //   224: astore_3
    //   225: goto -118 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	CityListActivity
    //   35	53	1	i	int
    //   12	209	2	localObject1	Object
    //   37	1	3	localObject2	Object
    //   106	2	3	localIOException1	java.io.IOException
    //   139	59	3	locald	d
    //   201	4	3	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   210	1	3	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   214	1	3	localXmlPullParserException3	org.xmlpull.v1.XmlPullParserException
    //   218	1	3	localIOException2	java.io.IOException
    //   224	1	3	localIOException3	java.io.IOException
    //   41	74	4	localObject3	Object
    //   16	160	5	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    // Exception table:
    //   from	to	target	type
    //   91	100	106	java/io/IOException
    //   117	170	106	java/io/IOException
    //   173	196	106	java/io/IOException
    //   0	36	201	org/xmlpull/v1/XmlPullParserException
    //   80	88	210	org/xmlpull/v1/XmlPullParserException
    //   91	100	214	org/xmlpull/v1/XmlPullParserException
    //   117	170	214	org/xmlpull/v1/XmlPullParserException
    //   173	196	214	org/xmlpull/v1/XmlPullParserException
    //   0	36	218	java/io/IOException
    //   80	88	224	java/io/IOException
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903072);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/CityListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */