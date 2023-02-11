package org.pallas.alapozo.ViewModel;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReszlegView {
	private int id;
	private int reszlegKod;
	private String reszlegNev;
	private String reszlegCim;
	private List<SmallAlkalmazottView> alkalmazottak = new ArrayList<>();
	private List<AutokView> autok = new ArrayList<>();
}
