package com.walker.common.util;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.walker.web.controller.Context;

@Component
public class Page implements Serializable{
	private static final long serialVersionUID = 1L;
//	static int defaultEachPageNum = 5;
	long NUM = 0;	//总数据条数
	int SHOWNUM = 5;//每页数量
	int NOWPAGE = 1;	//当前页码
	int PAGENUM = 0;	//总页数
	String ORDER;	//排序
	String DESC;	//倒序 有值则倒序
	
	public Page(){
		SHOWNUM = Context.getShowNum();//每页数量
	}
	
	public Page(int showNum, long allNum){
		this.SHOWNUM = showNum;
		this.setNUM(allNum);
	}
	
	public Bean toBean(){
		return new Bean().put("NUM", NUM).put("SHOWNUM", SHOWNUM).put("NOWPAGE", NOWPAGE).put("ORDER", ORDER).put("DESC", DESC);
	}
	
	/**
	 * 通过request获取 查询第几页 每页多少条
	 */
	public static Page getPage(HttpServletRequest request){
		Page res = new Page();
		res.setNOWPAGE(request.getParameter("NOWPAGE"));
		res.setSHOWNUM(request.getParameter("SHOWNUM"));
		res.setORDER(request.getParameter("ORDER"));
		res.setDESC(request.getParameter("DESC"));
		return res;
	}
	/**
	 * 通过request获取 查询第几页 每页多少条
	 */
	public static Page getPage(Bean bean){
		Page res = new Page();
		res.setNOWPAGE(bean.get("NOWPAGE", "0"));
		res.setSHOWNUM(bean.get("SHOWNUM", "0"));
		res.setORDER(bean.get("ORDER", ""));
		res.setDESC(bean.get("DESC", ""));
		return res;
	}
	
	public int start(){
		return (NOWPAGE-1) * SHOWNUM;
	}
	public int stop(){
		return NOWPAGE * SHOWNUM;
	}
	public long getNUM() {
		return NUM;
	} 
	/**
	 * 设置预期数据的总数量 并根据页显示数量更新总页数 
	 * @param num
	 */
	public void setNUM(long num) {
		this.NUM = num;
		this.PAGENUM = (int) Math.ceil( 1.0 * num / this.SHOWNUM );
	}

	public int getSHOWNUM() {
		return SHOWNUM;
	}

	public void setSHOWNUM(Object eachPageNum) {
		int defaultShowNum = Context.getShowNum();
		this.SHOWNUM = LangUtil.turn(eachPageNum, defaultShowNum);
		if(this.SHOWNUM <= 0){
			this.SHOWNUM = defaultShowNum;
		}
	}

	public int getNOWPAGE() {
		return NOWPAGE;
	}

	public void setNOWPAGE(String nowPage) {
		this.NOWPAGE = Tools.parseInt(nowPage, 1);
		if(this.NOWPAGE < 1){
			this.NOWPAGE = 1;
		}
	}

	public int getPAGENUM() {
		return PAGENUM;
	}

	public void setPAGENUM(Object pageNum) {
		this.PAGENUM = LangUtil.turn(pageNum, 0);
	}

	public String getORDER() {
		return ORDER;
	}

	public void setORDER(String order) {
		this.ORDER = order;
	}

	public String getDESC() {
		return DESC;
	}

	public void setDESC(String desc) {
		this.DESC = desc;
	}
	
	
	
}