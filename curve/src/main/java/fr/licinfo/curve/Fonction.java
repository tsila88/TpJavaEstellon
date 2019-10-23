package fr.licinfo.curve;

import fr.licinfo.formula.Formula;
import fr.licinfo.formula.Variable;

public class Fonction {

	private Formula formula;
	private Variable var;

	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}

	public Variable getVar() {
		return var;
	}

	public void setVar(Variable var) {
		this.var = var;
	}

	public Fonction(Formula formula, Variable var) {

		this.formula = formula;
		this.var = var;
	}
}
