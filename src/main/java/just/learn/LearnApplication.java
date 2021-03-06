package just.learn;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2Doc
@EnableSwagger2
@EnableTransactionManagement
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}
}
