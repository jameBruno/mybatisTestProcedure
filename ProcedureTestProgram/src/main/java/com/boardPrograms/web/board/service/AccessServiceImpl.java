package com.boardPrograms.web.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boardPrograms.web.board.dao.AccessDAO;
import com.boardPrograms.web.board.model.AccessVO;

@Component
@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation=Propagation.REQUIRED, rollbackFor=SQLException.class)
public class AccessServiceImpl implements AccessService {
	
	private static final String namespace = "com.boardPrograms.web.board.boardsMapper";
	
	@Autowired
	AccessDAO accessDAO;
	AccessVO accessVO;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	private Log log = LogFactory.getLog(getClass());
	
	public AccessServiceImpl(AccessDAO accessDAO, SqlSession sqlSession) {
		this.accessDAO = accessDAO;
		this.sqlSession = sqlSession;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation=Propagation.REQUIRED, rollbackFor=SQLException.class)
	public Cursor<Object> getAccessListCursor(Map<String, Object> param) {
		Cursor<Object> cursor = null;
		try {
			sqlSession.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			cursor = accessDAO.getAccessListCursor(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cursor;
	}
	
	/*
	 * @Override
	 * 
	 * @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation =
	 * Propagation.REQUIRED, rollbackFor = SQLException.class) public
	 * List<Map<String, String>> executeProcPostgreSQL(String queryId, Map<String,
	 * Object> param) {
	 * 
	 * List<Map<String, String>> params = null;
	 * 
	 * try { sqlSession.getConnection().setAutoCommit(false); } catch (Exception e)
	 * { e.printStackTrace(); }
	 * 
	 * try { params = accessDAO.executeProcPostgreSQL(queryId, param);
	 * System.out.println("param" + params); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return params; }
	 */
	
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED, rollbackFor = SQLException.class)
	public <T> List<T> executeProcPostgreSQL(String queryId, Map<String, Object> param, Class<T> clazz) {
		
		List<T> list = null;
		
		try {
			sqlSession.getConnection().setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			list = accessDAO.executeProcPostgreSQL(queryId, param, clazz);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation=Propagation.REQUIRED, rollbackFor=SQLException.class)
	public Map<String, Object> getAccessList(Map<String, Object> param) {
		
		Map<String, Object> map = null;
		
		try {
			sqlSession.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			map = accessDAO.getAccessList(param);
			System.out.println("map" + map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
		
		//return params.getRef_result();
		
		
		/*
		 * final AccessDAO accessDAO = sqlSession.getMapper(AccessDAO.class);
		 * System.out.println(params.toString()); accessDAO.getAccessList(params);
		 * return params.getRef_result();
		 */
		
		/*
		 * DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		 * def.setName("transaction");
		 * def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		 * def.setPropagationBehavior(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
		 * 
		 * TransactionStatus status = transactionManager.getTransaction(def);
		 */

		
		/*
		 * System.out.println(params.toString()); accessDAO.getAccessList(params);
		 */
		
		/*
		 * try { //sqlSession.getConnection().setAutoCommit(false);
		 * //accessDAO.setAutoCommit(false); //final AccessDAO accessDAO =
		 * sqlSession.getMapper(AccessDAO.class);
		 * 
		 * } catch (Exception e) { accessDAO.rollback(); } finally {
		 * accessDAO.setAutoCommit(true); }
		 */
		
	
		
		/*
		 * final AccessDAO accessDAO = sqlSession.getMapper(AccessDAO.class);
		 * accessDAO.getAccessList(params); System.out.println(params.toString());
		 */
		
		//transactionManager.commit(status);
		
	}
	
	public AccessDAO getAccessDAO() {
		return accessDAO;
	}
	
	public void setAccessDAO(AccessDAO accessDAO) {
		this.accessDAO = accessDAO;
	}

	
	/*
	@Override
	public Map<String, Object> getAccessList(Params params) {
		// TODO Auto-generated method stub
		Map<String, Object> list = accessDAO.getAccessList(params);
		
		return null;
	}
	*/
	
	/*
	@Override
	public List<AccessVO> listAccessList() {
		return sqlSession.selectList(namespace+".listAccessList");
	}
	*/
	
	/*
	public AccessServiceImpl(AccessDAO accessDAO, SqlSession sqlSession) {
		this.accessDAO = accessDAO;
		//this.sqlSession = sqlSession;
	}
	*/
	
	/*
	@Override
	public List<AccessVO> listAccessList() {
		return sqlSession.selectList(namespace+".listAccessList");
	}
	*/
	
	/*
	@Override
	public List<AccessVO> getAccessList(final Params params) {
		return accessDAO.getAccessList(params);
	}
	*/
	
}
