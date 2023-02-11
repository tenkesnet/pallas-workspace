package org.pallas.alapozo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pallas.alapozo.ViewModel.AlkalmazottView;
import org.pallas.alapozo.ViewModel.AutokView;
import org.pallas.alapozo.ViewModel.ReszlegView;
import org.pallas.alapozo.ViewModel.SmallAlkalmazottView;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.Autok;
import org.pallas.alapozo.model.Reszleg;

@Mapper
public interface ReszlegMapper {

	ReszlegMapper INSTANCE = Mappers.getMapper( ReszlegMapper.class );
	
	ReszlegView reszlegToReszlegView(Reszleg reszleg);
	@InheritInverseConfiguration
	@Mapping(target = "id", ignore = true)
	Reszleg reszlegViewToReszleg(ReszlegView reszlegView);
	
	List<ReszlegView> reszlegToReszlegViews(Iterable<Reszleg> reszlegs);
	SmallAlkalmazottView AlkalmazottToSmallAlkalmazottView(Alkalmazott alkalmazott);
	List<SmallAlkalmazottView> alkalmazottToSmallAlkalmazottViews(Iterable<Alkalmazott> alkalmazottak);
	AutokView autokToAutokView(Autok autok);
	List<AutokView> autokToAutokViews(Iterable<Autok> autok);
}
