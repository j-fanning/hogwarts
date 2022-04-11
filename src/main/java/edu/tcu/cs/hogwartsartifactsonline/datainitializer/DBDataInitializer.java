package edu.tcu.cs.hogwartsartifactsonline.datainitializer;

import edu.tcu.cs.hogwartsartifactsonline.dao.ArtifactDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.Artifact;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private ArtifactDao artifactDao;

    public DBDataInitializer(ArtifactDao artifactDao) {
        this.artifactDao = artifactDao;
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

        artifactDao.save(a1);
        artifactDao.save(a2);
        artifactDao.save(a3);
        artifactDao.save(a4);
        artifactDao.save(a5);
        artifactDao.save(a6);

    }
}
