package common;

public class PageResult {
	int pageNo, count;
	public int getPageNo() {
		return pageNo;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	boolean prev ;
	boolean next ;
	public PageResult(int count,int pageNo) {
		this.count = count;
		this.pageNo = pageNo;
		int lastPage = (count%6 ==0)?count/6:count/6+1;
		prev = pageNo > 1;
		next = pageNo != lastPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

}
