/*
 * CrudRepository
 * -이거 상속 받으면 별도의 method 구현, 재정의 없이, crud 기능의 메소드 호출만으로 실행 가능
 * -개발시 주의 사항(rule)
 * -CrudRepository<T, ID> 
 * 	T: entity 타임 (table 과 매핑된 entity 타입이어야 함
 * 	ID : 해당 entity의 pk 즉 id 변수 타입
 *  T에 deptcopy 들어가야 함
 */

package com.fisa.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisa.model.domain.entity.DeptCopy;

//fisadept. 뭐시기\
@Repository
public interface DeptCopyRepository extends CrudRepository<DeptCopy, Integer>{

}
