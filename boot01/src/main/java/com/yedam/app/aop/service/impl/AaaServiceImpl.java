package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{
	private AaaMapper aaaMapper;
	@Autowired
	AaaServiceImpl(AaaMapper aaaMapper){
		this.aaaMapper = aaaMapper;
	}
	@Transactional()
	//얘가 없을때는 오류가 나면 두개중에 하나의 데이터만 넘어갔었음. 은행으로 치면 입금은 했는데 출금은 안된 상태, 얘를 써서 두개 다 막음
	//Transactional: propagation = 전파,timeout = 이 트랜젝션이 수행하는 시간을 설정, rollbackFor = 서버에서 일어나는 롤백.. 여러가지 속성이 있음
	@Override
	public void insert() {
		aaaMapper.aaaInsert("101");
		aaaMapper.aaaInsert("a101");
		
	}

}
//트랜잭션(Transaction)은 데이터베이스 시스템에서 데이터의 일관성과 무결성을 보장하기 위한 중요한 개념입니다.
//
//트랜잭션을 발생시킨다는 것은 데이터베이스 작업을 하나의 논리적인 단위로 묶어서 처리하는 것을 의미합니다. 이 때 트랜잭션은 다음과 같은 특성을 가집니다:
//
//원자성(Atomicity): 트랜잭션 내의 모든 작업은 하나의 단위로 처리되며, 일부만 성공하고 일부가 실패하는 일은 없습니다.
//
//일관성(Consistency): 트랜잭션이 실행되면 데이터베이스는 일관된 상태로 유지됩니다.
//
//격리성(Isolation): 트랜잭션은 다른 트랜잭션의 영향을 받지 않고 독립적으로 실행됩니다.
//
//지속성(Durability): 트랜잭션이 성공적으로 완료되면 그 결과는 영구적으로 데이터베이스에 반영됩니다.