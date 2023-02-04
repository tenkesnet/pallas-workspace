package org.pallas.alapozo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pallas.alapozo.ViewModel.AlkalmazottView;
import org.pallas.alapozo.ViewModel.AutokView;
import org.pallas.alapozo.ViewModel.ReszlegView;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.Autok;
import org.pallas.alapozo.model.Reszleg;

@Mapper
public interface AlkalmazottMapper {

	AlkalmazottMapper INSTANCE = Mappers.getMapper( AlkalmazottMapper.class );
	
	AlkalmazottView alkalmazottToAlkalmazottView(Alkalmazott alkalmazott);
	@InheritInverseConfiguration
	@Mapping(target = "id", ignore = true)
	Alkalmazott alkalmazottViewToAlkalmazott(AlkalmazottView alkalmazottView);
	
	ReszlegView reszlegToReszlegView(Reszleg reszleg);
	AutokView autokToAutokView(Autok autok);
	List<AutokView> autokToAutokViews(Iterable<Autok> autok);
}
