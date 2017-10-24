package common;

public class PageResult {
	int pageNo, count;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	int beginPage;
	int endPage ;
	boolean prev ;
	boolean next ;
	public PageResult(int count,int pageNo) {
		this.count = count;
		this.pageNo = pageNo;
		int lastPage = (count%6 ==0)?count/6:count/6+1;
		int currTab = ((pageNo -1)) / 10+1;
		beginPage=((currTab -1) * 6)+1;
		endPage = (currTab * 6 > lastPage) ? lastPage:currTab * 6;
		prev = beginPage != 1;
		next = endPage != lastPage;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
}
