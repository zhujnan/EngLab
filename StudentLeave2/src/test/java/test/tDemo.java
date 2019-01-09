package test;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.wisezone.entity.Tip;
import com.wisezone.service.TipService;
import com.wisezone.service.impl.TipServiceImpl;

public class tDemo {
	@Test
	public void test() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		TipService Tip =(TipService) ac.getBean("tipService");
		ArrayList<Tip> Tips =Tip.getTips("wangba");
		for (Iterator iterator = Tips.iterator(); iterator.hasNext();) {
			Tip tip2 = (Tip) iterator.next();
			System.out.println(tip2.getClassName());
			
		}
	}
}
