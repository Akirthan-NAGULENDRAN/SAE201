import java.util.ArrayList;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

public class Chapeaux extends Forme{
    private PointPlan pos1;
    private PointPlan pos2;
    private PointPlan pos3;

    public Chapeaux() {
        super();
    }

    public Chapeaux(PointPlan p1, PointPlan p2, PointPlan p3) throws ColineaireException {
        if (MethodeTest.areColineaires(p1, p2, p3)) {
            throw new ColineaireException("Les points sont colinéaires, impossible de construire un chapeau !");
        }
        this.pos1 = p1;
        this.pos2 = p2;
        this.pos3 = p3;
        this.setNomForme("Chapeaux");
    }

    public PointPlan getpos1() {
        return this.pos1;
    }

    public PointPlan getpos2() {
        return this.pos2;
    }

    public PointPlan getpos3() {
        return this.pos3;
    }

    public void setpos1(PointPlan p) {
        this.pos1 = p;
    }

    public void setpos2(PointPlan p) {
        this.pos2 = p;
    }

    public void setpos3(PointPlan p) {
        this.pos3 = p;
    }

    @Override
    public void deplacer(int x, int y) {
        int depx1 = this.pos1.getAbscisse() + x;
        int depy1 = this.pos1.getOrdonnee() + y;
        this.pos1.setAbscisse(depx1);
        this.pos1.setOrdonnee(depy1);

        int depx2 = this.pos2.getAbscisse() + x;
        int depy2 = this.pos2.getOrdonnee() + y;
        this.pos2.setAbscisse(depx2);
        this.pos2.setOrdonnee(depy2);

        int depx3 = this.pos3.getAbscisse() + x;
        int depy3 = this.pos3.getOrdonnee() + y;
        this.pos3.setAbscisse(depx3);
        this.pos3.setOrdonnee(depy3);

        this.dessiner();
    }

    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segments = new ArrayList<Segment>();
        Segment s1 = new Segment(pos1, pos2);
        Segment s2 = new Segment(pos2, pos3);
        segments.add(s1);
        segments.add(s2);
        return segments;
    }

    @Override
    public String typeForme() {
        return "C";
    }

    public String toString() {
        return "[pos1" + this.getpos1() + ", pos2" + this.getpos2() + ", pos3" + this.getpos3() + "]";
    }  
}
