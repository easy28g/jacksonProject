package megacom.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ArrayType;
import megacom.models.Neko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JacksonParse {

    public void getJsonWithJackson() throws IOException {

        URL url = new URL("https://cat-fact.herokuapp.com/facts");
        HttpURLConnection urlConnection =  (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");


        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        //br.close();

        String sbString = String.valueOf(sb);
        System.out.println(sb);
        System.out.println();

        //mapper.readValue(jsonString, new TypeReference<Data<String>>() {});
        List<Neko> nekoArrayList;
        ObjectMapper objectMapper = new ObjectMapper();
        nekoArrayList =  objectMapper.readValue(sbString, new TypeReference<List<Neko>>() { });


        for(Neko item: nekoArrayList){
            System.out.println(item+"\n");
        }

    }

}


