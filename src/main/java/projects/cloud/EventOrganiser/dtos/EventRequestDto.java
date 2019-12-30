package projects.cloud.EventOrganiser.dtos;

public class EventRequestDto {

	private String title;
	private String organiserEmail;
	private String user;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrganiserEmail() {
		return organiserEmail;
	}

	public void setOrganiserEmail(String organiserEmail) {
		this.organiserEmail = organiserEmail;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
