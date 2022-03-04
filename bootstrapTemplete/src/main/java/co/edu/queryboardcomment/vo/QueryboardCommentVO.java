package co.edu.queryboardcomment.vo;

public class QueryboardCommentVO {
	private int c_no;
	private String c_ref;
	private String c_writer;
	private String c_comment_date;
	private String c_content;
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_ref() {
		return c_ref;
	}
	public void setC_ref(String c_ref) {
		this.c_ref = c_ref;
	}
	public String getC_writer() {
		return c_writer;
	}
	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}
	public String getC_comment_date() {
		return c_comment_date;
	}
	public void setC_comment_date(String c_comment_date) {
		this.c_comment_date = c_comment_date;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	
	@Override
	public String toString() {
		return "QueryboardCommentVO [c_no=" + c_no + ", c_ref=" + c_ref + ", c_writer=" + c_writer + ", c_comment_date="
				+ c_comment_date + ", c_content=" + c_content + "]";
	}
	
	
}
