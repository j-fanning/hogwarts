package edu.tcu.cs.hogwartsartifactsonline.datainitializer;

import edu.tcu.cs.hogwartsartifactsonline.dao.ArtifactDao;
import edu.tcu.cs.hogwartsartifactsonline.dao.UserDao;
import edu.tcu.cs.hogwartsartifactsonline.dao.WizardDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.Artifact;
import edu.tcu.cs.hogwartsartifactsonline.domain.User;
import edu.tcu.cs.hogwartsartifactsonline.domain.Wizard;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private ArtifactDao artifactDao;
    private WizardDao wizardDao;
    private UserDao userDao;

    public DBDataInitializer(ArtifactDao artifactDao, WizardDao wizardDao, UserDao userDao) {
        this.artifactDao = artifactDao;
        this.wizardDao = wizardDao;
        this.userDao = userDao;
    }

    @Override
    public void run(String... args) throws Exception {
        Artifact a1 = new Artifact();
        a1.setId("1250808601736515584");
        a1.setName("Deluminator");
        a1.setDescription("A Deluminator is a device invented by Albus Dumbledore that resembles... ");
        a1.setImageUrl("imageUrl");

        Artifact a2 = new Artifact();
        a2.setId("2222222222222222222");
        a2.setName("Invisibility Cloak");
        a2.setDescription("An invisibility cloak is used to make the wearer invisible.");
        a2.setImageUrl("imageUrl");

        Artifact a3 = new Artifact();
        a3.setId("3333333333333333333");
        a3.setName("Elder Wand");
        a3.setDescription("The Elder Wand, known throughout history as the Deathstick or... ");
        a3.setImageUrl("imageUrl");

        Artifact a4 = new Artifact();
        a4.setId("4444444444444444444");
        a4.setName("The Marauder's Map");
        a4.setDescription("A magical map of Hogwarts creaed by Remus Lupin, Peter Pettigre... ");
        a4.setImageUrl("imageUrl");

        Artifact a5 = new Artifact();
        a5.setId("5555555555555555555");
        a5.setName("The Sword Of Gryffindor");
        a5.setDescription("A goblin-made sword adorned with large rubies on the pommel. It... ");
        a5.setImageUrl("imageUrl");

        Artifact a6 = new Artifact();
        a6.setId("6666666666666666666");
        a6.setName("Resurrection Stone");
        a6.setDescription("The Resurrection Stone allows the holder to bring back deceased...  ");
        a6.setImageUrl("imageUrl");

        Wizard w1 = new Wizard();
        w1.setName("James the Wizard");
        w1.addArtifact(a1);
        w1.addArtifact(a2);

        Wizard w2 = new Wizard();
        w2.setName("Noelle the Witch");
        w2.addArtifact(a3);
        w2.addArtifact(a4);

        Wizard w3 = new Wizard();
        w3.setName("Ryan the Wizard");
        w3.addArtifact(a5);
        //w3.addArtifact(a6);

        wizardDao.save(w1);
        wizardDao.save(w2);
        wizardDao.save(w3);
        //since it isnt added to a wizard, save by itself
        artifactDao.save(a6);

        User u1 = new User();
        u1.setUsername("James");
        u1.setPassword("123456");
        u1.setEnabled(true);
        u1.setRoles("admin");

        User u2 = new User();
        u2.setUsername("Noe");
        u2.setPassword("654321");
        u2.setEnabled(true);
        u2.setRoles("user");

        User u3 = new User();
        u3.setUsername("Ryan");
        u3.setPassword("000000");
        u3.setEnabled(false);
        u3.setRoles("user");

        userDao.save(u1);
        userDao.save(u2);
        userDao.save(u3);
    }
}
