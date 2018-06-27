package com.b.c.c.a;

import com.b.c.g;

public class ae
  extends g<af>
{
  public ae(af paramaf)
  {
    super(paramaf);
  }
  
  private String a()
  {
    return a(514, new String[] { "Normal", "Macro", "View", "Manual" });
  }
  
  private String b()
  {
    return b(516, 3);
  }
  
  private String c()
  {
    return a(526, new String[] { "None", "Standard", "Best", "Adjust Exposure" });
  }
  
  private String d()
  {
    return a(527, new String[] { "Off", "On" });
  }
  
  private String e()
  {
    return a(528, new String[] { "Off", "On" });
  }
  
  private String f()
  {
    return a(531, new String[] { "Off", "On" });
  }
  
  private String g()
  {
    return a(532, new String[] { "Off", "On" });
  }
  
  private String h()
  {
    return a(534, new String[] { "Off", "On" });
  }
  
  private String i()
  {
    return a(535, new String[] { "Record while down", "Press start, press stop" });
  }
  
  private String j()
  {
    return a(536, new String[] { "Off", "On" });
  }
  
  private String k()
  {
    return a(537, new String[] { "Off", "On" });
  }
  
  private String l()
  {
    return a(539, new String[] { "Off", "On" });
  }
  
  private String m()
  {
    return a(541, new String[] { "Off", "On" });
  }
  
  private String n()
  {
    return a(542, new String[] { "No", "Yes" });
  }
  
  private String o()
  {
    return a(543, new String[] { "Off", "Sport", "TV", "Night", "User 1", "User 2", "Lamp" });
  }
  
  private String p()
  {
    return a(548, new String[] { "5 frames/sec", "10 frames/sec", "15 frames/sec", "20 frames/sec" });
  }
  
  private String q()
  {
    return a(549, new String[] { "Auto", "Force", "Disabled", "Red eye" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 515: 
    case 517: 
    case 518: 
    case 519: 
    case 520: 
    case 521: 
    case 522: 
    case 523: 
    case 524: 
    case 525: 
    case 529: 
    case 530: 
    case 533: 
    case 538: 
    case 540: 
    case 544: 
    case 545: 
    case 546: 
    case 547: 
    default: 
      return super.getDescription(paramInt);
    case 513: 
      return getSanyoQualityDescription();
    case 514: 
      return a();
    case 516: 
      return b();
    case 526: 
      return c();
    case 527: 
      return d();
    case 528: 
      return e();
    case 531: 
      return f();
    case 532: 
      return g();
    case 534: 
      return h();
    case 535: 
      return i();
    case 536: 
      return j();
    case 537: 
      return k();
    case 539: 
      return l();
    case 541: 
      return m();
    case 542: 
      return n();
    case 543: 
      return o();
    case 548: 
      return p();
    }
    return q();
  }
  
  public String getSanyoQualityDescription()
  {
    Integer localInteger = ((af)this.a).getInteger(513);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal/Very Low";
    case 1: 
      return "Normal/Low";
    case 2: 
      return "Normal/Medium Low";
    case 3: 
      return "Normal/Medium";
    case 4: 
      return "Normal/Medium High";
    case 5: 
      return "Normal/High";
    case 6: 
      return "Normal/Very High";
    case 7: 
      return "Normal/Super High";
    case 256: 
      return "Fine/Very Low";
    case 257: 
      return "Fine/Low";
    case 258: 
      return "Fine/Medium Low";
    case 259: 
      return "Fine/Medium";
    case 260: 
      return "Fine/Medium High";
    case 261: 
      return "Fine/High";
    case 262: 
      return "Fine/Very High";
    case 263: 
      return "Fine/Super High";
    case 512: 
      return "Super Fine/Very Low";
    case 513: 
      return "Super Fine/Low";
    case 514: 
      return "Super Fine/Medium Low";
    case 515: 
      return "Super Fine/Medium";
    case 516: 
      return "Super Fine/Medium High";
    case 517: 
      return "Super Fine/High";
    case 518: 
      return "Super Fine/Very High";
    }
    return "Super Fine/Super High";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */