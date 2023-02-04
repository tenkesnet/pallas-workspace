package org.pallas.alapozo.ViewModel;

import java.util.ArrayList;
import java.util.List;

import org.pallas.alapozo.model.Alkalmazott;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReszlegView {
	public int id;
	public int reszlegKod;
	public String reszlegNev;
	public String reszlegCim;
	public List<AlkalmazottView> alkalmazottak = new ArrayList<AlkalmazottView>();
	public List<AutokView> autok = new ArrayList<AutokView>();
}
