import java.util.ArrayList;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

public class Quadrilateres extends Forme{
    private PointPlan pos1;
    private PointPlan pos2;
    private PointPlan pos3;
    private PointPlan pos4;

    public Quadrilateres() {
        super();
    }

    public Quadrilateres(PointPlan p1, PointPlan p2) throws ColineaireException {
        if ( MethodeTest.areColineaires(p1, p2)) {
            throw new ColineaireException("Les points sont colinéaires, impossible de former un quadrilatère !");
        }
        this.pos1 = p1;
        this.pos2 = p2;
        this.pos3 = new PointPlan(pos2.getAbscisse(), pos1.getOrdonnee());
        this.pos4 = new PointPlan(pos1.getAbscisse(), pos2.getOrdonnee());
        this.setNomForme("Quadrilatères");
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

    public PointPlan getpos4() {
        return this.pos4;
    }

    public void setpos1(PointPlan p) {
        this.pos1 = p;
    }

    public void setpos2(PointPlan p) {
        this.pos2 = p;
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

        this.dessiner();
    }

    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segments = new ArrayList<Segment>();
            Segment s1 = new Segment(pos1, pos3);
            Segment s2 = new Segment(pos2, pos4);
            Segment s3 = new Segment(pos2, pos3);
            Segment s4 = new Segment(pos1, pos4);

            segments.add(s1);
            segments.add(s2);
            segments.add(s3);
            segments.add(s4);
            return segments;
    }
    @Override
    public String typeForme() {
        return "Q";
    }

    public String toString() {
        return "[pos1" + this.getpos1() + ", pos2" + this.getpos2() + ", pos3" + this.getpos3() + ", pos4" + this.getpos4() +"]";
    }
}