package com.example.demo.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.customer_infoMapper;
import com.example.demo.mapper.userMapper;
import com.example.demo.service.customer_infoService;
import com.example.demo.Entity.customer_info;

@RequestMapping("/test")
@RestController
public class testController {

    @Autowired
    private customer_infoMapper customer_infomapper;

    @Autowired
    private customer_infoService ciservice;

    @GetMapping("/customer")
	public List<customer_info> index()
	{
		return customer_infomapper.findAll();
	}

    @GetMapping("/findpage")
	public Map<String, Object> findpage(@RequestParam Integer pageNum, @RequestParam Integer pageSize)
	{
        int n;
        if(pageNum >= 1){
            n = 0 + (pageNum - 1) * pageSize;
        }
        else
        {
            n = 0;
        }
        List<customer_info> data = customer_infomapper.findPage(n, pageSize);
        int totalNum = customer_infomapper.findPageTotal();
        int pageTotalNum = (totalNum / pageSize) + 1;
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("totalNum", totalNum);
        res.put("pageTotalNum", pageTotalNum); 
        return res;
	}
		

    @PostMapping("/save")
    public Integer save(@RequestBody customer_info ci)
    {
        return ciservice.save(ci);
    }

    @DeleteMapping("/delete/{id}")
    public Integer deleteById(@PathVariable Integer id)
    {
        return ciservice.deleteById(id);
    }

    @DeleteMapping("/delete")
    public Integer delete_Body(@RequestBody customer_info ci)
    {
        return ciservice.deleteById(ci.getId());
    }

    @GetMapping("/alisia")
	public String alisia()
	{
		return "okk";
	}
    
}
