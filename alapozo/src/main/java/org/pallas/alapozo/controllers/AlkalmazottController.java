package org.pallas.alapozo.controllers;

import java.util.List;
import org.pallas.alapozo.ViewModel.AlkalmazottView;
import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.mapper.AlkalmazottMapper;
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
@RequestMapping(path = "/alkalmazott")
public class AlkalmazottController {

    @Autowired
    private IAutoKolcsonzoService _service;

    @Autowired
    private IAlkalmazottRepository alkalmazottRepo;

    @Autowired
    private IReszlegRepository reszlegRepo;

    /**
     *
     * @param request
     * @return
     */
    @PostMapping()
    public ComplexResult<Alkalmazott> add(@RequestBody AlkalmazottView request) {
        Alkalmazott alkalmazott = AlkalmazottMapper.INSTANCE.alkalmazottViewToAlkalmazott(request);
        if (alkalmazott.getReszleg() == null) {
            return new ComplexResult<>(null, "Not found reszleg", HttpStatus.NOT_FOUND);
        }
        if (alkalmazott.getReszleg().id != 0) {
            Reszleg reszleg = reszlegRepo.findById(alkalmazott.getReszleg().id).get();
            alkalmazott.setReszleg(reszleg);
        }
        return new ComplexResult<>(_service.saveAlkalmazott(alkalmazott), "Saved ok.", HttpStatus.OK);
    }

    /**
     *
     * @return list alkalmazott
     */
    @GetMapping
    public List<Alkalmazott> getAlkalmazott() {
        return alkalmazottRepo.findAll();
    }

    @GetMapping("/{stringId}")
    public ComplexResult<Alkalmazott> getAlkalmazottById(@PathVariable String stringId) {
        int id=0;
        try {
            id = Integer.parseInt(stringId);
        } catch (NumberFormatException e) {
            return new ComplexResult<>(null, "Id must be integer", HttpStatus.BAD_REQUEST);
        }
        ComplexResult<Alkalmazott> result = new ComplexResult<>(null, "Ok", HttpStatus.OK);
        try {
            result.Object = alkalmazottRepo.findById(id).get();
        } catch (Exception e) {
            result.Message = "Not found alkalmazott";
            result.Status = HttpStatus.NOT_FOUND;
        }
        return result;
    }

    /**
     *
     * @param id
     * @return ComplexResult
     */
    @DeleteMapping()
    public ComplexResult<String> deleteAlkalmazott(@RequestParam int id) {
        ComplexResult<String> result = new ComplexResult<>(null, "Deleted", HttpStatus.OK);
        try {
            alkalmazottRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
            result = new ComplexResult<>(null, "No record found", HttpStatus.NOT_FOUND);
        }
        return result;
    }
}
