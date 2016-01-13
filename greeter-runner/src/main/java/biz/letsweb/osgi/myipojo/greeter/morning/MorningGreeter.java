package biz.letsweb.osgi.myipojo.greeter.morning;

import biz.letsweb.osgi.myipojo.api.greeter.Hello;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Validate;

/**
 *
 * @author toks
 */
@Component
@Instantiate
public class MorningGreeter implements Runnable {

    /**
     *  Delay between two invocations.
     */
    private static final int DELAY = 5000;

    /**
     * Hello services.
     * Injected by the container.
     * */
    @Requires
    private Hello[] hellos;// = new ArrayList<>();
//    private List<Hello> hellos = new ArrayList<>();

    /**
     * End flag.
     *  */
    private boolean end;

    @Override
    public void run() {
        System.out.println("runnings ...");
        while (!end) {
            try {
                invokeHelloServices();
                Thread.sleep(DELAY);
            } catch (InterruptedException ie) {
                /* will recheck end */
                System.out.println(ie);
            }
        }
    }

    /**
     * Invoke hello services.
     */
    public void invokeHelloServices() {
        System.out.println("number of hellos: " + hellos.length + " " + System.currentTimeMillis() + " ");
        for (Hello h : hellos) {
            final String greeting = h.sayHello("world");
            System.out.print(greeting);
        }
    }

    /**
     * Starting.
     */
    @Validate
    public void starting() {
        System.out.println("starting .... ");
        Thread thread = new Thread(this);
        end = false;
        thread.start();
    }

    /**
     * Stopping.
     */
    @Invalidate
    public void stopping() {
        System.out.println("stopping .... ");
        end = true;
    }
}
