package fr.licinfo.formula;
public class Minimum implements Formula {

	private Variable tabVar[];

	
	public Variable[] getTabVar() {
		return tabVar;
	}

	public void setTabVar(Variable[] tabVar) {
		this.tabVar = tabVar;
	}

	public String asString() {
		// TODO Auto-generated method stub
		return "min="+this.asValue() ;
	}

	public double asValue() {
		// TODO Auto-generated method stub
		Variable min = tabVar[0];
		
		for(int i=0;i<this.tabVar.length;i++) {
			if (tabVar[i].asValue()<min.asValue()) {min = tabVar[i];}
			
		}
		return min.asValue();
	}
	
	
	
	
}
