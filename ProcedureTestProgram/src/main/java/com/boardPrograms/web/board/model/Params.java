
package com.boardPrograms.web.board.model;

import java.util.HashMap;
import java.util.List;

public class Params {
	private String CampID;
	private String sWorkSect;
	private String sCallListName;
	private String sPreNext;
	private int iSequence;
	private String sFieldName;
	private String sAccount;
	private String sText;
	private String sFilterSect;
	private List<AccessVO> ref_result;	
	
	public String getCampID() {
		return CampID;
	}
	public void setCampID(String campID) {
		CampID = campID;
	}
	public String getsWorkSect() {
		return sWorkSect;
	}
	public void setsWorkSect(String sWorkSect) {
		this.sWorkSect = sWorkSect;
	}
	public String getsCallListName() {
		return sCallListName;
	}
	public void setsCallListName(String sCallListName) {
		this.sCallListName = sCallListName;
	}
	public String getsPreNext() {
		return sPreNext;
	}
	public void setsPreNext(String sPreNext) {
		this.sPreNext = sPreNext;
	}
	public int getiSequence() {
		return iSequence;
	}
	public void setiSequence(int iSequence) {
		this.iSequence = iSequence;
	}
	public String getsFieldName() {
		return sFieldName;
	}
	public void setsFieldName(String sFieldName) {
		this.sFieldName = sFieldName;
	}
	public String getsAccount() {
		return sAccount;
	}
	public void setsAccount(String sAccount) {
		this.sAccount = sAccount;
	}
	public String getsText() {
		return sText;
	}
	public void setsText(String sText) {
		this.sText = sText;
	}
	public String getsFilterSect() {
		return sFilterSect;
	}
	public void setsFilterSect(String sFilterSect) {
		this.sFilterSect = sFilterSect;
	}
	public List<AccessVO> getRef_result() {
		return ref_result;
	}
	public void setRef_result(List<AccessVO> ref_result) {
		this.ref_result = ref_result;
	}

	
}
