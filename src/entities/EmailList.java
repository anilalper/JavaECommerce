package entities;

import core.abstracts.BaseEntity;

public class EmailList extends BaseEntity<Long> {


	private String ad;	

	public EmailList(Long id,String ad) {
		super(id);
		this.ad=ad;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	

}
