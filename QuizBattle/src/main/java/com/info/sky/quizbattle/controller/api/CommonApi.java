package com.info.sky.quizbattle.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping("API/v1/{token}/Common/")
public class CommonApi 
{
	public String getToken()
	{
		return "1998";
	}
}
