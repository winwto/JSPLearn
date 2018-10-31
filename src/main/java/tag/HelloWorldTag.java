package tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Date;

/**
 * 自定义标签类
 */
public class HelloWorldTag extends SimpleTagSupport {
    @Override
    public void doTag() throws IOException {
        getJspContext().getOut().write("Hello World" + " " + new Date());
    }
}
