package beans;

import java.awt.image.BufferedImage;

public class Review {
	
	private Ad ad;
	private String reviewer;
	private String titleRev;
	private String descriptionRev;
	private BufferedImage image;
	private boolean accurateAd;
	private boolean agreementRes;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(Ad ad, String reviewer, String titleRev, String descriptionRev, BufferedImage image,
			boolean accurateAd, boolean agreementRes) {
		super();
		this.ad = ad;
		this.reviewer = reviewer;
		this.titleRev = titleRev;
		this.descriptionRev = descriptionRev;
		this.image = image;
		this.accurateAd = accurateAd;
		this.agreementRes = agreementRes;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getTitleRev() {
		return titleRev;
	}

	public void setTitleRev(String titleRev) {
		this.titleRev = titleRev;
	}

	public String getDescriptionRev() {
		return descriptionRev;
	}

	public void setDescriptionRev(String descriptionRev) {
		this.descriptionRev = descriptionRev;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public boolean isAccurateAd() {
		return accurateAd;
	}

	public void setAccurateAd(boolean accurateAd) {
		this.accurateAd = accurateAd;
	}

	public boolean isAgreementRes() {
		return agreementRes;
	}

	public void setAgreementRes(boolean agreementRes) {
		this.agreementRes = agreementRes;
	}
	
	
	
	
}
