package com.lht;

import com.lht.service.RouterFeign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceFeignApplicationTests {

	@Autowired
	private RouterFeign routerFeign;

	@Test
	public void hystrixTest() throws InterruptedException {
		 final AtomicInteger cq = new AtomicInteger(1);
		for (int i = 1; i <= 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					job(cq.getAndAdd(1)+"");
				}
			}).start();
		}

		Thread.currentThread().join();//一直阻塞不会停止
	}

	public void job(String cq) {


		String queryTransRecListResp = routerFeign.queryTransRec( "查询: "+cq+"");

		System.out.println(String.format("获取结果为：【%s】  线程: %s", queryTransRecListResp,Thread.currentThread().getName()) );
	}

}
