/**
* Comment intgrer la librairie ardoise.jar dans votre projet Eclipse
 *
 * 1/ Crer un dossier libs dans votre projet Eclipse
 * Clic droit sur votre projet -> New -> Folder
 *
 * 2/ Copier ardoise.jar dans le dossier libs
 *
 * 3/ Déclarer ardoise.jar comme librairie externe pour votre projet
 * Clic droit sur ardoise.jar (dossier libs) -> Build Path -> Add to Build Path
 */



 /**
 * Importation des classes
 * PointPlan
 * Segment
 * Ardoise0 *
 * qui sont fournis dans la librairie ardoise.jar
 */

import ardoise.*;

/**
 * Classe TestProject
 * @author Akirthan
 * @groupe Zeus
 * @version 1.0
 *
 * Validation de l’ intgration de la librairie ardoise.jar au projet Java sur Eclipse et test de toute les classes du projet
 */

public class TestProject {

    public static void main(String []args ) throws ColineaireException{
        
        Ardoise ardoise = new Ardoise();

        /* Création du toit de la maison via la classe Triangles */
        PointPlan toit1 = new PointPlan(80, 140);
        PointPlan toit2 = new PointPlan(130, 100);
        PointPlan toit3 = new PointPlan(180, 140);

        Triangles toitmaison = new Triangles(toit1, toit2, toit3);

        /* Création de la tour, du corps et de la porte de la maison via la classe Quadrilateres*/
        PointPlan corps1 = new PointPlan(80, 140);
        PointPlan corps2 = new PointPlan(180, 198);

        PointPlan tour1 = new PointPlan(9, 100);
        PointPlan tour2= new PointPlan(20, 198);

        PointPlan porte1 = new PointPlan(120, 170);
        PointPlan porte2 = new PointPlan(140, 198);

        Quadrilateres corpsmaison = new Quadrilateres(corps1, corps2);
        Quadrilateres tour = new Quadrilateres(tour1, tour2);
        Quadrilateres portemaison = new Quadrilateres(porte1, porte2);

        ardoise.ajouterForme(tour);

        /* Première méthode : Ajout de la maison via la classe Maison */
        Maisons m = new Maisons(toitmaison, corpsmaison, portemaison);
        ardoise.ajouterForme(m);

        /* Deuxième méthode : Ajout de la maison via les classes Triangles et Quadrilatères

        ardoise.ajouterForme(corpsmaison);
        ardoise.ajouterForme(portemaison);
        ardoise.ajouterForme(toitmaison);

        */

        /* Ajout des 3 oiseaux via la classe Chapeaux*/
        PointPlan pos1oiseau1 = new PointPlan(118, 13);
        PointPlan pos2oiseau1 = new PointPlan(123, 20);
        PointPlan pos3oiseau1 = new PointPlan(128, 13);

        PointPlan pos1oiseau2 = new PointPlan(133, 30);
        PointPlan pos2oiseau2 = new PointPlan(136, 32);
        PointPlan pos3oiseau2 = new PointPlan(138, 30);

        PointPlan pos1oiseau3 = new PointPlan(142, 14);
        PointPlan pos2oiseau3 = new PointPlan(144, 17);
        PointPlan pos3oiseau3 = new PointPlan(146, 14);

        Chapeaux oiseau1 = new Chapeaux(pos1oiseau1, pos2oiseau1, pos3oiseau1);
        Chapeaux oiseau2 = new Chapeaux(pos1oiseau2, pos2oiseau2, pos3oiseau2);
        Chapeaux oiseau3 = new Chapeaux(pos1oiseau3, pos2oiseau3, pos3oiseau3);

        ardoise.ajouterForme(oiseau1);
        ardoise.ajouterForme(oiseau2);
        ardoise.ajouterForme(oiseau3);
        oiseau1.deplacer(10, 20);

        /* Ajout des 2 Montages via la classe Triangles */
        PointPlan pos1montagne1 = new PointPlan(3, 14);
        PointPlan pos2montagne1 = new PointPlan(43, 3);
        PointPlan pos3montagne1 = new PointPlan(112, 14);

        PointPlan pos1montagne2 = new PointPlan(152, 7);
        PointPlan pos2montagne2 = new PointPlan(166, 3);
        PointPlan pos3montagne2 = new PointPlan(172, 7);

        Triangles montagne1 = new Triangles(pos1montagne1, pos2montagne1, pos3montagne1);
        Triangles montagne2 = new Triangles(pos1montagne2, pos2montagne2, pos3montagne2);

        ardoise.ajouterForme(montagne1);
        ardoise.ajouterForme(montagne2);

        /* Ajout de l'étoile via la classe Etoile */
        PointPlan pos1branche1 = new PointPlan(170, 52);
        PointPlan pos2branche1 = new PointPlan(173, 45);
        PointPlan pos3branche1 = new PointPlan(177, 52);

        PointPlan pos2branche2 = new PointPlan(184, 57);
        PointPlan pos3branche2 = new PointPlan(177, 60);

        PointPlan pos2branche3 = new PointPlan(174, 66);
        PointPlan pos3branche3 = new PointPlan(170, 60);

        PointPlan pos2branche4 = new PointPlan(164, 57);
        PointPlan pos3branche4 = new PointPlan(170, 52);

        Chapeaux branche1 = new Chapeaux(pos1branche1, pos2branche1, pos3branche1);
        Chapeaux branche2 = new Chapeaux(pos3branche1, pos2branche2, pos3branche2);
        Chapeaux branche3 = new Chapeaux(pos3branche2, pos2branche3, pos3branche3);
        Chapeaux branche4 = new Chapeaux(pos3branche3, pos2branche4, pos3branche4);

        Etoiles e = new Etoiles(branche1, branche2, branche3, branche4);

        ardoise.ajouterForme(e);
        System.out.println(e);

        /* Affichage de l'ardoise */
        ardoise.dessinerGraphique();

        }
 }