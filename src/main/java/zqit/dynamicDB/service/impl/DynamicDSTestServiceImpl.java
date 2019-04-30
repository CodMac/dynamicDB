package zqit.dynamicDB.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zqit.dynamicDB.entity.Demo;
import zqit.dynamicDB.mapper.DemoMapper;
import zqit.dynamicDB.pulgins.dynamicDB.TargetDataSource;
import zqit.dynamicDB.service.DynamicDSTestService;

/**
 * 多数据源测试
 * @author mc
 *
 */
@Service
public class DynamicDSTestServiceImpl implements DynamicDSTestService {
	
	@Autowired
	DemoMapper demoMapper;

	@TargetDataSource(name="zqitDbTest")
	@Override
	public Object getUserListA() {
		List<Demo> list = demoMapper.selectAll();
		return list;
	}

	@TargetDataSource(name="zqitDbTest2")
	@Override
	public Object getUserListB() {
		List<Demo> list = demoMapper.selectAll();
		return list;
	}

	@Override
	public Object getUserListC() {
		List<Demo> list = demoMapper.selectAll();
		return list;
	}
	
}
