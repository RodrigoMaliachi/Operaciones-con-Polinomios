package Modelo;
import org.scilab.forge.jlatexmath.ParseException;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class visualizarLatex {

    private TeXFormula formula;
    private TeXIcon icon;
    private String math;

    public visualizarLatex(String math){
        this.math = math;
    }

    public TeXIcon getIconLaTex(){
        try {
            formula = new TeXFormula(this.math);
            this.icon = this.formula.createTeXIcon(TeXConstants.ALIGN_CENTER, 40);
            return this.icon;
        } catch (ParseException e) {
            System.err.println("Error: "+ e.getMessage());
            return this.icon = null;
        }
    }
}
