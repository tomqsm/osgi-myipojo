package biz.letsweb.osgi.myipojo.greeter.morning;

import biz.letsweb.osgi.myipojo.api.greeter.Hello;

/**
 *
 * @author toks
 */
public class MorningGreeter implements Runnable {

    /**
     *  Delay between two invocations.
     */
    private static final int DELAY = 10000;

    /**
     * Hello services.
     * Injected by the container.
     * */
    private Hello[] hellos;// = new ArrayList<>();
//    private List<Hello> hellos = new ArrayList<>();

    /**
     * End flag.
     *  */
    private boolean end;

    @Override
    public void run() {
        System.out.println("running ...");
        while (!end) {
            try {
                invokeHelloServices();
                Thread.sleep(DELAY);
            } catch (InterruptedException ie) {
                /* will recheck end */
            }
        }
    }

    /**
     * Invoke hello services.
     */
    public void invokeHelloServices() {
        for (Hello h : hellos) {
            h.sayHello("world");
        }
    }

    /**
     * Starting.
     */
    public void starting() {
        System.out.println("starting .... ");
        Thread thread = new Thread(this);
        end = false;
        thread.start();
    }

    /**
     * Stopping.
     */
    public void stopping() {
        System.out.println("stopping .... ");
        end = true;
    }
}
