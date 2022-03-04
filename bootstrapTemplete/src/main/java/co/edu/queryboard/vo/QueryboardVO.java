package co.edu.queryboard.vo;

public class QueryboardVO {
		private int qb_no;
		private String qb_title;
		private String qb_pwd;
		private String qb_writer;
		private String qb_content;
		private String qb_date;
		private int qb_readcount;
		private String pID;
		private boolean lock_flag;
		
		public int getQb_no() {
			return qb_no;
		}
		public void setQb_no(int qb_no) {
			this.qb_no = qb_no;
		}
		public String getQb_title() {
			return qb_title;
		}
		public void setQb_title(String qb_title) {
			this.qb_title = qb_title;
		}
		public String getQb_pwd() {
			return qb_pwd;
		}
		public void setQb_pwd(String qb_pwd) {
			this.qb_pwd = qb_pwd;
		}
		public String getQb_writer() {
			return qb_writer;
		}
		public void setQb_writer(String qb_writer) {
			this.qb_writer = qb_writer;
		}
		public String getQb_content() {
			return qb_content;
		}
		public void setQb_content(String qb_content) {
			this.qb_content = qb_content;
		}
		public String getQb_date() {
			return qb_date;
		}
		public void setQb_date(String qb_date) {
			this.qb_date = qb_date;
		}
		public int getQb_readcount() {
			return qb_readcount;
		}
		public void setQb_readcount(int qb_readcount) {
			this.qb_readcount = qb_readcount;
		}
		public String getpID() {
			return pID;
		}
		public void setpID(String pID) {
			this.pID = pID;
		}
		public boolean isLock_flag() {
			return lock_flag;
		}
		public void setLock_flag(boolean lock_flag) {
			this.lock_flag = lock_flag;
		}
		
		@Override
		public String toString() {
			return "QueryboardVO [qb_no=" + qb_no + ", qb_title=" + qb_title + ", qb_pwd=" + qb_pwd + ", qb_writer="
					+ qb_writer + ", qb_content=" + qb_content + ", qb_date=" + qb_date + ", qb_readcount="
					+ qb_readcount + ", pID=" + pID + ", lock_flag=" + lock_flag + "]";
		}
		
		
}
