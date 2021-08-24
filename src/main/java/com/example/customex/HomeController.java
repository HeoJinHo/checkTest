package com.example.customex;

import com.example.customex.model.CheckData;
import com.example.customex.sv.CheckDataSv;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HomeController
{

    private final CheckDataSv checkDataSv;

    @RequestMapping("/")
    public ModelAndView custom(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customEx.html");
        mv.addObject("data", checkDataSv.getList("fixed"));
        mv.addObject("data2", checkDataSv.getList("custom"));
        mv.addObject("count", checkDataSv.getCount("custom"));
        return mv;
    }


    @RequestMapping("/addFixCheck")
    public String addCheck(CheckData checkData){
        checkDataSv.insertCheckData(checkData);
        return "redirect:/";
    }

    @RequestMapping("/delFixCheck")
    public String delCheck(CheckData checkData){
        checkDataSv.deleteCheckData(checkData);
        return "redirect:/";
    }

    @RequestMapping("/addAddCheck")
    public String addAddCheck(CheckData checkData){
        checkDataSv.insertCheckData(checkData);
        return "redirect:/";
    }

    @GetMapping("/delCustom")
    public String delCustom(String val){
        checkDataSv.delCustomData(val);
        return "redirect:/";
    }

}
