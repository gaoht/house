package butterknife;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface BindBool
{
  int value();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/butterknife/BindBool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */