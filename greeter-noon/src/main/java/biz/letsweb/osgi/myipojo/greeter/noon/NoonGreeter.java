package biz.letsweb.osgi.myipojo.greeter.noon;

import biz.letsweb.osgi.myipojo.api.greeter.Hello;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;

/**
 *
 * @author toks
 */
@Component
@Instantiate
@Provides
public class NoonGreeter implements Hello {

    @Override
    public String sayHello(String name) {
        return "Good noon-time :) " + name;
    }

}
