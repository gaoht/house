package c.a.b.c;

import c.a.b.a.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class d
  extends c
{
  private String e()
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat.format(localCalendar.getTime());
  }
  
  public c.a.b.a.c a(c.a.b.a.a parama, i parami)
    throws c.a.b.d.d
  {
    super.a(parama, parami);
    parami.a("Web Socket Protocol Handshake");
    parami.a("Server", "TooTallNate Java-WebSocket");
    parami.a("Date", e());
    return parami;
  }
  
  public a c()
  {
    return new d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */