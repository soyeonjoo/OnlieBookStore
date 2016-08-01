package bookmall.vo;

public class AuthorVo {
	private Long  authorNo;
	private String authorName;
	private String description;
	

	public Long getAuthorNo() {
		return authorNo;
	}


	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
	
		return "AuthorVo [authorno=" + authorNo + ", authorname=" + authorName + ", description=" + description + "]";	}


}
