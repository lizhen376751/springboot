package com.lizhen.springboot.eurekaclient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by lizhen on 2018/4/10 0010.
 */
@RestController
public class GetNameController {
    @RequestMapping("/getName")
    public ArrayList<String> getName(){
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("lizhen1");
        arrayList.add("lizhen2");
        arrayList.add("lizhen3");
        arrayList.add("lizhen4");
        return arrayList;
    }
}
