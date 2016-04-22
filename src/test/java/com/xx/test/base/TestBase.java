package com.xx.test.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.xx.test.mt.service.dns.IDnsService;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/config/spring/applicationContext.xml",
		"file:src/main/webapp/WEB-INF/config/spring/springMVC-servlet.xml" })
public class TestBase {
	protected Log logger = LogFactory.getLog(TestBase.class);

	private IDnsService dnsService;

	public IDnsService getDnsService() {
		return dnsService;
	}

	@Autowired
	public void setDnsService(IDnsService dnsService) {
		this.dnsService = dnsService;
	}

	/**
	 * some initial code will be here
	 */
	@Before
	public void before() {

	}

	@Test
	public void test1() {
		List<String> lst = new ArrayList<String>();
		lst = dnsService.getAllDNS();
		logger.info(JSON.toJSONString(lst));
	}
}