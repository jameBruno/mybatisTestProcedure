package com.boardPrograms.web;

import com.boardPrograms.web.board.dao.AccessDAO;
import com.boardPrograms.web.board.model.AccessVO;
import com.boardPrograms.web.board.model.Params;
import com.boardPrograms.web.board.service.AccessService;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml", "classpath:spring/dataSource-context.xml", "classpath:spring/appServlet/servlet-context.xml"})
public class AccessServiceTest {
	
	/*private static final Logger logger = LoggerFactory.getLogger(AccessServiceTest.class);
	private static final String namespace = "com.boardPrograms.web.board.boarsMapper";
	
	@Autowired
	private AccessService accessService;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	private static final String queryId = "com.boardPrograms.web.board.boarsMapper";
	*/
	

	private static final Logger logger = LoggerFactory.getLogger(AccessServiceTest.class);
	private static final String namespace = "com.boardPrograms.web.board.boarsMapper";
	
	@Autowired
	private AccessService accessService;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	private static final String queryId = "com.boardPrograms.web.board.boarsMapper";
	
	@Autowired
	SqlSession sqlSession;
	
	ResultSet rs = null;
	
	@Test
	public void testGetEmpList() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		ArrayList<Params> lists = new ArrayList<Params>();
		
		params.put("CAMP_ID", "C");
		params.put("CAMP_STAT_CD", "중지");
		params.put("SCENARIO_NAME", "NO");
		params.put("CAMP_NAME", "테스트-통합테스트용");
		params.put("CAMP_COUNT", 1);
		params.put("GRP_VDN", "6001");
		params.put("GRP_NAME", "가입자아웃바운드");
		params.put("TR_NAME", "GH_TEST");
		params.put("CALLLIST_NAME", "U00120090904CL");
		
		Params paramVO = null;
		
		List<Params> resultList = accessService.executeProcPostgreSQL("com.boardPrograms.web.board.boardsMapper.getAccessList", params, Params.class);
		
		logger.info("list" + resultList.get(0).getCampID().toString());
		
