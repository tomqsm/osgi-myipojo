package biz.letsweb.osgi.myipojo.greeter.command;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.ServiceProperty;
import org.apache.felix.service.command.Descriptor;

/**
 *
 * @author toks
 */
@Component(immediate = true)
@Instantiate
@Provides(specifications = GreeterCommand.class)
public class GreeterCommand {

    @ServiceProperty(name = "osgi.command.scope", value = "test")
    private String scope;

    @ServiceProperty(name = "osgi.command.function", value = "{}")
    private String[] function = new String[]{"test"};

    @Descriptor("test")
    public void test() {
        System.out.println("test!");
    }
}
