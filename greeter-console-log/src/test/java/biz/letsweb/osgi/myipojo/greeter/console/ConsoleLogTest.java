package biz.letsweb.osgi.myipojo.greeter.console;

import biz.letsweb.osgi.myipojo.api.greeter.Hello;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.OptionUtils;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;

/**
 *
 * @author toks
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerMethod.class)
public class ConsoleLogTest {

    @Inject
    private Hello hello;

    @Configuration
    public static Option[] configure() {
        CoreOptions.cleanCaches();
//        rawPaxRunnerOption("--definitionURL", "file:platform-equinox-3.6M7.xml");
        Option[] bundles = CoreOptions.options(
                //                                CoreOptions.provision(
                CoreOptions.mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.ipojo").version("1.12.1"),
                //                CoreOptions.mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.ipojo.annotations").version("1.12.1"),
                CoreOptions.bundle("mvn:biz.letsweb.osgi/greeter-api/1.0.0"),
                CoreOptions.bundle("mvn:biz.letsweb.osgi/greeter-hello/1.0.0"),
                //                        CoreOptions.mavenBundle().groupId("org.ow2.chameleon.testing").artifactId("osgi-helpers").versionAsInProject()
                //                        CoreOptions.mavenBundle().groupId("org.ow2.chameleon.mail").artifactId("mail-service").versionAsInProject(),
                //                        CoreOptions.mavenBundle().groupId("org.ow2.chameleon.mail").artifactId("mail-service-impl").versionAsInProject(),
                //                        CoreOptions.mavenBundle().groupId("org.osgi").artifactId("org.osgi.compendium").version("4.2.0"),
                //                                        CoreOptions.mavenBundle().groupId("org.slf4j").artifactId("slf4j-api").versionAsInProject()
                //                        CoreOptions.mavenBundle().groupId("org.slf4j").artifactId("slf4j-simple").versionAsInProject()
                //                ),
//                CoreOptions.mavenBundle().groupId("org.osgi").artifactId("org.osgi.compendium").version("5.0.0").startLevel(1),
                //                CoreOptions.systemPackage("sun.security.util"),
                CoreOptions.systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("WARN"),                        CoreOptions.junitBundles()
        );

        return OptionUtils.combine(bundles);
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("beforeclass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("after class");
    }

    @Before
    public void setUp() {
        System.out.println("setup ...");
    }

    @After
    public void tearDown() {
        System.out.println("teardown ...");
    }

    @Test
    public void testSomeMethod() {
        System.out.println(hello.sayHello("this works"));
    }

}
