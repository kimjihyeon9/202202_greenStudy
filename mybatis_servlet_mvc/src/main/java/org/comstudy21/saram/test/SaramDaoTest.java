package org.comstudy21.saram.test;

import java.io.IOException;
import java.util.List;

import org.comstudy21.saram.model.SaramDao;
import org.comstudy21.saram.model.SaramDto;

public class SaramDaoTest {
	private static SaramDao saramDao = new SaramDao();
	
	public static void selectAllTest() throws IOException {
		List<SaramDto> list = saramDao.selectAll();
		System.out.println(list);
	}

	public static void selectOneTest() throws IOException {
		SaramDto saram = saramDao.selectOne(1);
		System.out.println(saram);
	}

	public static void insertTest() throws IOException {
		SaramDto dto = new SaramDto(0, "PARK2", "박길동2", 16);
		saramDao.insert(dto);
		selectAllTest();
	}
	
	public static void updateTest() throws IOException {
		SaramDto dto = new SaramDto(4, "KANG", "강길동", 20);
		saramDao.update(dto);
		selectAllTest();
	}
	
	public static void deleteTest() throws IOException {
		SaramDto dto = new SaramDto(4, "", "", 0);
		saramDao.delete(dto);
		selectAllTest();
	}
	
	public static void main(String[] args) throws IOException {
		selectAllTest();
//		selectOneTest();
//		insertTest();
//		updateTest();
//		deleteTest();
	}
}
