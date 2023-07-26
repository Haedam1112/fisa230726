package com.fisa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisa.exception.DeptNotFoundException;
import com.fisa.model.dao.DeptCopyRepository;
import com.fisa.model.domain.entity.DeptCopy;

@RestController
public class DeptCopyController {

	@Autowired   //타입에 맞는 spring bean 등록
	private DeptCopyRepository dao; // 객체화 시켜버리기
	
	//데이터 저장 - S save(S entity)
	/*
	 * 참고 :
	 * 1. entity와 dto 는 구분 필요
	 * 2. dto : view, model, controller간에 전송되는 데이터 표현용 객체
	 * 3. entity : table과 밀착
	 * 	- 분리 필수
	 * 	private int deptno;
	 * 	private String dname;
	 * 	private String loc;
	 */

	@PostMapping("/insert")
	public DeptCopy insertDept(DeptCopy datas) {
		System.out.println("********* " + datas); // datas.toString
		return dao.save(datas);
	}
	
	@GetMapping("/deptone")
	public DeptCopy getDept(int deptno) throws Exception { // 값 하나 찍어보기
		Optional<DeptCopy> dept = dao.findById(deptno);
		System.out.println(dept);
		dept.orElseThrow(Exception::new);
		return dept.get();
		// 예외 발생이 안된 경우에만 실행 즉 데이터가 있을 경우에만 get()
	}

	// 예외 전담 처리 메소드 - 삭제하고 싶은데 데이터가 없을때
	@ExceptionHandler(DeptNotFoundException.class)
	public String exHandler(DeptNotFoundException e) {
		e.printStackTrace();
		return "해당 부서 번호는 존재하지 않습니다.";
	}

	// 예외 전담 처리 메소드
	@ExceptionHandler
	public String exHandler(Exception e) {
		e.printStackTrace();

		return "요청시 입력 데이터 재 확인 부탁드립니다.";
	}

	// 모든 검색
	// http://localhost/guestbook/deptall
	@GetMapping("/deptall")
	public Iterable<DeptCopy> getDeptAll() {
		// System.out.println(dao.findAll());

		return dao.findAll();
	}

	@GetMapping("deptdelete")
	public String deleteDept(int deptno) throws DeptNotFoundException {
//			dao.findById(deptno).orElseThrow(new Exception("해당 부서 번호는 존재하지 않습니다.")); 문법 오류
		dao.findById(deptno).orElseThrow(DeptNotFoundException::new);// 로직 중지
		dao.deleteById(deptno);// 존재할 경우실행되는 라인
		return "delete 성공";
	}

}
