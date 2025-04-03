package com.study.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/daily-box-office")
    public String getDailyBoxOffice(@RequestParam(required = false) String date, Model model) {
        // 날짜가 없으면 기본값으로 어제 날짜 사용
        if (date == null || date.isEmpty()) {
            date = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        }

        // 영화진흥회 API에서 데이터 가져오기
        String result = movieService.getDailyBoxOffice(date);

        // JSON 파싱 (간단한 예제)
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> data;
        try {
            data = objectMapper.readValue(result, new TypeReference<>() {});
        } catch (Exception e) {
            model.addAttribute("error", "데이터를 불러오는 데 실패했습니다.");
            return "movies";
        }

        // Thymeleaf로 데이터 전달
        model.addAttribute("movieData", data);
        return "movies";  // movies.html로 이동
    }
}