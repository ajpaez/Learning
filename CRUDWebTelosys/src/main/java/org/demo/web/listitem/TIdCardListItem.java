/*
 * Created on 4 mar 2017 ( Time 18:53:43 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.TIdCard;
import org.demo.web.common.ListItem;

public class TIdCardListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public TIdCardListItem(TIdCard tIdCard) {
		super();

		this.value = ""
			 + tIdCard.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = tIdCard.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