		try {
			if(!resultList.isEmpty()) {
				
				for(int i = 0; i < resultList.size(); i++) {
					logger.info("result " + resultList.get(i).getCampID());
					logger.info("result " + resultList.get(i).getsAccount());
					logger.info("result " + resultList.get(i).getsCallListName());
					logger.info("result " + resultList.get(i).getsFieldName());
					logger.info("result " + resultList.get(i).getsFilterSect());
					logger.info("result " + resultList.get(i).getsPreNext());
					logger.info("result " + resultList.get(i).getsText());
					logger.info("result " + resultList.get(i).getsWorkSect());
					System.out.println("result " + resultList.get(i).getiSequence());
				}
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	/*
	@Test
	public void testGetEmpList() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		Params paramVo = new Params();
		
		params.put("CAMP_ID", "C");
		params.put("CAMP_STAT_CD", "중지");
		params.put("SCENARIO_NAME", "NO");
		params.put("CAMP_NAME", "테스트-통합테스트용");
		params.put("CAMP_COUNT", 3069);
		params.put("GRP_VDN", "6001");
		params.put("GRP_NAME", "가입자아웃바운드");
		params.put("TR_NAME", "GH_TEST");
		params.put("CALLLIST_NAME", "U00120090904CL");
		
		//HashMap<String, Object> ref_result = (HashMap<String, Object>) accessService.getAccessList(params);
		
		//HashMap<String, Object> ref_result = (HashMap<String, Object>) accessService.getAccessList(params);
		
		//List<Map<String, String>> resultList = accessService.executeProcPossgreSQL("SP_ACS_CAMP_INFO", params);
		
		List<AccessVO> resultList = accessService.executeProcPostgreSQL("SP_ACS_CAMP_INFO", params, AccessVO.class);
		
		logger.info("list" + resultList);
		
		try {
			if(!resultList.isEmpty()) {
				Map<String, String> map = (Map<String, String>) resultList.get(0);
				logger.info("map" + map);
				ResultSet rs = (ResultSet) map.get(0);
				
				ResultSetMetaData rsmd = rs.getMetaData();
				int nColumn = rsmd.getColumnCount();
				
				for (int i = 0; i < nColumn; i++) {
					System.out.println(rsmd.getColumnName(i + 1) + "\t");
				}
				
				while(rs.next()) {
					for(int i = 0; i < nColumn; i++) {
						System.out.println(rs.getString(i + 1) + "\t");
					}
					System.out.println();
				}
				
				//ResultSet rs = map.get("SP_ACS_CAMP_INFO")
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		
		/*
		ResultSet rs = (ResultSet) resultList.get(1);
		
	
		Iterator<Map<String, String>> iterator = resultList.iterator();
		
		
		
		
		
				 * 
				 * ResultSetMetaData rsmd = rs.getMetaData(); int nColumns =
				 * rsmd.getColumnCount();
				 * 
				 * for (int i = 0; i < nColumns; i++) { System.out.print("result" +
				 * rsmd.getColumnName(i + 1) + "\t"); }
				 * 
				 * while (rs.next()) { for (int i = 0; i < nColumns; i++) {
				 * System.out.print("result" + rs.getString(i + 1) + "\t"); }
				 * System.out.println(); } }
				 */
		
		/*	
			  while( iterator.hasNext() ) { empVO = iterator.next(); System.out.println(
			  "[mirinae.maru] EmpVO["+i+"] : " + empVO.getsFieldName() +"\t" +
			  empVO.getsWorkSect() + "\t" + empVO.getiSequence() + "\t" +
			  empVO.getsAccount() + "\t" + empVO.getsCallListName() + "\t" +
			  empVO.getsFilterSect() + "\t" + empVO.getsPreNext() + "\t" +
			  empVO.getsText());
			  
			  logger.info(empVO.getsCallListName() + empVO.getsFieldName() +
			  empVO.getsAccount()); i++; }*/
		
		
		/*
		  logger.info("list" + ref_result);
		  
		  for (String k : ref_result.keySet()) { logger.info(k + ":" +
		  ref_result.get(k)); }
		  
		  ResultSet rs = (ResultSet) ref_result.get("result"); logger.info("rs" + rs);
		 
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int nColumns = rsmd.getColumnCount();
			
			for (int i = 0; i < nColumns; i++) {
				System.out.print(rsmd.getColumnName(i + 1) + "\t");
			}
			
			while (rs.next()) {
				for (int i = 0; i < nColumns; i++) {
					System.out.print(rs.getString(i + 1) + "\t");
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
		
		/*
		 * Params params = new Params();
		 * 
		 * params.setCampID("C"); params.setsWorkSect("중지");
		 * params.setsCallListName("NO"); params.setsPreNext("테스트-통합테스트용");
		 * params.setiSequence(3069); params.setsFieldName("6001");
		 * params.setsAccount("가입자아웃바운드"); params.setsText("GH_TEST");
		 * params.setsFilterSect("U00120090904CL");
		 */
	
		
		//Cursor<AccessVO> accessList = (Cursor<AccessVO>) accessService.getAccessList(params); 
		
		//System.out.println("list" + ref_result.toString());
		
		//Map<String, Object> access = (Map<String, Object>) ref_result.get(0);
		//logger.info("access" + access);
		
		
			
			/*
			 * if (!ref_result.isEmpty()) { ResultSet rs = (ResultSet)
			 * ref_result.get("ref_result"); logger.info("rs" + rs);
			 * 
			 * // int i = 0; //AccessVO empVO = null; //Iterator<AccessVO> iterator =
			 * ref_result.iterator();
			 * 
			 * ResultSetMetaData rsmd = rs.getMetaData(); int nColumns =
			 * rsmd.getColumnCount();
			 * 
			 * for (int i = 0; i < nColumns; i++) { System.out.print("result" +
			 * rsmd.getColumnName(i + 1) + "\t"); }
			 * 
			 * while (rs.next()) { for (int i = 0; i < nColumns; i++) {
			 * System.out.print("result" + rs.getString(i + 1) + "\t"); }
			 * System.out.println(); } }
			 */
	
		/*
		 * while( iterator.hasNext() ) { empVO = iterator.next(); System.out.println(
		 * "[mirinae.maru] EmpVO["+i+"] : " + empVO.getsFieldName() +"\t" +
		 * empVO.getsWorkSect() + "\t" + empVO.getiSequence() + "\t" +
		 * empVO.getsAccount() + "\t" + empVO.getsCallListName() + "\t" +
		 * empVO.getsFilterSect() + "\t" + empVO.getsPreNext() + "\t" +
		 * empVO.getsText());
		 * 
		 * logger.info(empVO.getsCallListName() + empVO.getsFieldName() +
		 * empVO.getsAccount()); i++; }
		 */
				
				
	
}
			