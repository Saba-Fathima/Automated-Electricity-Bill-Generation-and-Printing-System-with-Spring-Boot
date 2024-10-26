package com.saba;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BillController {
	
	@RequestMapping("/")
	public String billPage()
	{
		return "bill";
	}
	
	@RequestMapping("/req1")
	public String resultPage(@RequestParam int cid, @RequestParam String cname, @RequestParam int curRead, @RequestParam int preRead, ModelMap model)
	{
		model.put("cid", cid);
		model.put("cname", cname);
		model.put("curRead", curRead);
		model.put("preRead", preRead);
		
		int units = curRead - preRead;
		model.put("units", units);
		
		double rate = 0, totalBill = 0;
		
		if(units < 300)
		{
			rate = 1.75;
			totalBill = units * rate;
		}
		else if(units >= 300 && units < 500)
		{
			rate = 3.25;
			totalBill = units * rate ;
		}
		else
		{
			rate = 7.25;
			totalBill = units * rate;
		}
		model.put("totalBill", totalBill);
		return "result";
		
	}

}
