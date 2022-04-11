package edu.tcu.cs.hogwartsartifactsonline.service;

import edu.tcu.cs.hogwartsartifactsonline.dao.WizardDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.Wizard;
import edu.tcu.cs.hogwartsartifactsonline.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class WizardService {

    private WizardDao wizardDao;

    public WizardService(WizardDao wizardDao) {
        this.wizardDao = wizardDao;
    }

    public List<Wizard> findAll(){
        return wizardDao.findAll();
    }

    public Wizard findbyId(Integer id) {
        return wizardDao.findById(id).get();
    }

    public void save(Wizard wizard){
        wizardDao.save(wizard);
    }

    public void update(Integer id, Wizard wizard) {
        wizard.setId(id);
        wizardDao.save(wizard);
    }

    public void deleteById(Integer id) {
        wizardDao.deleteById(id);
    }
}
