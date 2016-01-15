package biz.letsweb.osgi.myipojo.greeter.console;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;
import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.service.log.LogService;

/**
 *
 * @author toks
 */
@Component(immediate = true)
@Instantiate
@Provides
public class ConsoleLog implements LogListener {

    @Requires
    LogReaderService logReaderService;
    @Requires
    LogService logService;

    public ConsoleLog() {
        System.out.println("created X");
    }

    @Override
    public void logged(LogEntry entry) {
        if (entry != null) {
            System.out.println(entry.getTime() + " [" + entry.getBundle().getSymbolicName() + "] " + entry.getMessage());
        }
    }

    private void initializeLogReader(LogReaderService logReaderService) {
        logReaderService.addLogListener(this);
        logService.log(LogService.LOG_INFO, "... started ... :)");
    }

    public void bindService(LogReaderService logReaderService) {
        System.out.println("binding ConsoleLog");
        initializeLogReader(logReaderService);
    }

}
