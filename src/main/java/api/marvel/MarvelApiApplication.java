package api.marvel;

import api.marvel.parser.ParserApiMarvel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class MarvelApiApplication implements CommandLineRunner {


    @Value("${api.marvel.parser}")
    private boolean parser;

    @Autowired
    private ParserApiMarvel parserApiMarvel;

    public static void main(String[] args) {
        SpringApplication.run(MarvelApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Parser:" + parser);
        if (parser) {
            parserApiMarvel.parserApi();
        }
    }
}
