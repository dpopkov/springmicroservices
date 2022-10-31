package learn.springmicroservices.licensing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Slf4j
@Component
public class SystemPropertiesInfoComponent implements ApplicationRunner {

    private static final String JVM_SPEC = "jvmspec";
    private static final String JVM_IMPL = "jvmimpl";

    private final Properties props = System.getProperties();

    @Value("${app.info." + JVM_SPEC + "}")
    private boolean logJvmSpec;
    @Value("${app.info." + JVM_IMPL + "}")
    private boolean logJvmImpl;

    @Override
    public void run(ApplicationArguments args) {
        if (logJvmSpec || args.containsOption(JVM_SPEC)) {
            logJvmSpecificationInfo();
        }
        if (logJvmImpl || args.containsOption(JVM_IMPL)) {
            logJvmImplementationInfo();
        }
    }

    private void logJvmSpecificationInfo() {
        log.info("JVM specification version: {}", props.get("java.vm.specification.version"));
        log.info("JVM specification vendor: {}", props.get("java.vm.specification.vendor"));
        log.info("JVM specification name: {}", props.get("java.vm.specification.name"));
    }

    private void logJvmImplementationInfo() {
        log.info("JVM implementation version: {}", props.get("java.vm.version"));
        log.info("JVM implementation vendor: {}", props.get("java.vm.vendor"));
        log.info("JVM implementation name: {}", props.get("java.vm.name"));
    }
}
