package edu.tcu.cs.hogwartsartifactsonline.service;

import edu.tcu.cs.hogwartsartifactsonline.dao.ArtifactDao;
import edu.tcu.cs.hogwartsartifactsonline.dao.WizardDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.Artifact;
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
    private ArtifactDao artifactDao;

    public WizardService(WizardDao wizardDao, ArtifactDao artifactDao) {
        this.wizardDao = wizardDao;
        this.artifactDao = artifactDao;
    }

    public List<Wizard> findAll(){
        return wizardDao.findAll();
    }

    public Wizard findById(Integer id) {
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

    public void assignArtifact(Integer wizardId, String artifactId) {
        //find the artifact by id from DB
        Artifact artifactToBeAssigned = artifactDao.findById(artifactId).get();
        Wizard wizard = wizardDao.findById(wizardId).get();

        if(artifactToBeAssigned.getOwner() != null){
            artifactToBeAssigned.getOwner().removeArtifact(artifactToBeAssigned);
        }
        wizard.addArtifact(artifactToBeAssigned);
    }
}
