package apiGson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Post[] posts = gson.fromJson(getStringFromServer("https://jsonplaceholder.typicode.com/posts"),Post[].class);
        //печать постов
        for (Post post : posts){
            System.out.println(post);
        }
        //
        System.out.println("*************************************");

        Album[] albums = gson.fromJson(getStringFromServer("https://jsonplaceholder.typicode.com/albums"),Album[].class);
        for (Album album : albums){
            System.out.println(album);
        }

        System.out.println("*************************************");
        System.out.println("валюта");
        Valute valute = gson.fromJson(getStringFromServer("https://www.cbr-xml-daily.ru/daily_json.js"),Valute.class);
        System.out.println(valute);
        System.out.println(valute.valute.usd.value);
        System.out.println(valute.valute.usd.previous);
        double dinamika = valute.valute.usd.previous - valute.valute.usd.value;
        if (dinamika < 0) {
            System.out.println("рост курса на " + -dinamika);

        }
        else if (dinamika == 0)
            System.out.println("курс не изменился");
        else
            System.out.println("падение курса на " + dinamika);
    }

    //подключение к серверу
    static StringBuffer content;
    static HttpURLConnection connection;

    static String getStringFromServer(String adress){
        BufferedReader reader;
        String line;
        content = new StringBuffer();

        try {
            URL url = new URL(adress);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);

            //коды ответа сервера
            int status = connection.getResponseCode();
            System.out.println(status);

            if (status > 299) {
                System.out.println("ошибка сервера");
            }
            else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                reader.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }


        return content.toString();
    }

}
