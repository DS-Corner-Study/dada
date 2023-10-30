package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/get-api")
public class GetController {


    // http://localhost:8080/api/v1/get-api/hello

    // @RequestMapping으로 구현하기
//    @RequestMapping(value = "hello", method = RequestMethod.GET)
//    public String getHello() {
//        return "Hello World";
//    }

    // 매개변수가 없는 GET 메서드 구현
//    @GetMapping(value = "/name")
//    public String getName() {
//        return "Flature";
//    }

    /*
    // @PathVariable을 활용한 GET 메서드 구현
    @GetMapping(value = "/varialbe1/{variable}")
    public String getVariable1(@PathVariable String variable) {
            return variable;
    }

    // @PathVariable에 변수명을 매핑하는 방법
    @GetMapping(value = "/varialbe2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }


    // @RequestParam을 활용한 GET 메서드 구현
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // @RequestParam과 Map을 조합한 GET 메서드 구현
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> Param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }
     */

    // DTO 객체를 활용한 GET 메서드 구현
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto) {
        // return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
        return memberDto.toString();
    }
}
