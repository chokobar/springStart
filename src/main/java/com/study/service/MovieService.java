package com.study.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    private final String API_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
    private final String API_KEY = "32b9e80ddb27ce292a893344abcd9488";

    public String getDailyBoxOffice(String date) {
        String url = API_URL + "?key=" + API_KEY + "&targetDt=" + date;

        // RestTemplate을 이용해 API 요청 후 JSON 응답 반환
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}