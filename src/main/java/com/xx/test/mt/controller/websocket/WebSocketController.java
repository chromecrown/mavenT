package com.xx.test.mt.controller.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/websocket")
public class WebSocketController {

	@RequestMapping(value={"/",""})
	public String showWebSocketPage() {

		return "websocket";
	}

}
