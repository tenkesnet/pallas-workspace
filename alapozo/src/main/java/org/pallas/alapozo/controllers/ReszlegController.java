package org.pallas.alapozo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.pallas.alapozo.ViewModel.ReszlegView;
import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.mapper.ReszlegMapper;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.Reszleg;
import org.pallas.alapozo.repository.IAlkalmazottRepository;
import org.pallas.alapozo.repository.IReszlegRepository;
import org.pallas.alapozo.service.IAutoKolcsonzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/reszleg")
public class ReszlegController {

    @Autowired
    private IAutoKolcsonzoService _service;

    @Autowired
    private IReszlegRepository reszlegRepo;

    @Autowired
    private IAlkalmazottRepository alkalmazottRepo;

    @PostMapping()
    public Reszleg add(@RequestBody ReszlegView request) {
        Reszleg reszleg = ReszlegMapper.INSTANCE.reszlegViewToReszleg(request);
        if (reszleg != null && reszleg.getAlkalmazottak() != null) {
            List<Alkalmazott> alkalmazottak = new ArrayList<>();
            for (Alkalmazott x : reszleg.getAlkalmazottak()) {
                if (x.id != 0) {
                    Alkalmazott alkalmazott = alkalmazottRepo.findById(x.id).get();
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
        return reszlegRepo.save(reszleg);
    }

    @GetMapping()
    public List<ReszlegView> getAllReszleg() {
        ComplexResult<Iterable<Reszleg>> result = _service.getAllReszleg();
        List<ReszlegView> reszlegs = ReszlegMapper.INSTANCE.reszlegToReszlegViews(result.Object);
        return reszlegs;
    }

    @GetMapping("/{id}")
    public ComplexResult<ReszlegView> getReszlegId(@PathVariable int id) {
        ComplexResult<Reszleg> reszleg = _service.getReszlegId(id);
        if (reszleg.Status != HttpStatus.OK) {
            return new ComplexResult<>(null, reszleg.Message, reszleg.Status);
        }
        ReszlegView reszlegView = ReszlegMapper.INSTANCE.reszlegToReszlegView(reszleg.Object);
        return new ComplexResult<>(reszlegView, "", HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteReszleg(@RequestParam int id) {
        //repo.deleteById(id);
        _service.deleteReszleg(id);
    }

}
