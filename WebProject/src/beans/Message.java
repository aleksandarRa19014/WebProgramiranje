package beans;
import java.util.Date;

public class Message {
	
	private String nameAd;
	private String nameSender;
	private String titleMsg;
	private String contentMsg;
	private Date dateTimeMsg;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String nameAd, String nameSender, String titleMsg, String contentMsg, Date dateTimeMsg) {
		super();
		this.nameAd = nameAd;
		this.nameSender = nameSender;
		this.titleMsg = titleMsg;
		this.contentMsg = contentMsg;
		this.dateTimeMsg = dateTimeMsg;
	}

	public String getNameAd() {
		return nameAd;
	}

	public void setNameAd(String nameAd) {
		this.nameAd = nameAd;
	}

	public String getNameSender() {
		return nameSender;
	}

	public void setNameSender(String nameSender) {
		this.nameSender = nameSender;
	}

	public String getTitleMsg() {
		return titleMsg;
	}

	public void setTitleMsg(String titleMsg) {
		this.titleMsg = titleMsg;
	}

	public String getContentMsg() {
		return contentMsg;
	}

	public void setContentMsg(String contentMsg) {
		this.contentMsg = contentMsg;
	}

	public Date getDateTimeMsg() {
		return dateTimeMsg;
	}

	public void setDateTimeMsg(Date dateTimeMsg) {
		this.dateTimeMsg = dateTimeMsg;
	}
	
	
	
	
}
