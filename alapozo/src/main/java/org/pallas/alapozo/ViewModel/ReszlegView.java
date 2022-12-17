package org.pallas.alapozo.ViewModel;

import java.util.ArrayList;
import java.util.List;

import org.pallas.alapozo.model.Alkalmazott;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

public class ReszlegView {
	public int id;
	public int reszlegKod;
	public String reszlegNev;
	public String reszlegCim;
	public List<AlkalmazottView> alkalmazottak = new ArrayList<AlkalmazottView>();
	public ReszlegView(int id, int reszlegKod, String reszlegNev, String reszlegCim, List<AlkalmazottView> alkalmazottak) {
		super();
		this.id = id;
		this.reszlegKod = reszlegKod;
		this.reszlegNev = reszlegNev;
		this.reszlegCim = reszlegCim;
		this.alkalmazottak = alkalmazottak;
	}
}
