import com.zhy.collector.Collector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Package PACKAGE_NAME
 * @Description:
 * @User: zengqiang
 * @Date: 2018-09-13
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.zhy.modules.*.dao"})
public class TestApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        SpringApplication newRun= new SpringApplication(TestApplication.class);
        Collector collector = new Collector();
 		collector.init();
		collector.start();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TestApplication.class);
    }
}