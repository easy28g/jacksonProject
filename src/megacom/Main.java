package megacom;

import megacom.service.JacksonParse;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        JacksonParse jacksonParse = new JacksonParse();
        jacksonParse.getJsonWithJackson();
    }
}
