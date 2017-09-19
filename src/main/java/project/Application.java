package project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Files;
import java.util.TimeZone;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner fillService() {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
//                userService.addUser(new CustomUser(Role.ADMIN, "admin", "admin", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8"));
//                userService.addUser(new CustomUser(Role.GRAND_ADMIN, "grand", "grand", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8"));
            }
        };
    }

//    private byte[] getBytesFromFile(File file) {
//        byte[] imgData = null;
//        try {
//            imgData = Files.readAllBytes(file.toPath());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return imgData;
//    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(80);
        return factory;
    }
}