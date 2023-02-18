package org.pallas.alapozo.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.pallas.alapozo.ViewModel.ReszlegView;
import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.mapper.ReszlegMapper;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.Reszleg;
import org.pallas.alapozo.repository.IAlkalmazottRepository;
import org.pallas.alapozo.repository.IReszlegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 *
 * @author bardo
 */
@Component
public class ReszlegControllerHelper {
    
    @Autowired
    private IAlkalmazottRepository alkalmazottRepo;
    
    public  ComplexResult<Reszleg> ReszlegValidate(ReszlegView reszlegView){
        Reszleg reszleg = ReszlegMapper.INSTANCE.reszlegViewToReszleg(reszlegView);
        if(reszleg.getReszlegCim()==null || reszleg.getReszlegNev()==null ){
            return new ComplexResult<>(null,"Not enught data" , HttpStatus.BAD_REQUEST);
        }
        
        if (reszleg != null && reszleg.getAlkalmazottak() != null) {
            List<Alkalmazott> alkalmazottak = new ArrayList<>();
            for (Alkalmazott x : reszleg.getAlkalmazottak()) {
                if (x.id != 0) {
                    Optional<Alkalmazott> alkalmazottOptional = alkalmazottRepo.findById(x.id);
                    if(alkalmazottOptional.isEmpty()){
                        return new ComplexResult<>(null, "Alkalmazott id ("+x.id+") not found", HttpStatus.BAD_REQUEST);
                    }
                    Alkalmazott alkalmazott = alkalmazottOptional.get();
                    alkalmazott.setReszleg(reszleg);
                    alkalmazottak.add(alkalmazott);
                } else {
                    x.setReszleg(reszleg);
                    alkalmazottak.add(x);
                }
            }
            reszleg.setAlkalmazottak(alkalmazottak);
        }
        if (reszleg != null && reszleg.getAutok() != null) {
            reszleg.getAutok().forEach(x -> x.setReszleg(reszleg));
        }
        ComplexResult<Reszleg> result = new ComplexResult<>(reszleg, "Ok", HttpStatus.OK);
        return result;
    }
            
}
