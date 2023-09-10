package com.lr1springboot.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value="name", defaultValue="World") String name){
        return String.format("Hello %s!", name);
    }

    ArrayList<String>list;
    HashMap<Integer,String>map;
    int counter;
    String info;

    @GetMapping("/update-array")
    public String updatearray(@RequestParam(value = "item",defaultValue="World") String item){
        
        if(list==null){
            list=new ArrayList<>();
            info="Array created! Now you can save your Items";
        }else{
            list.add(item);
            info=item+" was added to list!";
        }
        return info;
    }

    @GetMapping("/show-array")
    public String showArrayList(){
        String result="";
        if(list!=null&&!list.isEmpty()){
            for (String string : list) {
                result+=string+'\n';
            }
            
        }else{
            result+="Nothing to show";
        }
        return result;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "item", defaultValue = "World") String item){
        if(map==null){
            counter=0;
            map=new HashMap<>();
            info="Map created! Now you can save your Items";
        }else{
            map.put(counter, item);
            counter+=1;
            info=item+" was added to map!";
        }
        return info;
    }


    @GetMapping("/show-map")
    public String showHashMap(){
        String result="";
        if(map!=null&&!map.isEmpty()){
            for (Map.Entry<Integer, String> pair: map.entrySet()) {
                result+=pair.getKey()+":"+pair.getValue()+"\n";
            }
            
        }else{
            result+="Nothing to show";
        }
        return result;
    }

    @GetMapping("/show-all-lenght")
    public String showAllLength(){
        String result1="";
        String result2="";
        if(map!=null){
            result1+="Map size: "+map.size()+"\n";
        }else{
            result1+="Nothing to show\n";
        } 
        if(list!=null){
            result2+="List size: "+list.size()+"\n";
        }else{
            result2+="Nothing to show\n";
        }
        
        return result1+result2;
    }
}